package com.bytedance.locallife.pdp.rv;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.recyclerview.widget.LifeNestedRecyclerView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.locallife.pdp.container.view.GoodsDetailNewBaseLynxView;
import com.bytedance.locallife.pdp.settings.l0;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.trade.goods.entity.PoiTradeSettingEntity;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001)B'\b\u0007\u0012\u0006\u0010#\u001a\u00020\"\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010&\u001a\u00020\u0004¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tR$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R$\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006*"}, d2 = {"Lcom/bytedance/locallife/pdp/rv/NestedParentRecyclerView;", "Landroidx/recyclerview/widget/LifeNestedRecyclerView;", "Landroidx/core/view/NestedScrollingParent3;", "Landroidx/core/view/NestedScrollingParent2;", "", "overScrollMode", "", "setOverScrollMode", "getNestedScrollAxes", "Lcom/bytedance/locallife/pdp/rv/b;", "builder", "setNestedBuilder", "Landroid/view/ViewGroup;", "m", "Landroid/view/ViewGroup;", "getGoodsDetailLynxView", "()Landroid/view/ViewGroup;", "setGoodsDetailLynxView", "(Landroid/view/ViewGroup;)V", "goodsDetailLynxView", "", "p", "Lkotlin/Lazy;", "getFixNestedClickError", "()Z", "fixNestedClickError", "", "q", "Ljava/lang/String;", "getSchema", "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", "schema", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class NestedParentRecyclerView extends LifeNestedRecyclerView implements NestedScrollingParent3, NestedScrollingParent2 {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f261680r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f261681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f261682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f261683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView f261684d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f261685e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f261686f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final NestedScrollingParentHelper f261687g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f261688h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.locallife.pdp.rv.b f261689i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, Set<Integer>> f261690j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f261691k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f261692l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewGroup f261693m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f261694n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f261695o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f261696p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f261697q;

    public static final class a {
    }

    public static final class b implements d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NestedParentRecyclerView f261698a;

        public b(NestedParentRecyclerView r100) {
            this.f261698a = r100;
        }

        @Override // com.bytedance.locallife.pdp.rv.d.a
        public final void a(String r100, JSONObject r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            Intrinsics.checkNotNullParameter(r101, "params");
            NestedParentRecyclerView r103 = this.f261698a;
            if (r103.f261692l == false) goto L19;
            if (r102 >= 0) goto L6;
            return;
        L6:
            Set<Integer> r104 = (Set) ((LinkedHashMap) r103.f261690j).get(r100);
            if (r104 != null) goto L10;
            r104 = new LinkedHashSet();
            this.f261698a.f261690j.put(r100, r104);
        L10:
            if (r104.contains(Integer.valueOf(r102)) == false) goto L19;
            NestedParentRecyclerView r105 = this.f261698a;
            if (r105.f261691k >= 3) goto L22;
            Function3<String, Map<String, String>, String, Unit> r106 = r105.getTrackException();
            if (r106 == null) goto L16;
            r106.invoke("send_log_unexpected_onExposure", MapsKt.mapOf(new Pair[]{TuplesKt.to("eventName", r100), TuplesKt.to("position", String.valueOf(r102)), TuplesKt.to("params", r101.toString())}), null);
        L16:
            this.f261698a.f261691k++;
            return;
        L22:
            return;
        L19:
            if ((this.f261698a.getGoodsDetailLynxView() instanceof GoodsDetailNewBaseLynxView) == false) goto L23;
            ViewGroup r107 = this.f261698a.getGoodsDetailLynxView();
            Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type com.bytedance.locallife.pdp.container.view.GoodsDetailNewBaseLynxView");
            ((GoodsDetailNewBaseLynxView) r107).J0(r100, r101);
            return;
        }
    }

    static {
    }

    public NestedParentRecyclerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public NestedParentRecyclerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final boolean getFixNestedClickError() {
        return ((Boolean) this.f261696p.getValue()).booleanValue();
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f261687g.getNestedScrollAxes();
    }

    public final RecyclerView r() {
        if (this.f261684d != null) goto L28;
        this.f261684d = com.bytedance.locallife.pdp.rv.a.a(this.f261683c);
        PoiTradeSettingEntity r100 = l0.f261737a;
        boolean r101 = true;
        if (r100 == null) goto L9;
        Integer r102 = r100.o0();
        if (r102 == null) goto L9;
        int r103 = r102.intValue();
    L11:
        if (r103 == 1) goto L14;
        r101 = false;
    L14:
        if (r101 == false) goto L24;
        RecyclerView r104 = this.f261684d;
        final StaggeredGridLayoutManager r105 = null;
        if (r104 == null) goto L18;
        RecyclerView.LayoutManager r106 = r104.getLayoutManager();
    L20:
        if ((r106 instanceof StaggeredGridLayoutManager) == false) goto L22;
        r105 = (StaggeredGridLayoutManager) r106;
    L22:
        if (r105 == null) goto L24;
        r105.setGapStrategy(0);
        addOnScrollListener(new NestedParentRecyclerView$findNestedChildRecyclerView$1$1(r105, this));
        goto L24
    L18:
        r106 = null;
    L24:
        RecyclerView r107 = this.f261684d;
        if (r107 == null) goto L28;
        this.f261688h = new d(r107, this.f261689i, new b(this));
    L9:
        r103 = 1;
    L28:
        return this.f261684d;
    }

    public final void t() {
        RecyclerView r100 = r();
        if (r100 == null) goto L5;
        r100.scrollToPosition(0);
    L5:
        this.f261681a = 0.0f;
        this.f261682b = 0;
        int[] r101 = this.f261685e;
        r101[0] = 0;
        r101[1] = 0;
        int[] r102 = this.f261686f;
        r102[0] = 0;
        r102[1] = 0;
    }

    public final ViewGroup getGoodsDetailLynxView() {
        return this.f261693m;
    }

    public final String getSchema() {
        return this.f261697q;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void onChildAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        ViewGroup r101 = com.bytedance.locallife.pdp.rv.a.b(r100);
        this.f261693m = r101;
        if (r101 == null) goto L6;
        this.f261683c = (ViewGroup) r100;
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void onChildDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if (r100 != this.f261683c) goto L6;
        this.f261683c = null;
        this.f261684d = null;
        this.f261693m = null;
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        if (this.f261683c == null) goto L11;
        float r101 = r100.getY();
        ViewGroup r102 = this.f261683c;
        Intrinsics.checkNotNull(r102);
        if (r101 <= r102.getTop()) goto L11;
        float r103 = r100.getY();
        ViewGroup r104 = this.f261683c;
        Intrinsics.checkNotNull(r104);
        if (r103 >= r104.getBottom()) goto L11;
        if (r() == null) goto L11;
        boolean r105 = true;
    L13:
        if (r105 == true) goto L15;
        int r106 = this.f261694n;
        if (r106 == 2) goto L21;
        if (r106 != 1) goto L28;
        return false;
    L28:
        return super.onInterceptTouchEvent(r100);
    L21:
        if ((r100.getY() + computeVerticalScrollOffset()) > this.f261695o) goto L24;
        return false;
    L24:
        return super.onInterceptTouchEvent(r100);
    L15:
        if (getScrollState() != 2) goto L17;
        stopScroll();
    L17:
        return false;
    L11:
        r105 = false;
        goto L13
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onStopNestedScroll(View r100) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        onStopNestedScroll(r100, 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        int r101 = r100.getActionMasked();
        int r102 = 0;
        if (r101 != 0) goto L5;
        this.f261681a = r100.getY();
        this.f261682b = r100.getPointerId(0);
        stopScroll();
    L29:
        return super.onTouchEvent(r100);
    L5:
        if (r101 != 2) goto L7;
        int r103 = r100.findPointerIndex(this.f261682b);
        if (r103 == (-1)) goto L20;
        float r104 = r100.getY(r103);
        if ((!canScrollVertically(1)) == false) goto L26;
        RecyclerView r105 = r();
        if (r105 == null) goto L26;
        int r106 = (int) (this.f261681a - r104);
        this.f261685e[1] = 0;
        int r107 = r105.getScrollY();
        r105.scrollBy(0, r106);
        this.f261685e[1] = r105.getScrollY() - r107;
        int r108 = this.f261685e[1];
    L26:
        this.f261681a = r104;
        goto L29
    L20:
        return super.onTouchEvent(r100);
    L7:
        if (r101 != 5) goto L9;
        int r109 = r100.getActionIndex();
        this.f261681a = r100.getY(r109);
        this.f261682b = r100.getPointerId(r109);
        goto L29
    L9:
        if (r101 != 6) goto L29;
        int r110 = r100.getActionIndex();
        if (r100.getPointerId(r110) != this.f261682b) goto L29;
        if (r110 != 0) goto L15;
        r102 = 1;
    L15:
        this.f261681a = r100.getY(r102);
        this.f261682b = r100.getPointerId(r102);
        goto L29
    }

    public final void setGoodsDetailLynxView(ViewGroup r100) {
        this.f261693m = r100;
    }

    public final void setNestedBuilder(com.bytedance.locallife.pdp.rv.b r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        if (Intrinsics.areEqual(r100, this.f261689i) == false) goto L5;
        return;
    L5:
        this.f261689i = r100;
    }

    @Override // android.view.View
    public void setOverScrollMode(int r100) {
        if (r100 == 2) goto L5;
        return;
    L5:
        addOnScrollListener(new AnonymousClass1(this));
        super.setOverScrollMode(r100);
    }

    public final void setSchema(String r100) {
        this.f261697q = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void smoothScrollToPosition(int r100) {
        t();
        super.smoothScrollToPosition(r100);
    }

    @Override // androidx.recyclerview.widget.LifeNestedRecyclerView
    public final void onFlingEnd(int r100, int r101) {
        super.onFlingEnd(r100, r101);
        if (r101 > 0) goto L5;
        return;
    L5:
        RecyclerView r102 = r();
        if (r102 == null) goto L9;
        r102.fling(0, r101);
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        if (r101 != 0) goto L7;
        if (getScrollState() != 2) goto L7;
    L8:
        stopScroll();
    L9:
        this.f261687g.onStopNestedScroll(r100, r101);
        stopNestedScroll(r101);
        return;
    L7:
        if (getFixNestedClickError() == false) goto L9;
        goto L8
    }

    public NestedParentRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        boolean r103 = false;
        setOverScrollMode(0);
        this.f261685e = new int[2];
        this.f261686f = new int[2];
        this.f261687g = new NestedScrollingParentHelper(this);
        this.f261690j = new LinkedHashMap();
        PoiTradeSettingEntity r104 = l0.f261737a;
        PoiTradeSettingEntity r105 = l0.f261737a;
        if (r105 == null) goto L7;
        Integer r106 = r105.l0();
        if (r106 == null) goto L7;
        int r107 = r106.intValue();
    L8:
        if (r107 != 1) goto L10;
        r103 = true;
    L10:
        this.f261692l = r103;
        this.f261696p = LazyKt.lazy(NestedParentRecyclerView$fixNestedClickError$2.INSTANCE);
        return;
    L7:
        r107 = 1;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r100, float r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        return dispatchNestedPreFling(r101, r102);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScrollAccepted(View r100, View r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        onNestedScrollAccepted(r100, r101, r102, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onStartNestedScroll(View r100, View r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        return onStartNestedScroll(r100, r101, r102, 0);
    }

    public /* synthetic */ NestedParentRecyclerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        if (r103 == true) goto L6;
        dispatchNestedFling(0.0f, r102, true);
        fling(0, (int) r102);
        return true;
    L6:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedPreScroll(View r100, int r101, int r110, int[] r111) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r111, "consumed");
        onNestedPreScroll(r100, r101, r110, r111, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        this.f261687g.onNestedScrollAccepted(r100, r101, r102, r103);
        startNestedScroll(2, r103);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        if ((r102 & 2) == 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L11;
        if (r103 != 0) goto L11;
        if (getScrollState() != 2) goto L11;
        stopScroll();
    L11:
        return r104;
    L5:
        r104 = false;
        goto L6
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r110, "consumed");
        if (dispatchNestedPreScroll(r101, r102, r110, null, r111) == false) goto L5;
        return;
    L5:
        int r103 = 1;
        if (r102 > 0) goto L8;
    L10:
        boolean r104 = false;
    L11:
        if (r104 == false) goto L18;
        int[] r105 = this.f261685e;
        r105[1] = 0;
        doScrollConsumed(0, r102, r105);
        r110[1] = this.f261685e[1];
        if (r111 == 0) goto L16;
        r103 = 2;
    L16:
        updateScrollState(r103);
        return;
    L18:
        return;
    L8:
        if ((!canScrollVertically(1)) == true) goto L10;
        r104 = true;
        goto L11
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScroll(View r100, int r110, int r111, int r112, int r113) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        onNestedScroll(r100, r110, r111, r112, r113, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r110, int r111, int r112, int r113, int r114, int r115) {
        Intrinsics.checkNotNullParameter(r110, PickerReporterConstants.KEY.TARGET);
        onNestedScroll(r110, r111, r112, r113, r114, r115, this.f261686f);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public final void onNestedScroll(View r100, int r110, int r111, int r112, int r113, int r114, int[] r115) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r115, "consumed");
        if (r113 == 0) goto L12;
        int[] r101 = this.f261685e;
        r101[1] = 0;
        doScrollConsumed(0, r113, r101);
        int r102 = this.f261685e[1];
        r115[1] = r115[1] + r102;
        dispatchNestedScroll(0, r102, 0, r113 - r102, null, r114, r115);
        if (r113 >= 0) goto L10;
        if (r114 != 0) goto L11;
        updateScrollState(1);
        return;
    L11:
        return;
    L10:
        return;
    }
}
