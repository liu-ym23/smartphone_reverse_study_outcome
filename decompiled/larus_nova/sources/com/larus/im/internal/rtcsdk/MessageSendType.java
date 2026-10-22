package com.larus.im.internal.rtcsdk;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/im/internal/rtcsdk/MessageSendType;", "", SocialConstants.PARAM_APP_DESC, "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getDesc", "()Ljava/lang/String;", "getType", "()I", "Engine", "Control", "P2P", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageSendType extends Enum<MessageSendType> {
    public static final MessageSendType Control = null;
    public static final MessageSendType Engine = null;
    public static final MessageSendType P2P = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MessageSendType[] f349822a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f349823b = null;
    private final String desc;
    private final int type;

    public static EnumEntries<MessageSendType> getEntries() {
        return f349823b;
    }

    static {
        MessageSendType r100 = new MessageSendType("Engine", 0, "Engine", 1);
        Engine = r100;
        MessageSendType r101 = new MessageSendType("Control", 1, "Control", 2);
        Control = r101;
        MessageSendType r102 = new MessageSendType("P2P", 2, "P2P", 3);
        P2P = r102;
        MessageSendType[] r103 = {r100, r101, r102};
        f349822a = r103;
        f349823b = EnumEntriesKt.enumEntries(r103);
    }

    public static MessageSendType[] values() {
        return (MessageSendType[]) f349822a.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getType() {
        return this.type;
    }

    public static MessageSendType valueOf(String r100) {
        return (MessageSendType) a.a(MessageSendType.class, r100);
    }

    public MessageSendType(String r100, int r101, String r102, int r103) {
        super(r100, r101);
        this.desc = r102;
        this.type = r103;
    }
}
