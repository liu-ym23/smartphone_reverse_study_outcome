package com.bytedance.android.shopping.anchorv4.widgets;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv3.widget.BasePdpRecyclerView;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.common.utility.Logger;
import com.bytedance.services.apm.api.EnsureManager;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002()B'\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010%\u001a\u00020\u0002¢\u0006\u0004\b&\u0010'R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR.\u0010\u0018\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010 \u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u001c¨\u0006*"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/widgets/ECCoordinatorRecyclerView;", "Lcom/bytedance/android/shopping/anchorv3/widget/BasePdpRecyclerView;", "", "c", "Lkotlin/Lazy;", "getWindowHeight", "()I", "windowHeight", "Landroid/view/View;", "f", "Landroid/view/View;", "getSecondaryViewContainer", "()Landroid/view/View;", "setSecondaryViewContainer", "(Landroid/view/View;)V", "secondaryViewContainer", "Landroidx/recyclerview/widget/RecyclerView;", "value", "g", "Landroidx/recyclerview/widget/RecyclerView;", "getSecondaryScrollView", "()Landroidx/recyclerview/widget/RecyclerView;", "setSecondaryScrollView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "secondaryScrollView", "Ljava/lang/reflect/Method;", "r", "getMethodSetScrollState", "()Ljava/lang/reflect/Method;", "methodSetScrollState", "s", "getMethodDispatchOnScrollStateChanged", "methodDispatchOnScrollStateChanged", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECCoordinatorRecyclerView extends BasePdpRecyclerView {
    public final Lazy c;
    public boolean d;
    public boolean e;
    public View f;
    public RecyclerView g;
    public final List<b> h;
    public final int i;
    public final Scroller j;
    public final VelocityTracker k;
    public int l;
    public float m;
    public int n;
    public boolean o;
    public float p;
    public float q;
    public final Lazy r;
    public final Lazy s;

    public static final class a {
    }

    public interface b {
        void b();
    }

    static {
    }

    public ECCoordinatorRecyclerView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECCoordinatorRecyclerView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final Method getMethodDispatchOnScrollStateChanged() {
        return (Method) this.s.getValue();
    }

    private final Method getMethodSetScrollState() {
        return (Method) this.r.getValue();
    }

    private final int getWindowHeight() {
        return ((Number) this.c.getValue()).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void computeScroll() {
        if (this.e == true) goto L6;
        super/*android.view.ViewGroup*/.computeScroll();
    L6:
        if (this.j.computeScrollOffset() == false) goto L14;
        int r0 = this.j.getCurrY() - this.n;
        this.o = true;
        v(r0);     // Catch: Exception -> L10
    L12:
        this.n = this.j.getCurrY();
        invalidate();
        return;
    L10:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L12
    L14:
        if (this.o == false) goto L20;
        y(this, 0);
        y(this.g, 0);
        this.o = false;
        return;
    }

    public final RecyclerView getSecondaryScrollView() {
        return this.g;
    }

    public final View getSecondaryViewContainer() {
        return this.f;
    }

    public final boolean r() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r6) {
        if (r6 == null) goto L4;
        boolean r0 = this.e;
        if (r6.getAction() != 0) goto L9;
        this.e = false;
    L25:
        if (r0 == false) goto L30;
        if (this.e == true) goto L30;
        onInterceptTouchEvent(r6);
    L30:
        if (r6.getAction() != 0) goto L32;
    L33:
        this.p = r6.getX();
        this.q = r6.getY();
        this.m = r6.getY();
        this.l = 0;
        if (this.o == false) goto L38;
        this.j.forceFinished(true);
        this.o = false;
        return true;
    L38:
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r6);
    L32:
        if (r6.getAction() != 5) goto L38;
    L9:
        if (r6.getAction() != 2) goto L25;
        Rect r1 = new Rect();
        getGlobalVisibleRect(r1);
        if ((r1.bottom - r1.top) == getHeight()) goto L13;
    L15:
        boolean r2 = false;
    L16:
        if (r2 == true) goto L18;
    L23:
        boolean r3 = true;
    L24:
        this.e = !r3;
        goto L25
    L18:
        if (r6.getY() > this.m) goto L20;
    L22:
        r3 = false;
        goto L24
    L20:
        if (canScrollVertically(-1) == true) goto L22;
    L13:
        if (isShown() == false) goto L15;
        r2 = true;
        goto L16
    L4:
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r15) {
        if (r15 == null) goto L4;
        int r0 = r15.getAction();
        if (r0 == 0) goto L9;
        if (r0 == 2) goto L9;
        boolean r1 = false;
    L10:
        this.d = r1;
        if (this.e == true) goto L15;
        return super/*androidx.recyclerview.widget.RecyclerView*/.onTouchEvent(r15);
    L15:
        if (this.l != 1) goto L17;
        return true;
    L17:
        int r2 = r15.getAction();
        if (r2 != 0) goto L20;
    L69:
        this.k.clear();
        this.k.addMovement(r15);
        this.o = false;
        return true;
    L20:
        if (r2 == 1) goto L36;
        if (r2 != 2) goto L23;
        float r3 = this.m;
        if (r3 != 0.0f) goto L71;
    L34:
        this.m = r15.getY();
        this.k.addMovement(r15);
        this.o = true;
        return true;
    L71:
        v((int) (r3 - r15.getY()));     // Catch: Exception -> L32
    L32:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L34
    L23:
        if (r2 == 5) goto L69;
        if (r2 == 6) goto L36;
        return super/*androidx.recyclerview.widget.RecyclerView*/.onTouchEvent(r15);
    L36:
        if (this.o == false) goto L75;
        this.k.addMovement(r15);
        this.k.computeCurrentVelocity(1000);
        int r9 = -((int) this.k.getYVelocity());
        if (r9 <= 0) goto L53;
        if (w(this) == false) goto L45;
        if (canScrollVertically(r9) == false) goto L45;
    L63:
        boolean r16 = true;
    L65:
        if (r16 == true) goto L67;
        y(this, 0);
        y(this.g, 0);
    L68:
        this.m = 0.0f;
        return true;
    L67:
        y(this, 2);
        this.n = 0;
        this.j.fling(0, 0, 0, r9, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        post(new com.bytedance.android.shopping.anchorv4.widgets.a(this));
        invalidate();
    L45:
        if (w(this.f) == false) goto L51;
        RecyclerView r17 = this.g;
        if (r17 == null) goto L51;
        if (r17.canScrollVertically(r9) == true) goto L63;
    L51:
        r16 = canScrollVertically(r9);
        goto L65
    L53:
        if (w(this.f) == false) goto L60;
        RecyclerView r18 = this.g;
        if (r18 == null) goto L60;
        if (r18.canScrollVertically(r9) == true) goto L63;
    L60:
        if (w(this) == true) goto L62;
    L64:
        r16 = canScrollVertically(r9);
        goto L65
    L62:
        if (canScrollVertically(r9) == false) goto L64;
    L75:
        return true;
    L9:
        r1 = true;
        goto L10
    L4:
        return super/*androidx.recyclerview.widget.RecyclerView*/.onTouchEvent(r15);
    }

    public final void setSecondaryScrollView(RecyclerView r2) {
        if (r2 == null) goto L4;
        r2.setNestedScrollingEnabled(false);
    L4:
        this.g = r2;
    }

    public final void setSecondaryViewContainer(View r1) {
        this.f = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean t(MotionEvent r7) {
        if (r7 == null) goto L39;
        if (this.e == false) goto L39;
        int r0 = r7.getAction();
        if (r0 != 0) goto L9;
    L36:
        this.p = r7.getX();
        this.q = r7.getY();
        this.m = r7.getY();
        this.l = 0;
        return false;
    L9:
        if (r0 != 2) goto L11;
        this.m = r7.getY();
        int r1 = this.l;
        if (r1 != 2) goto L16;
        return true;
    L16:
        if (r1 != 1) goto L18;
        return false;
    L18:
        if (r1 != 0) goto L33;
        if (Math.abs(this.q - r7.getY()) <= this.i) goto L33;
        View r2 = ViewExtensionsKt.a(this, r7.getRawX(), r7.getRawY());
        if ((Math.abs(this.q - r7.getY()) * 1.2f) <= Math.abs(this.p - r7.getX())) goto L24;
        boolean r8 = true;
    L25:
        if (r8 == false) goto L27;
    L30:
        int r9 = 2;
    L31:
        this.l = r9;
        goto L33
    L27:
        if ((!Intrinsics.areEqual(r2, this)) == true) goto L30;
        r9 = 1;
        goto L31
    L24:
        r8 = false;
    L33:
        if (this.l != 2) goto L40;
        return true;
    L40:
        return false;
    L11:
        if (r0 == 5) goto L36;
        return super.t(r7);
    L39:
        return super.t(r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void v(int r13) {
        if (r13 != 0) goto L4;
        return;
    L4:
        x("dispatchScrollY, dy = " + r13 + ", flagFling = " + this.o);
        Iterator r0 = ((ArrayList) this.h).iterator();
    L6:
        if (r0.hasNext() == false) goto L9;
        ((b) r0.next()).b();
        goto L6
    L9:
        if (this.o == false) goto L11;
        int r1 = 2;
    L13:
        if (r13 <= 0) goto L44;
        if (w(this) == false) goto L20;
        if (canScrollVertically(r13) == false) goto L20;
        scrollBy(0, r13);
        y(this, r1);
        x("dispatchScrollY, dispatch to primaryScrollView, dy = " + r13);
        return;
    L20:
        if (w(this.f) == false) goto L33;
        RecyclerView r9 = this.g;
        if (r9 == null) goto L33;
        if (r9.canScrollVertically(r13) != true) goto L33;
        RecyclerView r2 = this.g;
        if (r2 != null) goto L28;
    L31:
        x("dispatchScrollY, dispatch to secondaryScrollView, dy = " + r13);
        return;
    L28:
        if (r2.getHeight() >= 10) goto L30;
        return;
    L30:
        r2.scrollBy(0, r13);
        y(r2, r1);
    L33:
        if (canScrollVertically(r13) == false) goto L42;
        int r3 = getScrollY();
        scrollBy(0, r13);
        int r4 = r13 - r3;
        if (r4 <= 0) goto L41;
        RecyclerView r7 = this.g;
        if (r7 == null) goto L41;
        if (r7.canScrollVertically(r4) != true) goto L41;
        scrollBy(0, r4);
    L41:
        y(this, r1);
        y(this.g, r1);
        x("dispatchScrollY, dispatch to self, dy = " + r13 + ", remain = " + r4 + ", scrollY = " + getScrollY());
        return;
    L42:
        scrollBy(0, r13);
        y(this, r1);
        x("dispatchScrollY, no target, scrollY = " + getScrollY() + ", maxScrollY = 0, dy = " + r13);
        return;
    L44:
        if (w(this.f) == false) goto L54;
        RecyclerView r10 = this.g;
        if (r10 == null) goto L54;
        if (r10.canScrollVertically(r13) != true) goto L54;
        RecyclerView r5 = this.g;
        if (r5 == null) goto L52;
        r5.scrollBy(0, r13);
        y(r5, r1);
    L52:
        x("dispatchScrollY, dispatch to secondaryScrollView, dy = " + r13 + ", state = " + r1);
        return;
    L54:
        if (w(this) == false) goto L59;
        if (canScrollVertically(r13) == false) goto L59;
        scrollBy(0, r13);
        y(this, r1);
        x("dispatchScrollY, dispatch to primaryScrollView, dy = " + r13 + ", state = " + r1);
        return;
    L59:
        if (canScrollVertically(r13) == false) goto L70;
        int r6 = 0 - getScrollY();
        scrollBy(0, r13);
        int r8 = r6 + r13;
        if (r8 >= 0) goto L69;
        RecyclerView r11 = this.g;
        if (r11 == null) goto L69;
        if (r11.canScrollVertically(r8) != true) goto L69;
        RecyclerView r12 = this.g;
        if (r12 == null) goto L69;
        r12.scrollBy(0, r8);
    L69:
        y(this, r1);
        y(this.g, r1);
        x("dispatchScrollY, dispatch to self, dy = " + r13 + ", remain = " + r8 + ", scrollY = " + getScrollY());
        return;
    L70:
        x("dispatchScrollY, no target, scrollY = " + getScrollY() + ", maxScrollY = 0, dy = " + r13);
        return;
    L11:
        r1 = 1;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean w(View r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        int r1 = r4.getTop();
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == true) goto L8;
        r5 = null;
    L8:
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r5;
        if (r6 == null) goto L11;
        int r7 = r6.topMargin;
    L13:
        if (((r1 - r7) - getPaddingTop()) != getScrollY()) goto L16;
        return true;
    L16:
        return false;
    L11:
        r7 = 0;
        goto L13
    }

    public final void x(String r2) {
        Logger.d("ScrollViewCoordinator", r2);
    }

    public static final boolean u(ECCoordinatorRecyclerView r1, RecyclerView r2) {
        r1.getClass();
        if (r2 == null) goto L8;
        int[] r0 = new int[2];
        r2.getLocationInWindow(r0);
        if (r0[1] >= r1.getWindowHeight()) goto L8;
        return true;
    L8:
        return false;
    }

    public final void y(RecyclerView r6, int r7) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        if (r6 != null) goto L6;
        return;
    L6:
        Method r2 = getMethodSetScrollState();     // Catch: Throwable -> L11
        if (r2 == null) goto L9;
        r2.invoke(r6, new Object[]{Integer.valueOf(r7)});     // Catch: Throwable -> L11
    L9:
        x("setScrollState, target = " + r6 + ", state = " + r7);     // Catch: Throwable -> L11
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L19;
        EnsureManager.ensureNotReachHere("reflect invoke setScrollState failed");
        if (ECAppInfoService.e.isLocalTest() == false) goto L22;
        throw r9;
    L22:
        return;
    L19:
        return;
    L11:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public ECCoordinatorRecyclerView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = LazyKt.lazy(new ECCoordinatorRecyclerView$windowHeight$2(r2));
        setEdgeEffectFactory(new AnonymousClass1(r2));
        addOnScrollListener(new AnonymousClass2(this));
        this.h = new ArrayList();
        this.i = ViewConfiguration.get(r2).getScaledTouchSlop();
        this.j = new Scroller(r2);
        this.k = VelocityTracker.obtain();
        this.r = LazyKt.lazy(ECCoordinatorRecyclerView$methodSetScrollState$2.INSTANCE);
        this.s = LazyKt.lazy(ECCoordinatorRecyclerView$methodDispatchOnScrollStateChanged$2.INSTANCE);
    }

    public /* synthetic */ ECCoordinatorRecyclerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
