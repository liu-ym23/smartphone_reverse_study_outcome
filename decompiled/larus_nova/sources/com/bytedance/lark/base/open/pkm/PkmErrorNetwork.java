package com.bytedance.lark.base.open.pkm;

import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/lark/base/open/pkm/PkmErrorNetwork;", "Lcom/bytedance/lark/base/open/pkm/PkmError;", RNParamRegisterEventHandler.SRC_INNER, "", "(Ljava/lang/String;)V", "getInner", "()Ljava/lang/String;", "open_pkm_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PkmErrorNetwork extends PkmError {
    private final String inner;

    public final String getInner() {
        return this.inner;
    }

    public PkmErrorNetwork(String r100) {
        Intrinsics.checkNotNullParameter(r100, RNParamRegisterEventHandler.SRC_INNER);
        super(null);
        this.inner = r100;
    }
}
