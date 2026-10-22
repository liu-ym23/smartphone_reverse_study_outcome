package com.larus.extension.aggregate_search_ui.impl.component.kmp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class f extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f342592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextView f342593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f342594c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f342592a.setVisibility(4);
        this.f342593b.setTextColor(this.f342594c);
    }

    public f(View r100, TextView r101, int r102) {
        this.f342592a = r100;
        this.f342593b = r101;
        this.f342594c = r102;
    }
}
