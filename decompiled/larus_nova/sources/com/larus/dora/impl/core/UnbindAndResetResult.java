package com.larus.dora.impl.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/dora/impl/core/UnbindAndResetResult;", "", "<init>", "(Ljava/lang/String;I)V", "SERVER_UNBIND_NETWORK_ERROR", "SERVER_UNBIND_FAILED", "SERVER_UNBIND_UNKNOWN", "SPP_DISCONNECT_FAILED", "SUCCESS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UnbindAndResetResult extends Enum<UnbindAndResetResult> {
    public static final UnbindAndResetResult SERVER_UNBIND_FAILED = null;
    public static final UnbindAndResetResult SERVER_UNBIND_NETWORK_ERROR = null;
    public static final UnbindAndResetResult SERVER_UNBIND_UNKNOWN = null;
    public static final UnbindAndResetResult SPP_DISCONNECT_FAILED = null;
    public static final UnbindAndResetResult SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UnbindAndResetResult[] f332184a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f332185b = null;

    public static EnumEntries<UnbindAndResetResult> getEntries() {
        return f332185b;
    }

    static {
        UnbindAndResetResult r100 = new UnbindAndResetResult("SERVER_UNBIND_NETWORK_ERROR", 0);
        SERVER_UNBIND_NETWORK_ERROR = r100;
        UnbindAndResetResult r101 = new UnbindAndResetResult("SERVER_UNBIND_FAILED", 1);
        SERVER_UNBIND_FAILED = r101;
        UnbindAndResetResult r102 = new UnbindAndResetResult("SERVER_UNBIND_UNKNOWN", 2);
        SERVER_UNBIND_UNKNOWN = r102;
        UnbindAndResetResult r103 = new UnbindAndResetResult("SPP_DISCONNECT_FAILED", 3);
        SPP_DISCONNECT_FAILED = r103;
        UnbindAndResetResult r104 = new UnbindAndResetResult("SUCCESS", 4);
        SUCCESS = r104;
        UnbindAndResetResult[] r105 = {r100, r101, r102, r103, r104};
        f332184a = r105;
        f332185b = EnumEntriesKt.enumEntries(r105);
    }

    public static UnbindAndResetResult[] values() {
        return (UnbindAndResetResult[]) f332184a.clone();
    }

    public static UnbindAndResetResult valueOf(String r100) {
        return (UnbindAndResetResult) r27.a.a(UnbindAndResetResult.class, r100);
    }

    public UnbindAndResetResult(String r100, int r101) {
        super(r100, r101);
    }
}
