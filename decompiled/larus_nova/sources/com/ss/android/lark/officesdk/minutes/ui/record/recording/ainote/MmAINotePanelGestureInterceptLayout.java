package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001&B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u001eH\u0016J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0007H\u0002J\u001a\u0010#\u001a\u0004\u0018\u00010\u00152\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u0012H\u0002R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINotePanelGestureInterceptLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gestureListener", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINotePanelGestureInterceptLayout$GestureListener;", "getGestureListener", "()Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINotePanelGestureInterceptLayout$GestureListener;", "setGestureListener", "(Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINotePanelGestureInterceptLayout$GestureListener;)V", "touchSlop", "downX", "", "downY", "activeTouchTarget", "Landroid/view/View;", "handlingVerticalSwipe", "", "gestureTriggered", "requestDisallowInterceptTouchEvent", "", "disallowIntercept", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "event", "canActiveTouchTargetScrollVertically", "direction", "findTouchTarget", "x", "y", "GestureListener", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmAINotePanelGestureInterceptLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f436018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f436019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f436020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f436021d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f436022e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f436023f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f436024g;

    public interface a {
        boolean a();

        void b(float r100);

        void c(float r100);

        void d();

        boolean onDragStart();
    }

    public MmAINotePanelGestureInterceptLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MmAINotePanelGestureInterceptLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r100) {
    }

    public final a getGestureListener() {
        return this.f436018a;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = r100.getActionMasked();
        if (r101 != 0) goto L5;
        this.f436020c = r100.getRawX();
        this.f436021d = r100.getRawY();
        this.f436022e = a(r100.getX(), r100.getY());
        this.f436023f = false;
        this.f436024g = false;
    L50:
        return super.onInterceptTouchEvent(r100);
    L5:
        if (r101 != 1) goto L7;
    L47:
        this.f436022e = null;
        this.f436023f = false;
        this.f436024g = false;
        goto L50
    L7:
        if (r101 != 2) goto L9;
        float r102 = r100.getRawX() - this.f436020c;
        float r103 = r100.getRawY() - this.f436021d;
        if (Math.abs(r103) <= Math.abs(r102)) goto L50;
        if (Math.abs(r103) <= (this.f436019b * 2)) goto L50;
        if (r103 >= 0.0f) goto L26;
        a r104 = this.f436018a;
        if (r104 != null) goto L20;
    L22:
        boolean r105 = false;
    L23:
        if (r105 == false) goto L26;
        this.f436023f = true;
        return true;
    L20:
        if (r104.a() != true) goto L22;
        r105 = true;
    L26:
        if (r103 >= 0.0f) goto L28;
        int r106 = 1;
    L29:
        View r107 = this.f436022e;
    L30:
        if (r107 == null) goto L41;
        if (r107 == this) goto L41;
        if (r107.getVisibility() == 0) goto L35;
    L37:
        Object r108 = r107.getParent();
        if ((r108 instanceof View) == true) goto L39;
        r107 = null;
        goto L30
    L39:
        r107 = (View) r108;
        goto L30
    L35:
        if (r107.canScrollVertically(r106) == false) goto L37;
        boolean r109 = true;
    L42:
        if (r109 == false) goto L45;
        this.f436023f = false;
        return false;
    L45:
        this.f436023f = true;
        return true;
    L41:
        r109 = false;
        goto L42
    L28:
        r106 = -1;
        goto L29
    L9:
        if (r101 == 3) goto L47;
        goto L47
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f436023f == false) goto L5;
    L8:
        int r101 = r100.getActionMasked();
        boolean r102 = false;
        if (r101 != 0) goto L11;
        this.f436020c = r100.getRawX();
        this.f436021d = r100.getRawY();
        this.f436022e = a(r100.getX(), r100.getY());
        this.f436024g = false;
        return true;
    L11:
        if (r101 != 1) goto L13;
        float r103 = r100.getRawY() - this.f436021d;
        if (this.f436024g == false) goto L49;
        a r104 = this.f436018a;
        if (r104 == null) goto L49;
        r104.c(r103);
    L49:
        this.f436022e = null;
        this.f436023f = false;
        this.f436024g = false;
        return true;
    L13:
        if (r101 != 2) goto L15;
        float r105 = r100.getRawX() - this.f436020c;
        float r106 = r100.getRawY() - this.f436021d;
        if (Math.abs(r106) > Math.abs(r105)) goto L27;
    L43:
        return true;
    L27:
        if (Math.abs(r106) <= this.f436019b) goto L43;
        if (this.f436024g == true) goto L39;
        a r107 = this.f436018a;
        if (r107 != null) goto L33;
    L35:
        this.f436024g = r102;
        if (r102 == false) goto L39;
        this.f436020c = r100.getRawX();
        this.f436021d = r100.getRawY();
        goto L39
    L33:
        if (r107.onDragStart() != true) goto L35;
        r102 = true;
    L39:
        if (this.f436024g == false) goto L43;
        a r108 = this.f436018a;
        if (r108 == null) goto L43;
        r108.b(r100.getRawY() - this.f436021d);
        goto L43
    L15:
        if (r101 != 3) goto L43;
        if (this.f436024g == false) goto L22;
        a r109 = this.f436018a;
        if (r109 == null) goto L22;
        r109.d();
    L22:
        this.f436022e = null;
        this.f436023f = false;
        this.f436024g = false;
        return true;
    L5:
        if (r100.getActionMasked() == 0) goto L8;
        return super.onTouchEvent(r100);
    }

    public final void setGestureListener(a r100) {
        this.f436018a = r100;
    }

    public final View a(float r100, float r101) {
        int r102 = getChildCount();
    L3:
        r102 = r102 - 1;
        if ((-1) >= r102) goto L9;
        View r103 = getChildAt(r102);
        float r104 = r100 - r103.getLeft();
        float r105 = r101 - r103.getTop();
        Intrinsics.checkNotNull(r103);
        View r106 = b(r103, r104, r105);
        if (r106 == null) goto L3;
        return r106;
    L9:
        return null;
    }

    public MmAINotePanelGestureInterceptLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f436019b = ViewConfiguration.get(r100).getScaledTouchSlop();
    }

    public static final View b(View r100, float r101, float r102) {
        if (r100.getVisibility() == 0) goto L6;
        return null;
    L6:
        if (r101 >= 0.0f) goto L8;
    L24:
        return null;
    L8:
        if (r102 < 0.0f) goto L24;
        if (r101 >= r100.getWidth()) goto L24;
        if (r102 >= r100.getHeight()) goto L24;
        if ((r100 instanceof ViewGroup) == true) goto L17;
        return r100;
    L17:
        ViewGroup r103 = (ViewGroup) r100;
        int r104 = r103.getChildCount() - 1;
    L18:
        if ((-1) >= r104) goto L23;
        View r105 = r103.getChildAt(r104);
        float r106 = r101 - r105.getLeft();
        float r107 = r102 - r105.getTop();
        Intrinsics.checkNotNull(r105);
        View r108 = b(r105, r106, r107);
        if (r108 != null) goto L21;
        r104 = r104 - 1;
        goto L18
    L21:
        return r108;
    L23:
        return r100;
    }

    public /* synthetic */ MmAINotePanelGestureInterceptLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
