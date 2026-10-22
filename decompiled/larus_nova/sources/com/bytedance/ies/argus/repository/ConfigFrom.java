package com.bytedance.ies.argus.repository;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/argus/repository/ConfigFrom;", "", "", "strValue", "Ljava/lang/String;", "getStrValue", "()Ljava/lang/String;", "EMPTY", "COMMON_SETTING", "GECKO", "RECOVERY_SETTING", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ConfigFrom extends Enum<ConfigFrom> {
    public static final ConfigFrom COMMON_SETTING = null;
    public static final ConfigFrom EMPTY = null;
    public static final ConfigFrom GECKO = null;
    public static final ConfigFrom RECOVERY_SETTING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConfigFrom[] f246103a = null;
    private final String strValue;

    public static ConfigFrom valueOf(String r100) {
        return (ConfigFrom) r27.a.a(ConfigFrom.class, r100);
    }

    public static ConfigFrom[] values() {
        return (ConfigFrom[]) f246103a.clone();
    }

    static {
        ConfigFrom r100 = new ConfigFrom("EMPTY", 0, "empty");
        EMPTY = r100;
        ConfigFrom r101 = new ConfigFrom("COMMON_SETTING", 1, "common_setting");
        COMMON_SETTING = r101;
        ConfigFrom r102 = new ConfigFrom("GECKO", 2, "gecko");
        GECKO = r102;
        ConfigFrom r103 = new ConfigFrom("RECOVERY_SETTING", 3, "recovery_setting");
        RECOVERY_SETTING = r103;
        f246103a = new ConfigFrom[]{r100, r101, r102, r103};
    }

    public final String getStrValue() {
        return this.strValue;
    }

    public ConfigFrom(String r100, int r101, String r102) {
        super(r100, r101);
        this.strValue = r102;
    }
}
