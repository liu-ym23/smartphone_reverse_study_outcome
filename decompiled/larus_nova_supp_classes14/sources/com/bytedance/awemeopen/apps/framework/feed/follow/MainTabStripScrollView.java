package com.bytedance.awemeopen.apps.framework.feed.follow;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.awemeopen.apps.framework.utils.d0;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0003 !\"B\u0011\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aB\u001b\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u0019\u0010\u001dB#\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001fJ\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bR\u001b\u0010\u0013\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0016\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012¨\u0006#"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/follow/MainTabStripScrollView;", "Landroid/widget/HorizontalScrollView;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "leftSpace", "", "setLeftSpace", "Lcom/bytedance/awemeopen/apps/framework/feed/follow/MainTabStripScrollView$OnMainTabStripScrollListener;", "listener", "setOnMainTabStripScrollListener", "", "Landroid/view/View;", "getTabViewList", "Ljava/lang/Runnable;", "q", "Lkotlin/Lazy;", "getMScrollRunnable", "()Ljava/lang/Runnable;", "mScrollRunnable", "s", "getMSelectRunnable", "mSelectRunnable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "OnMainTabStripScrollListener", "b", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class MainTabStripScrollView extends HorizontalScrollView implements ViewPager.OnPageChangeListener, ViewTreeObserver.OnGlobalLayoutListener {
    public float a;
    public final int b;
    public boolean c;
    public long d;
    public int e;
    public DmtViewPager f;
    public List<Integer> g;
    public List<? extends View> h;
    public int i;
    public int j;
    public final b k;
    public int l;
    public int m;
    public float n;
    public final Handler o;
    public int p;
    public final Lazy q;
    public boolean r;
    public final Lazy s;

    public interface OnMainTabStripScrollListener {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/follow/MainTabStripScrollView$OnMainTabStripScrollListener$TouchScrollState;", "", "IDLE", "FLING", "TOUCH_SCROLL", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
        public static final enum TouchScrollState extends Enum<TouchScrollState> {
            public static final TouchScrollState FLING = null;
            public static final TouchScrollState IDLE = null;
            public static final TouchScrollState TOUCH_SCROLL = null;
            public static final /* synthetic */ TouchScrollState[] a = null;

            public static TouchScrollState valueOf(String r1) {
                return (TouchScrollState) r27.a.a(TouchScrollState.class, r1);
            }

            public static TouchScrollState[] values() {
                return (TouchScrollState[]) a.clone();
            }

            static {
                TouchScrollState r0 = new TouchScrollState("IDLE", 0);
                IDLE = r0;
                TouchScrollState r1 = new TouchScrollState("FLING", 1);
                FLING = r1;
                TouchScrollState r3 = new TouchScrollState("TOUCH_SCROLL", 2);
                TOUCH_SCROLL = r3;
                a = new TouchScrollState[]{r0, r1, r3};
            }

            public TouchScrollState(String r1, int r2) {
                super(r1, r2);
            }
        }
    }

    public static final class a {
    }

    public static final class b {
        public int a;
        public int b;

        public b() {
            this(0);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b;
        }

        public final String toString() {
            return "TabSizePair(width=" + this.a + ", left=" + this.b + ')';
        }

        public b(int r1) {
            this.a = 0;
            this.b = 0;
        }
    }

    static {
    }

    public static /* synthetic */ void a(MainTabStripScrollView r0) {
        setLeftSpace$lambda$0(r0);
    }

    public final void c() {
        AoLogger.g("MainTabStripScrollView", new Object[]{"checkMainTabStripScrollListener called"});
        List<? extends View> r1 = this.h;
        if (r1 == null) goto L5;
        int r2 = r1.size();
    L6:
        if (r2 <= 0) goto L38;
        int r4 = this.j;
        if (r4 < 0) goto L10;
        if (r4 >= r2) goto L10;
    L11:
        List<? extends View> r3 = this.h;
        if (r3 == null) goto L39;
        View r5 = (View) ListProtector.get(r3, this.j);
        if (r5 == null) goto L40;
        Object r6 = getParent();
        if (getRight() <= this.l) goto L19;
        this.l = getRight();
    L19:
        if (this.l > 0) goto L23;
        AoLogger.g("MainTabStripScrollView", new Object[]{"checkMainTabStripScrollListener mMaxScrollViewRight lt zero."});
        return;
    L23:
        if ((r5.getLayoutParams() instanceof RelativeLayout.LayoutParams) == false) goto L25;
        ViewGroup.LayoutParams r7 = r5.getLayoutParams();
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        int r8 = ((RelativeLayout.LayoutParams) r7).leftMargin;
    L26:
        int[] r9 = new int[2];
        r5.getLocationOnScreen(r9);
        int[] r10 = new int[2];
        if ((r6 instanceof View) == false) goto L29;
        View r11 = (View) r6;
    L30:
        if (r11 == null) goto L32;
        r11.getLocationOnScreen(r10);
    L32:
        int r12 = ((r9[0] - r10[0]) + r5.getPaddingLeft()) + r8;
        AoLogger.g("MainTabStripScrollView", new Object[]{"checkMainTabStripScrollListener lastTabViewStartX=" + r12 + ", mMaxScrollViewRight=" + this.l});
        if ((this.l - r12) > (r5.getWidth() * 0.33333334f)) goto L35;
        boolean r13 = true;
    L36:
        AoLogger.g("MainTabStripScrollView", new Object[]{"checkMainTabStripScrollListener onLastTabFullyGone=" + r13});
        return;
    L35:
        r13 = false;
        goto L36
    L29:
        r11 = null;
        goto L30
    L25:
        r8 = 0;
        goto L26
    L40:
        return;
    L39:
        return;
    L10:
        this.j = r2 - 1;
        goto L11
    L38:
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public final void setOnMainTabStripScrollListener(OnMainTabStripScrollListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    private final Runnable getMScrollRunnable() {
        return (Runnable) this.q.getValue();
    }

    private final Runnable getMSelectRunnable() {
        return (Runnable) this.s.getValue();
    }

    public final void d() {
        List<Integer> r0 = this.g;
        if (r0 != null) goto L5;
        this.g = new ArrayList();
    L6:
        List<? extends View> r1 = this.h;
        if (r1 == null) goto L14;
        Iterator<T> r2 = r1.iterator();
    L10:
        if (r2.hasNext() == false) goto L14;
        View r3 = (View) r2.next();
        int r4 = (int) (((r3.getLeft() + this.i) + (r3.getWidth() / 2.0f)) + 0.5f);
        List<Integer> r5 = this.g;
        if (r5 == null) goto L10;
        r5.add(Integer.valueOf(r4 - this.b));
    L14:
        AoLogger.g("MainTabStripScrollView", new Object[]{"checkTabStartScrollXList mTabStartScrollXList=" + this.g});
        return;
    L5:
        Intrinsics.checkNotNull(r0);
        r0.clear();
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewTreeObserver r0 = getViewTreeObserver();
        if (r0 == null) goto L6;
        r0.addOnGlobalLayoutListener(this);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewTreeObserver r0 = getViewTreeObserver();
        if (r0 == null) goto L6;
        r0.removeOnGlobalLayoutListener(this);
        return;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (getWidth() > 0) goto L5;
        return;
    L5:
        List<? extends View> r0 = this.h;
        if (r0 == null) goto L16;
        View r1 = (View) CollectionsKt.last(r0);
        if (r1 != null) goto L11;
        return;
    L11:
        if (r1.getWidth() == this.k.a) goto L13;
    L14:
        AoLogger.g("MainTabStripScrollView", new Object[]{"onGlobalLayout measured"});
        d();
        e(this.e);
        c();
        this.k.a = r1.getWidth();
        this.k.b = r1.getLeft();
        return;
    L13:
        if (r1.getLeft() != this.k.b) goto L14;
        return;
    }

    public final List<View> getTabViewList() {
        return this.h;
    }

    public MainTabStripScrollView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public static final /* synthetic */ Runnable b(MainTabStripScrollView r0) {
        return r0.getMScrollRunnable();
    }

    private static final void setLeftSpace$lambda$0(MainTabStripScrollView r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.l = r1.getRight();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        boolean r0 = true;
        if (r5 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L10;
        this.a = r5.getRawX();
    L10:
        if (r5 != null) goto L12;
    L14:
        r0 = false;
    L15:
        if (r0 == false) goto L20;
        if ((r5.getRawX() - this.a) <= 30.0f) goto L20;
        Runnable r1 = getMSelectRunnable();
        com.bytedance.awemeopen.apps.framework.feed.follow.util.b.a().postDelayed(r1, 50);
    L20:
        return super.dispatchTouchEvent(r5);
    L12:
        if (r5.getAction() != 1) goto L14;
    L5:
        if (r5.getAction() != 0) goto L7;
        r2 = true;
        goto L8
    }

    public final void e(int r7) {
        List<? extends View> r0 = this.h;
        if (r0 == null) goto L10;
        if (r7 < 0) goto L11;
        Intrinsics.checkNotNull(r0);
        if (r7 >= r0.size()) goto L12;
        List<? extends View> r1 = this.h;
        Intrinsics.checkNotNull(r1);
        View r2 = (View) ListProtector.get(r1, r7);
        int r3 = ((int) ((r2.getLeft() + this.i) + (r2.getWidth() / 2.0f))) - this.b;
        scrollTo(r3, 0);
        AoLogger.g("MainTabStripScrollView", new Object[]{"scrollToTabFinal position=" + r7 + " newScrollX=" + r3 + " left=" + r2.getLeft() + " leftSpace=" + this.i + " tabWidth=" + r2.getWidth()});
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void onPageScrollStateChanged(int r7) {
        if (r7 != 0) goto L4;
        this.m = -1;
        this.n = -1.0f;
        this.c = false;
        e(this.e);
        return;
    L4:
        if (r7 != 1) goto L6;
        this.c = true;
        long r0 = System.currentTimeMillis();
        if ((r0 - this.d) < 600) goto L14;
        e(this.e);
    L14:
        this.d = r0;
        return;
    L6:
        if (r7 == 2) goto L9;
        return;
    L9:
        if (this.c == true) goto L17;
        e(this.e);
        return;
    }

    public final void onPageSelected(int r3) {
        if (this.r == true) goto L20;
        List<? extends View> r0 = this.h;
        if (r0 == null) goto L18;
        Intrinsics.checkNotNull(r0);
        if (r3 >= r0.size()) goto L18;
        List<? extends View> r1 = this.h;
        d r2 = null;
        if (r1 == null) goto L12;
        View r4 = (View) ListProtector.get(r1, r3);
    L14:
        if ((r4 instanceof d) == false) goto L16;
        r2 = (d) r4;
    L16:
        if (r2 == null) goto L18;
        r2.getCurrentTabId();
        goto L18
    L12:
        r4 = null;
    L18:
        com.bytedance.awemeopen.apps.framework.feed.follow.util.b.a().removeCallbacks(getMSelectRunnable());
        this.r = true;
        return;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r4) {
        if (r4 == null) goto L4;
        Integer r0 = Integer.valueOf(r4.getAction());
    L5:
        if (r0 != null) goto L8;
    L10:
        if (r0 != null) goto L13;
    L16:
        return super.onTouchEvent(r4);
    L13:
        if (r0.intValue() != 1) goto L16;
        this.o.post(getMScrollRunnable());
        goto L16
    L8:
        if (r0.intValue() != 2) goto L10;
        this.o.removeCallbacks(getMScrollRunnable());
        goto L16
    L4:
        r0 = null;
        goto L5
    }

    public final void setLeftSpace(int r2) {
        if (r2 == this.i) goto L6;
        this.i = r2;
        post(new e(this));
        return;
    }

    public MainTabStripScrollView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public MainTabStripScrollView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2, r3, r4);
        this.b = (int) ((d0.d(getContext()) / 2.0f) + 0.5f);
        this.j = -1;
        this.k = new b(0);
        this.m = -1;
        this.n = -1.0f;
        this.o = new Handler();
        this.p = Integer.MAX_VALUE;
        this.q = LazyKt.lazy(new MainTabStripScrollView$mScrollRunnable$2(this));
        this.s = LazyKt.lazy(new MainTabStripScrollView$mSelectRunnable$2(this));
    }

    public final void onPageScrolled(int r8, float r9, int r10) {
        this.e = r8;
        List<? extends View> r11 = this.h;
        boolean r0 = true;
        if (r11 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == false) goto L12;
        return;
    L12:
        if (r9 != 0.0f) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == false) goto L18;
        e(r8);
        return;
    L18:
        if (this.n != (-1.0f)) goto L20;
        boolean r3 = true;
    L21:
        if (r3 == false) goto L23;
    L56:
        this.n = r9;
        this.m = r8;
        return;
    L23:
        if (this.m == (-1)) goto L56;
        int r4 = r8 + 1;
        List<? extends View> r5 = this.h;
        Intrinsics.checkNotNull(r5);
        if (r4 < r5.size()) goto L28;
        r4 = r4 - 1;
    L28:
        List<? extends View> r6 = this.h;
        Intrinsics.checkNotNull(r6);
        if (r8 >= r6.size()) goto L59;
        List<? extends View> r7 = this.h;
        Intrinsics.checkNotNull(r7);
        if (r4 >= r7.size()) goto L62;
        int r13 = this.m;
        if (r8 > r13) goto L44;
        if (r8 == r13) goto L37;
    L39:
        List<? extends View> r14 = this.h;
        Intrinsics.checkNotNull(r14);
        View r15 = (View) ListProtector.get(r14, r8);
        List<Integer> r16 = this.g;
        if (r16 == null) goto L42;
        int r17 = ((Number) ListProtector.get(r16, r4)).intValue();
    L43:
        float r18 = 1.0f - r9;
    L49:
        int r19 = (int) ((((((int) (((r15.getLeft() + this.i) + (r15.getWidth() / 2.0f)) + 0.5f)) - this.b) - r17) * r18) + r17);
        if (r9 == 0.0f) goto L53;
        r0 = false;
    L53:
        if (r0 == true) goto L55;
        scrollTo(r19, 0);
    L55:
        this.n = r9;
        this.m = r8;
        return;
    L42:
        r17 = 0;
        goto L43
    L37:
        if (r9 <= this.n) goto L39;
    L44:
        List<? extends View> r20 = this.h;
        Intrinsics.checkNotNull(r20);
        r15 = (View) ListProtector.get(r20, r4);
        List<Integer> r21 = this.g;
        if (r21 == null) goto L47;
        r17 = ((Number) ListProtector.get(r21, r8)).intValue();
    L48:
        r18 = r9;
        goto L49
    L47:
        r17 = 0;
        goto L48
    L62:
        return;
    L59:
        return;
    L20:
        r3 = false;
        goto L21
    L14:
        r2 = false;
        goto L15
    L5:
        if (r11.isEmpty() == true) goto L8;
        r12 = false;
        goto L9
    }

    @Override // android.view.View
    public final void onScrollChanged(int r1, int r2, int r3, int r4) {
        super.onScrollChanged(r1, r2, r3, r4);
        c();
    }
}
