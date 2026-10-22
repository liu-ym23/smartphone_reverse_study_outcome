package gta;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.applog.k0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes34.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f482684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f482685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f482686c;

    public final void a() {
        e r100 = this.f482686c;
        if (r100.f482690c == false) goto L18;
        r100.f482690c = false;
        k0 r101 = k0.d();
        e.b r102 = this.f482686c.f482698k;
        r101.e().removeCallbacks(r102);
        k0 r103 = k0.d();
        e.a r104 = this.f482686c.f482697j;
        r103.e().removeCallbacks(r104);
        this.f482686c.b().removeMessages(1);
        this.f482686c.f482694g.a();
        e r105 = this.f482686c;
        if (r105.f482688a == true) goto L7;
    L16:
        e r106 = this.f482686c;
        r106.f482688a = false;
        ((ArrayList) r106.f482695h).clear();
        r106.f482696i = false;
        return;
    L7:
        if ((this.f482684a - r105.f482691d) > 30000) goto L10;
        ((ArrayList) r105.f482695h).clear();
        this.f482686c.f482692e = null;
        goto L16
    L10:
        if (r105.f482692e != null) goto L12;
    L15:
        this.f482686c.f482698k.run();
        goto L16
    L12:
        if (r105.f482689b == false) goto L14;
        g r107 = this.f482686c.f482692e;
        String r108 = this.f482685b;
        r107.f482708e = true;
        r107.f482709f = r108;
        r107.f482710g = this.f482684a;
    L14:
        e r109 = this.f482686c;
        r109.f482694g.b(r109.f482692e);
        this.f482686c.f482692e = null;
        goto L15
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public d(e r100, long r101, String r102) {
        this.f482686c = r100;
        this.f482684a = r101;
        this.f482685b = r102;
    }
}
