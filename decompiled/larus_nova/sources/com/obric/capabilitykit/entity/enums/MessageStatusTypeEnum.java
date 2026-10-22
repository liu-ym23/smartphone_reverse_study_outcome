package com.obric.capabilitykit.entity.enums;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0087\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/entity/enums/MessageStatusTypeEnum;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "INBOX", "OUTBOX", "DRAFT", "SENDING", "SEND_FAILED", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1})
public final enum MessageStatusTypeEnum extends Enum<MessageStatusTypeEnum> {
    private static final /* synthetic */ MessageStatusTypeEnum[] $VALUES = null;
    public static final a Companion = null;
    public static final MessageStatusTypeEnum DRAFT = null;
    public static final MessageStatusTypeEnum INBOX = null;
    public static final MessageStatusTypeEnum OUTBOX = null;
    public static final MessageStatusTypeEnum SENDING = null;
    public static final MessageStatusTypeEnum SEND_FAILED = null;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a {
        public a() {
        }
    }

    private static final /* synthetic */ MessageStatusTypeEnum[] $values() {
        return new MessageStatusTypeEnum[]{INBOX, OUTBOX, DRAFT, SENDING, SEND_FAILED};
    }

    static {
        INBOX = new MessageStatusTypeEnum("INBOX", 0);
        OUTBOX = new MessageStatusTypeEnum("OUTBOX", 1);
        DRAFT = new MessageStatusTypeEnum("DRAFT", 2);
        SENDING = new MessageStatusTypeEnum("SENDING", 3);
        SEND_FAILED = new MessageStatusTypeEnum("SEND_FAILED", 4);
        $VALUES = $values();
        Companion = new a();
    }

    private MessageStatusTypeEnum(String r100, int r101) {
        super(r100, r101);
    }

    public static MessageStatusTypeEnum valueOf(String r100) {
        return (MessageStatusTypeEnum) r27.a.a(MessageStatusTypeEnum.class, r100);
    }

    public static MessageStatusTypeEnum[] values() {
        return (MessageStatusTypeEnum[]) $VALUES.clone();
    }
}
