package r17;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes21.dex */
public final class h {
    public static void b(PolarisFileWrapper r100, PolarisFileWrapper r101) {
        ZipOutputStream r102 = null;
        ZipOutputStream r103 = new ZipOutputStream(new PolarisFileOutputStreamWrapper(r101));     // Catch: Throwable -> L13 Exception -> L15
        a(r100, r103, r100.getName());     // Catch: Throwable -> L9 Exception -> L11
        r103.close();     // Catch: IOException -> L7
    L33:
        return;
    L11:
        e = e;
        r102 = r103;
    L16:
        HashMap<String, Object> r104 = new HashMap();     // Catch: Throwable -> L13
        r104.put("http_error_message", e.getMessage());     // Catch: Throwable -> L13
        x17.a.f562123j.b("compress_exception", r104);     // Catch: Throwable -> L13
        if (r102 == null) goto L40;
        r102.close();     // Catch: IOException -> L7
        goto L33
    L40:
        return;
    L9:
        th = th;
    L23:
        if (r103 != null) goto L31;
    L28:
        throw th;
    L31:
        r103.close();     // Catch: IOException -> L26
    L26:
        e = move-exception;
        e.printStackTrace();
    L15:
        e = e;
    L13:
        th = th;
        r103 = r102;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public static void a(PolarisFileWrapper r100, ZipOutputStream r101, String r102) throws Exception {
        byte[] r103 = new byte[2048];
        r101.putNextEntry(new ZipEntry(r102));
        PolarisFileInputStreamWrapper r104 = new PolarisFileInputStreamWrapper(r100);
    L3:
        int r105 = r104.read(r103);
        if (r105 == (-1)) goto L6;
        r101.write(r103, 0, r105);
        goto L3
    L6:
        r101.closeEntry();
        r104.close();
    }
}
