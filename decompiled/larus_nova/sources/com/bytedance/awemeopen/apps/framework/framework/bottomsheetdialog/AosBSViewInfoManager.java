package com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.google.android.material.internal.AosBottomSheetBehavior;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class AosBSViewInfoManager {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f196861l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AosBottomSheetBehavior<FrameLayout> f196862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f196863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f196864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a0 f196865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f196866e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f196867f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c0 f196868g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public s24.b f196869h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f196870i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f196871j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f196872k;

    public static final class a {
    }

    public static final class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AosBSViewInfoManager f196873a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ObjectAnimator f196874b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c0 f196875c;

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
            this.f196873a.f196867f = false;
            this.f196874b.removeListener(this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f196873a.f196867f = false;
            this.f196874b.removeListener(this);
            AosBSViewInfoManager r101 = this.f196873a;
            c0 r102 = this.f196875c;
            r101.f196866e = 3;
            r102.a();
            a0 r103 = r101.f196865d;
            if (r103 == null) goto L6;
            r103.onClose();
            return;
        }

        public b(AosBSViewInfoManager r100, ObjectAnimator r101, c0 r102) {
            this.f196873a = r100;
            this.f196874b = r101;
            this.f196875c = r102;
        }
    }

    static {
    }

    public final void a() {
        FrameLayout r100 = this.f196864c;
        if (r100 == null) goto L6;
        r100.post(new r(this));
        return;
    }

    public AosBSViewInfoManager() {
        this.f196866e = -1;
        this.f196872k = LazyKt.lazy(AosBSViewInfoManager$enableCommentShrink$2.INSTANCE);
    }

    public final void b(View r100) {
        Intrinsics.checkNotNull(r100);
        float r101 = r100.getMeasuredHeight();
        this.f196870i = r101;
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r101, 0.0f});
        r102.setDuration(300);
        if (((Boolean) this.f196872k.getValue()).booleanValue() == false) goto L5;
        r102.addUpdateListener(new w(this));
    L5:
        r102.start();
        a0 r103 = this.f196865d;
        if (r103 == null) goto L9;
        r103.onOpen();
        return;
    }

    public final void c(Activity r100, View r101, c0 r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f196867f == false) goto L6;
        return;
    L6:
        this.f196867f = true;
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, r101.getMeasuredHeight()});
        r103.setDuration(300);
        r103.addListener(new b(this, r103, r102));
        if (((Boolean) this.f196872k.getValue()).booleanValue() == false) goto L9;
        r103.addUpdateListener(new v(this));
    L9:
        r103.start();
    }
}
