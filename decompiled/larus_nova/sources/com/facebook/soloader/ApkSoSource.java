package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipEntry;

/* JADX INFO: loaded from: classes23.dex */
public class ApkSoSource extends ExtractFromZipSoSource {
    private static final byte APK_SO_SOURCE_SIGNATURE_VERSION = 2;
    private static final byte LIBS_DIR_DOESNT_EXIST = 1;
    private static final byte LIBS_DIR_DONT_CARE = 0;
    private static final byte LIBS_DIR_SNAPSHOT = 2;
    public static final int PREFER_ANDROID_LIBS_DIRECTORY = 1;
    private static final String TAG = "ApkSoSource";
    private final int mFlags;

    public class ApkUnpacker extends ExtractFromZipSoSource.ZipUnpacker {
        private final int mFlags;
        private final File mLibDir;
        final /* synthetic */ ApkSoSource this$0;

        public ApkUnpacker(ApkSoSource r100, ExtractFromZipSoSource r101) throws IOException {
            this.this$0 = r100;
            super(r100, r101);
            this.mLibDir = new PolarisFileWrapper(r100.mContext.getApplicationInfo().nativeLibraryDir);
            this.mFlags = ApkSoSource.access$000(r100);
        }

        @Override // com.facebook.soloader.ExtractFromZipSoSource.ZipUnpacker
        public boolean shouldExtract(ZipEntry r100, String r110) {
            String r101 = r100.getName();
            if (r110.equals(this.this$0.mCorruptedLib) == false) goto L7;
            this.this$0.mCorruptedLib = null;
            String.format("allowing consideration of corrupted lib %s", new Object[]{r110});
        L5:
            return true;
        L7:
            if ((this.mFlags & 1) == 0) goto L5;
            PolarisFileWrapper r102 = new PolarisFileWrapper(this.mLibDir, r110);
        L15:
            e = move-exception;
            String.format("not allowing consideration of %s: %s, IOException when constructing path: %s", new Object[]{r101, r110, e.toString()});
        L17:
            boolean r103 = false;
        L18:
            if (r103 == true) goto L20;
            return false;
        L20:
            if (r102.isFile() == true) goto L22;
            String.format("allowing consideration of %s: %s not in system lib dir", new Object[]{r101, r110});
            goto L5
        L22:
            long r104 = r102.length();
            long r105 = r100.getSize();
            if (r104 == r105) goto L26;
            String.format("allowing consideration of %s: sysdir file length is %s, but the file is %s bytes long in the APK", new Object[]{r102, Long.valueOf(r104), Long.valueOf(r105)});
            goto L5
        L26:
            return false;
        L11:
            if (r102.getCanonicalPath().startsWith(this.mLibDir.getCanonicalPath()) == true) goto L14;
            String.format("not allowing consideration of %s: %s not in lib dir", new Object[]{r101, r110});     // Catch: IOException -> L15
            goto L17
        L14:
            r103 = true;
            goto L18
        }
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    public byte[] getDepsBlock() throws IOException {
        File r100 = this.mZipFileName.getCanonicalFile();
        Parcel r101 = Parcel.obtain();
        r101.writeByte((byte) 2);     // Catch: Throwable -> L21
        r101.writeString(r100.getPath());     // Catch: Throwable -> L21
        r101.writeLong(r100.lastModified());     // Catch: Throwable -> L21
        r101.writeInt(SysUtil.getAppVersionCode(this.mContext));     // Catch: Throwable -> L21
        if ((this.mFlags & 1) != 0) goto L8;
        r101.writeByte((byte) 0);     // Catch: Throwable -> L21
        byte[] r102 = r101.marshall();     // Catch: Throwable -> L21
        r101.recycle();
        return r102;
    L8:
        String r103 = this.mContext.getApplicationInfo().nativeLibraryDir;     // Catch: Throwable -> L21
        if (r103 != null) goto L13;
        r101.writeByte((byte) 1);     // Catch: Throwable -> L21
        byte[] r104 = r101.marshall();     // Catch: Throwable -> L21
        r101.recycle();
        return r104;
    L13:
        File r105 = new PolarisFileWrapper(r103).getCanonicalFile();     // Catch: Throwable -> L21
        if (r105.exists() == true) goto L18;
        r101.writeByte((byte) 1);     // Catch: Throwable -> L21
        byte[] r106 = r101.marshall();     // Catch: Throwable -> L21
        r101.recycle();
        return r106;
    L18:
        r101.writeByte((byte) 2);     // Catch: Throwable -> L21
        r101.writeString(r105.getPath());     // Catch: Throwable -> L21
        r101.writeLong(r105.lastModified());     // Catch: Throwable -> L21
        byte[] r107 = r101.marshall();     // Catch: Throwable -> L21
        r101.recycle();
        return r107;
    L21:
        th = move-exception;
        r101.recycle();
        throw th;
    }

    public static /* synthetic */ int access$000(ApkSoSource r100) {
        return r100.mFlags;
    }

    @Override // com.facebook.soloader.ExtractFromZipSoSource, com.facebook.soloader.UnpackingSoSource
    public UnpackingSoSource.Unpacker makeUnpacker(byte r100) throws IOException {
        return new ApkUnpacker(this, this);
    }

    public ApkSoSource(Context r100, String r101, int r102) {
        this(r100, new PolarisFileWrapper(r100.getApplicationInfo().sourceDir), r101, r102);
    }

    public ApkSoSource(Context r100, File r101, String r102, int r103) {
        super(r100, r102, r101, "^lib/([^/]+)/([^/]+\\.so)$");
        this.mFlags = r103;
    }
}
