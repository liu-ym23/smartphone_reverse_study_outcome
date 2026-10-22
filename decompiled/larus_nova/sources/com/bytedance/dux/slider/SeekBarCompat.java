package com.bytedance.dux.slider;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/dux/slider/SeekBarCompat;", "Lcom/bytedance/dux/slider/TickMarkSeekBar;", "", "getDefaultProgress", "getProgress", "getMinRealValue", "getMaxRealValue", "minValue", "", "setMinValue", "maxValue", "setMaxValue", "progress", "setProgress", "setDefaultProgress", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "l", "setOnSeekBarChangeListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dux_release"}, k = 1, mv = {1, 7, 1})
public class SeekBarCompat extends TickMarkSeekBar {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f205649f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SeekBar.OnSeekBarChangeListener f205650g;

    public static final class a implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SeekBarCompat f205651a;

        public a(SeekBarCompat r100) {
            this.f205651a = r100;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar r100) {
            SeekBar.OnSeekBarChangeListener r101 = this.f205651a.f205650g;
            if (r101 == null) goto L6;
            r101.onStartTrackingTouch(r100);
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar r100) {
            SeekBar.OnSeekBarChangeListener r101 = this.f205651a.f205650g;
            if (r101 == null) goto L6;
            r101.onStopTrackingTouch(r100);
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
            String.valueOf(r101);
            SeekBarCompat r103 = this.f205651a;
            SeekBar.OnSeekBarChangeListener r104 = r103.f205650g;
            if (r104 == null) goto L6;
            r104.onProgressChanged(r100, r101 + r103.f205649f, r102);
            return;
        }
    }

    public SeekBarCompat(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SeekBarCompat(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final int getMinRealValue() {
        return 0 + this.f205649f;
    }

    @Override // com.bytedance.dux.slider.TickMarkSeekBar
    public int getDefaultProgress() {
        return super.getDefaultProgress() + this.f205649f;
    }

    public final int getMaxRealValue() {
        return getMax() + this.f205649f;
    }

    @Override // android.widget.ProgressBar
    public int getProgress() {
        return super.getProgress() + this.f205649f;
    }

    @Override // com.bytedance.dux.slider.TickMarkSeekBar
    public void setDefaultProgress(int r100) {
        super.setDefaultProgress(r100 - this.f205649f);
    }

    public final void setMaxValue(int r100) {
        setMax(r100 - this.f205649f);
    }

    public final void setMinValue(int r100) {
        this.f205649f = r100;
        setMax(getMax() - this.f205649f);
    }

    @Override // android.widget.SeekBar
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener r100) {
        this.f205650g = r100;
        super.setOnSeekBarChangeListener(new a(this));
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int r100) {
        super.setProgress(r100 - this.f205649f);
    }

    public SeekBarCompat(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ SeekBarCompat(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
