package com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/plugin/stranger/StrangerTagType;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "STRANGER", "TOTAL_BLOCK", "BLOCK", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum StrangerTagType extends Enum<StrangerTagType> {
    public static final StrangerTagType BLOCK = null;
    public static final StrangerTagType NONE = null;
    public static final StrangerTagType STRANGER = null;
    public static final StrangerTagType TOTAL_BLOCK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StrangerTagType[] f414482a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f414483b = null;

    public static EnumEntries<StrangerTagType> getEntries() {
        return f414483b;
    }

    static {
        StrangerTagType r100 = new StrangerTagType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        StrangerTagType r101 = new StrangerTagType("STRANGER", 1);
        STRANGER = r101;
        StrangerTagType r102 = new StrangerTagType("TOTAL_BLOCK", 2);
        TOTAL_BLOCK = r102;
        StrangerTagType r103 = new StrangerTagType("BLOCK", 3);
        BLOCK = r103;
        StrangerTagType[] r104 = {r100, r101, r102, r103};
        f414482a = r104;
        f414483b = EnumEntriesKt.enumEntries(r104);
    }

    public static StrangerTagType[] values() {
        return (StrangerTagType[]) f414482a.clone();
    }

    public static StrangerTagType valueOf(String r100) {
        return (StrangerTagType) a.a(StrangerTagType.class, r100);
    }

    public StrangerTagType(String r100, int r101) {
        super(r100, r101);
    }
}
