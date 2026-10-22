package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.widget;

import android.animation.ValueAnimator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoiceOvalBackground f430708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f430709b;

    public a(VoiceOvalBackground r100, boolean r101) {
        this.f430708a = r100;
        this.f430709b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        float r101 = r100.getAnimatedFraction();
        VoiceOvalBackground r102 = this.f430708a;
        boolean r103 = this.f430709b;
        if (r103 == false) goto L5;
        float r104 = r102.f430673i;
        float r105 = r102.f430675k;
    L6:
        r102.f430677m = r104 + ((r105 - r104) * r101);
        if (r103 == false) goto L9;
        float r106 = r102.f430674j;
        float r107 = r102.f430676l;
    L10:
        r102.f430678n = r106 + ((r107 - r106) * r101);
        r102.c();
        this.f430708a.e();
        this.f430708a.invalidate();
        return;
    L9:
        r106 = r102.f430676l;
        r107 = r102.f430674j;
        goto L10
    L5:
        r104 = r102.f430675k;
        r105 = r102.f430673i;
        goto L6
    }
}
