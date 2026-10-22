package com.ss.android.lark.chat.entity.message;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/MessageStreamStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "Transport", "Over", "Error", "Break", "Prepare", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageStreamStatus extends Enum<MessageStreamStatus> {
    public static final MessageStreamStatus Break = null;
    public static final a Companion = null;
    public static final MessageStreamStatus Error = null;
    public static final MessageStreamStatus Over = null;
    public static final MessageStreamStatus Prepare = null;
    public static final MessageStreamStatus Transport = null;
    public static final MessageStreamStatus Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MessageStreamStatus[] f415297a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415298b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<MessageStreamStatus> getEntries() {
        return f415298b;
    }

    static {
        MessageStreamStatus r100 = new MessageStreamStatus("Unknown", 0, 0);
        Unknown = r100;
        MessageStreamStatus r101 = new MessageStreamStatus("Transport", 1, 1);
        Transport = r101;
        MessageStreamStatus r102 = new MessageStreamStatus("Over", 2, 2);
        Over = r102;
        MessageStreamStatus r103 = new MessageStreamStatus("Error", 3, 3);
        Error = r103;
        MessageStreamStatus r104 = new MessageStreamStatus("Break", 4, 4);
        Break = r104;
        MessageStreamStatus r105 = new MessageStreamStatus("Prepare", 5, 5);
        Prepare = r105;
        MessageStreamStatus[] r110 = {r100, r101, r102, r103, r104, r105};
        f415297a = r110;
        f415298b = EnumEntriesKt.enumEntries(r110);
        Companion = new a();
    }

    public static MessageStreamStatus[] values() {
        return (MessageStreamStatus[]) f415297a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final MessageStreamStatus fromValue(int r100) {
        Companion.getClass();
        if (r100 == 1) goto L18;
        if (r100 == 2) goto L23;
        if (r100 == 3) goto L22;
        if (r100 == 4) goto L21;
        if (r100 == 5) goto L20;
        return Unknown;
    L20:
        return Prepare;
    L21:
        return Break;
    L22:
        return Error;
    L23:
        return Over;
    L18:
        return Transport;
    }

    public static MessageStreamStatus valueOf(String r100) {
        return (MessageStreamStatus) r27.a.a(MessageStreamStatus.class, r100);
    }

    public MessageStreamStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
