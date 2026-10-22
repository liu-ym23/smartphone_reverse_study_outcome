package com.ss.android.lark.ccm_api;

import com.bytedance.android.livehostapi.platform.depend.user.UserChangedCallback;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum SpacekitConst$LoginEvent extends Enum<SpacekitConst$LoginEvent> {
    public static final SpacekitConst$LoginEvent BeforeLogout = null;
    public static final SpacekitConst$LoginEvent Login = null;
    public static final SpacekitConst$LoginEvent Logout = null;
    public static final SpacekitConst$LoginEvent SwitchTenantEnd = null;
    public static final SpacekitConst$LoginEvent SwitchTenantFailed = null;
    public static final SpacekitConst$LoginEvent SwitchTenantStart = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SpacekitConst$LoginEvent[] f411061a = null;

    static {
        SpacekitConst$LoginEvent r100 = new SpacekitConst$LoginEvent("BeforeLogout", 0);
        BeforeLogout = r100;
        SpacekitConst$LoginEvent r101 = new SpacekitConst$LoginEvent(UserChangedCallback.CHANGE_TYPE_LOGIN, 1);
        Login = r101;
        SpacekitConst$LoginEvent r102 = new SpacekitConst$LoginEvent(UserChangedCallback.CHANGE_TYPE_LOGOUT, 2);
        Logout = r102;
        SpacekitConst$LoginEvent r103 = new SpacekitConst$LoginEvent("SwitchTenantStart", 3);
        SwitchTenantStart = r103;
        SpacekitConst$LoginEvent r104 = new SpacekitConst$LoginEvent("SwitchTenantEnd", 4);
        SwitchTenantEnd = r104;
        SpacekitConst$LoginEvent r105 = new SpacekitConst$LoginEvent("SwitchTenantFailed", 5);
        SwitchTenantFailed = r105;
        f411061a = new SpacekitConst$LoginEvent[]{r100, r101, r102, r103, r104, r105};
    }

    public static SpacekitConst$LoginEvent[] values() {
        return (SpacekitConst$LoginEvent[]) f411061a.clone();
    }

    public static SpacekitConst$LoginEvent valueOf(String r100) {
        return (SpacekitConst$LoginEvent) a.a(SpacekitConst$LoginEvent.class, r100);
    }

    public SpacekitConst$LoginEvent(String r100, int r101) {
        super(r100, r101);
    }
}
