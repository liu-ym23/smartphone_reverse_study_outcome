package z5a;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f570138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f570139b;

    public final void c() {
        JavaOnlyMap r100 = new JavaOnlyMap();
        r100.putString("event", "onEnd");
        JavaOnlyArray r101 = new JavaOnlyArray();
        r101.pushMap(r100);
        this.f570139b.a(this.f570138a, r101);
    }

    public final void a(InputStream r110) throws IOException {
        BufferedInputStream r100 = new BufferedInputStream(r110);
        StringBuilder r111 = new StringBuilder();
    L3:
        int r101 = r100.read();
        if (r101 == (-1)) goto L9;
        if (r101 == 13) goto L9;
        r111.append((char) r101);
    L9:
        if (r101 == 13) goto L11;
    L14:
        d("errorStreamingMalformedResponse");
        int r102 = -1;
    L15:
        if (r102 <= 0) goto L31;
        byte[] r103 = new byte[r102];
        int r104 = 0;
    L18:
        if (r104 >= r102) goto L23;
        int r105 = r100.read(r103, r104, r102 - r104);
        if (r105 == (-1)) goto L23;
        r104 = r104 + r105;
    L23:
        if (r104 == r102) goto L25;
    L28:
        d("errorStreamingMalformedResponse");
        r103 = new byte[0];
    L30:
        if (r103.length == 0) goto L31;
        b(r103);
        goto L3
    L25:
        if (r100.read() != 13) goto L28;
        if (r100.read() == 10) goto L30;
    L31:
        r100.close();
        return;
    L11:
        if (r100.read() != 10) goto L14;
        String r106 = r111.toString();
        r111.setLength(0);
        r102 = CastIntegerProtector.parseInt(r106, 16);
        goto L15
    }

    public final void b(byte[] r100) {
        JavaOnlyMap r101 = new JavaOnlyMap();
        r101.putString("event", "onData");
        r101.putByteArray("data", r100);
        JavaOnlyArray r102 = new JavaOnlyArray();
        r102.pushMap(r101);
        this.f570139b.a(this.f570138a, r102);
    }

    public final void d(String r100) {
        JavaOnlyMap r101 = new JavaOnlyMap();
        r101.putString("event", LynxVideoManagerLite.EVENT_ON_ERROR);
        r101.putString("error", r100);
        JavaOnlyArray r102 = new JavaOnlyArray();
        r102.pushMap(r101);
        this.f570139b.a(this.f570138a, r102);
    }

    public final void e(InputStream r100) throws IOException {
        BufferedInputStream r101 = new BufferedInputStream(r100);
        byte[] r102 = new byte[8192];     // Catch: Throwable -> L10
    L4:
        int r103 = r101.read(r102);     // Catch: Throwable -> L10
        if (r103 == (-1)) goto L8;
        byte[] r104 = new byte[r103];     // Catch: Throwable -> L10
        System.arraycopy(r102, 0, r104, 0, r103);     // Catch: Throwable -> L10
        b(r104);     // Catch: Throwable -> L10
        goto L4
    L8:
        r101.close();
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L15
    L17:
        throw th;
    L15:
        th = move-exception;
        th.addSuppressed(th);
        goto L17
    }

    public final void f(InputStream r100) throws IOException {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
    L3:
        int r102 = -1;
    L4:
        boolean r103 = false;
    L5:
        int r104 = r100.read();
        if (r104 == (-1)) goto L17;
        r101.write(r104);
        if (r104 != 13) goto L13;
        if (r103 == false) goto L10;
        r102 = -1;
        goto L5
    L10:
        r103 = true;
        goto L5
    L13:
        if (r102 != 10) goto L16;
        if (r104 != 10) goto L16;
        b(r101.toByteArray());
        r101.reset();
    L16:
        r102 = r104;
        goto L4
    }

    public a(String r100, b r101) {
        this.f570138a = r100;
        this.f570139b = r101;
    }
}
