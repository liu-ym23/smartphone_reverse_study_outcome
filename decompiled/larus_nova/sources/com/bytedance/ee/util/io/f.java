package com.bytedance.ee.util.io;

import android.text.TextUtils;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes19.dex */
public final class f {
    public static void a(ZipInputStream r100, String r101) throws IOException {
        VFSFile r102 = ay4.d.a().i(r101);
        if (r102.exists() == true) goto L53;
        r102.mkdirs();
    L53:
        ZipEntry r103 = r100.getNextEntry();     // Catch: Throwable -> L46
        if (r103 != null) goto L9;
    L15:
        tt5.a.h("ZipUtils", " unzipFile(): ");     // Catch: Throwable -> L46
        byte[] r104 = new byte[1048576];     // Catch: Throwable -> L46
    L16:
        if (r103 == null) goto L44;
        if (r103.getName() == null) goto L25;
        if (r103.getName().contains(DownloadConstants.VULNERABILITY_PATH) == false) goto L25;
        throw new IOException("unzip slip, path contains ..");     // Catch: Throwable -> L46
    L25:
        if (r103.isDirectory() == false) goto L27;
        ay4.d.a().i(r101 + File.separator + r103.getName()).mkdir();     // Catch: Throwable -> L46
    L37:
        r103 = r100.getNextEntry();     // Catch: Throwable -> L46
        goto L16
    L27:
        VFSFile r105 = ay4.d.a().i(r101 + File.separator + r103.getName());     // Catch: Throwable -> L46
        File r106 = r105.getParentFile();     // Catch: Throwable -> L46
        if (r106.exists() == true) goto L30;
        r106.mkdirs();     // Catch: Throwable -> L46
    L30:
        r105.createNewFile();     // Catch: Throwable -> L46
        OutputStream r107 = r105.newOutputStream();     // Catch: Throwable -> L40
    L49:
        int r108 = r100.read(r104);     // Catch: Throwable -> L38
        if (r108 <= 0) goto L36;
        r107.write(r104, 0, r108);     // Catch: Throwable -> L38
        goto L49
    L36:
        FileUtils.d(r107);     // Catch: Throwable -> L46
    L38:
        th = th;
    L42:
        FileUtils.d(r107);     // Catch: Throwable -> L46
        throw th;     // Catch: Throwable -> L46
    L40:
        th = th;
        r107 = null;
        goto L42
    L44:
        FileUtils.d(r100);
        return;
    L9:
        if (TextUtils.isEmpty(r103.getName()) == true) goto L15;
        if (r103.getName().contains(DownloadConstants.VULNERABILITY_PATH) == false) goto L15;
        tt5.a.k("ZipUtils", "unzipFile: zip name inValid, contains ../");     // Catch: Throwable -> L46
        FileUtils.d(r100);
        return;
    L46:
        th = move-exception;
        FileUtils.d(r100);
        throw th;
    }
}
