package com.larus.setting.api.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/setting/api/data/SettingsItemAction;", "", "<init>", "(Ljava/lang/String;I)V", "TOGGLE", "TAP", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SettingsItemAction extends Enum<SettingsItemAction> {
    public static final SettingsItemAction TAP = null;
    public static final SettingsItemAction TOGGLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SettingsItemAction[] f367897a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f367898b = null;

    public static EnumEntries<SettingsItemAction> getEntries() {
        return f367898b;
    }

    static {
        SettingsItemAction r100 = new SettingsItemAction("TOGGLE", 0);
        TOGGLE = r100;
        SettingsItemAction r101 = new SettingsItemAction("TAP", 1);
        TAP = r101;
        SettingsItemAction[] r102 = {r100, r101};
        f367897a = r102;
        f367898b = EnumEntriesKt.enumEntries(r102);
    }

    public static SettingsItemAction[] values() {
        return (SettingsItemAction[]) f367897a.clone();
    }

    public static SettingsItemAction valueOf(String r100) {
        return (SettingsItemAction) a.a(SettingsItemAction.class, r100);
    }

    public SettingsItemAction(String r100, int r101) {
        super(r100, r101);
    }
}
