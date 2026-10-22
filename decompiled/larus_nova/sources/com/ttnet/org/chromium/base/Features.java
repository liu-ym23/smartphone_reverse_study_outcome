package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;

/* JADX INFO: loaded from: classes41.dex */
@JNINamespace("base::android")
@MainDex
public abstract class Features {
    private final String mName;

    public interface Natives {
        boolean getFieldTrialParamByFeatureAsBoolean(long r100, String r101, boolean r102);

        boolean isEnabled(long r100);
    }

    public abstract long getFeaturePointer();

    public boolean isEnabled() {
        Boolean r100 = FeatureList.getTestValueForFeature(getName());
        if (r100 == null) goto L7;
        return r100.booleanValue();
    L7:
        return FeaturesJni.get().isEnabled(getFeaturePointer());
    }

    public String getName() {
        return this.mName;
    }

    public Features(String r100) {
        this.mName = r100;
    }

    public boolean getFieldTrialParamByFeatureAsBoolean(String r100, boolean r101) {
        return FeaturesJni.get().getFieldTrialParamByFeatureAsBoolean(getFeaturePointer(), r100, r101);
    }
}
