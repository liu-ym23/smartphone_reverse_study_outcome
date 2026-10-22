package com.bytedance.awemeopen.infra.plugs.lotties;

import android.graphics.drawable.Drawable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.bytedance.awemeopen.infra.base.anim.lottie.AoAnimConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class j implements com.bytedance.awemeopen.servicesapi.ui.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LottieDrawable f198873a;

    public j() {
        LottieDrawable r100 = new LottieDrawable();
        Intrinsics.checkNotNullParameter(r100, "lottieDrawable");
        this.f198873a = r100;
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final void b() {
        LottieDrawable r100 = this.f198873a;
        u0.c r101 = r100.f24726c;
        if (r101.f548108k == false) goto L5;
        r101.cancel();
    L5:
        r100.f24725b = null;
        r100.f24738o = null;
        r100.f24732i = null;
        u0.c r102 = r100.f24726c;
        r102.f548107j = null;
        r102.f548105h = -2.1474836E9f;
        r102.f548106i = 2.1474836E9f;
        r100.invalidateSelf();
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final void cancelAnimation() {
        this.f198873a.c();
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final void e() {
        this.f198873a.f24726c.removeAllListeners();
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final float getScale() {
        return this.f198873a.f24727d;
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final boolean isRunning() {
        return this.f198873a.h();
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final void start() {
        this.f198873a.start();
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final void stop() {
        this.f198873a.d();
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final LottieDrawable getDrawable() {
        return this.f198873a;
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final void a(AoAnimConfig.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f198873a.f24726c.addListener(r100);
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "str");
        this.f198873a.f24733j = r100;
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final void d(Drawable.Callback r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f198873a.setCallback(r100);
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final void g(int r100) {
        this.f198873a.f24726c.setRepeatMode(r100);
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final void h(com.bytedance.awemeopen.servicesapi.ui.a r100) {
        Intrinsics.checkNotNullParameter(r100, "lottieWrapperDrawable");
        LottieComposition r101 = r100.getComposition();
        if ((r101 instanceof LottieComposition) == false) goto L7;
        this.f198873a.m(r101);
        return;
    L7:
        throw new IllegalStateException("illegal state");
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final void setFrame(int r100) {
        this.f198873a.o(r100);
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final void setRepeatCount(int r100) {
        this.f198873a.w(r100);
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final void setScale(float r100) {
        LottieDrawable r101 = this.f198873a;
        r101.f24727d = r100;
        r101.x();
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final void f(int r100, int r101) {
        this.f198873a.r(r100, r101);
    }
}
