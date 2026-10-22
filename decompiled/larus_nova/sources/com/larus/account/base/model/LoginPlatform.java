package com.larus.account.base.model;

import com.android.ttcjpaysdk.base.ui.Utils.CJPayDiscountTextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.obric.miniapp.alarm.AccountType;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum LoginPlatform extends Enum<LoginPlatform> {
    public static final LoginPlatform DOUYIN = null;
    public static final LoginPlatform EMAIL = null;
    public static final LoginPlatform FACEBOOK = null;
    public static final LoginPlatform GOOGLE = null;
    public static final LoginPlatform LARK = null;
    public static final LoginPlatform LINE = null;
    public static final LoginPlatform ONELOGIN = null;
    public static final LoginPlatform PHONE = null;
    public static final LoginPlatform TIKTOK = null;
    public static final LoginPlatform TWITTER = null;
    public static final LoginPlatform UNKNOWN = null;
    public static final LoginPlatform WEIXIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoginPlatform[] f286200a = null;

    static {
        LoginPlatform r100 = new LoginPlatform("PHONE", 0);
        PHONE = r100;
        LoginPlatform r101 = new LoginPlatform(CommonConstant.RETKEY.EMAIL, 1);
        EMAIL = r101;
        LoginPlatform r102 = new LoginPlatform("GOOGLE", 2);
        GOOGLE = r102;
        LoginPlatform r103 = new LoginPlatform("FACEBOOK", 3);
        FACEBOOK = r103;
        LoginPlatform r104 = new LoginPlatform("TWITTER", 4);
        TWITTER = r104;
        LoginPlatform r105 = new LoginPlatform("TIKTOK", 5);
        TIKTOK = r105;
        LoginPlatform r110 = new LoginPlatform("DOUYIN", 6);
        DOUYIN = r110;
        LoginPlatform r111 = new LoginPlatform("WEIXIN", 7);
        WEIXIN = r111;
        LoginPlatform r112 = new LoginPlatform(CJPayDiscountTextUtils.CJ_PAY_STRIKE_THROUGH_TEXT_STYLE, 8);
        LINE = r112;
        LoginPlatform r113 = new LoginPlatform("ONELOGIN", 9);
        ONELOGIN = r113;
        LoginPlatform r114 = new LoginPlatform(AccountType.LARK, 10);
        LARK = r114;
        LoginPlatform r115 = new LoginPlatform("UNKNOWN", 11);
        UNKNOWN = r115;
        f286200a = new LoginPlatform[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
    }

    public static LoginPlatform[] values() {
        return (LoginPlatform[]) f286200a.clone();
    }

    public static LoginPlatform valueOf(String r100) {
        return (LoginPlatform) a.a(LoginPlatform.class, r100);
    }

    public LoginPlatform(String r100, int r101) {
        super(r100, r101);
    }
}
