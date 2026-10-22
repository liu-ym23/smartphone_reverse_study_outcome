package com.larus.ugc.feed.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/ugc/feed/api/model/CommunityCreateLaunchModeKmp;", "", "<init>", "(Ljava/lang/String;I)V", "STANDALONE", "CHAT_MULTI_TAB", "SIDE_BAR", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CommunityCreateLaunchModeKmp extends Enum<CommunityCreateLaunchModeKmp> {
    public static final CommunityCreateLaunchModeKmp CHAT_MULTI_TAB = null;
    public static final CommunityCreateLaunchModeKmp SIDE_BAR = null;
    public static final CommunityCreateLaunchModeKmp STANDALONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommunityCreateLaunchModeKmp[] f374312a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f374313b = null;

    public static EnumEntries<CommunityCreateLaunchModeKmp> getEntries() {
        return f374313b;
    }

    static {
        CommunityCreateLaunchModeKmp r100 = new CommunityCreateLaunchModeKmp("STANDALONE", 0);
        STANDALONE = r100;
        CommunityCreateLaunchModeKmp r101 = new CommunityCreateLaunchModeKmp("CHAT_MULTI_TAB", 1);
        CHAT_MULTI_TAB = r101;
        CommunityCreateLaunchModeKmp r102 = new CommunityCreateLaunchModeKmp("SIDE_BAR", 2);
        SIDE_BAR = r102;
        CommunityCreateLaunchModeKmp[] r103 = {r100, r101, r102};
        f374312a = r103;
        f374313b = EnumEntriesKt.enumEntries(r103);
    }

    public static CommunityCreateLaunchModeKmp[] values() {
        return (CommunityCreateLaunchModeKmp[]) f374312a.clone();
    }

    public static CommunityCreateLaunchModeKmp valueOf(String r100) {
        return (CommunityCreateLaunchModeKmp) a.a(CommunityCreateLaunchModeKmp.class, r100);
    }

    public CommunityCreateLaunchModeKmp(String r100, int r101) {
        super(r100, r101);
    }
}
