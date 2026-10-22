package com.bytedance.lark.policy.calculate.exception;

import faceverify.q;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/lark/policy/calculate/exception/NotFoundCombineAlgorithmException;", "Lcom/bytedance/lark/policy/calculate/exception/PolicyDecisionException;", q.KEY_ALGORITHM_CONFIG, "", "<init>", "(Ljava/lang/String;)V", "policy-engine_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotFoundCombineAlgorithmException extends PolicyDecisionException {
    public NotFoundCombineAlgorithmException(String r100) {
        Intrinsics.checkNotNullParameter(r100, q.KEY_ALGORITHM_CONFIG);
        super("can not found combine algorithm " + r100, 0, 2, null);
    }
}
