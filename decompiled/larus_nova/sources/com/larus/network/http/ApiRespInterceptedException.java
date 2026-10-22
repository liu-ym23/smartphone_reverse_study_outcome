package com.larus.network.http;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/network/http/ApiRespInterceptedException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "e", "", "<init>", "(Ljava/lang/Throwable;)V", "network_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ApiRespInterceptedException extends RuntimeException {
    /* JADX WARN: Multi-variable type inference failed */
    public ApiRespInterceptedException() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public ApiRespInterceptedException(Throwable r100) {
        super(r100);
    }

    public /* synthetic */ ApiRespInterceptedException(Throwable r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
