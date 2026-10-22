package com.ss.android.lark.passport.signinsdk_api.feature.listener.logout;

import com.larus.nova.R;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum LogoutReason extends Enum<LogoutReason> {
    public static final LogoutReason ADMIN_KICKOUT_WIPE = null;
    public static final LogoutReason BASICMODEL_LOGOUT_JSB = null;
    public static final LogoutReason DEVICE_IS_MIGRATE = null;
    public static final LogoutReason EMM_TASK = null;
    public static final LogoutReason ENCRYPT_KEY_EMPTY = null;
    public static final LogoutReason EXCEED_LIMIT_CAUSE_LOGOUT = null;
    public static final LogoutReason FORGOT_DIGITAL_CODE = null;
    public static final LogoutReason IDP_CLIENT_TYPE_CHANGE = null;
    public static final LogoutReason IDP_REFRESH_TOKEN_INVALID_FOR_BROWSER = null;
    public static final LogoutReason IDP_REFRESH_TOKEN_INVALID_FOR_INIT = null;
    public static final LogoutReason INACTIVE_FOR_LONG_POPUP = null;
    public static final LogoutReason KA_OPEN_COMPONENT = null;
    public static final LogoutReason LOGOUT_CAUSE_BY_VPN_SDK = null;
    public static final LogoutReason MULTIPLE_LOGOUT = null;
    public static final LogoutReason NO_LOGIN_DATA = null;
    public static final LogoutReason NO_LOGIN_DATA_CORE = null;
    public static final LogoutReason NO_LOGIN_DATA_MAKE_LOGOUT = null;
    public static final LogoutReason NO_PERMISSION_CHECK_LOGOUT = null;
    public static final LogoutReason PASSPORT_LOGOUT_JSB = null;
    public static final LogoutReason PlaceHolder = null;
    public static final LogoutReason SEC_USER_IP_LIMIT = null;
    public static final LogoutReason SEC_USER_IP_LIMIT_ALL_LOGOUT = null;
    public static final LogoutReason SESSION_CHECK = null;
    public static final LogoutReason SESSION_CHECK_EMPTY_LIST = null;
    public static final LogoutReason SETTING_DATA_DEEP_CLEAN = null;
    public static final LogoutReason SWITCH_NEXT_FAIL_BY_ERROR_NOT_VERIFY = null;
    public static final LogoutReason SWITCH_NEXT_FAIL_BY_ERROR_NOT_VERIFY_V2 = null;
    public static final LogoutReason SWITCH_NEXT_FAIL_BY_LEARN_MODE = null;
    public static final LogoutReason SWITCH_NEXT_FAIL_BY_LEARN_MODE_V2 = null;
    public static final LogoutReason SWITCH_NEXT_FAIL_BY_RETRY = null;
    public static final LogoutReason SWITCH_TO_VALID_ACTIVITY_FINISH = null;
    public static final LogoutReason USER_DRIVING_ALL_LOGOUT = null;
    public static final LogoutReason USER_DRIVING_SINGLE_LOGOUT = null;
    public static final LogoutReason USER_MAKE_LOGOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LogoutReason[] f438085a = null;
    private final int logoutTimeOut;
    private final boolean needOfflineLogout;
    private final boolean skipUpdateContainer;
    private final int toastId;

    static {
        LogoutReason r100 = new LogoutReason("PlaceHolder", 0);
        PlaceHolder = r100;
        LogoutReason r101 = new LogoutReason("SESSION_CHECK", 1);
        SESSION_CHECK = r101;
        LogoutReason r102 = new LogoutReason("EMM_TASK", 2);
        EMM_TASK = r102;
        LogoutReason r103 = new LogoutReason("PASSPORT_LOGOUT_JSB", 3);
        PASSPORT_LOGOUT_JSB = r103;
        LogoutReason r104 = new LogoutReason("BASICMODEL_LOGOUT_JSB", 4);
        BASICMODEL_LOGOUT_JSB = r104;
        LogoutReason r105 = new LogoutReason("IDP_REFRESH_TOKEN_INVALID_FOR_BROWSER", 5);
        IDP_REFRESH_TOKEN_INVALID_FOR_BROWSER = r105;
        LogoutReason r110 = new LogoutReason("IDP_REFRESH_TOKEN_INVALID_FOR_INIT", 6);
        IDP_REFRESH_TOKEN_INVALID_FOR_INIT = r110;
        LogoutReason r111 = new LogoutReason("IDP_CLIENT_TYPE_CHANGE", 7);
        IDP_CLIENT_TYPE_CHANGE = r111;
        LogoutReason r112 = new LogoutReason("NO_LOGIN_DATA", 8);
        NO_LOGIN_DATA = r112;
        LogoutReason r113 = new LogoutReason("NO_LOGIN_DATA_CORE", 9);
        NO_LOGIN_DATA_CORE = r113;
        LogoutReason r114 = new LogoutReason("USER_MAKE_LOGOUT", 10);
        USER_MAKE_LOGOUT = r114;
        LogoutReason r115 = new LogoutReason("SWITCH_TO_VALID_ACTIVITY_FINISH", 11);
        SWITCH_TO_VALID_ACTIVITY_FINISH = r115;
        LogoutReason r106 = new LogoutReason("SWITCH_NEXT_FAIL_BY_LEARN_MODE", 12);
        SWITCH_NEXT_FAIL_BY_LEARN_MODE = r106;
        LogoutReason r107 = new LogoutReason("SWITCH_NEXT_FAIL_BY_LEARN_MODE_V2", 13);
        SWITCH_NEXT_FAIL_BY_LEARN_MODE_V2 = r107;
        LogoutReason r108 = new LogoutReason("SWITCH_NEXT_FAIL_BY_ERROR_NOT_VERIFY", 14);
        SWITCH_NEXT_FAIL_BY_ERROR_NOT_VERIFY = r108;
        LogoutReason r109 = new LogoutReason("SWITCH_NEXT_FAIL_BY_ERROR_NOT_VERIFY_V2", 15);
        SWITCH_NEXT_FAIL_BY_ERROR_NOT_VERIFY_V2 = r109;
        LogoutReason r116 = new LogoutReason("SWITCH_NEXT_FAIL_BY_RETRY", 16);
        SWITCH_NEXT_FAIL_BY_RETRY = r116;
        LogoutReason r117 = new LogoutReason("ENCRYPT_KEY_EMPTY", 17);
        ENCRYPT_KEY_EMPTY = r117;
        LogoutReason r118 = new LogoutReason("SESSION_CHECK_EMPTY_LIST", 18);
        SESSION_CHECK_EMPTY_LIST = r118;
        LogoutReason r119 = new LogoutReason("USER_DRIVING_ALL_LOGOUT", 19, 10, true, false);
        USER_DRIVING_ALL_LOGOUT = r119;
        LogoutReason r210 = new LogoutReason("USER_DRIVING_SINGLE_LOGOUT", 20, 10, false, false);
        USER_DRIVING_SINGLE_LOGOUT = r210;
        LogoutReason r211 = new LogoutReason("MULTIPLE_LOGOUT", 21, 30, true, true);
        MULTIPLE_LOGOUT = r211;
        LogoutReason r120 = new LogoutReason("EXCEED_LIMIT_CAUSE_LOGOUT", 22);
        EXCEED_LIMIT_CAUSE_LOGOUT = r120;
        LogoutReason r121 = new LogoutReason("FORGOT_DIGITAL_CODE", 23);
        FORGOT_DIGITAL_CODE = r121;
        LogoutReason r122 = new LogoutReason("NO_PERMISSION_CHECK_LOGOUT", 24);
        NO_PERMISSION_CHECK_LOGOUT = r122;
        LogoutReason r123 = new LogoutReason("LOGOUT_CAUSE_BY_VPN_SDK", 25);
        LOGOUT_CAUSE_BY_VPN_SDK = r123;
        LogoutReason r124 = new LogoutReason("NO_LOGIN_DATA_MAKE_LOGOUT", 26);
        NO_LOGIN_DATA_MAKE_LOGOUT = r124;
        LogoutReason r125 = new LogoutReason("INACTIVE_FOR_LONG_POPUP", 27);
        INACTIVE_FOR_LONG_POPUP = r125;
        LogoutReason r126 = new LogoutReason();
        DEVICE_IS_MIGRATE = r126;
        LogoutReason r127 = new LogoutReason("SEC_USER_IP_LIMIT", 29);
        SEC_USER_IP_LIMIT = r127;
        LogoutReason r128 = new LogoutReason("SEC_USER_IP_LIMIT_ALL_LOGOUT", 30, 10, true, false);
        SEC_USER_IP_LIMIT_ALL_LOGOUT = r128;
        LogoutReason r129 = new LogoutReason("KA_OPEN_COMPONENT", 31);
        KA_OPEN_COMPONENT = r129;
        LogoutReason r130 = new LogoutReason("SETTING_DATA_DEEP_CLEAN", 32);
        SETTING_DATA_DEEP_CLEAN = r130;
        LogoutReason r131 = new LogoutReason("ADMIN_KICKOUT_WIPE", 33);
        ADMIN_KICKOUT_WIPE = r131;
        f438085a = new LogoutReason[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r210, r211, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131};
    }

    public LogoutReason() {
        super("DEVICE_IS_MIGRATE", 28);
        this.toastId = R.string.Lark_Passport_PhoneTransferLoginSessionExpired_LoginExpiredLogInAgain_Toast;
        this.logoutTimeOut = 30;
        this.needOfflineLogout = true;
        this.skipUpdateContainer = false;
    }

    public static LogoutReason[] values() {
        return (LogoutReason[]) f438085a.clone();
    }

    public boolean hasValidToast() {
        if (this.toastId <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.lang.Enum
    public String toString() {
        return name();
    }

    public int getLogoutTimeOut() {
        return this.logoutTimeOut;
    }

    public boolean getNeedOfflineLogout() {
        return this.needOfflineLogout;
    }

    public int getToast() {
        return this.toastId;
    }

    public boolean isSkipUpdateContainer() {
        return this.skipUpdateContainer;
    }

    public static LogoutReason fromValue(String r100) {
        LogoutReason[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        LogoutReason r104 = r101[r103];
        if (r104.name().equals(r100) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return PlaceHolder;
    }

    public static LogoutReason valueOf(String r100) {
        return (LogoutReason) a.a(LogoutReason.class, r100);
    }

    public LogoutReason(String r100, int r101) {
        super(r100, r101);
        this.toastId = -1;
        this.logoutTimeOut = 30;
        this.needOfflineLogout = true;
        this.skipUpdateContainer = false;
    }

    public LogoutReason(String r100, int r101, int r102, boolean r103, boolean r104) {
        super(r100, r101);
        this.toastId = -1;
        this.logoutTimeOut = r102;
        this.needOfflineLogout = r103;
        this.skipUpdateContainer = r104;
    }
}
