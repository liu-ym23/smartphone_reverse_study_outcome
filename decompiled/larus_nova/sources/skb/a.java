package skb;

import com.larksuite.framework.utils.d;
import com.ss.android.lark.log.Log;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes36.dex */
public final class a {
    static {
    }

    public static void a(String r100) {
        if (r100 == null) goto L5;
        Log.i("LarkBitmapFactory", r100);
        return;
    }

    @JvmStatic
    public static final byte[] b(InputStream r100) {
        byte[] r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();
        byte[] r103 = new byte[8192];
    L20:
        th = move-exception;
        a("readStream failed:" + th);     // Catch: Throwable -> L31
    L27:
        th = th;
        StringBuilder r104 = new StringBuilder("reset or close error:");
    L29:
        r104.append(th);
        a(r104.toString());
    L30:
        return r101;
    L23:
        if (r100.markSupported() == false) goto L25;
        r100.reset();     // Catch: Throwable -> L27
    L25:
        d.b(new Closeable[]{r102});     // Catch: Throwable -> L27
    L31:
        th = move-exception;
    L37:
        th = move-exception;
        a("reset or close error:" + th);
    L39:
        throw th;
    L33:
        if (r100.markSupported() == false) goto L35;
        r100.reset();     // Catch: Throwable -> L37
    L35:
        d.b(new Closeable[]{r102});     // Catch: Throwable -> L37
        goto L39
    L7:
        if (r100.markSupported() == false) goto L9;
        r100.mark(r100.available());     // Catch: Throwable -> L20
    L9:
        int r105 = r100.read(r103);     // Catch: Throwable -> L20
        if (r105 == (-1)) goto L12;
        r102.write(r103, 0, r105);     // Catch: Throwable -> L20
        goto L9
    L12:
        r101 = r102.toByteArray();     // Catch: Throwable -> L20
    L18:
        th = th;
        r104 = new StringBuilder("reset or close error:");
        goto L29
    L14:
        if (r100.markSupported() == false) goto L16;
        r100.reset();     // Catch: Throwable -> L18
    L16:
        d.b(new Closeable[]{r102});     // Catch: Throwable -> L18
        goto L30
    }
}
