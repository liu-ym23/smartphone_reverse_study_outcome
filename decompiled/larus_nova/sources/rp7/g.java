package rp7;

import android.util.Base64;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes22.dex */
public final class g implements qp7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f538861a;

    public g(op7.a r100) {
        this.f538861a = r100;
    }

    public static String b(qp7.f r100, String r101) {
        int r102 = r100.f534354a.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        if (r101.equals(ListProtector.get(r100.f534354a, r103)) == true) goto L12;
        r103 = r103 + 1;
        goto L3
    L12:
        return (String) ListProtector.get(r100.f534355b, r103);
    L8:
        return null;
    }

    @Override // qp7.c
    public final boolean a(pp7.e r100, qp7.g r101, qp7.h r110) throws IOException {
        if ("websocket".equalsIgnoreCase(b(r101, "Upgrade")) == true) goto L5;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == true) goto L13;
        r110.f534357c = 501;
        r110.f534358d = "Not Implemented";
        r110.f534359e = qp7.e.a("Not a supported WebSocket upgrade request\n", "text/plain");
        return true;
    L13:
        r110.f534357c = 101;
        r110.f534358d = "Switching Protocols";
        r110.a("Upgrade", "websocket");
        r110.a("Connection", "Upgrade");
        r110.f534359e = null;
        String r103 = b(r101, "Sec-WebSocket-Key");
        if (r103 != null) goto L37;
    L25:
        pp7.a r104 = r100.f530224b.a();
        OutputStream r105 = r100.f530223a.getOutputStream();
        qp7.i.b(r110, new qp7.i.b(new BufferedOutputStream(r105)));
        h r111 = new h(r104, r105, this.f538861a);
        if (r111.f538865d.getAndSet(true) == true) goto L38;
        ((op7.a) r111.f538864c).f524729a.a(r111);
    L38:
        r111.f538862a.a(r111.f538867f);     // Catch: IOException -> L30 EOFException -> L33
    L34:
        return false;
    L33:
        r111.b();
    L30:
        e = move-exception;
        r111.b();
        throw e;
    L37:
        String r106 = r103.concat("258EAFA5-E914-47DA-95CA-C5AB0DC85B11");     // Catch: NoSuchAlgorithmException -> L22
        MessageDigest r107 = MessageDigest.getInstance("SHA-1");     // Catch: NoSuchAlgorithmException -> L22
        int r108 = f.f538860a;     // Catch: NoSuchAlgorithmException -> L22
        r107.update(r106.getBytes("UTF-8"));     // Catch: NoSuchAlgorithmException -> L22
        r110.a("Sec-WebSocket-Accept", Base64.encodeToString(r107.digest(), 2));
        goto L25
    L19:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: NoSuchAlgorithmException -> L22
    L22:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        if ("Upgrade".equals(b(r101, "Connection")) == false) goto L9;
        if ("13".equals(b(r101, "Sec-WebSocket-Version")) == false) goto L9;
        r102 = true;
        goto L10
    }
}
