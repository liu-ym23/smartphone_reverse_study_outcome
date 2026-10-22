package com.ss.android.ugc.route_monitor.impl.route_out.control;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/route_monitor/impl/route_out/control/MatchResult;", "", "SUCCEED", "SWITCH_OFF", "CERT_ID_INVALID", "CERT_ID_MISS_MATCH", "CONDITION_MISS_MATCH", "route-monitor_release"}, k = 1, mv = {1, 4, 0})
public final enum MatchResult extends Enum<MatchResult> {
    public static final MatchResult CERT_ID_INVALID = null;
    public static final MatchResult CERT_ID_MISS_MATCH = null;
    public static final MatchResult CONDITION_MISS_MATCH = null;
    public static final MatchResult SUCCEED = null;
    public static final MatchResult SWITCH_OFF = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MatchResult[] f454598a = null;

    static {
        MatchResult r100 = new MatchResult("SUCCEED", 0);
        SUCCEED = r100;
        MatchResult r101 = new MatchResult("SWITCH_OFF", 1);
        SWITCH_OFF = r101;
        MatchResult r102 = new MatchResult("CERT_ID_INVALID", 2);
        CERT_ID_INVALID = r102;
        MatchResult r103 = new MatchResult("CERT_ID_MISS_MATCH", 3);
        CERT_ID_MISS_MATCH = r103;
        MatchResult r104 = new MatchResult("CONDITION_MISS_MATCH", 4);
        CONDITION_MISS_MATCH = r104;
        f454598a = new MatchResult[]{r100, r101, r102, r103, r104};
    }

    public static MatchResult valueOf(String r100) {
        return (MatchResult) r27.a.a(MatchResult.class, r100);
    }

    public static MatchResult[] values() {
        return (MatchResult[]) f454598a.clone();
    }

    public MatchResult(String r100, int r101) {
        super(r100, r101);
    }
}
