package com.larus.reach.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/reach/api/ReachRequestSource;", "", "<init>", "(Ljava/lang/String;I)V", "SERVER_CMD", "INAPP_PUSH_PULL", "CLIENT_BRIDGE", "LOCAL_SUBMIT", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReachRequestSource extends Enum<ReachRequestSource> {
    public static final ReachRequestSource CLIENT_BRIDGE = null;
    public static final ReachRequestSource INAPP_PUSH_PULL = null;
    public static final ReachRequestSource LOCAL_SUBMIT = null;
    public static final ReachRequestSource SERVER_CMD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReachRequestSource[] f367135a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f367136b = null;

    public static EnumEntries<ReachRequestSource> getEntries() {
        return f367136b;
    }

    static {
        ReachRequestSource r100 = new ReachRequestSource("SERVER_CMD", 0);
        SERVER_CMD = r100;
        ReachRequestSource r101 = new ReachRequestSource("INAPP_PUSH_PULL", 1);
        INAPP_PUSH_PULL = r101;
        ReachRequestSource r102 = new ReachRequestSource("CLIENT_BRIDGE", 2);
        CLIENT_BRIDGE = r102;
        ReachRequestSource r103 = new ReachRequestSource("LOCAL_SUBMIT", 3);
        LOCAL_SUBMIT = r103;
        ReachRequestSource[] r104 = {r100, r101, r102, r103};
        f367135a = r104;
        f367136b = EnumEntriesKt.enumEntries(r104);
    }

    public static ReachRequestSource[] values() {
        return (ReachRequestSource[]) f367135a.clone();
    }

    public static ReachRequestSource valueOf(String r100) {
        return (ReachRequestSource) a.a(ReachRequestSource.class, r100);
    }

    public ReachRequestSource(String r100, int r101) {
        super(r100, r101);
    }
}
