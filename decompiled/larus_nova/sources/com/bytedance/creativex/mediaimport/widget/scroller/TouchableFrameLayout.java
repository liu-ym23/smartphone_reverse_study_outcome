package com.bytedance.creativex.mediaimport.widget.scroller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001,B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0014J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u000fH\u0002J\u0018\u0010$\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u000fH\u0002J\u000e\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u0015J\u000e\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0007J\u000e\u0010)\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010*\u001a\u00020\u00192\b\b\u0001\u0010+\u001a\u00020\u000fR\u001e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006-"}, d2 = {"Lcom/bytedance/creativex/mediaimport/widget/scroller/TouchableFrameLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "maxBottom", "getMaxBottom", "()I", "downY", "", "dragThreshold", "mHeight", "disallowIntercept", "", "touchCallback", "Lcom/bytedance/creativex/mediaimport/widget/scroller/TouchableFrameLayout$Callback;", "isDragging", "()Z", "onSizeChanged", "", "w", "h", "oldw", "oldh", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "reachedTop", "top", "finalDeltaY", "reachedBottom", "setTouchCallback", "callback", "updateBottomEdge", "bottom", "enableDisallowInterceptTouchEvent", "setDragDetectThreshold", "threshold", "Callback", "feature-media-import_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TouchableFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f204215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f204216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f204217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f204218d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f204219e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f204220f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f204221g;

    public interface a {
        void a(int r100, int r101);

        void onDragEnd();

        void onDragStart();
    }

    public final int getMaxBottom() {
        return this.f204215a;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = r100.getAction();
        if (r101 == 0) goto L57;
        boolean r102 = false;
        if (r101 == 1) goto L51;
        if (r101 != 2) goto L9;
        float r103 = r100.getY() - this.f204216b;
        int r104 = this.f204218d;
        int r105 = (int) (getY() + r103);
        int r106 = r105 + r104;
        if (r105 >= 0) goto L15;
        r103 = r103 - r105;
        r105 = 0;
    L19:
        if (Math.abs(r103) < this.f204217c) goto L21;
        boolean r107 = true;
    L22:
        if (r107 == false) goto L24;
    L46:
        setY(r105);
        a r108 = this.f204220f;
        if (r108 == null) goto L49;
        r108.a(r105, r104 + r105);
    L49:
        return true;
    L24:
        if (r105 == 0) goto L26;
    L33:
        boolean r109 = false;
    L34:
        if (r109 == true) goto L46;
        if ((this.f204218d + r105) == this.f204215a) goto L38;
    L45:
        if (r102 == false) goto L49;
    L38:
        if (getY() != r105) goto L40;
        boolean r110 = true;
    L41:
        if (r110 == true) goto L45;
        if (r103 <= 0.0f) goto L45;
        r102 = true;
        goto L45
    L40:
        r110 = false;
        goto L41
    L26:
        if (getY() != r105) goto L28;
        boolean r111 = true;
    L29:
        if (r111 == true) goto L33;
        if (r103 >= 0.0f) goto L33;
        r109 = true;
        goto L34
    L28:
        r111 = false;
        goto L29
    L21:
        r107 = false;
        goto L22
    L15:
        int r112 = this.f204215a;
        if (r106 <= r112) goto L19;
        r105 = r112 - r104;
        r103 = r103 - (r106 - r112);
        goto L19
    L9:
        if (r101 == 3) goto L51;
        return super.onTouchEvent(r100);
    L51:
        if (this.f204219e == false) goto L53;
        requestDisallowInterceptTouchEvent(false);
    L53:
        this.f204221g = false;
        a r113 = this.f204220f;
        if (r113 == null) goto L56;
        r113.onDragEnd();
    L56:
        return true;
    L57:
        this.f204216b = r100.getY();
        if (this.f204219e == false) goto L60;
        requestDisallowInterceptTouchEvent(true);
    L60:
        this.f204221g = true;
        a r114 = this.f204220f;
        if (r114 == null) goto L63;
        r114.onDragStart();
    L63:
        return true;
    }

    public final void setDragDetectThreshold(float r100) {
        this.f204217c = r100;
    }

    public final void setTouchCallback(a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f204220f = r100;
    }

    public TouchableFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f204217c = 3.0f;
        this.f204219e = true;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f204218d = r101;
    }
}
