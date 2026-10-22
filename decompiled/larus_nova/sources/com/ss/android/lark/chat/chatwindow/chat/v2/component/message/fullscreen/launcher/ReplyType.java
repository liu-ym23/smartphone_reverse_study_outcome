package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/ReplyType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "REPLY_NORMAL", "REPLY_PARTIAL", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReplyType extends Enum<ReplyType> {
    public static final a Companion = null;
    public static final ReplyType REPLY_NORMAL = null;
    public static final ReplyType REPLY_PARTIAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReplyType[] f413972a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f413973b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ReplyType> getEntries() {
        return f413973b;
    }

    static {
        ReplyType r100 = new ReplyType("REPLY_NORMAL", 0, 0);
        REPLY_NORMAL = r100;
        ReplyType r101 = new ReplyType("REPLY_PARTIAL", 1, 1);
        REPLY_PARTIAL = r101;
        ReplyType[] r102 = {r100, r101};
        f413972a = r102;
        f413973b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static ReplyType[] values() {
        return (ReplyType[]) f413972a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ReplyType valueOf(String r100) {
        return (ReplyType) r27.a.a(ReplyType.class, r100);
    }

    public ReplyType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
