package fk;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.FrameLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f477552a;

    public a(e r100) {
        this.f477552a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationEnd(r100);
        e r101 = this.f477552a;
        com.bytedance.android.ec.hybrid.popup.g r102 = r101.f481520c;
        if (r102 == null) goto L7;
        FrameLayout r103 = r102.c();
        if (r103 == null) goto L7;
        r103.removeAllViews();
    L7:
        com.bytedance.android.ec.hybrid.card.api.e r104 = r101.f477558h;
        if (r104 == null) goto L10;
        r104.release();
    L10:
        r101.f477558h = null;
    }
}
