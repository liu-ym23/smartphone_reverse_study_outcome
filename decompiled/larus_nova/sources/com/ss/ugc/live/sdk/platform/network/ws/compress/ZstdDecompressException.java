package com.ss.ugc.live.sdk.platform.network.ws.compress;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/ugc/live/sdk/platform/network/ws/compress/ZstdDecompressException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "reason", "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "platform_release"}, k = 1, mv = {1, 4, 0})
public final class ZstdDecompressException extends RuntimeException {
    public ZstdDecompressException(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        super(r100, r101);
    }

    public /* synthetic */ ZstdDecompressException(String r100, Throwable r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
