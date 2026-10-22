package com.bytedance.android.shopping.deepfeed.weights;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductInfoMarqueeView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedProductInfoMarqueeView extends ConstraintLayout {
    public View a;
    public View b;
    public int c;
    public ValueAnimator d;
    public Runnable e;
    public final Handler f;
    public final long g;
    public final long h;
    public final boolean i;
    public boolean j;

    /* JADX WARN: Multi-variable type inference failed */
    public final void U5() {
        View r0 = this.a;
        if (r0 == null) goto L5;
    L7:
        if (r0 == null) goto L9;
        r0.setTranslationY(0.0f);
    L9:
        View r1 = this.b;
        if (r1 == null) goto L20;
        int r2 = this.c;
        if (r2 <= 0) goto L15;
    L18:
        r1.setTranslationY(r2);
        return;
    L15:
        if (tc3.f.e() == false) goto L17;
        com.bytedance.android.shopping.deepfeed.ui.view.a r3 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r2 = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 20);
        goto L18
    L17:
        com.bytedance.android.shopping.deepfeed.ui.view.a r4 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r2 = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 16);
        goto L18
    L20:
        return;
    L5:
        if (this.b != null) goto L7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        ValueAnimator r0 = this.d;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.d = null;
        Runnable r1 = this.e;
        if (r1 == null) goto L8;
        this.f.removeCallbacks(r1);
    L8:
        this.e = null;
        U5();
    }

    public DeepFeedProductInfoMarqueeView(Context r2) {
        this(r2, null);
    }

    public static boolean T5(View r1) {
        List r2 = com.bytedance.commerce.base.view.b.a(r1);
        if (r2 == null) goto L11;
        Iterator r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L16;
        if (((View) r3.next()).getVisibility() != 0) goto L6;
        return true;
    L16:
        return false;
    L11:
        return false;
    }

    public DeepFeedProductInfoMarqueeView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.f = new Handler(Looper.getMainLooper());
        this.g = 670;
        this.h = 2330;
        this.i = true;
        this.j = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(ConstraintLayout r4, ConstraintLayout r5) {
        if (r4 == null) goto L28;
        if (r5 == null) goto L30;
        removeAllViews();
        this.a = r4;
        this.b = r5;
        ConstraintLayout.LayoutParams r6 = new ConstraintLayout.LayoutParams(-2, -2);
        r6.topToTop = 0;
        if (tc3.f.d() == false) goto L8;
        r6.leftToLeft = 0;
    L9:
        Unit r2 = Unit.INSTANCE;
        addView(r4, r6);
        View r7 = this.b;
        ConstraintLayout.LayoutParams r8 = new ConstraintLayout.LayoutParams(-2, -2);
        r8.topToTop = 0;
        if (tc3.f.d() == false) goto L12;
        r8.leftToLeft = 0;
    L13:
        addView(r7, r8);
        View r9 = this.a;
        if (r9 == null) goto L16;
    L18:
        if (r9 == null) goto L20;
        r9.setTranslationY(0.0f);
    L20:
        View r10 = this.b;
        if (r10 != null) goto L23;
        return;
    L23:
        if (tc3.f.e() == false) goto L25;
        com.bytedance.android.shopping.deepfeed.ui.view.a r11 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        int r12 = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 20);
    L26:
        r10.setTranslationY(r12);
        return;
    L25:
        com.bytedance.android.shopping.deepfeed.ui.view.a r13 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r12 = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 16);
        goto L26
    L16:
        if (this.b != null) goto L18;
        return;
    L12:
        r8.rightToRight = 0;
        goto L13
    L8:
        r6.rightToRight = 0;
        goto L9
    L30:
        return;
    }

    public static Pair S5(List r8, int r9, int r10, int r11) {
        if (r8.isEmpty() == true) goto L5;
        Iterator r12 = r8.iterator();
        int r1 = r10;
        boolean r2 = false;
        int r3 = 0;
    L8:
        if (r12.hasNext() == false) goto L31;
        Object r4 = r12.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        View r6 = (View) r4;
        if (r6.getVisibility() == 8) goto L29;
        r6.measure(View.MeasureSpec.makeMeasureSpec(r9, 0), r11);
        ViewGroup.LayoutParams r13 = r6.getLayoutParams();
        if ((r13 instanceof ViewGroup.MarginLayoutParams) == true) goto L17;
        r13 = null;
    L17:
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r13;
        int r7 = r6.getMeasuredWidth();
        if (r14 == null) goto L20;
        int r15 = r14.leftMargin;
    L21:
        int r16 = r7 + r15;
        if (r14 == null) goto L24;
        int r17 = r14.rightMargin;
    L25:
        int r18 = r16 + r17;
        r1 = r1 + r18;
        if (r1 <= r9) goto L28;
        r6.setVisibility(8);
        r1 = r1 - r18;
        r2 = true;
    L28:
        r10 = r1;
        goto L29
    L24:
        r17 = 0;
        goto L25
    L20:
        r15 = 0;
    L29:
        r3 = r5;
        goto L8
    L31:
        return TuplesKt.to(Integer.valueOf(r10), Boolean.valueOf(r2));
    L5:
        return TuplesKt.to(Integer.valueOf(r10), Boolean.FALSE);
    }
}
