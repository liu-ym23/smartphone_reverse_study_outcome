package com.larus.account.saas.jsb.core;

import com.larus.account.saas.runtime.internal.delegate.SaasTracking;
import kotlin.Metadata;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class FlowAccountVerifyCore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f286367a = 0;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/account/saas/jsb/core/FlowAccountVerifyCore$Error;", "", "", "code", "I", "getCode", "()I", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "DECISION_NOT_FOUND", "DECISION_PARSE_FAILED", "INVALID_STATUS", "account-saas-jsb-core_release"}, k = 1, mv = {1, 7, 1})
    public static final enum Error extends Enum<Error> {
        public static final Error DECISION_NOT_FOUND = null;
        public static final Error DECISION_PARSE_FAILED = null;
        public static final Error INVALID_STATUS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Error[] f286368a = null;
        private final int code;
        private final String message;

        public static Error valueOf(String r100) {
            return (Error) r27.a.a(Error.class, r100);
        }

        public static Error[] values() {
            return (Error[]) f286368a.clone();
        }

        static {
            Error r100 = new Error("DECISION_NOT_FOUND", 0, 1, "decision is null, or not in twice verify flow");
            DECISION_NOT_FOUND = r100;
            Error r101 = new Error("DECISION_PARSE_FAILED", 1, 2, "catch exception while parsing decisions");
            DECISION_PARSE_FAILED = r101;
            Error r102 = new Error("INVALID_STATUS", 2, 3, "status error");
            INVALID_STATUS = r102;
            f286368a = new Error[]{r100, r101, r102};
        }

        public final int getCode() {
            return this.code;
        }

        public final String getMessage() {
            return this.message;
        }

        public Error(String r100, int r101, int r102, String r103) {
            super(r100, r101);
            this.code = r102;
            this.message = r103;
        }
    }

    static {
    }

    public static void a(int r100, String r101, int r102) {
        SaasTracking r103 = SaasTracking.f286464a;
        JSONObject r104 = new JSONObject();
        r104.put("flow_scene", "mfa_explicit_jsb_get_decision");
        r104.put("afid", String.valueOf(r100));
        r104.put("verify_scene", r101);
        r104.put(com.bytedance.android.ec.core.event.a.KEY_HIT_CACHE, r102);
        Unit r105 = Unit.INSTANCE;
        r103.reportEvent("doubao_account_mfa_explicit_flow", r104);
    }
}
