package com.bytedance.locallife.dito.exception;

import com.lynx.tasm.LynxError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/locallife/dito/exception/DitoWarnThrowable;", "", "msg", "", LynxError.LYNX_THROWABLE, "(Ljava/lang/String;Ljava/lang/Throwable;)V", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class DitoWarnThrowable extends Throwable {
    public DitoWarnThrowable(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        super(r100, r101);
    }
}
