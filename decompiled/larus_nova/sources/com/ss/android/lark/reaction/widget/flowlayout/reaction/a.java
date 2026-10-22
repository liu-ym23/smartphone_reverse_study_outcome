package com.ss.android.lark.reaction.widget.flowlayout.reaction;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.reaction.loader.ReactionLoaderManager;
import com.ss.android.lark.reaction.widget.flowlayout.ReactionFlowLayout;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a extends d {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f439420m = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f439421e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f439422f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ReactionFlowLayout.f f439423g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f439424h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final WeakReference<View> f439425i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f439426j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f439427k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile Drawable f439428l;

    /* JADX INFO: renamed from: com.ss.android.lark.reaction.widget.flowlayout.reaction.a$a, reason: collision with other inner class name */
    public static final class C5269a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f439429a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f439430b;

        public C5269a(a r100, View r101) {
            this.f439429a = r100;
            this.f439430b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            float r101 = this.f439429a.f439424h;
            Object r102 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Float");
            float r103 = r101 * ((Float) r102).floatValue();
            float r104 = this.f439429a.f439427k;
            Object r105 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Float");
            float r106 = r104 * ((Float) r105).floatValue();
            a r107 = this.f439429a;
            int r108 = r107.f439424h;
            float r109 = 2;
            int r110 = r107.f439427k;
            r107.f439428l.setBounds((int) ((r108 - r103) / r109), (int) ((r110 - r106) / r109), (int) ((r108 + r103) / r109), (int) ((r110 + r106) / r109));
            this.f439430b.invalidate();
        }
    }

    public static final class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f439431a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public b(a r100) {
            this.f439431a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            a r101 = this.f439431a;
            r101.f439423g.a(r101.f439422f);
        }
    }

    @Override // com.ss.android.lark.reaction.widget.flowlayout.reaction.ClearCacheDynamicDrawableSpan
    public final Drawable b() {
        return this.f439428l;
    }

    @Override // com.ss.android.lark.reaction.widget.flowlayout.reaction.d
    public final void c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (this.f439426j == false) goto L5;
        ValueAnimator r101 = ValueAnimator.ofFloat(new float[]{1.0f, 0.75f, 1.0f});
        r101.setInterpolator(new AccelerateDecelerateInterpolator());
        r101.setDuration(220);
        r101.addUpdateListener(new C5269a(this, r100));
        r101.addListener(new b(this));
        r101.start();
        return;
    L5:
        this.f439423g.a(this.f439422f);
    }

    public final void d(Drawable r100) {
        if (r100 == null) goto L10;
        this.f439428l = r100;
        int r101 = (this.f439424h * r100.getIntrinsicHeight()) / r100.getIntrinsicWidth();
        this.f439427k = r101;
        r100.setBounds(0, 0, this.f439424h, r101);
        if (this.f439389b == null) goto L6;
        this.f439389b = null;
    L6:
        a();
        View r102 = this.f439425i.get();
        if (r102 == null) goto L11;
        r102.invalidate();
        return;
    L11:
        return;
    }

    /* JADX WARN: Type inference failed for: r10v10, types: [com.ss.android.lark.reaction.widget.flowlayout.reaction.ClickableDrawableSpan$2] */
    public a(Context r100, String r101, ReactionFlowLayout.f r110, int r111, WeakReference r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "mReactionKey");
        Intrinsics.checkNotNullParameter(r110, "mReactionClickListener");
        Intrinsics.checkNotNullParameter(r112, "parentView");
        super(1);
        this.f439421e = r100;
        this.f439422f = r101;
        this.f439423g = r110;
        this.f439424h = r111;
        this.f439425i = r112;
        this.f439426j = r113;
        int r102 = ReactionTextView.f439391p;
        this.f439427k = r102;
        ReactionLoaderManager r114 = ReactionLoaderManager.b.f439153a;
        int r103 = UIUtils.dp2px(r100, k2c.b.b(r101));
        int r104 = UIUtils.dp2px(r100, k2c.b.a(r101));
        if (r103 <= 134) goto L5;
        xsb.b r115 = new xsb.b(r100, r111, r102, r103, r104);
    L6:
        this.f439428l = r115;
        this.f439428l.setBounds(0, 0, r111, this.f439427k);
        Bitmap r105 = ReactionLoaderManager.b(r101, new ClickableDrawableSpan$2(this));
        if (r105 == null) goto L10;
        d(new BitmapDrawable(r100.getResources(), r105));
        return;
    L10:
        return;
    L5:
        r115 = new xsb.b(r100, r111, r102, r104, r104);
        goto L6
    }

    @Override // com.ss.android.lark.reaction.widget.flowlayout.reaction.d, com.ss.android.lark.reaction.widget.flowlayout.reaction.ClearCacheDynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r108, "paint");
        Drawable r109 = this.f439428l;
        Paint.FontMetricsInt r110 = r108.getFontMetricsInt();
        int r111 = ((((r110.descent + r106) + r106) + r110.ascent) / 2) - (r109.getBounds().bottom / 2);
        r100.save();
        r100.translate(r104, r111);
        r109.draw(r100);
        r100.restore();
    }
}
