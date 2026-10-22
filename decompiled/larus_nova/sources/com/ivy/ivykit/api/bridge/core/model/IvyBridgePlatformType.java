package com.ivy.ivykit.api.bridge.core.model;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ivy/ivykit/api/bridge/core/model/IvyBridgePlatformType;", "", "RN", "WEB", "LYNX", UserProfileEvent.POSITION_NONE, AccountType.ALL, "ivy_api_release"}, k = 1, mv = {1, 7, 1})
public final enum IvyBridgePlatformType extends Enum<IvyBridgePlatformType> {
    public static final IvyBridgePlatformType ALL = null;
    public static final IvyBridgePlatformType LYNX = null;
    public static final IvyBridgePlatformType NONE = null;
    public static final IvyBridgePlatformType RN = null;
    public static final IvyBridgePlatformType WEB = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IvyBridgePlatformType[] f278313a = null;

    public static IvyBridgePlatformType valueOf(String r100) {
        return (IvyBridgePlatformType) a.a(IvyBridgePlatformType.class, r100);
    }

    public static IvyBridgePlatformType[] values() {
        return (IvyBridgePlatformType[]) f278313a.clone();
    }

    static {
        IvyBridgePlatformType r100 = new IvyBridgePlatformType("RN", 0);
        RN = r100;
        IvyBridgePlatformType r101 = new IvyBridgePlatformType("WEB", 1);
        WEB = r101;
        IvyBridgePlatformType r102 = new IvyBridgePlatformType("LYNX", 2);
        LYNX = r102;
        IvyBridgePlatformType r103 = new IvyBridgePlatformType(UserProfileEvent.POSITION_NONE, 3);
        NONE = r103;
        IvyBridgePlatformType r104 = new IvyBridgePlatformType(AccountType.ALL, 4);
        ALL = r104;
        f278313a = new IvyBridgePlatformType[]{r100, r101, r102, r103, r104};
    }

    public IvyBridgePlatformType(String r100, int r101) {
        super(r100, r101);
    }
}
