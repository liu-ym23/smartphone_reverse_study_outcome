package com.larus.bmhome.chat.detail.code;

import android.animation.ValueAnimator;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomMarkdownTextView f302737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CodeBlockDetailFragment f302738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f302739c;

    public /* synthetic */ f(CustomMarkdownTextView r100, CodeBlockDetailFragment r101, int r102) {
        this.f302737a = r100;
        this.f302738b = r101;
        this.f302739c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CustomMarkdownTextView r100 = this.f302737a;
        final CodeBlockDetailFragment r101 = this.f302738b;
        int r102 = this.f302739c;
        int r103 = CodeBlockDetailFragment.f302708k0;
        int r104 = r100.getMeasuredHeight();
        ValueAnimator r105 = r101.V;
        if (r105 == null) goto L5;
        r105.cancel();
    L5:
        ValueAnimator r106 = ValueAnimator.ofInt(new int[]{r102, r104});
        r101.V = r106;
        r106.setDuration(500);
        r106.addUpdateListener(new p(r101));
        r106.addListener(new e0(r101, r106));
        r106.start();
    }
}
