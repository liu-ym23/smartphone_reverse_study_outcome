package com.obric.sva.sdk.utils;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.sva.sdk.controller.BreathUtils;
import com.obric.sva.sdk.controller.Global;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007J0\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u0012\u0010\u0017\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0007J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0007J\u0018\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0005H\u0007J\u0018\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0005H\u0007J \u0010$\u001a\u00020\t2\u0006\u0010\n\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005H\u0007J \u0010'\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005H\u0007J\u0010\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020*H\u0007J \u0010+\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020*2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0015H\u0007J\u0018\u0010.\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020*2\u0006\u0010/\u001a\u00020*H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/obric/sva/sdk/utils/FileKt;", "", "<init>", "()V", "TAG", "", "WAV_HEADER_LENGTH", "", "saveByteToFile", "", "buffer", "", "bufferSize", "filePath", "pcm", "", "writeBufferToWavFile", "inBuff", "isAppendToFile", "getWavHeader", "audioDataLength", "", "audioDataAndHeaderLength", "readWavFileToByte", "readBinaryFile", "fileName", "readWavFile", "Ljava/nio/ShortBuffer;", "isSameMD5", "source", "Ljava/io/InputStream;", PickerReporterConstants.KEY.TARGET, "recordBreathToWaveFromStream", "outputStream", "Ljava/io/ByteArrayOutputStream;", "sessionId", "saveIntToFile", "", "size", "saveStereoToFile", "deleteContents", MapBundleKey.MapObjKey.OBJ_DIR, "Ljava/io/File;", "deleteOlderFiles", "minCount", "minAgeMs", "copyFile", com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileKt {
    public static final FileKt INSTANCE = null;
    private static final String TAG = null;
    public static final int WAV_HEADER_LENGTH = 44;

    private FileKt() {
    }

    public static /* synthetic */ int a(File r100, File r101) {
        return deleteOlderFiles$lambda$5(r100, r101);
    }

    public static /* synthetic */ int b(Function2 r100, Object r101, Object r102) {
        return deleteOlderFiles$lambda$6(r100, r101, r102);
    }

    @JvmStatic
    public static final byte[] getWavHeader(long r110, long r111) {
        return new byte[]{82, 73, 70, 70, (byte) (r111 & 255), (byte) ((r111 >> 8) & 255), (byte) ((r111 >> 16) & 255), (byte) ((r111 >> 24) & 255), 87, 65, 86, 69, 102, 109, 116, 32, 16, 0, 0, 0, 1, 0, 1, 0, (byte) 128, (byte) 62, (byte) 0, (byte) 0, (byte) 0, (byte) 125, (byte) 0, (byte) 0, 2, 0, 16, 0, 100, 97, 116, 97, (byte) (r110 & 255), (byte) ((r110 >> 8) & 255), (byte) ((r110 >> 16) & 255), (byte) ((r110 >> 24) & 255)};
    }

    static {
        INSTANCE = new FileKt();
        TAG = "FileKt";
    }

    @JvmStatic
    public static final boolean deleteContents(File r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_DIR);
        File[] r101 = r100.listFiles();
        boolean r102 = true;
        if (r101 == null) goto L13;
        Iterator r103 = ArrayIteratorKt.iterator(r101);
    L6:
        if (r103.hasNext() == false) goto L13;
        File r104 = (File) r103.next();
        if (r104.isDirectory() == false) goto L11;
        Intrinsics.checkNotNull(r104);
        r102 = r102 & deleteContents(r104);
    L11:
        if (r104.delete() == true) goto L6;
        LogUtils.v(TAG, "Failed to delete " + r104, new Object[0]);
        r102 = false;
    L13:
        return r102;
    }

    @JvmStatic
    public static final byte[] readBinaryFile(String r100) {
        byte[] r101 = null;
        BufferedInputStream r102 = new BufferedInputStream(new PolarisFileInputStreamWrapper(r100));     // Catch: IOException -> L8
        r101 = new byte[r102.available()];     // Catch: IOException -> L8
        byte[] r103 = new byte[1024];     // Catch: IOException -> L8
        int r104 = 0;
    L4:
        int r105 = r102.read(r103);     // Catch: IOException -> L8
        if (r105 == (-1)) goto L10;
        System.arraycopy(r103, 0, r101, r104, r105);     // Catch: IOException -> L8
        r104 = r104 + r105;
    L10:
        return r101;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    @JvmStatic
    public static final ShortBuffer readWavFile(String r100) throws IOException {
        int r101 = 0;
        if (r100 == null) goto L5;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == false) goto L29;
        RandomAccessFile r103 = new RandomAccessFile(r102, "r");
        r103.skipBytes(44);     // Catch: Throwable -> L23
        long r104 = r103.length();     // Catch: Throwable -> L23
        if (((int) r104) != r104) goto L22;
        int r105 = (((int) (r104 - ((long) 44))) + 1) / 2;     // Catch: Throwable -> L23
        short[] r106 = new short[r105];     // Catch: Throwable -> L23
    L12:
        if (r101 >= r105) goto L18;
        if (Intrinsics.areEqual(ByteOrder.LITTLE_ENDIAN, ByteOrder.nativeOrder()) == false) goto L16;
        short r107 = r103.readShort();     // Catch: Throwable -> L23
        short r108 = (short) ((r107 & 255) << 8);     // Catch: Throwable -> L23
        r106[r101] = r108;     // Catch: Throwable -> L23
        r106[r101] = (short) (r108 + ((r107 & 65280) >> 8));     // Catch: Throwable -> L23
    L17:
        r101 = r101 + 1;     // Catch: Throwable -> L23
        goto L12
    L16:
        r106[r101] = r103.readShort();     // Catch: Throwable -> L23
        goto L17
    L18:
        ShortBuffer r109 = ShortBuffer.allocate(r105);     // Catch: Throwable -> L23
        r109.put(r106);     // Catch: Throwable -> L23
        Intrinsics.checkNotNull(r109);     // Catch: Throwable -> L23
        CloseableKt.closeFinally(r103, null);
        return r109;
    L22:
        throw new IOException("File size >= 2 GB");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);
        throw th;
    L29:
        throw new FileNotFoundException();
    L5:
        return ShortBuffer.allocate(0);
    }

    @JvmStatic
    public static final byte[] readWavFileToByte(String r100) throws IOException {
        RandomAccessFile r101 = new RandomAccessFile(new PolarisFileWrapper(r100), "r");
        r101.skipBytes(44);     // Catch: Throwable -> L10
        long r102 = r101.length();     // Catch: Throwable -> L10
        if (((int) r102) != r102) goto L9;
        byte[] r103 = new byte[(int) (r102 - ((long) 44))];     // Catch: Throwable -> L10
        r101.read(r103);     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r101, null);
        return r103;
    L9:
        throw new IOException("File size >= 2 GB");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r101, th);
        throw th;
    }

    @JvmStatic
    public static final void copyFile(File r100, File r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        if (r100.exists() == true) goto L6;
        return;
    L6:
        if (r100.isDirectory() == false) goto L9;
        return;
    L9:
        if (r101.exists() == false) goto L11;
        r101.delete();
    L11:
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);
        PolarisFileOutputStreamWrapper r103 = new PolarisFileOutputStreamWrapper(r101);     // Catch: Throwable -> L28
        byte[] r104 = new byte[1024];     // Catch: Throwable -> L23
    L15:
        int r105 = r102.read(r104);     // Catch: Throwable -> L23
        if (r105 <= 0) goto L18;
        r103.write(r104, 0, r105);     // Catch: Throwable -> L23
        goto L15
    L18:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L23
    L20:
        CloseableKt.closeFinally(r103, null);     // Catch: Throwable -> L28
        CloseableKt.closeFinally(r102, null);
        return;
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);     // Catch: Throwable -> L28
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);
        throw th;
    }

    private static final int deleteOlderFiles$lambda$5(File r100, File r101) {
        return Long.compare(r101.lastModified(), r100.lastModified());
    }

    @JvmStatic
    public static final boolean isSameMD5(InputStream r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        if (new PolarisFileWrapper(r101).exists() == false) goto L6;
        String r102 = KtUtils.md5(r100);
        String r103 = KtUtils.md5(r101);
        LogUtils.d(TAG, "isSameMD5 : source " + r100 + " [" + r102 + "] vs target " + r101 + " [" + r103 + ']', new Object[0]);
        return StringsKt.equals(r102, r103, true);
    L6:
        return false;
    }

    @JvmStatic
    public static final void recordBreathToWaveFromStream(ByteArrayOutputStream r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "outputStream");
        Intrinsics.checkNotNullParameter(r101, "sessionId");
        BreathUtils r102 = BreathUtils.INSTANCE;
        if (rna.c.c(r102.getBREATH_LOCAL_DIR()) == true) goto L6;
        rna.c.a(r102.getBREATH_LOCAL_DIR());
    L6:
        if (r100.size() <= 0) goto L21;
        String r103 = r102.getBREATH_LOCAL_DIR() + File.separator + KtUtils.INSTANCE.getNow() + '_' + r101 + Global.SUFFIX_WAV_FILE;
        if (r103 == null) goto L17;
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103);
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L12:
        if (r104.exists() == true) goto L17;
        r104.createNewFile();     // Catch: IOException -> L15
    L17:
        saveByteToFile$default(r100.toByteArray(), r100.size(), r103, false, 8, null);
        return;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.obric.sva.sdk.utils.a] */
    @JvmStatic
    public static final boolean deleteOlderFiles(File r100, int r110, long r111) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_DIR);
        if (r110 >= 0) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L22;
        File[] r102 = r100.listFiles();
        if (r102 != null) goto L12;
        return false;
    L12:
        final ?? r103 = new a();
        Arrays.sort(r102, new b(r103));
        int r104 = r102.length;
        boolean r105 = false;
    L13:
        if (r110 >= r104) goto L20;
        File r106 = r102[r110];
        if ((System.currentTimeMillis() - r106.lastModified()) <= r111) goto L19;
        if (r106.delete() == false) goto L19;
        LogUtils.v(TAG, "Deleted old file " + r106, new Object[0]);
        r105 = true;
    L19:
        r110 = r110 + 1;
        goto L13
    L20:
        return r105;
    L22:
        throw new IllegalArgumentException("Constraints must be positive or 0".toString());
    L5:
        if (r111 < 0) goto L7;
        r101 = true;
        goto L8
    }

    private static final int deleteOlderFiles$lambda$6(Function2 r100, Object r101, Object r102) {
        return ((Number) r100.invoke(r101, r102)).intValue();
    }

    @JvmStatic
    public static final void saveIntToFile(int[] r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "buffer");
        Intrinsics.checkNotNullParameter(r102, "filePath");
        boolean r103 = false;
        LogUtils.v(TAG, "saveIntToFile size " + r101 + " to path " + r102, new Object[0]);
        StringBuilder r104 = new StringBuilder();
        int r105 = r100.length;
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L6;
        r104.append(String.valueOf(r100[r106]));
        r104.append(",");
        r106 = r106 + 1;
        goto L3
    L6:
        if (r104.length() <= 0) goto L8;
        r103 = true;
    L8:
        if (r103 == false) goto L10;
        r104.setLength(r104.length() - 1);
    L10:
        byte[] r107 = r104.toString().getBytes(Charsets.UTF_8);
        INSTANCE.writeBufferToWavFile(r107, r107.length, r102, false, true);
    }

    @JvmStatic
    public static final void saveStereoToFile(byte[] r100, int r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "buffer");
        Intrinsics.checkNotNullParameter(r111, "filePath");
        LogUtils.v(TAG, "saveStereoToFile size " + r110 + " to path " + r111, new Object[0]);
        INSTANCE.writeBufferToWavFile(r100, r110, r111, false, true);
    }

    @JvmStatic
    public static final void saveByteToFile(byte[] r100, int r110, String r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "buffer");
        Intrinsics.checkNotNullParameter(r111, "filePath");
        LogUtils.v(TAG, "saveHotWordRecording filePath = " + r111 + " with bufferSize " + r110, new Object[0]);
        INSTANCE.writeBufferToWavFile(r100, r110, r111, false, r112);
    }

    private final void writeBufferToWavFile(byte[] r110, int r111, String r112, boolean r113, boolean r114) {
        DataOutputStream r100 = null;
        String r101 = TAG;     // Catch: Throwable -> L19 IOException -> L21 FileNotFoundException -> L27
        LogUtils.v(r101, "writeBufferToWavFile: stream created bufferSize " + r111 + " pcm ? " + r114, new Object[0]);     // Catch: Throwable -> L19 IOException -> L21 FileNotFoundException -> L27
        DataOutputStream r102 = new DataOutputStream(new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r112, r113)));     // Catch: Throwable -> L19 IOException -> L21 FileNotFoundException -> L27
    L48:
        if (r114 == false) goto L7;
        LogUtils.v(r101, "writeBufferToWavFile: write pcm " + r111 + " bytes", new Object[0]);     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
        r102.write(r110, 0, r111);     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
        LogUtils.v(r101, "writeBufferToWavFile: pcm complete", new Object[0]);     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
    L8:
        r102.flush();     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
        r102.close();     // Catch: IOException -> L11
        LogUtils.v(r101, "writeBufferToWavFile: stream close", new Object[0]);     // Catch: IOException -> L11
    L43:
        return;
    L7:
        byte[] r115 = getWavHeader(r111, r111 + 44);     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
        LogUtils.v(r101, "writeBufferToWavFile: write header", new Object[0]);     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
        r102.write(r115);     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
        LogUtils.v(r101, "writeBufferToWavFile: write " + r111 + " bytes", new Object[0]);     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
        r102.write(r110, 0, r111);     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
        LogUtils.v(r101, "writeBufferToWavFile: complete", new Object[0]);     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
    L17:
        e = e;
        r100 = r102;
    L28:
        String r116 = TAG;     // Catch: Throwable -> L19
        LogUtils.e(r116, "writeShortBufferToWavFile: FileNotFound: " + e.getMessage(), new Object[0]);     // Catch: Throwable -> L19
        if (r100 == null) goto L31;
        r100.close();     // Catch: IOException -> L11
    L31:
        LogUtils.v(r116, "writeBufferToWavFile: stream close", new Object[0]);     // Catch: IOException -> L11
    L15:
        e = e;
        r100 = r102;
    L22:
        e.printStackTrace();     // Catch: Throwable -> L19
        if (r100 == null) goto L25;
        r100.close();     // Catch: IOException -> L11
    L25:
        LogUtils.v(TAG, "writeBufferToWavFile: stream close", new Object[0]);     // Catch: IOException -> L11
    L13:
        th = th;
        r100 = r102;
    L33:
        if (r100 != null) goto L41;
    L37:
        LogUtils.v(TAG, "writeBufferToWavFile: stream close", new Object[0]);     // Catch: IOException -> L35
    L40:
        throw th;
    L35:
        e = move-exception;
        e.printStackTrace();
        goto L40
    L41:
        r100.close();     // Catch: IOException -> L35
    L19:
        th = th;
    L27:
        e = e;
    L21:
        e = e;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L43
    }

    public static /* synthetic */ void saveByteToFile$default(byte[] r100, int r101, String r102, boolean r103, int r104, Object r105) {
        if ((r104 & 8) == 0) goto L5;
        r103 = false;
    L5:
        saveByteToFile(r100, r101, r102, r103);
    }
}
