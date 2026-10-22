package com.larus.gallery.tracker;

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
import com.larus.utils.logger.FLogger;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\b\b\u0018\u0000 v2\u00020\u0001:\u0005vwxyzB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u001d2\u0006\u00103\u001a\u00020\u0005J\u000e\u00104\u001a\u0002012\u0006\u00105\u001a\u00020\u0005J\u0006\u00106\u001a\u000201J\u0010\u00107\u001a\u0002012\b\u00108\u001a\u0004\u0018\u00010#J\u0010\u00109\u001a\u0002012\b\u0010:\u001a\u0004\u0018\u00010%J\u0006\u0010;\u001a\u00020\u0005J \u0010A\u001a\u0002012\u0006\u00102\u001a\u00020\u001d2\u0006\u0010B\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0005H\u0016J \u0010D\u001a\u0002012\u0006\u00102\u001a\u00020\u001d2\u0006\u0010B\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0005H\u0016J\u0010\u0010E\u001a\u0002012\u0006\u00102\u001a\u00020\u001dH\u0016J\u001c\u0010F\u001a\u0002012\n\u0010&\u001a\u00060'R\u00020\u001d2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010G\u001a\u00020\u0007H\u0016J\u0012\u0010H\u001a\u0002012\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J$\u0010I\u001a\u00020\u00052\u0006\u0010J\u001a\u00020\u00052\n\u0010&\u001a\u00060'R\u00020\u001d2\u0006\u0010(\u001a\u00020)H\u0016J$\u0010K\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u00052\n\u0010&\u001a\u00060'R\u00020\u001d2\u0006\u0010(\u001a\u00020)H\u0016J\u001c\u0010M\u001a\u0002012\n\u0010&\u001a\u00060'R\u00020\u001d2\u0006\u0010(\u001a\u00020)H\u0002J4\u0010N\u001a\u0002012\n\u0010&\u001a\u00060'R\u00020\u001d2\u0006\u0010(\u001a\u00020)2\u0006\u0010O\u001a\u00020\u00052\u0006\u0010P\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0005H\u0002J4\u0010R\u001a\u0002012\n\u0010&\u001a\u00060'R\u00020\u001d2\u0006\u0010(\u001a\u00020)2\u0006\u0010O\u001a\u00020\u00052\u0006\u0010P\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\u0005H\u0002J$\u0010T\u001a\u0002012\n\u0010&\u001a\u00060'R\u00020\u001d2\u0006\u0010(\u001a\u00020)2\u0006\u0010U\u001a\u00020\u0005H\u0002J\"\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\u00052\b\u0010Y\u001a\u0004\u0018\u00010\u00142\u0006\u0010Z\u001a\u00020WH\u0002J\b\u0010[\u001a\u000201H\u0002J$\u0010\\\u001a\u0002012\n\u0010&\u001a\u00060'R\u00020\u001d2\u0006\u0010(\u001a\u00020)2\u0006\u0010J\u001a\u00020\u0005H\u0002J\u000e\u0010]\u001a\u0002012\u0006\u0010J\u001a\u00020\u0005J\b\u0010^\u001a\u000201H\u0002J\u0010\u0010_\u001a\u0002012\u0006\u00105\u001a\u00020\u0005H\u0002J\b\u0010`\u001a\u00020\u0005H\u0002J\b\u0010a\u001a\u00020\u0005H\u0002J\u0010\u0010b\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u0005H\u0002J\u0012\u0010c\u001a\u0004\u0018\u00010d2\u0006\u0010e\u001a\u00020\u0005H\u0016J\u0014\u0010f\u001a\u00020\u0005*\u00020\u001f2\u0006\u00102\u001a\u00020\u001dH\u0002J\u0010\u0010g\u001a\u0002012\u0006\u00102\u001a\u00020\u001dH\u0002J\u0018\u0010h\u001a\u0002012\u0006\u00102\u001a\u00020\u001d2\u0006\u0010i\u001a\u00020\u0007H\u0002J\u0017\u0010j\u001a\u0004\u0018\u00010\u00052\u0006\u00102\u001a\u00020\u001dH\u0002¢\u0006\u0002\u0010kJ\u0010\u0010l\u001a\u0002012\u0006\u00105\u001a\u00020\u0005H\u0016J\u0010\u0010m\u001a\u0002012\u0006\u0010n\u001a\u00020\u0007H\u0002J\u0010\u0010o\u001a\u00020\u00072\u0006\u0010(\u001a\u00020)H\u0002J\"\u0010p\u001a\u0002012\u0006\u00102\u001a\u00020\u001d2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u00105\u001a\u00020\u0005H\u0016J'\u0010q\u001a\u0004\u0018\u0001Hr\"\u0004\b\u0000\u0010r*\n\u0012\u0006\u0012\u0004\u0018\u0001Hr0s2\u0006\u0010t\u001a\u00020\u0005¢\u0006\u0002\u0010uR\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00060!R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0018\u00010'R\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010<\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u001b\u001a\u0004\b>\u0010?¨\u0006{"}, d2 = {"Lcom/larus/gallery/tracker/ThumbnailTrackerLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "orientation", "", "reverseLayout", "", "<init>", "(Landroid/content/Context;IZ)V", "TAG", "", "DEBUG", "mOrientation", "mFirstVisiblePosition", "mLastVisiblePos", "mInitialSelectedPosition", "mCurSelectedPosition", "mScrollingPosition", "mCurSelectedView", "Landroid/view/View;", "hasSettledInitialPosition", "mState", "Lcom/larus/gallery/tracker/ThumbnailTrackerLayoutManager$State;", "getMState", "()Lcom/larus/gallery/tracker/ThumbnailTrackerLayoutManager$State;", "mState$delegate", "Lkotlin/Lazy;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mSnapHelper", "Lcom/larus/gallery/tracker/ThumbnailLinearSnapHelper;", "mInnerScrollListener", "Lcom/larus/gallery/tracker/ThumbnailTrackerLayoutManager$InnerScrollListener;", "mItemTransformer", "Lcom/larus/gallery/tracker/ThumbnailTrackerLayoutManager$ItemTransformer;", "mOnItemSelectedListener", "Lcom/larus/gallery/tracker/OnItemSelectedListener;", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "scrollToWaitForLayout", "layoutFromItemRemoved", "removePositionStart", "removeItemCount", "isViewPagerScrolling", "isHandlingPrepend", LynxViewpagerItem.BIND_ON_ATTACH, "", "recyclerView", "selectedPosition", "updateSelectedPosition", "position", "detach", "setItemTransformer", "itemTransformer", "setOnItemSelectedListener", "onItemSelectedListener", "getCurSelectedPosition", "orientationHelper", "Landroidx/recyclerview/widget/OrientationHelper;", "getOrientationHelper", "()Landroidx/recyclerview/widget/OrientationHelper;", "orientationHelper$delegate", "onItemsAdded", "positionStart", "itemCount", "onItemsRemoved", "onItemsChanged", "onLayoutChildren", "supportsPredictiveItemAnimations", "onLayoutCompleted", "scrollHorizontallyBy", "dx", "scrollVerticallyBy", "dy", "firstFillWithHorizontal", "fillLeft", "startPosition", "startOffset", "leftEdge", "fillRight", "rightEdge", "fillCover", "scrollDelta", "calculateToCenterFraction", "", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "pendingOffset", "printItemsFrames", "fillWithHorizontal", "scrollHorizontalTo", "notifyTransformItem", "performTransform", "getHorizontalSpace", "getVerticalSpace", "calculateScrollDirectionForPosition", "computeScrollVectorForPosition", "Landroid/graphics/PointF;", "targetPosition", "getSnapPosition", "maybeNotifySnapPositionChange", "notifyFlingPosition", "isFlinging", "calSnapPosition", "(Landroidx/recyclerview/widget/RecyclerView;)Ljava/lang/Integer;", "scrollToPosition", "waitForLayoutComplete", "wait", "needScrollToPosWhenLayoutCompleted", "smoothScrollToPosition", "getSafely", ExifInterface.GPS_DIRECTION_TRUE, "", "index", "(Ljava/util/List;I)Ljava/lang/Object;", "Companion", "InnerScrollListener", "State", "ScrollRect", "ItemTransformer", "gallery_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThumbnailTrackerLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f344008u = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f344009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f344010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f344011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f344012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f344013e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f344014f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f344015g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RecyclerView f344016h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ThumbnailLinearSnapHelper f344017i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final InnerScrollListener f344018j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f344019k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.larus.gallery.tracker.a f344020l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RecyclerView.Recycler f344021m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public RecyclerView.State f344022n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f344023o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f344024p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f344025q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f344026r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f344027s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f344028t;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J \u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/larus/gallery/tracker/ThumbnailTrackerLayoutManager$InnerScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "<init>", "(Lcom/larus/gallery/tracker/ThumbnailTrackerLayoutManager;)V", "mState", "", "getMState", "()I", "setMState", "(I)V", "mNeedNotifyFling", "", "getMNeedNotifyFling", "()Z", "setMNeedNotifyFling", "(Z)V", GXScroll.TYPE_ON_SCROLL_STATE_CHANGED, "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", GXScroll.TYPE_ON_SCROLLED, "dx", "dy", "gallery_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class InnerScrollListener extends RecyclerView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f344029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ThumbnailTrackerLayoutManager f344030b;

        public InnerScrollListener(ThumbnailTrackerLayoutManager r100) {
            this.f344030b = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrollStateChanged(RecyclerView r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "recyclerView");
            super.onScrollStateChanged(r100, r101);
            if (r101 != 1) goto L5;
            this.f344029a = true;
        L5:
            if (r101 != 0) goto L17;
            ThumbnailTrackerLayoutManager r102 = this.f344030b;
            int r103 = ThumbnailTrackerLayoutManager.f344008u;
            r102.w();
            ThumbnailTrackerLayoutManager r104 = this.f344030b;
            Integer r105 = r104.q(r100);
            if (r105 == null) goto L13;
            int r106 = r105.intValue();
            com.larus.gallery.tracker.a r107 = r104.f344020l;
            if (r107 == null) goto L11;
            r104.f344017i.findSnapView(r104);
            r107.onItemSelected(r106);
        L11:
            r104.f344013e = -1;
        L13:
            if (this.f344029a == false) goto L15;
            ThumbnailTrackerLayoutManager.p(this.f344030b, r100, false);
        L15:
            this.f344029a = false;
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrolled(RecyclerView r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "recyclerView");
            if (this.f344029a == false) goto L5;
            ThumbnailTrackerLayoutManager.p(this.f344030b, r100, true);
            return;
        L5:
            ThumbnailTrackerLayoutManager r103 = this.f344030b;
            int r104 = ThumbnailTrackerLayoutManager.f344008u;
            r103.q(r100);
        }
    }

    public static final class a {
    }

    public interface b {
        void a(View r100, int r101, float r102);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Rect f344031a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f344032b;

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
            if (Intrinsics.areEqual(this.f344031a, r101.f344031a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f344032b, r101.f344032b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f344031a.hashCode() * 31) + this.f344032b.hashCode();
        }

        public final String toString() {
            return "ScrollRect(startRect=" + this.f344031a + ", endRect=" + this.f344032b + ')';
        }

        public c(int r100) {
            Rect r101 = new Rect();
            Rect r102 = new Rect();
            Intrinsics.checkNotNullParameter(r101, "startRect");
            Intrinsics.checkNotNullParameter(r102, "endRect");
            this.f344031a = r101;
            this.f344032b = r102;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseArray<Rect> f344033a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SparseArray<Rect> f344034b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<c> f344035c;

        public d() {
            this.f344033a = new SparseArray();
            this.f344034b = new SparseArray();
            this.f344035c = new ArrayList();
        }
    }

    static {
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean supportsPredictiveItemAnimations() {
        return false;
    }

    public final d s() {
        return (d) this.f344015g.getValue();
    }

    public final OrientationHelper t() {
        return (OrientationHelper) this.f344028t.getValue();
    }

    public final void w() {
        if (this.f344019k == null) goto L7;
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
        this.f344009a = "ThumbnailTrackerLayoutManager";
        this.f344012d = -1;
        this.f344013e = -1;
        this.f344015g = LazyKt.lazy(new l());
        this.f344017i = new ThumbnailLinearSnapHelper();
        this.f344018j = new InnerScrollListener(this);
        this.f344028t = LazyKt.lazy(new m(this));
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
        if (r100 < this.f344010b) goto L9;
        r101 = 1;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsChanged(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onItemsChanged(r100);
        this.f344014f = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutCompleted(RecyclerView.State r100) {
        super.onLayoutCompleted(r100);
        w();
    }

    public final Integer q(RecyclerView r100) {
        ThumbnailLinearSnapHelper r101 = this.f344017i;
        RecyclerView.LayoutManager r102 = r100.getLayoutManager();
        if (r102 != null) goto L5;
    L4:
        int r103 = -1;
    L9:
        if (r103 != (-1)) goto L12;
        return null;
    L12:
        this.f344012d = r103;
        return Integer.valueOf(r103);
    L5:
        View r104 = r101.findSnapView(r102);
        if (r104 == null) goto L4;
        r103 = r102.getPosition(r104);
        goto L9
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void scrollToPosition(int r110) {
        if (this.f344021m != null) goto L6;
        return;
    L6:
        if (this.f344022n != null) goto L8;
        return;
    L8:
        RecyclerView r100 = this.f344016h;
        if (r100 != null) goto L11;
        return;
    L11:
        if (r100.getAdapter() == null) goto L71;
        this.f344011c = r110;
        if (r110 < 0) goto L57;
        RecyclerView.State r101 = this.f344022n;
        Intrinsics.checkNotNull(r101);
        if (r110 >= r101.getItemCount()) goto L57;
        int r102 = 0;
        this.f344023o = false;
        s().f344033a.clear();
        s().f344034b.clear();
        ((ArrayList) s().f344035c).clear();
        RecyclerView.Recycler r103 = this.f344021m;
        Intrinsics.checkNotNull(r103);
        RecyclerView.State r111 = this.f344022n;
        Intrinsics.checkNotNull(r111);
        RecyclerView r104 = this.f344016h;
        if (r104 != null) goto L21;
    L55:
        w();
        InnerScrollListener r105 = this.f344018j;
        RecyclerView r106 = this.f344016h;
        Intrinsics.checkNotNull(r106);
        r105.onScrolled(r106, 0, 0);
        return;
    L21:
        if (r104.getAdapter() == null) goto L55;
        this.f344014f = true;
        detachAndScrapAttachedViews(r103);
        int r112 = t().getStartAfterPadding();
        int r113 = t().getEndAfterPadding();
        int r114 = this.f344011c;
        Rect r115 = new Rect();
        int r107 = v();
        View r116 = r103.getViewForPosition(this.f344011c);
        addView(r116, 0);
        measureChildWithMargins(r116, 0, 0);
        int r108 = getDecoratedMeasuredWidth(r116);
        int r109 = getDecoratedMeasuredHeight(r116);
        int r117 = (int) (getPaddingTop() + ((r107 - r109) / 2.0f));
        int r118 = (int) (getPaddingLeft() + ((((getWidth() - getPaddingRight()) - getPaddingLeft()) - r108) / 2.0f));
        r115.set(r118, r117, r108 + r118, r109 + r117);
        layoutDecorated(r116, r115.left, r115.top, r115.right, r115.bottom);
        if (s().f344033a.get(r114) != null) goto L26;
        s().f344033a.put(r114, r115);
    L27:
        this.f344010b = r114;
        int r119 = getDecoratedLeft(r116);
        int r120 = getDecoratedRight(r116);
        int r121 = this.f344011c - 1;
        int r122 = v();
        int r123 = r121;
    L28:
        if (r123 < 0) goto L39;
        if (r119 <= r112) goto L39;
        if (r123 >= r111.getItemCount()) goto L39;
        RecyclerView r124 = this.f344016h;
        Intrinsics.checkNotNull(r124);
        RecyclerView.Adapter r125 = r124.getAdapter();
        Intrinsics.checkNotNull(r125);
        if (r123 >= r125.getItemCount()) goto L39;
        Rect r126 = new Rect();
        View r127 = r103.getViewForPosition(r123);
        addView(r127, r102);
        measureChildWithMargins(r127, r102, r102);
        int r128 = getDecoratedMeasuredWidth(r127);
        int r129 = getDecoratedMeasuredHeight(r127);
        int r130 = (int) (getPaddingTop() + ((r122 - r129) / 2.0f));
        r126.set(r119 - r128, r130, r119, r129 + r130);
        layoutDecorated(r127, r126.left, r126.top, r126.right, r126.bottom);
        r119 = r126.left;
        this.f344010b = r123;
        if (s().f344033a.get(r123) != null) goto L37;
        s().f344033a.put(r123, r126);
    L38:
        r123 = r123 - 1;
        r102 = 0;
        goto L28
    L37:
        Rect r131 = s().f344033a.get(r123);
        Intrinsics.checkNotNull(r131);
        r131.set(r126);
    L39:
        int r132 = this.f344011c + 1;
        RecyclerView r133 = this.f344016h;
        if (r133 == null) goto L55;
        if (r133.getAdapter() == null) goto L55;
        int r134 = v();
        int r135 = r132;
    L46:
        if (r135 >= r111.getItemCount()) goto L55;
        RecyclerView r136 = this.f344016h;
        Intrinsics.checkNotNull(r136);
        RecyclerView.Adapter r137 = r136.getAdapter();
        Intrinsics.checkNotNull(r137);
        if (r135 >= r137.getItemCount()) goto L55;
        if (r120 >= r113) goto L55;
        Rect r138 = new Rect();
        View r139 = r103.getViewForPosition(r135);
        addView(r139);
        measureChildWithMargins(r139, 0, 0);
        int r140 = getDecoratedMeasuredWidth(r139);
        int r141 = getDecoratedMeasuredHeight(r139);
        int r142 = (int) (getPaddingTop() + ((r134 - r141) / 2.0f));
        r138.set(r120, r142, r140 + r120, r141 + r142);
        layoutDecorated(r139, r138.left, r138.top, r138.right, r138.bottom);
        r120 = r138.right;
        if (s().f344033a.get(r135) != null) goto L53;
        s().f344033a.put(r135, r138);
    L54:
        r135 = r135 + 1;
        goto L46
    L53:
        Rect r143 = s().f344033a.get(r135);
        Intrinsics.checkNotNull(r143);
        r143.set(r138);
        goto L54
    L26:
        Rect r144 = s().f344033a.get(r114);
        Intrinsics.checkNotNull(r144);
        r144.set(r115);
    L57:
        this.f344023o = true;
        return;
    }

    public final void x(int r100) {
        View r101 = getChildAt(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        OrientationHelper r102 = t();
        float r103 = Math.max(-1.0f, Math.min(1.0f, (((int) ((((r101.getWidth() / 2.0f) - 0.0f) + r101.getLeft()) - (((r102.getEndAfterPadding() - r102.getStartAfterPadding()) / 2) + r102.getStartAfterPadding()))) * 1.0f) / r101.getWidth()));
        b r104 = this.f344019k;
        Intrinsics.checkNotNull(r104);
        r104.a(r101, r101.getWidth(), r103);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r101) {
        Intrinsics.checkNotNullParameter(r100, "recycler");
        Intrinsics.checkNotNullParameter(r101, "state");
        this.f344021m = r100;
        this.f344022n = r101;
        if (this.f344014f == false) goto L22;
        RecyclerView r102 = this.f344016h;
        if (r102 != null) goto L7;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == true) goto L22;
        if (this.f344027s == false) goto L20;
        int r104 = -1;
    L21:
        r(r100, r101, r104);
        w();
        this.f344024p = false;
    L23:
        this.f344027s = false;
        return;
    L20:
        r104 = 0;
        goto L21
    L7:
        if (r102.getAdapter() == null) goto L14;
        if (this.f344023o == false) goto L14;
        int r105 = r101.getItemCount();
        RecyclerView r106 = this.f344016h;
        Intrinsics.checkNotNull(r106);
        RecyclerView.Adapter r107 = r106.getAdapter();
        Intrinsics.checkNotNull(r107);
        if (r105 != r107.getItemCount()) goto L14;
        r103 = true;
    L22:
        scrollToPosition(Math.min(Math.max(0, this.f344011c), getItemCount() - 1));
        goto L23
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
        if (r100.f344013e == r104) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == false) goto L15;
        com.larus.gallery.tracker.a r106 = r100.f344020l;
        if (r106 == null) goto L12;
        r106.a(r104, r102);
    L12:
        r100.f344013e = r104;
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
        FLogger.f375446a.i(this.f344009a, "onItemsAdded positionStart = " + r101 + "  itemCount = " + r102 + ", curSelectedPosition = " + this.f344012d);
        if (r101 != 0) goto L10;
        this.f344027s = true;
        int r103 = this.f344012d + r102;
        this.f344012d = r103;
        this.f344011c = r103;
        this.f344010b += r102;
        SparseArray r104 = new SparseArray();
        SparseArray<Rect> r105 = s().f344033a;
        int r106 = r105.size();
        int r107 = 0;
    L5:
        if (r107 >= r106) goto L7;
        r104.put(r105.keyAt(r107) + r102, r105.valueAt(r107));
        r107 = r107 + 1;
        goto L5
    L7:
        s().f344033a.clear();
        SparseArrayKt.putAll(s().f344033a, r104);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsRemoved(RecyclerView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onItemsRemoved(r100, r101, r102);
        this.f344024p = true;
        this.f344025q = r101;
        this.f344026r = r102;
    }

    public final void r(RecyclerView.Recycler r110, RecyclerView.State r111, int r210) {
        if (getItemCount() != 0) goto L5;
        return;
    L5:
        int r100 = t().getStartAfterPadding();
        int r101 = t().getEndAfterPadding();
        int r112 = -1;
        if (getChildCount() <= 0) goto L35;
        if (r210 < 0) goto L29;
        int r102 = getChildCount();
        int r103 = 0;
        int r104 = 0;
    L9:
        if (r103 >= r102) goto L14;
        View r105 = getChildAt(r103 + r104);
        Intrinsics.checkNotNull(r105);
        if ((getDecoratedRight(r105) - r210) >= r100) goto L14;
        removeAndRecycleView(r105, r110);
        s().f344033a.remove(r103);
        this.f344010b++;
        r104 = r104 - 1;
        r103 = r103 + 1;
    L14:
        if (this.f344024p == false) goto L35;
        View r106 = findViewByPosition(this.f344025q - 1);
        if (r106 == null) goto L35;
        RecyclerView r107 = this.f344016h;
        Intrinsics.checkNotNull(r107);
        int r108 = r107.indexOfChild(r106) + 1;
        int r109 = this.f344026r + r108;
    L18:
        if (r108 >= r109) goto L35;
        if (1 <= r108) goto L21;
    L23:
        boolean r113 = false;
    L24:
        if (r113 == false) goto L28;
        View r114 = getChildAt(r108);
        if (r114 == null) goto L28;
        removeAndRecycleView(r114, r110);
        s().f344033a.remove(r108);
    L28:
        r108 = r108 + 1;
        goto L18
    L21:
        if (r108 >= getChildCount()) goto L23;
        r113 = true;
        goto L24
    L29:
        int r115 = getChildCount() - 1;
    L30:
        if ((-1) >= r115) goto L35;
        View r116 = getChildAt(r115);
        Intrinsics.checkNotNull(r116);
        if ((getDecoratedLeft(r116) - r210) <= r101) goto L34;
        removeAndRecycleView(r116, r110);
        s().f344033a.remove(r115);
    L34:
        r115 = r115 - 1;
    L35:
        int r117 = this.f344010b;
        int r118 = v();
        if (r210 < 0) goto L63;
        if (getChildCount() == 0) goto L47;
        View r119 = getChildAt(getChildCount() - 1);
        View r120 = findViewByPosition(this.f344025q - 1);
        if (this.f344024p == false) goto L43;
        if (r120 == null) goto L43;
        r117 = this.f344025q;
        int r121 = getDecoratedRight(r120);
    L46:
        int r122 = r117;
    L48:
        int r123 = r122;
    L50:
        if (r123 >= r111.getItemCount()) goto L75;
        if (r121 >= (r101 + r210)) goto L94;
        Rect r124 = s().f344033a.get(r123);
        View r125 = r110.getViewForPosition(r123);
        addView(r125);
        if (r124 != null) goto L56;
        r124 = new Rect();
        s().f344033a.put(r123, r124);
    L56:
        Rect r126 = r124;
        measureChildWithMargins(r125, 0, 0);
        int r127 = getDecoratedMeasuredWidth(r125);
        int r128 = getDecoratedMeasuredHeight(r125);
        int r129 = (int) (getPaddingTop() + ((r118 - r128) / 2.0f));
        if (r121 != (-1)) goto L60;
        if (r122 != 0) goto L60;
        int r130 = (int) (getPaddingLeft() + ((((getWidth() - getPaddingRight()) - getPaddingLeft()) - r127) / 2.0f));
        r126.set(r130, r129, r127 + r130, r128 + r129);
    L61:
        layoutDecorated(r125, r126.left, r126.top, r126.right, r126.bottom);
        r121 = r126.right;
        r123 = r123 + 1;
    L60:
        r126.set(r121, r129, r127 + r121, r128 + r129);
        goto L61
    L94:
        return;
    L75:
        return;
    L43:
        if (r119 == null) goto L45;
        r117 = getPosition(r119) + 1;
        r121 = getDecoratedRight(r119);
        goto L46
    L45:
        r121 = -1;
        goto L46
    L47:
        r122 = r117;
        r121 = -1;
        goto L48
    L63:
        if (getChildCount() <= 0) goto L65;
        View r131 = getChildAt(0);
        Intrinsics.checkNotNull(r131);
        int r132 = getPosition(r131) - 1;
        r112 = getDecoratedLeft(r131);
        r117 = r132;
    L65:
        int r133 = r117;
    L66:
        if (r133 < 0) goto L95;
        if (r112 <= (r100 + r210)) goto L96;
        if (r133 >= r111.getItemCount()) goto L97;
        Rect r134 = s().f344033a.get(r133);
        View r135 = r110.getViewForPosition(r133);
        addView(r135, 0);
        if (r134 != null) goto L74;
        r134 = new Rect();
        s().f344033a.put(r133, r134);
    L74:
        Rect r136 = r134;
        measureChildWithMargins(r135, 0, 0);
        int r137 = getDecoratedMeasuredWidth(r135);
        int r138 = getDecoratedMeasuredHeight(r135);
        int r139 = (int) (getPaddingTop() + ((r118 - r138) / 2.0f));
        r136.set(r112 - r137, r139, r112, r138 + r139);
        layoutDecorated(r135, r136.left, r136.top, r136.right, r136.bottom);
        r112 = r136.left;
        this.f344010b = r133;
        r133 = r133 - 1;
        goto L66
    L97:
        return;
    L96:
        return;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollHorizontallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        Intrinsics.checkNotNullParameter(r101, "recycler");
        Intrinsics.checkNotNullParameter(r102, "state");
        if (getChildCount() == 0) goto L19;
        if (r100 == 0) goto L20;
        int r103 = -r100;
        int r104 = ((t().getEndAfterPadding() - t().getStartAfterPadding()) / 2) + t().getStartAfterPadding();
        if (r100 < 0) goto L14;
        View r105 = getChildAt(getChildCount() - 1);
        int r106 = getItemCount() - 1;
        if (r105 != null) goto L11;
    L17:
        int r107 = -r103;
        s().getClass();
        r(r101, r102, r107);
        offsetChildrenHorizontal(r103);
        w();
        return r107;
    L11:
        if (getPosition(r105) < r106) goto L17;
        int r108 = Math.max(0, Math.min(r100, (((r105.getRight() - r105.getLeft()) / 2) + r105.getLeft()) - r104));
    L16:
        r103 = -r108;
        goto L17
    L14:
        if (this.f344010b != 0) goto L17;
        View r109 = getChildAt(0);
        Intrinsics.checkNotNull(r109);
        r108 = Math.min(0, Math.max(r100, (((r109.getRight() - r109.getLeft()) / 2) + r109.getLeft()) - r104));
        goto L16
    L20:
        return 0;
    L19:
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollVerticallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        Intrinsics.checkNotNullParameter(r101, "recycler");
        Intrinsics.checkNotNullParameter(r102, "state");
        if (getChildCount() == 0) goto L17;
        if (r100 == 0) goto L18;
        int r103 = -r100;
        int r104 = ((t().getEndAfterPadding() - t().getStartAfterPadding()) / 2) + t().getStartAfterPadding();
        if (r100 <= 0) goto L12;
        View r105 = getChildAt(getChildCount() - 1);
        Intrinsics.checkNotNull(r105);
        if (getPosition(r105) != (getItemCount() - 1)) goto L15;
        View r106 = getChildAt(getChildCount() - 1);
        Intrinsics.checkNotNull(r106);
        int r107 = Math.max(0, Math.min(r100, (((getDecoratedBottom(r106) - getDecoratedTop(r106)) / 2) + getDecoratedTop(r106)) - r104));
    L14:
        r103 = -r107;
    L15:
        int r108 = -r103;
        s().getClass();
        r(r101, r102, r108);
        offsetChildrenVertical(r103);
        w();
        return r108;
    L12:
        if (this.f344010b != 0) goto L15;
        View r109 = getChildAt(0);
        Intrinsics.checkNotNull(r109);
        r107 = Math.min(0, Math.max(r100, (((getDecoratedBottom(r109) - getDecoratedTop(r109)) / 2) + getDecoratedTop(r109)) - r104));
        goto L14
    L18:
        return 0;
    L17:
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView r100, RecyclerView.State r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        final Context r103 = r100.getContext();
        LinearSmoothScroller r104 = new ThumbnailTrackerLayoutManager$smoothScrollToPosition$smoothScroller$1(this, r103);
        r104.setTargetPosition(r102);
        startSmoothScroll(r104);
    }
}
