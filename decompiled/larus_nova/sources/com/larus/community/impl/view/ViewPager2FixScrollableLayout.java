package com.larus.community.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r29.m;
import r29.n;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 12\u00020\u0001:\u00011B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J2\u0010!\u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010\n2\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0010H\u0002J\"\u0010'\u001a\u00020\u001c2\b\u0010(\u001a\u0004\u0018\u00010\n2\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0013H\u0002J\"\u0010)\u001a\u00020\u001c2\b\u0010(\u001a\u0004\u0018\u00010\n2\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0010H\u0002J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001cH\u0016J\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020+H\u0002R$\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001a\u001a\u0004\b\u001e\u0010\u001f¨\u00062"}, d2 = {"Lcom/larus/community/impl/view/ViewPager2FixScrollableLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ignoreCheckScrollViews", "", "Landroid/view/View;", "getIgnoreCheckScrollViews", "()Ljava/util/List;", "setIgnoreCheckScrollViews", "(Ljava/util/List;)V", "touchSlop", "", "pagingTouchSlop", "initialX", "", "initialY", "parentViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "getParentViewPager", "()Landroidx/viewpager2/widget/ViewPager2;", "parentViewPager$delegate", "Lkotlin/Lazy;", "viewPagerEnableScroll", "", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "getChild", "()Landroid/view/View;", "child$delegate", "existChildCanScroll", BaseSwitches.V, "orientation", "delta", "x", "y", "canScroll", "view", "isTouchPointInView", "requestDisallowInterceptTouchEvent", "", "disallowIntercept", "onInterceptTouchEvent", "e", "Landroid/view/MotionEvent;", BasicTestActionHandler.TEST_ACTION_RESET, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ViewPager2FixScrollableLayout extends FrameLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f329936i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<? extends View> f329937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f329938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f329939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f329940d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f329941e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f329942f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f329943g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f329944h;

    public static final class a {
    }

    static {
    }

    private final View getChild() {
        return (View) this.f329944h.getValue();
    }

    private final ViewPager2 getParentViewPager() {
        return (ViewPager2) this.f329942f.getValue();
    }

    public final List<View> getIgnoreCheckScrollViews() {
        return this.f329937a;
    }

    public ViewPager2FixScrollableLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "e");
        FLogger r100 = FLogger.f375446a;
        r100.d("BF_VP2FixScrollable", "onInterceptTouchEvent: " + r110.getAction());
        ViewPager2 r101 = getParentViewPager();
        if (r101 == null) goto L64;
        int r102 = r101.getOrientation();
        int r103 = r110.getAction() & r110.getActionMasked();
        if (r103 != 1) goto L7;
    L58:
        r100.d("BF_VP2FixScrollable", "action up or cancel, reset");
        this.f329943g = false;
        ViewPager2 r111 = getParentViewPager();
        if (r111 == null) goto L61;
        r111.setUserInputEnabled(true);
    L61:
        ViewParent r112 = getParent();
        if (r112 == null) goto L64;
        r112.requestDisallowInterceptTouchEvent(false);
        goto L64
    L7:
        if (r103 == 3) goto L58;
        if (r103 != 0) goto L10;
    L13:
        int r104 = (int) r110.getRawX();
        int r105 = (int) r110.getRawY();
        if (r110.getAction() != 0) goto L21;
        this.f329940d = r110.getX();
        this.f329941e = r110.getY();
        this.f329943g = false;
        ViewParent r113 = getParent();
        if (r113 == null) goto L18;
        r113.requestDisallowInterceptTouchEvent(true);
    L18:
        r100.d("BF_VP2FixScrollable", "Forbid the parent to intercept the move event");
        return false;
    L21:
        if (r110.getAction() != 2) goto L57;
        if (r102 != 0) goto L24;
        boolean r106 = true;
    L25:
        if (r106 == false) goto L27;
        float r107 = r110.getX();
        float r108 = this.f329940d;
    L28:
        float r109 = r107 - r108;
        if (r106 == false) goto L31;
        float r114 = r110.getY();
        float r115 = this.f329941e;
    L32:
        float r116 = Math.abs(r109);
        float r117 = Math.abs(r114 - r115);
        if (r117 <= this.f329938b) goto L44;
        if (r117 <= (((double) r116) * 0.5d)) goto L57;
        r100.d("BF_VP2FixScrollable", "The sliding angle is not enough, disable this ViewPager, then it will be handled by parent ViewPager");
        ViewPager2 r118 = getParentViewPager();
        if (r118 == null) goto L39;
        r118.setUserInputEnabled(false);
    L39:
        ViewParent r119 = getParent();
        if (r119 == null) goto L42;
        r119.requestDisallowInterceptTouchEvent(false);
    L42:
        return false;
    L44:
        if (r116 <= this.f329939c) goto L57;
        if (a(getChild(), r102, r109, r104, r105) == true) goto L57;
        if ((((double) r116) * 0.5d) <= r117) goto L57;
        r100.d("BF_VP2FixScrollable", "If the sliding distance exceeds the sliding threshold of ViewPager, and the child cannot slide in the sliding direction, then it will be handled by this ViewPager");
        this.f329943g = true;
        ViewPager2 r120 = getParentViewPager();
        if (r120 == null) goto L52;
        r120.setUserInputEnabled(true);
    L52:
        ViewParent r121 = getParent();
        if (r121 == null) goto L55;
        r121.requestDisallowInterceptTouchEvent(false);
    L55:
        return true;
    L31:
        r114 = r110.getX();
        r115 = this.f329940d;
        goto L32
    L27:
        r107 = r110.getY();
        r108 = this.f329941e;
        goto L28
    L24:
        r106 = false;
    L57:
        return super.onInterceptTouchEvent(r110);
    L10:
        if (this.f329943g == false) goto L13;
        r100.d("BF_VP2FixScrollable", "viewPagerEnableScroll is true, fast return");
        return true;
    L64:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r100) {
        if (r100 == true) goto L8;
        super.requestDisallowInterceptTouchEvent(false);
        ViewParent r101 = getParent();
        if (r101 == null) goto L10;
        r101.requestDisallowInterceptTouchEvent(true);
        return;
    L10:
        return;
    L8:
        super.requestDisallowInterceptTouchEvent(true);
    }

    public final void setIgnoreCheckScrollViews(List<? extends View> r100) {
        this.f329937a = r100;
    }

    public ViewPager2FixScrollableLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f329938b = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f329939c = ViewConfiguration.get(r100).getScaledPagingTouchSlop();
        this.f329942f = LazyKt.lazy(new m(this));
        this.f329944h = LazyKt.lazy(new n(this));
    }

    public final boolean a(View r110, int r111, float r112, int r113, int r114) {
        if (r110 != null) goto L5;
        return false;
    L5:
        int[] r100 = new int[2];
        r110.getLocationOnScreen(r100);
        int r101 = r100[0];
        int r102 = r100[1];
        int r103 = r110.getMeasuredWidth() + r101;
        int r104 = r110.getMeasuredHeight() + r102;
        if (r102 > r114) goto L9;
        if (r114 > r104) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == false) goto L17;
        if (r101 > r113) goto L14;
        if (r113 > r103) goto L14;
        boolean r106 = true;
    L15:
        if (r106 == false) goto L17;
        boolean r107 = true;
    L18:
        if (r107 == true) goto L20;
        return false;
    L20:
        int r108 = -((int) Math.signum(r112));
        if (r111 == 0) goto L26;
        if (r111 != 1) goto L25;
        boolean r109 = r110.canScrollVertically(r108);
    L27:
        if (r109 == false) goto L37;
        List<? extends View> r115 = this.f329937a;
        if (r115 != null) goto L31;
    L33:
        boolean r116 = false;
    L34:
        if (r116 == true) goto L37;
        return true;
    L31:
        if (r115.contains(r110) != true) goto L33;
        r116 = true;
    L37:
        if ((r110 instanceof ViewGroup) == false) goto L45;
        ViewGroup r117 = (ViewGroup) r110;
        int r118 = r117.getChildCount() - 1;
    L40:
        if ((-1) >= r118) goto L45;
        if (a(r117.getChildAt(r118), r111, r112, r113, r114) == true) goto L43;
        r118 = r118 - 1;
        goto L40
    L43:
        return true;
    L45:
        return false;
    L25:
        throw new IllegalArgumentException("orientation is not found");
    L26:
        r109 = r110.canScrollHorizontally(r108);
    L14:
        r106 = false;
    L17:
        r107 = false;
    L9:
        r105 = false;
        goto L10
    }
}
