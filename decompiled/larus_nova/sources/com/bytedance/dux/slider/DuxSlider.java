package com.bytedance.dux.slider;

import android.content.Context;
import android.content.res.Resources;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0010J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0010H\u0016¨\u0006!"}, d2 = {"Lcom/bytedance/dux/slider/DuxSlider;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "value", "", "setMinValue", "setMaxValue", "getMinValue", "getMaxValue", "getDefaultValue", "setDefaultValue", "process", "setProgress", "Lcom/bytedance/dux/slider/SeekBarFloatCompat$b;", "listener", "setOnSeekBarChangeListenerExt", "", "isAlwaysLight", "setIsAlwaysLight", "isAlwaysNight", "setIsAlwaysNight", "percent", "setAdsorptionPercent", "enabled", "setEnabled", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxSlider extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f205638j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SeekBarFloatCompat f205639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f205640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f205641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f205642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f205643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f205644f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SeekBarFloatCompat.b f205645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f205646h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Float f205647i;

    public static final class a implements SeekBarFloatCompat.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DuxSlider f205648a;

        public a(DuxSlider r100) {
            this.f205648a = r100;
        }

        @Override // com.bytedance.dux.slider.SeekBarFloatCompat.b
        public final void onStartTrackingTouch(SeekBar r100) {
            DuxSlider r101 = this.f205648a;
            int r102 = DuxSlider.f205638j;
            r101.getClass();
            SeekBarFloatCompat.b r103 = this.f205648a.f205645g;
            if (r103 == null) goto L6;
            r103.onStartTrackingTouch(r100);
            return;
        }

        @Override // com.bytedance.dux.slider.SeekBarFloatCompat.b
        public final void onStopTrackingTouch(SeekBar r100) {
            DuxSlider r101 = this.f205648a;
            int r102 = DuxSlider.f205638j;
            r101.getClass();
            SeekBarFloatCompat.b r103 = this.f205648a.f205645g;
            if (r103 == null) goto L6;
            r103.onStopTrackingTouch(r100);
            return;
        }

        @Override // com.bytedance.dux.slider.SeekBarFloatCompat.b
        public final void a(SeekBar r100, float r101, boolean r102) {
            DuxSlider r103 = this.f205648a;
            int r104 = DuxSlider.f205638j;
            String r105 = String.valueOf((int) r103.R5(r101));
            r103.f205640b.setText(r105);
            float r106 = ((r103.f205639a.getX() + (r103.f205639a.getThumb().getIntrinsicWidth() / 2)) + r103.f205639a.getThumb().getBounds().left) - (r103.f205640b.getPaint().measureText(r105) / 2);
            if (r106 <= 0) goto L5;
            r103.f205640b.setX(r106);
        L5:
            float r107 = this.f205648a.R5(r101);
            if (this.f205648a.getDefaultValue() >= this.f205648a.getMinValue()) goto L8;
        L21:
            this.f205648a.f205647i = Float.valueOf(r107);
            DuxSlider r108 = this.f205648a;
            SeekBarFloatCompat.b r109 = r108.f205645g;
            if (r109 == null) goto L28;
            r109.a(r100, r108.R5(r101), r102);
            return;
        L28:
            return;
        L8:
            if (this.f205648a.getDefaultValue() > this.f205648a.getMaxValue()) goto L21;
            float r110 = Math.abs(r107 - this.f205648a.getDefaultValue()) / (this.f205648a.getMaxValue() - this.f205648a.getMinValue());
            DuxSlider r111 = this.f205648a;
            if (r110 > r111.f205642d) goto L21;
            if (r102 == false) goto L13;
            r111.setProgress(r111.getDefaultValue());
        L13:
            Float r112 = this.f205648a.f205647i;
            if (r112 == null) goto L21;
            Intrinsics.checkNotNull(r112);
            float r113 = Math.abs(r112.floatValue() - r107) / (this.f205648a.getMaxValue() - this.f205648a.getMinValue());
            DuxSlider r114 = this.f205648a;
            if (r113 < r114.f205642d) goto L21;
            if (r114.f205646h == false) goto L21;
            Object r115 = r114.getContext().getSystemService("vibrator");     // Catch: Exception -> L25
            Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type android.os.Vibrator");     // Catch: Exception -> L25
            ((Vibrator) r115).vibrate(10);     // Catch: Exception -> L25
            goto L21
        }
    }

    public DuxSlider(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DuxSlider(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final float getDefaultValue() {
        return R5(this.f205639a.getDefaultValue());
    }

    public final float getMaxValue() {
        return R5(this.f205639a.getMaxValue());
    }

    public final float getMinValue() {
        return R5(this.f205639a.getMinValue());
    }

    public final float R5(float r100) {
        float r101 = this.f205643e;
        return CastFloatProtector.parseFloat(String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(r101 + (((r100 - 0.0f) / 100.0f) * (this.f205644f - r101)))}, 1)));
    }

    public final void setAdsorptionPercent(float r100) {
        this.f205642d = r100;
    }

    public final void setDefaultValue(float r100) {
        SeekBarFloatCompat r101 = this.f205639a;
        float r102 = this.f205643e;
        r101.setDefaultProgress((((r100 - r102) / (this.f205644f - r102)) * 100.0f) + 0.0f);
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        this.f205639a.setEnabled(r100);
        this.f205640b.setEnabled(r100);
        this.f205641c.setEnabled(r100);
        if (r100 == false) goto L5;
        float r101 = 1.0f;
    L6:
        setAlpha(r101);
        return;
    L5:
        r101 = 0.5f;
        goto L6
    }

    public final void setIsAlwaysLight(boolean r100) {
        if (r100 == false) goto L4;
        this.f205641c.setTextColor(ContextCompat.getColor(getContext(), R.color.TextReverse));
        this.f205640b.setTextColor(ContextCompat.getColor(getContext(), R.color.TextReverse));
    L5:
        this.f205639a.setIsAlwaysLight(r100);
        return;
    L4:
        this.f205641c.setTextColor(ContextCompat.getColor(getContext(), R.color.TextPrimary));
        this.f205640b.setTextColor(ContextCompat.getColor(getContext(), R.color.TextPrimary));
        goto L5
    }

    public final void setIsAlwaysNight(boolean r100) {
        if (r100 == false) goto L4;
        this.f205641c.setTextColor(ContextCompat.getColor(getContext(), R.color.ConstTextInverse));
        this.f205640b.setTextColor(ContextCompat.getColor(getContext(), R.color.ConstTextInverse));
    L5:
        this.f205639a.setIsAlwaysNight(r100);
        return;
    L4:
        this.f205641c.setTextColor(ContextCompat.getColor(getContext(), R.color.TextPrimary));
        this.f205640b.setTextColor(ContextCompat.getColor(getContext(), R.color.TextPrimary));
        goto L5
    }

    public final void setMaxValue(float r100) {
        this.f205644f = r100;
        this.f205639a.setMinValue(0.0f);
        this.f205639a.setMaxValue(100.0f);
    }

    public final void setMinValue(float r100) {
        this.f205643e = r100;
        this.f205639a.setMinValue(0.0f);
        this.f205639a.setMaxValue(100.0f);
    }

    public final void setOnSeekBarChangeListenerExt(SeekBarFloatCompat.b r100) {
        this.f205645g = r100;
    }

    public final void setProgress(float r100) {
        SeekBarFloatCompat r101 = this.f205639a;
        float r102 = this.f205643e;
        r101.setProgress((((r100 - r102) / (this.f205644f - r102)) * 100.0f) + 0.0f);
    }

    public DuxSlider(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f205642d = 0.05f;
        this.f205644f = 100.0f;
        this.f205646h = true;
        LayoutInflater.from(r100).inflate(R.layout.dux_slider, this);
        SeekBarFloatCompat r103 = (SeekBarFloatCompat) findViewById(R.id.seekBar);
        this.f205639a = r103;
        this.f205641c = (TextView) findViewById(R.id.tvTitle);
        TextView r104 = (TextView) findViewById(R.id.tvProgress);
        this.f205640b = r104;
        r103.setOnSeekBarChangeListenerExt(new a(this));
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L7;
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
        Resources r107 = Resources.getSystem();
        int r108 = MathKt.roundToInt(TypedValue.applyDimension(2, 58, WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics())));
        Resources r109 = Resources.getSystem();
        int r110 = (r108 + MathKt.roundToInt(TypedValue.applyDimension(2, 20, WindowDisplayMetricsOverride.apply(r109, r109.getDisplayMetrics())))) / 2;
        Resources r111 = Resources.getSystem();
        r106.bottomMargin = r110 + MathKt.roundToInt(TypedValue.applyDimension(1, 4, WindowDisplayMetricsOverride.apply(r111, r111.getDisplayMetrics())));
        r104.setLayoutParams(r106);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public /* synthetic */ DuxSlider(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 <= 0) goto L6;
        Resources r104 = Resources.getSystem();
        this.f205642d = TypedValue.applyDimension(1, 5, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics())) / r100;
        return;
    }
}
