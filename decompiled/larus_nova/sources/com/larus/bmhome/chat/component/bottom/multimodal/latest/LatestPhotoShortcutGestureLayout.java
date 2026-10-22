package com.larus.bmhome.chat.component.bottom.multimodal.latest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u000b\u0018\u00002\u00020\u0001:\u0001\u001fB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0018H\u0017J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0016H\u0016J\u000e\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0014R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutGestureLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gestureListener", "com/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutGestureLayout$gestureListener$1", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutGestureLayout$gestureListener$1;", "gestureDetector", "Landroid/view/GestureDetector;", "getGestureDetector", "()Landroid/view/GestureDetector;", "gestureDetector$delegate", "Lkotlin/Lazy;", "onGesture", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutGestureLayout$OnGesture;", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "event", "onWindowFocusChanged", "", "hasWindowFocus", "setOnGesture", "OnGesture", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LatestPhotoShortcutGestureLayout extends FrameLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f299835d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f299836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f299837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f299838c;

    public interface a {
        void a();

        void b();

        void c();

        void d();

        void onClick();
    }

    public static final class b extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LatestPhotoShortcutGestureLayout f299839a;

        public b(LatestPhotoShortcutGestureLayout r100) {
            this.f299839a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            a r101 = this.f299839a.f299838c;
            if (r101 == null) goto L7;
            r101.onClick();
            return true;
        L7:
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            Intrinsics.checkNotNullParameter(r101, "e2");
            if (Math.abs(r103) < Math.abs(r102)) goto L5;
            return false;
        L5:
            if (r102 >= 0.0f) goto L14;
            a r104 = this.f299839a.f299838c;
            if (r104 == null) goto L13;
            r104.a();
            return true;
        L13:
            return true;
        L14:
            return false;
        }
    }

    public LatestPhotoShortcutGestureLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LatestPhotoShortcutGestureLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final GestureDetector getGestureDetector() {
        return (GestureDetector) this.f299837b.getValue();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        getGestureDetector().onTouchEvent(r100);
        int r101 = r100.getAction();
        if (r101 == 0) goto L9;
        if (r101 != 1) goto L12;
        a r102 = this.f299838c;
        if (r102 == null) goto L12;
        r102.d();
    L12:
        return true;
    L9:
        a r103 = this.f299838c;
        if (r103 == null) goto L12;
        r103.b();
        goto L12
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean r100) {
        super.onWindowFocusChanged(r100);
        if (getVisibility() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L12;
        if (r100 == true) goto L13;
        a r102 = this.f299838c;
        if (r102 == null) goto L14;
        r102.c();
        return;
    L14:
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setOnGesture(a r100) {
        Intrinsics.checkNotNullParameter(r100, "onGesture");
        this.f299838c = r100;
    }

    public LatestPhotoShortcutGestureLayout(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f299836a = new b(this);
        this.f299837b = LazyKt.lazy(new l(r100, this));
    }

    public /* synthetic */ LatestPhotoShortcutGestureLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
