package com.bytedance.ee.bear.drive.core.thumbnail;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.core.util.SparseArrayKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.model.GXScroll;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\b\b\u0018\u0000 q2\u00020\u0001:\u0005qrstuB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u001a2\u0006\u00100\u001a\u00020\u0005J\u000e\u00101\u001a\u00020.2\u0006\u00102\u001a\u00020\u0005J\u0006\u00103\u001a\u00020.J\u0010\u00104\u001a\u00020.2\b\u00105\u001a\u0004\u0018\u00010 J\u0010\u00106\u001a\u00020.2\b\u00107\u001a\u0004\u0018\u00010\"J\u0006\u00108\u001a\u00020\u0005J \u0010>\u001a\u00020.2\u0006\u0010/\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u0005H\u0016J \u0010A\u001a\u00020.2\u0006\u0010/\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u0005H\u0016J\u0010\u0010B\u001a\u00020.2\u0006\u0010/\u001a\u00020\u001aH\u0016J\u001c\u0010C\u001a\u00020.2\n\u0010#\u001a\u00060$R\u00020\u001a2\u0006\u0010%\u001a\u00020&H\u0016J$\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u00052\n\u0010#\u001a\u00060$R\u00020\u001a2\u0006\u0010%\u001a\u00020&H\u0016J$\u0010F\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u00052\n\u0010#\u001a\u00060$R\u00020\u001a2\u0006\u0010%\u001a\u00020&H\u0016J\u001c\u0010H\u001a\u00020.2\n\u0010#\u001a\u00060$R\u00020\u001a2\u0006\u0010%\u001a\u00020&H\u0002J4\u0010I\u001a\u00020.2\n\u0010#\u001a\u00060$R\u00020\u001a2\u0006\u0010%\u001a\u00020&2\u0006\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u0005H\u0002J4\u0010M\u001a\u00020.2\n\u0010#\u001a\u00060$R\u00020\u001a2\u0006\u0010%\u001a\u00020&2\u0006\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\u00052\u0006\u0010N\u001a\u00020\u0005H\u0002J$\u0010O\u001a\u00020.2\n\u0010#\u001a\u00060$R\u00020\u001a2\u0006\u0010%\u001a\u00020&2\u0006\u0010P\u001a\u00020\u0005H\u0002J\"\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u00052\b\u0010T\u001a\u0004\u0018\u00010\u00112\u0006\u0010U\u001a\u00020RH\u0002J\b\u0010V\u001a\u00020.H\u0002J$\u0010W\u001a\u00020.2\n\u0010#\u001a\u00060$R\u00020\u001a2\u0006\u0010%\u001a\u00020&2\u0006\u0010E\u001a\u00020\u0005H\u0002J\u000e\u0010X\u001a\u00020.2\u0006\u0010E\u001a\u00020\u0005J\b\u0010Y\u001a\u00020.H\u0002J\u0010\u0010Z\u001a\u00020.2\u0006\u00102\u001a\u00020\u0005H\u0002J\b\u0010[\u001a\u00020\u0005H\u0002J\b\u0010\\\u001a\u00020\u0005H\u0002J\u0010\u0010]\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005H\u0002J\u0012\u0010^\u001a\u0004\u0018\u00010_2\u0006\u0010`\u001a\u00020\u0005H\u0016J\u0014\u0010a\u001a\u00020\u0005*\u00020\u001c2\u0006\u0010/\u001a\u00020\u001aH\u0002J\u0010\u0010b\u001a\u00020.2\u0006\u0010/\u001a\u00020\u001aH\u0002J\u0018\u0010c\u001a\u00020.2\u0006\u0010/\u001a\u00020\u001a2\u0006\u0010d\u001a\u00020\u0007H\u0002J\u0017\u0010e\u001a\u0004\u0018\u00010\u00052\u0006\u0010/\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010fJ\u0010\u0010g\u001a\u00020.2\u0006\u00102\u001a\u00020\u0005H\u0016J\u0010\u0010h\u001a\u00020.2\u0006\u0010i\u001a\u00020\u0007H\u0002J\u0010\u0010j\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&H\u0002J\"\u0010k\u001a\u00020.2\u0006\u0010/\u001a\u00020\u001a2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u00102\u001a\u00020\u0005H\u0016J'\u0010l\u001a\u0004\u0018\u0001Hm\"\u0004\b\u0000\u0010m*\n\u0012\u0006\u0012\u0004\u0018\u0001Hm0n2\u0006\u0010o\u001a\u00020\u0005¢\u0006\u0002\u0010pR\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00060\u001eR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0018\u00010$R\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00109\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u0018\u001a\u0004\b;\u0010<¨\u0006v"}, d2 = {"Lcom/bytedance/ee/bear/drive/core/thumbnail/ThumbnailTrackerLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "orientation", "", "reverseLayout", "", "<init>", "(Landroid/content/Context;IZ)V", "mOrientation", "mFirstVisiblePosition", "mLastVisiblePos", "mInitialSelectedPosition", "mCurSelectedPosition", "mScrollingPosition", "mCurSelectedView", "Landroid/view/View;", "hasSettledInitialPosition", "mState", "Lcom/bytedance/ee/bear/drive/core/thumbnail/ThumbnailTrackerLayoutManager$State;", "getMState", "()Lcom/bytedance/ee/bear/drive/core/thumbnail/ThumbnailTrackerLayoutManager$State;", "mState$delegate", "Lkotlin/Lazy;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mSnapHelper", "Lcom/bytedance/ee/bear/drive/core/thumbnail/ThumbnailLinearSnapHelper;", "mInnerScrollListener", "Lcom/bytedance/ee/bear/drive/core/thumbnail/ThumbnailTrackerLayoutManager$InnerScrollListener;", "mItemTransformer", "Lcom/bytedance/ee/bear/drive/core/thumbnail/ThumbnailTrackerLayoutManager$ItemTransformer;", "mOnItemSelectedListener", "Lcom/bytedance/ee/bear/drive/core/thumbnail/OnItemSelectedListener;", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "scrollToWaitForLayout", "layoutFromItemRemoved", "removePositionStart", "removeItemCount", "isViewPagerScrolling", "isHandlingPrepend", LynxViewpagerItem.BIND_ON_ATTACH, "", "recyclerView", "selectedPosition", "updateSelectedPosition", "position", "detach", "setItemTransformer", "itemTransformer", "setOnItemSelectedListener", "onItemSelectedListener", "getCurSelectedPosition", "orientationHelper", "Landroidx/recyclerview/widget/OrientationHelper;", "getOrientationHelper", "()Landroidx/recyclerview/widget/OrientationHelper;", "orientationHelper$delegate", "onItemsAdded", "positionStart", "itemCount", "onItemsRemoved", "onItemsChanged", "onLayoutChildren", "scrollHorizontallyBy", "dx", "scrollVerticallyBy", "dy", "firstFillWithHorizontal", "fillLeft", "startPosition", "startOffset", "leftEdge", "fillRight", "rightEdge", "fillCover", "scrollDelta", "calculateToCenterFraction", "", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "pendingOffset", "printItemsFrames", "fillWithHorizontal", "scrollHorizontalTo", "notifyTransformItem", "performTransform", "getHorizontalSpace", "getVerticalSpace", "calculateScrollDirectionForPosition", "computeScrollVectorForPosition", "Landroid/graphics/PointF;", "targetPosition", "getSnapPosition", "maybeNotifySnapPositionChange", "notifyFlingPosition", "isFlinging", "calSnapPosition", "(Landroidx/recyclerview/widget/RecyclerView;)Ljava/lang/Integer;", "scrollToPosition", "waitForLayoutComplete", "wait", "needScrollToPosWhenLayoutCompleted", "smoothScrollToPosition", "getSafely", ExifInterface.GPS_DIRECTION_TRUE, "", "index", "(Ljava/util/List;I)Ljava/lang/Object;", "Companion", "InnerScrollListener", "State", "ScrollRect", "ItemTransformer", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThumbnailTrackerLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f224328t = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f224329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f224330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f224331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f224332d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f224333e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f224334f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RecyclerView f224335g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ThumbnailLinearSnapHelper f224336h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final InnerScrollListener f224337i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f224338j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public j f224339k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public RecyclerView.Recycler f224340l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RecyclerView.State f224341m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f224342n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f224343o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f224344p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f224345q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f224346r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f224347s;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J \u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/drive/core/thumbnail/ThumbnailTrackerLayoutManager$InnerScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "<init>", "(Lcom/bytedance/ee/bear/drive/core/thumbnail/ThumbnailTrackerLayoutManager;)V", "mState", "", "getMState", "()I", "setMState", "(I)V", "mNeedNotifyFling", "", "getMNeedNotifyFling", "()Z", "setMNeedNotifyFling", "(Z)V", GXScroll.TYPE_ON_SCROLL_STATE_CHANGED, "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", GXScroll.TYPE_ON_SCROLLED, "dx", "dy", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class InnerScrollListener extends RecyclerView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f224348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ThumbnailTrackerLayoutManager f224349b;

        public InnerScrollListener(ThumbnailTrackerLayoutManager r100) {
            this.f224349b = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrollStateChanged(RecyclerView r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "recyclerView");
            super.onScrollStateChanged(r100, r101);
            if (r101 != 1) goto L5;
            this.f224348a = true;
        L5:
            if (r101 != 0) goto L17;
            ThumbnailTrackerLayoutManager r102 = this.f224349b;
            int r103 = ThumbnailTrackerLayoutManager.f224328t;
            r102.w();
            ThumbnailTrackerLayoutManager r104 = this.f224349b;
            Integer r105 = r104.q(r100);
            if (r105 == null) goto L13;
            r105.intValue();
            j r106 = r104.f224339k;
            if (r106 == null) goto L11;
            r104.f224336h.findSnapView(r104);
            r106.b();
        L11:
            r104.f224332d = -1;
        L13:
            if (this.f224348a == false) goto L15;
            ThumbnailTrackerLayoutManager.p(this.f224349b, r100, false);
        L15:
            this.f224348a = false;
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrolled(RecyclerView r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "recyclerView");
            if (this.f224348a == false) goto L5;
            ThumbnailTrackerLayoutManager.p(this.f224349b, r100, true);
            return;
        L5:
            ThumbnailTrackerLayoutManager r103 = this.f224349b;
            int r104 = ThumbnailTrackerLayoutManager.f224328t;
            r103.q(r100);
        }
    }

    public static final class a {
    }

    public interface b {
        void transformItem(View r100, float r101);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Rect f224350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f224351b;

        public c() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f224350a, r101.f224350a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f224351b, r101.f224351b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f224350a.hashCode() * 31) + this.f224351b.hashCode();
        }

        public final String toString() {
            return "ScrollRect(startRect=" + this.f224350a + ", endRect=" + this.f224351b + ')';
        }

        public c(int r100) {
            Rect r101 = new Rect();
            Rect r102 = new Rect();
            Intrinsics.checkNotNullParameter(r101, "startRect");
            Intrinsics.checkNotNullParameter(r102, "endRect");
            this.f224350a = r101;
            this.f224351b = r102;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseArray<Rect> f224352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SparseArray<Rect> f224353b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<c> f224354c;

        public d() {
            this.f224352a = new SparseArray();
            this.f224353b = new SparseArray();
            this.f224354c = new ArrayList();
        }
    }

    static {
    }

    public final d s() {
        return (d) this.f224334f.getValue();
    }

    public final OrientationHelper t() {
        return (OrientationHelper) this.f224347s.getValue();
    }

    public final void w() {
        if (this.f224338j == null) goto L7;
        int r100 = getChildCount();
        int r101 = 0;
    L5:
        if (r101 >= r100) goto L9;
        x(r101);
        r101 = r101 + 1;
        goto L5
    L9:
        return;
    }

    public final int v() {
        return (getHeight() - getPaddingBottom()) - getPaddingTop();
    }

    public ThumbnailTrackerLayoutManager(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, 0, false);
        this.f224331c = -1;
        this.f224332d = -1;
        this.f224334f = LazyKt.lazy(ThumbnailTrackerLayoutManager$mState$2.INSTANCE);
        this.f224336h = new ThumbnailLinearSnapHelper();
        this.f224337i = new InnerScrollListener(this);
        this.f224347s = LazyKt.lazy(new ThumbnailTrackerLayoutManager$orientationHelper$2(this));
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public final PointF computeScrollVectorForPosition(int r100) {
        int r101 = -1;
        if (getChildCount() != 0) goto L6;
    L9:
        PointF r102 = new PointF();
        if (r101 != 0) goto L13;
        return null;
    L13:
        r102.x = r101;
        r102.y = 0.0f;
        return r102;
    L6:
        if (r100 < this.f224329a) goto L9;
        r101 = 1;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsChanged(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onItemsChanged(r100);
        this.f224333e = false;
    }

    public final Integer q(RecyclerView r100) {
        ThumbnailLinearSnapHelper r101 = this.f224336h;
        RecyclerView.LayoutManager r102 = r100.getLayoutManager();
        if (r102 != null) goto L5;
    L4:
        int r103 = -1;
    L9:
        if (r103 != (-1)) goto L12;
        return null;
    L12:
        this.f224331c = r103;
        return Integer.valueOf(r103);
    L5:
        View r104 = r101.findSnapView(r102);
        if (r104 == null) goto L4;
        r103 = r102.getPosition(r104);
        goto L9
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void scrollToPosition(int r210) {
        RecyclerView.Recycler r100 = this.f224340l;
        if (r100 != null) goto L5;
        return;
    L5:
        RecyclerView.State r101 = this.f224341m;
        if (r101 != null) goto L8;
        return;
    L8:
        RecyclerView r102 = this.f224335g;
        if (r102 != null) goto L12;
        return;
    L12:
        if (r102.getAdapter() != null) goto L14;
        return;
    L14:
        this.f224330b = r210;
        if (r210 >= 0) goto L17;
    L65:
        this.f224342n = true;
        return;
    L17:
        if (r210 >= r101.getItemCount()) goto L65;
        this.f224342n = false;
        s().f224352a.clear();
        s().f224353b.clear();
        ((ArrayList) s().f224354c).clear();
        RecyclerView r103 = this.f224335g;
        if (r103 != null) goto L22;
    L63:
        w();
        this.f224337i.onScrolled(r102, 0, 0);
        return;
    L22:
        if (r103.getAdapter() == null) goto L63;
        this.f224333e = true;
        detachAndScrapAttachedViews(r100);
        int r110 = t().getStartAfterPadding();
        int r111 = t().getEndAfterPadding();
        int r112 = this.f224330b;
        Rect r113 = new Rect();
        int r104 = v();
        View r105 = r100.getViewForPosition(this.f224330b);
        addView(r105, 0);
        measureChildWithMargins(r105, 0, 0);
        int r106 = getDecoratedMeasuredWidth(r105);
        int r107 = getDecoratedMeasuredHeight(r105);
        int r108 = (int) (getPaddingTop() + ((r104 - r107) / 2.0f));
        int r109 = (int) (getPaddingLeft() + ((((getWidth() - getPaddingRight()) - getPaddingLeft()) - r106) / 2.0f));
        r113.set(r109, r108, r106 + r109, r107 + r108);
        layoutDecorated(r105, r113.left, r113.top, r113.right, r113.bottom);
        if (s().f224352a.get(r112) != null) goto L27;
        s().f224352a.put(r112, r113);
    L30:
        this.f224329a = r112;
        int r114 = getDecoratedLeft(r105);
        int r115 = getDecoratedRight(r105);
        int r116 = this.f224330b - 1;
        RecyclerView r117 = this.f224335g;
        if (r117 == null) goto L47;
        RecyclerView.Adapter r118 = r117.getAdapter();
        if (r118 == null) goto L47;
        int r119 = r118.getItemCount();
        int r120 = v();
        int r121 = r116;
    L35:
        if (r121 < 0) goto L47;
        if (r114 <= r110) goto L47;
        if (r121 >= r101.getItemCount()) goto L47;
        if (r121 >= r119) goto L47;
        Rect r122 = new Rect();
        View r123 = r100.getViewForPosition(r121);
        addView(r123, 0);
        measureChildWithMargins(r123, 0, 0);
        int r124 = getDecoratedMeasuredWidth(r123);
        int r125 = getDecoratedMeasuredHeight(r123);
        int r126 = r121;
        int r127 = (int) (getPaddingTop() + ((r120 - r125) / 2.0f));
        r122.set(r114 - r124, r127, r114, r125 + r127);
        int r128 = r115;
        int r211 = r110;
        layoutDecorated(r123, r122.left, r122.top, r122.right, r122.bottom);
        r114 = r122.left;
        this.f224329a = r126;
        if (s().f224352a.get(r126) != null) goto L43;
        s().f224352a.put(r126, r122);
    L46:
        r121 = r126 - 1;
        r115 = r128;
        r110 = r211;
        goto L35
    L43:
        Rect r129 = s().f224352a.get(r126);
        if (r129 == null) goto L46;
        r129.set(r122);
    L47:
        int r130 = r115;
        int r131 = this.f224330b + 1;
        RecyclerView r132 = this.f224335g;
        if (r132 == null) goto L63;
        RecyclerView.Adapter r133 = r132.getAdapter();
        if (r133 == null) goto L63;
        int r134 = r133.getItemCount();
        int r135 = v();
        int r136 = r131;
        int r137 = r130;
    L53:
        if (r136 >= r101.getItemCount()) goto L63;
        if (r136 >= r134) goto L63;
        if (r137 >= r111) goto L63;
        Rect r138 = new Rect();
        View r139 = r100.getViewForPosition(r136);
        addView(r139);
        measureChildWithMargins(r139, 0, 0);
        int r140 = getDecoratedMeasuredWidth(r139);
        int r141 = getDecoratedMeasuredHeight(r139);
        int r142 = (int) (getPaddingTop() + ((r135 - r141) / 2.0f));
        r138.set(r137, r142, r140 + r137, r141 + r142);
        layoutDecorated(r139, r138.left, r138.top, r138.right, r138.bottom);
        r137 = r138.right;
        if (s().f224352a.get(r136) != null) goto L59;
        s().f224352a.put(r136, r138);
    L62:
        r136 = r136 + 1;
        goto L53
    L59:
        Rect r143 = s().f224352a.get(r136);
        if (r143 == null) goto L62;
        r143.set(r138);
        goto L62
    L27:
        Rect r144 = s().f224352a.get(r112);
        if (r144 == null) goto L30;
        r144.set(r113);
        goto L30
    }

    public final void x(int r100) {
        View r101 = getChildAt(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        b r102 = this.f224338j;
        if (r102 != null) goto L8;
        return;
    L8:
        OrientationHelper r103 = t();
        float r104 = Math.max(-1.0f, Math.min(1.0f, (((int) ((((r101.getWidth() / 2.0f) - 0.0f) + r101.getLeft()) - (((r103.getEndAfterPadding() - r103.getStartAfterPadding()) / 2) + r103.getStartAfterPadding()))) * 1.0f) / r101.getWidth()));
        r101.getWidth();
        r102.transformItem(r101, r104);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r101) {
        Intrinsics.checkNotNullParameter(r100, "recycler");
        Intrinsics.checkNotNullParameter(r101, "state");
        this.f224340l = r100;
        this.f224341m = r101;
        if (this.f224333e == false) goto L21;
        RecyclerView r102 = this.f224335g;
        if (r102 == null) goto L13;
        RecyclerView.Adapter r103 = r102.getAdapter();
        if (r103 == null) goto L13;
        int r104 = r103.getItemCount();
        if (this.f224342n == false) goto L13;
        if (r101.getItemCount() != r104) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == true) goto L21;
        if (this.f224346r == false) goto L19;
        int r106 = -1;
    L20:
        r(r100, r101, r106);
        this.f224343o = false;
    L22:
        this.f224346r = false;
        return;
    L19:
        r106 = 0;
    L13:
        r105 = false;
    L21:
        scrollToPosition(Math.min(Math.max(0, this.f224330b), getItemCount() - 1));
        goto L22
    }

    public final <T> T u(List<T> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 >= 0) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L12;
        return null;
    L12:
        return (T) ListProtector.get(r100, r101);
    L5:
        if (r101 >= ((ArrayList) r100).size()) goto L7;
        r102 = true;
        goto L8
    }

    public static final void p(ThumbnailTrackerLayoutManager r100, RecyclerView r101, boolean r102) {
        Integer r103 = r100.q(r101);
        if (r103 == null) goto L14;
        int r104 = r103.intValue();
        if (r100.f224332d == r104) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == false) goto L15;
        j r106 = r100.f224339k;
        if (r106 == null) goto L12;
        r106.a(r104, r102);
    L12:
        r100.f224332d = r104;
        return;
    L15:
        return;
    L7:
        r105 = false;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsAdded(RecyclerView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onItemsAdded(r100, r101, r102);
        tt5.a.h("ThumbnailTrackerLayoutManager", "onItemsAdded positionStart = " + r101 + "  itemCount = " + r102 + ", curSelectedPosition = " + this.f224331c);
        if (r101 != 0) goto L10;
        this.f224346r = true;
        int r103 = this.f224331c + r102;
        this.f224331c = r103;
        this.f224330b = r103;
        this.f224329a += r102;
        SparseArray r104 = new SparseArray();
        SparseArray<Rect> r105 = s().f224352a;
        int r106 = r105.size();
        int r107 = 0;
    L5:
        if (r107 >= r106) goto L7;
        r104.put(r105.keyAt(r107) + r102, r105.valueAt(r107));
        r107 = r107 + 1;
        goto L5
    L7:
        s().f224352a.clear();
        SparseArrayKt.putAll(s().f224352a, r104);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsRemoved(RecyclerView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onItemsRemoved(r100, r101, r102);
        this.f224343o = true;
        this.f224344p = r101;
        this.f224345q = r102;
    }

    public final void r(RecyclerView.Recycler r110, RecyclerView.State r111, int r210) {
        if (getItemCount() != 0) goto L5;
        return;
    L5:
        int r100 = t().getStartAfterPadding();
        int r101 = t().getEndAfterPadding();
        int r112 = -1;
        if (getChildCount() <= 0) goto L43;
        if (r210 < 0) goto L34;
        int r102 = getChildCount();
        int r103 = 0;
        int r104 = 0;
    L9:
        if (r103 >= r102) goto L17;
        View r105 = getChildAt(r103 + r104);
        if (r105 == null) goto L17;
        if ((getDecoratedRight(r105) - r210) >= r100) goto L17;
        removeAndRecycleView(r105, r110);
        s().f224352a.remove(r103);
        this.f224329a++;
        r104 = r104 - 1;
        r103 = r103 + 1;
    L17:
        if (this.f224343o == false) goto L43;
        View r106 = findViewByPosition(this.f224344p - 1);
        if (r106 == null) goto L43;
        RecyclerView r107 = this.f224335g;
        if (r107 == null) goto L86;
        int r108 = r107.indexOfChild(r106) + 1;
        int r109 = this.f224345q + r108;
    L23:
        if (r108 >= r109) goto L43;
        if (1 <= r108) goto L26;
    L28:
        boolean r113 = false;
    L29:
        if (r113 == false) goto L33;
        View r114 = getChildAt(r108);
        if (r114 == null) goto L33;
        removeAndRecycleView(r114, r110);
        s().f224352a.remove(r108);
    L33:
        r108 = r108 + 1;
        goto L23
    L26:
        if (r108 >= getChildCount()) goto L28;
        r113 = true;
    L86:
        w();
        return;
    L34:
        int r115 = getChildCount() - 1;
    L35:
        if ((-1) >= r115) goto L43;
        View r116 = getChildAt(r115);
        if (r116 == null) goto L42;
        if ((getDecoratedLeft(r116) - r210) <= r101) goto L42;
        removeAndRecycleView(r116, r110);
        s().f224352a.remove(r115);
    L42:
        r115 = r115 - 1;
    L43:
        int r117 = this.f224329a;
        int r118 = v();
        if (r210 < 0) goto L71;
        if (getChildCount() == 0) goto L55;
        View r119 = getChildAt(getChildCount() - 1);
        View r120 = findViewByPosition(this.f224344p - 1);
        if (this.f224343o == false) goto L51;
        if (r120 == null) goto L51;
        r117 = this.f224344p;
        int r121 = getDecoratedRight(r120);
    L54:
        int r122 = r117;
    L56:
        int r123 = r122;
    L58:
        if (r123 >= r111.getItemCount()) goto L86;
        if (r121 >= (r101 + r210)) goto L86;
        Rect r124 = s().f224352a.get(r123);
        View r125 = r110.getViewForPosition(r123);
        addView(r125);
        if (r124 != null) goto L64;
        r124 = new Rect();
        s().f224352a.put(r123, r124);
    L64:
        Rect r126 = r124;
        measureChildWithMargins(r125, 0, 0);
        int r127 = getDecoratedMeasuredWidth(r125);
        int r128 = getDecoratedMeasuredHeight(r125);
        int r129 = (int) (getPaddingTop() + ((r118 - r128) / 2.0f));
        if (r121 != (-1)) goto L68;
        if (r122 != 0) goto L68;
        int r130 = (int) (getPaddingLeft() + ((((getWidth() - getPaddingRight()) - getPaddingLeft()) - r127) / 2.0f));
        r126.set(r130, r129, r127 + r130, r128 + r129);
    L69:
        layoutDecorated(r125, r126.left, r126.top, r126.right, r126.bottom);
        r121 = r126.right;
        r123 = r123 + 1;
    L68:
        r126.set(r121, r129, r127 + r121, r128 + r129);
    L51:
        if (r119 == null) goto L53;
        r117 = getPosition(r119) + 1;
        r121 = getDecoratedRight(r119);
        goto L54
    L53:
        r121 = -1;
        goto L54
    L55:
        r122 = r117;
        r121 = -1;
        goto L56
    L71:
        if (getChildCount() <= 0) goto L76;
        View r131 = getChildAt(0);
        if (r131 == null) goto L86;
        int r132 = getPosition(r131) - 1;
        r112 = getDecoratedLeft(r131);
        r117 = r132;
    L76:
        int r133 = r117;
    L77:
        if (r133 < 0) goto L86;
        if (r112 <= (r100 + r210)) goto L86;
        if (r133 >= r111.getItemCount()) goto L86;
        Rect r134 = s().f224352a.get(r133);
        View r135 = r110.getViewForPosition(r133);
        addView(r135, 0);
        if (r134 != null) goto L85;
        r134 = new Rect();
        s().f224352a.put(r133, r134);
    L85:
        Rect r136 = r134;
        measureChildWithMargins(r135, 0, 0);
        int r137 = getDecoratedMeasuredWidth(r135);
        int r138 = getDecoratedMeasuredHeight(r135);
        int r139 = (int) (getPaddingTop() + ((r118 - r138) / 2.0f));
        r136.set(r112 - r137, r139, r112, r138 + r139);
        layoutDecorated(r135, r136.left, r136.top, r136.right, r136.bottom);
        r112 = r136.left;
        this.f224329a = r133;
        r133 = r133 - 1;
        goto L77
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollHorizontallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        Intrinsics.checkNotNullParameter(r101, "recycler");
        Intrinsics.checkNotNullParameter(r102, "state");
        if (getChildCount() == 0) goto L22;
        if (r100 == 0) goto L23;
        int r103 = -r100;
        int r104 = ((t().getEndAfterPadding() - t().getStartAfterPadding()) / 2) + t().getStartAfterPadding();
        if (r100 < 0) goto L14;
        View r105 = getChildAt(getChildCount() - 1);
        int r106 = getItemCount() - 1;
        if (r105 != null) goto L11;
    L20:
        int r107 = -r103;
        s().getClass();
        r(r101, r102, r107);
        offsetChildrenHorizontal(r103);
        return r107;
    L11:
        if (getPosition(r105) < r106) goto L20;
        int r108 = Math.max(0, Math.min(r100, (((r105.getRight() - r105.getLeft()) / 2) + r105.getLeft()) - r104));
    L19:
        r103 = -r108;
        goto L20
    L14:
        if (this.f224329a != 0) goto L20;
        View r109 = getChildAt(0);
        if (r109 != null) goto L18;
        return 0;
    L18:
        r108 = Math.min(0, Math.max(r100, (((r109.getRight() - r109.getLeft()) / 2) + r109.getLeft()) - r104));
        goto L19
    L23:
        return 0;
    L22:
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollVerticallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        Intrinsics.checkNotNullParameter(r101, "recycler");
        Intrinsics.checkNotNullParameter(r102, "state");
        if (getChildCount() == 0) goto L23;
        if (r100 == 0) goto L24;
        int r103 = -r100;
        int r104 = ((t().getEndAfterPadding() - t().getStartAfterPadding()) / 2) + t().getStartAfterPadding();
        if (r100 <= 0) goto L15;
        View r105 = getChildAt(getChildCount() - 1);
        if (r105 != null) goto L12;
        return 0;
    L12:
        if (getPosition(r105) != (getItemCount() - 1)) goto L21;
        int r106 = Math.max(0, Math.min(r100, (((getDecoratedBottom(r105) - getDecoratedTop(r105)) / 2) + getDecoratedTop(r105)) - r104));
    L20:
        r103 = -r106;
    L21:
        int r107 = -r103;
        s().getClass();
        r(r101, r102, r107);
        offsetChildrenVertical(r103);
        return r107;
    L15:
        if (this.f224329a != 0) goto L21;
        View r108 = getChildAt(0);
        if (r108 != null) goto L19;
        return 0;
    L19:
        r106 = Math.min(0, Math.max(r100, (((getDecoratedBottom(r108) - getDecoratedTop(r108)) / 2) + getDecoratedTop(r108)) - r104));
        goto L20
    L24:
        return 0;
    L23:
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView r100, RecyclerView.State r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        if (r100.getLayoutManager() == this) goto L5;
    L9:
        tt5.a.k("ThumbnailTrackerLayoutManager", "smoothScrollToPosition skipped because recyclerView is detached");
        return;
    L5:
        if (r100.isAttachedToWindow() == false) goto L9;
        final Context r103 = r100.getContext();
        LinearSmoothScroller r104 = new ThumbnailTrackerLayoutManager$smoothScrollToPosition$smoothScroller$1(this, r103);
        r104.setTargetPosition(r102);
        startSmoothScroll(r104);
    }
}
