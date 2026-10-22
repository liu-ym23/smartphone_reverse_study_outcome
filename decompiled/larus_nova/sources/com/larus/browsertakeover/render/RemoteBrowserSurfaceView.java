package com.larus.browsertakeover.render;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdkapi.distribution.config.GestureAction;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u0087\u00012\u00020\u0001:\b\u0084\u0001\u0085\u0001\u0086\u0001\u0087\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ0\u0010Q\u001a\u00020\u001f2\u0006\u0010R\u001a\u00020\u001b2\u0006\u0010S\u001a\u00020\u00192\u0006\u0010T\u001a\u00020\u00192\u0006\u0010U\u001a\u00020\u00192\b\b\u0002\u0010V\u001a\u00020\u0007J\u0006\u0010W\u001a\u00020\u001fJ\u000e\u0010X\u001a\u00020\u001f2\u0006\u0010Y\u001a\u00020\u000bJ\u0010\u0010Z\u001a\u00020\u001f2\b\u0010[\u001a\u0004\u0018\u00010\\J\u0010\u0010]\u001a\u0004\u0018\u00010\u00162\u0006\u0010[\u001a\u00020\\J(\u0010^\u001a\u00020\u001f2\u0006\u0010_\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u00072\u0006\u0010a\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\u0007H\u0014J\b\u0010c\u001a\u00020\u001fH\u0014J\n\u0010d\u001a\u0004\u0018\u00010(H\u0002J\u0010\u0010e\u001a\u00020\u001f2\u0006\u0010f\u001a\u00020gH\u0014J\u0010\u0010h\u001a\u00020\u000b2\u0006\u0010i\u001a\u00020jH\u0016J\u0018\u0010k\u001a\u00020\u001f2\u0006\u0010l\u001a\u00020\u00192\u0006\u0010m\u001a\u00020\u0019H\u0002J\"\u0010n\u001a\u00020\u001f2\u0006\u0010l\u001a\u00020\u00192\u0006\u0010m\u001a\u00020\u00192\b\b\u0002\u0010o\u001a\u00020\u000bH\u0002J\u0010\u0010p\u001a\u00020\u00192\u0006\u0010i\u001a\u00020jH\u0002J\u0010\u0010q\u001a\u00020\u00192\u0006\u0010i\u001a\u00020jH\u0002J\u0010\u0010r\u001a\u00020\u00192\u0006\u0010i\u001a\u00020jH\u0002J \u0010s\u001a\u00020\u001f2\u0006\u0010t\u001a\u00020\u00192\u0006\u0010u\u001a\u00020\u00192\u0006\u0010v\u001a\u00020\u0019H\u0002J\"\u0010w\u001a\u00020\u001f2\u0006\u0010l\u001a\u00020\u00192\u0006\u0010m\u001a\u00020\u00192\b\b\u0002\u0010o\u001a\u00020\u000bH\u0002J\u0010\u0010x\u001a\u00020\u001f2\u0006\u0010o\u001a\u00020\u000bH\u0002J\b\u0010y\u001a\u00020\u001fH\u0002J\b\u0010z\u001a\u00020\u000bH\u0016J\b\u0010{\u001a\u00020\u001fH\u0002J\b\u0010|\u001a\u00020\u001fH\u0002J\b\u0010}\u001a\u00020\u001fH\u0002J/\u0010~\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u007f2\u0006\u0010l\u001a\u00020\u00192\u0006\u0010m\u001a\u00020\u00192\u0007\u0010\u0080\u0001\u001a\u00020(H\u0002R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010B\u001a\u00020CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001c\u0010H\u001a\u0004\u0018\u00010IX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010N\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u000e\"\u0004\bP\u0010\u0010R\u0017\u0010\u0081\u0001\u001a\u0002018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001¨\u0006\u0088\u0001"}, d2 = {"Lcom/larus/browsertakeover/render/RemoteBrowserSurfaceView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "usesRtsInputPacing", "getUsesRtsInputPacing", "()Z", "setUsesRtsInputPacing", "(Z)V", "bitmapPaint", "Landroid/graphics/Paint;", "viewport", "Lcom/larus/browsertakeover/render/RemoteBrowserViewport;", "viewportRect", "Landroid/graphics/RectF;", "imageRect", "touchSlop", "", "frame", "Landroid/graphics/Bitmap;", "reportedFrameAttempt", "onFirstFrameSubmitted", "Lkotlin/Function1;", "", "getOnFirstFrameSubmitted", "()Lkotlin/jvm/functions/Function1;", "setOnFirstFrameSubmitted", "(Lkotlin/jvm/functions/Function1;)V", "deviceWidth", "deviceHeight", "offsetTop", "gestureMapping", "Lcom/larus/browsertakeover/render/RemoteBrowserViewport$Mapping;", "gesture", "Lcom/larus/browsertakeover/render/RemoteBrowserSurfaceView$Gesture;", "downX", "downY", "lastX", "lastY", "moved", "lastMoveSentAtNanos", "", "lastRemoteX", "lastRemoteY", "hasLastRemotePoint", "secondPointerDownTime", "twoDownX", "twoDownY", "twoStartSpan", GestureAction.zoom, "zoomOffsetX", "zoomOffsetY", "pendingPanScrollX", "pendingPanScrollY", "longPressDetector", "Landroid/view/GestureDetector;", "scaleDetector", "Landroid/view/ScaleGestureDetector;", "interactionMode", "Lcom/larus/browsertakeover/render/RemoteBrowserSurfaceView$InteractionMode;", "getInteractionMode", "()Lcom/larus/browsertakeover/render/RemoteBrowserSurfaceView$InteractionMode;", "setInteractionMode", "(Lcom/larus/browsertakeover/render/RemoteBrowserSurfaceView$InteractionMode;)V", "interactionListener", "Lcom/larus/browsertakeover/render/RemoteBrowserSurfaceView$InteractionListener;", "getInteractionListener", "()Lcom/larus/browsertakeover/render/RemoteBrowserSurfaceView$InteractionListener;", "setInteractionListener", "(Lcom/larus/browsertakeover/render/RemoteBrowserSurfaceView$InteractionListener;)V", "inputEnabled", "getInputEnabled", "setInputEnabled", "setFrame", SimplayerImageStrategy.RESULT_BITMAP, "remoteWidth", "remoteHeight", "remoteOffsetTop", MapMonitorConst.ATTEMPT, "clearFrame", "setImeVisible", "visible", "setImeVisibleBounds", "localVisibleRect", "Landroid/graphics/Rect;", "getVisibleRemoteBounds", "onSizeChanged", "w", "h", "oldw", "oldh", "onDetachedFromWindow", "currentMapping", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "dispatchDragMove", "x", "y", "dispatchScroll", "force", "centroidX", "centroidY", "span", "applyLocalScale", "factor", "focusX", "focusY", "panLocal", "flushPanScroll", "resetLocalScale", "performClick", "finishGesture", "cancelRemoteDrag", "cancelGesture", "mapPoint", "Lkotlin/Pair;", "snapshot", "movementIntervalNanos", "getMovementIntervalNanos", "()J", "InteractionMode", "InteractionListener", "Gesture", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RemoteBrowserSurfaceView extends View {
    public float A;
    public float B;
    public float C;
    public float D;
    public float E;
    public float F;
    public final GestureDetector G;
    public final ScaleGestureDetector H;
    public InteractionMode I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public b f319484J;
    public boolean K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f319485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f319486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.browsertakeover.render.c f319487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f319488d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f319489e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f319490f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bitmap f319491g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f319492h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function1<? super Integer, Unit> f319493i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f319494j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f319495k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f319496l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.larus.browsertakeover.render.c.b f319497m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Gesture f319498n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f319499o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f319500p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f319501q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f319502r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f319503s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f319504t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f319505u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f319506v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f319507w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f319508x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f319509y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f319510z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/browsertakeover/render/RemoteBrowserSurfaceView$Gesture;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "SINGLE", "SINGLE_SCROLL", "LOCAL_PAN", "DRAG", "TWO_PENDING", "TWO_SCROLL", "PINCH", "CANCELLED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Gesture extends Enum<Gesture> {
        public static final Gesture CANCELLED = null;
        public static final Gesture DRAG = null;
        public static final Gesture LOCAL_PAN = null;
        public static final Gesture NONE = null;
        public static final Gesture PINCH = null;
        public static final Gesture SINGLE = null;
        public static final Gesture SINGLE_SCROLL = null;
        public static final Gesture TWO_PENDING = null;
        public static final Gesture TWO_SCROLL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Gesture[] f319511a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f319512b = null;

        public static EnumEntries<Gesture> getEntries() {
            return f319512b;
        }

        static {
            Gesture r100 = new Gesture(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            Gesture r101 = new Gesture("SINGLE", 1);
            SINGLE = r101;
            Gesture r102 = new Gesture("SINGLE_SCROLL", 2);
            SINGLE_SCROLL = r102;
            Gesture r103 = new Gesture("LOCAL_PAN", 3);
            LOCAL_PAN = r103;
            Gesture r104 = new Gesture("DRAG", 4);
            DRAG = r104;
            Gesture r105 = new Gesture("TWO_PENDING", 5);
            TWO_PENDING = r105;
            Gesture r110 = new Gesture("TWO_SCROLL", 6);
            TWO_SCROLL = r110;
            Gesture r111 = new Gesture("PINCH", 7);
            PINCH = r111;
            Gesture r112 = new Gesture("CANCELLED", 8);
            CANCELLED = r112;
            Gesture[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
            f319511a = r113;
            f319512b = EnumEntriesKt.enumEntries(r113);
        }

        public static Gesture[] values() {
            return (Gesture[]) f319511a.clone();
        }

        public static Gesture valueOf(String r100) {
            return (Gesture) r27.a.a(Gesture.class, r100);
        }

        public Gesture(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/browsertakeover/render/RemoteBrowserSurfaceView$InteractionMode;", "", "<init>", "(Ljava/lang/String;I)V", "SCROLL", "DRAG", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum InteractionMode extends Enum<InteractionMode> {
        public static final InteractionMode DRAG = null;
        public static final InteractionMode SCROLL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ InteractionMode[] f319513a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f319514b = null;

        public static EnumEntries<InteractionMode> getEntries() {
            return f319514b;
        }

        static {
            InteractionMode r100 = new InteractionMode("SCROLL", 0);
            SCROLL = r100;
            InteractionMode r101 = new InteractionMode("DRAG", 1);
            DRAG = r101;
            InteractionMode[] r102 = {r100, r101};
            f319513a = r102;
            f319514b = EnumEntriesKt.enumEntries(r102);
        }

        public static InteractionMode[] values() {
            return (InteractionMode[]) f319513a.clone();
        }

        public static InteractionMode valueOf(String r100) {
            return (InteractionMode) r27.a.a(InteractionMode.class, r100);
        }

        public InteractionMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public interface b {
        void CR(float r100, float r101);

        void F80(float r100, float r101);

        void Gp(float r100, float r101, float r102, float r103);

        void O70(float r100, float r101);

        void f5(float r100, float r101);

        void p10(float r100, float r101);

        void p50(float r100, float r101);
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f319515a = null;

        static {
            int[] r100 = new int[Gesture.values().length];
            r100[Gesture.SINGLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[Gesture.SINGLE_SCROLL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[Gesture.LOCAL_PAN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[Gesture.DRAG.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[Gesture.TWO_PENDING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[Gesture.TWO_SCROLL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f319515a = r100;
        }
    }

    public static final class d extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RemoteBrowserSurfaceView f319516a;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            return true;
        }

        public d(RemoteBrowserSurfaceView r100) {
            this.f319516a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            if (this.f319516a.getInputEnabled() == false) goto L19;
            RemoteBrowserSurfaceView r101 = this.f319516a;
            if (r101.f319498n == Gesture.SINGLE) goto L7;
            return;
        L7:
            if (r101.f319503s == true) goto L22;
            com.larus.browsertakeover.render.c.b r102 = r101.f319497m;
            if (r102 != null) goto L12;
            return;
        L12:
            Pair<Float, Float> r103 = r101.h(r101.f319499o, r101.f319500p, r102);
            if (r103 != null) goto L15;
            return;
        L15:
            RemoteBrowserSurfaceView r104 = this.f319516a;
            r104.f319498n = Gesture.DRAG;
            r104.f319505u = r103.getFirst().floatValue();
            RemoteBrowserSurfaceView r105 = this.f319516a;
            r105.f319506v = r103.getSecond().floatValue();
            RemoteBrowserSurfaceView r106 = this.f319516a;
            r106.f319507w = true;
            b r107 = r106.getInteractionListener();
            if (r107 == null) goto L21;
            r107.p50(r103.getFirst().floatValue(), r103.getSecond().floatValue());
            return;
        L21:
            return;
        L22:
            return;
        }
    }

    public static final class e extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RemoteBrowserSurfaceView f319517a;

        public e(RemoteBrowserSurfaceView r100) {
            this.f319517a = r100;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector r110) {
            Intrinsics.checkNotNullParameter(r110, "detector");
            RemoteBrowserSurfaceView r100 = this.f319517a;
            boolean r101 = false;
            if (r100.f319498n == Gesture.PINCH) goto L5;
            return false;
        L5:
            float r102 = r110.getScaleFactor();
            float r103 = r110.getFocusX();
            float r111 = r110.getFocusY();
            r100.getClass();
            if (Float.isInfinite(r102) == false) goto L8;
        L10:
            if (r101 == true) goto L12;
        L18:
            return true;
        L12:
            if (r102 <= 0.0f) goto L18;
            com.larus.browsertakeover.render.c.b r104 = r100.f319487c.a(r100.getWidth(), r100.getHeight(), r100.f319494j, r100.f319495k, r100.f319496l);
            if (r104 == null) goto L18;
            com.larus.browsertakeover.render.c.b r105 = r104.a(r100.B, r100.C, r100.D);
            float r106 = RangesKt.coerceIn(r100.B * r102, 1.0f, 4.0f);
            float r107 = r106 / r100.B;
            com.larus.browsertakeover.render.c.a r108 = r105.f319545a;
            float r109 = r103 - ((r103 - r108.f319541a) * r107);
            float r112 = r111 - ((r111 - r108.f319542b) * r107);
            com.larus.browsertakeover.render.c.a r113 = r104.f319545a;
            float r114 = r113.f319543c;
            float r115 = r113.f319541a;
            float r116 = r113.f319544d - r113.f319542b;
            float r117 = -(r114 - r115);
            float r118 = r106 - 1.0f;
            r100.C = RangesKt.coerceIn(r109 - r115, r117 * r118, 0.0f);
            r100.D = RangesKt.coerceIn(r112 - r104.f319545a.f319542b, (-r116) * r118, 0.0f);
            r100.B = r106;
            r100.invalidate();
            goto L18
        L8:
            if (Float.isNaN(r102) == true) goto L10;
            r101 = true;
            goto L10
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector r110) {
            Intrinsics.checkNotNullParameter(r110, "detector");
            Gesture r100 = this.f319517a.f319498n;
            Gesture r101 = Gesture.PINCH;
            if (r100 != r101) goto L6;
            return true;
        L6:
            if (r100 == Gesture.TWO_PENDING) goto L8;
            return false;
        L8:
            float r102 = Math.abs(r110.getCurrentSpan() - this.f319517a.A);
            float r111 = (float) Math.hypot(r110.getFocusX() - this.f319517a.f319509y, r110.getFocusY() - this.f319517a.f319510z);
            RemoteBrowserSurfaceView r103 = this.f319517a;
            if (r102 > (r103.f319490f * 2.0f)) goto L11;
        L15:
            return false;
        L11:
            if (r102 <= r111) goto L15;
            r103.f319498n = r101;
            r103.f319503s = true;
            return true;
        }
    }

    static {
    }

    public RemoteBrowserSurfaceView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RemoteBrowserSurfaceView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final long getMovementIntervalNanos() {
        if (this.f319485a == false) goto L5;
        return 50000000;
    L5:
        return 16000000;
    }

    public final void b() {
        if (this.f319498n == Gesture.DRAG) goto L5;
        return;
    L5:
        if (this.f319507w == false) goto L11;
        b r100 = this.f319484J;
        if (r100 == null) goto L12;
        r100.CR(this.f319505u, this.f319506v);
        return;
    L12:
        return;
    }

    public final void e() {
        Bitmap r100 = this.f319491g;
        this.f319491g = null;
        a();
        this.B = 1.0f;
        this.C = 0.0f;
        this.D = 0.0f;
        invalidate();
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L11;
        r100.recycle();
        return;
    L11:
        return;
    L5:
        if (r100.isRecycled() == true) goto L7;
        r101 = true;
        goto L8
    }

    public final com.larus.browsertakeover.render.c.b f() {
        Bitmap r100 = this.f319491g;
        boolean r101 = false;
        if (r100 == null) goto L8;
        if (r100.isRecycled() == true) goto L8;
        r101 = true;
    L8:
        if (r101 == true) goto L10;
        return null;
    L10:
        com.larus.browsertakeover.render.c.b r102 = this.f319487c.a(getWidth(), getHeight(), this.f319494j, this.f319495k, this.f319496l);
        if (r102 != null) goto L13;
        return null;
    L13:
        return r102.a(this.B, this.C, this.D);
    }

    public final void a() {
        b();
        this.f319498n = Gesture.NONE;
        this.f319497m = null;
        this.E = 0.0f;
        this.F = 0.0f;
        this.f319507w = false;
        ViewParent r100 = getParent();
        if (r100 == null) goto L6;
        r100.requestDisallowInterceptTouchEvent(false);
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        a();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final boolean performClick() {
        super.performClick();
        return true;
    }

    public final boolean getInputEnabled() {
        return this.K;
    }

    public final b getInteractionListener() {
        return this.f319484J;
    }

    public final InteractionMode getInteractionMode() {
        return this.I;
    }

    public final Function1<Integer, Unit> getOnFirstFrameSubmitted() {
        return this.f319493i;
    }

    public final boolean getUsesRtsInputPacing() {
        return this.f319485a;
    }

    public static float c(MotionEvent r100) {
        return (r100.getX(0) + r100.getX(1)) / 2.0f;
    }

    public static float d(MotionEvent r100) {
        return (r100.getY(0) + r100.getY(1)) / 2.0f;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        Bitmap r100 = this.f319491g;
        if (r100 != null) goto L5;
        return;
    L5:
        com.larus.browsertakeover.render.c.b r101 = f();
        if (r101 != null) goto L8;
        return;
    L8:
        com.larus.browsertakeover.render.c.a r102 = r101.f319545a;
        this.f319488d.set(r102.f319541a, r102.f319542b, r102.f319543c, r102.f319544d);
        float r103 = r100.getHeight() / (r100.getWidth() / this.f319494j);
        RectF r104 = this.f319489e;
        float r105 = r102.f319541a;
        float r106 = r102.f319542b;
        float r107 = this.f319496l;
        float r108 = r101.f319549e;
        r104.set(r105, (r107 * r108) + r106, r102.f319543c, r106 + ((r107 + r103) * r108));
        r110.save();
        r110.clipRect(this.f319488d);
        com.larus.browsertakeover.render.c.a r109 = r101.f319550f;
        if (r109 == null) goto L11;
        r110.clipRect(r109.f319541a, r109.f319542b, r109.f319543c, r109.f319544d);
    L11:
        r110.drawBitmap(r100, null, this.f319489e, this.f319486b);
        r110.restore();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        int r100 = 0;
        if (this.K == true) goto L5;
    L156:
        return false;
    L5:
        if (this.f319491g == null) goto L156;
        int r101 = r110.getActionMasked();
        if (r101 != 0) goto L10;
        a();
        com.larus.browsertakeover.render.c.b r102 = f();
        if (r102 != null) goto L35;
        return false;
    L35:
        Pair<Float, Float> r103 = h(r110.getX(), r110.getY(), r102);
        if (r103 != null) goto L38;
        return false;
    L38:
        this.f319497m = r102;
        this.f319498n = Gesture.SINGLE;
        this.f319499o = r110.getX();
        this.f319500p = r110.getY();
        this.f319501q = r110.getX();
        this.f319502r = r110.getY();
        this.f319503s = false;
        this.f319504t = 0;
        this.f319505u = r103.getFirst().floatValue();
        this.f319506v = r103.getSecond().floatValue();
        this.f319507w = true;
        if (this.I != InteractionMode.DRAG) goto L43;
        this.f319498n = Gesture.DRAG;
        b r104 = this.f319484J;
        if (r104 == null) goto L43;
        r104.p50(r103.getFirst().floatValue(), r103.getSecond().floatValue());
    L43:
        ViewParent r105 = getParent();
        if (r105 == null) goto L46;
        r105.requestDisallowInterceptTouchEvent(true);
    L46:
        this.G.onTouchEvent(r110);
        this.H.onTouchEvent(r110);
        int r106 = r110.getActionMasked();
        Pair<Float, Float> r107 = null;
        if (r106 != 1) goto L49;
        com.larus.browsertakeover.render.c.b r108 = this.f319497m;
        if (r108 == null) goto L126;
        Pair<Float, Float> r109 = h(r110.getX(), r110.getY(), r108);
    L127:
        int r111 = c.f319515a[this.f319498n.ordinal()];
        if (r111 == 1) goto L146;
        if (r111 == 2) goto L144;
        if (r111 != 3) goto L132;
        i(r110.getX(), r110.getY(), true);
    L151:
        this.f319498n = Gesture.NONE;
        this.f319497m = null;
        this.E = 0.0f;
        this.F = 0.0f;
        this.f319507w = false;
        ViewParent r112 = getParent();
        if (r112 == null) goto L154;
        r112.requestDisallowInterceptTouchEvent(false);
    L154:
        super.performClick();
    L155:
        return true;
    L132:
        if (r111 != 4) goto L151;
        if (r109 == null) goto L139;
        b r113 = this.f319484J;
        if (r113 == null) goto L151;
        r113.f5(r109.getFirst().floatValue(), r109.getSecond().floatValue());
        goto L151
    L139:
        if (this.f319507w == false) goto L151;
        b r114 = this.f319484J;
        if (r114 == null) goto L151;
        r114.f5(this.f319505u, this.f319506v);
        goto L151
    L144:
        g(r110.getX(), r110.getY(), true);
        goto L151
    L146:
        if (this.f319503s == true) goto L151;
        if (r109 == null) goto L151;
        b r115 = this.f319484J;
        if (r115 == null) goto L151;
        r115.O70(r109.getFirst().floatValue(), r109.getSecond().floatValue());
        goto L151
    L126:
        r109 = null;
        goto L127
    L49:
        if (r106 == 2) goto L87;
        if (r106 != 3) goto L52;
        a();
        goto L155
    L52:
        if (r106 != 6) goto L155;
        if (this.f319498n != Gesture.TWO_PENDING) goto L70;
        if (this.f319503s == true) goto L70;
        if (r110.getPointerCount() != 2) goto L70;
        if ((r110.getEventTime() - this.f319508x) > ViewConfiguration.getDoubleTapTimeout()) goto L70;
        com.larus.browsertakeover.render.c.b r116 = this.f319497m;
        if (r116 == null) goto L65;
        r107 = h(c(r110), d(r110), r116);
    L65:
        if (r107 == null) goto L74;
        b r117 = this.f319484J;
        if (r117 == null) goto L74;
        r117.F80(r107.getFirst().floatValue(), r107.getSecond().floatValue());
    L74:
        b();
        if (this.f319498n == Gesture.PINCH) goto L77;
    L84:
        this.f319498n = Gesture.CANCELLED;
        goto L155
    L77:
        if (this.B <= 1.0f) goto L84;
        if (r110.getPointerCount() != 2) goto L84;
        if (r110.getActionIndex() != 0) goto L83;
        r100 = 1;
    L83:
        this.f319501q = r110.getX(r100);
        this.f319502r = r110.getY(r100);
        this.f319497m = f();
        this.f319503s = true;
        this.f319498n = Gesture.LOCAL_PAN;
    L70:
        if (this.f319498n != Gesture.TWO_SCROLL) goto L74;
        if (r110.getPointerCount() != 2) goto L74;
        g(c(r110), d(r110), true);
        goto L74
    L87:
        switch(c.f319515a[this.f319498n.ordinal()]) {
            case 1: goto L118;
            case 2: goto L116;
            case 3: goto L115;
            case 4: goto L102;
            case 5: goto L90;
            case 6: goto L90;
            default: goto L155;
        };
    L102:
        float r118 = r110.getX();
        float r119 = r110.getY();
        com.larus.browsertakeover.render.c.b r120 = this.f319497m;
        if (r120 == null) goto L155;
        long r121 = System.nanoTime();
        int r122 = com.larus.browsertakeover.render.d.f319551a;
        if (com.larus.browsertakeover.render.d.a(this.f319504t, r121, getMovementIntervalNanos(), false) == false) goto L155;
        Pair<Float, Float> r123 = h(r118, r119, r120);
        if (r123 == null) goto L155;
        b r124 = this.f319484J;
        if (r124 == null) goto L114;
        r124.p10(r123.getFirst().floatValue(), r123.getSecond().floatValue());
    L114:
        this.f319505u = r123.getFirst().floatValue();
        this.f319506v = r123.getSecond().floatValue();
        this.f319507w = true;
        this.f319504t = r121;
        goto L155
    L115:
        i(r110.getX(), r110.getY(), false);
        goto L155
    L116:
        g(r110.getX(), r110.getY(), false);
        goto L155
    L90:
        if (r110.getPointerCount() != 2) goto L155;
        float r125 = c(r110);
        float r126 = d(r110);
        float r127 = (float) Math.hypot(r125 - this.f319509y, r126 - this.f319510z);
        float r128 = Math.abs(((float) Math.hypot(r110.getX(0) - r110.getX(1), r110.getY(0) - r110.getY(1))) - this.A);
        float r129 = this.f319490f;
        if (r127 <= r129) goto L94;
    L95:
        this.f319503s = true;
    L96:
        Gesture r130 = this.f319498n;
        Gesture r131 = Gesture.TWO_SCROLL;
        if (r130 == r131) goto L101;
        if (r127 <= r129) goto L155;
        if (r127 < r128) goto L155;
    L101:
        this.f319498n = r131;
        g(r125, r126, false);
        goto L155
    L94:
        if (r128 <= (r129 * 2.0f)) goto L96;
    L118:
        if (((float) Math.hypot(r110.getX() - this.f319499o, r110.getY() - this.f319500p)) <= this.f319490f) goto L155;
        this.f319503s = true;
        if (this.B <= 1.0f) goto L122;
        this.f319498n = Gesture.LOCAL_PAN;
        i(r110.getX(), r110.getY(), false);
        goto L155
    L122:
        this.f319498n = Gesture.SINGLE_SCROLL;
        g(r110.getX(), r110.getY(), false);
        goto L155
    L10:
        if (r101 != 5) goto L46;
        if (this.f319503s == false) goto L15;
    L18:
        boolean r132 = true;
    L19:
        Gesture r133 = this.f319498n;
        if (r133 != Gesture.SINGLE_SCROLL) goto L23;
        g(r110.getX(), r110.getY(), true);
    L26:
        if (r110.getPointerCount() == 2) goto L28;
    L31:
        b();
        this.f319498n = Gesture.CANCELLED;
        goto L46
    L28:
        if (this.f319498n == Gesture.CANCELLED) goto L31;
        b();
        this.f319497m = f();
        this.f319498n = Gesture.TWO_PENDING;
        this.f319508x = r110.getEventTime();
        this.f319509y = c(r110);
        float r134 = d(r110);
        this.f319510z = r134;
        this.f319501q = this.f319509y;
        this.f319502r = r134;
        this.A = (float) Math.hypot(r110.getX(0) - r110.getX(1), r110.getY(0) - r110.getY(1));
        this.f319503s = r132;
        this.f319504t = 0;
        goto L46
    L23:
        if (r133 != Gesture.LOCAL_PAN) goto L26;
        i(r110.getX(), r110.getY(), true);
        goto L26
    L15:
        if (this.f319498n == Gesture.DRAG) goto L18;
        r132 = false;
        goto L19
    }

    public final void setImeVisible(boolean r100) {
        com.larus.browsertakeover.render.c r101 = this.f319487c;
        int r102 = getWidth();
        int r103 = getHeight();
        boolean r104 = false;
        if (r101.f319537a == r100) goto L16;
        r101.f319537a = r100;
        if (r100 == true) goto L8;
        r101.f319538b = null;
    L8:
        if (r100 == true) goto L11;
        r102 = 0;
    L11:
        r101.f319539c = r102;
        if (r100 == true) goto L15;
        r103 = 0;
    L15:
        r101.f319540d = r103;
        r104 = true;
    L16:
        if (r104 == false) goto L19;
        a();
        invalidate();
        return;
    }

    public final void setImeVisibleBounds(Rect r100) {
        if (r100 == null) goto L4;
        com.larus.browsertakeover.render.c.a r101 = new com.larus.browsertakeover.render.c.a(r100.left, r100.top, r100.right, r100.bottom);
    L5:
        com.larus.browsertakeover.render.c r102 = this.f319487c;
        if (Intrinsics.areEqual(r102.f319538b, r101) == false) goto L8;
        boolean r103 = false;
    L9:
        if (r103 == false) goto L12;
        a();
        invalidate();
        return;
    L12:
        return;
    L8:
        r102.f319538b = r101;
        r103 = true;
        goto L9
    L4:
        r101 = null;
        goto L5
    }

    public final void setInputEnabled(boolean r100) {
        if (r100 == true) goto L4;
        a();
    L4:
        this.K = r100;
    }

    public final void setInteractionListener(b r100) {
        this.f319484J = r100;
    }

    public final void setInteractionMode(InteractionMode r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.I = r100;
    }

    public final void setOnFirstFrameSubmitted(Function1<? super Integer, Unit> r100) {
        this.f319493i = r100;
    }

    public final void setUsesRtsInputPacing(boolean r100) {
        if (this.f319485a != r100) goto L5;
        return;
    L5:
        this.f319485a = r100;
        this.f319504t = 0;
    }

    public RemoteBrowserSurfaceView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f319486b = new Paint(3);
        this.f319487c = new com.larus.browsertakeover.render.c();
        this.f319488d = new RectF();
        this.f319489e = new RectF();
        this.f319490f = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f319494j = 1.0f;
        this.f319495k = 1.0f;
        this.f319498n = Gesture.NONE;
        this.B = 1.0f;
        this.G = new GestureDetector(r100, new d(this));
        ScaleGestureDetector r103 = new ScaleGestureDetector(r100, new e(this));
        r103.setQuickScaleEnabled(false);
        this.H = r103;
        this.I = InteractionMode.SCROLL;
        setBackgroundColor(Color.rgb(19, 21, 26));
        setFocusable(true);
    }

    public final void g(float r110, float r111, boolean r112) {
        com.larus.browsertakeover.render.c.b r100 = this.f319497m;
        if (r100 != null) goto L5;
        return;
    L5:
        long r101 = System.nanoTime();
        int r102 = com.larus.browsertakeover.render.d.f319551a;
        if (com.larus.browsertakeover.render.d.a(this.f319504t, r101, getMovementIntervalNanos(), r112) == true) goto L8;
        return;
    L8:
        Pair<Float, Float> r113 = h(r110, r111, r100);
        if (r113 != null) goto L11;
        return;
    L11:
        Pair<Float, Float> r103 = h(this.f319501q, this.f319502r, r100);
        if (r103 != null) goto L15;
        return;
    L15:
        if (Intrinsics.areEqual(r103, r113) == true) goto L19;
        b r104 = this.f319484J;
        if (r104 == null) goto L19;
        r104.Gp(r113.getFirst().floatValue(), r113.getSecond().floatValue(), r103.getFirst().floatValue() - r113.getFirst().floatValue(), r103.getSecond().floatValue() - r113.getSecond().floatValue());
    L19:
        this.f319501q = r110;
        this.f319502r = r111;
        this.f319504t = r101;
    }

    public final Pair<Float, Float> h(float r100, float r101, com.larus.browsertakeover.render.c.b r102) {
        int r103 = getWidth();
        int r104 = getHeight();
        if (r100 >= 0.0f) goto L5;
    L54:
        return null;
    L5:
        if (r100 >= r103) goto L54;
        if (r101 < 0.0f) goto L54;
        if (r101 >= r104) goto L54;
        com.larus.browsertakeover.render.c.a r105 = r102.f319550f;
        if (r105 != null) goto L14;
    L22:
        com.larus.browsertakeover.render.c.a r106 = r102.f319545a;
        float r107 = r106.f319541a;
        if (r100 < r107) goto L54;
        if (r100 >= r106.f319543c) goto L54;
        float r108 = r106.f319542b;
        if (r101 < r108) goto L54;
        if (r101 >= r106.f319544d) goto L54;
        float r109 = r102.f319549e;
        float r110 = (r100 - r107) / r109;
        float r111 = (r101 - r108) / r109;
        float r112 = r102.f319548d;
        float r113 = r111 - r112;
        float r114 = r102.f319547c - r112;
        boolean r115 = true;
        if (Float.isInfinite(r110) == false) goto L34;
    L36:
        boolean r116 = false;
    L37:
        if (r116 == false) goto L54;
        if (Float.isInfinite(r113) == false) goto L41;
    L43:
        boolean r117 = false;
    L44:
        if (r117 == false) goto L54;
        if (0.0f <= r113) goto L48;
    L50:
        r115 = false;
    L51:
        if (r115 == false) goto L54;
        return TuplesKt.to(Float.valueOf(RangesKt.coerceIn(r110, 0.0f, r102.f319546b)), Float.valueOf(RangesKt.coerceIn(r113, 0.0f, r114)));
    L48:
        if (r113 > r114) goto L50;
    L41:
        if (Float.isNaN(r113) == true) goto L43;
        r117 = true;
        goto L44
    L34:
        if (Float.isNaN(r110) == true) goto L36;
        r116 = true;
        goto L37
    L14:
        if (r100 < r105.f319541a) goto L54;
        if (r100 >= r105.f319543c) goto L54;
        if (r101 < r105.f319542b) goto L54;
        if (r101 < r105.f319544d) goto L22;
        goto L22
    }

    public final void i(float r110, float r210, boolean r211) {
        boolean r100 = false;
        if (Float.isInfinite(r110) == false) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L10;
        return;
    L10:
        if (Float.isInfinite(r210) == false) goto L12;
    L14:
        boolean r102 = false;
    L15:
        if (r102 == false) goto L61;
        com.larus.browsertakeover.render.c.b r103 = this.f319487c.a(getWidth(), getHeight(), this.f319494j, this.f319495k, this.f319496l);
        if (r103 != null) goto L20;
        return;
    L20:
        com.larus.browsertakeover.render.c.a r104 = r103.f319545a;
        float r105 = r104.f319543c - r104.f319541a;
        float r106 = this.B - 1.0f;
        float r107 = r105 * r106;
        float r108 = (r104.f319544d - r104.f319542b) * r106;
        float r109 = this.C + (r110 - this.f319501q);
        float r111 = this.D + (r210 - this.f319502r);
        if (Float.isInfinite(r109) == false) goto L23;
    L25:
        boolean r112 = false;
    L26:
        if (r112 == true) goto L28;
        return;
    L28:
        if (Float.isInfinite(r111) == false) goto L30;
    L32:
        boolean r113 = false;
    L33:
        if (r113 == false) goto L62;
        this.C = RangesKt.coerceIn(r109, -r107, 0.0f);
        this.D = RangesKt.coerceIn(r111, -r108, 0.0f);
        this.f319501q = r110;
        this.f319502r = r210;
        invalidate();
        com.larus.browsertakeover.render.c.b r114 = r103.a(this.B, this.C, this.D);
        Pair<Float, Float> r115 = h(r110, r210, r114);
        if (r115 == null) goto L39;
        float r116 = this.E;
        float r117 = r109 - this.C;
        float r118 = r114.f319549e;
        this.E = r116 - (r117 / r118);
        this.F -= (r111 - this.D) / r118;
        this.f319505u = r115.getFirst().floatValue();
        this.f319506v = r115.getSecond().floatValue();
        this.f319507w = true;
    L39:
        if (this.f319507w == true) goto L41;
        return;
    L41:
        if (this.E != 0.0f) goto L43;
        boolean r119 = true;
    L44:
        if (r119 == true) goto L46;
    L50:
        long r120 = System.nanoTime();
        int r121 = com.larus.browsertakeover.render.d.f319551a;
        if (com.larus.browsertakeover.render.d.a(this.f319504t, r120, getMovementIntervalNanos(), r211) == false) goto L64;
        float r122 = this.E;
        float r123 = this.F;
        this.E = 0.0f;
        this.F = 0.0f;
        this.f319504t = r120;
        b r124 = this.f319484J;
        if (r124 == null) goto L60;
        r124.Gp(this.f319505u, this.f319506v, r122, r123);
        return;
    L60:
        return;
    L64:
        return;
    L46:
        if (this.F != 0.0f) goto L48;
        r100 = true;
    L48:
        if (r100 == false) goto L50;
        return;
    L43:
        r119 = false;
        goto L44
    L62:
        return;
    L30:
        if (Float.isNaN(r111) == true) goto L32;
        r113 = true;
        goto L33
    L23:
        if (Float.isNaN(r109) == true) goto L25;
        r112 = true;
        goto L26
    L61:
        return;
    L12:
        if (Float.isNaN(r210) == true) goto L14;
        r102 = true;
        goto L15
    L5:
        if (Float.isNaN(r110) == true) goto L7;
        r101 = true;
        goto L8
    }

    public /* synthetic */ RemoteBrowserSurfaceView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        a();
        com.larus.browsertakeover.render.c r104 = this.f319487c;
        if (r104.f319537a == true) goto L5;
    L9:
        this.B = 1.0f;
        this.C = 0.0f;
        this.D = 0.0f;
        return;
    L5:
        if (r104.f319539c == r100) goto L7;
    L8:
        r104.f319539c = r100;
        r104.f319540d = r101;
        goto L9
    L7:
        if (r104.f319540d > 0) goto L9;
        goto L8
    }
}
