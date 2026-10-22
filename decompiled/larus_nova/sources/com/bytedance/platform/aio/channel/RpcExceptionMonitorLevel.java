package com.bytedance.platform.aio.channel;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/platform/aio/channel/RpcExceptionMonitorLevel;", "", "", "postFix", "Ljava/lang/String;", "getPostFix", "()Ljava/lang/String;", "ERROR", "WARNING", "INFO", "live-kmp-platform-dynamic-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RpcExceptionMonitorLevel extends Enum<RpcExceptionMonitorLevel> {
    public static final RpcExceptionMonitorLevel ERROR = null;
    public static final RpcExceptionMonitorLevel INFO = null;
    public static final RpcExceptionMonitorLevel WARNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RpcExceptionMonitorLevel[] f266573a = null;
    private final String postFix;

    static {
        RpcExceptionMonitorLevel r100 = new RpcExceptionMonitorLevel("ERROR", 0, "err");
        ERROR = r100;
        RpcExceptionMonitorLevel r101 = new RpcExceptionMonitorLevel("WARNING", 1, "warning");
        WARNING = r101;
        RpcExceptionMonitorLevel r102 = new RpcExceptionMonitorLevel("INFO", 2, "info");
        INFO = r102;
        f266573a = new RpcExceptionMonitorLevel[]{r100, r101, r102};
    }

    public static RpcExceptionMonitorLevel valueOf(String r100) {
        return (RpcExceptionMonitorLevel) r27.a.a(RpcExceptionMonitorLevel.class, r100);
    }

    public static RpcExceptionMonitorLevel[] values() {
        return (RpcExceptionMonitorLevel[]) f266573a.clone();
    }

    public final String getPostFix() {
        return this.postFix;
    }

    public RpcExceptionMonitorLevel(String r100, int r101, String r102) {
        super(r100, r101);
        this.postFix = r102;
    }
}
