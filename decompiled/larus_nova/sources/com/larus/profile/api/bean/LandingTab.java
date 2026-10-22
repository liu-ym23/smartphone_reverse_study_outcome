package com.larus.profile.api.bean;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/profile/api/bean/LandingTab;", "", "<init>", "(Ljava/lang/String;I)V", "PROFILE_BOT_LIST", "MY_COLLECT", "MY_LIKE", "PROFILE_CREATION_LIST_PUBLIC", "PROFILE_CREATION_LIST_PRIVATE", "PROFILE_CREATION_LIST_MIX", "PROFILE_CREATION_LIST", "PUBLIC_VOICE_LIST", FlowDoraWifiScene.ALBUM, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LandingTab extends Enum<LandingTab> {
    public static final LandingTab ALBUM = null;
    public static final LandingTab MY_COLLECT = null;
    public static final LandingTab MY_LIKE = null;
    public static final LandingTab PROFILE_BOT_LIST = null;
    public static final LandingTab PROFILE_CREATION_LIST = null;
    public static final LandingTab PROFILE_CREATION_LIST_MIX = null;
    public static final LandingTab PROFILE_CREATION_LIST_PRIVATE = null;
    public static final LandingTab PROFILE_CREATION_LIST_PUBLIC = null;
    public static final LandingTab PUBLIC_VOICE_LIST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LandingTab[] f365986a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365987b = null;

    public static EnumEntries<LandingTab> getEntries() {
        return f365987b;
    }

    static {
        LandingTab r100 = new LandingTab("PROFILE_BOT_LIST", 0);
        PROFILE_BOT_LIST = r100;
        LandingTab r101 = new LandingTab("MY_COLLECT", 1);
        MY_COLLECT = r101;
        LandingTab r102 = new LandingTab("MY_LIKE", 2);
        MY_LIKE = r102;
        LandingTab r103 = new LandingTab("PROFILE_CREATION_LIST_PUBLIC", 3);
        PROFILE_CREATION_LIST_PUBLIC = r103;
        LandingTab r104 = new LandingTab("PROFILE_CREATION_LIST_PRIVATE", 4);
        PROFILE_CREATION_LIST_PRIVATE = r104;
        LandingTab r105 = new LandingTab("PROFILE_CREATION_LIST_MIX", 5);
        PROFILE_CREATION_LIST_MIX = r105;
        LandingTab r110 = new LandingTab("PROFILE_CREATION_LIST", 6);
        PROFILE_CREATION_LIST = r110;
        LandingTab r111 = new LandingTab("PUBLIC_VOICE_LIST", 7);
        PUBLIC_VOICE_LIST = r111;
        LandingTab r112 = new LandingTab(FlowDoraWifiScene.ALBUM, 8);
        ALBUM = r112;
        LandingTab[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f365986a = r113;
        f365987b = EnumEntriesKt.enumEntries(r113);
    }

    public static LandingTab[] values() {
        return (LandingTab[]) f365986a.clone();
    }

    public static LandingTab valueOf(String r100) {
        return (LandingTab) a.a(LandingTab.class, r100);
    }

    public LandingTab(String r100, int r101) {
        super(r100, r101);
    }
}
