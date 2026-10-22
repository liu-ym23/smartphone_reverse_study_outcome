package com.ss.android.ugc.aweme.search.common.result;

import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.ugc.aweme.discover.commodity.stickyheaders.OnLayoutChildrenListener;
import com.ss.android.ugc.aweme.discover.commodity.stickyheaders.handler.StickyHeaderHandler;
import com.ss.android.ugc.aweme.discover.commodity.stickyheaders.handler.ViewHolderFactory;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.ss.android.ugc.aweme.search.common.layoutmanager.ECStickyHeaderPositionsProvider;
import com.ss.android.ugc.aweme.search.common.list.utils.ItemShowReporter;
import com.ss.android.ugc.aweme.search.common.list.utils.PendingTask;
import com.ss.android.ugc.aweme.search.common.result.base.FeedLayoutRenderMetric;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/result/WrapContentStaggeredGridLayoutManager;", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class WrapContentStaggeredGridLayoutManager extends StaggeredGridLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public StickyHeaderHandler f451854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Integer> f451855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f451856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewHolderFactory f451857d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f451858e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WeakReference<Fragment> f451859f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ItemShowReporter f451860g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f451861h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<OnLayoutChildrenListener> f451862i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final FeedLayoutRenderMetric f451863j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ECStickyHeaderPositionsProvider f451864k;

    public final int findFirstCompletelyVisibleItemPosition() {
        return findFirstCompletelyVisibleItemPositions(this.f451856c)[0];
    }

    public final void p() {
        ((ArrayList) this.f451855b).clear();
        ECStickyHeaderPositionsProvider r100 = this.f451864k;
        if (r100 == null) goto L5;
        List<Integer> r101 = r100.a();
    L6:
        if (r101 != null) goto L11;
        StickyHeaderHandler r102 = this.f451854a;
        if (r102 == null) goto L15;
        Intrinsics.checkNotNull(r102);
        r102.f450359e = this.f451855b;
        return;
    L15:
        return;
    L11:
        ArrayList r103 = (ArrayList) this.f451855b;
        r103.addAll(r101);
        StickyHeaderHandler r104 = this.f451854a;
        if (r104 == null) goto L16;
        Intrinsics.checkNotNull(r104);
        r104.f450359e = this.f451855b;
        return;
    L16:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final Map<Integer, View> q() {
        LinkedHashMap r100 = new LinkedHashMap();
        int r101 = getChildCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        View r103 = getChildAt(r102);
        Intrinsics.checkNotNull(r103);
        int r104 = getPosition(r103);
        List<Integer> r105 = this.f451855b;
        ArrayList r106 = (ArrayList) r105;
        if (r106.contains(Integer.valueOf(r104)) == false) goto L7;
        r100.put(Integer.valueOf(r104), r103);
    L7:
        r102 = r102 + 1;
        goto L3
    L8:
        return r100;
    }

    public final void r() {
        StickyHeaderHandler r100 = this.f451854a;
        boolean r101 = true;
        if (r100 == null) goto L5;
        r100.f450361g = -1;
        r100.f450360f = true;
        r100.c();
    L5:
        Logger.a("MisspellDebug", "resetHeaderHandler findFirstVisibleItemPosition = " + findFirstVisibleItemPositions(this.f451856c)[0] + " findFirstCompletelyVisibleItemPosition = " + findFirstCompletelyVisibleItemPosition() + " visibleHeaders = " + q());
        StickyHeaderHandler r102 = this.f451854a;
        if (r102 == null) goto L13;
        int r103 = findFirstVisibleItemPositions(this.f451856c)[0];
        Map<Integer, View> r104 = q();
        ViewHolderFactory r105 = this.f451857d;
        if (findFirstCompletelyVisibleItemPosition() == 0) goto L11;
        r101 = false;
    L11:
        r102.d(r103, r104, r105, r101);
        return;
    }

    public WrapContentStaggeredGridLayoutManager(ECStickyHeaderPositionsProvider r100) {
        super(2, 1);
        this.f451864k = r100;
        this.f451855b = new ArrayList();
        this.f451856c = new int[2];
        this.f451858e = true;
        this.f451860g = new ItemShowReporter(this);
        this.f451862i = new ArrayList();
        this.f451863j = new FeedLayoutRenderMetric();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void addView(View r100) {
        SystemClock.uptimeMillis();
        super.addView(r100);
        if (this.f451863j == null) goto L6;
        SystemClock.uptimeMillis();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void detachAndScrapAttachedViews(RecyclerView.Recycler r100) {
        Intrinsics.checkNotNullParameter(r100, "recycler");
        SystemClock.uptimeMillis();
        super.detachAndScrapAttachedViews(r100);
        if (this.f451863j == null) goto L6;
        SystemClock.uptimeMillis();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onAttachedToWindow(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f451857d = new ViewHolderFactory(r100);
        this.f451860g.f451698a = r100;
        WeakReference<Fragment> r101 = this.f451859f;
        if (r101 == null) goto L5;
        Fragment r102 = r101.get();
    L6:
        StickyHeaderHandler r103 = new StickyHeaderHandler(r100, r102);
        this.f451854a = r103;
        Intrinsics.checkNotNull(r103);
        if (((ArrayList) this.f451855b).size() <= 0) goto L9;
        StickyHeaderHandler r104 = this.f451854a;
        Intrinsics.checkNotNull(r104);
        r104.f450359e = this.f451855b;
        r();
    L9:
        super.onAttachedToWindow(r100);
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutCompleted(RecyclerView.State r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        super.onLayoutCompleted(r100);
        this.f451861h = false;
        Iterator r101 = ((ArrayList) this.f451862i).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((OnLayoutChildrenListener) r101.next()).onLayoutComplete();
        goto L4
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void removeAndRecycleAllViews(RecyclerView.Recycler r100) {
        Intrinsics.checkNotNullParameter(r100, "recycler");
        super.removeAndRecycleAllViews(r100);
        StickyHeaderHandler r101 = this.f451854a;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNull(r101);
        r101.a(r101.f450361g);
        return;
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void scrollToPosition(int r100) {
        super.scrollToPositionWithOffset(r100, 0);
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onDetachedFromWindow(RecyclerView r100, RecyclerView.Recycler r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "recycler");
        StickyHeaderHandler r102 = this.f451854a;
        if (r102 == null) goto L5;
        Intrinsics.checkNotNull(r102);
        r102.f450355a.getViewTreeObserver().removeOnGlobalLayoutListener(r102.f450362h);
    L5:
        ItemShowReporter r103 = this.f451860g;
        r103.getClass();
        StringBuilder r104 = new StringBuilder("clear size = ");
        Map<String, List<PendingTask>> r105 = r103.f451699b;
        if (r105 == null) goto L8;
        Integer r106 = Integer.valueOf(r105.size());
    L9:
        r104.append(r106.intValue());
        Logger.a("ItemShowReporter", r104.toString());
        r103.f451698a = null;
        ((LinkedHashMap) r103.f451699b).clear();
        super.onDetachedFromWindow(r100, r101);
        return;
    L8:
        r106 = null;
        goto L9
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r101) {
        SystemClock.uptimeMillis();     // Catch: Exception -> L12
        super.onLayoutChildren(r100, r101);     // Catch: Exception -> L12
        this.f451860g.b();     // Catch: Exception -> L12
        if (this.f451861h == false) goto L5;
        super.onLayoutChildren(r100, r101);     // Catch: Exception -> L12
    L5:
        p();     // Catch: Exception -> L12
        if (this.f451854a == null) goto L9;
        r();     // Catch: Exception -> L12
    L9:
        if (this.f451863j == null) goto L15;
        SystemClock.uptimeMillis();     // Catch: Exception -> L12
        return;
    L15:
        return;
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollHorizontallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        Intrinsics.checkNotNullParameter(r101, "recycler");
        Intrinsics.checkNotNullParameter(r102, "state");
        int r103 = super.scrollHorizontallyBy(r100, r101, r102);
        if (Math.abs(r103) > 0) goto L5;
    L10:
        return r103;
    L5:
        if (this.f451854a == null) goto L10;
        Logger.a("MisspellDebug", "scrollHorizontallyBy scroll = " + r103 + ", findFirstCompletelyVisibleItemPosition = " + findFirstCompletelyVisibleItemPosition());
        StickyHeaderHandler r104 = this.f451854a;
        Intrinsics.checkNotNull(r104);
        boolean r105 = false;
        int r106 = findFirstVisibleItemPositions(this.f451856c)[0];
        Map<Integer, View> r107 = q();
        ViewHolderFactory r108 = this.f451857d;
        if (findFirstCompletelyVisibleItemPosition() != 0) goto L9;
        r105 = true;
    L9:
        r104.d(r106, r107, r108, r105);
        goto L10
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollVerticallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        Intrinsics.checkNotNullParameter(r101, "recycler");
        Intrinsics.checkNotNullParameter(r102, "state");
        boolean r103 = false;
        if (this.f451858e == true) goto L6;
        Logger.a("MisspellDebug", "scrollVerticallyBy canScroll = " + this.f451858e);
        return 0;
    L6:
        ItemShowReporter r104 = this.f451860g;
        RecyclerView r105 = r104.f451698a;
        if (r105 == null) goto L10;
        r104.a(r105, r100, "onScrollVerticallyBy");
    L10:
        int r106 = super.scrollVerticallyBy(r100, r101, r102);
        Logger.a("MisspellDebug", "scrollVerticallyBy scroll = " + r106);
        if (Math.abs(r106) > 0) goto L13;
    L18:
        return r106;
    L13:
        if (this.f451854a == null) goto L18;
        Logger.a("MisspellDebug", "scrollVerticallyBy findFirstCompletelyVisibleItemPosition = " + findFirstCompletelyVisibleItemPosition());
        StickyHeaderHandler r107 = this.f451854a;
        Intrinsics.checkNotNull(r107);
        int r108 = findFirstVisibleItemPositions(this.f451856c)[0];
        Map<Integer, View> r109 = q();
        ViewHolderFactory r110 = this.f451857d;
        if (findFirstCompletelyVisibleItemPosition() != 0) goto L17;
        r103 = true;
    L17:
        r107.d(r108, r109, r110, r103);
        goto L18
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void layoutDecoratedWithMargins(View r100, int r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        SystemClock.uptimeMillis();
        super.layoutDecoratedWithMargins(r100, r101, r102, r103, r104);
        if (this.f451863j == null) goto L6;
        SystemClock.uptimeMillis();
        return;
    }
}
