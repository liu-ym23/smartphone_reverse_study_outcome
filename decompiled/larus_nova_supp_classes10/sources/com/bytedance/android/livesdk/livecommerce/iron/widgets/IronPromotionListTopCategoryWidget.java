package com.bytedance.android.livesdk.livecommerce.iron.widgets;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.flow.CategoryTagFlowLayout;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.j;
import com.bytedance.android.livesdk.livecommerce.utils.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0016B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002J\u001c\u0010\r\u001a\u00020\u00042\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/widgets/IronPromotionListTopCategoryWidget;", "Landroid/widget/FrameLayout;", "", "down", "", "setExpandViewStatus", "enable", "setExpandViewEnable", "isAnchor", "setIsAnchor", "Lkotlin/Function1;", "Landroid/view/View;", "clickListener", "setDisableClickListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "c", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IronPromotionListTopCategoryWidget extends FrameLayout {
    public static final /* synthetic */ int o = 0;
    public final List<TopCategoryView> a;
    public final a b;
    public TopCategoryView c;
    public ei2.a d;
    public final int e;
    public int f;
    public float g;
    public AnimatorSet h;
    public ValueAnimator i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public Function1<? super View, Unit> n;

    public static final class a extends CategoryTagFlowLayout {
        public final /* synthetic */ IronPromotionListTopCategoryWidget k;

        @Override // com.bytedance.android.livesdk.livecommerce.iron.widgets.flow.CategoryTagFlowLayout
        public ei2.a getExpandView() {
            IronPromotionListTopCategoryWidget r0 = this.k;
            if (r0.d != null) goto L5;
            IronPromotionListTopCategoryWidget$createExpandView$view$1 r1 = new IronPromotionListTopCategoryWidget$createExpandView$view$1(r0, r0.getContext());
            int r3 = r0.e;
            ViewGroup.MarginLayoutParams r2 = new ViewGroup.MarginLayoutParams(r3, r3);
            r2.leftMargin = UtilityKotlinExtentionsKt.d(8);
            Unit r4 = Unit.INSTANCE;
            r1.setLayoutParams(r2);
            r1.setBackgroundResource(2131247958);
            r1.setContentDescription("更多分类按钮");
            View r5 = new View(r0.getContext());
            FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(UtilityKotlinExtentionsKt.d(6), UtilityKotlinExtentionsKt.d(3));
            r6.gravity = 17;
            r5.setLayoutParams(r6);
            r5.setBackgroundResource(2131234650);
            r1.addView(r5);
            r1.setType(1);
            int r7 = -UtilityKotlinExtentionsKt.d(6);
            int r8 = UtilityKotlinExtentionsKt.d(8);
            Handler r9 = k.a;
            r1.post(new j(r1, r7, r8));
            r1.setOnClickListener(new com.bytedance.android.livesdk.livecommerce.iron.widgets.g(r0, r1));
            r0.d = r1;
        L5:
            ei2.a r10 = this.k.d;
            Intrinsics.checkNotNull(r10);
            return r10;
        }

        public a(IronPromotionListTopCategoryWidget r1, Context r2) {
            this.k = r1;
            super(r2);
        }
    }

    public static final class b implements View.OnTouchListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r2) {
            return true;
        }
    }

    public static final class c {
    }

    public static final class d implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ IronPromotionListTopCategoryWidget a;

        public d(IronPromotionListTopCategoryWidget r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r1) {
            this.a.invalidate();
        }
    }

    public static final class e implements Animator.AnimatorListener {
        public final /* synthetic */ IronPromotionListTopCategoryWidget a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        public e(IronPromotionListTopCategoryWidget r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.j = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.j = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            IronPromotionListTopCategoryWidget r3 = this.a;
            r3.j = true;
            r3.getClass();
        }
    }

    public static final class f implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ IronPromotionListTopCategoryWidget a;

        public f(IronPromotionListTopCategoryWidget r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r1) {
            this.a.invalidate();
        }
    }

    public static final class g implements Animator.AnimatorListener {
        public final /* synthetic */ IronPromotionListTopCategoryWidget a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        public g(IronPromotionListTopCategoryWidget r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.j = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            IronPromotionListTopCategoryWidget r3 = this.a;
            r3.l = false;
            r3.j = false;
            r3.getClass();
            this.a.requestLayout();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.j = true;
        }
    }

    static {
    }

    public IronPromotionListTopCategoryWidget(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public IronPromotionListTopCategoryWidget(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a() {
        if (this.j == false) goto L5;
        return;
    L5:
        if (this.l == false) goto L7;
        return;
    L7:
        if (getVisibility() != 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L63;
        AnimatorSet r1 = this.h;
        if (r1 == null) goto L15;
        r1.cancel();
    L15:
        AnimatorSet r2 = new AnimatorSet();
        ValueAnimator r4 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r4.setDuration(200);
        r4.addUpdateListener(new d(this));
        Unit r5 = Unit.INSTANCE;
        this.i = r4;
        AnimatorSet.Builder r6 = r2.play(r4);
        List r7 = com.bytedance.commerce.base.view.b.a(this.b);
        ArrayList r8 = new ArrayList();
        Iterator r9 = r7.iterator();
    L17:
        if (r9.hasNext() == false) goto L21;
        Object r10 = r9.next();
        if ((r10 instanceof ei2.a) == false) goto L17;
        r8.add(r10);
        goto L17
    L21:
        ArrayList r11 = new ArrayList();
        Iterator r12 = r8.iterator();
    L22:
        View r13 = null;
        if (r12.hasNext() == false) goto L40;
        Object r14 = r12.next();
        View r15 = ((ei2.a) r14).getTagView();
        if ((r15 instanceof TopCategoryView) == false) goto L28;
        r13 = r15;
    L28:
        TopCategoryView r16 = (TopCategoryView) r13;
        if (r16 == null) goto L33;
        PromotionCategory r17 = r16.getCurrentCategory();
        if (r17 == null) goto L33;
        int r18 = r17.getTabRow();
    L34:
        if (r18 == 1) goto L36;
        boolean r19 = true;
    L37:
        if (r19 == false) goto L22;
        r11.add(r14);
        goto L22
    L36:
        r19 = false;
    L33:
        r18 = 1;
        goto L34
    L40:
        if ((!r11.isEmpty()) == true) goto L43;
        r11 = null;
    L43:
        if (r11 == null) goto L48;
        Iterator r20 = r11.iterator();
    L46:
        if (r20.hasNext() == false) goto L48;
        r6.after(ObjectAnimator.ofFloat((ei2.a) r20.next(), "alpha", new float[]{0.0f, 1.0f}).setDuration(160));
    L48:
        r2.addListener(new e(this));
        this.l = true;
        this.k = true;
        requestLayout();
        r2.setInterpolator(new DecelerateInterpolator());
        setExpandViewStatus(false);
        r2.start();
        Unit r3 = Unit.INSTANCE;
        this.h = r2;
        return;
    L63:
        return;
    L9:
        r0 = false;
        goto L10
    }

    public final void b() {
        if (this.j == false) goto L5;
        return;
    L5:
        if (this.l == true) goto L7;
        return;
    L7:
        if (getVisibility() != 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L63;
        AnimatorSet r1 = this.h;
        if (r1 == null) goto L15;
        r1.cancel();
    L15:
        AnimatorSet r2 = new AnimatorSet();
        ValueAnimator r4 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r4.setDuration(200);
        r4.addUpdateListener(new f(this));
        Unit r5 = Unit.INSTANCE;
        this.i = r4;
        AnimatorSet.Builder r6 = r2.play(r4);
        List r7 = com.bytedance.commerce.base.view.b.a(this.b);
        ArrayList r8 = new ArrayList();
        Iterator r9 = r7.iterator();
    L17:
        if (r9.hasNext() == false) goto L21;
        Object r10 = r9.next();
        if ((r10 instanceof ei2.a) == false) goto L17;
        r8.add(r10);
        goto L17
    L21:
        ArrayList r11 = new ArrayList();
        Iterator r12 = r8.iterator();
    L22:
        View r13 = null;
        if (r12.hasNext() == false) goto L40;
        Object r14 = r12.next();
        View r15 = ((ei2.a) r14).getTagView();
        if ((r15 instanceof TopCategoryView) == false) goto L28;
        r13 = r15;
    L28:
        TopCategoryView r16 = (TopCategoryView) r13;
        if (r16 == null) goto L33;
        PromotionCategory r17 = r16.getCurrentCategory();
        if (r17 == null) goto L33;
        int r18 = r17.getTabRow();
    L34:
        if (r18 == 1) goto L36;
        boolean r19 = true;
    L37:
        if (r19 == false) goto L22;
        r11.add(r14);
        goto L22
    L36:
        r19 = false;
    L33:
        r18 = 1;
        goto L34
    L40:
        if ((!r11.isEmpty()) == true) goto L43;
        r11 = null;
    L43:
        if (r11 == null) goto L48;
        Iterator r20 = r11.iterator();
    L46:
        if (r20.hasNext() == false) goto L48;
        r6.with(ObjectAnimator.ofFloat((ei2.a) r20.next(), "alpha", new float[]{1.0f, 0.0f}).setDuration(160));
    L48:
        r2.addListener(new g(this));
        this.l = true;
        this.k = false;
        r2.setInterpolator(new DecelerateInterpolator());
        setExpandViewStatus(true);
        r2.start();
        Unit r3 = Unit.INSTANCE;
        this.h = r2;
        return;
    L63:
        return;
    L9:
        r0 = false;
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ((ArrayList) this.a).clear();
    }

    private final void setExpandViewEnable(boolean r4) {
        ei2.a r0 = this.d;
        if (r0 != null) goto L5;
    L15:
        if (r4 == false) goto L17;
        int r5 = 2131247958;
    L18:
        ei2.a r1 = this.d;
        if (r1 == null) goto L22;
        r1.setBackgroundResource(r5);
        return;
    L22:
        return;
    L17:
        r5 = 2131247953;
        goto L18
    L5:
        if (getChildCount() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L15;
        View r3 = r0.getChildAt(0);
        if (r3 == null) goto L15;
        r3.setEnabled(r4);
        goto L15
    L7:
        r2 = false;
        goto L8
    }

    private final void setExpandViewStatus(boolean r4) {
        ei2.a r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (getChildCount() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L20;
        View r2 = r0.getChildAt(0);
        if (r2 == null) goto L21;
        if (r4 == false) goto L16;
        int r5 = 2131234650;
    L17:
        r2.setBackgroundResource(r5);
        return;
    L16:
        r5 = 2131234651;
        goto L17
    L21:
        return;
    L20:
        return;
    L7:
        r1 = false;
        goto L8
    }

    @Override // android.view.View
    public final void draw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        r6.save();
        if (this.j == false) goto L13;
        ValueAnimator r0 = this.i;
        if (r0 == null) goto L7;
        float r1 = r0.getAnimatedFraction();
    L9:
        if (this.k == false) goto L11;
        r6.clipRect(0.0f, 0.0f, getWidth(), this.g + (r1 * (getHeight() - this.g)));
    L17:
        super.draw(r6);
        r6.restore();
        return;
    L11:
        r6.clipRect(0.0f, 0.0f, getWidth(), getHeight() - (r1 * (getHeight() - this.g)));
        goto L17
    L7:
        r1 = 0.0f;
        goto L9
    L13:
        if (this.l == false) goto L15;
        float r2 = getHeight();
    L16:
        r6.clipRect(0.0f, 0.0f, getWidth(), r2);
        goto L17
    L15:
        r2 = this.g;
        goto L16
    }

    public final void setDisableClickListener(Function1<? super View, Unit> r1) {
        this.n = r1;
    }

    public final void setIsAnchor(boolean r1) {
        this.m = r1;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r2, int r3) {
        super.onMeasure(r2, r3);
        if (this.l == true) goto L5;
        int r4 = (this.e + getPaddingTop()) + getPaddingBottom();
        this.f = r4;
        this.g = r4 - (getPaddingBottom() / 2);
        setMeasuredDimension(getMeasuredWidth(), this.f);
        return;
    L5:
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight() + UtilityKotlinExtentionsKt.d(8));
    }

    public IronPromotionListTopCategoryWidget(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.a = new ArrayList();
        this.e = UtilityKotlinExtentionsKt.d(26) + 2;
        a r8 = new a(this, r5);
        this.b = r8;
        addView(r8);
        setOnTouchListener(b.a);
        int r9 = 0;
        int r10 = 0;
    L4:
        if (r10 >= 15) goto L6;
        List<TopCategoryView> r0 = this.a;
        ArrayList r1 = (ArrayList) r0;
        r1.add(new TopCategoryView(r5, null, 6, r9));
        r10 = r10 + 1;
        goto L4
    }

    public /* synthetic */ IronPromotionListTopCategoryWidget(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
