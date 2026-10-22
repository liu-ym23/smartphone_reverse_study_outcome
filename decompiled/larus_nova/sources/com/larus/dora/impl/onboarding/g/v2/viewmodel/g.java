package com.larus.dora.impl.onboarding.g.v2.viewmodel;

import android.animation.ValueAnimator;
import com.larus.platform.api.IVideoController;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f336807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f336808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f336809c;

    public /* synthetic */ g(l r100, long r101, Function0 r102) {
        this.f336807a = r100;
        this.f336808b = r101;
        this.f336809c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final l r100 = this.f336807a;
        long r101 = this.f336808b;
        final Function0 r102 = this.f336809c;
        StringBuilder r103 = new StringBuilder("stopPlayWithAnim: isPlaying=");
        IVideoController r104 = r100.a();
        if (r104 == null) goto L5;
        Boolean r105 = Boolean.valueOf(r104.p3());
    L6:
        r103.append(r105);
        g49.d.d("DoraOnboardingBgMusicPlayerV2", r103.toString());
        ValueAnimator r106 = r100.f336817d;
        if (r106 == null) goto L11;
        boolean r107 = true;
        if (r106.isRunning() != true) goto L11;
    L12:
        if (r107 == false) goto L14;
        g49.d.d("DoraOnboardingBgMusicPlayerV2", "stopPlayWithAnim: stopAnim is running");
    L14:
        IVideoController r108 = r100.a();
        if (r108 == null) goto L17;
        float r109 = r108.g();
    L18:
        ValueAnimator r110 = com.larus.dora.impl.onboarding.v.a(r109, r101, new j(r100), new k(r100, r102));
        r100.f336817d = r110;
        r110.start();
        return;
    L17:
        r109 = 1.0f;
    L11:
        r107 = false;
        goto L12
    L5:
        r105 = null;
        goto L6
    }
}
