package com.bytedance.ee.bear.document.appsetting;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class FeatureGatingKey implements NonProguard {
    private List<String> featureGatingKeys;

    public FeatureGatingKey() {
    }

    public List<String> getFeatureGatingKeys() {
        return this.featureGatingKeys;
    }

    public void setFeatureGatingKeys(List<String> r100) {
        this.featureGatingKeys = r100;
    }
}
