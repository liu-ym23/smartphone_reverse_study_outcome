package com.larus.camera.impl.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableKt;
import com.byted.cast.common.CastMonitor;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 92\u00020\u0001:\u00019B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0014J\u0010\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020\u0016H\u0016J0\u0010*\u001a\u00020%2\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u00020\u0014H\u0014J\u0006\u00100\u001a\u00020\u0012J\u000e\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020\u0014J\u000e\u00103\u001a\u00020%2\u0006\u00104\u001a\u00020#J\u0016\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020\u00142\u0006\u00105\u001a\u00020\u0007J\b\u00106\u001a\u00020%H\u0002J\f\u00107\u001a\u00020\u0014*\u00020\u0014H\u0002J\u0006\u00108\u001a\u00020%R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0018\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/larus/camera/impl/widget/EduCaptureTipView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "recordViewSize", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;Z)V", "cornerBitmaps", "", "Landroid/graphics/Bitmap;", "[Landroid/graphics/Bitmap;", "cornerMatrix", "Landroid/graphics/Matrix;", "[Landroid/graphics/Matrix;", "textView", "Landroidx/appcompat/widget/AppCompatTextView;", "imageSize", "", "currentDegree", "", "viewWidth", "viewHeight", "drawableMargin", "getDrawableMargin", "()I", "drawableMargin$delegate", "Lkotlin/Lazy;", "bitmapPaint", "Landroid/graphics/Paint;", "animator", "Landroid/animation/ValueAnimator;", "customRectSizeCalculator", "Lcom/larus/camera/impl/widget/RectSizeCalculator;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setAlpha", "alpha", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "getTextView", "rotateTo", "degrees", "customCalRectSize", "calculator", "animate", "calCornerPosition", "degree2Valid", MapMonitorConst.EVENT_DESTROY, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EduCaptureTipView extends FrameLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int f322848l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f322849m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f322850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bitmap[] f322851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix[] f322852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f322853d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f322854e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f322855f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f322856g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f322857h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f322858i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f322859j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ValueAnimator f322860k;

    public static final class a {
        public static Pair a(Context r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            if (EduCaptureTipView.f322848l != 0) goto L5;
        L11:
            int r102 = r100.getResources().getDimensionPixelSize(R.dimen.larus_edu_capture_tip_view_width_backup);
            int r103 = r100.getResources().getDimensionPixelSize(R.dimen.larus_edu_capture_tip_view_height_backup);
        L13:
            if ((r101 % 180) != 0) goto L16;
            return TuplesKt.to(Integer.valueOf(r102), Integer.valueOf(r103));
        L16:
            return TuplesKt.to(Integer.valueOf(r103), Integer.valueOf(r102));
        L5:
            if (EduCaptureTipView.f322849m == 0) goto L11;
            int r104 = r100.getResources().getDimensionPixelSize(R.dimen.larus_edu_capture_tip_view_drawable_margin);
            int r105 = EduCaptureTipView.f322849m;
            r103 = r105 / 3;
            if ((r101 % 180) != 0) goto L10;
            r105 = EduCaptureTipView.f322848l;
        L10:
            r102 = r105 - (r104 * 2);
            goto L13
        }
    }

    static {
    }

    public EduCaptureTipView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 6);
    }

    public EduCaptureTipView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4);
    }

    private final int getDrawableMargin() {
        return ((Number) this.f322858i.getValue()).intValue();
    }

    public final void a() {
        if (this.f322852c != null) goto L5;
        return;
    L5:
        Float r100 = Float.valueOf(this.f322856g);
        if (r100.floatValue() <= 0.0f) goto L8;
        boolean r101 = true;
    L9:
        Float r102 = null;
        if (r101 == true) goto L13;
        r100 = null;
    L13:
        if (r100 == null) goto L23;
        float r103 = r100.floatValue();
        Float r104 = Float.valueOf(this.f322857h);
        if (r104.floatValue() <= 0.0f) goto L17;
        boolean r105 = true;
    L18:
        if (r105 == false) goto L20;
        r102 = r104;
    L20:
        if (r102 == null) goto L24;
        float r106 = r102.floatValue();
        float r107 = 2;
        float r108 = getMeasuredWidth() / r107;
        float r109 = getMeasuredHeight() / r107;
        float r110 = (r103 - ((r103 - r106) * (Math.abs(this.f322855f) / 90))) - (getDrawableMargin() * 2);
        Matrix r111 = this.f322852c[0];
        r111.reset();
        float r112 = r110 / r107;
        float r113 = r108 - r112;
        float r114 = (r106 / 3) / r107;
        float r115 = r109 - r114;
        r111.setTranslate(r113, r115);
        r111.postRotate(this.f322855f, r108, r109);
        Matrix r116 = this.f322852c[1];
        r116.reset();
        float r117 = r112 + r108;
        r116.setTranslate(r117 - this.f322854e, r115);
        r116.postRotate(this.f322855f, r108, r109);
        Matrix r118 = this.f322852c[2];
        r118.reset();
        int r119 = this.f322854e;
        float r120 = r114 + r109;
        r118.setTranslate(r117 - r119, r120 - r119);
        r118.postRotate(this.f322855f, r108, r109);
        Matrix r121 = this.f322852c[3];
        r121.reset();
        r121.setTranslate(r113, r120 - this.f322854e);
        r121.postRotate(this.f322855f, r108, r109);
        return;
    L24:
        return;
    L17:
        r105 = false;
        goto L18
    L23:
        return;
    L8:
        r101 = false;
        goto L9
    }

    public final AppCompatTextView getTextView() {
        return this.f322853d;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        Bitmap[] r101 = this.f322851b;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.f322852c == null) goto L11;
        int r102 = r101.length;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L12;
        r100.drawBitmap(this.f322851b[r103], this.f322852c[r103], this.f322859j);
        r103 = r103 + 1;
        goto L7
    L12:
        return;
    }

    @Override // android.view.View
    public void setAlpha(float r100) {
        super.setAlpha(r100);
        this.f322859j.setAlpha((int) (r100 * 255));
    }

    public EduCaptureTipView(Context r110, AttributeSet r111, int r112) {
        Bitmap[] r100 = null;
        if ((r112 & 2) == 0) goto L6;
        r111 = null;
    L6:
        if ((r112 & 4) == 0) goto L8;
        boolean r113 = true;
    L9:
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111);
        this.f322850a = r113;
        this.f322853d = new AppCompatTextView(r110);
        this.f322858i = LazyKt.lazy(LazyThreadSafetyMode.NONE, new k());
        this.f322859j = new Paint();
        Drawable r101 = ContextCompat.getDrawable(r110, R.drawable.larus_edu_camera_ic_tip_rect_topleft);
        if (r101 == null) goto L12;
        Bitmap r114 = DrawableKt.toBitmap$default(r101, 0, 0, null, 7, null);
    L13:
        if (r114 == null) goto L23;
        this.f322854e = r114.getWidth();
        Matrix[] r115 = new Matrix[4];
        int r116 = 0;
    L15:
        if (r116 >= 4) goto L17;
        r115[r116] = new Matrix();
        r116 = r116 + 1;
        goto L15
    L17:
        this.f322852c = r115;
        Matrix r117 = new Matrix();
        r100 = new Bitmap[4];
        int r118 = 0;
    L18:
        if (r118 >= 4) goto L24;
        if (r118 != 0) goto L21;
        Bitmap r102 = r114;
    L22:
        r100[r118] = r102;
        r118 = r118 + 1;
        goto L18
    L21:
        r117.postRotate(90.0f);
        r102 = Bitmap.createBitmap(r114, 0, 0, r114.getWidth(), r114.getHeight(), r117, true);
        Intrinsics.checkNotNull(r102);
    L24:
        this.f322851b = r100;
        this.f322853d.setGravity(17);
        View r119 = this.f322853d;
        FrameLayout.LayoutParams r120 = new FrameLayout.LayoutParams(-2, -2);
        r120.gravity = 17;
        Unit r121 = Unit.INSTANCE;
        addView(r119, r120);
        setWillNotDraw(false);
        return;
    L23:
        this.f322854e = 0;
        this.f322852c = null;
        goto L24
    L12:
        r114 = null;
        goto L13
    L8:
        r113 = false;
        goto L9
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (getMeasuredHeight() == this.f322857h) goto L5;
    L6:
        this.f322856g = getMeasuredWidth();
        this.f322857h = getMeasuredHeight();
        if (this.f322850a == false) goto L9;
        f322848l = getMeasuredWidth();
        f322849m = getMeasuredHeight();
    L14:
        a();
        return;
    L9:
        int r105 = f322849m;
        if (r105 == 0) goto L14;
        int r106 = f322848l;
        if (r106 == 0) goto L14;
        this.f322856g = r106;
        this.f322857h = r105;
        goto L14
    L5:
        if (getMeasuredWidth() != this.f322856g) goto L6;
    }
}
