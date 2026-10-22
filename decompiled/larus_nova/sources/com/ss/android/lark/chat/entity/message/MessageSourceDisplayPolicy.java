package com.ss.android.lark.chat.entity.message;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/MessageSourceDisplayPolicy;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN_AGENT_SEND_MESSAGE_SOURCE_DISPLAY_POLICY", "MENU", "INLINE", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageSourceDisplayPolicy extends Enum<MessageSourceDisplayPolicy> {
    public static final MessageSourceDisplayPolicy INLINE = null;
    public static final MessageSourceDisplayPolicy MENU = null;
    public static final MessageSourceDisplayPolicy UNKNOWN_AGENT_SEND_MESSAGE_SOURCE_DISPLAY_POLICY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MessageSourceDisplayPolicy[] f415295a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415296b = null;

    public static EnumEntries<MessageSourceDisplayPolicy> getEntries() {
        return f415296b;
    }

    static {
        MessageSourceDisplayPolicy r100 = new MessageSourceDisplayPolicy("UNKNOWN_AGENT_SEND_MESSAGE_SOURCE_DISPLAY_POLICY", 0);
        UNKNOWN_AGENT_SEND_MESSAGE_SOURCE_DISPLAY_POLICY = r100;
        MessageSourceDisplayPolicy r101 = new MessageSourceDisplayPolicy("MENU", 1);
        MENU = r101;
        MessageSourceDisplayPolicy r102 = new MessageSourceDisplayPolicy("INLINE", 2);
        INLINE = r102;
        MessageSourceDisplayPolicy[] r103 = {r100, r101, r102};
        f415295a = r103;
        f415296b = EnumEntriesKt.enumEntries(r103);
    }

    public static MessageSourceDisplayPolicy[] values() {
        return (MessageSourceDisplayPolicy[]) f415295a.clone();
    }

    public static MessageSourceDisplayPolicy valueOf(String r100) {
        return (MessageSourceDisplayPolicy) r27.a.a(MessageSourceDisplayPolicy.class, r100);
    }

    public MessageSourceDisplayPolicy(String r100, int r101) {
        super(r100, r101);
    }
}
