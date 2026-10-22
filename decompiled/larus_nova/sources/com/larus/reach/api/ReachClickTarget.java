package com.larus.reach.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/reach/api/ReachClickTarget;", "", "<init>", "(Ljava/lang/String;I)V", "CARD", "BUTTON", "CLOSE", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReachClickTarget extends Enum<ReachClickTarget> {
    public static final ReachClickTarget BUTTON = null;
    public static final ReachClickTarget CARD = null;
    public static final ReachClickTarget CLOSE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReachClickTarget[] f367121a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f367122b = null;

    public static EnumEntries<ReachClickTarget> getEntries() {
        return f367122b;
    }

    static {
        ReachClickTarget r100 = new ReachClickTarget("CARD", 0);
        CARD = r100;
        ReachClickTarget r101 = new ReachClickTarget("BUTTON", 1);
        BUTTON = r101;
        ReachClickTarget r102 = new ReachClickTarget("CLOSE", 2);
        CLOSE = r102;
        ReachClickTarget[] r103 = {r100, r101, r102};
        f367121a = r103;
        f367122b = EnumEntriesKt.enumEntries(r103);
    }

    public static ReachClickTarget[] values() {
        return (ReachClickTarget[]) f367121a.clone();
    }

    public static ReachClickTarget valueOf(String r100) {
        return (ReachClickTarget) a.a(ReachClickTarget.class, r100);
    }

    public ReachClickTarget(String r100, int r101) {
        super(r100, r101);
    }
}
