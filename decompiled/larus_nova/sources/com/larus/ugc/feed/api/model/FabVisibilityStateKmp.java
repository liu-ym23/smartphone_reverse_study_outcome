package com.larus.ugc.feed.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/ugc/feed/api/model/FabVisibilityStateKmp;", "", "<init>", "(Ljava/lang/String;I)V", "VISIBLE", "HIDDEN_DOWNGRADE", "HIDDEN_LAUNCH_MODE", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FabVisibilityStateKmp extends Enum<FabVisibilityStateKmp> {
    public static final FabVisibilityStateKmp HIDDEN_DOWNGRADE = null;
    public static final FabVisibilityStateKmp HIDDEN_LAUNCH_MODE = null;
    public static final FabVisibilityStateKmp VISIBLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FabVisibilityStateKmp[] f374330a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f374331b = null;

    public static EnumEntries<FabVisibilityStateKmp> getEntries() {
        return f374331b;
    }

    static {
        FabVisibilityStateKmp r100 = new FabVisibilityStateKmp("VISIBLE", 0);
        VISIBLE = r100;
        FabVisibilityStateKmp r101 = new FabVisibilityStateKmp("HIDDEN_DOWNGRADE", 1);
        HIDDEN_DOWNGRADE = r101;
        FabVisibilityStateKmp r102 = new FabVisibilityStateKmp("HIDDEN_LAUNCH_MODE", 2);
        HIDDEN_LAUNCH_MODE = r102;
        FabVisibilityStateKmp[] r103 = {r100, r101, r102};
        f374330a = r103;
        f374331b = EnumEntriesKt.enumEntries(r103);
    }

    public static FabVisibilityStateKmp[] values() {
        return (FabVisibilityStateKmp[]) f374330a.clone();
    }

    public static FabVisibilityStateKmp valueOf(String r100) {
        return (FabVisibilityStateKmp) a.a(FabVisibilityStateKmp.class, r100);
    }

    public FabVisibilityStateKmp(String r100, int r101) {
        super(r100, r101);
    }
}
