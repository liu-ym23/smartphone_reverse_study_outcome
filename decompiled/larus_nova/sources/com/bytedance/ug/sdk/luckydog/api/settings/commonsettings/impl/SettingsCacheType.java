package com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl;

import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ug/sdk/luckydog/api/settings/commonsettings/impl/SettingsCacheType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "JSON_OBJECT", "JSON_ARRAY", "BOOLEAN", "INT", "STRING", "DOUBLE", "LONG", "UNKNOWN", "NULL", "luckydog-api_release"}, k = 1, mv = {1, 4, 0})
public final enum SettingsCacheType extends Enum<SettingsCacheType> {
    public static final SettingsCacheType BOOLEAN = null;
    public static final SettingsCacheType DOUBLE = null;
    public static final SettingsCacheType INT = null;
    public static final SettingsCacheType JSON_ARRAY = null;
    public static final SettingsCacheType JSON_OBJECT = null;
    public static final SettingsCacheType LONG = null;
    public static final SettingsCacheType NULL = null;
    public static final SettingsCacheType STRING = null;
    public static final SettingsCacheType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SettingsCacheType[] f271626a = null;
    private final String value;

    public static SettingsCacheType valueOf(String r100) {
        return (SettingsCacheType) r27.a.a(SettingsCacheType.class, r100);
    }

    public static SettingsCacheType[] values() {
        return (SettingsCacheType[]) f271626a.clone();
    }

    static {
        SettingsCacheType r100 = new SettingsCacheType("JSON_OBJECT", 0, "object");
        JSON_OBJECT = r100;
        SettingsCacheType r101 = new SettingsCacheType("JSON_ARRAY", 1, "array");
        JSON_ARRAY = r101;
        SettingsCacheType r102 = new SettingsCacheType("BOOLEAN", 2, "bool");
        BOOLEAN = r102;
        SettingsCacheType r103 = new SettingsCacheType("INT", 3, "int");
        INT = r103;
        SettingsCacheType r104 = new SettingsCacheType("STRING", 4, "str");
        STRING = r104;
        SettingsCacheType r105 = new SettingsCacheType("DOUBLE", 5, ItemStyle.ITEM_STYLE_DOUBLE);
        DOUBLE = r105;
        SettingsCacheType r106 = new SettingsCacheType("LONG", 6, "long");
        LONG = r106;
        SettingsCacheType r107 = new SettingsCacheType("UNKNOWN", 7, "unknown");
        UNKNOWN = r107;
        SettingsCacheType r108 = new SettingsCacheType("NULL", 8, "null");
        NULL = r108;
        f271626a = new SettingsCacheType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
    }

    public final String getValue() {
        return this.value;
    }

    public SettingsCacheType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
