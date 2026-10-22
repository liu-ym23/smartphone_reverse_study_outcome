package com.bytedance.dux.slider;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u001a\u001bB'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/dux/slider/SeekBarFloatCompat;", "Lcom/bytedance/dux/slider/SeekBarCompat;", "", "minValue", "", "setMinValue", "maxValue", "setMaxValue", "progress", "setDefaultProgress", "setProgress", "getMinValue", "getMaxValue", "getFloatProgress", "getDefaultValue", "Lcom/bytedance/dux/slider/SeekBarFloatCompat$b;", "l", "setOnSeekBarChangeListenerExt", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class SeekBarFloatCompat extends SeekBarCompat {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f205652h;

    public static final class a {
    }

    public interface b {
        void a(SeekBar r100, float r101, boolean r102);

        void onStartTrackingTouch(SeekBar r100);

        void onStopTrackingTouch(SeekBar r100);
    }

    public static final class c implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SeekBarFloatCompat f205653a;

        public c(SeekBarFloatCompat r100) {
            this.f205653a = r100;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar r100) {
            b r101 = this.f205653a.f205652h;
            if (r101 == null) goto L6;
            r101.onStartTrackingTouch(r100);
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar r100) {
            b r101 = this.f205653a.f205652h;
            if (r101 == null) goto L6;
            r101.onStopTrackingTouch(r100);
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
            String.valueOf(r101);
            SeekBarFloatCompat r103 = this.f205653a;
            b r104 = r103.f205652h;
            if (r104 == null) goto L6;
            r104.a(r100, r103.d(r101), r102);
            return;
        }
    }

    static {
    }

    public SeekBarFloatCompat(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SeekBarFloatCompat(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final float getDefaultValue() {
        return d(super.getDefaultProgress());
    }

    public final float getFloatProgress() {
        return d(super.getProgress());
    }

    public final float getMaxValue() {
        return d(getMaxRealValue());
    }

    public final float getMinValue() {
        return d(getMinRealValue());
    }

    public final float d(int r100) {
        return CastFloatProtector.parseFloat(String.format(Locale.CHINA, "%.2f", Arrays.copyOf(new Object[]{Float.valueOf(r100 / 100)}, 1)));
    }

    public final void setDefaultProgress(float r100) {
        super.setDefaultProgress((int) (r100 * 100));
    }

    public final void setMaxValue(float r100) {
        super.setMaxValue((int) (r100 * 100));
    }

    public final void setMinValue(float r100) {
        super.setMinValue((int) (r100 * 100));
    }

    public final void setOnSeekBarChangeListenerExt(b r100) {
        this.f205652h = r100;
        super.setOnSeekBarChangeListener(new c(this));
    }

    public final void setProgress(float r100) {
        super.setProgress((int) (r100 * 100));
    }

    public SeekBarFloatCompat(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ SeekBarFloatCompat(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
