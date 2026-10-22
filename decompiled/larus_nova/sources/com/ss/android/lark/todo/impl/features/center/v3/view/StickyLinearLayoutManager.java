package com.ss.android.lark.todo.impl.features.center.v3.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u00013B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\n\u0010\rJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0007J\u000e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0005J$\u0010\u001c\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u0005H\u0016J\u001c\u0010\"\u001a\u00020\u00182\n\u0010#\u001a\u00060$R\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010%\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u0005H\u0016J$\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\n\u0010#\u001a\u00060$R\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J$\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00052\n\u0010#\u001a\u00060$R\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0014\u0010*\u001a\u00020\u00182\n\u0010#\u001a\u00060$R\u00020\u001eH\u0016J\u0010\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u001eH\u0016J\u001c\u0010-\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u001e2\n\u0010#\u001a\u00060$R\u00020\u001eH\u0016J\b\u0010.\u001a\u00020\u0018H\u0002J\u0014\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020100H\u0002J\b\u00102\u001a\u00020\u0018H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/view/StickyLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "orientation", "", "reverseLayout", "", "mHeaderProvider", "Lcom/ss/android/lark/todo/impl/features/center/v3/view/AdapterDataProvider;", "<init>", "(Landroid/content/Context;IZLcom/ss/android/lark/todo/impl/features/center/v3/view/AdapterDataProvider;)V", "headerProvider", "(Landroid/content/Context;Lcom/ss/android/lark/todo/impl/features/center/v3/view/AdapterDataProvider;)V", "mHeaderHandler", "Lcom/ss/android/lark/todo/impl/features/center/v3/view/StickyHeaderHandler;", "mHeaderPositions", "", "viewHolderFactory", "Lcom/ss/android/lark/todo/impl/features/center/v3/view/ViewHolderFactory;", "headerElevation", "mHeaderListener", "Lcom/ss/android/lark/todo/impl/features/center/v3/view/StickyLinearLayoutManager$StickyHeaderListener;", "setStickyHeaderListener", "", "listener", "elevateHeaders", "dpElevation", "smoothScrollToPosition", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "position", "onLayoutChildren", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "scrollToPosition", "scrollVerticallyBy", "dy", "scrollHorizontallyBy", "dx", "removeAndRecycleAllViews", "onAttachedToWindow", "view", "onDetachedFromWindow", "resetHeaderHandler", "getVisibleHeaders", "", "Landroid/view/View;", "cacheHeaderPositions", "StickyHeaderListener", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StickyLinearLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.todo.impl.features.center.v3.view.a f441900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a0 f441901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Integer> f441902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e1 f441903d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f441904e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f441905f;

    public interface a {
        void a(RecyclerView.ViewHolder r100);

        void b();

        void c();
    }

    public final Map<Integer, View> p() {
        LinkedHashMap r100 = new LinkedHashMap();
        int r101 = getChildCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L11;
        View r103 = getChildAt(r102);
        if (r103 == null) goto L10;
        int r104 = getPosition(r103);
        List<Integer> r105 = this.f441902c;
        ArrayList r106 = (ArrayList) r105;
        if (r106.contains(Integer.valueOf(r104)) == false) goto L10;
        r100.put(Integer.valueOf(r104), r103);
    L10:
        r102 = r102 + 1;
        goto L3
    L11:
        return r100;
    }

    public final void q() {
        a0 r100 = this.f441901b;
        boolean r101 = true;
        if (r100 == null) goto L5;
        r100.f441990b = getOrientation();
        r100.f441991c = -1;
        r100.f441992d = true;
        ViewParent r102 = r100.f441997i.getParent();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r102).post(new c0(r100, -1));
    L5:
        a0 r103 = this.f441901b;
        if (r103 == null) goto L13;
        int r104 = findFirstVisibleItemPosition();
        Map<Integer, View> r105 = p();
        e1 r106 = this.f441903d;
        if (findFirstCompletelyVisibleItemPosition() == 0) goto L11;
        r101 = false;
    L11:
        r103.d(r104, r105, r106, r101);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onAttachedToWindow(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f441903d = new e1(r100);
        a0 r101 = new a0(r100);
        this.f441901b = r101;
        int r102 = this.f441904e;
        if (r102 == (-1)) goto L5;
        r101.f442000l = r102;
    L6:
        a r103 = this.f441905f;
        if (r103 == null) goto L10;
        Intrinsics.checkNotNullParameter(r103, "listener");
        r101.f441995g = r103;
    L10:
        if (((ArrayList) this.f441902c).size() <= 0) goto L15;
        a0 r104 = this.f441901b;
        if (r104 == null) goto L14;
        r104.f441989a = this.f441902c;
    L14:
        q();
    L15:
        super.onAttachedToWindow(r100);
        return;
    L5:
        r101.f441999k = -1;
        r101.f442000l = -1;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void removeAndRecycleAllViews(RecyclerView.Recycler r100) {
        Intrinsics.checkNotNullParameter(r100, "recycler");
        super.removeAndRecycleAllViews(r100);
        a0 r101 = this.f441901b;
        if (r101 == null) goto L6;
        r101.b(r101.f441991c);
        return;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void scrollToPosition(int r100) {
        super.scrollToPositionWithOffset(r100, 0);
    }

    public StickyLinearLayoutManager(Context r100, TaskListAdapter r101) {
        Intrinsics.checkNotNullParameter(r101, "headerProvider");
        Intrinsics.checkNotNullParameter(r101, "mHeaderProvider");
        super(r100, 1, false);
        this.f441900a = r101;
        this.f441902c = new ArrayList();
        this.f441904e = -1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onDetachedFromWindow(RecyclerView r100, RecyclerView.Recycler r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "recycler");
        a0 r102 = this.f441901b;
        if (r102 == null) goto L5;
        r102.f441997i.getViewTreeObserver().removeOnGlobalLayoutListener(r102.f441998j);
    L5:
        super.onDetachedFromWindow(r100, r101);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r101) {
        Intrinsics.checkNotNullParameter(r100, "recycler");
        Intrinsics.checkNotNullParameter(r101, "state");
        super.onLayoutChildren(r100, r101);
        ((ArrayList) this.f441902c).clear();
        com.ss.android.lark.todo.impl.features.center.v3.view.a r102 = this.f441900a;
        if (r102 == null) goto L5;
        List<?> r103 = r102.G();
    L6:
        if (r103 != null) goto L10;
        a0 r104 = this.f441901b;
        if (r104 == null) goto L28;
        r104.f441989a = this.f441902c;
    L28:
        if (this.f441901b == null) goto L34;
        q();
        return;
    L34:
        return;
    L10:
        int r105 = r103.size();
        int r106 = 0;
    L11:
        if (r106 >= r105) goto L24;
        Object r107 = ListProtector.get(r103, r106);
        if ((r107 instanceof com.ss.android.lark.todo.impl.features.center.v3.data.c) == false) goto L15;
        com.ss.android.lark.todo.impl.features.center.v3.data.c r108 = (com.ss.android.lark.todo.impl.features.center.v3.data.c) r107;
    L16:
        if (r108 == null) goto L20;
        boolean r109 = true;
        if (r108.e() != true) goto L20;
    L21:
        if (r109 == false) goto L23;
        ((ArrayList) this.f441902c).add(Integer.valueOf(r106));
    L23:
        r106 = r106 + 1;
    L20:
        r109 = false;
        goto L21
    L15:
        r108 = null;
        goto L16
    L24:
        a0 r110 = this.f441901b;
        if (r110 == null) goto L28;
        r110.f441989a = this.f441902c;
        goto L28
    L5:
        r103 = null;
        goto L6
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollHorizontallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        Intrinsics.checkNotNullParameter(r101, "recycler");
        Intrinsics.checkNotNullParameter(r102, "state");
        int r103 = super.scrollHorizontallyBy(r100, r101, r102);
        if (Math.abs(r103) <= 0) goto L11;
        a0 r104 = this.f441901b;
        if (r104 == null) goto L11;
        int r105 = findFirstVisibleItemPosition();
        Map<Integer, View> r106 = p();
        e1 r107 = this.f441903d;
        if (findFirstCompletelyVisibleItemPosition() != 0) goto L9;
        boolean r108 = true;
    L10:
        r104.d(r105, r106, r107, r108);
        goto L11
    L9:
        r108 = false;
    L11:
        return r103;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollVerticallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        Intrinsics.checkNotNullParameter(r101, "recycler");
        Intrinsics.checkNotNullParameter(r102, "state");
        int r103 = super.scrollVerticallyBy(r100, r101, r102);
        if (Math.abs(r103) <= 0) goto L11;
        a0 r104 = this.f441901b;
        if (r104 == null) goto L11;
        int r105 = findFirstVisibleItemPosition();
        Map<Integer, View> r106 = p();
        e1 r107 = this.f441903d;
        if (findFirstCompletelyVisibleItemPosition() != 0) goto L9;
        boolean r108 = true;
    L10:
        r104.d(r105, r106, r107, r108);
        goto L11
    L9:
        r108 = false;
    L11:
        return r103;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView r100, RecyclerView.State r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        final Context r103 = r100.getContext();
        LinearSmoothScroller r104 = new StickyLinearLayoutManager$smoothScrollToPosition$smoothScroller$1(r103);
        r104.setTargetPosition(r102);
        startSmoothScroll(r104);
    }
}
