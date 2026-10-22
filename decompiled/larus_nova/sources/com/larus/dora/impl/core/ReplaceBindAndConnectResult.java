package com.larus.dora.impl.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/dora/impl/core/ReplaceBindAndConnectResult;", "", "<init>", "(Ljava/lang/String;I)V", "SERVER_REPLACE_BIND_NETWORK_ERROR", "SERVER_REPLACE_BIND_FAILED", "SERVER_REPLACE_BIND_UNKNOWN", "CONNECT_FAILED", "CONNECT_TIMEOUT", "SUCCESS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReplaceBindAndConnectResult extends Enum<ReplaceBindAndConnectResult> {
    public static final ReplaceBindAndConnectResult CONNECT_FAILED = null;
    public static final ReplaceBindAndConnectResult CONNECT_TIMEOUT = null;
    public static final ReplaceBindAndConnectResult SERVER_REPLACE_BIND_FAILED = null;
    public static final ReplaceBindAndConnectResult SERVER_REPLACE_BIND_NETWORK_ERROR = null;
    public static final ReplaceBindAndConnectResult SERVER_REPLACE_BIND_UNKNOWN = null;
    public static final ReplaceBindAndConnectResult SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReplaceBindAndConnectResult[] f332182a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f332183b = null;

    public static EnumEntries<ReplaceBindAndConnectResult> getEntries() {
        return f332183b;
    }

    static {
        ReplaceBindAndConnectResult r100 = new ReplaceBindAndConnectResult("SERVER_REPLACE_BIND_NETWORK_ERROR", 0);
        SERVER_REPLACE_BIND_NETWORK_ERROR = r100;
        ReplaceBindAndConnectResult r101 = new ReplaceBindAndConnectResult("SERVER_REPLACE_BIND_FAILED", 1);
        SERVER_REPLACE_BIND_FAILED = r101;
        ReplaceBindAndConnectResult r102 = new ReplaceBindAndConnectResult("SERVER_REPLACE_BIND_UNKNOWN", 2);
        SERVER_REPLACE_BIND_UNKNOWN = r102;
        ReplaceBindAndConnectResult r103 = new ReplaceBindAndConnectResult("CONNECT_FAILED", 3);
        CONNECT_FAILED = r103;
        ReplaceBindAndConnectResult r104 = new ReplaceBindAndConnectResult("CONNECT_TIMEOUT", 4);
        CONNECT_TIMEOUT = r104;
        ReplaceBindAndConnectResult r105 = new ReplaceBindAndConnectResult("SUCCESS", 5);
        SUCCESS = r105;
        ReplaceBindAndConnectResult[] r110 = {r100, r101, r102, r103, r104, r105};
        f332182a = r110;
        f332183b = EnumEntriesKt.enumEntries(r110);
    }

    public static ReplaceBindAndConnectResult[] values() {
        return (ReplaceBindAndConnectResult[]) f332182a.clone();
    }

    public static ReplaceBindAndConnectResult valueOf(String r100) {
        return (ReplaceBindAndConnectResult) r27.a.a(ReplaceBindAndConnectResult.class, r100);
    }

    public ReplaceBindAndConnectResult(String r100, int r101) {
        super(r100, r101);
    }
}
