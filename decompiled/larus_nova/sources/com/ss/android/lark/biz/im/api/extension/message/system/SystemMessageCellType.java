package com.ss.android.lark.biz.im.api.extension.message.system;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/message/system/SystemMessageCellType;", "", "<init>", "(Ljava/lang/String;I)V", "RED_PACKET", "MY_AI_TOOL", "MY_AI_TOOL_MOCK", "CHAT_GUIDE", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SystemMessageCellType extends Enum<SystemMessageCellType> {
    public static final SystemMessageCellType CHAT_GUIDE = null;
    public static final SystemMessageCellType MY_AI_TOOL = null;
    public static final SystemMessageCellType MY_AI_TOOL_MOCK = null;
    public static final SystemMessageCellType RED_PACKET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SystemMessageCellType[] f410212a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410213b = null;

    public static EnumEntries<SystemMessageCellType> getEntries() {
        return f410213b;
    }

    static {
        SystemMessageCellType r100 = new SystemMessageCellType("RED_PACKET", 0);
        RED_PACKET = r100;
        SystemMessageCellType r101 = new SystemMessageCellType("MY_AI_TOOL", 1);
        MY_AI_TOOL = r101;
        SystemMessageCellType r102 = new SystemMessageCellType("MY_AI_TOOL_MOCK", 2);
        MY_AI_TOOL_MOCK = r102;
        SystemMessageCellType r103 = new SystemMessageCellType("CHAT_GUIDE", 3);
        CHAT_GUIDE = r103;
        SystemMessageCellType[] r104 = {r100, r101, r102, r103};
        f410212a = r104;
        f410213b = EnumEntriesKt.enumEntries(r104);
    }

    public static SystemMessageCellType[] values() {
        return (SystemMessageCellType[]) f410212a.clone();
    }

    public static SystemMessageCellType valueOf(String r100) {
        return (SystemMessageCellType) r27.a.a(SystemMessageCellType.class, r100);
    }

    public SystemMessageCellType(String r100, int r101) {
        super(r100, r101);
    }
}
