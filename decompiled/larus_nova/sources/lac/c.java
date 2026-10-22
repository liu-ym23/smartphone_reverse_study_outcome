package lac;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.utils.walle.SignatureNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public final class c {
    public static String a(PolarisFileWrapper r100) {
        RandomAccessFile r101 = new RandomAccessFile(r100, "r");     // Catch: Throwable -> L14 IOException -> L23
        FileChannel r102 = r101.getChannel();     // Catch: Throwable -> L11 IOException -> L13
    L65:
        Map<Integer, ByteBuffer> r103 = a.b(a.a(r102).f508249a);     // Catch: Throwable -> L8 IOException -> L10
        r102.close();     // Catch: IOException -> L48 Throwable -> L33
    L31:
        r101.close();     // Catch: Throwable -> L33
    L35:
        if (r103 == null) goto L39;
        ByteBuffer r104 = r103.get(1903654775);
        if (r104 == null) goto L39;
        byte[] r105 = r104.array();
        int r106 = r104.arrayOffset();
        byte[] r107 = Arrays.copyOfRange(r105, r104.position() + r106, r106 + r104.limit());
    L41:
        if (r107 == null) goto L70;
        return new String(r107, "UTF-8");
    L45:
        e = move-exception;
        e.printStackTrace();
        return null;
    L70:
        return null;
    L39:
        r107 = null;
        goto L41
    L8:
        Throwable th10 = th;
    L16:
        if (r102 != null) goto L58;
    L20:
        if (r101 == null) goto L67;
        r101.close();     // Catch: IOException -> L49 SignatureNotFoundException -> L27
        throw th10;     // Catch: SignatureNotFoundException -> L27
    L68:
        throw th10;     // Catch: SignatureNotFoundException -> L27
    L67:
        throw th10;     // Catch: SignatureNotFoundException -> L27
    L58:
        r102.close();     // Catch: IOException -> L19 SignatureNotFoundException -> L27
    L24:
        if (r102 != null) goto L56;
    L29:
        if (r101 == null) goto L34;
        r103 = null;
        goto L31
    L56:
        r102.close();     // Catch: SignatureNotFoundException -> L27 IOException -> L28
    L13:
        r102 = null;
    L11:
        th10 = th;
        r102 = null;
        goto L16
    L23:
        r102 = null;
        r101 = null;
    L14:
        th = move-exception;
        th10 = th;
        r102 = null;
        r101 = null;
    L34:
        r103 = null;
        goto L35
    }
}
