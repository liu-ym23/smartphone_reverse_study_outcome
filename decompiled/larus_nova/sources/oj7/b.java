package oj7;

import android.app.Application;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements ni7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f523584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f523585b;

    @Override // ni7.b
    public final g F() {
        return new g(this.f523585b, this.f523584a);
    }

    public b(Application r100) {
        a r101 = new a();
        this.f523584a = r101;
        c r102 = new c();
        this.f523585b = r102;
        r100.registerActivityLifecycleCallbacks(r102);
        r100.registerActivityLifecycleCallbacks(r101);
    }
}
