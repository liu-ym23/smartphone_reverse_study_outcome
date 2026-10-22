package com.bytedance.dora.offline.file;

import android.app.Application;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.sva.sdk.controller.Global;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f204610a = null;

    /* JADX INFO: loaded from: classes15.dex */
    public static final class a implements AutoCloseable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f204611a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RandomAccessFile f204612b;

        @Override // java.lang.AutoCloseable
        public final void close() throws IOException {
            this.f204612b.close();
        }

        public a(PolarisFileWrapper r100) throws IOException {
            this.f204611a = r100;
            this.f204612b = new RandomAccessFile(r100, "rw");
        }
    }

    public d() {
    }

    static {
        f204610a = "0123456789abcdef".toCharArray();
    }

    public static PolarisFileWrapper a(String r100) {
        Application r101 = pk4.n.f529659c;
        if (r101 == null) goto L20;
        File r102 = r101.getFilesDir();
        if (r102 == null) goto L18;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102, "offline_file");
        if (r103.exists() == false) goto L9;
    L11:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103, ek4.a.b(r100));
        if (r104.exists() == false) goto L14;
    L16:
        return r104;
    L14:
        if (r104.mkdirs() == true) goto L16;
        pk4.j.f("OfflineFileStore", "Create offline file dir failed, directory=" + r104.getName());
        goto L16
    L9:
        if (r103.mkdirs() == true) goto L11;
        pk4.j.f("OfflineFileStore", "Create offline file root dir failed, directory=" + r103.getName());
        goto L11
    L18:
        throw new IllegalStateException("App files dir is null for offline file store");
    L20:
        throw new IllegalStateException("App context is null for offline file store");
    }

    public static boolean c(File r100) {
        if (r100.exists() == true) goto L17;
        return true;
    L17:
    L14:
        th = move-exception;
        pk4.j.c("OfflineFileStore", "Delete file exception, fileName=" + r100.getName(), th);
        return false;
    L7:
        if (r100.delete() == false) goto L9;
    L13:
        return true;
    L9:
        if (r100.exists() == false) goto L13;
        pk4.j.f("OfflineFileStore", "Delete file failed, fileName=" + r100.getName());     // Catch: Throwable -> L14
        return false;
    }

    public static byte[] e(PolarisFileWrapper r100) throws Exception {
        MessageDigest r101 = MessageDigest.getInstance("MD5");
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);
        byte[] r103 = new byte[8192];     // Catch: Throwable -> L10
    L4:
        int r104 = r102.read(r103);     // Catch: Throwable -> L10
        if (r104 <= 0) goto L8;
        r101.update(r103, 0, r104);     // Catch: Throwable -> L10
        goto L4
    L8:
        r102.close();
        return r101.digest();
    L10:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L13
    L15:
        throw th;
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    public static String f(String r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.length() == 0) goto L12;
        String r101 = r100.replaceAll("[^a-zA-Z0-9._-]", "_");
        if (r101.equals(r100) == true) goto L9;
        pk4.j.f("OfflineFileStore", "Normalize offline file key because it contains unsafe characters, keyLength=" + r100.length());
    L9:
        return r101;
    L12:
        return "";
    }

    public static String g(byte[] r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        StringBuilder r101 = new StringBuilder(r100.length * 2);
        int r102 = r100.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L9;
        int r104 = r100[r103] & UByte.MAX_VALUE;
        char[] r105 = f204610a;
        r101.append(r105[r104 >>> 4]);
        r101.append(r105[r104 & 15]);
        r103 = r103 + 1;
        goto L6
    L9:
        return r101.toString();
    }

    public static boolean b(String r100, String r110) {
        if (r110 != null) goto L5;
        return true;
    L5:
        if (r110.length() == 0) goto L39;
        String r111 = f(r110);
        if (r111.length() != 0) goto L10;
        return true;
    L10:
        PolarisFileWrapper r101 = a(r100);
        File[] r102 = r101.listFiles();
        if (r102 != null) goto L17;
        if (r101.exists() == false) goto L40;
        pk4.j.f("OfflineFileStore", "List offline file dir failed, directory=" + r101.getName() + ", fileKeyLength=" + r111.length());
        return false;
    L40:
        return true;
    L17:
        if (r102.length == 0) goto L41;
        String r103 = r111.concat(".");
        int r104 = r102.length;
        int r105 = 0;
        boolean r106 = true;
    L20:
        if (r105 >= r104) goto L32;
        File r107 = r102[r105];
        String r108 = r107.getName();
        if (r108.equals(r111) == true) goto L26;
        if (r108.startsWith(r103) == true) goto L26;
    L30:
        r105 = r105 + 1;
    L26:
        if (c(r107) == false) goto L29;
        if (r106 == false) goto L29;
        r106 = true;
    L29:
        r106 = false;
        goto L30
    L32:
        return r106;
    L41:
        return true;
    L39:
        return true;
    }

    public static PolarisFileWrapper d(String r100, b.d r101, String r102) {
        PolarisFileWrapper r103 = a(r100);
        if (r102 != null) goto L5;
    L20:
        String r104 = Global.SUFFIX_DATA_FILE;
    L21:
        String r105 = f(r101.a());
        PolarisFileWrapper r106 = new PolarisFileWrapper(r103, r105.concat(r104));
    L27:
        e = move-exception;
        pk4.j.c("OfflineFileStore", "Check offline file path failed, fileKeyLength=" + r105.length(), e);
    L30:
        return new PolarisFileWrapper(r103, r105.concat(Global.SUFFIX_DATA_FILE));
    L23:
        if (r106.getCanonicalPath().startsWith(r103.getCanonicalPath() + File.separator) == true) goto L33;
        pk4.j.b("OfflineFileStore", "Offline file path is outside base dir, fileKeyLength=" + r105.length());     // Catch: IOException -> L27
        goto L30
    L33:
        return r106;
    L5:
        if (r102.length() == 0) goto L20;
        String r107 = r102.trim();
        if (r107.length() == 0) goto L20;
        if (r107.startsWith(".") == true) goto L14;
        r107 = ".".concat(r107);
    L14:
        r104 = r107.replaceAll("[^a-zA-Z0-9._-]", "_");
        if (r104.length() <= 1) goto L20;
        if (r104.equals(r107) == true) goto L21;
        pk4.j.f("OfflineFileStore", "Normalize offline file extension, original=" + r102 + ", normalized=" + r104);
        goto L21
    }
}
