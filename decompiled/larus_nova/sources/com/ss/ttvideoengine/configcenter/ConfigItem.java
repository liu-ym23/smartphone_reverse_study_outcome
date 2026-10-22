package com.ss.ttvideoengine.configcenter;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes34.dex */
public class ConfigItem {
    public static final ConfigItem EMPTY = null;
    public static final int MODULE_TYPE_ENGINE = 0;
    public static final int MODULE_TYPE_MDL = 2;
    public static final int MODULE_TYPE_PLAYER = 1;
    public static final int MODULE_TYPE_STRATEGY_CENTER = 3;
    public static final int VALUE_TYPE_FLOAT = 3;
    public static final int VALUE_TYPE_INT = 1;
    public static final int VALUE_TYPE_LONG = 2;
    public static final int VALUE_TYPE_STRING = 4;
    protected final int configKey;
    protected final Object itemValue;
    protected final int moduleType;
    protected final int priority;
    protected final int valueType;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ModuleType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ValueType {
    }

    static {
        EMPTY = new ConfigItem(-1, null, 0, 1, 0);
    }

    public int getPriority() {
        return this.priority;
    }

    public Object getValue() {
        return this.itemValue;
    }

    public ConfigItem(int r100, Object r101, int r102, int r103, int r104) {
        this.configKey = r100;
        this.itemValue = r101;
        this.valueType = r103;
        this.moduleType = r104;
        this.priority = r102;
    }
}
