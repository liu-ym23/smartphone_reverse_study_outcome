package com.obric.assistant.performance;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/performance/SettingsChangeMonitorTiming;", "", "<init>", "(Ljava/lang/String;I)V", "NO_TIMING", "TIMING_LIGHT_DOZE", "TIMING_DEEP_DOZE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SettingsChangeMonitorTiming extends Enum<SettingsChangeMonitorTiming> {
    public static final SettingsChangeMonitorTiming NO_TIMING = null;
    public static final SettingsChangeMonitorTiming TIMING_DEEP_DOZE = null;
    public static final SettingsChangeMonitorTiming TIMING_LIGHT_DOZE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SettingsChangeMonitorTiming[] f391030a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f391031b = null;

    public static EnumEntries<SettingsChangeMonitorTiming> getEntries() {
        return f391031b;
    }

    static {
        SettingsChangeMonitorTiming r100 = new SettingsChangeMonitorTiming("NO_TIMING", 0);
        NO_TIMING = r100;
        SettingsChangeMonitorTiming r101 = new SettingsChangeMonitorTiming("TIMING_LIGHT_DOZE", 1);
        TIMING_LIGHT_DOZE = r101;
        SettingsChangeMonitorTiming r102 = new SettingsChangeMonitorTiming("TIMING_DEEP_DOZE", 2);
        TIMING_DEEP_DOZE = r102;
        SettingsChangeMonitorTiming[] r103 = {r100, r101, r102};
        f391030a = r103;
        f391031b = EnumEntriesKt.enumEntries(r103);
    }

    public static SettingsChangeMonitorTiming[] values() {
        return (SettingsChangeMonitorTiming[]) f391030a.clone();
    }

    public static SettingsChangeMonitorTiming valueOf(String r100) {
        return (SettingsChangeMonitorTiming) r27.a.a(SettingsChangeMonitorTiming.class, r100);
    }

    public SettingsChangeMonitorTiming(String r100, int r101) {
        super(r100, r101);
    }
}
