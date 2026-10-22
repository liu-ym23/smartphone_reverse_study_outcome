package com.larus.avlink.common;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/avlink/common/SessionType;", "", "<init>", "(Ljava/lang/String;I)V", "SAMI", "RTC", "QUIC", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SessionType extends Enum<SessionType> {
    public static final SessionType QUIC = null;
    public static final SessionType RTC = null;
    public static final SessionType SAMI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SessionType[] f291748a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291749b = null;

    public static EnumEntries<SessionType> getEntries() {
        return f291749b;
    }

    static {
        SessionType r100 = new SessionType("SAMI", 0);
        SAMI = r100;
        SessionType r101 = new SessionType("RTC", 1);
        RTC = r101;
        SessionType r102 = new SessionType("QUIC", 2);
        QUIC = r102;
        SessionType[] r103 = {r100, r101, r102};
        f291748a = r103;
        f291749b = EnumEntriesKt.enumEntries(r103);
    }

    public static SessionType[] values() {
        return (SessionType[]) f291748a.clone();
    }

    public static SessionType valueOf(String r100) {
        return (SessionType) a.a(SessionType.class, r100);
    }

    public SessionType(String r100, int r101) {
        super(r100, r101);
    }
}
