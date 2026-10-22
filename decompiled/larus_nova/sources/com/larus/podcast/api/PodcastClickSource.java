package com.larus.podcast.api;

import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/podcast/api/PodcastClickSource;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DeepResearch", "MessagePanelLongPress", "SuggestPrompt", ServiceType.DOC, "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PodcastClickSource extends Enum<PodcastClickSource> {
    public static final PodcastClickSource DeepResearch = null;
    public static final PodcastClickSource Doc = null;
    public static final PodcastClickSource MessagePanelLongPress = null;
    public static final PodcastClickSource SuggestPrompt = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PodcastClickSource[] f365945a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365946b = null;
    private final int value;

    public static EnumEntries<PodcastClickSource> getEntries() {
        return f365946b;
    }

    static {
        PodcastClickSource r100 = new PodcastClickSource("DeepResearch", 0, 0);
        DeepResearch = r100;
        PodcastClickSource r101 = new PodcastClickSource("MessagePanelLongPress", 1, 1);
        MessagePanelLongPress = r101;
        PodcastClickSource r102 = new PodcastClickSource("SuggestPrompt", 2, 2);
        SuggestPrompt = r102;
        PodcastClickSource r103 = new PodcastClickSource(ServiceType.DOC, 3, 3);
        Doc = r103;
        PodcastClickSource[] r104 = {r100, r101, r102, r103};
        f365945a = r104;
        f365946b = EnumEntriesKt.enumEntries(r104);
    }

    public static PodcastClickSource[] values() {
        return (PodcastClickSource[]) f365945a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static PodcastClickSource valueOf(String r100) {
        return (PodcastClickSource) r27.a.a(PodcastClickSource.class, r100);
    }

    public PodcastClickSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
