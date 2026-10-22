package com.larus.dora.impl.device.settings.camera.timeoptions;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/dora/impl/device/settings/camera/timeoptions/TimeOptionsPageType;", "", "<init>", "(Ljava/lang/String;I)V", "INTERVAL", "MAX_DURATION", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TimeOptionsPageType extends Enum<TimeOptionsPageType> {
    public static final TimeOptionsPageType INTERVAL = null;
    public static final TimeOptionsPageType MAX_DURATION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TimeOptionsPageType[] f334296a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f334297b = null;

    public static EnumEntries<TimeOptionsPageType> getEntries() {
        return f334297b;
    }

    static {
        TimeOptionsPageType r100 = new TimeOptionsPageType("INTERVAL", 0);
        INTERVAL = r100;
        TimeOptionsPageType r101 = new TimeOptionsPageType("MAX_DURATION", 1);
        MAX_DURATION = r101;
        TimeOptionsPageType[] r102 = {r100, r101};
        f334296a = r102;
        f334297b = EnumEntriesKt.enumEntries(r102);
    }

    public static TimeOptionsPageType[] values() {
        return (TimeOptionsPageType[]) f334296a.clone();
    }

    public static TimeOptionsPageType valueOf(String r100) {
        return (TimeOptionsPageType) a.a(TimeOptionsPageType.class, r100);
    }

    public TimeOptionsPageType(String r100, int r101) {
        super(r100, r101);
    }
}
