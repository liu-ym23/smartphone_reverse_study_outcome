package com.bytedance.ee.bear.document.plugin.selection;

import android.animation.ValueAnimator;
import android.webkit.WebView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class k implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j.a f220939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WebView f220940b;

    public k(j.a r100, ChameleonWebView r101) {
        this.f220939a = r100;
        this.f220940b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        j.a r101 = this.f220939a;
        int r102 = r101.f220936a;
        WebView r103 = this.f220940b;
        if (r103.canScrollVertically(r101.f220937b) == true) goto L5;
        r100.cancel();
        return;
    L5:
        if (this.f220939a.f220937b > 0) goto L8;
        r102 = -r102;
    L8:
        r103.scrollBy(0, r102);
        boolean r104 = this.f220939a.f220938c;
    }
}
