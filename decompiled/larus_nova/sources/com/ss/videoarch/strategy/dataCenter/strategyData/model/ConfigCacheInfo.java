package com.ss.videoarch.strategy.dataCenter.strategyData.model;

/* JADX INFO: loaded from: classes38.dex */
public class ConfigCacheInfo {
    public String mCreate;
    public String mExpandValue;
    public String mSettingsName;
    public String mSettingsValue;
    public String mUpdate;

    public String toString() {
        return "ConfigCacheInfo{mSettingsName='" + this.mSettingsName + "', mSettingsValue='" + this.mSettingsValue + "', mExpand='" + this.mExpandValue + "', mUpdate='" + this.mUpdate + "', mCreate='" + this.mCreate + "'}";
    }

    public ConfigCacheInfo() {
        this.mSettingsName = "";
        this.mSettingsValue = "";
        this.mExpandValue = "";
        this.mUpdate = "";
        this.mCreate = "";
    }
}
