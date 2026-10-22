package com.bytedance.android.shopping.orderlist.list.widget.horizontalpull;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import com.bytedance.android.shopping.orderlist.common.monitor.business.OrderCommonBusinessMonitor;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.widgets.touch.CheckViewHelper;
import com.bytedance.android.shopping.orderlist.common.widgets.touch.TouchHelper;
import com.bytedance.android.shopping.orderlist.list.container.OrderListFragment;
import com.bytedance.android.shopping.orderlist.list.viewmodel.OrderListViewModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/widget/horizontalpull/PageHorizontalPullLayout;", "Lcom/bytedance/android/shopping/orderlist/list/widget/horizontalpull/BaseHorizontalPullLayout;", "Lcom/bytedance/android/shopping/orderlist/list/widget/horizontalpull/c;", "listener", "", "setEasyPullListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PageHorizontalPullLayout extends BaseHorizontalPullLayout {
    public static final /* synthetic */ int s = 0;
    public OrderListFragment e;
    public com.bytedance.android.shopping.orderlist.list.container.c f;
    public OrderListViewModel g;
    public float h;
    public float i;
    public float j;
    public final int k;
    public boolean l;
    public Integer m;
    public ValueAnimator n;
    public c o;
    public final VelocityTracker p;
    public final int q;
    public final TouchHelper r;

    public PageHorizontalPullLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PageHorizontalPullLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void d() {
        ValueAnimator r0 = this.n;
        if (r0 != null) goto L5;
    L9:
        e();
        return;
    L5:
        if (r0.isRunning() != true) goto L9;
        ValueAnimator r1 = this.n;
        if (r1 == null) goto L11;
        com.bytedance.android.ec.core.utils.f.a(r1, new PageHorizontalPullLayout$resetUI$1(this));
        return;
    }

    public final void e() {
        Iterator<Map.Entry<View, BaseHorizontalPullLayout.a>> r0 = getChildViews().entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry<View, BaseHorizontalPullLayout.a> r1 = r0.next();
        r1.getKey().setX(r1.getValue().a);
        goto L4
    L6:
        this.h = 0.0f;
        this.i = 0.0f;
    }

    public final boolean c(Integer r10) {
        OrderListViewModel r0 = this.g;
        final com.bytedance.android.shopping.orderlist.list.slice.elements.tab.g r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.shopping.orderlist.list.viewmodel.a r2 = r0.getStaticState();
    L6:
        if (r2 == null) goto L8;
        final Integer r3 = r2.l;
    L9:
        if (r2 == null) goto L11;
        final List<Integer> r4 = r2.n;
    L12:
        if (r4 != null) goto L15;
        r4 = CollectionsKt.emptyList();
    L15:
        if (r3 != null) goto L17;
    L38:
        if (r2 == null) goto L40;
        r1 = r2.h;
    L40:
        if (r10 != null) goto L43;
    L49:
        if (r10 != null) goto L52;
    L58:
        return false;
    L52:
        if (r10.intValue() != 2) goto L58;
        if (r1 != null) goto L55;
    L56:
        Lazy r11 = OrderCommonLog.a;
        OrderCommonLog.a("PageHorizontalPullLayout", new PageHorizontalPullLayout$isNeedInterceptMove$5(r1));
        return true;
    L55:
        if (r1.h == false) goto L58;
    L43:
        if (r10.intValue() != 0) goto L49;
        if (r1 != null) goto L46;
    L47:
        Lazy r12 = OrderCommonLog.a;
        OrderCommonLog.a("PageHorizontalPullLayout", new PageHorizontalPullLayout$isNeedInterceptMove$4(r1));
        return true;
    L46:
        if (r1.g == false) goto L49;
    L17:
        if ((!r4.isEmpty()) == false) goto L38;
        int r5 = r4.indexOf(r3);
        if (r5 >= 0) goto L22;
        Lazy r13 = OrderCommonLog.a;
        OrderCommonLog.a("PageHorizontalPullLayout", new PageHorizontalPullLayout$isNeedInterceptMove$1(r3, r4));
        return true;
    L22:
        if (r10 != null) goto L25;
    L29:
        if (r10 != null) goto L32;
    L37:
        return false;
    L32:
        if (r10.intValue() != 2) goto L37;
        if (r5 != CollectionsKt.getLastIndex(r4)) goto L37;
        Lazy r14 = OrderCommonLog.a;
        OrderCommonLog.a("PageHorizontalPullLayout", new PageHorizontalPullLayout$isNeedInterceptMove$3(r3, r4));
        return true;
    L25:
        if (r10.intValue() != 0) goto L29;
        if (r5 != 0) goto L29;
        Lazy r15 = OrderCommonLog.a;
        OrderCommonLog.a("PageHorizontalPullLayout", new PageHorizontalPullLayout$isNeedInterceptMove$2(r3, r4));
        return true;
    L11:
        r4 = null;
        goto L12
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(final MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "ev");
        CheckViewHelper.b(this, r3);
        if (this.l == false) goto L6;
        return true;
    L6:
        this.r.a(r3, null);
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.a("PageHorizontalPullLayout", new AnonymousClass1(r3));
        return super.dispatchTouchEvent(r3);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r9) {
        Intrinsics.checkNotNullParameter(r9, "ev");
        int r0 = r9.getAction();
        if (r0 != 0) goto L5;
        this.j = r9.getX();
    L33:
        Lazy r10 = OrderCommonLog.a;
        OrderCommonLog.a("PageHorizontalPullLayout", AnonymousClass4.INSTANCE);
        return false;
    L5:
        if (r0 != 2) goto L33;
        if (this.r.c != TouchHelper.TouchIntent.H_MOVING_RIGHT) goto L10;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L20;
        int r2 = CheckViewHelper.a;
        if (CheckViewHelper.a(new Point((int) r9.getRawX(), (int) r9.getRawY()), this, -1) != null) goto L20;
        final boolean r11 = a();
        if (r11 == false) goto L18;
        this.m = 0;
    L18:
        Lazy r3 = OrderCommonLog.a;
        OrderCommonLog.a("PageHorizontalPullLayout", new C03061(r11));
        return r11;
    L20:
        if (this.r.c != TouchHelper.TouchIntent.H_MOVING_LEFT) goto L22;
        boolean r4 = true;
    L23:
        if (r4 == false) goto L30;
        int r5 = CheckViewHelper.a;
        if (CheckViewHelper.a(new Point((int) r9.getRawX(), (int) r9.getRawY()), this, 1) != null) goto L30;
        final boolean r6 = b();
        if (r6 == false) goto L29;
        this.m = 2;
    L29:
        Lazy r12 = OrderCommonLog.a;
        OrderCommonLog.a("PageHorizontalPullLayout", new AnonymousClass2(r6));
        return r6;
    L30:
        this.m = -1;
        Lazy r13 = OrderCommonLog.a;
        OrderCommonLog.a("PageHorizontalPullLayout", AnonymousClass3.INSTANCE);
        return false;
    L22:
        r4 = false;
        goto L23
    L10:
        r1 = false;
        goto L12
    }

    @Override // android.view.View
    public final boolean onTouchEvent(final MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "ev");
        getParent().requestDisallowInterceptTouchEvent(true);
        int r0 = r8.getAction();
        if (r0 == 0) goto L118;
        float r2 = 0.0f;
        if (r0 == 1) goto L75;
        if (r0 != 2) goto L8;
        this.p.addMovement(r8);
        this.i = r8.getX() - this.j;
        if (c(this.m) == true) goto L74;
        Lazy r1 = OrderCommonLog.a;
        OrderCommonLog.a("PageHorizontalPullLayout", PageHorizontalPullLayout$moveByHand$1.INSTANCE);
        Integer r3 = this.m;
        if (r3 != null) goto L17;
    L33:
        if (r3 != null) goto L36;
    L54:
        c r4 = this.o;
        if (r4 == null) goto L57;
        r4.d(this.m, r2);
    L57:
        this.h = r2;
        Integer r5 = this.m;
        if (r5 != null) goto L61;
    L66:
        if (r5 == null) goto L74;
        if (r5.intValue() != 2) goto L74;
        Iterator<Map.Entry<View, BaseHorizontalPullLayout.a>> r6 = getChildViews().entrySet().iterator();
    L72:
        if (r6.hasNext() == false) goto L74;
        Map.Entry<View, BaseHorizontalPullLayout.a> r7 = r6.next();
        r7.getKey().setX(r7.getValue().a + this.i);
        goto L72
    L61:
        if (r5.intValue() != 0) goto L66;
        Iterator<Map.Entry<View, BaseHorizontalPullLayout.a>> r9 = getChildViews().entrySet().iterator();
    L64:
        if (r9.hasNext() == false) goto L74;
        Map.Entry<View, BaseHorizontalPullLayout.a> r10 = r9.next();
        r10.getKey().setX(r10.getValue().a + this.i);
        goto L64
    L36:
        if (r3.intValue() != 2) goto L54;
        float r11 = this.i;
        if (r11 <= 0) goto L41;
        float r12 = 0.0f;
    L44:
        this.i = r12;
        if (r12 == 0.0f) goto L54;
        if ((-getMaxOffsetRight()) < this.i) goto L50;
    L53:
        r2 = 1.0f;
        goto L54
    L50:
        if (getMaxOffsetRight() == 0) goto L53;
        float r13 = this.i;
        int r14 = -getMaxOffsetRight();
    L52:
        r2 = r13 / r14;
        goto L54
    L41:
        if (r11 >= (-getMaxOffsetRight())) goto L43;
        r12 = -getMaxOffsetRight();
        goto L44
    L43:
        r12 = this.i;
        goto L44
    L17:
        if (r3.intValue() != 0) goto L33;
        float r15 = this.i;
        if (r15 >= 0) goto L22;
        float r16 = 0.0f;
    L25:
        this.i = r16;
        if (r16 == 0.0f) goto L54;
        if (getMaxOffsetLeft() <= this.i) goto L53;
        if (getMaxOffsetLeft() == 0) goto L53;
        r13 = this.i;
        r14 = getMaxOffsetLeft();
        goto L52
    L22:
        if (r15 <= getMaxOffsetLeft()) goto L24;
        r16 = getMaxOffsetLeft();
        goto L25
    L24:
        r16 = this.i;
    L74:
        Lazy r17 = OrderCommonLog.a;
        OrderCommonLog.a("PageHorizontalPullLayout", new C03071(r8));
    L119:
        return true;
    L8:
        if (r0 != 3) goto L119;
    L75:
        this.p.addMovement(r8);
        this.p.computeCurrentVelocity(1000);
        Integer r18 = this.m;
        if (r18 != null) goto L79;
    L81:
        if (r18 == null) goto L119;
        if (r18.intValue() != 2) goto L119;
    L85:
        Lazy r19 = OrderCommonLog.a;
        OrderCommonLog.a("PageHorizontalPullLayout", new C03082(r8));
        int r20 = (int) this.p.getXVelocity();
        if (c(this.m) == true) goto L119;
        com.bytedance.android.shopping.orderlist.list.container.c r21 = this.f;
        if (r21 == null) goto L100;
        if (r21.isRequesting() != true) goto L100;
        OrderListFragment r22 = this.e;
        if (r22 == null) goto L100;
        ig3.a r23 = r22.K;
        if (r23 == null) goto L100;
        OrderCommonBusinessMonitor r24 = r23.c;
        if (r24 == null) goto L100;
        r24.b("slideTab");
    L100:
        if (Math.abs(this.i) <= this.k) goto L102;
    L103:
        com.bytedance.android.shopping.orderlist.list.container.c r25 = this.f;
        if (r25 != null) goto L106;
    L117:
        float r26 = this.i;
        ValueAnimator r27 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r27.setDuration(getRollBackDuration());
        r27.addUpdateListener(new f(r27, this.h, this, r26));
        r27.addListener(new g(this));
        Unit r28 = Unit.INSTANCE;
        this.n = r27;
        r27.start();
        goto L119
    L106:
        if (r25.isRequesting() == true) goto L117;
        View r29 = a.a(getChildViews(), 4);
        if (r29 != null) goto L110;
        OrderCommonErrorMonitorKt.b(null, "SERIOUS_BUSINESS_ERROR", "PageHorizontalPullLayout-rollFrontHorizontalRefresh: contentView is null");
        goto L119
    L110:
        float r30 = this.i;
        if (r30 == 0.0f) goto L113;
        Float r31 = Float.valueOf(((r29.getWidth() - Math.abs(r30)) * r30) / Math.abs(r30));
    L114:
        if (r31 != null) goto L116;
        OrderCommonErrorMonitorKt.b(null, "SERIOUS_BUSINESS_ERROR", "PageHorizontalPullLayout-rollFrontHorizontalRefresh: remainOffset is null");
        goto L119
    L116:
        ValueAnimator r32 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r32.setDuration(getRollBackDuration());
        r32.addUpdateListener(new h(r32, this, r30, r31));
        r32.addListener(new i(this));
        Unit r33 = Unit.INSTANCE;
        this.n = r32;
        r32.start();
        goto L119
    L113:
        r31 = null;
        goto L114
    L102:
        if (Math.abs(r20) <= this.q) goto L117;
    L79:
        if (r18.intValue() != 0) goto L81;
    L118:
        this.p.clear();
        this.p.addMovement(r8);
        goto L119
    }

    public final void setEasyPullListener(c r1) {
        this.o = r1;
    }

    public PageHorizontalPullLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.k = com.bytedance.android.shopping.extensions.b.b(90);
        this.m = -1;
        this.p = VelocityTracker.obtain();
        Resources r5 = r2.getResources();
        this.q = (int) (WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()).density * 400.0f);
        this.r = new TouchHelper(r2);
    }

    public /* synthetic */ PageHorizontalPullLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
