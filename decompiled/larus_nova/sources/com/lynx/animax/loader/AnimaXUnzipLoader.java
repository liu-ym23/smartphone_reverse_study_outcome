package com.lynx.animax.loader;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.animax.util.AnimaXLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import q4a.d;

/* JADX INFO: loaded from: classes32.dex */
public class AnimaXUnzipLoader {

    public static class UnzipResult {
        private String error;
        private String path;

        public String getError() {
            return this.error;
        }

        public String getPath() {
            return this.path;
        }

        public void setError(String r100) {
            this.error = r100;
        }

        public void setPath(String r100) {
            this.path = r100;
        }

        public UnzipResult(String r100, String r101) {
            this.error = r100;
            this.path = r101;
        }
    }

    public AnimaXUnzipLoader() {
    }

    public static String getError(UnzipResult r100) {
        return r100.getError();
    }

    public static String getPath(UnzipResult r100) {
        return r100.getPath();
    }

    public static UnzipResult unzip(String r100, String r110) {
        if (r100 == null) goto L87;
        if (r100.isEmpty() == true) goto L87;
        if (r110 == null) goto L85;
        if (r110.isEmpty() == true) goto L85;
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r100));     // Catch: FileNotFoundException -> L14
    L16:
        if (r101 != null) goto L18;
        ZipInputStream r102 = null;
    L19:
        if (r102 != null) goto L21;
        d r103 = new d("open zip file error");
    L38:
        if (r103.f531718a == true) goto L42;
        return new UnzipResult(r103.f531719b, null);
    L42:
        return new UnzipResult(null, r110);
    L21:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r110);
        if (r104.exists() == true) goto L24;
        boolean r105 = r104.mkdirs();
    L25:
        if (r105 == true) goto L102;
        r103 = new d("make dst directory error");
    L102:
        ZipEntry r106 = r102.getNextEntry();     // Catch: IOException -> L29
    L31:
        if (r106 == null) goto L88;
        String r107 = r106.getName();
        if (r107 != null) goto L47;
    L90:
        r102.closeEntry();     // Catch: IOException -> L82
    L82:
        e = move-exception;
        AnimaXLog.a("UnzipUtil", "closeEntry error: " + e.getMessage());
        goto L102
    L47:
        if (r107.contains("__MACOSX") == true) goto L90;
        if (r107.contains(".DS_Store") == true) goto L90;
        if (r107.contains("../") == true) goto L90;
        if (r106.isDirectory() == false) goto L96;
        new PolarisFileWrapper(r110 + File.separator + r107).mkdirs();
        goto L90
    L96:
        PolarisFileOutputStreamWrapper r108 = new PolarisFileOutputStreamWrapper(r110 + File.separator + r107);     // Catch: FileNotFoundException -> L59
    L61:
        if (r108 == null) goto L90;
        BufferedOutputStream r109 = new BufferedOutputStream(r108);
        byte[] r111 = new byte[4096];
    L94:
        int r112 = r102.read(r111);     // Catch: IOException -> L67
    L69:
        if ((-1) == r112) goto L100;
        boolean r113 = false;
        r109.write(r111, 0, r112);     // Catch: IOException -> L73
        r113 = true;
    L75:
        if (r113 == true) goto L94;
    L73:
        e = move-exception;
        AnimaXLog.a("UnzipUtil", "writeToStream error: " + e.getMessage());
    L100:
        r109.close();     // Catch: IOException -> L78
    L78:
        e = move-exception;
        AnimaXLog.a("UnzipUtil", "close bufferedOutputStream error: " + e.getMessage());
    L67:
        e = move-exception;
        AnimaXLog.a("UnzipUtil", "readZipFile error: " + e.getMessage());
        r112 = -1;
    L59:
        e = move-exception;
        AnimaXLog.a("UnzipUtil", "extractFile, create FileOutputStream error: " + e.getMessage());
        r108 = null;
        goto L61
    L88:
        r102.close();     // Catch: IOException -> L34
    L36:
        r103 = new d();
    L34:
        e = move-exception;
        AnimaXLog.a("UnzipUtil", "zipInputStream close error: " + e.getMessage());
    L29:
        e = move-exception;
        AnimaXLog.a("UnzipUtil", "getNextEntry error: " + e.getMessage());
        r106 = null;
        goto L31
    L24:
        r105 = true;
        goto L25
    L18:
        r102 = new ZipInputStream(r101);
    L14:
        e = move-exception;
        AnimaXLog.a("UnzipUtil", "new FileInputStream error: " + e.getMessage());
        r101 = null;
    L85:
        return new UnzipResult("UnzippedFilePath is null.", null);
    L87:
        return new UnzipResult("ZippedFilePath is null.", null);
    }
}
