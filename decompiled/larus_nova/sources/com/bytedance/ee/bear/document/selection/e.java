package com.bytedance.ee.bear.document.selection;

import android.animation.ValueAnimator;
import android.view.ActionMode;
import android.webkit.WebView;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d.a f221608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WebView f221609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d.b f221610c;

    public e(d.a r100, WebView r101, v r102) {
        this.f221608a = r100;
        this.f221609b = r101;
        this.f221610c = r102;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        d.a r101 = this.f221608a;
        int r102 = r101.f221603a;
        WebView r103 = this.f221609b;
        if (r103.canScrollVertically(r101.f221604b) == true) goto L5;
        r100.cancel();
        return;
    L5:
        if (this.f221608a.f221604b > 0) goto L8;
        r102 = -r102;
    L8:
        r103.scrollBy(0, r102);
        if (this.f221608a.f221605c == false) goto L17;
        d.b r104 = this.f221610c;
        if (r104 == null) goto L18;
        e0 r105 = ((v) r104).f221718a;
        r105.q();
        ActionMode r106 = r105.C;
        if (r106 == null) goto L19;
        r106.invalidateContentRect();
        return;
    L19:
        return;
    L18:
        return;
    }
}
