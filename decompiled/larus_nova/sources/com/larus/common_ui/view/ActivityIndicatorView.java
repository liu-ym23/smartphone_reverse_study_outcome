package com.larus.common_ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.lynx.tasm.LynxTemplateRender;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001d\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\nJ*\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0014J\u0018\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u000eH\u0002J\u0018\u0010&\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u000eH\u0002J\b\u0010'\u001a\u00020\u001dH\u0014J\b\u0010(\u001a\u00020\u001dH\u0014J\u0006\u0010)\u001a\u00020\u001dJ\u0006\u0010*\u001a\u00020\u001dJ\u000e\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u0007J\u000e\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u000eJ\u000e\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u0007J\u000e\u00101\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u0010R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/larus/common_ui/view/ActivityIndicatorView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mColor", "mStartAngle", "mStrokeWidth", "", "isAutoStart", "", "mLineCount", "minAlpha", "mAngleGradient", "mColors", "", "mPaint", "Landroid/graphics/Paint;", "mAnimHandler", "Landroid/os/Handler;", "mAnimRunnable", "Ljava/lang/Runnable;", LynxTemplateRender.RENDER_PHASE_SETUP, "", "defStyleRes", "initialize", "onDraw", "canvas", "Landroid/graphics/Canvas;", "pointX", "angle", "radius", "pointY", "onAttachedToWindow", "onDetachedFromWindow", "start", "stop", "setColor", "color", "setStrokeWidth", "strokeWidth", "setStartAngle", "startAngle", "autoStart", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActivityIndicatorView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f328117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f328118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f328119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f328120d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f328121e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f328122f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Paint f328123g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Handler f328124h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f328125i;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActivityIndicatorView f328126a;

        @Override // java.lang.Runnable
        public final void run() {
            ActivityIndicatorView r100 = this.f328126a;     // Catch: Throwable -> L4
            r100.f328118b += r100.f328121e;     // Catch: Throwable -> L4
            r100.invalidate();     // Catch: Throwable -> L4
            Handler r101 = this.f328126a.f328124h;     // Catch: Throwable -> L4
            Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L4
            r101.postDelayed(this, 100);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(ActivityIndicatorView r100) {
            this.f328126a = r100;
        }
    }

    public final void b() {
        Handler r100 = this.f328124h;
        Intrinsics.checkNotNull(r100);
        r100.removeCallbacks(this.f328125i);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f328120d == false) goto L6;
        Handler r100 = this.f328124h;
        Intrinsics.checkNotNull(r100);
        r100.post(this.f328125i);
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f328124h == null) goto L6;
        b();
        return;
    }

    public ActivityIndicatorView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r210) {
        Intrinsics.checkNotNullParameter(r210, "canvas");
        super.onDraw(r210);
        int r100 = 2;
        int r101 = getWidth() / 2;
        int r110 = getHeight() / 2;
        float r111 = Math.min((getWidth() - getPaddingStart()) - getPaddingEnd(), (getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f;
        if (this.f328119c != 0.0f) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        float r103 = 2;
        this.f328119c = a(this.f328121e / 2, r111 / r103) / r103;
    L8:
        Paint r104 = this.f328123g;
        Intrinsics.checkNotNull(r104);
        r104.setStrokeWidth(this.f328119c);
        int r112 = this.f328122f.length;
        int r113 = 0;
    L9:
        if (r113 >= r112) goto L11;
        Paint r105 = this.f328123g;
        Intrinsics.checkNotNull(r105);
        r105.setColor(this.f328122f[r113]);
        float r106 = r101;
        float r107 = r100;
        float r108 = r111 / r107;
        float r109 = a(((-this.f328121e) * r113) + this.f328118b, r108) + r106;
        float r114 = r110;
        int r115 = r110;
        double r116 = ((double) (((-this.f328121e) * r113) + this.f328118b)) * 3.141592653589793d;
        double r117 = 180;
        float r118 = ((float) (((double) r108) * Math.sin(r116 / r117))) + r114;
        float r119 = a(((-this.f328121e) * r113) + this.f328118b, r111 - (this.f328119c / r107)) + r106;
        int r120 = ((-this.f328121e) * r113) + this.f328118b;
        float r121 = r114 + ((float) ((r111 - (this.f328119c / r107)) * Math.sin((((double) r120) * 3.141592653589793d) / r117)));
        Paint r122 = this.f328123g;
        Intrinsics.checkNotNull(r122);
        r210.drawLine(r109, r118, r119, r121, r122);
        r113 = r113 + 1;
        r101 = r101;
        r110 = r115;
        r100 = 2;
        goto L9
    L11:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void setColor(int r100) {
        this.f328117a = r100;
    }

    public final void setStartAngle(int r100) {
        this.f328118b = r100;
    }

    public final void setStrokeWidth(float r100) {
        this.f328119c = r100;
    }

    public ActivityIndicatorView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public static float a(int r100, float r101) {
        return (float) (((double) r101) * Math.cos((((double) r100) * 3.141592653589793d) / ((double) 180)));
    }

    public ActivityIndicatorView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f328117a = Color.argb(255, 255, 255, 255);
        this.f328121e = 45;
        this.f328122f = new int[8];
        this.f328124h = new Handler(Looper.getMainLooper());
        this.f328125i = new a(this);
        int r103 = 0;
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.larus_aiv_auto_start, R.attr.larus_aiv_color, R.attr.larus_aiv_startAngle, R.attr.larus_aiv_strokeWidth}, r102, 0);
        this.f328117a = r104.getColor(1, this.f328117a);
        this.f328118b = r104.getInt(2, this.f328118b);
        this.f328119c = r104.getDimension(3, this.f328119c);
        this.f328120d = r104.getBoolean(0, true);
        r104.recycle();
        this.f328123g = new Paint(1);
        int r105 = Color.alpha(this.f328117a);
        int r106 = Color.red(this.f328117a);
        int r107 = Color.green(this.f328117a);
        int r108 = Color.blue(this.f328117a);
        int r109 = Math.abs(r105 + 0) / 8;
    L3:
        if (r103 >= 8) goto L5;
        this.f328122f[r103] = Color.argb(r105 - (r109 * r103), r106, r107, r108);
        r103 = r103 + 1;
        goto L3
    L5:
        Paint r110 = this.f328123g;
        Intrinsics.checkNotNull(r110);
        r110.setStrokeCap(Paint.Cap.ROUND);
    }
}
