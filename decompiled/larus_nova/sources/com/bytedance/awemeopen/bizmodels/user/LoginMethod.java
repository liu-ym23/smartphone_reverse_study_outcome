package com.bytedance.awemeopen.bizmodels.user;

import com.ss.android.ugc.effectmanager.common.EffectConstants;

/* JADX INFO: loaded from: classes44.dex */
public final enum LoginMethod extends Enum<LoginMethod> {
    public static final LoginMethod NORMAL = null;
    public static final LoginMethod ONE_KEY = null;
    public static final LoginMethod SILENT = null;
    public static final LoginMethod UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoginMethod[] f198215a = null;

    static {
        LoginMethod r100 = new LoginMethod(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        LoginMethod r101 = new LoginMethod("ONE_KEY", 1);
        ONE_KEY = r101;
        LoginMethod r102 = new LoginMethod("SILENT", 2);
        SILENT = r102;
        LoginMethod r103 = new LoginMethod("UNKNOWN", 3);
        UNKNOWN = r103;
        f198215a = new LoginMethod[]{r100, r101, r102, r103};
    }

    public static LoginMethod[] values() {
        return (LoginMethod[]) f198215a.clone();
    }

    public static LoginMethod valueOf(String r100) {
        return (LoginMethod) r27.a.a(LoginMethod.class, r100);
    }

    public LoginMethod(String r100, int r101) {
        super(r100, r101);
    }
}
