package com.bytedance.lark.policy.calculate.exception;

import com.bytedance.lark.policy.model.ErrorCode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/lark/policy/calculate/exception/PolicyDecisionException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "msg", "", "code", "", "<init>", "(Ljava/lang/String;I)V", "getCode", "()I", "policy-engine_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class PolicyDecisionException extends Exception {
    private final int code;

    /* JADX WARN: Multi-variable type inference failed */
    public PolicyDecisionException() {
        String r100 = null;
        this(r100, 0, 3, 0 == true ? 1 : 0);
    }

    public final int getCode() {
        return this.code;
    }

    public PolicyDecisionException(String r100, int r101) {
        super(r100);
        this.code = r101;
    }

    public /* synthetic */ PolicyDecisionException(String r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = ErrorCode.UNKNOWN_ERROR.getCode();
    L8:
        this(r100, r101);
    }
}
