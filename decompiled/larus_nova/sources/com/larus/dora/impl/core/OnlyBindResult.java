package com.larus.dora.impl.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/dora/impl/core/OnlyBindResult;", "", "<init>", "(Ljava/lang/String;I)V", "SERVER_BIND_NETWORK_ERROR", "SERVER_BIND_FAILED", "SERVER_BIND_NEED_UNBIND", "SERVER_BIND_UNKNOWN", "SUCCESS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OnlyBindResult extends Enum<OnlyBindResult> {
    public static final OnlyBindResult SERVER_BIND_FAILED = null;
    public static final OnlyBindResult SERVER_BIND_NEED_UNBIND = null;
    public static final OnlyBindResult SERVER_BIND_NETWORK_ERROR = null;
    public static final OnlyBindResult SERVER_BIND_UNKNOWN = null;
    public static final OnlyBindResult SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OnlyBindResult[] f332176a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f332177b = null;

    public static EnumEntries<OnlyBindResult> getEntries() {
        return f332177b;
    }

    static {
        OnlyBindResult r100 = new OnlyBindResult("SERVER_BIND_NETWORK_ERROR", 0);
        SERVER_BIND_NETWORK_ERROR = r100;
        OnlyBindResult r101 = new OnlyBindResult("SERVER_BIND_FAILED", 1);
        SERVER_BIND_FAILED = r101;
        OnlyBindResult r102 = new OnlyBindResult("SERVER_BIND_NEED_UNBIND", 2);
        SERVER_BIND_NEED_UNBIND = r102;
        OnlyBindResult r103 = new OnlyBindResult("SERVER_BIND_UNKNOWN", 3);
        SERVER_BIND_UNKNOWN = r103;
        OnlyBindResult r104 = new OnlyBindResult("SUCCESS", 4);
        SUCCESS = r104;
        OnlyBindResult[] r105 = {r100, r101, r102, r103, r104};
        f332176a = r105;
        f332177b = EnumEntriesKt.enumEntries(r105);
    }

    public static OnlyBindResult[] values() {
        return (OnlyBindResult[]) f332176a.clone();
    }

    public static OnlyBindResult valueOf(String r100) {
        return (OnlyBindResult) r27.a.a(OnlyBindResult.class, r100);
    }

    public OnlyBindResult(String r100, int r101) {
        super(r100, r101);
    }
}
