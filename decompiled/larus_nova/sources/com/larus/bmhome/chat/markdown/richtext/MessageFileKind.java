package com.larus.bmhome.chat.markdown.richtext;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/markdown/richtext/MessageFileKind;", "", "<init>", "(Ljava/lang/String;I)V", "FILE", "DIRECTORY", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageFileKind extends Enum<MessageFileKind> {
    public static final MessageFileKind DIRECTORY = null;
    public static final MessageFileKind FILE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MessageFileKind[] f307174a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f307175b = null;

    public static EnumEntries<MessageFileKind> getEntries() {
        return f307175b;
    }

    static {
        MessageFileKind r100 = new MessageFileKind("FILE", 0);
        FILE = r100;
        MessageFileKind r101 = new MessageFileKind("DIRECTORY", 1);
        DIRECTORY = r101;
        MessageFileKind[] r102 = {r100, r101};
        f307174a = r102;
        f307175b = EnumEntriesKt.enumEntries(r102);
    }

    public static MessageFileKind[] values() {
        return (MessageFileKind[]) f307174a.clone();
    }

    public static MessageFileKind valueOf(String r100) {
        return (MessageFileKind) r27.a.a(MessageFileKind.class, r100);
    }

    public MessageFileKind(String r100, int r101) {
        super(r100, r101);
    }
}
