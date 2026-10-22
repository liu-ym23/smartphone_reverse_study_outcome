package com.obric.oui.slider;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0015B'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002¨\u0006\u0016"}, d2 = {"Lcom/obric/oui/slider/SeekBarFloatCompat;", "Lcom/obric/oui/slider/SeekBarCompat;", "", "minValue", "", "setMinValue", "maxValue", "setMaxValue", "progress", "setProgress", "getMinValue", "getMaxValue", "getFloatProgress", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class SeekBarFloatCompat extends SeekBarCompat {

    public static final class a {
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

    public final float getFloatProgress() {
        return v(super.getProgress());
    }

    public final float getMaxValue() {
        return v(getMaxRealValue());
    }

    public final float getMinValue() {
        return v(getMinRealValue());
    }

    private static float v(int r100) {
        return CastFloatProtector.parseFloat(String.format(Locale.CHINA, "%.2f", Arrays.copyOf(new Object[]{Float.valueOf(r100 / 100)}, 1)));
    }

    public final void setMaxValue(float r100) {
        super.setMaxValue((int) (r100 * 100));
    }

    public final void setMinValue(float r100) {
        super.setMinValue((int) (r100 * 100));
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
