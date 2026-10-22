package com.obric.assistant.performance;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/performance/SettingsChangeMonitorMode;", "", "<init>", "(Ljava/lang/String;I)V", "DO_NOTHING", "TIGGER_SETTINGS_PUSH", "TIGGER_SETTINGS_PULL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SettingsChangeMonitorMode extends Enum<SettingsChangeMonitorMode> {
    public static final SettingsChangeMonitorMode DO_NOTHING = null;
    public static final SettingsChangeMonitorMode TIGGER_SETTINGS_PULL = null;
    public static final SettingsChangeMonitorMode TIGGER_SETTINGS_PUSH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SettingsChangeMonitorMode[] f391028a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f391029b = null;

    public static EnumEntries<SettingsChangeMonitorMode> getEntries() {
        return f391029b;
    }

    static {
        SettingsChangeMonitorMode r100 = new SettingsChangeMonitorMode("DO_NOTHING", 0);
        DO_NOTHING = r100;
        SettingsChangeMonitorMode r101 = new SettingsChangeMonitorMode("TIGGER_SETTINGS_PUSH", 1);
        TIGGER_SETTINGS_PUSH = r101;
        SettingsChangeMonitorMode r102 = new SettingsChangeMonitorMode("TIGGER_SETTINGS_PULL", 2);
        TIGGER_SETTINGS_PULL = r102;
        SettingsChangeMonitorMode[] r103 = {r100, r101, r102};
        f391028a = r103;
        f391029b = EnumEntriesKt.enumEntries(r103);
    }

    public static SettingsChangeMonitorMode[] values() {
        return (SettingsChangeMonitorMode[]) f391028a.clone();
    }

    public static SettingsChangeMonitorMode valueOf(String r100) {
        return (SettingsChangeMonitorMode) r27.a.a(SettingsChangeMonitorMode.class, r100);
    }

    public SettingsChangeMonitorMode(String r100, int r101) {
        super(r100, r101);
    }
}
