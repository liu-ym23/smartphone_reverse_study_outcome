package com.ss.android.lark.chatwindow.view.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 02\u00020\u0001:\u000201B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\rJ\u000e\u0010\"\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0012\u0010#\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010%\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010'\u001a\u00020 2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\b\u0010*\u001a\u00020 H\u0002J \u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u0012H\u0002J\u0010\u0010/\u001a\u00020 2\u0006\u0010&\u001a\u00020\u0012H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u000e\u0010\u001e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/ss/android/lark/chatwindow/view/widget/TouchInterceptionLayout2;", "Lcom/larksuite/component/ui/layout/LKUIRoundableLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "handler", "Landroid/os/Handler;", "mDoubleTapSlopSquare", "", "doubleClickEnable", "", "doubleClickListener", "Lcom/ss/android/lark/chatwindow/view/widget/TouchInterceptionLayout2$DoubleClickListener;", "mStillDown", "mCurrentDownEvent", "Landroid/view/MotionEvent;", "mPreviousUpEvent", "mIsDoubleTapping", "doubleTapTimeout", "", "getDoubleTapTimeout", "()J", "setDoubleTapTimeout", "(J)V", "doubleTapMinTime", "getDoubleTapMinTime", "setDoubleTapMinTime", "isConsumed", "setIsEnableDoubleClick", "", "enable", "setDoubleClickListener", "dispatchTouchEvent", "ev", "onTouchEvent", "event", "cancelChildrenLongPress", "viewGroup", "Landroid/view/ViewGroup;", "cancel", "isConsideredDoubleTap", "firstDown", "firstUp", "secondDown", "dispatchTouchEventToChildren", "Companion", "DoubleClickListener", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TouchInterceptionLayout2 extends LKUIRoundableLayout {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f417151r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f417152s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f417153t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f417154u;

    public static final class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TouchInterceptionLayout2 f417155a;

        @Override // android.os.Handler
        public final void handleMessage(Message r110) {
            Intrinsics.checkNotNullParameter(r110, "msg");
            super.handleMessage(r110);
            Log.d("TouchInterceptionLayout2", "handleMessage");
            if (r110.what != 65537) goto L17;
            TouchInterceptionLayout2 r100 = this.f417155a;
            int r101 = 0;
            if (r100.f417154u == false) goto L8;
            r100.performClick();
            this.f417155a.f417154u = false;
            return;
        L8:
            Log.d("TouchInterceptionLayout2", "performClick");
            Object r111 = r110.obj;
            if ((r111 instanceof MotionEvent) == false) goto L11;
            MotionEvent r112 = (MotionEvent) r111;
        L12:
            if (r112 == null) goto L20;
            TouchInterceptionLayout2 r102 = this.f417155a;
            r102.getClass();
            MotionEvent r113 = MotionEvent.obtain(r112.getDownTime(), 1 + r112.getEventTime(), 1, r112.getX() - r102.getPaddingLeft(), r112.getY() - r102.getPaddingTop(), r112.getMetaState());
            int r103 = r102.getChildCount();
        L14:
            if (r101 >= r103) goto L16;
            View r104 = r102.getChildAt(r101);
            MotionEvent r105 = MotionEvent.obtain(r113);
            r104.dispatchTouchEvent(r105);
            r105.recycle();
            r101 = r101 + 1;
            goto L14
        L16:
            r113.recycle();
            return;
        L20:
            return;
        L11:
            r112 = null;
            goto L12
        L17:
            Log.d("TouchInterceptionLayout2", "unknown msg");
        }

        public a(TouchInterceptionLayout2 r100, Looper r101) {
            this.f417155a = r100;
            super(r101);
        }
    }

    public static final class b {
    }

    public interface c {
    }

    static {
    }

    public final void setDoubleClickListener(c r100) {
        Intrinsics.checkNotNullParameter(r100, "doubleClickListener");
    }

    public final long getDoubleTapMinTime() {
        return this.f417153t;
    }

    public final long getDoubleTapTimeout() {
        return this.f417152s;
    }

    public TouchInterceptionLayout2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        boolean r101 = this.f417151r;
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        boolean r101 = this.f417151r;
        return super.onTouchEvent(r100);
    }

    public final void setDoubleTapMinTime(long r100) {
        this.f417153t = r100;
    }

    public final void setDoubleTapTimeout(long r100) {
        this.f417152s = r100;
    }

    public final void setIsEnableDoubleClick(boolean r100) {
        this.f417151r = r100;
    }

    public TouchInterceptionLayout2(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, 4, 0);
        this.f417152s = 199;
        this.f417153t = 40;
        new a(this, Looper.getMainLooper());
        ViewConfiguration r102 = ViewConfiguration.get(r100);
        r102.getScaledDoubleTapSlop();
        r102.getScaledDoubleTapSlop();
    }
}
