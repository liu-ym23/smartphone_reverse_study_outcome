package com.larus.bmhome.chat.monitor;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/monitor/MessageImageType;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageImageType extends Enum<MessageImageType> {
    public static final MessageImageType IMAGE = null;
    public static final MessageImageType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MessageImageType[] f308192a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f308193b = null;

    public static EnumEntries<MessageImageType> getEntries() {
        return f308193b;
    }

    static {
        MessageImageType r100 = new MessageImageType("IMAGE", 0);
        IMAGE = r100;
        MessageImageType r101 = new MessageImageType("VIDEO", 1);
        VIDEO = r101;
        MessageImageType[] r102 = {r100, r101};
        f308192a = r102;
        f308193b = EnumEntriesKt.enumEntries(r102);
    }

    public static MessageImageType[] values() {
        return (MessageImageType[]) f308192a.clone();
    }

    public static MessageImageType valueOf(String r100) {
        return (MessageImageType) a.a(MessageImageType.class, r100);
    }

    public MessageImageType(String r100, int r101) {
        super(r100, r101);
    }
}
