package com.ss.android.lark.chat.entity.message;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/MessageDLPState;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "IN_PROGRESS", "PASS", "BLOCK", "INACTIVE", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageDLPState extends Enum<MessageDLPState> {
    public static final MessageDLPState BLOCK = null;
    public static final a Companion = null;
    public static final MessageDLPState INACTIVE = null;
    public static final MessageDLPState IN_PROGRESS = null;
    public static final MessageDLPState PASS = null;
    public static final MessageDLPState UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MessageDLPState[] f415232a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415233b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<MessageDLPState> getEntries() {
        return f415233b;
    }

    static {
        MessageDLPState r100 = new MessageDLPState("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        MessageDLPState r101 = new MessageDLPState("IN_PROGRESS", 1, 1);
        IN_PROGRESS = r101;
        MessageDLPState r102 = new MessageDLPState("PASS", 2, 2);
        PASS = r102;
        MessageDLPState r103 = new MessageDLPState("BLOCK", 3, 3);
        BLOCK = r103;
        MessageDLPState r104 = new MessageDLPState("INACTIVE", 4, 4);
        INACTIVE = r104;
        MessageDLPState[] r105 = {r100, r101, r102, r103, r104};
        f415232a = r105;
        f415233b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static MessageDLPState[] values() {
        return (MessageDLPState[]) f415232a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final MessageDLPState fromValue(int r100) {
        Companion.getClass();
        MessageDLPState r101 = IN_PROGRESS;
        if (r100 == r101.getValue()) goto L16;
        MessageDLPState r102 = PASS;
        if (r100 == r102.getValue()) goto L17;
        MessageDLPState r103 = BLOCK;
        if (r100 == r103.getValue()) goto L18;
        MessageDLPState r104 = INACTIVE;
        if (r100 != r104.getValue()) goto L15;
        return r104;
    L15:
        return UNKNOWN;
    L18:
        return r103;
    L17:
        return r102;
    L16:
        return r101;
    }

    public static MessageDLPState valueOf(String r100) {
        return (MessageDLPState) r27.a.a(MessageDLPState.class, r100);
    }

    public MessageDLPState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
