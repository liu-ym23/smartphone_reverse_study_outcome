package com.larus.network.error;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/larus/network/error/SSEStreamException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "msg", "", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "network_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SSEStreamException extends IllegalStateException {
    public SSEStreamException(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        Intrinsics.checkNotNullParameter(r101, "cause");
        super(r100, r101);
    }
}
