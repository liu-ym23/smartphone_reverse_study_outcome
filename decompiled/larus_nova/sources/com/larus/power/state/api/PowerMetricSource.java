package com.larus.power.state.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/power/state/api/PowerMetricSource;", "", "<init>", "(Ljava/lang/String;I)V", "UNITM_EFFECTIVE", "UNITM_BATTERY", "ANDROID_THERMAL", "BATTERY_MANAGER", "ANDROID_POWER_MANAGER", "APM_CPU", "ACTIVITY_MANAGER", "LINUX_SYSFS", "COMPOSITE", "UNKNOWN", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PowerMetricSource extends Enum<PowerMetricSource> {
    public static final PowerMetricSource ACTIVITY_MANAGER = null;
    public static final PowerMetricSource ANDROID_POWER_MANAGER = null;
    public static final PowerMetricSource ANDROID_THERMAL = null;
    public static final PowerMetricSource APM_CPU = null;
    public static final PowerMetricSource BATTERY_MANAGER = null;
    public static final PowerMetricSource COMPOSITE = null;
    public static final PowerMetricSource LINUX_SYSFS = null;
    public static final PowerMetricSource UNITM_BATTERY = null;
    public static final PowerMetricSource UNITM_EFFECTIVE = null;
    public static final PowerMetricSource UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PowerMetricSource[] f365949a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365950b = null;

    public static EnumEntries<PowerMetricSource> getEntries() {
        return f365950b;
    }

    static {
        PowerMetricSource r100 = new PowerMetricSource("UNITM_EFFECTIVE", 0);
        UNITM_EFFECTIVE = r100;
        PowerMetricSource r101 = new PowerMetricSource("UNITM_BATTERY", 1);
        UNITM_BATTERY = r101;
        PowerMetricSource r102 = new PowerMetricSource("ANDROID_THERMAL", 2);
        ANDROID_THERMAL = r102;
        PowerMetricSource r103 = new PowerMetricSource("BATTERY_MANAGER", 3);
        BATTERY_MANAGER = r103;
        PowerMetricSource r104 = new PowerMetricSource("ANDROID_POWER_MANAGER", 4);
        ANDROID_POWER_MANAGER = r104;
        PowerMetricSource r105 = new PowerMetricSource("APM_CPU", 5);
        APM_CPU = r105;
        PowerMetricSource r110 = new PowerMetricSource("ACTIVITY_MANAGER", 6);
        ACTIVITY_MANAGER = r110;
        PowerMetricSource r111 = new PowerMetricSource("LINUX_SYSFS", 7);
        LINUX_SYSFS = r111;
        PowerMetricSource r112 = new PowerMetricSource("COMPOSITE", 8);
        COMPOSITE = r112;
        PowerMetricSource r113 = new PowerMetricSource("UNKNOWN", 9);
        UNKNOWN = r113;
        PowerMetricSource[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        f365949a = r114;
        f365950b = EnumEntriesKt.enumEntries(r114);
    }

    public static PowerMetricSource[] values() {
        return (PowerMetricSource[]) f365949a.clone();
    }

    public static PowerMetricSource valueOf(String r100) {
        return (PowerMetricSource) a.a(PowerMetricSource.class, r100);
    }

    public PowerMetricSource(String r100, int r101) {
        super(r100, r101);
    }
}
