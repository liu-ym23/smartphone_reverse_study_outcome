package com.bytedance.kmp.network.bridge;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/kmp/network/bridge/KmpRespondCode;", "", "", "code", "I", "getCode", "()I", "DTO_NOT_FOUND", "DTO_NOT_VALID", "REQUEST_BODY_SERIALIZE_ERROR", "GET_PROMISE_ERROR", "RESPONSE_DTO_CREATE_ERROR", "RESPONSE_TYPE_CONVERT_ERROR", "network_service_release"}, k = 1, mv = {1, 7, 0})
public final enum KmpRespondCode extends Enum<KmpRespondCode> {
    public static final KmpRespondCode DTO_NOT_FOUND = null;
    public static final KmpRespondCode DTO_NOT_VALID = null;
    public static final KmpRespondCode GET_PROMISE_ERROR = null;
    public static final KmpRespondCode REQUEST_BODY_SERIALIZE_ERROR = null;
    public static final KmpRespondCode RESPONSE_DTO_CREATE_ERROR = null;
    public static final KmpRespondCode RESPONSE_TYPE_CONVERT_ERROR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KmpRespondCode[] f252485a = null;
    private final int code;

    public static KmpRespondCode valueOf(String r100) {
        return (KmpRespondCode) r27.a.a(KmpRespondCode.class, r100);
    }

    public static KmpRespondCode[] values() {
        return (KmpRespondCode[]) f252485a.clone();
    }

    static {
        KmpRespondCode r100 = new KmpRespondCode("DTO_NOT_FOUND", 0, -1);
        DTO_NOT_FOUND = r100;
        KmpRespondCode r101 = new KmpRespondCode("DTO_NOT_VALID", 1, -2);
        DTO_NOT_VALID = r101;
        KmpRespondCode r102 = new KmpRespondCode("REQUEST_BODY_SERIALIZE_ERROR", 2, -3);
        REQUEST_BODY_SERIALIZE_ERROR = r102;
        KmpRespondCode r103 = new KmpRespondCode("GET_PROMISE_ERROR", 3, -4);
        GET_PROMISE_ERROR = r103;
        KmpRespondCode r104 = new KmpRespondCode("RESPONSE_DTO_CREATE_ERROR", 4, -5);
        RESPONSE_DTO_CREATE_ERROR = r104;
        KmpRespondCode r105 = new KmpRespondCode("RESPONSE_TYPE_CONVERT_ERROR", 5, -6);
        RESPONSE_TYPE_CONVERT_ERROR = r105;
        f252485a = new KmpRespondCode[]{r100, r101, r102, r103, r104, r105};
    }

    public final int getCode() {
        return this.code;
    }

    public KmpRespondCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
