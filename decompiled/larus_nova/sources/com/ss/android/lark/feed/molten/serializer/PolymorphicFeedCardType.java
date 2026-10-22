package com.ss.android.lark.feed.molten.serializer;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/PolymorphicFeedCardType;", "Ljava/io/Serializable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UI_FEED_CARD", "FEED_PREVIEW", "DOC_FEED_PREVIEW", "CHAT_FEED_PREVIEW", "THREAD_FEED_PREVIEW", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PolymorphicFeedCardType extends Enum<PolymorphicFeedCardType> implements Serializable {
    public static final PolymorphicFeedCardType CHAT_FEED_PREVIEW = null;
    public static final PolymorphicFeedCardType DOC_FEED_PREVIEW = null;
    public static final PolymorphicFeedCardType FEED_PREVIEW = null;
    public static final PolymorphicFeedCardType THREAD_FEED_PREVIEW = null;
    public static final PolymorphicFeedCardType UI_FEED_CARD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PolymorphicFeedCardType[] f421084a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f421085b = null;
    private final String value;

    public static EnumEntries<PolymorphicFeedCardType> getEntries() {
        return f421085b;
    }

    static {
        PolymorphicFeedCardType r100 = new PolymorphicFeedCardType("UI_FEED_CARD", 0, "UIFeedCard");
        UI_FEED_CARD = r100;
        PolymorphicFeedCardType r101 = new PolymorphicFeedCardType("FEED_PREVIEW", 1, "FeedPreview");
        FEED_PREVIEW = r101;
        PolymorphicFeedCardType r102 = new PolymorphicFeedCardType("DOC_FEED_PREVIEW", 2, "DocFeedPreview");
        DOC_FEED_PREVIEW = r102;
        PolymorphicFeedCardType r103 = new PolymorphicFeedCardType("CHAT_FEED_PREVIEW", 3, "ChatFeedPreview");
        CHAT_FEED_PREVIEW = r103;
        PolymorphicFeedCardType r104 = new PolymorphicFeedCardType("THREAD_FEED_PREVIEW", 4, "ThreadFeedPreview");
        THREAD_FEED_PREVIEW = r104;
        PolymorphicFeedCardType[] r105 = {r100, r101, r102, r103, r104};
        f421084a = r105;
        f421085b = EnumEntriesKt.enumEntries(r105);
    }

    public static PolymorphicFeedCardType[] values() {
        return (PolymorphicFeedCardType[]) f421084a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static PolymorphicFeedCardType valueOf(String r100) {
        return (PolymorphicFeedCardType) r27.a.a(PolymorphicFeedCardType.class, r100);
    }

    public PolymorphicFeedCardType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
