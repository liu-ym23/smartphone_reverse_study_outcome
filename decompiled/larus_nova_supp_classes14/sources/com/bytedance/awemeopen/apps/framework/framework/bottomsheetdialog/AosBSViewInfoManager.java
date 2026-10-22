package com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.internal.AosBottomSheetBehavior;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AosBSViewInfoManager {
    public static final /* synthetic */ int l = 0;
    public AosBottomSheetBehavior<FrameLayout> a;
    public FrameLayout b;
    public FrameLayout c;
    public a0 d;
    public int e;
    public boolean f;
    public c0 g;
    public s24.b h;
    public float i;
    public float j;
    public final Lazy k;

    public static final class a {
    }

    public static final class b implements Animator.AnimatorListener {
        public final /* synthetic */ AosBSViewInfoManager a;
        public final /* synthetic */ ObjectAnimator b;
        public final /* synthetic */ c0 c;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.f = false;
            this.b.removeListener(this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            this.a.f = false;
            this.b.removeListener(this);
            AosBSViewInfoManager r4 = this.a;
            c0 r0 = this.c;
            r4.e = 3;
            r0.a();
            a0 r5 = r4.d;
            if (r5 == null) goto L6;
            r5.onClose();
            return;
        }

        public b(AosBSViewInfoManager r1, ObjectAnimator r2, c0 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    public final void a() {
        FrameLayout r0 = this.c;
        if (r0 == null) goto L6;
        r0.post(new r(this));
        return;
    }

    public AosBSViewInfoManager() {
        this.e = -1;
        this.k = LazyKt.lazy(AosBSViewInfoManager$enableCommentShrink$2.INSTANCE);
    }

    public final void b(View r4) {
        Intrinsics.checkNotNull(r4);
        float r0 = r4.getMeasuredHeight();
        this.i = r0;
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r4, "translationY", new float[]{r0, 0.0f});
        r5.setDuration(300);
        if (((Boolean) this.k.getValue()).booleanValue() == false) goto L5;
        r5.addUpdateListener(new w(this));
    L5:
        r5.start();
        a0 r6 = this.d;
        if (r6 == null) goto L9;
        r6.onOpen();
        return;
    }

    public final void c(Activity r4, View r5, c0 r6) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (this.f == false) goto L6;
        return;
    L6:
        this.f = true;
        ObjectAnimator r7 = ObjectAnimator.ofFloat(r5, "translationY", new float[]{0.0f, r5.getMeasuredHeight()});
        r7.setDuration(300);
        r7.addListener(new b(this, r7, r6));
        if (((Boolean) this.k.getValue()).booleanValue() == false) goto L9;
        r7.addUpdateListener(new v(this));
    L9:
        r7.start();
    }
}
