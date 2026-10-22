package com.facebook.keyframes.model;

import com.facebook.keyframes.util.ArgCheckUtil;
import com.facebook.keyframes.util.ListHelper;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class KFGradientColor {
    public static final String KEY_VALUES_JSON_FIELD = "key_values";
    public static final String TIMING_CURVES_JSON_FIELD = "timing_curves";
    private final List<KFColorFrame> mKeyValues;
    private final float[][][] mTimingCurves;

    public static class Builder {
        public List<KFColorFrame> keyValues;
        public float[][][] timingCurves;

        public Builder() {
        }

        public KFGradientColor build() {
            return new KFGradientColor(this.keyValues, this.timingCurves);
        }
    }

    public List<KFColorFrame> getKeyValues() {
        return this.mKeyValues;
    }

    public float[][][] getTimingCurves() {
        return this.mTimingCurves;
    }

    public KFGradientColor(List<KFColorFrame> r100, float[][][] r101) {
        List<KFColorFrame> r102 = ListHelper.immutableOrEmpty(r100);
        this.mKeyValues = r102;
        this.mTimingCurves = (float[][][]) ArgCheckUtil.checkArg(r101, ArgCheckUtil.checkTimingCurveObjectValidity(r101, r102.size()), "timing_curves");
    }
}
