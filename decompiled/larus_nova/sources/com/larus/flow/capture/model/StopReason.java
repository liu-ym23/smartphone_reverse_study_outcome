package com.larus.flow.capture.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/flow/capture/model/StopReason;", "", "<init>", "(Ljava/lang/String;I)V", "USER_STOP", "PERMISSION_REVOKED", "SOURCE_INTERRUPTED", "RTC_FAILED", "RUNTIME_ERROR", "OApp.flowSDK.baseSDK.common.flow-capture"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum StopReason extends Enum<StopReason> {
    public static final StopReason PERMISSION_REVOKED = null;
    public static final StopReason RTC_FAILED = null;
    public static final StopReason RUNTIME_ERROR = null;
    public static final StopReason SOURCE_INTERRUPTED = null;
    public static final StopReason USER_STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StopReason[] f343428a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f343429b = null;

    public static EnumEntries<StopReason> getEntries() {
        return f343429b;
    }

    static {
        StopReason r100 = new StopReason("USER_STOP", 0);
        USER_STOP = r100;
        StopReason r101 = new StopReason("PERMISSION_REVOKED", 1);
        PERMISSION_REVOKED = r101;
        StopReason r102 = new StopReason("SOURCE_INTERRUPTED", 2);
        SOURCE_INTERRUPTED = r102;
        StopReason r103 = new StopReason("RTC_FAILED", 3);
        RTC_FAILED = r103;
        StopReason r104 = new StopReason("RUNTIME_ERROR", 4);
        RUNTIME_ERROR = r104;
        StopReason[] r105 = {r100, r101, r102, r103, r104};
        f343428a = r105;
        f343429b = EnumEntriesKt.enumEntries(r105);
    }

    public static StopReason[] values() {
        return (StopReason[]) f343428a.clone();
    }

    public static StopReason valueOf(String r100) {
        return (StopReason) a.a(StopReason.class, r100);
    }

    public StopReason(String r100, int r101) {
        super(r100, r101);
    }
}
