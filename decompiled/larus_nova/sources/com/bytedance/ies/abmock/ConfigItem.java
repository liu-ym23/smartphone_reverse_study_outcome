package com.bytedance.ies.abmock;

/* JADX INFO: loaded from: classes6.dex */
public class ConfigItem {
    public Object defaultValue;
    public boolean isAB;
    public SaveConfigType$ConfigType type;

    public ConfigItem(SaveConfigType$ConfigType r100, Object r101, boolean r102) {
        this.type = r100;
        this.defaultValue = r101;
        this.isAB = r102;
    }
}
