package com.facebook.keyframes;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import com.facebook.keyframes.model.KFImage;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class KeyframesDrawableBuilder {
    private ExperimentalFeatures mExperimentalFeatures;
    private KFImage mImage;
    private int mMaxFrameRate;

    public class ExperimentalFeatures {
        private Map<String, KeyframesDrawable.FeatureConfig> mParticleFeatureConfigs;
        final /* synthetic */ KeyframesDrawableBuilder this$0;

        public KeyframesDrawable build() {
            return this.this$0.build();
        }

        public Map<String, KeyframesDrawable.FeatureConfig> getParticleFeatureConfigs() {
            return this.mParticleFeatureConfigs;
        }

        public ExperimentalFeatures(KeyframesDrawableBuilder r100) {
            this.this$0 = r100;
        }

        public ExperimentalFeatures withParticleFeatureConfigs(Pair<String, Pair<Drawable, Matrix>>... r100) {
            this.mParticleFeatureConfigs = new HashMap();
            int r101 = r100.length;
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L5;
            Pair<String, Pair<Drawable, Matrix>> r103 = r100[r102];
            Map<String, KeyframesDrawable.FeatureConfig> r104 = this.mParticleFeatureConfigs;
            Object r105 = r103.first;
            Object r106 = r103.second;
            String r107 = (String) r105;
            r104.put(r107, new KeyframesDrawable.FeatureConfig((Drawable) ((Pair) r106).first, (Matrix) ((Pair) r106).second));
            r102 = r102 + 1;
            goto L3
        L5:
            return this;
        }
    }

    public KeyframesDrawable build() {
        if (this.mImage == null) goto L7;
        return new KeyframesDrawable(this);
    L7:
        throw new IllegalArgumentException("No KFImage provided!");
    }

    public KeyframesDrawableBuilder() {
        this.mMaxFrameRate = 60;
        this.mExperimentalFeatures = new ExperimentalFeatures(this);
    }

    public ExperimentalFeatures getExperimentalFeatures() {
        return this.mExperimentalFeatures;
    }

    public KFImage getImage() {
        return this.mImage;
    }

    public int getMaxFrameRate() {
        return this.mMaxFrameRate;
    }

    public ExperimentalFeatures withExperimentalFeatures() {
        return this.mExperimentalFeatures;
    }

    public KeyframesDrawableBuilder withImage(KFImage r100) {
        this.mImage = r100;
        return this;
    }

    public KeyframesDrawableBuilder withMaxFrameRate(int r100) {
        this.mMaxFrameRate = r100;
        return this;
    }
}
