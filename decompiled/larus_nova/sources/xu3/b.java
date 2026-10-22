package xu3;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static void a(File r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.exists() == false) goto L12;
        r100.delete();     // Catch: Throwable -> L8
        return;
    L13:
        return;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x003a: MOVE (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:16777274), block:B:26:0x003a */
    public static byte[] b(File r100) {
        Closeable r101 = null;
        if (r100.exists() == true) goto L5;
        return null;
    L5:
        int r102 = (int) r100.length();
        byte[] r103 = new byte[r102];
        BufferedInputStream r104 = new BufferedInputStream(new PolarisFileInputStreamWrapper(r100));     // Catch: Throwable -> L15 IOException -> L17 FileNotFoundException -> L20
    L30:
        r104.read(r103, 0, r102);     // Catch: IOException -> L11 FileNotFoundException -> L13 Throwable -> L25
        r104.close();     // Catch: IOException -> L11 FileNotFoundException -> L13 Throwable -> L25
        c.a(r104);
        return r103;
    L13:
        e = e;
    L22:
        e.printStackTrace();     // Catch: Throwable -> L25
    L23:
        c.a(r104);
        return null;
    L11:
        e = e;
    L19:
        e.printStackTrace();     // Catch: Throwable -> L25
    L25:
        th = th;
        r101 = r3;
    L27:
        c.a(r101);
        throw th;
    L20:
        e = e;
        r104 = null;
    L17:
        e = e;
        r104 = null;
    L15:
        th = th;
        goto L27
    }
}
