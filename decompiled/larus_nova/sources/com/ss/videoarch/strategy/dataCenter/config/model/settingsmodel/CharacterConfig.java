package com.ss.videoarch.strategy.dataCenter.config.model.settingsmodel;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class CharacterConfig {
    public String mFeaturesCollectRules;
    public List<String> mFeaturesList;
    public List<String> mRTFeaturesList;

    public CharacterConfig() {
        this.mFeaturesList = new ArrayList();
        this.mRTFeaturesList = new ArrayList();
        this.mFeaturesCollectRules = "";
    }
}
