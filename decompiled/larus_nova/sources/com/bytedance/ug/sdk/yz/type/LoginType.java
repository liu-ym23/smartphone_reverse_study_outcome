package com.bytedance.ug.sdk.yz.type;

import com.huawei.hms.android.SystemUtils;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public final enum LoginType extends Enum<LoginType> {
    public static final LoginType HUAWEI = null;
    public static final LoginType MEIZU = null;
    public static final LoginType XIAOMI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoginType[] f272364a = null;
    public int value;

    static {
        LoginType r100 = new LoginType(SystemUtils.PRODUCT_HUAWEI, 0, 0);
        HUAWEI = r100;
        LoginType r101 = new LoginType("XIAOMI", 1, 1);
        XIAOMI = r101;
        LoginType r102 = new LoginType("MEIZU", 2, 2);
        MEIZU = r102;
        f272364a = new LoginType[]{r100, r101, r102};
    }

    public static LoginType[] values() {
        return (LoginType[]) f272364a.clone();
    }

    public static LoginType valueOf(String r100) {
        return (LoginType) a.a(LoginType.class, r100);
    }

    public LoginType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
