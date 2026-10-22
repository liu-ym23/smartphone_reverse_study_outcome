package com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/plugin/stranger/StrangerBannerType;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", UserProfileEvent.POSITION_NONE, "TOTAL_BLOCK", "STRANGER", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum StrangerBannerType extends Enum<StrangerBannerType> {
    public static final StrangerBannerType NONE = null;
    public static final StrangerBannerType STRANGER = null;
    public static final StrangerBannerType TOTAL_BLOCK = null;
    public static final StrangerBannerType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StrangerBannerType[] f414480a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f414481b = null;

    public static EnumEntries<StrangerBannerType> getEntries() {
        return f414481b;
    }

    static {
        StrangerBannerType r100 = new StrangerBannerType("UNKNOWN", 0);
        UNKNOWN = r100;
        StrangerBannerType r101 = new StrangerBannerType(UserProfileEvent.POSITION_NONE, 1);
        NONE = r101;
        StrangerBannerType r102 = new StrangerBannerType("TOTAL_BLOCK", 2);
        TOTAL_BLOCK = r102;
        StrangerBannerType r103 = new StrangerBannerType("STRANGER", 3);
        STRANGER = r103;
        StrangerBannerType[] r104 = {r100, r101, r102, r103};
        f414480a = r104;
        f414481b = EnumEntriesKt.enumEntries(r104);
    }

    public static StrangerBannerType[] values() {
        return (StrangerBannerType[]) f414480a.clone();
    }

    public static StrangerBannerType valueOf(String r100) {
        return (StrangerBannerType) a.a(StrangerBannerType.class, r100);
    }

    public StrangerBannerType(String r100, int r101) {
        super(r100, r101);
    }
}
