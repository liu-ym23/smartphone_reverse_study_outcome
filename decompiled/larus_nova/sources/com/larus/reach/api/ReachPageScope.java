package com.larus.reach.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/reach/api/ReachPageScope;", "", "<init>", "(Ljava/lang/String;I)V", "Global", "TargetPage", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReachPageScope extends Enum<ReachPageScope> {
    public static final ReachPageScope Global = null;
    public static final ReachPageScope TargetPage = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReachPageScope[] f367127a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f367128b = null;

    public static EnumEntries<ReachPageScope> getEntries() {
        return f367128b;
    }

    static {
        ReachPageScope r100 = new ReachPageScope("Global", 0);
        Global = r100;
        ReachPageScope r101 = new ReachPageScope("TargetPage", 1);
        TargetPage = r101;
        ReachPageScope[] r102 = {r100, r101};
        f367127a = r102;
        f367128b = EnumEntriesKt.enumEntries(r102);
    }

    public static ReachPageScope[] values() {
        return (ReachPageScope[]) f367127a.clone();
    }

    public static ReachPageScope valueOf(String r100) {
        return (ReachPageScope) a.a(ReachPageScope.class, r100);
    }

    public ReachPageScope(String r100, int r101) {
        super(r100, r101);
    }
}
