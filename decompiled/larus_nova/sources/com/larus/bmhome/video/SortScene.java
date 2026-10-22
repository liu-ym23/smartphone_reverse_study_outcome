package com.larus.bmhome.video;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/video/SortScene;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Undefined", "InnerStream", "MessageListTab", "MessageListPull", "ConversationList", "DiscoveryTab", "WelcomeBack", "PreFetch", "Recommend", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SortScene extends Enum<SortScene> {
    public static final a Companion = null;
    public static final SortScene ConversationList = null;
    public static final SortScene DiscoveryTab = null;
    public static final SortScene InnerStream = null;
    public static final SortScene MessageListPull = null;
    public static final SortScene MessageListTab = null;
    public static final SortScene PreFetch = null;
    public static final SortScene Recommend = null;
    public static final SortScene Undefined = null;
    public static final SortScene WelcomeBack = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SortScene[] f315191a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f315192b = null;
    private final int value;

    public static EnumEntries<SortScene> getEntries() {
        return f315192b;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.bmhome.video.SortScene$a] */
    static {
        SortScene r100 = new SortScene("Undefined", 0, 0);
        Undefined = r100;
        SortScene r101 = new SortScene("InnerStream", 1, 1);
        InnerStream = r101;
        SortScene r102 = new SortScene("MessageListTab", 2, 2);
        MessageListTab = r102;
        SortScene r103 = new SortScene("MessageListPull", 3, 3);
        MessageListPull = r103;
        SortScene r104 = new SortScene("ConversationList", 4, 4);
        ConversationList = r104;
        SortScene r105 = new SortScene("DiscoveryTab", 5, 5);
        DiscoveryTab = r105;
        SortScene r110 = new SortScene("WelcomeBack", 6, 6);
        WelcomeBack = r110;
        SortScene r111 = new SortScene("PreFetch", 7, 7);
        PreFetch = r111;
        SortScene r112 = new SortScene("Recommend", 8, 8);
        Recommend = r112;
        SortScene[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f315191a = r113;
        f315192b = EnumEntriesKt.enumEntries(r113);
        Companion = new a();
    }

    public static SortScene[] values() {
        return (SortScene[]) f315191a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SortScene valueOf(String r100) {
        return (SortScene) r27.a.a(SortScene.class, r100);
    }

    public SortScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
