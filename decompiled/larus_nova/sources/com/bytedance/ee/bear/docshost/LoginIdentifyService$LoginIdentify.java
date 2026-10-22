package com.bytedance.ee.bear.docshost;

/* JADX INFO: loaded from: classes16.dex */
public final enum LoginIdentifyService$LoginIdentify extends Enum<LoginIdentifyService$LoginIdentify> {
    public static final LoginIdentifyService$LoginIdentify Suite_enterprise_Lark = null;
    public static final LoginIdentifyService$LoginIdentify Suite_enterprise_LarkDocs = null;
    public static final LoginIdentifyService$LoginIdentify Suite_single_Lark = null;
    public static final LoginIdentifyService$LoginIdentify Suite_single_LarkDocs = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoginIdentifyService$LoginIdentify[] f218475a = null;
    public static final LoginIdentifyService$LoginIdentify single_Lark = null;
    public static final LoginIdentifyService$LoginIdentify single_LarkDocs = null;

    static {
        LoginIdentifyService$LoginIdentify r100 = new LoginIdentifyService$LoginIdentify("single_LarkDocs", 0);
        single_LarkDocs = r100;
        LoginIdentifyService$LoginIdentify r101 = new LoginIdentifyService$LoginIdentify("single_Lark", 1);
        single_Lark = r101;
        LoginIdentifyService$LoginIdentify r102 = new LoginIdentifyService$LoginIdentify("Suite_single_LarkDocs", 2);
        Suite_single_LarkDocs = r102;
        LoginIdentifyService$LoginIdentify r103 = new LoginIdentifyService$LoginIdentify("Suite_single_Lark", 3);
        Suite_single_Lark = r103;
        LoginIdentifyService$LoginIdentify r104 = new LoginIdentifyService$LoginIdentify("Suite_enterprise_LarkDocs", 4);
        Suite_enterprise_LarkDocs = r104;
        LoginIdentifyService$LoginIdentify r105 = new LoginIdentifyService$LoginIdentify("Suite_enterprise_Lark", 5);
        Suite_enterprise_Lark = r105;
        f218475a = new LoginIdentifyService$LoginIdentify[]{r100, r101, r102, r103, r104, r105};
    }

    public static LoginIdentifyService$LoginIdentify[] values() {
        return (LoginIdentifyService$LoginIdentify[]) f218475a.clone();
    }

    public static LoginIdentifyService$LoginIdentify valueOf(String r100) {
        return (LoginIdentifyService$LoginIdentify) r27.a.a(LoginIdentifyService$LoginIdentify.class, r100);
    }

    public LoginIdentifyService$LoginIdentify(String r100, int r101) {
        super(r100, r101);
    }
}
