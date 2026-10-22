package com.ss.android.lark.chatwindow.view.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.byted.cast.common.CastMonitor;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 02\u00020\u0001:\u000201B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\rJ\u000e\u0010\"\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0012\u0010#\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010%\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010'\u001a\u00020 2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\b\u0010*\u001a\u00020 H\u0002J \u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u0012H\u0002J\u0010\u0010/\u001a\u00020 2\u0006\u0010&\u001a\u00020\u0012H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u000e\u0010\u001e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/ss/android/lark/chatwindow/view/widget/TouchInterceptionLayout;", "Lcom/ss/android/lark/chatwindow/view/widget/MeasureDetectFrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "handler", "Landroid/os/Handler;", "mDoubleTapSlopSquare", "", "doubleClickEnable", "", "doubleClickListener", "Lcom/ss/android/lark/chatwindow/view/widget/TouchInterceptionLayout$DoubleClickListener;", "mStillDown", "mCurrentDownEvent", "Landroid/view/MotionEvent;", "mPreviousUpEvent", "mIsDoubleTapping", "doubleTapTimeout", "", "getDoubleTapTimeout", "()J", "setDoubleTapTimeout", "(J)V", "doubleTapMinTime", "getDoubleTapMinTime", "setDoubleTapMinTime", "isConsumed", "setIsEnableDoubleClick", "", "enable", "setDoubleClickListener", "dispatchTouchEvent", "ev", "onTouchEvent", "event", "cancelChildrenLongPress", "viewGroup", "Landroid/view/ViewGroup;", "cancel", "isConsideredDoubleTap", "firstDown", "firstUp", "secondDown", "dispatchTouchEventToChildren", "Companion", "DoubleClickListener", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TouchInterceptionLayout extends MeasureDetectFrameLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f417139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f417140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f417141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f417142e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f417143f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public MotionEvent f417144g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MotionEvent f417145h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f417146i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f417147j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f417148k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f417149l;

    public static final class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TouchInterceptionLayout f417150a;

        @Override // android.os.Handler
        public final void handleMessage(Message r110) {
            Intrinsics.checkNotNullParameter(r110, "msg");
            super.handleMessage(r110);
            Log.d("TouchInterceptionLayout", "handleMessage");
            if (r110.what != 65537) goto L24;
            TouchInterceptionLayout r100 = this.f417150a;
            int r101 = 0;
            if (r100.f417149l == false) goto L13;
            if (r100.f417143f == false) goto L9;
            r100.performLongClick();
        L10:
            this.f417150a.f417149l = false;
            return;
        L9:
            r100.performClick();
            goto L10
        L13:
            if (r100.f417143f == false) goto L15;
            return;
        L15:
            Log.d("TouchInterceptionLayout", "performClick");
            Object r111 = r110.obj;
            if ((r111 instanceof MotionEvent) == false) goto L18;
            MotionEvent r112 = (MotionEvent) r111;
        L19:
            if (r112 == null) goto L27;
            TouchInterceptionLayout r102 = this.f417150a;
            r102.getClass();
            MotionEvent r113 = MotionEvent.obtain(r112.getDownTime(), 1 + r112.getEventTime(), 1, r112.getX() - r102.getPaddingLeft(), r112.getY() - r102.getPaddingTop(), r112.getMetaState());
            int r103 = r102.getChildCount();
        L21:
            if (r101 >= r103) goto L23;
            View r104 = r102.getChildAt(r101);
            MotionEvent r105 = MotionEvent.obtain(r113);
            r104.dispatchTouchEvent(r105);
            r105.recycle();
            r101 = r101 + 1;
            goto L21
        L23:
            r113.recycle();
            return;
        L27:
            return;
        L18:
            r112 = null;
            goto L19
        L24:
            Log.d("TouchInterceptionLayout", "unknown msg");
        }

        public a(TouchInterceptionLayout r100, Looper r101) {
            this.f417150a = r100;
            super(r101);
        }
    }

    public static final class b {
    }

    public interface c {
        void a();
    }

    static {
    }

    public final long getDoubleTapMinTime() {
        return this.f417148k;
    }

    public final long getDoubleTapTimeout() {
        return this.f417147j;
    }

    public TouchInterceptionLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public static void a(ViewGroup r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = r100.getChildCount();
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L14;
        View r103 = r100.getChildAt(r102);
        r103.cancelLongPress();
        if ((r103 instanceof ViewGroup) == false) goto L9;
        ViewGroup r104 = (ViewGroup) r103;
    L10:
        if (r104 == null) goto L13;
        a((ViewGroup) r103);
    L13:
        r102 = r102 + 1;
        goto L5
    L9:
        r104 = null;
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r110) {
        if (this.f417141d == false) goto L63;
        if (this.f417142e == null) goto L63;
        if (r110 == null) goto L9;
        Integer r100 = Integer.valueOf(r110.getActionMasked());
    L10:
        boolean r101 = false;
        if (r100 != null) goto L14;
    L40:
        if (r100 != null) goto L43;
    L55:
        if (r100 != null) goto L58;
    L61:
        return super.dispatchTouchEvent(r110);
    L58:
        if (r100.intValue() != 3) goto L61;
        this.f417146i = false;
        this.f417143f = false;
        this.f417149l = false;
        this.f417139b.removeMessages(CastMonitor.EVENT_TRACK);
        goto L61
    L43:
        if (r100.intValue() != 1) goto L55;
        cancelLongPress();
        this.f417143f = false;
        MotionEvent r102 = this.f417145h;
        if (r102 == null) goto L47;
        r102.recycle();
    L47:
        this.f417145h = MotionEvent.obtain(r110);
        if (this.f417139b.hasMessages(CastMonitor.EVENT_TRACK) == false) goto L50;
    L53:
        this.f417146i = false;
        return true;
    L50:
        if (this.f417146i == true) goto L53;
        return super.dispatchTouchEvent(r110);
    L14:
        if (r100.intValue() != 0) goto L40;
        boolean r103 = this.f417139b.hasMessages(CastMonitor.EVENT_TRACK);
        if (r103 == false) goto L18;
        this.f417139b.removeMessages(CastMonitor.EVENT_TRACK);
    L18:
        MotionEvent r104 = this.f417144g;
        if (r104 == null) goto L36;
        MotionEvent r105 = this.f417145h;
        if (r105 == null) goto L36;
        if (r103 == false) goto L36;
        long r106 = r110.getEventTime() - r105.getEventTime();
        if (r106 <= this.f417147j) goto L26;
    L31:
        if (r101 == false) goto L36;
        this.f417146i = true;
        this.f417139b.removeMessages(CastMonitor.EVENT_TRACK);
        cancelLongPress();
        a(this);
        c r111 = this.f417142e;
        if (r111 == null) goto L35;
        r111.a();
    L35:
        return true;
    L26:
        if (r106 < this.f417148k) goto L31;
        int r107 = ((int) r104.getX()) - ((int) r110.getX());
        int r108 = ((int) r104.getY()) - ((int) r110.getY());
        if (((r107 * r107) + (r108 * r108)) >= this.f417140c) goto L31;
        r101 = true;
    L36:
        MotionEvent r109 = this.f417144g;
        if (r109 == null) goto L39;
        r109.recycle();
    L39:
        this.f417144g = MotionEvent.obtain(r110);
        Message r112 = this.f417139b.obtainMessage();
        r112.what = CastMonitor.EVENT_TRACK;
        r112.obj = this.f417144g;
        this.f417139b.sendMessageDelayed(r112, this.f417147j);
        this.f417143f = true;
        goto L61
    L9:
        r100 = null;
    L63:
        return super.dispatchTouchEvent(r110);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f417141d == false) goto L19;
        if (this.f417142e == null) goto L19;
        if (r100 == null) goto L9;
        Integer r101 = Integer.valueOf(r100.getActionMasked());
    L10:
        if (r101 == null) goto L17;
        if (r101.intValue() != 0) goto L17;
        this.f417149l = true;
        return true;
    L17:
        return super.onTouchEvent(r100);
    L9:
        r101 = null;
    L19:
        return super.onTouchEvent(r100);
    }

    public final void setDoubleClickListener(c r100) {
        Intrinsics.checkNotNullParameter(r100, "doubleClickListener");
        this.f417142e = r100;
    }

    public final void setDoubleTapMinTime(long r100) {
        this.f417148k = r100;
    }

    public final void setDoubleTapTimeout(long r100) {
        this.f417147j = r100;
    }

    public final void setIsEnableDoubleClick(boolean r100) {
        this.f417141d = r100;
    }

    public TouchInterceptionLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f417147j = 199;
        this.f417148k = 40;
        this.f417139b = new a(this, Looper.getMainLooper());
        ViewConfiguration r102 = ViewConfiguration.get(r100);
        this.f417140c = r102.getScaledDoubleTapSlop() * r102.getScaledDoubleTapSlop();
    }
}
