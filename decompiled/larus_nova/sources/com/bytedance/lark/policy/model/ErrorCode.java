package com.bytedance.lark.policy.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/lark/policy/model/ErrorCode;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "UNKNOWN_ERROR", "POLICY_FETCH_ERROR", "POINT_CUT_FETCH_ERROR", "SERVER_INTERCEPT_ERROR", "NOT_FOUND_COMBINE_ALGORITHM_ERROR", "DOWNGRADE_FAILED_ERROR", "FAST_PASS_REQUEST_ERROR", "SERVER_POLICY_TENANT_ERROR", "POINT_CUT_FIND_ERROR", "NETWORK_REQUEST_ERROR", "SERVER_DECISION_ERROR", "FACTOR_FETCH_ERROR", "IP_FETCH_ERROR", "LOCAL_CALCULATE_ERROR", "policy-engine_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ErrorCode extends Enum<ErrorCode> {
    public static final ErrorCode DOWNGRADE_FAILED_ERROR = null;
    public static final ErrorCode FACTOR_FETCH_ERROR = null;
    public static final ErrorCode FAST_PASS_REQUEST_ERROR = null;
    public static final ErrorCode IP_FETCH_ERROR = null;
    public static final ErrorCode LOCAL_CALCULATE_ERROR = null;
    public static final ErrorCode NETWORK_REQUEST_ERROR = null;
    public static final ErrorCode NOT_FOUND_COMBINE_ALGORITHM_ERROR = null;
    public static final ErrorCode POINT_CUT_FETCH_ERROR = null;
    public static final ErrorCode POINT_CUT_FIND_ERROR = null;
    public static final ErrorCode POLICY_FETCH_ERROR = null;
    public static final ErrorCode SERVER_DECISION_ERROR = null;
    public static final ErrorCode SERVER_INTERCEPT_ERROR = null;
    public static final ErrorCode SERVER_POLICY_TENANT_ERROR = null;
    public static final ErrorCode UNKNOWN_ERROR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ErrorCode[] f253830a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f253831b = null;
    private final int code;

    public static EnumEntries<ErrorCode> getEntries() {
        return f253831b;
    }

    static {
        ErrorCode r100 = new ErrorCode("UNKNOWN_ERROR", 0, 200);
        UNKNOWN_ERROR = r100;
        ErrorCode r101 = new ErrorCode("POLICY_FETCH_ERROR", 1, 201);
        POLICY_FETCH_ERROR = r101;
        ErrorCode r102 = new ErrorCode("POINT_CUT_FETCH_ERROR", 2, 202);
        POINT_CUT_FETCH_ERROR = r102;
        ErrorCode r103 = new ErrorCode("SERVER_INTERCEPT_ERROR", 3, 203);
        SERVER_INTERCEPT_ERROR = r103;
        ErrorCode r104 = new ErrorCode("NOT_FOUND_COMBINE_ALGORITHM_ERROR", 4, 204);
        NOT_FOUND_COMBINE_ALGORITHM_ERROR = r104;
        ErrorCode r105 = new ErrorCode("DOWNGRADE_FAILED_ERROR", 5, 205);
        DOWNGRADE_FAILED_ERROR = r105;
        ErrorCode r110 = new ErrorCode("FAST_PASS_REQUEST_ERROR", 6, 206);
        FAST_PASS_REQUEST_ERROR = r110;
        ErrorCode r111 = new ErrorCode("SERVER_POLICY_TENANT_ERROR", 7, 207);
        SERVER_POLICY_TENANT_ERROR = r111;
        ErrorCode r112 = new ErrorCode("POINT_CUT_FIND_ERROR", 8, 208);
        POINT_CUT_FIND_ERROR = r112;
        ErrorCode r113 = new ErrorCode("NETWORK_REQUEST_ERROR", 9, 209);
        NETWORK_REQUEST_ERROR = r113;
        ErrorCode r114 = new ErrorCode("SERVER_DECISION_ERROR", 10, 210);
        SERVER_DECISION_ERROR = r114;
        ErrorCode r106 = new ErrorCode("FACTOR_FETCH_ERROR", 11, 211);
        FACTOR_FETCH_ERROR = r106;
        ErrorCode r107 = new ErrorCode("IP_FETCH_ERROR", 12, 212);
        IP_FETCH_ERROR = r107;
        ErrorCode r108 = new ErrorCode("LOCAL_CALCULATE_ERROR", 13, 213);
        LOCAL_CALCULATE_ERROR = r108;
        ErrorCode[] r109 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108};
        f253830a = r109;
        f253831b = EnumEntriesKt.enumEntries(r109);
    }

    public static ErrorCode[] values() {
        return (ErrorCode[]) f253830a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public static ErrorCode valueOf(String r100) {
        return (ErrorCode) r27.a.a(ErrorCode.class, r100);
    }

    public ErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
