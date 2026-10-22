package com.obric.aivoice.core.utils;

import com.lynx.tasm.LynxError;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/aivoice/core/utils/TryRunResult;", "", LynxError.LYNX_THROWABLE, "", "(Ljava/lang/Throwable;)V", "getThrowable", "()Ljava/lang/Throwable;", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TryRunResult {
    private final Throwable throwable;

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public TryRunResult(Throwable r100) {
        this.throwable = r100;
    }
}
