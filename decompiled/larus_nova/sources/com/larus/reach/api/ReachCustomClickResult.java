package com.larus.reach.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/reach/api/ReachCustomClickResult;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_HANDLED", "LOCAL_HANDLED", "SCENE_HANDLED", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReachCustomClickResult extends Enum<ReachCustomClickResult> {
    public static final ReachCustomClickResult LOCAL_HANDLED = null;
    public static final ReachCustomClickResult NOT_HANDLED = null;
    public static final ReachCustomClickResult SCENE_HANDLED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReachCustomClickResult[] f367125a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f367126b = null;

    public static EnumEntries<ReachCustomClickResult> getEntries() {
        return f367126b;
    }

    static {
        ReachCustomClickResult r100 = new ReachCustomClickResult("NOT_HANDLED", 0);
        NOT_HANDLED = r100;
        ReachCustomClickResult r101 = new ReachCustomClickResult("LOCAL_HANDLED", 1);
        LOCAL_HANDLED = r101;
        ReachCustomClickResult r102 = new ReachCustomClickResult("SCENE_HANDLED", 2);
        SCENE_HANDLED = r102;
        ReachCustomClickResult[] r103 = {r100, r101, r102};
        f367125a = r103;
        f367126b = EnumEntriesKt.enumEntries(r103);
    }

    public static ReachCustomClickResult[] values() {
        return (ReachCustomClickResult[]) f367125a.clone();
    }

    public static ReachCustomClickResult valueOf(String r100) {
        return (ReachCustomClickResult) a.a(ReachCustomClickResult.class, r100);
    }

    public ReachCustomClickResult(String r100, int r101) {
        super(r100, r101);
    }
}
