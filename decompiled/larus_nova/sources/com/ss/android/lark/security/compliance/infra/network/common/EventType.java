package com.ss.android.lark.security.compliance.infra.network.common;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/security/compliance/infra/network/common/EventType;", "", "<init>", "(Ljava/lang/String;I)V", "REPORTNETREQUESTSTART", "REPORTNETERROR", "security-compliance-infra_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EventType extends Enum<EventType> {
    public static final EventType REPORTNETERROR = null;
    public static final EventType REPORTNETREQUESTSTART = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EventType[] f440443a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f440444b = null;

    public static EnumEntries<EventType> getEntries() {
        return f440444b;
    }

    static {
        EventType r100 = new EventType("REPORTNETREQUESTSTART", 0);
        REPORTNETREQUESTSTART = r100;
        EventType r101 = new EventType("REPORTNETERROR", 1);
        REPORTNETERROR = r101;
        EventType[] r102 = {r100, r101};
        f440443a = r102;
        f440444b = EnumEntriesKt.enumEntries(r102);
    }

    public static EventType[] values() {
        return (EventType[]) f440443a.clone();
    }

    public static EventType valueOf(String r100) {
        return (EventType) a.a(EventType.class, r100);
    }

    public EventType(String r100, int r101) {
        super(r100, r101);
    }
}
