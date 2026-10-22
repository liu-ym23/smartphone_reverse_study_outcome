package com.ss.android.lark.passport.flow.mfa;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/passport/flow/mfa/FlowMfaTokenStatus;", "", "<init>", "(Ljava/lang/String;I)V", "VALID", "INVALID", "UNKNOWN", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowMfaTokenStatus extends Enum<FlowMfaTokenStatus> {
    public static final FlowMfaTokenStatus INVALID = null;
    public static final FlowMfaTokenStatus UNKNOWN = null;
    public static final FlowMfaTokenStatus VALID = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowMfaTokenStatus[] f437869a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f437870b = null;

    public static EnumEntries<FlowMfaTokenStatus> getEntries() {
        return f437870b;
    }

    static {
        FlowMfaTokenStatus r100 = new FlowMfaTokenStatus("VALID", 0);
        VALID = r100;
        FlowMfaTokenStatus r101 = new FlowMfaTokenStatus("INVALID", 1);
        INVALID = r101;
        FlowMfaTokenStatus r102 = new FlowMfaTokenStatus("UNKNOWN", 2);
        UNKNOWN = r102;
        FlowMfaTokenStatus[] r103 = {r100, r101, r102};
        f437869a = r103;
        f437870b = EnumEntriesKt.enumEntries(r103);
    }

    public static FlowMfaTokenStatus[] values() {
        return (FlowMfaTokenStatus[]) f437869a.clone();
    }

    public static FlowMfaTokenStatus valueOf(String r100) {
        return (FlowMfaTokenStatus) r27.a.a(FlowMfaTokenStatus.class, r100);
    }

    public FlowMfaTokenStatus(String r100, int r101) {
        super(r100, r101);
    }
}
