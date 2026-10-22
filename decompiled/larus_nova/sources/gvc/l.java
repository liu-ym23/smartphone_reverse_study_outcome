package gvc;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes42.dex */
public final class l extends cvc.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f482946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s f482947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e.g f482948d;

    @Override // cvc.b
    public final void a() {
        e.g r100 = this.f482948d;
        boolean r101 = this.f482946b;
        s r102 = this.f482947c;
        p r103 = r100.f482930c.f482906u;
        monitor-enter(r103);
        e r104 = r100.f482930c;     // Catch: Throwable -> L51
        monitor-enter(r104);     // Catch: Throwable -> L51
        int r105 = r100.f482930c.f482904s.a();     // Catch: Throwable -> L20
        if (r101 == false) goto L9;
        s r106 = r100.f482930c.f482904s;     // Catch: Throwable -> L20
        r106.f482998a = 0;     // Catch: Throwable -> L20
        Arrays.fill(r106.f482999b, 0);     // Catch: Throwable -> L20
    L9:
        s r107 = r100.f482930c.f482904s;     // Catch: Throwable -> L20
        r107.getClass();     // Catch: Throwable -> L20
        int r108 = 0;
    L10:
        boolean r109 = true;
        if (r108 >= 10) goto L22;
        if (((1 << r108) & r102.f482998a) != 0) goto L16;
        r109 = false;
    L16:
        if (r109 == false) goto L19;
        r107.b(r108, r102.f482999b[r108]);     // Catch: Throwable -> L20
    L19:
        r108 = r108 + 1;     // Catch: Throwable -> L20
        goto L10
    L22:
        int r110 = r100.f482930c.f482904s.a();     // Catch: Throwable -> L20
        o[] r111 = null;
        if (r110 == (-1)) goto L28;
        if (r110 == r105) goto L28;
        long r112 = r110 - r105;     // Catch: Throwable -> L20
        if (r100.f482930c.f482888c.isEmpty() == true) goto L29;
        r111 = (o[]) ((LinkedHashMap) r100.f482930c.f482888c).values().toArray(new o[r100.f482930c.f482888c.size()]);     // Catch: Throwable -> L20
    L29:
        monitor-exit(r104);     // Catch: Throwable -> L20
    L59:
        e r113 = r100.f482930c;     // Catch: IOException -> L32 Throwable -> L51
        r113.f482906u.a(r113.f482904s);     // Catch: IOException -> L32 Throwable -> L51
    L33:
        monitor-exit(r103);     // Catch: Throwable -> L51
        if (r111 == null) goto L47;
        int r114 = r111.length;
        int r115 = 0;
    L36:
        if (r115 >= r114) goto L47;
        o r116 = r111[r115];
        monitor-enter(r116);
        r116.f482962b += r112;     // Catch: Throwable -> L44
        if (r112 <= 0) goto L42;
        r116.notifyAll();     // Catch: Throwable -> L44
    L42:
        monitor-exit(r116);     // Catch: Throwable -> L44
        r115 = r115 + 1;     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        throw th;
    L47:
        e.f482885x.execute(new m(r100, new Object[]{r100.f482930c.f482889d}));
        return;
    L32:
        r100.f482930c.b();     // Catch: Throwable -> L51
    L28:
        r112 = 0;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        throw th;
    }

    public l(e.g r100, Object[] r101, s r102) {
        this.f482948d = r100;
        this.f482946b = false;
        this.f482947c = r102;
        super("OkHttp %s ACK Settings", r101);
    }
}
