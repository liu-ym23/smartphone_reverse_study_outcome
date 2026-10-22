package com.bytedance.ies.sve_core;

/* JADX INFO: loaded from: classes19.dex */
public abstract class w extends BaseEffect {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v f248704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Store f248705c;

    public void d() {
    }

    public void e() {
    }

    public w(Store r100) {
        super(r100);
        this.f248705c = r100;
    }

    public final void f(a r100) {
        v r101 = this.f248704b;
        if (r101 == null) goto L8;
        r<?> r102 = r101.f248703a;
        if (r102 == null) goto L9;
        r102.Wo(new y(r100));
        return;
    L9:
        return;
    }
}
