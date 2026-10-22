package com.larus.power.state.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/power/state/api/PowerMetricAvailability;", "", "<init>", "(Ljava/lang/String;I)V", "AVAILABLE", "STALE", "TEMPORARILY_UNAVAILABLE", "UNSUPPORTED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PowerMetricAvailability extends Enum<PowerMetricAvailability> {
    public static final PowerMetricAvailability AVAILABLE = null;
    public static final PowerMetricAvailability STALE = null;
    public static final PowerMetricAvailability TEMPORARILY_UNAVAILABLE = null;
    public static final PowerMetricAvailability UNSUPPORTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PowerMetricAvailability[] f365947a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365948b = null;

    public static EnumEntries<PowerMetricAvailability> getEntries() {
        return f365948b;
    }

    static {
        PowerMetricAvailability r100 = new PowerMetricAvailability("AVAILABLE", 0);
        AVAILABLE = r100;
        PowerMetricAvailability r101 = new PowerMetricAvailability("STALE", 1);
        STALE = r101;
        PowerMetricAvailability r102 = new PowerMetricAvailability("TEMPORARILY_UNAVAILABLE", 2);
        TEMPORARILY_UNAVAILABLE = r102;
        PowerMetricAvailability r103 = new PowerMetricAvailability("UNSUPPORTED", 3);
        UNSUPPORTED = r103;
        PowerMetricAvailability[] r104 = {r100, r101, r102, r103};
        f365947a = r104;
        f365948b = EnumEntriesKt.enumEntries(r104);
    }

    public static PowerMetricAvailability[] values() {
        return (PowerMetricAvailability[]) f365947a.clone();
    }

    public static PowerMetricAvailability valueOf(String r100) {
        return (PowerMetricAvailability) a.a(PowerMetricAvailability.class, r100);
    }

    public PowerMetricAvailability(String r100, int r101) {
        super(r100, r101);
    }
}
