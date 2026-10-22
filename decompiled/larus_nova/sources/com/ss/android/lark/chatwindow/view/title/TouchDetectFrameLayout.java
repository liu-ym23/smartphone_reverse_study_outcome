package com.ss.android.lark.chatwindow.view.title;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001!\u0018\u0000 &2\u00020\u0001:\u0002&'B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%H\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"¨\u0006("}, d2 = {"Lcom/ss/android/lark/chatwindow/view/title/TouchDetectFrameLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gestureDetector", "Landroid/view/GestureDetector;", "enableCheck", "", "getEnableCheck", "()Z", "setEnableCheck", "(Z)V", "enableClick", "getEnableClick", "setEnableClick", "enableTouchMoveCheck", "getEnableTouchMoveCheck", "setEnableTouchMoveCheck", "listener", "Lcom/ss/android/lark/chatwindow/view/title/TouchDetectFrameLayout$OnTouchEventDetectedListener;", "getListener", "()Lcom/ss/android/lark/chatwindow/view/title/TouchDetectFrameLayout$OnTouchEventDetectedListener;", "setListener", "(Lcom/ss/android/lark/chatwindow/view/title/TouchDetectFrameLayout$OnTouchEventDetectedListener;)V", "gestureListener", "com/ss/android/lark/chatwindow/view/title/TouchDetectFrameLayout$gestureListener$1", "Lcom/ss/android/lark/chatwindow/view/title/TouchDetectFrameLayout$gestureListener$1;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "Companion", "OnTouchEventDetectedListener", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TouchDetectFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public GestureDetector f417121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f417122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f417123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f417124d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f417125e;

    public static final class a {
    }

    public interface b {
    }

    public static final class c extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TouchDetectFrameLayout f417126a;

        public c(TouchDetectFrameLayout r100) {
            this.f417126a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            return this.f417126a.getEnableCheck();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            if (this.f417126a.getEnableClick() == false) goto L6;
            Log.d("TouchDetectFrameLayout", "click");
            this.f417126a.getListener();
        L6:
            return this.f417126a.getEnableClick();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            Intrinsics.checkNotNullParameter(r101, "e2");
            if (r100 != null) goto L7;
            return false;
        L7:
            if (this.f417126a.getEnableTouchMoveCheck() == false) goto L19;
            if ((r100.getY() - r101.getY()) <= UIUtils.dp2px(this.f417126a.getContext(), 10.0f)) goto L14;
            if (Math.abs(r103) <= 100.0f) goto L14;
            Log.d("TouchDetectFrameLayout", "fling up");
            this.f417126a.getListener();
        L14:
            if ((r101.getY() - r100.getY()) <= UIUtils.dp2px(this.f417126a.getContext(), 10.0f)) goto L19;
            if (Math.abs(r103) <= 100.0f) goto L19;
            Log.d("TouchDetectFrameLayout", "fling down");
            this.f417126a.getListener();
        L19:
            return this.f417126a.getEnableTouchMoveCheck();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            Intrinsics.checkNotNullParameter(r101, "e2");
            if (r100 != null) goto L7;
            return false;
        L7:
            if (this.f417126a.getEnableTouchMoveCheck() == false) goto L15;
            if ((r100.getY() - r101.getY()) <= UIUtils.dp2px(this.f417126a.getContext(), 10.0f)) goto L12;
            Log.d("TouchDetectFrameLayout", "scroll up");
            this.f417126a.getListener();
            goto L15
        L12:
            if ((r101.getY() - r100.getY()) <= UIUtils.dp2px(this.f417126a.getContext(), 10.0f)) goto L15;
            Log.d("TouchDetectFrameLayout", "scroll down");
            this.f417126a.getListener();
        L15:
            return this.f417126a.getEnableTouchMoveCheck();
        }
    }

    static {
    }

    public final b getListener() {
        return null;
    }

    public final void setListener(b r100) {
    }

    public final boolean getEnableCheck() {
        return this.f417122b;
    }

    public final boolean getEnableClick() {
        return this.f417123c;
    }

    public final boolean getEnableTouchMoveCheck() {
        return this.f417124d;
    }

    public TouchDetectFrameLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f417122b = true;
        this.f417125e = new c(this);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f417121a != null) goto L5;
        this.f417121a = new GestureDetector(getContext(), this.f417125e);
    L5:
        GestureDetector r101 = this.f417121a;
        if (r101 == null) goto L9;
        return r101.onTouchEvent(r100);
    L9:
        return super.onTouchEvent(r100);
    }

    public final void setEnableCheck(boolean r100) {
        this.f417122b = r100;
    }

    public final void setEnableClick(boolean r100) {
        this.f417123c = r100;
    }

    public final void setEnableTouchMoveCheck(boolean r100) {
        this.f417124d = r100;
    }

    public TouchDetectFrameLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f417122b = true;
        this.f417125e = new c(this);
    }

    public TouchDetectFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f417122b = true;
        this.f417125e = new c(this);
    }
}
