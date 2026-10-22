package com.ss.android.ugc.effectmanager.effect.bridge;

import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class EffectFetcherArguments {
    private List<String> mDownloadUrl;
    private Effect mEffect;
    private String mEffectDir;

    public List<String> getDownloadUrl() {
        return this.mDownloadUrl;
    }

    public Effect getEffect() {
        return this.mEffect;
    }

    public String getEffectDir() {
        return this.mEffectDir;
    }

    public EffectFetcherArguments(Effect r100, List<String> r101, String r102) {
        this.mEffect = r100;
        this.mDownloadUrl = r101;
        this.mEffectDir = r102;
    }
}
