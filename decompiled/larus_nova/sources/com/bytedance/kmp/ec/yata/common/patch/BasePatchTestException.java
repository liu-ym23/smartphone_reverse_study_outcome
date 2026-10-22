package com.bytedance.kmp.ec.yata.common.patch;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/kmp/ec/yata/common/patch/BasePatchTestException;", "Lcom/bytedance/kmp/ec/yata/common/patch/BasePatchException;", "detail", "", "message", "(Ljava/lang/String;Ljava/lang/String;)V", "yata-common-kmp_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
public final class BasePatchTestException extends BasePatchException {
    public BasePatchTestException(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "detail");
        Intrinsics.checkNotNullParameter(r101, "message");
        super(r100, r101);
    }
}
