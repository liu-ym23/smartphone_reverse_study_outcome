package com.larus.business.multitask_management.impl.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes26.dex */
public final class d extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f321185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f321186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f321187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c f321188d;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f321185a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        if (this.f321185a == false) goto L5;
        return;
    L5:
        Lazy r101 = TaskProgressMockCache.f321164a;
        TaskProgressMockCache.d(this.f321186b, this.f321187c);
        c r102 = this.f321188d;
        Integer r103 = r102.f321178c;
        if (r103 == null) goto L8;
        int r104 = r103.intValue();
    L9:
        int r105 = r102.c(r104, this.f321188d.f321179d, RangesKt.coerceIn(this.f321187c, 0, 500));
        this.f321188d.f(this.f321186b, RangesKt.coerceIn(this.f321187c, 0, 500), r105, this.f321188d.f321179d);
        return;
    L8:
        r104 = 0;
        goto L9
    }

    public d(String r100, int r101, c r102) {
        this.f321186b = r100;
        this.f321187c = r101;
        this.f321188d = r102;
    }
}
