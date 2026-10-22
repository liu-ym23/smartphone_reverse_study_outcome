package com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class o implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f196910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ObjectAnimator f196911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f196912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AosBaseFragment<?> f196913d;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f196910a.f196909h = false;
        this.f196911b.removeListener(this);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f196910a.f196909h = false;
        this.f196911b.removeListener(this);
        n.a(this.f196910a, this.f196912c, this.f196913d);
    }

    public o(n r100, ObjectAnimator r101, FragmentActivity r102, AosBaseFragment<?> r103) {
        this.f196910a = r100;
        this.f196911b = r101;
        this.f196912c = r102;
        this.f196913d = r103;
    }
}
