package androidx.camera.core.imagecapture;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.internal.compat.workaround.InvalidJpegDataParser;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class JpegBytes2Disk implements Operation<In, ImageCapture.OutputFileResults> {
    private static final int COPY_BUFFER_SIZE = 1024;
    private static final int NOT_PENDING = 0;
    private static final int PENDING = 1;
    private static final String TEMP_FILE_PREFIX = "CameraX";
    private static final String TEMP_FILE_SUFFIX = ".tmp";

    public static abstract class In {
        public In() {
        }

        public abstract ImageCapture.OutputFileOptions getOutputFileOptions();

        public abstract Packet<byte[]> getPacket();

        public static In of(Packet<byte[]> r1, ImageCapture.OutputFileOptions r2) {
            return new AutoValue_JpegBytes2Disk_In(r1, r2);
        }
    }

    public JpegBytes2Disk() {
    }

    private static File createTempFile(ImageCapture.OutputFileOptions r4) throws ImageCaptureException {
        File r5 = r4.getFile();     // Catch: IOException -> L9
        if (r5 == null) goto L8;
        return new File(r5.getParent(), TEMP_FILE_PREFIX + UUID.randomUUID().toString() + getFileExtensionWithDot(r5));
    L8:
        return File.createTempFile(TEMP_FILE_PREFIX, TEMP_FILE_SUFFIX);
    L9:
        e = move-exception;
        throw new ImageCaptureException(1, "Failed to create temp file.", e);
    }

    private static String getFileExtensionWithDot(File r1) {
        String r2 = r1.getName();
        int r0 = r2.lastIndexOf(46);
        if (r0 >= 0) goto L5;
        return "";
    L5:
        return r2.substring(r0);
    }

    private static boolean isSaveToFile(ImageCapture.OutputFileOptions r0) {
        if (r0.getFile() == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isSaveToMediaStore(ImageCapture.OutputFileOptions r1) {
        if (r1.getSaveCollection() != null) goto L5;
    L9:
        return false;
    L5:
        if (r1.getContentResolver() == null) goto L9;
        if (r1.getContentValues() == null) goto L9;
        return true;
    }

    private static boolean isSaveToOutputStream(ImageCapture.OutputFileOptions r0) {
        if (r0.getOutputStream() == null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public ImageCapture.OutputFileResults apply2(In r5) throws ImageCaptureException {
        Packet<byte[]> r0 = r5.getPacket();
        ImageCapture.OutputFileOptions r6 = r5.getOutputFileOptions();
        File r1 = createTempFile(r6);
        writeBytesToFile(r1, r0.getData());
        Exif r2 = r0.getExif();
        Objects.requireNonNull(r2);
        updateFileExif(r1, r2, r6, r0.getRotationDegrees());
        return new ImageCapture.OutputFileResults(moveFileToTarget(r1, r6));
    }

    @Override // androidx.camera.core.processing.Operation
    public /* bridge */ /* synthetic */ ImageCapture.OutputFileResults apply(In r1) throws ImageCaptureException {
        return apply2(r1);
    }

    private static Uri copyFileToFile(File r2, File r3) throws ImageCaptureException {
        if (r3.exists() == false) goto L6;
        r3.delete();
    L6:
        if (r2.renameTo(r3) == false) goto L10;
        return Uri.fromFile(r3);
    L10:
        throw new ImageCaptureException(1, "Failed to overwrite the file: " + r3.getAbsolutePath(), null);
    }

    private static Uri copyFileToMediaStore(File r6, ImageCapture.OutputFileOptions r7) throws ImageCaptureException {
        ContentResolver r1 = r7.getContentResolver();
        Objects.requireNonNull(r1);
        if (r7.getContentValues() == null) goto L5;
        ContentValues r2 = new ContentValues(r7.getContentValues());
    L6:
        setContentValuePendingFlag(r2, 1);
        Uri r5 = null;
        Uri r8 = androidx_camera_core_imagecapture_JpegBytes2Disk_android_content_ContentResolver_insert(r1, r7.getSaveCollection(), r2);     // Catch: Throwable -> L20 SecurityException -> L22 IOException -> L24
    L32:
        if (r8 == null) goto L19;
        copyTempFileToUri(r6, r8, r1);     // Catch: Throwable -> L12 SecurityException -> L14 IOException -> L16
        updateUriPendingStatus(r8, r1, 0);
        return r8;
    L19:
        throw new ImageCaptureException(1, "Failed to insert a MediaStore URI.", null);     // Catch: Throwable -> L12 SecurityException -> L14 IOException -> L16
    L16:
        e = e;
    L17:
        r5 = r8;
    L26:
        throw new ImageCaptureException(1, "Failed to write to MediaStore URI: " + r5, e);     // Catch: Throwable -> L20
    L14:
        e = e;
    L12:
        th = th;
        r5 = r8;
    L27:
        if (r5 == null) goto L29;
        updateUriPendingStatus(r5, r1, 0);
    L29:
        throw th;
    L20:
        th = th;
    L24:
        e = e;
    L22:
        e = e;
        goto L26
    L5:
        r2 = new ContentValues();
        goto L6
    }

    private static void copyFileToOutputStream(File r3, OutputStream r4) throws IOException {
        FileInputStream r0 = new FileInputStream(r3);
        byte[] r5 = new byte[COPY_BUFFER_SIZE];     // Catch: Throwable -> L10
    L4:
        int r1 = r0.read(r5);     // Catch: Throwable -> L10
        if (r1 <= 0) goto L8;
        r4.write(r5, 0, r1);     // Catch: Throwable -> L10
        goto L4
    L8:
        r0.close();
        return;
    L10:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L13
    L15:
        throw th;
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    public static Uri moveFileToTarget(File r3, ImageCapture.OutputFileOptions r4) throws ImageCaptureException {
        Uri r0 = null;
        if (isSaveToMediaStore(r4) == false) goto L7;
        r0 = copyFileToMediaStore(r3, r4);     // Catch: Throwable -> L14 IOException -> L16
    L12:
        r3.delete();
        return r0;
    L7:
        if (isSaveToOutputStream(r4) == false) goto L10;
        OutputStream r5 = r4.getOutputStream();     // Catch: Throwable -> L14 IOException -> L16
        Objects.requireNonNull(r5);     // Catch: Throwable -> L14 IOException -> L16
        OutputStream r1 = r5;     // Catch: Throwable -> L14 IOException -> L16
        copyFileToOutputStream(r3, r5);     // Catch: Throwable -> L14 IOException -> L16
        goto L12
    L10:
        if (isSaveToFile(r4) == false) goto L12;
        File r6 = r4.getFile();     // Catch: Throwable -> L14 IOException -> L16
        Objects.requireNonNull(r6);     // Catch: Throwable -> L14 IOException -> L16
        File r2 = r6;     // Catch: Throwable -> L14 IOException -> L16
        r0 = copyFileToFile(r3, r6);     // Catch: Throwable -> L14 IOException -> L16
        goto L12
    L17:
        throw new ImageCaptureException(1, "Failed to write to OutputStream.", null);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r3.delete();
        throw th;
    }

    private static void setContentValuePendingFlag(ContentValues r2, int r3) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        r2.put("is_pending", Integer.valueOf(r3));
        return;
    }

    private static void writeBytesToFile(File r2, byte[] r3) throws ImageCaptureException {
        FileOutputStream r0 = new FileOutputStream(r2);     // Catch: IOException -> L12
        r0.write(r3, 0, new InvalidJpegDataParser().getValidDataLength(r3));     // Catch: Throwable -> L6
        r0.close();     // Catch: IOException -> L12
        return;
    L6:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L9
    L11:
        throw th;     // Catch: IOException -> L12
    L9:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L12
    L12:
        e = move-exception;
        throw new ImageCaptureException(1, "Failed to write to temp file", e);
    }

    private static Uri androidx_camera_core_imagecapture_JpegBytes2Disk_android_content_ContentResolver_insert(ContentResolver r18, Uri r19, ContentValues r20) throws ImageCaptureException {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19, r20};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240017);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(240017, "android/content/ContentResolver", "insert", r18, r1, "android.net.Uri", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (Uri) r4.b;
    L21:
        return r18.insert(r19, r20);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    private static void copyTempFileToUri(File r1, Uri r2, ContentResolver r3) throws IOException {
        OutputStream r4 = r3.openOutputStream(r2);
        if (r4 == null) goto L10;
        copyFileToOutputStream(r1, r4);     // Catch: Throwable -> L7
        r4.close();
        return;
    L10:
        throw new FileNotFoundException(r2 + " cannot be resolved.");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        if (r4 != null) goto L17;
    L16:
        throw th;
    L17:
        r4.close();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.addSuppressed(th);
        goto L16
    }

    private static void updateUriPendingStatus(Uri r2, ContentResolver r3, int r4) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        ContentValues r0 = new ContentValues();
        setContentValuePendingFlag(r0, r4);
        androidx_camera_core_imagecapture_JpegBytes2Disk_android_content_ContentResolver_update(r3, r2, r0, null, null);
        return;
    }

    private static void updateFileExif(File r0, Exif r1, ImageCapture.OutputFileOptions r2, int r3) throws ImageCaptureException {
        Exif r4 = Exif.createFromFile(r0);     // Catch: IOException -> L17
        r1.copyToCroppedImage(r4);     // Catch: IOException -> L17
        if (r4.getRotation() != 0) goto L6;
        if (r3 == 0) goto L6;
        r4.rotate(r3);     // Catch: IOException -> L17
    L6:
        ImageCapture.Metadata r5 = r2.getMetadata();     // Catch: IOException -> L17
        if (r5.isReversedHorizontal() == false) goto L10;
        r4.flipHorizontally();     // Catch: IOException -> L17
    L10:
        if (r5.isReversedVertical() == false) goto L13;
        r4.flipVertically();     // Catch: IOException -> L17
    L13:
        if (r5.getLocation() == null) goto L15;
        r4.attachLocation(r5.getLocation());     // Catch: IOException -> L17
    L15:
        r4.save();     // Catch: IOException -> L17
        return;
    L17:
        e = move-exception;
        throw new ImageCaptureException(1, "Failed to update Exif data", e);
    }

    private static int androidx_camera_core_imagecapture_JpegBytes2Disk_android_content_ContentResolver_update(ContentResolver r18, Uri r19, ContentValues r20, String r21, String[] r22) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19, r20, r21, r22};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240018);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(240018, "android/content/ContentResolver", "update", r18, r1, "int", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return ((Integer) r4.b).intValue();
    L21:
        return r18.update(r19, r20, r21, r22);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }
}
