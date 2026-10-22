package com.ss.android.lark.biz.im.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\r\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/biz/im/api/MessageType;", "", "intType", "", "<init>", "(Ljava/lang/String;II)V", "getIntType", "()I", "UNKNOWN", "AT", "URGENT", "FOCUS", "CHATTER_APPLY", "getValue", "Companion", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageType extends Enum<MessageType> {
    public static final MessageType AT = null;
    public static final MessageType CHATTER_APPLY = null;
    public static final a Companion = null;
    public static final MessageType FOCUS = null;
    public static final MessageType UNKNOWN = null;
    public static final MessageType URGENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MessageType[] f409882a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f409883b = null;
    private final int intType;

    public static EnumEntries<MessageType> getEntries() {
        return f409883b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.biz.im.api.MessageType$a] */
    static {
        MessageType r100 = new MessageType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        MessageType r101 = new MessageType("AT", 1, 1);
        AT = r101;
        MessageType r102 = new MessageType("URGENT", 2, 2);
        URGENT = r102;
        MessageType r103 = new MessageType("FOCUS", 3, 3);
        FOCUS = r103;
        MessageType r104 = new MessageType("CHATTER_APPLY", 4, 4);
        CHATTER_APPLY = r104;
        MessageType[] r105 = {r100, r101, r102, r103, r104};
        f409882a = r105;
        f409883b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static MessageType[] values() {
        return (MessageType[]) f409882a.clone();
    }

    public final int getIntType() {
        return this.intType;
    }

    public final int getValue() {
        return this.intType;
    }

    public static MessageType valueOf(String r100) {
        return (MessageType) r27.a.a(MessageType.class, r100);
    }

    public MessageType(String r100, int r101, int r102) {
        super(r100, r101);
        this.intType = r102;
    }
}
