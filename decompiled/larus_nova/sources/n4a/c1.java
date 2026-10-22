package n4a;

import java.io.ByteArrayOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes32.dex */
public final class c1 extends b1 {
    public c1() {
    }

    @Override // n4a.b1
    public final byte[] b(byte[] r100) {
        String[] r101 = f5.f517286a;
        byte[] r102 = null;
        if (r100 != null) goto L5;
    L43:
        return r102;
    L5:
        if (r100.length == 0) goto L43;
        ByteArrayOutputStream r103 = new ByteArrayOutputStream();     // Catch: Throwable -> L18
        ZipOutputStream r104 = new ZipOutputStream(r103);     // Catch: Throwable -> L16
        r104.putNextEntry(new ZipEntry("log"));     // Catch: Throwable -> L14
        r104.write(r100);     // Catch: Throwable -> L14
        r104.closeEntry();     // Catch: Throwable -> L14
        r104.finish();     // Catch: Throwable -> L14
        r102 = r103.toByteArray();     // Catch: Throwable -> L14
        r104.close();     // Catch: Throwable -> L12
    L56:
        r103.close();     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        n.a(th, "ut", "zp2");
    L12:
        th = move-exception;
        n.a(th, "ut", "zp1");
    L14:
        th = th;
    L44:
        n.a(th, "ut", "zp");     // Catch: Throwable -> L31
        if (r104 != null) goto L48;
    L26:
        if (r103 == null) goto L43;
    L48:
        r104.close();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        n.a(th, "ut", "zp1");
    L31:
        th = move-exception;
        if (r104 != null) goto L52;
    L37:
        if (r103 == null) goto L62;
        r103.close();     // Catch: Throwable -> L40
        throw th;
    L40:
        th = move-exception;
        n.a(th, "ut", "zp2");
        throw th;
    L62:
        throw th;
    L52:
        r104.close();     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        n.a(th, "ut", "zp1");
    L16:
        th = th;
        r104 = null;
    L18:
        th = th;
        r103 = null;
        r104 = null;
        goto L44
    }
}
