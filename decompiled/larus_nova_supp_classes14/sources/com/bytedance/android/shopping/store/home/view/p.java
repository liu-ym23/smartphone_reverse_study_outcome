package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.store.common.bubble.ECBubbleControllerManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p extends FrameLayout implements com.bytedance.android.ec.store.common.bubble.d {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public TextView d;
    public View e;
    public int f;
    public View g;
    public FrameLayout h;
    public String i;
    public Long j;
    public final LifecycleOwner k;

    public static final class a {
        public final String a;
        public final int b;

        public a(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "content");
            this.a = r2;
            this.b = r3;
        }
    }

    private final int getPaddingContent() {
        return ((Number) this.b.getValue()).intValue();
    }

    private final int getPaddingRoot() {
        return ((Number) this.a.getValue()).intValue();
    }

    private final int getTriangleWidth() {
        return ((Number) this.c.getValue()).intValue();
    }

    public final void b() {
        View r0 = this.g;
        FrameLayout r1 = this.h;
        String r2 = this.i;
        Long r3 = this.j;
        ViewParent r4 = null;
        if (r1 == null) goto L7;
        Context r6 = r1.getContext();
        if (r6 == null) goto L7;
        Context r7 = th.a.e(r6, true);
    L8:
        if (r7 == null) goto L48;
        Point r8 = l0.f(r7);
        if (r8 == null) goto L51;
        if (r0 == null) goto L49;
        int r9 = r0.getWidth();
        if (r2 == null) goto L52;
        int[] r10 = new int[2];
        r0.getLocationInWindow(r10);
        a r5 = new a(r2, r10[0] + (r9 / 2));
        setupInternal(r5);
        int r11 = this.f;
        int r12 = r5.b;
        int r13 = r8.x;
        if (r12 <= (r13 / 2)) goto L19;
        boolean r14 = true;
    L20:
        if (r14 == false) goto L22;
        r12 = r13 - r12;
    L22:
        int r15 = r11 / 2;
        if (r12 > r15) goto L25;
        int r16 = 0;
    L26:
        ViewParent r17 = getParent();
        if ((r17 instanceof ViewGroup) == false) goto L30;
        r4 = r17;
    L30:
        ViewGroup r18 = (ViewGroup) r4;
        if (r18 == null) goto L33;
        r18.removeView(this);
    L33:
        FrameLayout.LayoutParams r19 = new FrameLayout.LayoutParams(-2, -2);
        if (r14 == false) goto L36;
        int r20 = 8388613;
    L37:
        r19.gravity = r20 | 80;
        if (r14 == false) goto L40;
        r19.rightMargin = r16;
    L41:
        r19.bottomMargin = RangesKt.coerceAtLeast((r8.y - l0.e(r7)) - r10[1], 0);
        r1.addView(this, r19);
        this.j = r3;
        final FragmentActivity r21 = l0.c(r7);
        if (r21 == null) goto L53;
        Function0<Unit> r22 = new ECStoreTipsView$popupAbove$1(r21);
        ECBubbleControllerManager.b.a(this.k).d();
        Long r23 = this.j;
        if (r23 == null) goto L50;
        new Handler(Looper.getMainLooper()).postDelayed(new q(this, r22), r23.longValue());
        return;
    L50:
        return;
    L53:
        return;
    L40:
        r19.leftMargin = r16;
        goto L41
    L36:
        r20 = 8388611;
        goto L37
    L25:
        r16 = RangesKt.coerceAtMost(r12 - r15, r13 - r11);
        goto L26
    L19:
        r14 = false;
        goto L20
    L52:
        return;
    L49:
        return;
    L51:
        return;
    L48:
        return;
    L7:
        r7 = null;
        goto L8
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.k;
    }

    private final void setupInternal(a r9) {
        if (this.d == null) goto L5;
        boolean r0 = true;
    L6:
        ViewGroup.LayoutParams r3 = null;
        if (r0 == true) goto L9;
    L13:
        Context r1 = th.a.e(getContext(), true);
        ShoppingAsyncInflater.e.getClass();
        View r2 = com.bytedance.android.ec.opt.asyncInflate.c.a(ShoppingAsyncInflater.a.a(r1), 2131560952, null, 6);
        this.d = (TextView) r2.findViewById(2131371101);
        this.e = r2.findViewById(2131371102);
        addView(r2);
    L14:
        TextView r4 = this.d;
        if (r4 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("text");
    L17:
        int r5 = com.bytedance.android.shopping.extensions.b.b(160);
        Point r6 = l0.f(th.a.e(getContext(), true));
        if (r6 == null) goto L47;
        r4.setText(r9.a);
        GradientDrawable r7 = new GradientDrawable();
        r7.setColor((int) 3845733188L);
        r7.setCornerRadius(com.bytedance.android.ec.core.utils.q.a(8));
        Unit r8 = Unit.INSTANCE;
        int r10 = qc3.a.a;
        Intrinsics.checkNotNullParameter(r4, "$this$setBackgroundCompat");
        r4.setBackground(r7);
        float r11 = r4.getPaint().measureText(r9.a);
        int r12 = (getPaddingRoot() + getPaddingContent()) * 2;
        r5 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(((int) (r11 + 0.5f)) + r12, r12), r6.x);
        View r13 = this.e;
        if (r13 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("triangle");
    L23:
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if ((r14 instanceof LinearLayout.LayoutParams) == false) goto L27;
        r3 = r14;
    L27:
        LinearLayout.LayoutParams r15 = (LinearLayout.LayoutParams) r3;
        if (r15 == null) goto L47;
        int r16 = r9.b;
        int r17 = r6.x;
        if (r16 <= (r17 / 2)) goto L33;
        boolean r18 = true;
    L34:
        if (r18 == false) goto L37;
        r16 = r17 - r16;
    L37:
        if (r16 < (r5 / 2)) goto L39;
        r15.gravity = 1;
        r15.leftMargin = 0;
        r15.rightMargin = 0;
    L43:
        View r19 = this.e;
        if (r19 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("triangle");
    L46:
        r19.requestLayout();
        goto L47
    L39:
        int r20 = RangesKt.coerceAtLeast((r16 - (getTriangleWidth() / 2)) - getPaddingRoot(), 0);
        if (r18 == true) goto L42;
        r15.gravity = 3;
        r15.leftMargin = r20;
        goto L43
    L42:
        r15.gravity = 5;
        r15.rightMargin = r20;
        goto L43
    L33:
        r18 = false;
    L47:
        this.f = r5;
        return;
    L9:
        if (this.e == null) goto L11;
        boolean r21 = true;
    L12:
        if (r21 == true) goto L14;
    L11:
        r21 = false;
        goto L12
    L5:
        r0 = false;
        goto L6
    }

    public p(final Context r3, LifecycleOwner r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        super(r3, null, 0);
        this.k = r4;
        this.a = LazyKt.lazy(new ECStoreTipsView$paddingRoot$2(r3));
        this.b = LazyKt.lazy(new ECStoreTipsView$paddingContent$2(r3));
        this.c = LazyKt.lazy(new ECStoreTipsView$triangleWidth$2(r3));
    }
}
