package com.obric.oui.slider;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.amap.api.col.s.ce;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pla.d;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001:\u0001CB'\b\u0007\u0012\u0006\u0010=\u001a\u00020<\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>\u0012\b\b\u0002\u0010@\u001a\u00020\u0002¢\u0006\u0004\bA\u0010BJ\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0002J\u0010\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\u0002J\u0010\u0010\r\u001a\u00020\u00042\b\b\u0001\u0010\f\u001a\u00020\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\b\b\u0001\u0010\u000e\u001a\u00020\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\b\b\u0001\u0010\u0010\u001a\u00020\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\b\b\u0001\u0010\u0012\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001c\u001a\u00020\u0018J\u0006\u0010\u001d\u001a\u00020\u0018J\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0002J\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0018J\u0006\u0010!\u001a\u00020\u0018J\u0006\u0010\"\u001a\u00020\u0018J\u0010\u0010%\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#J\u000e\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0018J\u000e\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020(H\u0016J\u0006\u0010.\u001a\u00020-J\u0010\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020(H\u0016R$\u00107\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u0010;\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00102\u001a\u0004\b9\u00104\"\u0004\b:\u00106¨\u0006D"}, d2 = {"Lcom/obric/oui/slider/OSlider;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "thumbColor", "", "setThumbColorInt", "thumbColorResId", "setThumbColor", "backgroundColor", "setProcessBackgroundColorInt", "progressColor", "setProcessProgressColorInt", "backgroundColorResId", "setProcessBackgroundColor", "progressColorResId", "setProcessProgressColor", "tickColor", "setTickColorInt", "tickColorResId", "setTickColor", "Landroid/graphics/drawable/Drawable;", "drawable", "setLeftIcon", "setRightIcon", "", "value", "setMinValue", "setMaxValue", "getMinValue", "getMaxValue", "setTickMarkCount", "process", "setProgress", "getProgress", "getRealProgress", "Lcom/obric/oui/slider/TickMarkSeekBar$b;", "listener", "setOnSeekBarChangeListenerExt", "seekBarHeight", "setSeekBarHeight", "", "isStyleSegmented", "setIsSegmented", "enabled", "setEnabled", "Landroid/widget/SeekBar;", "getSeekBar", "hapticFeedbackEnabled", "setHapticFeedbackEnabled", ce.f26395j, "Landroid/graphics/drawable/Drawable;", "getLeftImage", "()Landroid/graphics/drawable/Drawable;", "setLeftImage", "(Landroid/graphics/drawable/Drawable;)V", "leftImage", ce.f26396k, "getRightImage", "setRightImage", "rightImage", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OSlider extends ConstraintLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f402987l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SeekBarFloatCompat f402988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f402989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f402990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f402991d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f402992e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TickMarkSeekBar.b f402993f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f402994g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f402995h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f402996i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Drawable f402997j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable f402998k;

    public static final class a implements TickMarkSeekBar.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OSlider f402999a;

        public a(OSlider r100) {
            this.f402999a = r100;
        }

        @Override // com.obric.oui.slider.TickMarkSeekBar.b
        public final void b(SeekBar r100) {
            TickMarkSeekBar.b r101 = this.f402999a.f402993f;
            if (r101 == null) goto L7;
            r101.b(r100);
            return;
        }

        @Override // com.obric.oui.slider.TickMarkSeekBar.b
        public final void d(TickMarkSeekBar r100) {
            OSlider r101 = this.f402999a;
            int r102 = OSlider.f402987l;
            r101.getClass();
            TickMarkSeekBar.b r103 = this.f402999a.f402993f;
            if (r103 == null) goto L7;
            r103.d(r100);
            return;
        }

        @Override // com.obric.oui.slider.TickMarkSeekBar.b
        public final void e(int r100) {
            TickMarkSeekBar.b r101 = this.f402999a.f402993f;
            if (r101 == null) goto L7;
            r101.e(r100);
            return;
        }

        @Override // com.obric.oui.slider.TickMarkSeekBar.b
        public final void onStartTrackingTouch(SeekBar r100) {
            OSlider r101 = this.f402999a;
            int r102 = OSlider.f402987l;
            r101.getClass();
            TickMarkSeekBar.b r103 = this.f402999a.f402993f;
            if (r103 == null) goto L7;
            r103.onStartTrackingTouch(r100);
            return;
        }

        @Override // com.obric.oui.slider.TickMarkSeekBar.b
        public final void c(SeekBar r100, float r101) {
            TickMarkSeekBar.b r102 = this.f402999a.f402993f;
            if (r102 == null) goto L7;
            r102.c(r100, r101);
            return;
        }

        @Override // com.obric.oui.slider.TickMarkSeekBar.b
        public final void a(SeekBar r100, float r101, boolean r102) {
            OSlider r103 = this.f402999a;
            TickMarkSeekBar.b r104 = r103.f402993f;
            if (r104 == null) goto L7;
            r104.a(r100, r103.R5(r101), r102);
            return;
        }
    }

    public static final class b {
    }

    static {
    }

    public OSlider(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OSlider(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final float getMaxValue() {
        return R5(this.f402988a.getMaxValue());
    }

    public final float getMinValue() {
        return R5(this.f402988a.getMinValue());
    }

    public final float getProgress() {
        return this.f402988a.getFloatProgress();
    }

    public final float getRealProgress() {
        return R5(this.f402988a.getFloatProgress());
    }

    public final Drawable getLeftImage() {
        return this.f402997j;
    }

    public final Drawable getRightImage() {
        return this.f402998k;
    }

    public final SeekBar getSeekBar() {
        return this.f402988a;
    }

    public final float R5(float r100) {
        float r101 = this.f402991d;
        return CastFloatProtector.parseFloat(String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(r101 + (((r100 - 0.0f) / 100.0f) * (this.f402992e - r101)))}, 1)));
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        this.f402996i = d.n(this, 32);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f402994g == false) goto L5;
        Rect r101 = new Rect();
        this.f402988a.getHitRect(r101);
        int r102 = r100.getActionMasked();
        if (r102 == 0) goto L27;
        if (r102 == 1) goto L23;
        if (r102 == 2) goto L15;
        if (r102 == 3) goto L23;
    L30:
        wma.b.a("OSlider", "onTouchEvent, " + r100.getAction() + ", super.onTouchEvent, isSeeking: " + this.f402995h);
        return super.onTouchEvent(r100);
    L15:
        if (this.f402995h == false) goto L19;
        MotionEvent r103 = MotionEvent.obtain(r100);
        r103.offsetLocation(-this.f402988a.getLeft(), -this.f402988a.getTop());
        this.f402988a.dispatchTouchEvent(r103);
        r103.recycle();
        return true;
    L19:
        if (r101.contains((int) r100.getX(), (int) r100.getY()) == false) goto L30;
        this.f402995h = true;
        MotionEvent r104 = MotionEvent.obtain(r100);
        r104.setAction(0);
        r104.offsetLocation(-this.f402988a.getLeft(), -this.f402988a.getTop());
        this.f402988a.dispatchTouchEvent(r104);
        r104.recycle();
        MotionEvent r105 = MotionEvent.obtain(r100);
        r105.offsetLocation(-this.f402988a.getLeft(), -this.f402988a.getTop());
        this.f402988a.dispatchTouchEvent(r105);
        r105.recycle();
        wma.b.a("OSlider", Intrinsics.stringPlus("onTouchEvent, ACTION_MOVE, case 3, isSeeking: ", Boolean.valueOf(this.f402995h)));
        return true;
    L23:
        if (this.f402995h == false) goto L30;
        MotionEvent r106 = MotionEvent.obtain(r100);
        r106.offsetLocation(-this.f402988a.getLeft(), -this.f402988a.getTop());
        this.f402988a.dispatchTouchEvent(r106);
        r106.recycle();
        this.f402995h = false;
        requestDisallowInterceptTouchEvent(false);
        wma.b.a("OSlider", "onTouchEvent, " + r100.getAction() + ", case 4, isSeeking: " + this.f402995h);
        return true;
    L27:
        if (r101.contains((int) r100.getX(), (int) r100.getY()) == true) goto L30;
        this.f402995h = false;
        requestDisallowInterceptTouchEvent(true);
        wma.b.a("OSlider", Intrinsics.stringPlus("onTouchEvent, ACTION_DOWN, case 1, isSeeking: ", Boolean.valueOf(this.f402995h)));
        return true;
    L5:
        return super.onTouchEvent(r100);
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        this.f402988a.setEnabled(r100);
        this.f402989b.setEnabled(r100);
        if (r100 == false) goto L5;
        float r101 = 1.0f;
    L6:
        setAlpha(r101);
        return;
    L5:
        r101 = 0.5f;
        goto L6
    }

    @Override // android.view.View
    public void setHapticFeedbackEnabled(boolean r100) {
        super.setHapticFeedbackEnabled(r100);
        this.f402988a.setHapticFeedbackEnabled(r100);
    }

    public final void setIsSegmented(boolean r100) {
        SeekBarFloatCompat r101 = this.f402988a;
        r101.f403028y = r100;
        if (r100 == false) goto L5;
        r101.setProgressDrawable(null);
        r101.f403004a = 0;
        r101.setProgress(r101.p(0));
    L6:
        r101.d();
        r101.invalidate();
        return;
    L5:
        r101.f403004a = -1;
        goto L6
    }

    public final void setLeftIcon(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        this.f402989b.setImageDrawable(r100);
    }

    public final void setLeftImage(Drawable r100) {
        this.f402997j = r100;
    }

    public final void setMaxValue(float r100) {
        Intrinsics.stringPlus("setMaxValue >>> ", Float.valueOf(r100));
        this.f402992e = r100;
        this.f402988a.setMinValue(0.0f);
        this.f402988a.setMaxValue(100.0f);
    }

    public final void setMinValue(float r100) {
        Intrinsics.stringPlus("setMinValue >>> ", Float.valueOf(r100));
        this.f402991d = r100;
        this.f402988a.setMinValue(0.0f);
        this.f402988a.setMaxValue(100.0f);
    }

    public final void setOnSeekBarChangeListenerExt(TickMarkSeekBar.b r100) {
        this.f402993f = r100;
    }

    public final void setProcessBackgroundColor(int r100) {
        this.f402988a.setProcessBackgroundColor(r100);
    }

    public final void setProcessBackgroundColorInt(int r100) {
        this.f402988a.setProcessBackgroundColorInt(r100);
    }

    public final void setProcessProgressColor(int r100) {
        this.f402988a.setProcessProgressColor(r100);
    }

    public final void setProcessProgressColorInt(int r100) {
        this.f402988a.setProcessProgressColorInt(r100);
    }

    public final void setProgress(float r100) {
        SeekBarFloatCompat r101 = this.f402988a;
        float r102 = this.f402991d;
        r101.setProgress((((r100 - r102) / (this.f402992e - r102)) * 100.0f) + 0.0f);
    }

    public final void setRightIcon(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        this.f402990c.setImageDrawable(r100);
    }

    public final void setRightImage(Drawable r100) {
        this.f402998k = r100;
    }

    public final void setSeekBarHeight(float r100) {
        this.f402988a.setBackgroundHeight(r100);
    }

    public final void setThumbColor(int r100) {
        this.f402988a.setThumbColor(r100);
    }

    public final void setThumbColorInt(int r100) {
        this.f402988a.setThumbColorInt(r100);
    }

    public final void setTickColor(int r100) {
        this.f402988a.setTickColor(r100);
    }

    public final void setTickColorInt(int r100) {
        this.f402988a.setTickColorInt(r100);
    }

    public final void setTickMarkCount(int r100) {
        this.f402988a.setDefaultTickMarkCount(r100);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(this.f402996i, 1073741824));
    }

    public OSlider(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f402992e = 100.0f;
        d.n(this, 6);
        this.f402996i = d.n(this, 32);
        TypedArray r103 = r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.oui_slider_left_icon, R.attr.oui_slider_right_icon, R.attr.sliderHeight}, r102, 0);
        float r104 = r103.getDimensionPixelSize(2, d.n(this, 6));
        setLeftImage(r103.getDrawable(0));
        setRightImage(r103.getDrawable(1));
        LayoutInflater.from(r100).inflate(R.layout.o_slider, this);
        SeekBarFloatCompat r105 = (SeekBarFloatCompat) findViewById(R.id.seekBar);
        this.f402988a = r105;
        r105.setBackgroundHeight(r104);
        ImageView r106 = (ImageView) findViewById(R.id.tvLeftIcon);
        this.f402989b = r106;
        if (this.f402997j == null) goto L5;
        r106.setVisibility(0);
        r106.setImageDrawable(this.f402997j);
    L5:
        ImageView r107 = (ImageView) findViewById(R.id.tvRightIcon);
        this.f402990c = r107;
        Drawable r108 = this.f402998k;
        if (r108 == null) goto L8;
        r107.setImageDrawable(r108);
        r107.setVisibility(0);
    L8:
        r105.setOnSeekBarChangeListenerExt(new a(this));
        r105.setHapticFeedbackEnabled(isHapticFeedbackEnabled());
    }

    public /* synthetic */ OSlider(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
