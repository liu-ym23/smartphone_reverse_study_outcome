package com.bytedance.ee.bear.drive.core.thumbnail;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.core.util.SparseArrayKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\b\b\u0018\u0000 q2\u00020\u0001:\u0005qrstuB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u001a2\u0006\u00100\u001a\u00020\u0005J\u000e\u00101\u001a\u00020.2\u0006\u00102\u001a\u00020\u0005J\u0006\u00103\u001a\u00020.J\u0010\u00104\u001a\u00020.2\b\u00105\u001a\u0004\u0018\u00010 J\u0010\u00106\u001a\u00020.2\b\u00107\u001a\u0004\u0018\u00010\"J\u0006\u00108\u001a\u00020\u0005J \u0010>\u001a\u00020.2\u0006\u0010/\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u0005H\u0016J \u0010A\u001a\u00020.2\u0006\u0010/\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u0005H\u0016J\u0010\u0010B\u001a\u00020.2\u0006\u0010/\u001a\u00020\u001aH\u0016J\u001c\u0010C\u001a\u00020.2\n\u0010#\u001a\u00060$R\u00020\u001a2\u0006\u0010%\u001a\u00020&H\u0016J$\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u00052\n\u0010#\u001a\u00060$R\u00020\u001a2\u0006\u0010%\u001a\u00020&H\u0016J$\u0010F\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u00052\n\u0010#\u001a\u00060$R\u00020\u001a2\u0006\u0010%\u001a\u00020&H\u0016J\u001c\u0010H\u001a\u00020.2\n\u0010#\u001a\u00060$R\u00020\u001a2\u0006\u0010%\u001a\u00020&H\u0002J4\u0010I\u001a\u00020.2\n\u0010#\u001a\u00060$R\u00020\u001a2\u0006\u0010%\u001a\u00020&2\u0006\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u0005H\u0002J4\u0010M\u001a\u00020.2\n\u0010#\u001a\u00060$R\u00020\u001a2\u0006\u0010%\u001a\u00020&2\u0006\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\u00052\u0006\u0010N\u001a\u00020\u0005H\u0002J$\u0010O\u001a\u00020.2\n\u0010#\u001a\u00060$R\u00020\u001a2\u0006\u0010%\u001a\u00020&2\u0006\u0010P\u001a\u00020\u0005H\u0002J\"\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u00052\b\u0010T\u001a\u0004\u0018\u00010\u00112\u0006\u0010U\u001a\u00020RH\u0002J\b\u0010V\u001a\u00020.H\u0002J$\u0010W\u001a\u00020.2\n\u0010#\u001a\u00060$R\u00020\u001a2\u0006\u0010%\u001a\u00020&2\u0006\u0010E\u001a\u00020\u0005H\u0002J\u000e\u0010X\u001a\u00020.2\u0006\u0010E\u001a\u00020\u0005J\b\u0010Y\u001a\u00020.H\u0002J\u0010\u0010Z\u001a\u00020.2\u0006\u00102\u001a\u00020\u0005H\u0002J\b\u0010[\u001a\u00020\u0005H\u0002J\b\u0010\\\u001a\u00020\u0005H\u0002J\u0010\u0010]\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005H\u0002J\u0012\u0010^\u001a\u0004\u0018\u00010_2\u0006\u0010`\u001a\u00020\u0005H\u0016J\u0014\u0010a\u001a\u00020\u0005*\u00020\u001c2\u0006\u0010/\u001a\u00020\u001aH\u0002J\u0010\u0010b\u001a\u00020.2\u0006\u0010/\u001a\u00020\u001aH\u0002J\u0018\u0010c\u001a\u00020.2\u0006\u0010/\u001a\u00020\u001a2\u0006\u0010d\u001a\u00020\u0007H\u0002J\u0017\u0010e\u001a\u0004\u0018\u00010\u00052\u0006\u0010/\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010fJ\u0010\u0010g\u001a\u00020.2\u0006\u00102\u001a\u00020\u0005H\u0016J\u0010\u0010h\u001a\u00020.2\u0006\u0010i\u001a\u00020\u0007H\u0002J\u0010\u0010j\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&H\u0002J\"\u0010k\u001a\u00020.2\u0006\u0010/\u001a\u00020\u001a2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u00102\u001a\u00020\u0005H\u0016J'\u0010l\u001a\u0004\u0018\u0001Hm\"\u0004\b\u0000\u0010m*\n\u0012\u0006\u0012\u0004\u0018\u0001Hm0n2\u0006\u0010o\u001a\u00020\u0005¢\u0006\u0002\u0010pR\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00060\u001eR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0018\u00010$R\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00109\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u0018\u001a\u0004\b;\u0010<¨\u0006v"}, d2 = {"Lcom/bytedance/ee/bear/drive/core/thumbnail/ThumbnailTrackerLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "reverseLayout", "", "<init>", "(Landroid/content/Context;IZ)V", "mOrientation", "mFirstVisiblePosition", "mLastVisiblePos", "mInitialSelectedPosition", "mCurSelectedPosition", "mScrollingPosition", "mCurSelectedView", "Landroid/view/View;", "hasSettledInitialPosition", "mState", "Lcom/bytedance/ee/bear/drive/core/thumbnail/ThumbnailTrackerLayoutManager$State;", "getMState", "()Lcom/bytedance/ee/bear/drive/core/thumbnail/ThumbnailTrackerLayoutManager$State;", "mState$delegate", "Lkotlin/Lazy;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mSnapHelper", "Lcom/bytedance/ee/bear/drive/core/thumbnail/ThumbnailLinearSnapHelper;", "mInnerScrollListener", "Lcom/bytedance/ee/bear/drive/core/thumbnail/ThumbnailTrackerLayoutManager$InnerScrollListener;", "mItemTransformer", "Lcom/bytedance/ee/bear/drive/core/thumbnail/ThumbnailTrackerLayoutManager$ItemTransformer;", "mOnItemSelectedListener", "Lcom/bytedance/ee/bear/drive/core/thumbnail/OnItemSelectedListener;", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "scrollToWaitForLayout", "layoutFromItemRemoved", "removePositionStart", "removeItemCount", "isViewPagerScrolling", "isHandlingPrepend", "attach", "", "recyclerView", "selectedPosition", "updateSelectedPosition", "position", "detach", "setItemTransformer", "itemTransformer", "setOnItemSelectedListener", "onItemSelectedListener", "getCurSelectedPosition", "orientationHelper", "Landroidx/recyclerview/widget/OrientationHelper;", "getOrientationHelper", "()Landroidx/recyclerview/widget/OrientationHelper;", "orientationHelper$delegate", "onItemsAdded", "positionStart", "itemCount", "onItemsRemoved", "onItemsChanged", "onLayoutChildren", "scrollHorizontallyBy", "dx", "scrollVerticallyBy", "dy", "firstFillWithHorizontal", "fillLeft", "startPosition", "startOffset", "leftEdge", "fillRight", "rightEdge", "fillCover", "scrollDelta", "calculateToCenterFraction", "", "pos", "child", "pendingOffset", "printItemsFrames", "fillWithHorizontal", "scrollHorizontalTo", "notifyTransformItem", "performTransform", "getHorizontalSpace", "getVerticalSpace", "calculateScrollDirectionForPosition", "computeScrollVectorForPosition", "Landroid/graphics/PointF;", "targetPosition", "getSnapPosition", "maybeNotifySnapPositionChange", "notifyFlingPosition", "isFlinging", "calSnapPosition", "(Landroidx/recyclerview/widget/RecyclerView;)Ljava/lang/Integer;", "scrollToPosition", "waitForLayoutComplete", "wait", "needScrollToPosWhenLayoutCompleted", "smoothScrollToPosition", "getSafely", "T", "", "index", "(Ljava/util/List;I)Ljava/lang/Object;", "Companion", "InnerScrollListener", "State", "ScrollRect", "ItemTransformer", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThumbnailTrackerLayoutManager extends LinearLayoutManager {
    public static final /* synthetic */ int t = 0;
    public int a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public final Lazy f;
    public RecyclerView g;
    public final ThumbnailLinearSnapHelper h;
    public final InnerScrollListener i;
    public b j;
    public j k;
    public RecyclerView.Recycler l;
    public RecyclerView.State m;
    public boolean n;
    public boolean o;
    public int p;
    public int q;
    public boolean r;
    public final Lazy s;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J \u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/drive/core/thumbnail/ThumbnailTrackerLayoutManager$InnerScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "<init>", "(Lcom/bytedance/ee/bear/drive/core/thumbnail/ThumbnailTrackerLayoutManager;)V", "mState", "", "getMState", "()I", "setMState", "(I)V", "mNeedNotifyFling", "", "getMNeedNotifyFling", "()Z", "setMNeedNotifyFling", "(Z)V", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "onScrolled", "dx", "dy", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class InnerScrollListener extends RecyclerView.OnScrollListener {
        public boolean a;
        public final /* synthetic */ ThumbnailTrackerLayoutManager b;

        public InnerScrollListener(ThumbnailTrackerLayoutManager r1) {
            this.b = r1;
        }

        public final void onScrollStateChanged(RecyclerView r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "recyclerView");
            super.onScrollStateChanged(r3, r4);
            if (r4 != 1) goto L5;
            this.a = true;
        L5:
            if (r4 != 0) goto L17;
            ThumbnailTrackerLayoutManager r5 = this.b;
            int r0 = ThumbnailTrackerLayoutManager.t;
            r5.w();
            ThumbnailTrackerLayoutManager r6 = this.b;
            Integer r1 = r6.q(r3);
            if (r1 == null) goto L13;
            r1.intValue();
            j r2 = r6.k;
            if (r2 == null) goto L11;
            r6.h.findSnapView(r6);
            r2.b();
        L11:
            r6.d = -1;
        L13:
            if (this.a == false) goto L15;
            ThumbnailTrackerLayoutManager.p(this.b, r3, false);
        L15:
            this.a = false;
            return;
        }

        public final void onScrolled(RecyclerView r1, int r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "recyclerView");
            if (this.a == false) goto L5;
            ThumbnailTrackerLayoutManager.p(this.b, r1, true);
            return;
        L5:
            ThumbnailTrackerLayoutManager r4 = this.b;
            int r5 = ThumbnailTrackerLayoutManager.t;
            r4.q(r1);
        }
    }

    public static final class a {
    }

    public interface b {
        void transformItem(View r1, float r2);
    }

    public static final class c {
        public Rect a;
        public final Rect b;

        public c() {
            this(0);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "ScrollRect(startRect=" + this.a + ", endRect=" + this.b + ')';
        }

        public c(int r3) {
            Rect r4 = new Rect();
            Rect r0 = new Rect();
            Intrinsics.checkNotNullParameter(r4, "startRect");
            Intrinsics.checkNotNullParameter(r0, "endRect");
            this.a = r4;
            this.b = r0;
        }
    }

    public static final class d {
        public final SparseArray<Rect> a;
        public final SparseArray<Rect> b;
        public final List<c> c;

        public d() {
            this.a = new SparseArray();
            this.b = new SparseArray();
            this.c = new ArrayList();
        }
    }

    static {
    }

    public final d s() {
        return (d) this.f.getValue();
    }

    public final OrientationHelper t() {
        return (OrientationHelper) this.s.getValue();
    }

    public final void w() {
        if (this.j == null) goto L7;
        int r0 = getChildCount();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        x(r1);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public final int v() {
        return (getHeight() - getPaddingBottom()) - getPaddingTop();
    }

    public ThumbnailTrackerLayoutManager(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, 0, false);
        this.c = -1;
        this.d = -1;
        this.f = LazyKt.lazy(ThumbnailTrackerLayoutManager$mState$2.INSTANCE);
        this.h = new ThumbnailLinearSnapHelper();
        this.i = new InnerScrollListener(this);
        this.s = LazyKt.lazy(new ThumbnailTrackerLayoutManager$orientationHelper$2(this));
    }

    public final PointF computeScrollVectorForPosition(int r3) {
        int r1 = -1;
        if (getChildCount() != 0) goto L6;
    L9:
        PointF r4 = new PointF();
        if (r1 != 0) goto L13;
        return null;
    L13:
        r4.x = r1;
        r4.y = 0.0f;
        return r4;
    L6:
        if (r3 < this.a) goto L9;
        r1 = 1;
        goto L9
    }

    public final void onItemsChanged(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.onItemsChanged(r2);
        this.e = false;
    }

    public final Integer q(RecyclerView r3) {
        ThumbnailLinearSnapHelper r0 = this.h;
        RecyclerView.LayoutManager r4 = r3.getLayoutManager();
        if (r4 != null) goto L5;
    L4:
        int r5 = -1;
    L9:
        if (r5 != (-1)) goto L12;
        return null;
    L12:
        this.c = r5;
        return Integer.valueOf(r5);
    L5:
        View r1 = r0.findSnapView(r4);
        if (r1 == null) goto L4;
        r5 = r4.getPosition(r1);
        goto L9
    }

    public final void scrollToPosition(int r22) {
        RecyclerView.Recycler r7 = this.l;
        if (r7 != null) goto L5;
        return;
    L5:
        RecyclerView.State r8 = this.m;
        if (r8 != null) goto L8;
        return;
    L8:
        RecyclerView r9 = this.g;
        if (r9 != null) goto L12;
        return;
    L12:
        if (r9.getAdapter() != null) goto L14;
        return;
    L14:
        this.b = r22;
        if (r22 >= 0) goto L17;
    L65:
        this.n = true;
        return;
    L17:
        if (r22 >= r8.getItemCount()) goto L65;
        this.n = false;
        s().a.clear();
        s().b.clear();
        ((ArrayList) s().c).clear();
        RecyclerView r0 = this.g;
        if (r0 != null) goto L22;
    L63:
        w();
        this.i.onScrolled(r9, 0, 0);
        return;
    L22:
        if (r0.getAdapter() == null) goto L63;
        this.e = true;
        detachAndScrapAttachedViews(r7);
        int r12 = t().getStartAfterPadding();
        int r13 = t().getEndAfterPadding();
        int r14 = this.b;
        Rect r16 = new Rect();
        int r1 = v();
        View r5 = r7.getViewForPosition(this.b);
        addView(r5, 0);
        measureChildWithMargins(r5, 0, 0);
        int r2 = getDecoratedMeasuredWidth(r5);
        int r3 = getDecoratedMeasuredHeight(r5);
        int r4 = (int) (getPaddingTop() + ((r1 - r3) / 2.0f));
        int r6 = (int) (getPaddingLeft() + ((((getWidth() - getPaddingRight()) - getPaddingLeft()) - r2) / 2.0f));
        r16.set(r6, r4, r2 + r6, r3 + r4);
        layoutDecorated(r5, r16.left, r16.top, r16.right, r16.bottom);
        if (s().a.get(r14) != null) goto L27;
        s().a.put(r14, r16);
    L30:
        this.a = r14;
        int r10 = getDecoratedLeft(r5);
        int r11 = getDecoratedRight(r5);
        int r17 = this.b - 1;
        RecyclerView r18 = this.g;
        if (r18 == null) goto L47;
        RecyclerView.Adapter r19 = r18.getAdapter();
        if (r19 == null) goto L47;
        int r110 = r19.getItemCount();
        int r111 = v();
        int r20 = r17;
    L35:
        if (r20 < 0) goto L47;
        if (r10 <= r12) goto L47;
        if (r20 >= r8.getItemCount()) goto L47;
        if (r20 >= r110) goto L47;
        Rect r21 = new Rect();
        View r23 = r7.getViewForPosition(r20);
        addView(r23, 0);
        measureChildWithMargins(r23, 0, 0);
        int r24 = getDecoratedMeasuredWidth(r23);
        int r26 = getDecoratedMeasuredHeight(r23);
        int r112 = r20;
        int r27 = (int) (getPaddingTop() + ((r111 - r26) / 2.0f));
        r21.set(r10 - r24, r27, r10, r26 + r27);
        int r113 = r11;
        int r28 = r12;
        layoutDecorated(r23, r21.left, r21.top, r21.right, r21.bottom);
        r10 = r21.left;
        this.a = r112;
        if (s().a.get(r112) != null) goto L43;
        s().a.put(r112, r21);
    L46:
        r20 = r112 - 1;
        r11 = r113;
        r12 = r28;
        goto L35
    L43:
        Rect r29 = s().a.get(r112);
        if (r29 == null) goto L46;
        r29.set(r21);
    L47:
        int r114 = r11;
        int r30 = this.b + 1;
        RecyclerView r31 = this.g;
        if (r31 == null) goto L63;
        RecyclerView.Adapter r32 = r31.getAdapter();
        if (r32 == null) goto L63;
        int r115 = r32.getItemCount();
        int r116 = v();
        int r117 = r30;
        int r33 = r114;
    L53:
        if (r117 >= r8.getItemCount()) goto L63;
        if (r117 >= r115) goto L63;
        if (r33 >= r13) goto L63;
        Rect r118 = new Rect();
        View r34 = r7.getViewForPosition(r117);
        addView(r34);
        measureChildWithMargins(r34, 0, 0);
        int r36 = getDecoratedMeasuredWidth(r34);
        int r37 = getDecoratedMeasuredHeight(r34);
        int r38 = (int) (getPaddingTop() + ((r116 - r37) / 2.0f));
        r118.set(r33, r38, r36 + r33, r37 + r38);
        layoutDecorated(r34, r118.left, r118.top, r118.right, r118.bottom);
        r33 = r118.right;
        if (s().a.get(r117) != null) goto L59;
        s().a.put(r117, r118);
    L62:
        r117 = r117 + 1;
        goto L53
    L59:
        Rect r39 = s().a.get(r117);
        if (r39 == null) goto L62;
        r39.set(r118);
        goto L62
    L27:
        Rect r40 = s().a.get(r14);
        if (r40 == null) goto L30;
        r40.set(r16);
        goto L30
    }

    public final void x(int r5) {
        View r6 = getChildAt(r5);
        if (r6 != null) goto L5;
        return;
    L5:
        b r0 = this.j;
        if (r0 != null) goto L8;
        return;
    L8:
        OrientationHelper r1 = t();
        float r2 = Math.max(-1.0f, Math.min(1.0f, (((int) ((((r6.getWidth() / 2.0f) - 0.0f) + r6.getLeft()) - (((r1.getEndAfterPadding() - r1.getStartAfterPadding()) / 2) + r1.getStartAfterPadding()))) * 1.0f) / r6.getWidth()));
        r6.getWidth();
        r0.transformItem(r6, r2);
    }

    public final void onLayoutChildren(RecyclerView.Recycler r5, RecyclerView.State r6) {
        Intrinsics.checkNotNullParameter(r5, "recycler");
        Intrinsics.checkNotNullParameter(r6, "state");
        this.l = r5;
        this.m = r6;
        if (this.e == false) goto L21;
        RecyclerView r0 = this.g;
        if (r0 == null) goto L13;
        RecyclerView.Adapter r1 = r0.getAdapter();
        if (r1 == null) goto L13;
        int r2 = r1.getItemCount();
        if (this.n == false) goto L13;
        if (r6.getItemCount() != r2) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == true) goto L21;
        if (this.r == false) goto L19;
        int r4 = -1;
    L20:
        r(r5, r6, r4);
        this.o = false;
    L22:
        this.r = false;
        return;
    L19:
        r4 = 0;
    L13:
        r3 = false;
    L21:
        scrollToPosition(Math.min(Math.max(0, this.b), getItemCount() - 1));
        goto L22
    }

    public final <T> T u(List<T> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 >= 0) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L12;
        return null;
    L12:
        return (T) ListProtector.get(r2, r3);
    L5:
        if (r3 >= ((ArrayList) r2).size()) goto L7;
        r0 = true;
        goto L8
    }

    public static final void p(ThumbnailTrackerLayoutManager r1, RecyclerView r2, boolean r3) {
        Integer r4 = r1.q(r2);
        if (r4 == null) goto L14;
        int r5 = r4.intValue();
        if (r1.d == r5) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L15;
        j r6 = r1.k;
        if (r6 == null) goto L12;
        r6.a(r5, r3);
    L12:
        r1.d = r5;
        return;
    L15:
        return;
    L7:
        r0 = false;
        goto L8
    }

    public final void onItemsAdded(RecyclerView r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "recyclerView");
        super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.onItemsAdded(r5, r6, r7);
        tt5.a.h("ThumbnailTrackerLayoutManager", "onItemsAdded positionStart = " + r6 + "  itemCount = " + r7 + ", curSelectedPosition = " + this.c);
        if (r6 != 0) goto L10;
        this.r = true;
        int r8 = this.c + r7;
        this.c = r8;
        this.b = r8;
        this.a += r7;
        SparseArray r9 = new SparseArray();
        SparseArray<Rect> r10 = s().a;
        int r0 = r10.size();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        r9.put(r10.keyAt(r1) + r7, r10.valueAt(r1));
        r1 = r1 + 1;
        goto L5
    L7:
        s().a.clear();
        SparseArrayKt.putAll(s().a, r9);
        return;
    }

    public final void onItemsRemoved(RecyclerView r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.onItemsRemoved(r2, r3, r4);
        this.o = true;
        this.p = r3;
        this.q = r4;
    }

    public final void r(RecyclerView.Recycler r18, RecyclerView.State r19, int r20) {
        if (getItemCount() != 0) goto L5;
        return;
    L5:
        int r8 = t().getStartAfterPadding();
        int r9 = t().getEndAfterPadding();
        int r11 = -1;
        if (getChildCount() <= 0) goto L43;
        if (r20 < 0) goto L34;
        int r0 = getChildCount();
        int r2 = 0;
        int r3 = 0;
    L9:
        if (r2 >= r0) goto L17;
        View r4 = getChildAt(r2 + r3);
        if (r4 == null) goto L17;
        if ((getDecoratedRight(r4) - r20) >= r8) goto L17;
        removeAndRecycleView(r4, r18);
        s().a.remove(r2);
        this.a++;
        r3 = r3 - 1;
        r2 = r2 + 1;
    L17:
        if (this.o == false) goto L43;
        View r1 = findViewByPosition(this.p - 1);
        if (r1 == null) goto L43;
        RecyclerView r5 = this.g;
        if (r5 == null) goto L86;
        int r6 = r5.indexOfChild(r1) + 1;
        int r7 = this.q + r6;
    L23:
        if (r6 >= r7) goto L43;
        if (1 <= r6) goto L26;
    L28:
        boolean r10 = false;
    L29:
        if (r10 == false) goto L33;
        View r12 = getChildAt(r6);
        if (r12 == null) goto L33;
        removeAndRecycleView(r12, r18);
        s().a.remove(r6);
    L33:
        r6 = r6 + 1;
        goto L23
    L26:
        if (r6 >= getChildCount()) goto L28;
        r10 = true;
    L86:
        w();
        return;
    L34:
        int r13 = getChildCount() - 1;
    L35:
        if ((-1) >= r13) goto L43;
        View r14 = getChildAt(r13);
        if (r14 == null) goto L42;
        if ((getDecoratedLeft(r14) - r20) <= r9) goto L42;
        removeAndRecycleView(r14, r18);
        s().a.remove(r13);
    L42:
        r13 = r13 - 1;
    L43:
        int r16 = this.a;
        int r17 = v();
        if (r20 < 0) goto L71;
        if (getChildCount() == 0) goto L55;
        View r21 = getChildAt(getChildCount() - 1);
        View r22 = findViewByPosition(this.p - 1);
        if (this.o == false) goto L51;
        if (r22 == null) goto L51;
        r16 = this.p;
        int r23 = getDecoratedRight(r22);
    L54:
        int r24 = r16;
    L56:
        int r110 = r24;
    L58:
        if (r110 >= r19.getItemCount()) goto L86;
        if (r23 >= (r9 + r20)) goto L86;
        Rect r26 = s().a.get(r110);
        View r27 = r18.getViewForPosition(r110);
        addView(r27);
        if (r26 != null) goto L64;
        r26 = new Rect();
        s().a.put(r110, r26);
    L64:
        Rect r111 = r26;
        measureChildWithMargins(r27, 0, 0);
        int r28 = getDecoratedMeasuredWidth(r27);
        int r29 = getDecoratedMeasuredHeight(r27);
        int r30 = (int) (getPaddingTop() + ((r17 - r29) / 2.0f));
        if (r23 != (-1)) goto L68;
        if (r24 != 0) goto L68;
        int r31 = (int) (getPaddingLeft() + ((((getWidth() - getPaddingRight()) - getPaddingLeft()) - r28) / 2.0f));
        r111.set(r31, r30, r28 + r31, r29 + r30);
    L69:
        layoutDecorated(r27, r111.left, r111.top, r111.right, r111.bottom);
        r23 = r111.right;
        r110 = r110 + 1;
    L68:
        r111.set(r23, r30, r28 + r23, r29 + r30);
    L51:
        if (r21 == null) goto L53;
        r16 = getPosition(r21) + 1;
        r23 = getDecoratedRight(r21);
        goto L54
    L53:
        r23 = -1;
        goto L54
    L55:
        r24 = r16;
        r23 = -1;
        goto L56
    L71:
        if (getChildCount() <= 0) goto L76;
        View r32 = getChildAt(0);
        if (r32 == null) goto L86;
        int r33 = getPosition(r32) - 1;
        r11 = getDecoratedLeft(r32);
        r16 = r33;
    L76:
        int r34 = r16;
    L77:
        if (r34 < 0) goto L86;
        if (r11 <= (r8 + r20)) goto L86;
        if (r34 >= r19.getItemCount()) goto L86;
        Rect r36 = s().a.get(r34);
        View r37 = r18.getViewForPosition(r34);
        addView(r37, 0);
        if (r36 != null) goto L85;
        r36 = new Rect();
        s().a.put(r34, r36);
    L85:
        Rect r112 = r36;
        measureChildWithMargins(r37, 0, 0);
        int r38 = getDecoratedMeasuredWidth(r37);
        int r39 = getDecoratedMeasuredHeight(r37);
        int r40 = (int) (getPaddingTop() + ((r17 - r39) / 2.0f));
        r112.set(r11 - r38, r40, r11, r39 + r40);
        layoutDecorated(r37, r112.left, r112.top, r112.right, r112.bottom);
        r11 = r112.left;
        this.a = r34;
        r34 = r34 - 1;
        goto L77
    }

    public final int scrollHorizontallyBy(int r7, RecyclerView.Recycler r8, RecyclerView.State r9) {
        Intrinsics.checkNotNullParameter(r8, "recycler");
        Intrinsics.checkNotNullParameter(r9, "state");
        if (getChildCount() == 0) goto L22;
        if (r7 == 0) goto L23;
        int r0 = -r7;
        int r2 = ((t().getEndAfterPadding() - t().getStartAfterPadding()) / 2) + t().getStartAfterPadding();
        if (r7 < 0) goto L14;
        View r3 = getChildAt(getChildCount() - 1);
        int r4 = getItemCount() - 1;
        if (r3 != null) goto L11;
    L20:
        int r1 = -r0;
        s().getClass();
        r(r8, r9, r1);
        offsetChildrenHorizontal(r0);
        return r1;
    L11:
        if (getPosition(r3) < r4) goto L20;
        int r10 = Math.max(0, Math.min(r7, (((r3.getRight() - r3.getLeft()) / 2) + r3.getLeft()) - r2));
    L19:
        r0 = -r10;
        goto L20
    L14:
        if (this.a != 0) goto L20;
        View r5 = getChildAt(0);
        if (r5 != null) goto L18;
        return 0;
    L18:
        r10 = Math.min(0, Math.max(r7, (((r5.getRight() - r5.getLeft()) / 2) + r5.getLeft()) - r2));
        goto L19
    L23:
        return 0;
    L22:
        return 0;
    }

    public final int scrollVerticallyBy(int r7, RecyclerView.Recycler r8, RecyclerView.State r9) {
        Intrinsics.checkNotNullParameter(r8, "recycler");
        Intrinsics.checkNotNullParameter(r9, "state");
        if (getChildCount() == 0) goto L23;
        if (r7 == 0) goto L24;
        int r0 = -r7;
        int r2 = ((t().getEndAfterPadding() - t().getStartAfterPadding()) / 2) + t().getStartAfterPadding();
        if (r7 <= 0) goto L15;
        View r3 = getChildAt(getChildCount() - 1);
        if (r3 != null) goto L12;
        return 0;
    L12:
        if (getPosition(r3) != (getItemCount() - 1)) goto L21;
        int r10 = Math.max(0, Math.min(r7, (((getDecoratedBottom(r3) - getDecoratedTop(r3)) / 2) + getDecoratedTop(r3)) - r2));
    L20:
        r0 = -r10;
    L21:
        int r1 = -r0;
        s().getClass();
        r(r8, r9, r1);
        offsetChildrenVertical(r0);
        return r1;
    L15:
        if (this.a != 0) goto L21;
        View r4 = getChildAt(0);
        if (r4 != null) goto L19;
        return 0;
    L19:
        r10 = Math.min(0, Math.max(r7, (((getDecoratedBottom(r4) - getDecoratedTop(r4)) / 2) + getDecoratedTop(r4)) - r2));
        goto L20
    L24:
        return 0;
    L23:
        return 0;
    }

    public final void smoothScrollToPosition(RecyclerView r1, RecyclerView.State r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "recyclerView");
        if (r1.getLayoutManager() == this) goto L5;
    L9:
        tt5.a.k("ThumbnailTrackerLayoutManager", "smoothScrollToPosition skipped because recyclerView is detached");
        return;
    L5:
        if (r1.isAttachedToWindow() == false) goto L9;
        final Context r4 = r1.getContext();
        LinearSmoothScroller r5 = new ThumbnailTrackerLayoutManager$smoothScrollToPosition$smoothScroller$1(this, r4);
        r5.setTargetPosition(r3);
        startSmoothScroll(r5);
    }
}
