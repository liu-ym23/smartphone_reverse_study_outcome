package com.bytedance.lark.policy.calculate.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/lark/policy/calculate/exception/ExprCalculateException;", "Lcom/bytedance/lark/policy/calculate/exception/PolicyDecisionException;", "expr", "", "errorCode", "", "errorMsg", "msg", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getExpr", "()Ljava/lang/String;", "getErrorCode", "()I", "getErrorMsg", "policy-engine_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExprCalculateException extends PolicyDecisionException {
    private final int errorCode;
    private final String errorMsg;
    private final String expr;

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final String getExpr() {
        return this.expr;
    }

    public ExprCalculateException(String r100, int r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "expr");
        Intrinsics.checkNotNullParameter(r102, "errorMsg");
        Intrinsics.checkNotNullParameter(r103, "msg");
        super(r103, r101);
        this.expr = r100;
        this.errorCode = r101;
        this.errorMsg = r102;
    }

    public /* synthetic */ ExprCalculateException(String r100, int r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 8) == 0) goto L5;
        r103 = "expr calculate error,expr:" + r100 + ",code:" + r101 + ",exprMsg:" + r102;
    L5:
        this(r100, r101, r102, r103);
    }
}
