package com.obric.oui.forms;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class p extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OInputView f401037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextView f401038b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        if (this.f401037a.getVInput().hasFocus() == false) goto L5;
        this.f401037a.k6(OInputView.LabelUIState.REAL_LABEL_SHOW, this.f401038b, "LabelShowAnim, onAnimationCancel");
        return;
    L5:
        this.f401037a.k6(OInputView.LabelUIState.FAKE_LABEL_SHOW, this.f401038b, "LabelShowAnim, onAnimationCancel");
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        if (this.f401037a.getVInput().hasFocus() == false) goto L5;
        this.f401037a.k6(OInputView.LabelUIState.REAL_LABEL_SHOW, this.f401038b, "LabelShowAnim, onAnimationCancel");
        return;
    L5:
        this.f401037a.k6(OInputView.LabelUIState.FAKE_LABEL_SHOW, this.f401038b, "LabelShowAnim, onAnimationCancel");
    }

    public p(OInputView r100, TextView r101) {
        this.f401037a = r100;
        this.f401038b = r101;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        OInputView r102 = this.f401037a;
        OInputView.LabelUIState r103 = OInputView.LabelUIState.FAKE_LABEL_SHOW;
        TextView r104 = this.f401038b;
        int r105 = OInputView.f400925k0;
        r102.k6(r103, r104, "LabelShowAnim, onAnimationStart");
    }
}
