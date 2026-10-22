package com.larus.dora.impl.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/impl/core/OnlyConnectResult;", "", "<init>", "(Ljava/lang/String;I)V", "CONNECT_FAILED", "CONNECT_TIMEOUT", "SUCCESS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OnlyConnectResult extends Enum<OnlyConnectResult> {
    public static final OnlyConnectResult CONNECT_FAILED = null;
    public static final OnlyConnectResult CONNECT_TIMEOUT = null;
    public static final OnlyConnectResult SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OnlyConnectResult[] f332178a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f332179b = null;

    public static EnumEntries<OnlyConnectResult> getEntries() {
        return f332179b;
    }

    static {
        OnlyConnectResult r100 = new OnlyConnectResult("CONNECT_FAILED", 0);
        CONNECT_FAILED = r100;
        OnlyConnectResult r101 = new OnlyConnectResult("CONNECT_TIMEOUT", 1);
        CONNECT_TIMEOUT = r101;
        OnlyConnectResult r102 = new OnlyConnectResult("SUCCESS", 2);
        SUCCESS = r102;
        OnlyConnectResult[] r103 = {r100, r101, r102};
        f332178a = r103;
        f332179b = EnumEntriesKt.enumEntries(r103);
    }

    public static OnlyConnectResult[] values() {
        return (OnlyConnectResult[]) f332178a.clone();
    }

    public static OnlyConnectResult valueOf(String r100) {
        return (OnlyConnectResult) r27.a.a(OnlyConnectResult.class, r100);
    }

    public OnlyConnectResult(String r100, int r101) {
        super(r100, r101);
    }
}
