package com.facebook.keyframes.model;

import com.facebook.keyframes.model.keyframedmodels.KeyFramedGradient;
import com.facebook.keyframes.util.ArgCheckUtil;

/* JADX INFO: loaded from: classes23.dex */
public class KFGradient {
    public static final String COLOR_END_JSON_FIELD = "color_end";
    public static final String COLOR_START_JSON_FIELD = "color_start";
    private final KeyFramedGradient mEndGradient;
    private final KeyFramedGradient mStartGradient;

    public static class Builder {
        public KFGradientColor colorEnd;
        public KFGradientColor colorStart;

        public Builder() {
        }

        public KFGradient build() {
            return new KFGradient(this.colorStart, this.colorEnd);
        }
    }

    public KeyFramedGradient getEndGradient() {
        return this.mEndGradient;
    }

    public KeyFramedGradient getStartGradient() {
        return this.mStartGradient;
    }

    public KFGradient(KFGradientColor r100, KFGradientColor r101) {
        boolean r102 = true;
        if (r100 == null) goto L5;
        boolean r103 = true;
    L6:
        this.mStartGradient = KeyFramedGradient.fromGradient((KFGradientColor) ArgCheckUtil.checkArg(r100, r103, COLOR_START_JSON_FIELD), KeyFramedGradient.Position.START);
        if (r101 != null) goto L10;
        r102 = false;
    L10:
        this.mEndGradient = KeyFramedGradient.fromGradient((KFGradientColor) ArgCheckUtil.checkArg(r101, r102, COLOR_END_JSON_FIELD), KeyFramedGradient.Position.END);
        return;
    L5:
        r103 = false;
        goto L6
    }
}
