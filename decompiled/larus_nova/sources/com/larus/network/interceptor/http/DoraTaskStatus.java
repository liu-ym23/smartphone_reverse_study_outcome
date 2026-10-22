package com.larus.network.interceptor.http;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/network/interceptor/http/DoraTaskStatus;", "", "<init>", "(Ljava/lang/String;I)V", "WAKE_OFF_OR_DISCONNECTED", "WAKE_UP", "ttnet_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraTaskStatus extends Enum<DoraTaskStatus> {
    public static final DoraTaskStatus WAKE_OFF_OR_DISCONNECTED = null;
    public static final DoraTaskStatus WAKE_UP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraTaskStatus[] f360207a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f360208b = null;

    public static EnumEntries<DoraTaskStatus> getEntries() {
        return f360208b;
    }

    static {
        DoraTaskStatus r100 = new DoraTaskStatus("WAKE_OFF_OR_DISCONNECTED", 0);
        WAKE_OFF_OR_DISCONNECTED = r100;
        DoraTaskStatus r101 = new DoraTaskStatus("WAKE_UP", 1);
        WAKE_UP = r101;
        DoraTaskStatus[] r102 = {r100, r101};
        f360207a = r102;
        f360208b = EnumEntriesKt.enumEntries(r102);
    }

    public static DoraTaskStatus[] values() {
        return (DoraTaskStatus[]) f360207a.clone();
    }

    public static DoraTaskStatus valueOf(String r100) {
        return (DoraTaskStatus) a.a(DoraTaskStatus.class, r100);
    }

    public DoraTaskStatus(String r100, int r101) {
        super(r100, r101);
    }
}
