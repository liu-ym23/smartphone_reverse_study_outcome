package com.larus.avlink.gallery.view;

import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001-\b\u0001\u0018\u00002\u00020\u0001:\u0001JB¨\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\b\u00126\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\r0\u000f\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0005\u0012\u0012\b\u0002\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010/\u001a\u00020\rJ\u001e\u00100\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u00101\u001a\u00020\u00142\u0006\u00102\u001a\u00020\u0014J\u0018\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u000206H\u0016J\u0018\u00107\u001a\u00020\r2\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u000206H\u0016J\u0010\u00108\u001a\u00020\r2\u0006\u00109\u001a\u00020\u0006H\u0016J\u0010\u0010:\u001a\u00020\r2\u0006\u00105\u001a\u000206H\u0002J\u0018\u0010;\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u00142\u0006\u0010=\u001a\u00020\u0014H\u0002J\b\u0010>\u001a\u00020\rH\u0002J\u0018\u0010?\u001a\u00020\r2\u0006\u0010<\u001a\u00020\u00142\u0006\u0010=\u001a\u00020\u0014H\u0002J\u0010\u0010@\u001a\u00020\r2\u0006\u0010A\u001a\u00020\tH\u0002J\u0018\u0010B\u001a\u00020\t2\u0006\u0010<\u001a\u00020\u00142\u0006\u0010=\u001a\u00020\u0014H\u0002J \u0010C\u001a\u00020\u00142\u0006\u0010D\u001a\u00020E2\u0006\u0010<\u001a\u00020\u00142\u0006\u0010=\u001a\u00020\u0014H\u0002J\u0010\u0010F\u001a\u00020\r2\u0006\u00102\u001a\u00020\u0014H\u0002J\b\u0010G\u001a\u00020\rH\u0002J\b\u0010H\u001a\u00020\rH\u0002J\b\u0010I\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bX\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\r0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010.¨\u0006K"}, d2 = {"Lcom/larus/avlink/gallery/view/RecyclerViewSwipeMultiSelectHelper;", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "isEnabled", "Lkotlin/Function0;", "", "onSelectionStart", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "", "onSelectionRangeChanged", "Lkotlin/Function2;", "anchorPosition", "currentPosition", "onSelectionFinished", "bottomAutoScrollBoundaryProvider", "", "bottomEdgeTriggerDistanceOverridePx", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ljava/lang/Float;)V", "Ljava/lang/Float;", "touchSlop", "topEdgeTriggerDistancePx", "bottomEdgeTriggerDistancePx", "fastEdgeDistancePx", "normalSpeedPxPerSecond", "fastSpeedPxPerSecond", "downX", "downY", "lastTouchX", "lastTouchY", "axisLock", "Lcom/larus/avlink/gallery/view/RecyclerViewSwipeMultiSelectHelper$AxisLock;", "isTracking", "isSelecting", "autoScrollSpeedPxPerSecond", "lastAutoScrollFrameTimeMs", "", "pendingScrollOffsetPx", "isAutoScrollNestedActive", "autoScrollRunnable", "com/larus/avlink/gallery/view/RecyclerViewSwipeMultiSelectHelper$autoScrollRunnable$1", "Lcom/larus/avlink/gallery/view/RecyclerViewSwipeMultiSelectHelper$autoScrollRunnable$1;", "detach", "prepareForLongPressSelection", "touchX", "touchY", "onInterceptTouchEvent", "rv", "event", "Landroid/view/MotionEvent;", "onTouchEvent", "onRequestDisallowInterceptTouchEvent", "disallowIntercept", "handleActionDown", "hasCrossedTouchSlop", "x", "y", "beginSelection", "updateSelectionForPoint", "scrollByParentFirst", "scrollDelta", "findClosestAdapterPosition", "calculateDistanceToViewBounds", "view", "Landroid/view/View;", "updateAutoScrollSpeed", "stopAutoScroll", "finishSelection", "resetGestureState", "AxisLock", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecyclerViewSwipeMultiSelectHelper implements RecyclerView.OnItemTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f292931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Boolean> f292932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Integer, Unit> f292933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<Integer, Integer, Unit> f292934d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f292935e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Float> f292936f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f292937g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f292938h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f292939i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f292940j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f292941k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f292942l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f292943m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f292944n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f292945o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f292946p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f292947q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f292948r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public AxisLock f292949s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f292950t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f292951u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f292952v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f292953w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f292954x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f292955y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final a f292956z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/avlink/gallery/view/RecyclerViewSwipeMultiSelectHelper$AxisLock;", "", "<init>", "(Ljava/lang/String;I)V", "UNDECIDED", "X", "Y", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AxisLock extends Enum<AxisLock> {
        public static final AxisLock UNDECIDED = null;
        public static final AxisLock X = null;
        public static final AxisLock Y = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AxisLock[] f292957a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f292958b = null;

        public static EnumEntries<AxisLock> getEntries() {
            return f292958b;
        }

        static {
            AxisLock r100 = new AxisLock("UNDECIDED", 0);
            UNDECIDED = r100;
            AxisLock r101 = new AxisLock("X", 1);
            X = r101;
            AxisLock r102 = new AxisLock("Y", 2);
            Y = r102;
            AxisLock[] r103 = {r100, r101, r102};
            f292957a = r103;
            f292958b = EnumEntriesKt.enumEntries(r103);
        }

        public static AxisLock[] values() {
            return (AxisLock[]) f292957a.clone();
        }

        public static AxisLock valueOf(String r100) {
            return (AxisLock) r27.a.a(AxisLock.class, r100);
        }

        public AxisLock(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerViewSwipeMultiSelectHelper f292959a;

        public final void a() {
            RecyclerViewSwipeMultiSelectHelper r100 = this.f292959a;
            if (r100.f292951u == false) goto L30;
            boolean r101 = true;
            if (r100.f292952v != 0.0f) goto L7;
            boolean r102 = true;
        L8:
            if (r102 == true) goto L32;
            long r103 = SystemClock.uptimeMillis();
            RecyclerViewSwipeMultiSelectHelper r104 = this.f292959a;
            long r105 = r104.f292953w;
            if (r105 != 0) goto L13;
            long r106 = 16;
        L14:
            r104.f292953w = r103;
            float r107 = r104.f292954x + ((r104.f292952v * r106) / 1000.0f);
            r104.f292954x = r107;
            int r108 = (int) r107;
            if (r108 == 0) goto L23;
            int[] r110 = new int[2];
            if (r104.f292931a.dispatchNestedPreScroll(0, r108, r110, null, 1) == false) goto L19;
            int r109 = r108 - r110[1];
        L20:
            if (r109 == 0) goto L22;
            r104.f292931a.scrollBy(0, r109);
        L22:
            this.f292959a.f292954x -= r108;
            goto L23
        L19:
            r109 = r108;
        L23:
            RecyclerViewSwipeMultiSelectHelper r111 = this.f292959a;
            r111.d(r111.f292947q, r111.f292948r);
            RecyclerViewSwipeMultiSelectHelper r112 = this.f292959a;
            r112.c(r112.f292948r);
            RecyclerViewSwipeMultiSelectHelper r113 = this.f292959a;
            if (r113.f292952v == 0.0f) goto L27;
            r101 = false;
        L27:
            if (r101 == true) goto L31;
            r113.f292931a.postOnAnimation(this);
            return;
        L31:
            return;
        L13:
            r106 = r103 - r105;
            goto L14
        L32:
            return;
        L7:
            r102 = false;
            goto L8
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(RecyclerViewSwipeMultiSelectHelper r100) {
            this.f292959a = r100;
        }
    }

    public final void a() {
        this.f292943m = -1;
        this.f292944n = -1;
        this.f292949s = AxisLock.UNDECIDED;
        this.f292950t = false;
        this.f292951u = false;
        this.f292945o = 0.0f;
        this.f292946p = 0.0f;
        this.f292947q = 0.0f;
        this.f292948r = 0.0f;
    }

    public final void b() {
        this.f292952v = 0.0f;
        this.f292954x = 0.0f;
        this.f292953w = 0;
        if (this.f292955y == false) goto L5;
        this.f292931a.stopNestedScroll(1);
        this.f292955y = false;
    L5:
        this.f292931a.removeCallbacks(this.f292956z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void onRequestDisallowInterceptTouchEvent(boolean r100) {
    }

    public final void c(float r100) {
        if (this.f292951u == true) goto L6;
        b();
        return;
    L6:
        Rect r101 = new Rect();
        boolean r102 = this.f292931a.getLocalVisibleRect(r101);
        int r103 = this.f292931a.getPaddingTop();
        boolean r104 = false;
        if (r102 == false) goto L9;
        int r105 = r101.top;
    L10:
        float r106 = Math.max(r103, r105);
        int r107 = this.f292931a.getHeight() - this.f292931a.getPaddingBottom();
        if (r102 == false) goto L13;
        int r108 = r101.bottom;
    L14:
        float r109 = Math.min(r107, r108);
        Function0<Float> r110 = this.f292936f;
        if (r110 == null) goto L19;
        Float r111 = r110.invoke();
        if (r111 == null) goto L19;
        float r112 = RangesKt.coerceIn(r111.floatValue(), r106, r109);
    L20:
        float r113 = Math.min(r109, r112);
        if (r113 > r106) goto L25;
        b();
        return;
    L25:
        if (r100 > (this.f292938h + r106)) goto L35;
        float r114 = RangesKt.coerceAtLeast(r100 - r106, 0.0f);
        if (this.f292931a.canScrollVertically(-1) == true) goto L30;
    L43:
        float r115 = 0.0f;
    L45:
        if (r115 != this.f292952v) goto L47;
        boolean r116 = true;
    L48:
        if (r116 == false) goto L51;
        return;
    L51:
        if (r115 != 0.0f) goto L53;
        boolean r117 = true;
    L54:
        if (r117 == false) goto L56;
    L58:
        if (r115 != 0.0f) goto L60;
        boolean r118 = true;
    L61:
        if (r118 == true) goto L63;
    L65:
        this.f292952v = r115;
        this.f292954x = 0.0f;
        this.f292953w = 0;
        if (r115 != 0.0f) goto L68;
        r104 = true;
    L68:
        if (r104 == false) goto L70;
        this.f292931a.removeCallbacks(this.f292956z);
        return;
    L70:
        this.f292931a.removeCallbacks(this.f292956z);
        this.f292931a.postOnAnimation(this.f292956z);
        return;
    L63:
        if (this.f292955y == false) goto L65;
        this.f292931a.stopNestedScroll(1);
        this.f292955y = false;
        goto L65
    L60:
        r118 = false;
        goto L61
    L56:
        if (this.f292955y == true) goto L58;
        this.f292955y = this.f292931a.startNestedScroll(2, 1);
        goto L65
    L53:
        r117 = false;
        goto L54
    L47:
        r116 = false;
        goto L48
    L30:
        if (r114 > this.f292940j) goto L32;
        float r119 = this.f292942l;
    L33:
        r115 = -r119;
        goto L45
    L32:
        r119 = this.f292941k;
        goto L33
    L35:
        if (r100 < (r113 - this.f292939i)) goto L43;
        float r120 = RangesKt.coerceAtLeast(r113 - r100, 0.0f);
        if (this.f292931a.canScrollVertically(1) == false) goto L43;
        if (r120 > this.f292940j) goto L42;
        r115 = this.f292942l;
        goto L45
    L42:
        r115 = this.f292941k;
    L19:
        r112 = r109;
        goto L20
    L13:
        r108 = this.f292931a.getHeight();
        goto L14
    L9:
        r105 = 0;
        goto L10
    }

    public final void d(float r110, float r111) {
        if (this.f292951u == true) goto L5;
        return;
    L5:
        if (this.f292943m == (-1)) goto L47;
        View r100 = this.f292931a.findChildViewUnder(r110, r111);
        if (r100 == null) goto L10;
        int r112 = this.f292931a.getChildAdapterPosition(r100);
    L35:
        if (r112 != (-1)) goto L37;
        return;
    L37:
        if (r112 == this.f292944n) goto L48;
        this.f292944n = r112;
        this.f292934d.invoke(Integer.valueOf(this.f292943m), Integer.valueOf(r112));
        return;
    L48:
        return;
    L10:
        int r101 = this.f292931a.getChildCount();
        View r102 = null;
        float r103 = Float.MAX_VALUE;
        int r104 = 0;
    L11:
        if (r104 >= r101) goto L32;
        View r105 = this.f292931a.getChildAt(r104);
        if (r105 == null) goto L31;
        float r106 = 0.0f;
        if (r110 >= r105.getLeft()) goto L19;
        float r107 = r105.getLeft() - r110;
    L23:
        if (r111 >= r105.getTop()) goto L26;
        r106 = r105.getTop() - r111;
    L28:
        float r108 = (r107 * r107) + (r106 * r106);
        if (r108 >= r103) goto L31;
        r102 = r105;
        r103 = r108;
        goto L31
    L26:
        if (r111 <= r105.getBottom()) goto L28;
        r106 = r111 - r105.getBottom();
        goto L28
    L19:
        if (r110 <= r105.getRight()) goto L21;
        r107 = r110 - r105.getRight();
        goto L23
    L21:
        r107 = 0.0f;
    L31:
        r104 = r104 + 1;
        goto L11
    L32:
        if (r102 == null) goto L34;
        r112 = this.f292931a.getChildAdapterPosition(r102);
        goto L35
    L34:
        r112 = -1;
        goto L35
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final boolean onInterceptTouchEvent(RecyclerView r110, MotionEvent r111) {
        Intrinsics.checkNotNullParameter(r110, "rv");
        Intrinsics.checkNotNullParameter(r111, "event");
        int r100 = r111.getActionMasked();
        if (r100 == 0) goto L43;
        if (r100 != 1) goto L6;
    L40:
        boolean r112 = this.f292951u;
        b();
        a();
        if (r112 == false) goto L56;
        this.f292935e.invoke();
    L56:
        return false;
    L6:
        if (r100 == 2) goto L11;
        if (r100 == 3) goto L40;
    L11:
        if (this.f292950t == true) goto L13;
        return false;
    L13:
        this.f292947q = r111.getX();
        this.f292948r = r111.getY();
        if (this.f292949s != AxisLock.UNDECIDED) goto L39;
        if (Math.hypot(r111.getX() - this.f292945o, r111.getY() - this.f292946p) < this.f292937g) goto L18;
        boolean r101 = true;
    L19:
        if (r101 == false) goto L39;
        if (Math.abs(r111.getX() - this.f292945o) <= Math.abs(r111.getY() - this.f292946p)) goto L23;
        AxisLock r102 = AxisLock.X;
    L24:
        this.f292949s = r102;
        if (r102 != AxisLock.X) goto L34;
        int r103 = this.f292943m;
        if (r103 == (-1)) goto L30;
        this.f292951u = true;
        this.f292933c.invoke(Integer.valueOf(r103));
    L30:
        d(r111.getX(), r111.getY());
        c(r111.getY());
        ViewParent r113 = r110.getParent();
        if (r113 == null) goto L33;
        r113.requestDisallowInterceptTouchEvent(true);
    L33:
        return true;
    L34:
        b();
        ViewParent r114 = r110.getParent();
        if (r114 == null) goto L37;
        r114.requestDisallowInterceptTouchEvent(false);
    L37:
        this.f292950t = false;
        goto L39
    L23:
        r102 = AxisLock.Y;
        goto L24
    L18:
        r101 = false;
    L39:
        return this.f292951u;
    L43:
        boolean r115 = this.f292951u;
        b();
        a();
        if (r115 == false) goto L47;
        this.f292935e.invoke();
    L47:
        if (this.f292932b.invoke().booleanValue() == false) goto L56;
        View r116 = this.f292931a.findChildViewUnder(r111.getX(), r111.getY());
        if (r116 == null) goto L56;
        int r117 = this.f292931a.getChildAdapterPosition(r116);
        if (r117 == (-1)) goto L56;
        this.f292943m = r117;
        this.f292944n = r117;
        this.f292945o = r111.getX();
        this.f292946p = r111.getY();
        this.f292947q = r111.getX();
        this.f292948r = r111.getY();
        this.f292949s = AxisLock.UNDECIDED;
        this.f292950t = true;
        this.f292951u = false;
        goto L56
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void onTouchEvent(RecyclerView r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "rv");
        Intrinsics.checkNotNullParameter(r101, "event");
        if (this.f292951u == true) goto L5;
        return;
    L5:
        int r102 = r101.getActionMasked();
        if (r102 != 1) goto L8;
    L13:
        boolean r103 = this.f292951u;
        b();
        a();
        if (r103 == false) goto L18;
        this.f292935e.invoke();
        return;
    L18:
        return;
    L8:
        if (r102 != 2) goto L10;
        this.f292947q = r101.getX();
        this.f292948r = r101.getY();
        d(r101.getX(), r101.getY());
        c(r101.getY());
        return;
    L10:
        if (r102 == 3) goto L13;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RecyclerViewSwipeMultiSelectHelper(RecyclerView r100, Function0<Boolean> r101, Function1<? super Integer, Unit> r102, Function2<? super Integer, ? super Integer, Unit> r103, Function0<Unit> r104, Function0<Float> r105, Float r106) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "isEnabled");
        Intrinsics.checkNotNullParameter(r102, "onSelectionStart");
        Intrinsics.checkNotNullParameter(r103, "onSelectionRangeChanged");
        Intrinsics.checkNotNullParameter(r104, "onSelectionFinished");
        this.f292931a = r100;
        this.f292932b = r101;
        this.f292933c = r102;
        this.f292934d = r103;
        this.f292935e = r104;
        this.f292936f = r105;
        this.f292937g = ViewConfiguration.get(r100.getContext()).getScaledTouchSlop();
        this.f292938h = t1.a(r100.getContext(), 64.0f);
        if (r106 == null) goto L5;
        float r107 = r106.floatValue();
    L6:
        this.f292939i = r107;
        this.f292940j = t1.a(r100.getContext(), 32.0f);
        this.f292941k = t1.a(r100.getContext(), 256.0f);
        this.f292942l = t1.a(r100.getContext(), 512.0f);
        this.f292943m = -1;
        this.f292944n = -1;
        this.f292949s = AxisLock.UNDECIDED;
        this.f292956z = new a(this);
        r100.addOnItemTouchListener(this);
        return;
    L5:
        r107 = t1.a(r100.getContext(), 64.0f);
        goto L6
    }
}
