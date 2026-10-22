package gta;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.applog.k0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes34.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f482701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f482702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f482703c;

    public final void a() {
        e r100 = this.f482703c;
        if (r100.f482690c == true) goto L12;
        r100.f482688a = false;
        ((ArrayList) r100.f482695h).clear();
        r100.f482696i = false;
        k0 r101 = k0.d();
        e.b r102 = this.f482703c.f482698k;
        if (r102 == null) goto L7;
        r101.e().removeCallbacks(r102);
        r101.e().postDelayed(r102, 30010);
    L8:
        e r103 = this.f482703c;
        r103.f482691d = this.f482701a;
        r103.f482690c = true;
        if (r103.f482689b == false) goto L13;
        e r104 = this.f482703c;
        r104.f482688a = true;
        r104.f482692e = new g(this.f482701a);
        e r105 = this.f482703c;
        g r106 = r105.f482692e;
        String r107 = this.f482702b;
        r106.f482706c = true;
        r106.f482707d = r107;
        e.a(r105, r106.f482705b);
        return;
    L13:
        return;
    L7:
        r101.getClass();
        goto L8
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

    public f(e r100, long r101, String r102) {
        this.f482703c = r100;
        this.f482701a = r101;
        this.f482702b = r102;
    }
}
