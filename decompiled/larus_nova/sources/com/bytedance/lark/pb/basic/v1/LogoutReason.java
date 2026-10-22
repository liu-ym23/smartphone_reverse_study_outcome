package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum LogoutReason extends Enum<LogoutReason> implements WireEnum {
    private static final /* synthetic */ LogoutReason[] $VALUES = null;
    public static final ProtoAdapter<LogoutReason> ADAPTER = null;
    public static final LogoutReason BoundDoubaoAccountChanged = null;
    public static final LogoutReason ChangeTenant = null;
    public static final LogoutReason DupLogin = null;
    public static final LogoutReason LoginError = null;
    public static final LogoutReason LoginWithoutLogout = null;
    public static final LogoutReason LongTimeNoLogin = null;
    public static final LogoutReason SecureMode = null;
    public static final LogoutReason SessionExpire = null;
    public static final LogoutReason UnKnownReason = null;
    public static final LogoutReason UserLogout = null;
    private final int value;

    static {
        LogoutReason r100 = new LogoutReason("UnKnownReason", 0, 0);
        UnKnownReason = r100;
        LogoutReason r101 = new LogoutReason("UserLogout", 1, 1);
        UserLogout = r101;
        LogoutReason r102 = new LogoutReason("ChangeTenant", 2, 2);
        ChangeTenant = r102;
        LogoutReason r103 = new LogoutReason("SessionExpire", 3, 3);
        SessionExpire = r103;
        LogoutReason r104 = new LogoutReason("SecureMode", 4, 8);
        SecureMode = r104;
        LogoutReason r105 = new LogoutReason("LongTimeNoLogin", 5, 9);
        LongTimeNoLogin = r105;
        LogoutReason r110 = new LogoutReason("BoundDoubaoAccountChanged", 6, 10);
        BoundDoubaoAccountChanged = r110;
        LogoutReason r111 = new LogoutReason("LoginError", 7, 20);
        LoginError = r111;
        LogoutReason r106 = new LogoutReason("LoginWithoutLogout", 8, 21);
        LoginWithoutLogout = r106;
        LogoutReason r107 = new LogoutReason("DupLogin", 9, 22);
        DupLogin = r107;
        $VALUES = new LogoutReason[]{r100, r101, r102, r103, r104, r105, r110, r111, r106, r107};
        ADAPTER = ProtoAdapter.newEnumAdapter(LogoutReason.class);
    }

    public static LogoutReason[] values() {
        return (LogoutReason[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static LogoutReason fromValue(int r100) {
        if (r100 == 0) goto L32;
        if (r100 == 1) goto L30;
        if (r100 == 2) goto L28;
        if (r100 == 3) goto L26;
        switch(r100) {
            case 8: goto L24;
            case 9: goto L22;
            case 10: goto L20;
            default: goto L10;
        };
    L10:
        switch(r100) {
            case 20: goto L18;
            case 21: goto L16;
            case 22: goto L14;
            default: goto L11;
        };
    L11:
        return null;
    L14:
        return DupLogin;
    L16:
        return LoginWithoutLogout;
    L18:
        return LoginError;
    L20:
        return BoundDoubaoAccountChanged;
    L22:
        return LongTimeNoLogin;
    L24:
        return SecureMode;
    L26:
        return SessionExpire;
    L28:
        return ChangeTenant;
    L30:
        return UserLogout;
    L32:
        return UnKnownReason;
    }

    public static LogoutReason valueOf(String r100) {
        return (LogoutReason) a.a(LogoutReason.class, r100);
    }

    private LogoutReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
