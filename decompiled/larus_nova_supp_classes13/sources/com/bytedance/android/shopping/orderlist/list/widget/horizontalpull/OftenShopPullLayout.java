package com.bytedance.android.shopping.orderlist.list.widget.horizontalpull;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.widgets.touch.TouchHelper;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/widget/horizontalpull/OftenShopPullLayout;", "Lcom/bytedance/android/shopping/orderlist/list/widget/horizontalpull/BaseHorizontalPullLayout;", "Lcom/bytedance/android/shopping/orderlist/list/widget/horizontalpull/b;", "listener", "", "setEasyPullListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OftenShopPullLayout extends BaseHorizontalPullLayout {
    public float e;
    public float f;
    public float g;
    public boolean h;
    public Integer i;
    public b j;
    public final TouchHelper k;

    public OftenShopPullLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OftenShopPullLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int r1) {
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(final MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "ev");
        boolean r1 = true;
        if (this.h == false) goto L5;
        return true;
    L5:
        this.k.a(r6, null);
        TouchHelper.TouchIntent r0 = this.k.c;
        if (r0 != TouchHelper.TouchIntent.DOWN_STATE) goto L8;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L13;
        getParent().requestDisallowInterceptTouchEvent(true);
    L37:
        Lazy r3 = OrderCommonLog.a;
        OrderCommonLog.a("OftenShopPullLayout", new AnonymousClass3(r6));
        return super.dispatchTouchEvent(r6);
    L13:
        if (r0 != TouchHelper.TouchIntent.V_MOVING_DOWN) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == false) goto L18;
    L36:
        Lazy r5 = OrderCommonLog.a;
        OrderCommonLog.a("OftenShopPullLayout", AnonymousClass1.INSTANCE);
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L37
    L18:
        if (r0 != TouchHelper.TouchIntent.V_MOVING_UP) goto L20;
        boolean r7 = true;
    L21:
        if (r7 == true) goto L36;
        if (r0 != TouchHelper.TouchIntent.H_MOVING_LEFT) goto L26;
        boolean r8 = true;
    L27:
        if (r8 == true) goto L34;
        if (r0 == TouchHelper.TouchIntent.H_MOVING_RIGHT) goto L32;
        r1 = false;
    L32:
        if (r1 == false) goto L37;
    L34:
        if (a() == false) goto L37;
        Lazy r9 = OrderCommonLog.a;
        OrderCommonLog.a("OftenShopPullLayout", AnonymousClass2.INSTANCE);
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L37
    L26:
        r8 = false;
        goto L27
    L20:
        r7 = false;
        goto L21
    L15:
        r4 = false;
        goto L16
    L8:
        r2 = false;
        goto L10
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(final MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "ev");
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.a("OftenShopPullLayout", new C03011(r6));
        int r1 = r6.getAction();
        if (r1 != 0) goto L5;
        this.g = r6.getX();
    L28:
        OrderCommonLog.a("OftenShopPullLayout", AnonymousClass5.INSTANCE);
        return false;
    L5:
        if (r1 != 2) goto L28;
        TouchHelper.TouchIntent r2 = this.k.c;
        boolean r4 = true;
        if (r2 != TouchHelper.TouchIntent.H_MOVING_RIGHT) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L17;
        final boolean r7 = a();
        if (r7 == false) goto L15;
        this.i = 0;
    L15:
        OrderCommonLog.a("OftenShopPullLayout", new C03022(r7));
        return r7;
    L17:
        if (r2 == TouchHelper.TouchIntent.H_MOVING_LEFT) goto L20;
        r4 = false;
    L20:
        if (r4 == false) goto L25;
        final boolean r5 = b();
        if (r5 == false) goto L24;
        this.i = 2;
    L24:
        OrderCommonLog.a("OftenShopPullLayout", new C03033(r5));
        return r5;
    L25:
        this.i = -1;
        OrderCommonLog.a("OftenShopPullLayout", AnonymousClass4.INSTANCE);
        return false;
    L10:
        r3 = false;
        goto L11
    }

    @Override // android.view.View
    public final boolean onTouchEvent(final MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "ev");
        getParent().requestDisallowInterceptTouchEvent(true);
        int r0 = r8.getAction();
        if (r0 == 1) goto L70;
        if (r0 != 2) goto L6;
        this.f = r8.getX() - this.g;
        Lazy r1 = OrderCommonLog.a;
        OrderCommonLog.a("OftenShopPullLayout", OftenShopPullLayout$moveByHand$1.INSTANCE);
        Integer r2 = this.i;
        float r4 = 0.0f;
        if (r2 != null) goto L12;
    L28:
        if (r2 != null) goto L31;
    L49:
        b r3 = this.j;
        if (r3 == null) goto L52;
        r3.d(r4);
    L52:
        this.e = r4;
        Integer r5 = this.i;
        if (r5 != null) goto L56;
    L61:
        if (r5 != null) goto L64;
    L69:
        Lazy r6 = OrderCommonLog.a;
        OrderCommonLog.a("OftenShopPullLayout", new C03041(r8));
    L81:
        return true;
    L64:
        if (r5.intValue() != 2) goto L69;
        Iterator<Map.Entry<View, BaseHorizontalPullLayout.a>> r7 = getChildViews().entrySet().iterator();
    L67:
        if (r7.hasNext() == false) goto L69;
        Map.Entry<View, BaseHorizontalPullLayout.a> r9 = r7.next();
        r9.getKey().setX(r9.getValue().a + this.f);
        goto L67
    L56:
        if (r5.intValue() != 0) goto L61;
        Iterator<Map.Entry<View, BaseHorizontalPullLayout.a>> r10 = getChildViews().entrySet().iterator();
    L59:
        if (r10.hasNext() == false) goto L69;
        Map.Entry<View, BaseHorizontalPullLayout.a> r11 = r10.next();
        r11.getKey().setX(r11.getValue().a + this.f);
        goto L59
    L31:
        if (r2.intValue() != 2) goto L49;
        float r12 = this.f;
        if (r12 <= 0) goto L36;
        float r13 = 0.0f;
    L39:
        this.f = r13;
        if (r13 == 0.0f) goto L49;
        if ((-getMaxOffsetRight()) < this.f) goto L45;
    L48:
        r4 = 1.0f;
        goto L49
    L45:
        if (getMaxOffsetRight() == 0) goto L48;
        float r14 = this.f;
        int r15 = -getMaxOffsetRight();
    L47:
        r4 = r14 / r15;
        goto L49
    L36:
        if (r12 >= (-getMaxOffsetRight())) goto L38;
        r13 = -getMaxOffsetRight();
        goto L39
    L38:
        r13 = this.f;
        goto L39
    L12:
        if (r2.intValue() != 0) goto L28;
        float r16 = this.f;
        if (r16 >= 0) goto L17;
        float r17 = 0.0f;
    L20:
        this.f = r17;
        if (r17 == 0.0f) goto L49;
        if (getMaxOffsetLeft() <= this.f) goto L48;
        if (getMaxOffsetLeft() == 0) goto L48;
        r14 = this.f;
        r15 = getMaxOffsetLeft();
        goto L47
    L17:
        if (r16 <= getMaxOffsetLeft()) goto L19;
        r17 = getMaxOffsetLeft();
        goto L20
    L19:
        r17 = this.f;
        goto L20
    L6:
        if (r0 != 3) goto L81;
    L70:
        Integer r18 = this.i;
        if (r18 != null) goto L74;
    L76:
        if (r18 == null) goto L81;
        if (r18.intValue() != 2) goto L81;
    L80:
        Lazy r19 = OrderCommonLog.a;
        OrderCommonLog.a("OftenShopPullLayout", new C03052(r8));
        float r20 = this.f;
        ValueAnimator r21 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r21.setDuration(getRollBackDuration());
        r21.addUpdateListener(new d(r21, this.e, this, r20));
        r21.addListener(new e(this));
        r21.start();
        goto L81
    L74:
        if (r18.intValue() != 0) goto L76;
        goto L76
    }

    public final void setEasyPullListener(b r1) {
        this.j = r1;
    }

    public OftenShopPullLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.i = -1;
        this.k = new TouchHelper(r2);
    }

    public /* synthetic */ OftenShopPullLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
