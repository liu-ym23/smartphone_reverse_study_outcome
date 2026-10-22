package com.larus.dora.impl.dynamic.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import c59.e0;
import c59.f0;
import c59.n;
import c59.p;
import c59.t;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.common.CastMonitor;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.android.material.tabs.TabLayout;
import com.larus.dora.impl.dynamic.DoraDynamicListFragment;
import com.larus.dora.impl.dynamic.DoraDynamicPagerAdapter;
import com.larus.dora.impl.dynamic.DslCardAdapter;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import v19.c7;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\t*\u0002#*\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000e\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\bJ\u0010\u00108\u001a\u0002062\b\u00109\u001a\u0004\u0018\u00010:J\u0010\u0010;\u001a\u0002062\b\u00109\u001a\u0004\u0018\u00010<J,\u0010=\u001a\u0002062\u0006\u0010>\u001a\u0002012\u0010\b\u0002\u0010?\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\f2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u000eJ\u001e\u0010B\u001a\u0002062\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0086@¢\u0006\u0002\u0010GJ\u0006\u0010H\u001a\u000206J\u0018\u0010I\u001a\u0002062\u0006\u0010J\u001a\u00020\b2\u0006\u0010K\u001a\u00020\bH\u0014J0\u0010L\u001a\u0002062\u0006\u0010M\u001a\u0002012\u0006\u0010N\u001a\u00020\b2\u0006\u0010O\u001a\u00020\b2\u0006\u0010P\u001a\u00020\b2\u0006\u0010Q\u001a\u00020\bH\u0014J\u0010\u0010R\u001a\u0002012\u0006\u0010S\u001a\u00020TH\u0016J\u0010\u0010U\u001a\u0002012\u0006\u0010S\u001a\u00020TH\u0016J\b\u0010V\u001a\u00020\bH\u0002J(\u0010W\u001a\u0002012\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020Y2\u0006\u0010[\u001a\u00020\b2\u0006\u0010\\\u001a\u00020\bH\u0016J(\u0010]\u001a\u0002062\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020Y2\u0006\u0010[\u001a\u00020\b2\u0006\u0010\\\u001a\u00020\bH\u0016J\u0018\u0010^\u001a\u0002062\u0006\u0010Z\u001a\u00020Y2\u0006\u0010\\\u001a\u00020\bH\u0016J0\u0010_\u001a\u0002062\u0006\u0010Z\u001a\u00020Y2\u0006\u0010`\u001a\u00020\b2\u0006\u0010a\u001a\u00020\b2\u0006\u0010b\u001a\u00020c2\u0006\u0010\\\u001a\u00020\bH\u0016J(\u0010d\u001a\u0002062\u0006\u0010N\u001a\u00020\b2\u0006\u0010O\u001a\u00020\b2\u0006\u0010e\u001a\u00020\b2\u0006\u0010f\u001a\u00020\bH\u0014J8\u0010g\u001a\u0002062\u0006\u0010Z\u001a\u00020Y2\u0006\u0010h\u001a\u00020\b2\u0006\u0010i\u001a\u00020\b2\u0006\u0010j\u001a\u00020\b2\u0006\u0010k\u001a\u00020\b2\u0006\u0010\\\u001a\u00020\bH\u0016R$\u0010\u000b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0010\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$R\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0010\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0004\n\u0002\u0010+R\u0011\u0010,\u001a\u00020-¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001e\u00102\u001a\u0002012\u0006\u00100\u001a\u000201@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u000e\u00104\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006l"}, d2 = {"Lcom/larus/dora/impl/dynamic/widget/NestedDynamicPageView;", "Landroidx/core/widget/NestedScrollView;", "Landroidx/core/view/NestedScrollingParent2;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lastTabConfigList", "", "", "", "", "mDownX", "", "mDownY", "velocityTracker", "Landroid/view/VelocityTracker;", "touchSlop", "contentContainer", "Landroid/widget/LinearLayout;", "getContentContainer", "()Landroid/widget/LinearLayout;", "aboveTabView", "Landroidx/recyclerview/widget/RecyclerView;", "getAboveTabView", "()Landroidx/recyclerview/widget/RecyclerView;", "newcomerGuideWidget", "Lcom/larus/dora/impl/dynamic/widget/NewcomerGuideWidget;", "getNewcomerGuideWidget", "()Lcom/larus/dora/impl/dynamic/widget/NewcomerGuideWidget;", "tabSelectedListener", "com/larus/dora/impl/dynamic/widget/NestedDynamicPageView$tabSelectedListener$1", "Lcom/larus/dora/impl/dynamic/widget/NestedDynamicPageView$tabSelectedListener$1;", "tabView", "Lcom/google/android/material/tabs/TabLayout;", "getTabView", "()Lcom/google/android/material/tabs/TabLayout;", "pageChangeCallback", "com/larus/dora/impl/dynamic/widget/NestedDynamicPageView$pageChangeCallback$1", "Lcom/larus/dora/impl/dynamic/widget/NestedDynamicPageView$pageChangeCallback$1;", "viewPage2", "Landroidx/viewpager2/widget/ViewPager2;", "getViewPage2", "()Landroidx/viewpager2/widget/ViewPager2;", "value", "", "isTabSticky", "()Z", "lastGuideVisible", "onTabSelected", "", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "setAboveAdapter", "adapter", "Lcom/larus/dora/impl/dynamic/DslCardAdapter;", "setPagerAdapter", "Lcom/larus/dora/impl/dynamic/DoraDynamicPagerAdapter;", "showNewcomerGuide", "show", "config", "Lcom/larus/platform/model/NewcomerGuideItem;", "userType", "setPageInfo", "pageInfo", "Lcom/larus/dora/impl/dynamic/dsl/DslDeviceManagementPage;", "connectState", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "(Lcom/larus/dora/impl/dynamic/dsl/DslDeviceManagementPage;Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDestroyView", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "l", "t", "r", "b", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "getHeaderHeight", "onStartNestedScroll", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Landroid/view/View;", PickerReporterConstants.KEY.TARGET, "axes", "type", "onNestedScrollAccepted", "onStopNestedScroll", "onNestedPreScroll", "dx", "dy", "consumed", "", "onScrollChanged", "oldl", "oldt", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NestedDynamicPageView extends NestedScrollView implements NestedScrollingParent2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<? extends Map<String, ? extends Object>> f335482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f335483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f335484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public VelocityTracker f335485d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f335486e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f335487f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RecyclerView f335488g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final NewcomerGuideWidget f335489h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TabLayout f335490i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final NestedDynamicPageView$pageChangeCallback$1 f335491j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ViewPager2 f335492k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f335493l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f335494m;

    public static final class a implements TabLayout.OnTabSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NestedDynamicPageView f335495a;

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public final void onTabReselected(TabLayout.Tab r100) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public final void onTabUnselected(TabLayout.Tab r100) {
        }

        public a(NestedDynamicPageView r100) {
            this.f335495a = r100;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public final void onTabSelected(TabLayout.Tab r100) {
            if (r100 == null) goto L5;
            int r101 = r100.getPosition();
            this.f335495a.f335492k.setCurrentItem(r101);
            return;
        }
    }

    public NestedDynamicPageView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public NestedDynamicPageView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        if ((r102 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final int getHeaderHeight() {
        int r100 = 0;
        if (this.f335488g.getVisibility() == 8) goto L5;
        int r101 = this.f335488g.getMeasuredHeight();
    L7:
        if (this.f335489h.getVisibility() == 8) goto L10;
        r100 = this.f335489h.getMeasuredHeight();
    L10:
        return r101 + r100;
    L5:
        r101 = 0;
        goto L7
    }

    public final RecyclerView getAboveTabView() {
        return this.f335488g;
    }

    public final LinearLayout getContentContainer() {
        return this.f335487f;
    }

    public final NewcomerGuideWidget getNewcomerGuideWidget() {
        return this.f335489h;
    }

    public final TabLayout getTabView() {
        return this.f335490i;
    }

    public final ViewPager2 getViewPage2() {
        return this.f335492k;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = r100.getActionMasked();
        if (r101 != 0) goto L5;
        this.f335483b = r100.getX();
        this.f335484c = r100.getY();
        VelocityTracker r102 = this.f335485d;
        if (r102 == null) goto L27;
        r102.recycle();
    L27:
        VelocityTracker r103 = VelocityTracker.obtain();
        this.f335485d = r103;
        if (r103 == null) goto L31;
        r103.addMovement(r100);
    L31:
        return super.onInterceptTouchEvent(r100);
    L5:
        if (r101 != 1) goto L7;
    L21:
        VelocityTracker r104 = this.f335485d;
        if (r104 == null) goto L31;
        r104.addMovement(r100);
        goto L31
    L7:
        if (r101 != 2) goto L9;
        float r105 = r100.getX() - this.f335483b;
        float r106 = r100.getY() - this.f335484c;
        VelocityTracker r107 = this.f335485d;
        if (r107 == null) goto L15;
        r107.addMovement(r100);
    L15:
        if (Math.abs(r106) <= Math.abs(r105)) goto L31;
        if (Math.abs(r106) <= this.f335486e) goto L31;
        if (this.f335493l == false) goto L31;
        return true;
    L9:
        if (r101 == 3) goto L21;
        goto L21
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = r100.getActionMasked();
        int r102 = -1;
        RecyclerView r103 = null;
        if (r101 != 1) goto L5;
    L34:
        VelocityTracker r104 = this.f335485d;
        if (r104 == null) goto L37;
        r104.addMovement(r100);
    L37:
        VelocityTracker r105 = this.f335485d;
        if (r105 == null) goto L40;
        r105.computeCurrentVelocity(1000);
    L40:
        VelocityTracker r106 = this.f335485d;
        if (r106 == null) goto L43;
        float r107 = r106.getYVelocity();
    L44:
        VelocityTracker r108 = this.f335485d;
        if (r108 == null) goto L47;
        r108.recycle();
    L47:
        this.f335485d = null;
        if (this.f335493l == false) goto L74;
        RecyclerView.Adapter r109 = this.f335492k.getAdapter();
        if ((r109 instanceof DoraDynamicPagerAdapter) == false) goto L52;
        DoraDynamicPagerAdapter r110 = (DoraDynamicPagerAdapter) r109;
    L53:
        if (r110 == null) goto L58;
        DoraDynamicListFragment r111 = r110.y2(this.f335492k.getCurrentItem());
        if (r111 == null) goto L58;
        r103 = r111.f335101f;
    L58:
        if (r107 > 0.0f) goto L61;
        r102 = 1;
    L61:
        if (r103 != null) goto L63;
    L65:
        int r112 = (int) (-r107);
        if (r102 > 0) goto L68;
    L71:
        fling(r112);
    L72:
        return true;
    L68:
        if (r112 <= 1800) goto L70;
        r112 = 1800;
    L70:
        super.onTouchEvent(r100);
        goto L71
    L63:
        if (r103.canScrollVertically(r102) == false) goto L65;
        r103.fling(0, (int) (-r107));
        goto L72
    L52:
        r110 = null;
    L74:
        return super.onTouchEvent(r100);
    L43:
        r107 = 0.0f;
        goto L44
    L5:
        if (r101 != 2) goto L7;
        float r113 = r100.getY() - this.f335484c;
        this.f335483b = r100.getX();
        this.f335484c = r100.getY();
        VelocityTracker r114 = this.f335485d;
        if (r114 == null) goto L13;
        r114.addMovement(r100);
    L13:
        if (this.f335493l == false) goto L74;
        RecyclerView.Adapter r115 = this.f335492k.getAdapter();
        if ((r115 instanceof DoraDynamicPagerAdapter) == false) goto L17;
        DoraDynamicPagerAdapter r116 = (DoraDynamicPagerAdapter) r115;
    L18:
        if (r116 == null) goto L22;
        DoraDynamicListFragment r117 = r116.y2(this.f335492k.getCurrentItem());
        if (r117 == null) goto L22;
        r103 = r117.f335101f;
    L22:
        if (r103 != null) goto L24;
    L30:
        boolean r118 = false;
    L31:
        if (r118 == true) goto L33;
        scrollTo(0, RangesKt.coerceIn(getScrollY() - ((int) r113), 0, getHeaderHeight()));
    L33:
        return true;
    L24:
        if (r113 > 0.0f) goto L28;
        r102 = 1;
    L28:
        if (r103.canScrollVertically(r102) == false) goto L30;
        r103.scrollBy(0, (int) (-r113));
        r118 = true;
        goto L31
    L17:
        r116 = null;
        goto L18
    L7:
        if (r101 == 3) goto L34;
        goto L34
    }

    public final void setAboveAdapter(DslCardAdapter r100) {
        this.f335488g.setAdapter(r100);
    }

    public final void setPagerAdapter(DoraDynamicPagerAdapter r100) {
        this.f335492k.setAdapter(r100);
    }

    @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = View.MeasureSpec.getSize(r100);
        int r103 = View.MeasureSpec.getSize(r101);
        int r104 = 0;
        if (this.f335488g.getVisibility() == 8) goto L5;
        this.f335488g.measure(View.MeasureSpec.makeMeasureSpec(r102, 1073741824), View.MeasureSpec.makeMeasureSpec(r103, Integer.MIN_VALUE));
        int r105 = this.f335488g.getMeasuredHeight();
    L7:
        if (this.f335489h.getVisibility() == 8) goto L9;
        this.f335489h.measure(View.MeasureSpec.makeMeasureSpec(r102, 1073741824), View.MeasureSpec.makeMeasureSpec(r103, Integer.MIN_VALUE));
        r104 = this.f335489h.getMeasuredHeight();
    L9:
        this.f335490i.measure(View.MeasureSpec.makeMeasureSpec(r102, 1073741824), View.MeasureSpec.makeMeasureSpec(r103, Integer.MIN_VALUE));
        this.f335492k.measure(View.MeasureSpec.makeMeasureSpec(r102, 1073741824), View.MeasureSpec.makeMeasureSpec(r103 - this.f335490i.getMeasuredHeight(), 1073741824));
        int r106 = ((r105 + r104) + this.f335490i.getMeasuredHeight()) + this.f335492k.getMeasuredHeight();
        this.f335487f.measure(View.MeasureSpec.makeMeasureSpec(r102, 1073741824), View.MeasureSpec.makeMeasureSpec(r106, 1073741824));
        setMeasuredDimension(r102, r103);
        return;
    L5:
        r105 = 0;
        goto L7
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        super.onStopNestedScroll(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback, com.larus.dora.impl.dynamic.widget.NestedDynamicPageView$pageChangeCallback$1] */
    public NestedDynamicPageView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.f335482a = CollectionsKt.emptyList();
        this.f335486e = ViewConfiguration.get(r110).getScaledTouchSlop();
        LinearLayout r113 = new LinearLayout(r110);
        r113.setOrientation(1);
        r113.setNestedScrollingEnabled(true);
        this.f335487f = r113;
        RecyclerView r100 = new RecyclerView(r110);
        r100.setItemAnimator(null);
        r100.setLayoutManager(new LinearLayoutManager(r110));
        r100.setNestedScrollingEnabled(false);
        r100.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f335488g = r100;
        int r101 = 6;
        NewcomerGuideWidget r102 = new NewcomerGuideWidget(r110, null, r101, 0);
        LinearLayout.LayoutParams r103 = new LinearLayout.LayoutParams(-1, -2);
        int r104 = c7.b(16);
        r103.setMargins(r104, c7.b(8), r104, 0);
        r102.setLayoutParams(r103);
        r102.setVisibility(8);
        this.f335489h = r102;
        a r105 = new a(this);
        TabLayout r106 = new TabLayout(r110);
        r106.setMinimumHeight(c7.b(32));
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(-1, -2);
        int r108 = c7.b(12);
        r107.setMargins(r108, 0, r108, 0);
        r106.setLayoutParams(r107);
        r106.setTabMode(1);
        r106.setTabGravity(0);
        r106.setSelectedTabIndicatorColor(ContextCompat.getColor(r110, v19.c.b(R.attr.larus_neutral_100, r110, R.color.larus_neutral_100)));
        r106.setTabTextColors(ContextCompat.getColor(r110, v19.c.b(R.attr.larus_neutral_50, r110, R.color.larus_neutral_50)), ContextCompat.getColor(r110, v19.c.b(R.attr.larus_neutral_100, r110, R.color.larus_neutral_100)));
        r106.setTabIndicatorFullWidth(true);
        r106.setTabRippleColor(ColorStateList.valueOf(0));
        r106.addOnTabSelectedListener(r105);
        this.f335490i = r106;
        ?? r109 = new NestedDynamicPageView$pageChangeCallback$1(this);
        this.f335491j = r109;
        ViewPager2 r114 = new ViewPager2(r110);
        LinearLayout.LayoutParams r115 = new LinearLayout.LayoutParams(-1, -1);
        r115.topMargin = c7.b(24);
        r114.setLayoutParams(r115);
        r114.setNestedScrollingEnabled(true);
        r114.registerOnPageChangeCallback(r109);
        this.f335492k = r114;
        addView(r113);
        r113.addView(r100);
        r113.addView(r102);
        r113.addView(r106);
        r113.addView(r114);
        setNestedScrollingEnabled(true);
        setOverScrollMode(0);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00a0 -> B:28:0x00a3). Please report as a decompilation issue!!! */
    public final Object e(c59.m r100, e59.b r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof NestedDynamicPageView$setPageInfo$1) == false) goto L7;
        NestedDynamicPageView$setPageInfo$1 r101 = (NestedDynamicPageView$setPageInfo$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        Iterator<e0> r105 = (Iterator) r101.L$0;
        ResultKt.throwOnFailure(r112);
        NestedDynamicPageView r113 = this;
    L28:
        f0 r114 = (f0) r112;
        if (r114 == null) goto L34;
        t r115 = r114.a();
        if (r115 == null) goto L34;
        String r116 = p.b(r115);
        if (r116 == null) goto L34;
    L35:
        TabLayout.Tab r106 = r113.f335490i.newTab();
        View r107 = LayoutInflater.from(r113.getContext()).inflate(R.layout.larus_dora_tab_layout, null);
        ((TextView) r107.findViewById(R.id.text_title)).setText(r116);
        r113.f335490i.addTab(r106.setCustomView(r107));
    L24:
        if (r105.hasNext() == false) goto L37;
        e0 r117 = r105.next();
        CoroutineDispatcher r108 = Dispatchers.getIO();
        NestedDynamicPageView$setPageInfo$2$tabConfig$1 r109 = new NestedDynamicPageView$setPageInfo$2$tabConfig$1(r117, null);
        r101.L$0 = r105;
        r101.label = 1;
        r112 = BuildersKt.withContext(r108, r109, r101);
        if (r112 != r103) goto L28;
        return r103;
    L37:
        int r118 = RangesKt.coerceIn(r113.f335492k.getCurrentItem(), 0, RangesKt.coerceAtLeast(r113.f335490i.getTabCount() - 1, 0));
        if (r113.f335490i.getTabCount() > 0) goto L40;
    L46:
        RecyclerView.Adapter r119 = r113.f335492k.getAdapter();
        if (r119 == null) goto L49;
        int r120 = r119.getItemCount();
    L50:
        int r121 = 0;
    L51:
        if (r121 >= r120) goto L63;
        RecyclerView.Adapter r122 = r113.f335492k.getAdapter();
        if ((r122 instanceof DoraDynamicPagerAdapter) == false) goto L55;
        DoraDynamicPagerAdapter r123 = (DoraDynamicPagerAdapter) r122;
    L56:
        if (r123 == null) goto L62;
        DoraDynamicListFragment r124 = r123.y2(r121);
        if (r124 == null) goto L62;
        RecyclerView r125 = r124.f335101f;
        if (r125 == null) goto L62;
        r125.scrollToPosition(0);
    L62:
        r121 = r121 + 1;
        goto L51
    L55:
        r123 = null;
        goto L56
    L63:
        r113.f335488g.scrollToPosition(0);
        return Unit.INSTANCE;
    L49:
        r120 = 0;
        goto L50
    L40:
        if (r113.f335492k.getCurrentItem() == r118) goto L42;
        r113.f335492k.setCurrentItem(r118, false);
    L42:
        TabLayout.Tab r126 = r113.f335490i.getTabAt(r118);
        if (r126 == null) goto L46;
        r126.select();
    L34:
        r116 = "";
        goto L35
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        n r127 = (n) CollectionsKt.getOrNull(r100.f22518b, !(r110 instanceof e59.b.a) ? 1 : 0);
        if (r127 == null) goto L45;
        List<e0> r128 = r127.f22520b;
        ArrayList r129 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r128, 10));
        Iterator<T> r130 = r128.iterator();
    L18:
        if (r130.hasNext() == false) goto L21;
        r129.add(((e0) r130.next()).f22508a);
        goto L18
    L21:
        if (Intrinsics.areEqual(this.f335482a, r129) == true) goto L36;
        this.f335482a = r129;
        this.f335490i.removeAllTabs();
        r105 = r127.f22520b.iterator();
        r113 = this;
        goto L24
    L36:
        r113 = this;
        goto L37
    L45:
        r113 = this;
    L7:
        r101 = new NestedDynamicPageView$setPageInfo$1(this, r111);
        goto L8
    }

    public /* synthetic */ NestedDynamicPageView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        super.onNestedScrollAccepted(r100, r101, r102, r103);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
        int r104 = getHeaderHeight();
        if (r101 < r104) goto L5;
        boolean r105 = true;
    L6:
        this.f335493l = r105;
        if (r101 <= r104) goto L9;
        setScrollY(r104);
        return;
    L9:
        if (r101 >= 0) goto L13;
        setScrollY(0);
        return;
    L13:
        return;
    L5:
        r105 = false;
        goto L6
    }

    @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        LinearLayout r105 = this.f335487f;
        r105.layout(0, 0, r105.getMeasuredWidth(), this.f335487f.getMeasuredHeight());
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r103, "consumed");
        r103[0] = 0;
        if (this.f335493l == false) goto L5;
        r103[1] = 0;
    L9:
        int r105 = r103[1];
        if (r105 == 0) goto L13;
        scrollBy(0, r105);
        return;
    L13:
        return;
    L5:
        int r106 = getHeaderHeight();
        if (r102 >= 0) goto L8;
        r103[1] = RangesKt.coerceAtLeast(r102, -getScrollY());
        goto L9
    L8:
        r103[1] = RangesKt.coerceAtMost(r102, r106 - getScrollY());
        goto L9
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r100, int r101, int r102, int r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        if (r104 == 0) goto L6;
        int r106 = getHeaderHeight();
        scrollTo(0, RangesKt.coerceIn(getScrollY() + r104, 0, r106));
        return;
    }
}
