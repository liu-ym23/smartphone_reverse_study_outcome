package com.ss.android.lark.passport.flow.auth_type;

import com.larus.nova.R;
import com.obric.miniapp.alarm.AccountType;

/* JADX INFO: loaded from: classes37.dex */
public final enum DisplayTypeEnum extends Enum<DisplayTypeEnum> {
    public static final DisplayTypeEnum APPLE = null;
    public static final DisplayTypeEnum GOOGLE = null;
    public static final DisplayTypeEnum IDP = null;
    public static final DisplayTypeEnum MAIL = null;
    public static final DisplayTypeEnum OTHERS = null;
    public static final DisplayTypeEnum OTP = null;
    public static final DisplayTypeEnum PASSWORD = null;
    public static final DisplayTypeEnum PHONE = null;
    public static final DisplayTypeEnum QR = null;
    public static final DisplayTypeEnum SPARE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DisplayTypeEnum[] f437729a = null;
    private final int iconRes;
    private final int type;

    static {
        DisplayTypeEnum r100 = new DisplayTypeEnum("PHONE", 0, ContactPointTypeEnum.PHONE.value(), R.drawable.ud_icon_cellphone_outlined);
        PHONE = r100;
        DisplayTypeEnum r101 = new DisplayTypeEnum("MAIL", 1, ContactPointTypeEnum.MAIL.value(), R.drawable.ud_icon_mail_outlined);
        MAIL = r101;
        DisplayTypeEnum r102 = new DisplayTypeEnum("OTP", 2, 3, R.drawable.sigin_sdk_verify_otp);
        OTP = r102;
        DisplayTypeEnum r103 = new DisplayTypeEnum("GOOGLE", 3, 4, R.drawable.ud_icon_google_colorful);
        GOOGLE = r103;
        DisplayTypeEnum r104 = new DisplayTypeEnum("APPLE", 4, 5, R.drawable.ud_icon_apple_filled);
        APPLE = r104;
        DisplayTypeEnum r105 = new DisplayTypeEnum("PASSWORD", 5, 6, R.drawable.ud_icon_lock_outlined);
        PASSWORD = r105;
        DisplayTypeEnum r110 = new DisplayTypeEnum("SPARE", 6, 6, R.drawable.ud_icon_safe_pass_outlined);
        SPARE = r110;
        DisplayTypeEnum r111 = new DisplayTypeEnum("IDP", 7, ContactPointTypeEnum.IDP.value(), R.drawable.sigin_sdk_verify_sso);
        IDP = r111;
        DisplayTypeEnum r112 = new DisplayTypeEnum("QR", 8, ContactPointTypeEnum.QR.value(), R.drawable.ud_icon_qr_outlined);
        QR = r112;
        DisplayTypeEnum r113 = new DisplayTypeEnum(AccountType.OTHERS, 9, ContactPointTypeEnum.OTHERS.value(), R.drawable.ud_icon_member_filled);
        OTHERS = r113;
        f437729a = new DisplayTypeEnum[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
    }

    public static DisplayTypeEnum[] values() {
        return (DisplayTypeEnum[]) f437729a.clone();
    }

    public int getIconRes() {
        return this.iconRes;
    }

    public int value() {
        return this.type;
    }

    public static DisplayTypeEnum fromValue(int r100) {
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L17;
        if (r100 == 3) goto L15;
        if (r100 == 32) goto L13;
        return OTHERS;
    L13:
        return IDP;
    L15:
        return OTP;
    L17:
        return MAIL;
    L19:
        return PHONE;
    }

    public static DisplayTypeEnum valueOf(String r100) {
        return (DisplayTypeEnum) r27.a.a(DisplayTypeEnum.class, r100);
    }

    public DisplayTypeEnum(String r100, int r101, int r102, int r103) {
        super(r100, r101);
        this.type = r102;
        this.iconRes = r103;
    }
}
