package com.larksuite.common_selection;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.collection.ArrayMap;
import com.baidu.platform.comapi.map.MapController;
import com.byted.cast.common.CastMonitor;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.common_selection.selectionhandle.SelectionHandleType;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 t2\u00020\u0001:\u0001tB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u00108\u001a\u00020\u00182\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u0002022\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020)H\u0002J(\u0010?\u001a\u00020\u00182\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0007H\u0014J\u0010\u0010D\u001a\u00020\u00132\u0006\u0010E\u001a\u00020=H\u0002J\u0012\u0010F\u001a\u00020\u00132\b\u0010E\u001a\u0004\u0018\u00010=H\u0016J\u0010\u0010G\u001a\u00020\u00132\u0006\u0010E\u001a\u00020=H\u0016J\u0010\u0010H\u001a\u00020\u00132\u0006\u0010I\u001a\u00020=H\u0017J0\u0010J\u001a\u00020\u00182\u0006\u0010K\u001a\u00020\u00132\u0006\u0010L\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u0007H\u0014J\b\u0010P\u001a\u00020\u0018H\u0002J\u0010\u0010Q\u001a\u00020\u00182\u0006\u0010R\u001a\u00020\u001eH\u0002J\u0010\u0010S\u001a\u00020\u00182\u0006\u0010T\u001a\u00020UH\u0014J\u0010\u0010V\u001a\u00020\u00182\u0006\u0010T\u001a\u00020UH\u0014J\u0010\u0010W\u001a\u00020\u00182\u0006\u0010T\u001a\u00020UH\u0002J\b\u0010X\u001a\u00020\u0018H\u0002J0\u0010Y\u001a\u00020\u00182\u0006\u0010Z\u001a\u00020\u001e2\u0006\u0010[\u001a\u00020\u00132\u0006\u0010\\\u001a\u00020\u00132\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\u000fH\u0002J\u001f\u0010`\u001a\u0004\u0018\u0001022\u0006\u0010a\u001a\u00020/2\u0006\u0010b\u001a\u00020/H\u0000¢\u0006\u0002\bcJ\u0010\u0010d\u001a\u00020\u00182\u0006\u0010e\u001a\u00020\u0013H\u0016J\b\u0010f\u001a\u00020\u0018H\u0002J\u001a\u0010g\u001a\u0004\u0018\u0001022\u0006\u0010a\u001a\u00020/2\u0006\u0010b\u001a\u00020/H\u0002J\u001a\u0010h\u001a\u0004\u0018\u0001022\u0006\u0010a\u001a\u00020/2\u0006\u0010b\u001a\u00020/H\u0002J\u001a\u0010i\u001a\u0004\u0018\u0001022\u0006\u0010a\u001a\u00020/2\u0006\u0010b\u001a\u00020/H\u0002J \u0010j\u001a\u0002022\u0006\u0010Z\u001a\u00020\u001e2\u0006\u0010k\u001a\u00020/2\u0006\u0010l\u001a\u00020/H\u0002J\u0018\u0010m\u001a\u00020\r2\u0006\u0010n\u001a\u00020\u001e2\u0006\u0010o\u001a\u00020\rH\u0002J\b\u0010p\u001a\u00020\u0018H\u0016J\u001c\u0010q\u001a\u00020\u00182\u0006\u0010r\u001a\u00020\u00072\f\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\r0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00070#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006u"}, d2 = {"Lcom/larksuite/common_selection/SelectionContainer;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tempRect", "Landroid/graphics/Rect;", "tempRectF", "Landroid/graphics/RectF;", DBDefinition.TEMP_PATH, "Landroid/graphics/Path;", "highlightPath", "touchSlop", "isInitialDragSelect", "", "skipActionUPOnTouchEvent", "isInActionDown", "externalLongClickListener", "Lkotlin/Function0;", "", "externalLongPressTimeOut", "initialSelectionGranularity", "Lcom/larksuite/common_selection/SelectionGranularity;", "flatSelectableItems", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "getFlatSelectableItems$common_selection_release", "()Ljava/util/ArrayList;", "viewBoundsCache", "Landroidx/collection/ArrayMap;", "viewIndexCache", "isBoundsCacheDirty", "isSelectableListDirty", "childCountAtLastRebuild", "selectionManager", "Lcom/larksuite/common_selection/SelectionManager;", "getSelectionManager", "()Lcom/larksuite/common_selection/SelectionManager;", "setSelectionManager", "(Lcom/larksuite/common_selection/SelectionManager;)V", "lastTouchX", "", "lastTouchY", "dragAnchorPoint", "Lcom/larksuite/common_selection/SelectionPoint;", "disallowInterceptTouchEventRequested", "externalLongPressRunnable", "Ljava/lang/Runnable;", "gestureDetector", "Landroid/view/GestureDetector;", "initialSelection", "option", "Lcom/larksuite/common_selection/SelectionOption;", "point", "e", "Landroid/view/MotionEvent;", SRStrategy.KEY_SR_STRATEGY_MODE, "onSizeChanged", "w", "h", "oldw", "oldh", "isActionDownOnHandle", "ev", "dispatchTouchEvent", "onInterceptTouchEvent", "onTouchEvent", "event", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "buildFlatSelectableList", "addSelectableViewRecursively", "view", "onDraw", "canvas", "Landroid/graphics/Canvas;", "dispatchDraw", "drawSelectionHighlight", "updateViewBoundsCache", "getHighlightPathForItem", MapController.ITEM_LAYER_TAG, "isStart", "isEnd", FilterData.FilterOptionItem.Type.RANGE, "Lcom/larksuite/common_selection/SelectionRange;", "outPath", "findNearestSelectionPointAt", "containerX", "containerY", "findNearestSelectionPointAt$common_selection_release", "requestDisallowInterceptTouchEvent", "disallowIntercept", "updateCachesIfNeeded", "findDirectHit", "findNextPointForDrag", "findNearestPointGlobally", "getPrecisePointInItem", "localX", "localY", "getDescendantBoundsInContainer", "descendant", "outRect", "invalidate", "setExternalLongClickListener", "timeOut", "handleLongClick", "Companion", "common-selection_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectionContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f282827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f282828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f282829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Path f282830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f282831e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f282832f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f282833g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f282834h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function0<Unit> f282835i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f282836j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public SelectionGranularity f282837k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList<View> f282838l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayMap<View, RectF> f282839m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayMap<View, Integer> f282840n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f282841o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f282842p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f282843q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public i f282844r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f282845s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f282846t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public o f282847u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f282848v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final d f282849w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final GestureDetector f282850x;

    public static final class a implements ViewGroup.OnHierarchyChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SelectionContainer f282851a;

        public a(SelectionContainer r100) {
            this.f282851a = r100;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewAdded(View r100, View r101) {
            SelectionContainer r102 = this.f282851a;
            r102.f282842p = true;
            r102.f282841o = true;
            r102.invalidate();
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewRemoved(View r100, View r101) {
            SelectionContainer r102 = this.f282851a;
            r102.f282842p = true;
            r102.f282841o = true;
            r102.invalidate();
        }
    }

    public static final class b {
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f282852a = null;

        static {
            int[] r100 = new int[SelectionInitiationMode.values().length];
            r100[SelectionInitiationMode.SELECT_ON_CONTENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[SelectionInitiationMode.SELECT_ANYWHERE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f282852a = r100;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f282853a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SelectionContainer f282854b;

        public d(Context r100, SelectionContainer r101) {
            this.f282853a = r100;
            this.f282854b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Log.d("SelectionContainer", "externalLongPressRunnable, execute");     // Catch: Throwable -> L14
            com.larksuite.common_selection.a.a(this.f282853a);     // Catch: Throwable -> L14
            Function0<Unit> r100 = this.f282854b.f282835i;     // Catch: Throwable -> L14
            if (r100 == null) goto L5;
            r100.invoke();     // Catch: Throwable -> L14
        L5:
            i r101 = this.f282854b.getSelectionManager();     // Catch: Throwable -> L14
            if (r101 != null) goto L9;
            return;
        L9:
            if (r101.f282877j == null) goto L11;
        L12:
            r101.d();     // Catch: Throwable -> L14
            return;
        L11:
            if (r101.h() == true) goto L12;
            return;
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L22;
            throw th;
        }
    }

    public static final class e extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SelectionContainer f282855a;

        public e(SelectionContainer r100) {
            this.f282855a = r100;
        }

        public final boolean a(i r100) {
            if (r100.h() == true) goto L5;
        L13:
            return false;
        L5:
            if (Intrinsics.areEqual(r100.f282878k, this.f282855a) == false) goto L13;
            if (r100.f282881n == null) goto L9;
            boolean r101 = true;
        L10:
            if (r101 == true) goto L13;
            this.f282855a.f282847u = null;
            r100.d();
            return true;
        L9:
            r101 = false;
            goto L10
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            i r101 = this.f282855a.getSelectionManager();
            if (r101 != null) goto L7;
            return super.onDoubleTap(r100);
        L7:
            if (Intrinsics.areEqual(r101.f282878k, this.f282855a) == true) goto L9;
            o r102 = this.f282855a.e(r100.getX(), r100.getY());
            if (r102 == null) goto L13;
            n r103 = r101.f282875h.get(TriggerMode.DoubleTap);
            if (r103 == null) goto L17;
            this.f282855a.getParent().requestDisallowInterceptTouchEvent(true);
            SelectionContainer.a(this.f282855a, r103, r102, r100, r101);
            return true;
        L17:
            return super.onDoubleTap(r100);
        L13:
            return super.onDoubleTap(r100);
        L9:
            return a(r101);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            i r101 = this.f282855a.getSelectionManager();
            if (r101 != null) goto L6;
            return;
        L6:
            if (r101.f282881n == null) goto L8;
            boolean r102 = true;
        L9:
            if (r102 == false) goto L11;
            return;
        L11:
            SelectionContainer r103 = this.f282855a;
            if (r103.f282848v == false) goto L14;
            return;
        L14:
            o r104 = r103.e(r100.getX(), r100.getY());
            if (r104 != null) goto L17;
            return;
        L17:
            n r105 = r101.f282875h.get(TriggerMode.LongPress);
            if (r105 != null) goto L20;
            return;
        L20:
            this.f282855a.getParent().requestDisallowInterceptTouchEvent(true);
            SelectionContainer.a(this.f282855a, r105, r104, r100, r101);
            return;
        L8:
            r102 = false;
            goto L9
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            i r101 = this.f282855a.getSelectionManager();
            if (r101 != null) goto L7;
            return onSingleTapConfirmed(r100);
        L7:
            if (a(r101) == false) goto L9;
        L12:
            return true;
        L9:
            if (super.onSingleTapUp(r100) == true) goto L12;
            return false;
        }
    }

    static {
    }

    public SelectionContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SelectionContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void invalidate() {
        this.f282841o = true;
        super.invalidate();
    }

    public final void c() {
        this.f282838l.clear();
        this.f282839m.clear();
        this.f282840n.clear();
        int r100 = getChildCount();
        int r101 = r100 * 2;
        this.f282838l.ensureCapacity(r101);
        this.f282839m.ensureCapacity(r101);
        this.f282840n.ensureCapacity(r101);
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        View r103 = getChildAt(r102);
        Intrinsics.checkNotNull(r103);
        b(r103);
        r102 = r102 + 1;
        goto L3
    }

    public final void h() {
        this.f282839m.clear();
        Iterator<View> r100 = this.f282838l.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        View r101 = r100.next();
        RectF r102 = this.f282828b;
        f(r101, r102);
        this.f282839m.put(r101, new RectF(r102));
        goto L4
    }

    public final ArrayList<View> getFlatSelectableItems$common_selection_release() {
        return this.f282838l;
    }

    public final i getSelectionManager() {
        return this.f282844r;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(View r100) {
        if ((r100 instanceof com.larksuite.common_selection.c) == false) goto L9;
        Iterator<View> r101 = ((com.larksuite.common_selection.c) r100).a().iterator();
    L6:
        if (r101.hasNext() == false) goto L14;
        b(r101.next());
        goto L6
    L14:
        return;
    L9:
        if ((r100 instanceof com.larksuite.common_selection.d) == true) goto L13;
        this.f282840n.put(r100, Integer.valueOf(this.f282838l.size()));
        this.f282838l.add(r100);
        return;
    }

    public final void d(Canvas r110) {
        i r100 = this.f282844r;
        if (r100 != null) goto L5;
        return;
    L5:
        p r101 = r100.f282877j;
        if (r101 != null) goto L8;
        return;
    L8:
        View r102 = r101.f282910a.f282908a;
        if (r102 != null) goto L11;
    L13:
        boolean r103 = false;
    L14:
        if (r103 == true) goto L16;
        return;
    L16:
        if (r102 != null) goto L18;
        return;
    L18:
        View r104 = r101.f282911b.f282908a;
        if (r104 != null) goto L22;
        return;
    L22:
        if (this.f282841o == false) goto L24;
        h();
        this.f282841o = false;
    L24:
        int r105 = this.f282838l.size();
        int r106 = 0;
        boolean r107 = false;
    L25:
        if (r106 >= r105) goto L50;
        View r111 = (View) ListProtector.get(this.f282838l, r106);
        if (Intrinsics.areEqual(r111, r102) == false) goto L29;
        r107 = true;
    L29:
        if (r107 == false) goto L47;
        this.f282830d.reset();
        boolean r112 = Intrinsics.areEqual(r111, r102);
        boolean r113 = Intrinsics.areEqual(r111, r104);
        Path r114 = this.f282830d;
        this.f282829c.reset();
        RectF r115 = this.f282839m.get(r111);
        if (r115 != null) goto L33;
        r115 = this.f282828b;
        f(r111, r115);
    L33:
        t r116 = t.f282928a;
        s r117 = t.a(r111);
        if (r117 != null) goto L36;
        r117 = t.f282930c;
    L36:
        if (r112 == false) goto L38;
        int r118 = r101.f282910a.f282909b;
    L39:
        if (r113 == false) goto L41;
        int r119 = r101.f282911b.f282909b;
    L42:
        if (r118 >= r119) goto L44;
        r117.e(r111, r118, r119, this.f282829c);
        r114.addPath(this.f282829c, r115.left, r115.top);
    L44:
        r110.drawPath(this.f282830d, r100.f282876i);
        goto L47
    L41:
        r119 = r117.a(r111);
        goto L42
    L38:
        r118 = 0;
    L47:
        if (Intrinsics.areEqual(r111, r104) == false) goto L49;
        r107 = false;
    L49:
        r106 = r106 + 1;
        goto L25
    L50:
        return;
    L11:
        if (r101.f282911b.f282908a == null) goto L13;
        r103 = true;
        goto L14
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        i r101 = this.f282844r;
        if (r101 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r101.f282878k, this) == true) goto L8;
        return;
    L8:
        if (r101.f282874g == DrawHighlightStyle.BACKGROUND) goto L13;
        d(r100);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (r100 != null) goto L6;
        return super.dispatchTouchEvent(r100);
    L6:
        if (r100.getAction() != 0) goto L10;
        this.f282848v = false;
        this.f282833g = false;
        this.f282834h = true;
        boolean r101 = super.dispatchTouchEvent(r100) | true;
        this.f282834h = false;
        return r101;
    L10:
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        i r101 = this.f282844r;
        if (r101 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r101.f282878k, this) == true) goto L8;
        return;
    L8:
        if (r101.f282874g == DrawHighlightStyle.FOREGROUND) goto L13;
        d(r100);
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "ev");
        Log.d("SelectionContainer", "onInterceptTouchEvent: action is " + r110.getAction());
        i r100 = this.f282844r;
        if (r100 == null) goto L5;
        int r101 = r110.getAction();
        boolean r102 = false;
        if (r101 != 0) goto L44;
        this.f282845s = r110.getX();
        this.f282846t = r110.getY();
        i r103 = this.f282844r;
        if (r103 == null) goto L36;
        ly7.c r104 = r103.f282879l;
        View r105 = null;
        if (r104 == null) goto L14;
        View r106 = r104.getView();
    L15:
        ly7.c r107 = r103.f282880m;
        if (r107 == null) goto L18;
        r105 = r107.getView();
    L18:
        if (r106 != null) goto L20;
    L27:
        if (r105 == null) goto L36;
        if (r105.getVisibility() != 0) goto L31;
        boolean r108 = true;
    L32:
        if (r108 == false) goto L36;
        r105.getHitRect(this.f282827a);
        if (this.f282827a.contains((int) r110.getX(), (int) r110.getY()) == false) goto L36;
    L35:
        boolean r109 = true;
    L37:
        if (r109 == false) goto L41;
        Log.d("SelectionContainer", "isActionDownOnHandle true, action is " + r101);
        return false;
    L41:
        if (this.f282835i == null) goto L44;
        Log.d("SelectionContainer", "try to trigger long press, action is " + r101);
        getHandler().postDelayed(this.f282849w, (long) this.f282836j);
        goto L44
    L31:
        r108 = false;
        goto L32
    L20:
        if (r106.getVisibility() != 0) goto L22;
        boolean r111 = true;
    L23:
        if (r111 == false) goto L27;
        r106.getHitRect(this.f282827a);
        if (this.f282827a.contains((int) r110.getX(), (int) r110.getY()) == false) goto L27;
    L22:
        r111 = false;
        goto L23
    L14:
        r106 = null;
    L36:
        r109 = false;
    L44:
        if (r100.f282881n == null) goto L46;
        boolean r112 = true;
    L47:
        if (r112 == false) goto L50;
        Log.d("SelectionContainer", "sm.isHandleBeingDragged, action is " + r101);
        return true;
    L50:
        i r113 = this.f282844r;
        if (r113 != null) goto L53;
    L55:
        boolean r114 = this.f282850x.onTouchEvent(r110);
        if (this.f282832f == false) goto L60;
        if (r101 != 1) goto L60;
        boolean r115 = onTouchEvent(r110);
        this.f282833g = true;
        Log.d("SelectionContainer", "skipActionUPOnTouchEvent true, action is " + r101);
        getHandler().removeCallbacks(this.f282849w);
        return r115;
    L60:
        if (r101 != 1) goto L62;
    L64:
        getHandler().removeCallbacks(this.f282849w);
        if (r102 == false) goto L69;
        Log.d("SelectionContainer", "isHandleShowing, action is " + r101);
        return r114;
    L69:
        if (r101 != 2) goto L76;
        float r116 = Math.abs(r110.getX() - this.f282845s);
        float r117 = Math.abs(r110.getY() - this.f282846t);
        float r118 = this.f282831e;
        if (r116 <= r118) goto L73;
    L74:
        Log.d("SelectionContainer", "deltaX or deltaY > touchSlop, action is " + r101);
        getHandler().removeCallbacks(this.f282849w);
        goto L76
    L73:
        if (r117 > r118) goto L74;
    L76:
        return this.f282832f;
    L62:
        if (r101 == 3) goto L64;
    L53:
        if (r113.h() != true) goto L55;
        r102 = true;
        goto L55
    L46:
        r112 = false;
        goto L47
    L5:
        return super.onInterceptTouchEvent(r110);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        Log.d("SelectionContainer", "onTouchEvent, called");
        final boolean r100 = false;
        if (r110.getActionMasked() == 1) goto L5;
    L8:
        final i r101 = this.f282844r;
        if (r101 != null) goto L13;
        return super.onTouchEvent(r110);
    L13:
        if (r101.f282881n == null) goto L15;
        boolean r102 = true;
    L16:
        if (r102 == true) goto L18;
        this.f282850x.onTouchEvent(r110);
    L18:
        int r103 = r110.getAction();
        if (r103 != 0) goto L21;
        String r104 = "SelectionContainer";
        this.f282845s = r110.getX();
        this.f282846t = r110.getY();
    L179:
        Log.d(r104, "onTouchEvent, action is " + r110.getAction() + ", result is true");
        return true;
    L21:
        if (r103 == 1) goto L116;
        if (r103 != 2) goto L25;
        float r105 = Math.abs(r110.getX() - this.f282845s);
        float r111 = Math.abs(r110.getY() - this.f282846t);
        float r112 = this.f282831e;
        if (r105 <= r112) goto L30;
    L31:
        this.f282845s = r110.getX();
        this.f282846t = r110.getY();
        if (this.f282832f == false) goto L63;
        o r106 = this.f282847u;
        if (r106 != null) goto L36;
        return true;
    L36:
        o r107 = e(r110.getX(), r110.getY());
        if (r107 != null) goto L39;
        return true;
    L39:
        Integer r113 = this.f282840n.get(r106.f282908a);
        int r114 = -1;
        if (r113 == null) goto L42;
        int r115 = r113.intValue();
    L43:
        Integer r116 = this.f282840n.get(r107.f282908a);
        if (r116 == null) goto L46;
        r114 = r116.intValue();
    L46:
        if (r115 > r114) goto L51;
        if (r115 == r114) goto L50;
    L52:
        boolean r117 = false;
    L53:
        if (r117 == false) goto L55;
        r107 = r106;
        r106 = r107;
    L55:
        r101.n(r106, r107);
        final SelectionContainer r108 = r101.f282878k;
        if (r108 != null) goto L59;
    L62:
        r101.j(r110);
        Log.d("SelectionContainer", "MotionEvent.ACTION_MOVE, dx dy is " + r105 + ", " + r111 + ", handler.removeCallbacks(externalLongPressRunnable)");
        getHandler().removeCallbacks(this.f282849w);
    L26:
        String r118 = "SelectionContainer";
    L114:
        r104 = r118;
        goto L179
    L59:
        if (r101.f282884q == false) goto L61;
        r108.post(new l(r101, false));
        goto L62
    L61:
        r108.post(new SelectionManager$showHandles$2(r101, r108, r100));
        goto L62
    L50:
        if (r106.f282909b <= r107.f282909b) goto L52;
    L51:
        r117 = true;
        goto L53
    L42:
        r115 = -1;
        goto L43
    L63:
        if (r102 == false) goto L26;
        float r109 = r110.getRawX();
        float r119 = r110.getRawY();
        p r120 = r101.f282877j;
        if (r120 == null) goto L84;
        SelectionContainer r121 = r101.f282878k;
        if (r121 == null) goto L84;
        SelectionHandleType r122 = r101.f282881n;
        if (r122 == null) goto L84;
        SelectionHandleType r123 = SelectionHandleType.START;
        if (r122 != r123) goto L77;
        ly7.c r124 = r101.f282879l;
    L80:
        if (r124 == null) goto L84;
        Point r125 = r124.h(r109, r119);
        int r126 = r125.x;
        int r127 = r125.y;
        int[] r128 = new int[2];
        r121.getLocationOnScreen(r128);
        float r129 = r126 - r128[0];
        float r130 = r127 - r128[1];
        o r131 = r121.e(r129, r130);
        if (r131 == null) goto L84;
        r118 = "SelectionContainer";
        Log.d("SelectionManager", "handleDrag: " + r129 + ", " + r130 + ", point: " + r131);
        o r132 = r120.f282910a;
        o r133 = r120.f282911b;
        if (r122 == r123) goto L89;
        r133 = r131;
        r131 = r132;
    L89:
        ArrayList<View> r134 = r121.getFlatSelectableItems$common_selection_release();
        int r135 = CollectionsKt.indexOf(r134, r131.f282908a);
        int r136 = CollectionsKt.indexOf(r134, r133.f282908a);
        if (r135 < 0) goto L105;
        if (r136 < 0) goto L105;
        if (r135 > r136) goto L96;
        if (r135 != r136) goto L105;
        if (r131.f282909b <= r133.f282909b) goto L105;
    L96:
        if (r122 != r123) goto L98;
        r123 = SelectionHandleType.END;
    L98:
        r101.f282881n = r123;
        if (r123 != null) goto L104;
        com.larksuite.common_selection.b r137 = r101.f282886s;
        if (r137 == null) goto L103;
        r137.f282865a.dismiss();
    L103:
        r101.f282886s = null;
    L104:
        o r138 = r133;
        r133 = r131;
        r131 = r138;
    L105:
        r101.f282877j = new p(r131, r133);
        r101.i();
        r121.invalidate();
        r101.m();
        if (r101.f282873f == true) goto L108;
    L110:
        float r139 = r124.getOffsetForMagnifier();
        com.larksuite.common_selection.b r140 = r101.f282886s;
        if (r140 == null) goto L113;
        r140.f282865a.a(r129, r130 - r139);
    L113:
        r101.j(r110);
        goto L114
    L108:
        if (r101.f282886s != null) goto L110;
        r101.f282886s = new com.larksuite.common_selection.b(r121);
        goto L110
    L77:
        if (r122 != SelectionHandleType.END) goto L79;
        r124 = r101.f282880m;
        goto L80
    L79:
        r124 = null;
    L84:
        r118 = "SelectionContainer";
        goto L113
    L30:
        if (r111 <= r112) goto L26;
    L25:
        if (r103 != 3) goto L26;
    L116:
        if (this.f282832f == false) goto L167;
        this.f282832f = false;
        this.f282847u = null;
        getParent().requestDisallowInterceptTouchEvent(false);
        SelectionGranularity r141 = this.f282837k;
        if (r141 != null) goto L120;
        r141 = SelectionGranularity.WORD;
    L120:
        Intrinsics.checkNotNullParameter(r141, "granularity");
        p r142 = r101.f282877j;
        if (r142 != null) goto L124;
        Log.e("SelectionManager", "expandSelectionIfCollapsed: current range is null");
    L159:
        r104 = "SelectionContainer";
        Log.d(r104, "onTouchEvent, action is " + r110.getAction() + ", selectionRange is " + r101.f282877j);
        final SelectionContainer r143 = r101.f282878k;
        if (r143 != null) goto L163;
    L166:
        r101.j(r110);
    L177:
        Log.d(r104, "MotionEvent.ACTION_UP or MotionEvent.ACTION_CANCEL, is not isInitialDragSelect and is not handle drag, handler.removeCallbacks(externalLongPressRunnable)");
        getHandler().removeCallbacks(this.f282849w);
        goto L179
    L163:
        if (r101.f282884q == false) goto L165;
        r143.post(new l(r101, true));
        goto L166
    L165:
        final boolean r144 = true;
        r143.post(new SelectionManager$showHandles$2(r101, r143, r144));
        goto L166
    L124:
        if (Intrinsics.areEqual(r142.f282910a.f282908a, r142.f282911b.f282908a) == true) goto L126;
    L128:
        boolean r145 = false;
    L129:
        if (r145 == false) goto L159;
        o r146 = r142.f282910a;
        View r147 = r146.f282908a;
        if (r147 == null) goto L159;
        if (r141 != SelectionGranularity.ALL) goto L152;
        SelectionContainer r148 = r101.f282878k;
        if (r148 == null) goto L139;
        ArrayList<View> r149 = r148.getFlatSelectableItems$common_selection_release();
    L140:
        if (r149 != null) goto L142;
    L145:
        boolean r150 = true;
    L146:
        if (r150 == true) goto L159;
        o r151 = new o((View) CollectionsKt.first(r149), 0);
        View r152 = (View) CollectionsKt.last(r149);
        t r153 = t.f282928a;
        s r154 = t.a(r152);
        if (r154 != null) goto L151;
        r154 = t.f282930c;
    L151:
        p r155 = new p(r151, new o(r152, r154.a(r152)));
    L156:
        if (r155 == null) goto L158;
        r101.n(r155.f282910a, r155.f282911b);
    L158:
        r101.k();
        goto L159
    L142:
        if (r149.isEmpty() == true) goto L145;
        r150 = false;
        goto L146
    L139:
        r149 = null;
        goto L140
    L152:
        t r156 = t.f282928a;
        s r157 = t.a(r147);
        if (r157 == null) goto L159;
        r155 = r157.b(r147, r146, r141);
        goto L156
    L126:
        if (r142.f282910a.f282909b != r142.f282911b.f282909b) goto L128;
        r145 = true;
        goto L129
    L167:
        r104 = "SelectionContainer";
        if (r102 == false) goto L177;
        r101.f282881n = null;
        com.larksuite.common_selection.b r158 = r101.f282886s;
        if (r158 == null) goto L172;
        r158.f282865a.dismiss();
    L172:
        r101.f282886s = null;
        getParent().requestDisallowInterceptTouchEvent(false);
        SelectionContainer r159 = r101.f282878k;
        if (r159 == null) goto L176;
        r159.post(new m(r101));
    L176:
        r101.j(r110);
        Log.d(r104, "onTouchEvent: isHandleDrag");
        goto L177
    L15:
        r102 = false;
        goto L16
    L5:
        if (this.f282833g == false) goto L8;
        this.f282833g = false;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r100) {
        Log.d("SelectionContainer", "requestDisallowInterceptTouchEvent called");
        getParent().requestDisallowInterceptTouchEvent(r100);
        if (this.f282834h == true) goto L6;
        this.f282848v = true;
        return;
    }

    public final void setSelectionManager(i r100) {
        this.f282844r = r100;
    }

    public final o e(float r110, float r111) {
        boolean r100 = false;
        if (this.f282842p == false) goto L6;
        c();
        this.f282842p = false;
    L6:
        if (this.f282841o == false) goto L8;
        h();
        this.f282841o = false;
    L8:
        Iterator<View> r101 = this.f282838l.iterator();
    L9:
        o r102 = null;
        if (r101.hasNext() == false) goto L16;
        View r103 = r101.next();
        RectF r104 = this.f282839m.get(r103);
        if (r104 == null) goto L9;
        if (r104.contains(r110, r111) == false) goto L9;
        o r105 = g(r103, r110 - r104.left, r111 - r104.top);
    L17:
        if (r105 != null) goto L96;
        i r106 = this.f282844r;
        if (r106 == null) goto L68;
        SelectionHandleType r107 = r106.f282881n;
        if (r107 == null) goto L24;
        boolean r108 = true;
    L25:
        if (r108 == false) goto L27;
    L28:
        r100 = true;
    L29:
        if (r100 == false) goto L68;
        if (this.f282832f == false) goto L35;
        o r109 = this.f282847u;
    L43:
        if (r109 == null) goto L68;
        View r112 = r109.f282908a;
        if (r112 == null) goto L68;
        Integer r113 = this.f282840n.get(r112);
        if (r113 == null) goto L68;
        int r114 = r113.intValue();
        RectF r115 = this.f282839m.get(r112);
        if (r115 == null) goto L68;
        if (r114 <= 0) goto L61;
        View r116 = (View) ListProtector.get(this.f282838l, r114 - 1);
        RectF r117 = this.f282839m.get(r116);
        if (r117 == null) goto L61;
        if (r111 >= ((r115.top + r117.bottom) / 2)) goto L61;
        o r118 = g(r116, r110 - r117.left, r111 - r117.top);
    L69:
        if (r118 != null) goto L97;
        Iterator<View> r119 = this.f282838l.iterator();
        float r120 = Float.MAX_VALUE;
    L72:
        if (r119.hasNext() == false) goto L82;
        View r121 = r119.next();
        RectF r122 = this.f282839m.get(r121);
        if (r122 == null) goto L72;
        float r123 = r110 - r122.left;
        float r124 = r111 - r122.top;
        o r125 = g(r121, r123, r124);
        t r126 = t.f282928a;
        s r127 = t.a(r121);
        if (r127 != null) goto L78;
        r127 = t.f282930c;
    L78:
        float r128 = r127.f(r121, r123, r124, r125);
        if (r128 >= r120) goto L72;
        r120 = r128;
        r102 = r125;
        goto L72
    L82:
        return r102;
    L97:
        return r118;
    L61:
        if (r114 >= (this.f282838l.size() - 1)) goto L67;
        View r129 = (View) ListProtector.get(this.f282838l, r114 + 1);
        RectF r130 = this.f282839m.get(r129);
        if (r130 == null) goto L67;
        float r131 = r115.bottom;
        float r132 = r130.top;
        if (r111 <= ((r131 + r132) / 2)) goto L67;
        r118 = g(r129, r110 - r130.left, r111 - r132);
    L67:
        r118 = g(r112, r110 - r115.left, r111 - r115.top);
        goto L69
    L35:
        if (r107 != SelectionHandleType.START) goto L39;
        p r133 = r106.f282877j;
        if (r133 == null) goto L42;
        r109 = r133.f282910a;
    L42:
        r109 = null;
        goto L43
    L39:
        p r134 = r106.f282877j;
        if (r134 == null) goto L42;
        r109 = r134.f282911b;
        goto L43
    L27:
        if (this.f282832f == false) goto L29;
    L24:
        r108 = false;
    L68:
        r118 = null;
        goto L69
    L96:
        return r105;
    L16:
        r105 = null;
        goto L17
    }

    public final void f(View r100, RectF r101) {
        float r102 = 0.0f;
        View r103 = r100;
        float r104 = 0.0f;
    L4:
        if (Intrinsics.areEqual(r103, this) == true) goto L8;
        if ((r103.getParent() instanceof View) == false) goto L8;
        r102 = r102 + r103.getLeft();
        r104 = r104 + r103.getTop();
        Object r105 = r103.getParent();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.view.View");
        r103 = (View) r105;
    L8:
        r101.set(r102, r104, r100.getWidth() + r102, r100.getHeight() + r104);
    }

    public SelectionContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f282827a = new Rect();
        this.f282828b = new RectF();
        this.f282829c = new Path();
        this.f282830d = new Path();
        int r103 = v.f282932a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r104 = r100.getResources();
        this.f282831e = MathKt.roundToInt(WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density * 2.0f);
        this.f282836j = ViewConfiguration.getLongPressTimeout();
        this.f282838l = new ArrayList(20);
        this.f282839m = new ArrayMap(20);
        this.f282840n = new ArrayMap(20);
        this.f282841o = true;
        this.f282842p = true;
        this.f282849w = new d(r100, this);
        this.f282850x = new GestureDetector(r100, new e(this));
        setWillNotDraw(false);
        setOnHierarchyChangeListener(new a(this));
    }

    public static o g(View r100, float r101, float r102) {
        t r103 = t.f282928a;
        s r104 = t.a(r100);
        if (r104 != null) goto L6;
        r104 = t.f282930c;
    L6:
        return r104.g(r100, r101, r102);
    }

    public /* synthetic */ SelectionContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f282841o = true;
    }

    public static final void a(SelectionContainer r100, n r101, o r102, MotionEvent r103, i r104) {
        r100.getClass();
        SelectionInitiationMode r105 = r101.f282907b;
        int r106 = c.f282852a[r105.ordinal()];
        if (r106 != 1) goto L5;
        View r107 = r102.f282908a;
        if (r107 == null) goto L24;
        RectF r108 = r100.f282839m.get(r107);
        if (r108 != null) goto L15;
        r108 = new RectF();
        r100.f(r107, r108);
    L15:
        float r109 = r103.getX() - r108.left;
        float r110 = r103.getY() - r108.top;
        t r111 = t.f282928a;
        s r112 = t.a(r107);
        if (r112 != null) goto L19;
        r112 = t.f282930c;
    L19:
        if (r112.i(r107, r109, r110) == false) goto L23;
        r100.f282832f = true;
        r100.f282837k = r101.f282906a;
        r100.f282847u = new o(r102.f282908a, r102.f282909b);
        r104.l(r100, r102);
        return;
    L23:
        return;
    L24:
        return;
    L5:
        if (r106 != 2) goto L8;
        r100.f282832f = true;
        r100.f282837k = r101.f282906a;
        r100.f282847u = new o(r102.f282908a, r102.f282909b);
        r104.l(r100, r102);
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        this.f282841o = true;
        int r105 = getChildCount();
        if (this.f282843q == r105) goto L5;
    L6:
        c();
        this.f282843q = r105;
        this.f282842p = false;
    L7:
        i r106 = this.f282844r;
        if (r106 == null) goto L10;
        SelectionContainer r107 = r106.f282878k;
    L12:
        if (Intrinsics.areEqual(r107, this) == true) goto L14;
        return;
    L14:
        if (r106.f282883p.getAndSet(true) == true) goto L21;
        SelectionContainer r108 = r106.f282878k;
        if (r108 == null) goto L22;
        r108.post(new k(r106));
        return;
    L22:
        return;
    L21:
        return;
    L10:
        r107 = null;
        goto L12
    L5:
        if (this.f282842p == false) goto L7;
        goto L6
    }
}
