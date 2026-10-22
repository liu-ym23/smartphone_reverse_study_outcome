package com.bytedance.ee.bear.basesdk;

import com.bytedance.android.livehostapi.platform.depend.user.UserChangedCallback;

/* JADX INFO: loaded from: classes15.dex */
public interface IDocInit {

    public static final enum LoginEvent extends Enum<LoginEvent> {
        public static final LoginEvent BeforeLogout = null;
        public static final LoginEvent Login = null;
        public static final LoginEvent Logout = null;
        public static final LoginEvent SwitchTenantEnd = null;
        public static final LoginEvent SwitchTenantFailed = null;
        public static final LoginEvent SwitchTenantStart = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LoginEvent[] f206473a = null;

        static {
            LoginEvent r100 = new LoginEvent("BeforeLogout", 0);
            BeforeLogout = r100;
            LoginEvent r101 = new LoginEvent(UserChangedCallback.CHANGE_TYPE_LOGIN, 1);
            Login = r101;
            LoginEvent r102 = new LoginEvent(UserChangedCallback.CHANGE_TYPE_LOGOUT, 2);
            Logout = r102;
            LoginEvent r103 = new LoginEvent("SwitchTenantStart", 3);
            SwitchTenantStart = r103;
            LoginEvent r104 = new LoginEvent("SwitchTenantEnd", 4);
            SwitchTenantEnd = r104;
            LoginEvent r105 = new LoginEvent("SwitchTenantFailed", 5);
            SwitchTenantFailed = r105;
            f206473a = new LoginEvent[]{r100, r101, r102, r103, r104, r105};
        }

        public static LoginEvent[] values() {
            return (LoginEvent[]) f206473a.clone();
        }

        public static LoginEvent valueOf(String r100) {
            return (LoginEvent) r27.a.a(LoginEvent.class, r100);
        }

        public LoginEvent(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum PreInitPeriod extends Enum<PreInitPeriod> {
        public static final PreInitPeriod OnAttachBase = null;
        public static final PreInitPeriod OnCreate = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PreInitPeriod[] f206474a = null;

        static {
            PreInitPeriod r100 = new PreInitPeriod("OnAttachBase", 0);
            OnAttachBase = r100;
            PreInitPeriod r101 = new PreInitPeriod("OnCreate", 1);
            OnCreate = r101;
            f206474a = new PreInitPeriod[]{r100, r101};
        }

        public static PreInitPeriod[] values() {
            return (PreInitPeriod[]) f206474a.clone();
        }

        public static PreInitPeriod valueOf(String r100) {
            return (PreInitPeriod) r27.a.a(PreInitPeriod.class, r100);
        }

        public PreInitPeriod(String r100, int r101) {
            super(r100, r101);
        }
    }
}
