package com.ss.android.lark.setting.export.v2;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/setting/export/v2/SettingPageType;", "", "<init>", "(Ljava/lang/String;I)V", "SYSTEM_SETTING", "COMMON_SETTING", "EFFICIENCY_SETTING", "UNKNOWN", "setting-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SettingPageType extends Enum<SettingPageType> {
    public static final SettingPageType COMMON_SETTING = null;
    public static final SettingPageType EFFICIENCY_SETTING = null;
    public static final SettingPageType SYSTEM_SETTING = null;
    public static final SettingPageType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SettingPageType[] f440502a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f440503b = null;

    public static EnumEntries<SettingPageType> getEntries() {
        return f440503b;
    }

    static {
        SettingPageType r100 = new SettingPageType("SYSTEM_SETTING", 0);
        SYSTEM_SETTING = r100;
        SettingPageType r101 = new SettingPageType("COMMON_SETTING", 1);
        COMMON_SETTING = r101;
        SettingPageType r102 = new SettingPageType("EFFICIENCY_SETTING", 2);
        EFFICIENCY_SETTING = r102;
        SettingPageType r103 = new SettingPageType("UNKNOWN", 3);
        UNKNOWN = r103;
        SettingPageType[] r104 = {r100, r101, r102, r103};
        f440502a = r104;
        f440503b = EnumEntriesKt.enumEntries(r104);
    }

    public static SettingPageType[] values() {
        return (SettingPageType[]) f440502a.clone();
    }

    public static SettingPageType valueOf(String r100) {
        return (SettingPageType) a.a(SettingPageType.class, r100);
    }

    public SettingPageType(String r100, int r101) {
        super(r100, r101);
    }
}
