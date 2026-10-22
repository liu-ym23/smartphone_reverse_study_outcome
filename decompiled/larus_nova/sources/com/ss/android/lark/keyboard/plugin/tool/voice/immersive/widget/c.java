package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.widget;

import android.animation.ValueAnimator;
import android.graphics.RectF;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoiceWaveBar f430711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList<Float> f430712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList<Float> f430713c;

    public c(VoiceWaveBar r100, ArrayList<Float> r101, ArrayList<Float> r102) {
        this.f430711a = r100;
        this.f430712b = r101;
        this.f430713c = r102;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        if ((this.f430711a.f430698p.isEmpty() | this.f430712b.isEmpty()) == false) goto L5;
        return;
    L5:
        Iterator r101 = CollectionsKt.zip(this.f430712b, this.f430713c).iterator();
        int r102 = 0;
    L7:
        if (r101.hasNext() == false) goto L12;
        int r103 = r102 + 1;
        Pair r104 = (Pair) r101.next();
        float r105 = ((Number) r104.component1()).floatValue();
        float r106 = ((Number) r104.component2()).floatValue() - r105;
        Object r107 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type kotlin.Float");
        float r108 = (r105 + ((r106 * ((Float) r107).floatValue()) / 12)) / 2;
        if (this.f430711a.f430698p.size() <= r102) goto L11;
        RectF r109 = (RectF) ListProtector.get(this.f430711a.f430698p, r102);
        VoiceWaveBar r110 = this.f430711a;
        r109.bottom = r110.f430688f + r108;
        ((RectF) ListProtector.get(r110.f430698p, r102)).top = this.f430711a.f430688f - r108;
    L11:
        r102 = r103;
        goto L7
    L12:
        this.f430711a.invalidate();
    }
}
