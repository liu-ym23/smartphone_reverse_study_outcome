package com.larus.bmhome.chat.markdown.richtext;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/markdown/richtext/MessageMarkdownLinkSource;", "", "<init>", "(Ljava/lang/String;I)V", "MARKDOWN_LINK", "PLAIN_URL", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageMarkdownLinkSource extends Enum<MessageMarkdownLinkSource> {
    public static final MessageMarkdownLinkSource MARKDOWN_LINK = null;
    public static final MessageMarkdownLinkSource PLAIN_URL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MessageMarkdownLinkSource[] f307176a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f307177b = null;

    public static EnumEntries<MessageMarkdownLinkSource> getEntries() {
        return f307177b;
    }

    static {
        MessageMarkdownLinkSource r100 = new MessageMarkdownLinkSource("MARKDOWN_LINK", 0);
        MARKDOWN_LINK = r100;
        MessageMarkdownLinkSource r101 = new MessageMarkdownLinkSource("PLAIN_URL", 1);
        PLAIN_URL = r101;
        MessageMarkdownLinkSource[] r102 = {r100, r101};
        f307176a = r102;
        f307177b = EnumEntriesKt.enumEntries(r102);
    }

    public static MessageMarkdownLinkSource[] values() {
        return (MessageMarkdownLinkSource[]) f307176a.clone();
    }

    public static MessageMarkdownLinkSource valueOf(String r100) {
        return (MessageMarkdownLinkSource) r27.a.a(MessageMarkdownLinkSource.class, r100);
    }

    public MessageMarkdownLinkSource(String r100, int r101) {
        super(r100, r101);
    }
}
