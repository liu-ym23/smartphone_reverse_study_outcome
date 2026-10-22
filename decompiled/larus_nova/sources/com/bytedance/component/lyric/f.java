package com.bytedance.component.lyric;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class f extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewPainter f203002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f203003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ jg4.a f203004c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ViewPainter r101 = this.f203002a;
        if (r101.f202975b != null) goto L5;
        return;
    L5:
        r101.setAnimationY(0);
        this.f203002a.setAnimating(false);
        ViewPainter r102 = this.f203002a;
        r102.f202976c = this.f203003b;
        r102.f202974a = this.f203004c.f498982e;
        r102.setInScroll(false);
        this.f203002a.getDynamicRectF().left = 0.0f;
        this.f203002a.invalidate();
    }

    public f(ViewPainter r100, int r101, jg4.a r102) {
        this.f203002a = r100;
        this.f203003b = r101;
        this.f203004c = r102;
    }
}
