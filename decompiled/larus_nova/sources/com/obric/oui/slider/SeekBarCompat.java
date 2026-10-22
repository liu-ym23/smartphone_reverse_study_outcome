package com.obric.oui.slider;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0012\u0010\u000f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/slider/SeekBarCompat;", "Lcom/obric/oui/slider/TickMarkSeekBar;", "", "getProgress", "getMinRealValue", "getMaxRealValue", "minValue", "", "setMinValue", "maxValue", "setMaxValue", "progress", "setProgress", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "l", "setOnSeekBarChangeListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class SeekBarCompat extends TickMarkSeekBar {

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f403000k0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public SeekBar.OnSeekBarChangeListener f403001p0;

    public static final class a implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SeekBarCompat f403002a;

        public a(SeekBarCompat r100) {
            this.f403002a = r100;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar r100) {
            SeekBar.OnSeekBarChangeListener r101 = this.f403002a.f403001p0;
            if (r101 == null) goto L7;
            r101.onStartTrackingTouch(r100);
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar r100) {
            SeekBar.OnSeekBarChangeListener r101 = this.f403002a.f403001p0;
            if (r101 == null) goto L7;
            r101.onStopTrackingTouch(r100);
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
            String.valueOf(r101);
            SeekBarCompat r103 = this.f403002a;
            SeekBar.OnSeekBarChangeListener r104 = r103.f403001p0;
            if (r104 == null) goto L7;
            r104.onProgressChanged(r100, r101 + r103.f403000k0, r102);
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
        return 0 + this.f403000k0;
    }

    public final int getMaxRealValue() {
        return getMax() + this.f403000k0;
    }

    @Override // android.widget.ProgressBar
    public int getProgress() {
        return super.getProgress() + this.f403000k0;
    }

    public final void setMaxValue(int r100) {
        setMax(r100 - this.f403000k0);
    }

    public final void setMinValue(int r100) {
        this.f403000k0 = r100;
        setMax(getMax() - this.f403000k0);
    }

    @Override // android.widget.SeekBar
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener r100) {
        this.f403001p0 = r100;
        super.setOnSeekBarChangeListener(new a(this));
    }

    @Override // com.obric.oui.slider.TickMarkSeekBar, android.widget.ProgressBar
    public void setProgress(int r100) {
        super.setProgress(r100 - this.f403000k0);
    }

    @Override // com.obric.oui.slider.TickMarkSeekBar, android.widget.ProgressBar
    public final void setProgress(int r100, boolean r101) {
        super.setProgress(r100 - this.f403000k0, r101);
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
