package com.ss.android.lark.chatwindow.view.title;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001 \u0018\u0000 &2\u00020\u0001:\u0001&B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020$H\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!¨\u0006'"}, d2 = {"Lcom/ss/android/lark/chatwindow/view/title/TouchDetectExceptClickFrameLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "def", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "flingOrScroll", "", "getFlingOrScroll", "()Z", "setFlingOrScroll", "(Z)V", "enableTouchMoveCheck", "getEnableTouchMoveCheck", "setEnableTouchMoveCheck", "listener", "Lcom/ss/android/lark/chatwindow/view/title/TouchDetectFrameLayout$OnTouchEventDetectedListener;", "getListener", "()Lcom/ss/android/lark/chatwindow/view/title/TouchDetectFrameLayout$OnTouchEventDetectedListener;", "setListener", "(Lcom/ss/android/lark/chatwindow/view/title/TouchDetectFrameLayout$OnTouchEventDetectedListener;)V", "gestureDetector", "Landroid/view/GestureDetector;", "getGestureDetector", "()Landroid/view/GestureDetector;", "gestureDetector$delegate", "Lkotlin/Lazy;", "gestureListener", "com/ss/android/lark/chatwindow/view/title/TouchDetectExceptClickFrameLayout$gestureListener$1", "Lcom/ss/android/lark/chatwindow/view/title/TouchDetectExceptClickFrameLayout$gestureListener$1;", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "dispatchTouchEvent", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TouchDetectExceptClickFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f417115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f417116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f417117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f417118d;

    public static final class a {
    }

    public static final class b extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TouchDetectExceptClickFrameLayout f417119a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f417120b;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            this.f417119a.setFlingOrScroll(false);
            return false;
        }

        public b(TouchDetectExceptClickFrameLayout r100, Context r101) {
            this.f417119a = r100;
            this.f417120b = r101;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r110) {
            Intrinsics.checkNotNullParameter(r101, "e2");
            if (r100 != null) goto L5;
            return false;
        L5:
            this.f417119a.setFlingOrScroll(true);
            if (this.f417119a.getEnableTouchMoveCheck() == true) goto L9;
            return false;
        L9:
            if ((r100.getY() - r101.getY()) <= UIUtils.dp2px(this.f417120b, 10.0f)) goto L15;
            if (Math.abs(r110) <= 100.0f) goto L15;
            Log.d("TouchDetectFrameLayout", "fling up");
            this.f417119a.getListener();
            return true;
        L15:
            if ((r101.getY() - r100.getY()) > UIUtils.dp2px(this.f417120b, 10.0f)) goto L17;
        L20:
            return false;
        L17:
            if (Math.abs(r110) <= 100.0f) goto L20;
            Log.d("TouchDetectFrameLayout", "fling down");
            this.f417119a.getListener();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            Intrinsics.checkNotNullParameter(r101, "e2");
            if (r100 != null) goto L5;
            return false;
        L5:
            this.f417119a.setFlingOrScroll(true);
            if (this.f417119a.getEnableTouchMoveCheck() == true) goto L9;
            return false;
        L9:
            if ((r100.getY() - r101.getY()) <= UIUtils.dp2px(this.f417120b, 10.0f)) goto L13;
            Log.d("TouchDetectFrameLayout", "scroll up");
            this.f417119a.getListener();
            return true;
        L13:
            if ((r101.getY() - r100.getY()) <= UIUtils.dp2px(this.f417120b, 10.0f)) goto L16;
            Log.d("TouchDetectFrameLayout", "scroll down");
            this.f417119a.getListener();
            return true;
        L16:
            return false;
        }
    }

    static {
    }

    public TouchDetectExceptClickFrameLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TouchDetectExceptClickFrameLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final TouchDetectFrameLayout.b getListener() {
        return null;
    }

    public final void setListener(TouchDetectFrameLayout.b r100) {
    }

    private final GestureDetector getGestureDetector() {
        return (GestureDetector) this.f417117c.getValue();
    }

    public final boolean getEnableTouchMoveCheck() {
        return this.f417116b;
    }

    public final boolean getFlingOrScroll() {
        return this.f417115a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        getGestureDetector().onTouchEvent(r100);
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (r100.getAction() != 0) goto L6;
        this.f417115a = false;
    L11:
        return super.onInterceptTouchEvent(r100);
    L6:
        if (r100.getAction() != 1) goto L11;
        if (this.f417115a == false) goto L11;
        return true;
    }

    public final void setEnableTouchMoveCheck(boolean r100) {
        this.f417116b = r100;
    }

    public final void setFlingOrScroll(boolean r100) {
        this.f417115a = r100;
    }

    public TouchDetectExceptClickFrameLayout(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f417117c = LazyKt.lazy(new TouchDetectExceptClickFrameLayout$gestureDetector$2(r100, this));
        this.f417118d = new b(this, r100);
    }

    public /* synthetic */ TouchDetectExceptClickFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
