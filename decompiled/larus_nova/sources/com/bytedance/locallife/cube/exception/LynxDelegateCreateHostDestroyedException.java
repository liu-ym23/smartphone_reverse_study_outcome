package com.bytedance.locallife.cube.exception;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/locallife/cube/exception/LynxDelegateCreateHostDestroyedException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "()V", "message", "", "getMessage", "()Ljava/lang/String;", "cube-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class LynxDelegateCreateHostDestroyedException extends Exception {
    @Override // java.lang.Throwable
    public String getMessage() {
        return "activity is destroyed";
    }

    public LynxDelegateCreateHostDestroyedException() {
    }
}
