package com.larus.bmhome.chat.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/chat/bean/PageType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "UNKNOWN", "Chat", SuggestActionType.IMAGE_TEMPLATE, "VIDEO", "MUSIC_TEMPLATE", "AWEME_FEED", "AI_GENERATE", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PageType extends Enum<PageType> {
    public static final PageType AI_GENERATE = null;
    public static final PageType AWEME_FEED = null;
    public static final PageType Chat = null;
    public static final a Companion = null;
    public static final PageType IMAGE_TEMPLATE = null;
    public static final PageType MUSIC_TEMPLATE = null;
    public static final PageType UNKNOWN = null;
    public static final PageType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PageType[] f297415a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f297416b = null;
    private final int type;

    public static EnumEntries<PageType> getEntries() {
        return f297416b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.bean.PageType$a] */
    static {
        PageType r100 = new PageType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        PageType r101 = new PageType("Chat", 1, 1);
        Chat = r101;
        PageType r102 = new PageType(SuggestActionType.IMAGE_TEMPLATE, 2, 2);
        IMAGE_TEMPLATE = r102;
        PageType r103 = new PageType("VIDEO", 3, 3);
        VIDEO = r103;
        PageType r104 = new PageType("MUSIC_TEMPLATE", 4, 4);
        MUSIC_TEMPLATE = r104;
        PageType r105 = new PageType("AWEME_FEED", 5, 5);
        AWEME_FEED = r105;
        PageType r110 = new PageType("AI_GENERATE", 6, 6);
        AI_GENERATE = r110;
        PageType[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f297415a = r111;
        f297416b = EnumEntriesKt.enumEntries(r111);
        Companion = new a();
    }

    public static PageType[] values() {
        return (PageType[]) f297415a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static PageType valueOf(String r100) {
        return (PageType) r27.a.a(PageType.class, r100);
    }

    public PageType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
