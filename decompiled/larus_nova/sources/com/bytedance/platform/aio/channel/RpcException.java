package com.bytedance.platform.aio.channel;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\t\u0018\u00002\u00060\u0001j\u0002`\u0002BM\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R-\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/platform/aio/channel/RpcException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "rpcCategory", "", "rpcMessage", "rpcExtra", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "rpcErrorLevel", "Lcom/bytedance/platform/aio/channel/RpcExceptionMonitorLevel;", "cause", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/bytedance/platform/aio/channel/RpcExceptionMonitorLevel;Ljava/lang/Throwable;)V", "getRpcCategory", "()Ljava/lang/String;", "getRpcErrorLevel", "()Lcom/bytedance/platform/aio/channel/RpcExceptionMonitorLevel;", "getRpcExtra", "()Ljava/util/Map;", "getRpcMessage", "live-kmp-platform-dynamic-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RpcException extends RuntimeException {
    private final String rpcCategory;
    private final RpcExceptionMonitorLevel rpcErrorLevel;
    private final Map<String, String> rpcExtra;
    private final String rpcMessage;

    public final String getRpcCategory() {
        return this.rpcCategory;
    }

    public final RpcExceptionMonitorLevel getRpcErrorLevel() {
        return this.rpcErrorLevel;
    }

    public final Map<String, String> getRpcExtra() {
        return this.rpcExtra;
    }

    public final String getRpcMessage() {
        return this.rpcMessage;
    }

    public RpcException(String r100, String r101, Map<String, String> r102, RpcExceptionMonitorLevel r103, Throwable r104) {
        Intrinsics.checkNotNullParameter(r100, "rpcCategory");
        Intrinsics.checkNotNullParameter(r101, "rpcMessage");
        Intrinsics.checkNotNullParameter(r102, "rpcExtra");
        Intrinsics.checkNotNullParameter(r103, "rpcErrorLevel");
        super("category = " + r100 + ", message = " + r101 + ", extra = " + r102, r104);
        this.rpcCategory = r100;
        this.rpcMessage = r101;
        this.rpcExtra = r102;
        this.rpcErrorLevel = r103;
    }

    public /* synthetic */ RpcException(String r100, String r101, Map r102, RpcExceptionMonitorLevel r110, Throwable r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 16) == 0) goto L5;
        r111 = null;
    L5:
        this(r100, r101, r102, r110, r111);
    }
}
