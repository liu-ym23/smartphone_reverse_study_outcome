package com.bytedance.ee.bear.bitable.homepage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larksuite.component.ui.imageview.LKUILottieAnimationView;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f212257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f212258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LKUILottieAnimationView f212259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f212260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f212261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f212262f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f212263g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f212264h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f212265i;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.homepage.a$a, reason: collision with other inner class name */
    public static final class C3044a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f212266a;

        public C3044a(a r100) {
            this.f212266a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            a r101 = this.f212266a;
            if (r101.f212264h == true) goto L6;
            r101.a(false);
            return;
        }
    }

    public final void a(boolean r100) {
        LKUILottieAnimationView r101 = this.f212259c;
        if (r100 == false) goto L5;
        int r102 = this.f212261e;
    L6:
        r101.setImageDrawable(UIHelper.getDrawable(r102));
        if (r100 == false) goto L9;
        this.f212259c.clearColorFilter();
        return;
    L9:
        this.f212259c.setColorFilter(UIHelper.getColor(R.color.icon_n2));
        return;
    L5:
        r102 = this.f212262f;
        goto L6
    }

    public final void b(boolean r100, boolean r101, Typeface r102) {
        if (this.f212264h == r100) goto L5;
        boolean r103 = true;
    L6:
        this.f212264h = r100;
        TextView r104 = this.f212258b;
        if (r100 == false) goto L9;
        int r105 = R.color.text_title;
    L10:
        r104.setTextColor(UIHelper.getColor(r105));
        this.f212258b.setTypeface(r102, this.f212264h ? 1 : 0);
        if (r101 == false) goto L20;
        if (r103 == false) goto L20;
        if (r100 == false) goto L15;
        this.f212259c.clearColorFilter();
    L15:
        this.f212259c.setAnimation(this.f212260d);
        LKUILottieAnimationView r106 = this.f212259c;
        if (r100 == false) goto L18;
        float r107 = 1.0f;
    L19:
        r106.setSpeed(r107);
        this.f212259c.playAnimation();
        return;
    L18:
        r107 = -1.0f;
    L20:
        a(r100);
        return;
    L9:
        r105 = R.color.text_caption;
        goto L10
    L5:
        r103 = false;
        goto L6
    }

    public /* synthetic */ a(View r100, TextView r110, LKUILottieAnimationView r111, int r112, int r113, int r114) {
        this(r100, r110, r111, r112, r113, r114, null);
    }

    public a(View r100, TextView r101, LKUILottieAnimationView r102, int r103, int r104, int r105, View r106) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r101, "textView");
        Intrinsics.checkNotNullParameter(r102, "iconView");
        this.f212257a = r100;
        this.f212258b = r101;
        this.f212259c = r102;
        this.f212260d = r103;
        this.f212261e = r104;
        this.f212262f = r105;
        this.f212263g = r106;
        r102.setAnimation(r103);
        r102.addAnimatorListener(new C3044a(this));
        a(false);
    }
}
