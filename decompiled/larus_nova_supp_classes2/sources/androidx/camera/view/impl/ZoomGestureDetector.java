package androidx.camera.view.impl;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.compose.material3.MenuKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 -2\u00020\u0001:\u0003-./B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010(\u001a\u00020\fH\u0002J\b\u0010)\u001a\u00020\u0012H\u0002J\u0010\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,H\u0007R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010%\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u00060"}, d2 = {"Landroidx/camera/view/impl/ZoomGestureDetector;", "", "context", "Landroid/content/Context;", "spanSlop", "", "minSpan", "listener", "Landroidx/camera/view/impl/ZoomGestureDetector$OnZoomGestureListener;", "(Landroid/content/Context;IILandroidx/camera/view/impl/ZoomGestureDetector$OnZoomGestureListener;)V", "anchoredZoomMode", "anchoredZoomStartX", "", "anchoredZoomStartY", "currentSpan", "currentSpanX", "currentSpanY", "eventBeforeOrAboveStartingGestureEvent", "", "eventTime", "", "focusX", "focusY", "gestureDetector", "Landroid/view/GestureDetector;", "initialSpan", "isInProgress", "isQuickZoomEnabled", "()Z", "setQuickZoomEnabled", "(Z)V", "isStylusZoomEnabled", "setStylusZoomEnabled", "prevTime", "previousSpan", "previousSpanX", "previousSpanY", "timeDelta", "getTimeDelta", "()J", "getIncrementalScaleFactor", "inAnchoredZoomMode", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "Companion", "OnZoomGestureListener", "ZoomEvent", "camera-view_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ZoomGestureDetector {
    private static final int ANCHORED_ZOOM_MODE_DOUBLE_TAP = 1;
    private static final int ANCHORED_ZOOM_MODE_NONE = 0;
    private static final int ANCHORED_ZOOM_MODE_STYLUS = 2;
    public static final Companion Companion = null;
    private static final int DEFAULT_MIN_SPAN = 0;
    private static final float SCALE_FACTOR = 0.5f;
    private int anchoredZoomMode;
    private float anchoredZoomStartX;
    private float anchoredZoomStartY;
    private final Context context;
    private float currentSpan;
    private float currentSpanX;
    private float currentSpanY;
    private boolean eventBeforeOrAboveStartingGestureEvent;
    private long eventTime;
    private int focusX;
    private int focusY;
    private GestureDetector gestureDetector;
    private float initialSpan;
    private boolean isInProgress;
    private boolean isQuickZoomEnabled;
    private boolean isStylusZoomEnabled;
    private final OnZoomGestureListener listener;
    private final int minSpan;
    private long prevTime;
    private float previousSpan;
    private float previousSpanX;
    private float previousSpanY;
    private final int spanSlop;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/camera/view/impl/ZoomGestureDetector$Companion;", "", "()V", "ANCHORED_ZOOM_MODE_DOUBLE_TAP", "", "ANCHORED_ZOOM_MODE_NONE", "ANCHORED_ZOOM_MODE_STYLUS", "DEFAULT_MIN_SPAN", "SCALE_FACTOR", "", "camera-view_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/camera/view/impl/ZoomGestureDetector$OnZoomGestureListener;", "", "onZoomEvent", "", "zoomEvent", "Landroidx/camera/view/impl/ZoomGestureDetector$ZoomEvent;", "camera-view_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OnZoomGestureListener {
        boolean onZoomEvent(ZoomEvent r1);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001:\u0003\r\u000e\u000fB%\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0010"}, d2 = {"Landroidx/camera/view/impl/ZoomGestureDetector$ZoomEvent;", "", "eventTime", "", "focusX", "", "focusY", "(JII)V", "getEventTime", "()J", "getFocusX", "()I", "getFocusY", "Begin", "End", "Move", "camera-view_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class ZoomEvent {
        private final long eventTime;
        private final int focusX;
        private final int focusY;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/camera/view/impl/ZoomGestureDetector$ZoomEvent$Begin;", "Landroidx/camera/view/impl/ZoomGestureDetector$ZoomEvent;", "eventTime", "", "focusX", "", "focusY", "(JII)V", "camera-view_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Begin extends ZoomEvent {
            public Begin(long r7, int r9, int r10) {
                super(r7, r9, r10, null);
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/camera/view/impl/ZoomGestureDetector$ZoomEvent$End;", "Landroidx/camera/view/impl/ZoomGestureDetector$ZoomEvent;", "eventTime", "", "focusX", "", "focusY", "incrementalScaleFactor", "", "(JIIF)V", "getIncrementalScaleFactor", "()F", "camera-view_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class End extends ZoomEvent {
            private final float incrementalScaleFactor;

            public final float getIncrementalScaleFactor() {
                return this.incrementalScaleFactor;
            }

            public End(long r7, int r9, int r10, float r11) {
                super(r7, r9, r10, null);
                this.incrementalScaleFactor = r11;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/camera/view/impl/ZoomGestureDetector$ZoomEvent$Move;", "Landroidx/camera/view/impl/ZoomGestureDetector$ZoomEvent;", "eventTime", "", "focusX", "", "focusY", "incrementalScaleFactor", "", "(JIIF)V", "getIncrementalScaleFactor", "()F", "camera-view_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Move extends ZoomEvent {
            private final float incrementalScaleFactor;

            public final float getIncrementalScaleFactor() {
                return this.incrementalScaleFactor;
            }

            public Move(long r7, int r9, int r10, float r11) {
                super(r7, r9, r10, null);
                this.incrementalScaleFactor = r11;
            }
        }

        public /* synthetic */ ZoomEvent(long r1, int r3, int r4, DefaultConstructorMarker r5) {
            this(r1, r3, r4);
        }

        public final long getEventTime() {
            return this.eventTime;
        }

        public final int getFocusX() {
            return this.focusX;
        }

        public final int getFocusY() {
            return this.focusY;
        }

        private ZoomEvent(long r1, int r3, int r4) {
            this.eventTime = r1;
            this.focusX = r3;
            this.focusY = r4;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ZoomGestureDetector(Context r9, int r10, OnZoomGestureListener r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r11, "listener");
        this(r9, r10, 0, r11, 4, null);
    }

    public ZoomGestureDetector(Context r9, OnZoomGestureListener r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "listener");
        this(r9, 0, 0, r10, 6, null);
    }

    private final boolean inAnchoredZoomMode() {
        if (this.anchoredZoomMode == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final long getTimeDelta() {
        return this.eventTime - this.prevTime;
    }

    private final float getIncrementalScaleFactor() {
        if (inAnchoredZoomMode() == false) goto L20;
        boolean r0 = this.eventBeforeOrAboveStartingGestureEvent;
        if (r0 == true) goto L7;
    L8:
        if (r0 == false) goto L10;
    L12:
        boolean r1 = false;
    L13:
        float r2 = Math.abs(1 - (this.currentSpan / this.previousSpan)) * 0.5f;
        if (this.previousSpan <= this.spanSlop) goto L25;
        if (r1 == false) goto L19;
        return 1.0f + r2;
    L19:
        return 1.0f - r2;
    L25:
        return 1.0f;
    L10:
        if (this.currentSpan <= this.previousSpan) goto L12;
    L11:
        r1 = true;
        goto L13
    L7:
        if (this.currentSpan < this.previousSpan) goto L11;
    L20:
        float r3 = this.previousSpan;
        if (r3 > MenuKt.ClosedAlphaTarget) goto L23;
        return 1.0f;
    L23:
        return this.currentSpan / r3;
    }

    public final boolean isQuickZoomEnabled() {
        return this.isQuickZoomEnabled;
    }

    public final boolean isStylusZoomEnabled() {
        return this.isStylusZoomEnabled;
    }

    public final boolean onTouchEvent(MotionEvent r20) {
        Intrinsics.checkNotNullParameter(r20, "event");
        this.eventTime = r20.getEventTime();
        int r2 = r20.getActionMasked();
        if (this.isQuickZoomEnabled == false) goto L5;
        this.gestureDetector.onTouchEvent(r20);
    L5:
        int r3 = r20.getPointerCount();
        if ((r20.getButtonState() & 32) == 0) goto L8;
        boolean r4 = true;
    L10:
        if (this.anchoredZoomMode != 2) goto L13;
        if (r4 == true) goto L13;
        boolean r7 = true;
    L14:
        if (r2 != 1) goto L16;
    L20:
        boolean r9 = true;
    L21:
        float r10 = MenuKt.ClosedAlphaTarget;
        if (r2 == 0) goto L25;
        if (r9 == true) goto L25;
    L35:
        if (this.isInProgress == true) goto L44;
        if (this.isStylusZoomEnabled == false) goto L44;
        if (inAnchoredZoomMode() == true) goto L44;
        if (r9 == true) goto L44;
        if (r4 == false) goto L44;
        this.anchoredZoomStartX = r20.getX();
        this.anchoredZoomStartY = r20.getY();
        this.anchoredZoomMode = 2;
        this.initialSpan = MenuKt.ClosedAlphaTarget;
    L44:
        if (r2 == 0) goto L51;
        if (r2 == 6) goto L51;
        if (r2 == 5) goto L51;
        if (r7 == true) goto L51;
        boolean r5 = false;
    L52:
        if (r2 != 6) goto L54;
        boolean r6 = true;
    L55:
        if (r6 == false) goto L57;
        int r8 = r20.getActionIndex();
    L58:
        if (r6 == false) goto L60;
        int r11 = r3 - 1;
    L62:
        if (inAnchoredZoomMode() == false) goto L68;
        float r12 = this.anchoredZoomStartX;
        float r13 = this.anchoredZoomStartY;
        if (r20.getY() >= r13) goto L66;
        boolean r14 = true;
    L67:
        this.eventBeforeOrAboveStartingGestureEvent = r14;
    L74:
        float r15 = MenuKt.ClosedAlphaTarget;
        int r16 = 0;
    L75:
        if (r16 >= r3) goto L79;
        if (r8 == r16) goto L78;
        r10 = r10 + Math.abs(r20.getX(r16) - r12);
        r15 = r15 + Math.abs(r20.getY(r16) - r13);
    L78:
        r16 = r16 + 1;
        goto L75
    L79:
        float r1 = r11;
        float r17 = 2;
        float r18 = (r10 / r1) * r17;
        float r19 = (r15 / r1) * r17;
        if (inAnchoredZoomMode() == false) goto L82;
        float r21 = r19;
    L83:
        boolean r22 = this.isInProgress;
        this.focusX = MathKt.roundToInt(r12);
        this.focusY = MathKt.roundToInt(r13);
        if (inAnchoredZoomMode() == false) goto L86;
    L91:
        if (r5 == false) goto L94;
        this.currentSpanX = r18;
        this.previousSpanX = r18;
        this.currentSpanY = r19;
        this.previousSpanY = r19;
        this.currentSpan = r21;
        this.previousSpan = r21;
        this.initialSpan = r21;
    L94:
        if (inAnchoredZoomMode() == false) goto L96;
        int r23 = this.spanSlop;
    L98:
        if (this.isInProgress == true) goto L106;
        if (r21 < r23) goto L106;
        if (r22 == false) goto L103;
    L104:
        this.currentSpanX = r18;
        this.previousSpanX = r18;
        this.currentSpanY = r19;
        this.previousSpanY = r19;
        this.currentSpan = r21;
        this.previousSpan = r21;
        long r24 = this.eventTime;
        this.prevTime = r24;
        this.isInProgress = this.listener.onZoomEvent(new ZoomEvent.Begin(r24, this.focusX, this.focusY));
        goto L106
    L103:
        if (Math.abs(r21 - this.initialSpan) > this.spanSlop) goto L104;
    L106:
        if (r2 != 2) goto L121;
        this.currentSpanX = r18;
        this.currentSpanY = r19;
        this.currentSpan = r21;
        if (this.isInProgress == false) goto L110;
        boolean r25 = this.listener.onZoomEvent(new ZoomEvent.Move(this.eventTime, this.focusX, this.focusY, getIncrementalScaleFactor()));
    L111:
        if (r25 == false) goto L122;
        this.previousSpanX = this.currentSpanX;
        this.previousSpanY = this.currentSpanY;
        this.previousSpan = this.currentSpan;
        this.prevTime = this.eventTime;
        return true;
    L122:
        return true;
    L110:
        r25 = true;
        goto L111
    L121:
        return true;
    L96:
        r23 = this.minSpan;
        goto L98
    L86:
        if (this.isInProgress == false) goto L91;
        if (r21 < this.minSpan) goto L90;
        if (r5 == false) goto L91;
    L90:
        this.listener.onZoomEvent(new ZoomEvent.End(this.eventTime, this.focusX, this.focusY, getIncrementalScaleFactor()));
        this.isInProgress = false;
        this.initialSpan = r21;
        goto L91
    L82:
        r21 = (float) Math.hypot(r18, r19);
        goto L83
    L66:
        r14 = false;
        goto L67
    L68:
        int r26 = 0;
        float r27 = MenuKt.ClosedAlphaTarget;
        float r110 = MenuKt.ClosedAlphaTarget;
    L69:
        if (r26 >= r3) goto L73;
        if (r8 == r26) goto L72;
        r27 = r27 + r20.getX(r26);
        r110 = r110 + r20.getY(r26);
    L72:
        r26 = r26 + 1;
        goto L69
    L73:
        float r28 = r11;
        float r29 = r27 / r28;
        r13 = r110 / r28;
        r12 = r29;
        goto L74
    L60:
        r11 = r3;
        goto L62
    L57:
        r8 = -1;
        goto L58
    L54:
        r6 = false;
    L51:
        r5 = true;
    L25:
        if (this.isInProgress == false) goto L28;
        this.listener.onZoomEvent(new ZoomEvent.End(this.eventTime, this.focusX, this.focusY, getIncrementalScaleFactor()));
        this.isInProgress = false;
        this.initialSpan = MenuKt.ClosedAlphaTarget;
        this.anchoredZoomMode = 0;
    L31:
        if (r9 == false) goto L35;
        return true;
    L28:
        if (inAnchoredZoomMode() == false) goto L31;
        if (r9 == false) goto L31;
        this.isInProgress = false;
        this.initialSpan = MenuKt.ClosedAlphaTarget;
        this.anchoredZoomMode = 0;
        goto L31
    L16:
        if (r2 == 3) goto L20;
        if (r7 == true) goto L20;
        r9 = false;
    L13:
        r7 = false;
        goto L14
    L8:
        r4 = false;
        goto L10
    }

    public final void setQuickZoomEnabled(boolean r1) {
        this.isQuickZoomEnabled = r1;
    }

    public final void setStylusZoomEnabled(boolean r1) {
        this.isStylusZoomEnabled = r1;
    }

    public static final /* synthetic */ void access$setAnchoredZoomMode$p(ZoomGestureDetector r0, int r1) {
        r0.anchoredZoomMode = r1;
    }

    public static final /* synthetic */ void access$setAnchoredZoomStartX$p(ZoomGestureDetector r0, float r1) {
        r0.anchoredZoomStartX = r1;
    }

    public static final /* synthetic */ void access$setAnchoredZoomStartY$p(ZoomGestureDetector r0, float r1) {
        r0.anchoredZoomStartY = r1;
    }

    public ZoomGestureDetector(Context r2, int r3, int r4, OnZoomGestureListener r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, "listener");
        this.context = r2;
        this.spanSlop = r3;
        this.minSpan = r4;
        this.listener = r5;
        this.isQuickZoomEnabled = true;
        this.isStylusZoomEnabled = true;
        this.gestureDetector = new GestureDetector(r2, new ZoomGestureDetector$gestureDetector$1(this));
    }

    public /* synthetic */ ZoomGestureDetector(Context r1, int r2, int r3, OnZoomGestureListener r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = ViewConfiguration.get(r1).getScaledTouchSlop() * 2;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3, r4);
    }
}
