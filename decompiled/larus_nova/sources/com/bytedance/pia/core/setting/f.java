package com.bytedance.pia.core.setting;

import com.bytedance.pia.core.api.bridge.PiaMethod;

/* JADX INFO: loaded from: classes21.dex */
public final class f<T> implements l47.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l47.a<PiaMethod.Error> f266302a;

    public f() {
        this.f266302a = null;
    }

    @Override // l47.a
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        g r102 = g.f266303a;
        l47.a<PiaMethod.Error> r103 = this.f266302a;
        if (r103 == null) goto L5;
        r103.accept(new PiaMethod.Error(-10001, r101.getMessage()));
    L5:
        r102.getClass();
        g.f266309g.set(false);
        com.bytedance.pia.core.utils.d.f("Update settings error:", r101, null, 12);
        com.bytedance.pia.core.utils.d.l("[PIASettings] Update Async settings failed. Error: " + r101.getMessage(), null, 14);
    }
}
