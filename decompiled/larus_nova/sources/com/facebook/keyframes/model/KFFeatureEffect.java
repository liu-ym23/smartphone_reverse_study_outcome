package com.facebook.keyframes.model;

import com.facebook.keyframes.util.ArgCheckUtil;

/* JADX INFO: loaded from: classes23.dex */
public class KFFeatureEffect {
    public static final String GRADIENT_JSON_FIELD = "gradient";
    private final KFGradient mGradient;

    /* JADX INFO: renamed from: com.facebook.keyframes.model.KFFeatureEffect$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        public KFGradient gradient;

        public Builder() {
        }

        public KFFeatureEffect build() {
            return new KFFeatureEffect(this.gradient, null);
        }
    }

    public KFGradient getGradient() {
        return this.mGradient;
    }

    private KFFeatureEffect(KFGradient r100) {
        if (r100 == null) goto L5;
        boolean r101 = true;
    L6:
        this.mGradient = (KFGradient) ArgCheckUtil.checkArg(r100, r101, GRADIENT_JSON_FIELD);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public /* synthetic */ KFFeatureEffect(KFGradient r100, AnonymousClass1 r101) {
        this(r100);
    }
}
