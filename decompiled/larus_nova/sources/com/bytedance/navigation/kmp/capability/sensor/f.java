package com.bytedance.navigation.kmp.capability.sensor;

import android.os.Handler;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes21.dex */
public final class f implements com.bytedance.navigation.kmp.listener.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FallbackDeviceHeadingSensor f265824a;

    public f(FallbackDeviceHeadingSensor r100) {
        this.f265824a = r100;
    }

    @Override // com.bytedance.navigation.kmp.listener.b
    public final void a(float r100, float r101, boolean r102) {
        if (this.f265824a.f265790h != FallbackDeviceHeadingSensor.State.BOOTSTRAP_ROTV) goto L10;
        FallbackDeviceHeadingSensor r103 = this.f265824a;
        e r104 = r103.f265797o;
        Function1<Runnable, Unit> r105 = r103.f265789g;
        if (r105 == null) goto L7;
        r105.invoke(r104);
    L8:
        this.f265824a.a(FallbackDeviceHeadingSensor.State.USING_ESKF);
        goto L10
    L7:
        ((Handler) r103.f265796n.getValue()).removeCallbacks(r104);
    L10:
        if (this.f265824a.f265790h == FallbackDeviceHeadingSensor.State.USING_ESKF) goto L12;
        return;
    L12:
        com.bytedance.navigation.kmp.listener.b r106 = this.f265824a.f265791i;
        if (r106 == null) goto L16;
        r106.a(r100, r101, r102);
        return;
    }
}
