package com.larus.platform.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/platform/api/InnerVideoPreloadScene;", "", "sceneValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getSceneValue", "()Ljava/lang/String;", "Unknown", "SearchList", "RelatedVideo", "ChatFirstCard", "WCBFirstCard", "ChatFeed", "WCBFeed", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InnerVideoPreloadScene extends Enum<InnerVideoPreloadScene> {
    public static final InnerVideoPreloadScene ChatFeed = null;
    public static final InnerVideoPreloadScene ChatFirstCard = null;
    public static final InnerVideoPreloadScene RelatedVideo = null;
    public static final InnerVideoPreloadScene SearchList = null;
    public static final InnerVideoPreloadScene Unknown = null;
    public static final InnerVideoPreloadScene WCBFeed = null;
    public static final InnerVideoPreloadScene WCBFirstCard = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InnerVideoPreloadScene[] f364810a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f364811b = null;
    private final String sceneValue;

    public static EnumEntries<InnerVideoPreloadScene> getEntries() {
        return f364811b;
    }

    static {
        InnerVideoPreloadScene r100 = new InnerVideoPreloadScene("Unknown", 0, "unknown");
        Unknown = r100;
        InnerVideoPreloadScene r101 = new InnerVideoPreloadScene("SearchList", 1, "search_list");
        SearchList = r101;
        InnerVideoPreloadScene r102 = new InnerVideoPreloadScene("RelatedVideo", 2, "related_video");
        RelatedVideo = r102;
        InnerVideoPreloadScene r103 = new InnerVideoPreloadScene("ChatFirstCard", 3, "chat_first_card");
        ChatFirstCard = r103;
        InnerVideoPreloadScene r104 = new InnerVideoPreloadScene("WCBFirstCard", 4, "wcb_first_card");
        WCBFirstCard = r104;
        InnerVideoPreloadScene r105 = new InnerVideoPreloadScene("ChatFeed", 5, "chat_feed");
        ChatFeed = r105;
        InnerVideoPreloadScene r110 = new InnerVideoPreloadScene("WCBFeed", 6, "wcb_feed");
        WCBFeed = r110;
        InnerVideoPreloadScene[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f364810a = r111;
        f364811b = EnumEntriesKt.enumEntries(r111);
    }

    public static InnerVideoPreloadScene[] values() {
        return (InnerVideoPreloadScene[]) f364810a.clone();
    }

    public final String getSceneValue() {
        return this.sceneValue;
    }

    public static InnerVideoPreloadScene valueOf(String r100) {
        return (InnerVideoPreloadScene) r27.a.a(InnerVideoPreloadScene.class, r100);
    }

    public InnerVideoPreloadScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.sceneValue = r102;
    }
}
