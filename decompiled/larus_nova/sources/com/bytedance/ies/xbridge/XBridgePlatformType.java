package com.bytedance.ies.xbridge;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/xbridge/XBridgePlatformType;", "", "(Ljava/lang/String;I)V", "RN", "WEB", "LYNX", UserProfileEvent.POSITION_NONE, AccountType.ALL, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum XBridgePlatformType extends Enum<XBridgePlatformType> {
    private static final /* synthetic */ XBridgePlatformType[] $VALUES = null;
    public static final XBridgePlatformType ALL = null;
    public static final XBridgePlatformType LYNX = null;
    public static final XBridgePlatformType NONE = null;
    public static final XBridgePlatformType RN = null;
    public static final XBridgePlatformType WEB = null;

    private static final /* synthetic */ XBridgePlatformType[] $values() {
        return new XBridgePlatformType[]{RN, WEB, LYNX, NONE, ALL};
    }

    public static XBridgePlatformType valueOf(String r100) {
        return (XBridgePlatformType) r27.a.a(XBridgePlatformType.class, r100);
    }

    public static XBridgePlatformType[] values() {
        return (XBridgePlatformType[]) $VALUES.clone();
    }

    static {
        RN = new XBridgePlatformType("RN", 0);
        WEB = new XBridgePlatformType("WEB", 1);
        LYNX = new XBridgePlatformType("LYNX", 2);
        NONE = new XBridgePlatformType(UserProfileEvent.POSITION_NONE, 3);
        ALL = new XBridgePlatformType(AccountType.ALL, 4);
        $VALUES = $values();
    }

    private XBridgePlatformType(String r100, int r101) {
        super(r100, r101);
    }
}
