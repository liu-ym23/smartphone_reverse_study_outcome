package com.larus.im.bean.message;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/larus/im/bean/message/MessageRequestType;", "", "isResendScene", "", "<init>", "(Ljava/lang/String;IZ)V", "()Z", "UNKNOWN", "SEND_TEXT", "SEND_AUDIO", "SEND_IMAGE", "SEND_FILE", "SEND_NESTED_FILE", "SEND_VIDEO", "BATCH_SEND", "RESEND_TEXT", "RESEND_IMAGE", "RESEND_FILE", "RESEND_NESTED_FILE", "RESEND_AUDIO", "RESEND_VIDEO", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageRequestType extends Enum<MessageRequestType> {
    public static final MessageRequestType BATCH_SEND = null;
    public static final MessageRequestType RESEND_AUDIO = null;
    public static final MessageRequestType RESEND_FILE = null;
    public static final MessageRequestType RESEND_IMAGE = null;
    public static final MessageRequestType RESEND_NESTED_FILE = null;
    public static final MessageRequestType RESEND_TEXT = null;
    public static final MessageRequestType RESEND_VIDEO = null;
    public static final MessageRequestType SEND_AUDIO = null;
    public static final MessageRequestType SEND_FILE = null;
    public static final MessageRequestType SEND_IMAGE = null;
    public static final MessageRequestType SEND_NESTED_FILE = null;
    public static final MessageRequestType SEND_TEXT = null;
    public static final MessageRequestType SEND_VIDEO = null;
    public static final MessageRequestType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MessageRequestType[] f346675a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f346676b = null;
    private final boolean isResendScene;

    public static EnumEntries<MessageRequestType> getEntries() {
        return f346676b;
    }

    static {
        MessageRequestType r100 = new MessageRequestType("UNKNOWN", 0, false);
        UNKNOWN = r100;
        MessageRequestType r101 = new MessageRequestType("SEND_TEXT", 1, false);
        SEND_TEXT = r101;
        MessageRequestType r102 = new MessageRequestType("SEND_AUDIO", 2, false);
        SEND_AUDIO = r102;
        MessageRequestType r103 = new MessageRequestType("SEND_IMAGE", 3, false);
        SEND_IMAGE = r103;
        MessageRequestType r104 = new MessageRequestType("SEND_FILE", 4, false);
        SEND_FILE = r104;
        MessageRequestType r105 = new MessageRequestType("SEND_NESTED_FILE", 5, false);
        SEND_NESTED_FILE = r105;
        MessageRequestType r110 = new MessageRequestType("SEND_VIDEO", 6, false);
        SEND_VIDEO = r110;
        MessageRequestType r111 = new MessageRequestType("BATCH_SEND", 7, false);
        BATCH_SEND = r111;
        MessageRequestType r112 = new MessageRequestType("RESEND_TEXT", 8, true);
        RESEND_TEXT = r112;
        MessageRequestType r113 = new MessageRequestType("RESEND_IMAGE", 9, true);
        RESEND_IMAGE = r113;
        MessageRequestType r114 = new MessageRequestType("RESEND_FILE", 10, true);
        RESEND_FILE = r114;
        MessageRequestType r115 = new MessageRequestType("RESEND_NESTED_FILE", 11, true);
        RESEND_NESTED_FILE = r115;
        MessageRequestType r106 = new MessageRequestType("RESEND_AUDIO", 12, true);
        RESEND_AUDIO = r106;
        MessageRequestType r107 = new MessageRequestType("RESEND_VIDEO", 13, true);
        RESEND_VIDEO = r107;
        MessageRequestType[] r108 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107};
        f346675a = r108;
        f346676b = EnumEntriesKt.enumEntries(r108);
    }

    public static MessageRequestType[] values() {
        return (MessageRequestType[]) f346675a.clone();
    }

    public final boolean isResendScene() {
        return this.isResendScene;
    }

    public static MessageRequestType valueOf(String r100) {
        return (MessageRequestType) r27.a.a(MessageRequestType.class, r100);
    }

    public MessageRequestType(String r100, int r101, boolean r102) {
        super(r100, r101);
        this.isResendScene = r102;
    }
}
