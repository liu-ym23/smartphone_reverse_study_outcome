package com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.collect;

import android.animation.Animator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f extends com.bytedance.awemeopen.infra.base.anim.lottie.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CollectElementView f196694a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f196695a = null;

        static {
            int[] r100 = new int[CollectElementView.State.values().length];
            r100[CollectElementView.State.AnimToCollect.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[CollectElementView.State.AnimToUnCollect.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f196695a = r100;
        }
    }

    public f(CollectElementView r100) {
        this.f196694a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        CollectElementView r101 = this.f196694a;
        CollectElementView.State r102 = r101.f196681j;
        int r103 = a.f196695a[r102.ordinal()];
        if (r103 != 1) goto L5;
        CollectElementView.State r104 = CollectElementView.State.Collect;
    L9:
        r101.f196681j = r104;
        return;
    L5:
        if (r103 == 2) goto L7;
        r104 = this.f196694a.f196681j;
        goto L9
    L7:
        r104 = CollectElementView.State.UnCollect;
        goto L9
    }
}
