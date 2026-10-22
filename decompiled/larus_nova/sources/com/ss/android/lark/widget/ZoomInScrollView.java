package com.ss.android.lark.widget;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.larksuite.framework.ui.ObservedScrollView;
import com.larksuite.framework.utils.DeviceUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xbc.e;
import xbc.f;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0002$%B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0017H\u0002J(\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0014J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0013H\u0002J\b\u0010#\u001a\u00020\u0017H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082D¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/ss/android/lark/widget/ZoomInScrollView;", "Lcom/larksuite/framework/ui/ObservedScrollView;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mHeaderView", "Landroid/view/View;", "mCardView", "mHeaderWidth", "mHeaderHeight", "mIsPulling", "", "mLastY", "mScaleRatio", "", "mScaleTimes", "mReplyRatio", "onFinishInflate", "", "calculateCardMinHeight", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "ev", "Landroid/view/MotionEvent;", "setZoom", "s", "replyView", "OnScrollListener", "Companion", "widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ZoomInScrollView extends ObservedScrollView {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f445646j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static float f445647k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f445648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f445649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f445650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f445651d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f445652e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f445653f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f445654g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f445655h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f445656i;

    public static final class a {
    }

    static {
    }

    public ZoomInScrollView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ZoomInScrollView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        setOverScrollMode(2);
        View r100 = getChildAt(0);
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof ViewGroup) == false) goto L13;
        ViewGroup r101 = (ViewGroup) r100;
        this.f445648a = r101.getChildAt(0);
        View r102 = r101.getChildAt(1);
        this.f445649b = r102;
        View r103 = this.f445648a;
        if (r103 == null) goto L14;
        if (r102 == null) goto L15;
        r103.post(new e(r103, this));
        return;
    L15:
        return;
    L14:
        return;
    }

    private final void setZoom(float r100) {
        View r101 = this.f445648a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101 == null) goto L13;
        int r102 = this.f445650c;
        if (((float) (((double) (r102 + r100)) / (((double) r102) * 1.0d))) <= this.f445655h) goto L9;
        return;
    L9:
        ViewGroup.LayoutParams r103 = r101.getLayoutParams();
        int r104 = this.f445650c;
        r103.width = (int) (r104 + r100);
        r103.height = (int) (this.f445651d * ((r104 + r100) / r104));
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r103;
        r105.setMargins((-(r105.width - this.f445650c)) / 2, 0, 0, 0);
        View r106 = this.f445648a;
        if (r106 == null) goto L14;
        r106.setLayoutParams(r103);
        return;
    L14:
        return;
    }

    @Override // android.widget.ScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (this.f445648a == null) goto L5;
        int r101 = r100.getAction();
        if (r101 == 1) goto L23;
        if (r101 != 2) goto L27;
        if (this.f445652e == true) goto L18;
        if (getScrollY() != 0) goto L16;
        this.f445653f = (int) r100.getY();
        goto L18
    L16:
        return super.onTouchEvent(r100);
    L18:
        if ((r100.getY() - this.f445653f) < 0.0f) goto L20;
        int r102 = (int) ((r100.getY() - this.f445653f) * this.f445654g);
        this.f445652e = true;
        setZoom(r102);
        return true;
    L20:
        return super.onTouchEvent(r100);
    L27:
        return super.onTouchEvent(r100);
    L23:
        this.f445652e = false;
        View r103 = this.f445648a;
        if (r103 == null) goto L27;
        float r104 = r103.getMeasuredWidth() - this.f445650c;
        ValueAnimator r105 = ObjectAnimator.ofFloat(new float[]{r104, 0.0f}).setDuration((long) (r104 * this.f445656i));
        r105.addUpdateListener(new f(this));
        r105.start();
        goto L27
    L5:
        return super.onTouchEvent(r100);
    }

    public static final /* synthetic */ void a(ZoomInScrollView r100, float r101) {
        r100.setZoom(r101);
    }

    public ZoomInScrollView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100, r101, r102);
        this.f445654g = 0.4f;
        this.f445655h = 2.0f;
        this.f445656i = 0.4f;
        if (f445647k > 0.0f) goto L5;
    L6:
        f445646j = DeviceUtils.getScreenHeight(r100);
        f445647k = DeviceUtils.getScreenDensity(r100);
        return;
    L5:
        if (f445646j <= 0) goto L6;
    }

    public /* synthetic */ ZoomInScrollView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.ScrollView, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        View r104 = this.f445648a;
        if (r104 != null) goto L5;
        return;
    L5:
        if (this.f445649b == null) goto L17;
        int r105 = 0;
        if (r104 == null) goto L10;
        int r106 = r104.getMeasuredWidth();
    L11:
        this.f445650c = r106;
        View r107 = this.f445648a;
        if (r107 == null) goto L14;
        r105 = r107.getMeasuredHeight();
    L14:
        this.f445651d = r105;
        return;
    L10:
        r106 = 0;
        goto L11
    }
}
