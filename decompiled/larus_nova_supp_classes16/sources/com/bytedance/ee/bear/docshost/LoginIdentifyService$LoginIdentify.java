package com.bytedance.ee.bear.docshost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum LoginIdentifyService$LoginIdentify extends Enum<LoginIdentifyService$LoginIdentify> {
    public static final LoginIdentifyService$LoginIdentify Suite_enterprise_Lark = null;
    public static final LoginIdentifyService$LoginIdentify Suite_enterprise_LarkDocs = null;
    public static final LoginIdentifyService$LoginIdentify Suite_single_Lark = null;
    public static final LoginIdentifyService$LoginIdentify Suite_single_LarkDocs = null;
    public static final /* synthetic */ LoginIdentifyService$LoginIdentify[] a = null;
    public static final LoginIdentifyService$LoginIdentify single_Lark = null;
    public static final LoginIdentifyService$LoginIdentify single_LarkDocs = null;

    static {
        LoginIdentifyService$LoginIdentify r0 = new LoginIdentifyService$LoginIdentify("single_LarkDocs", 0);
        single_LarkDocs = r0;
        LoginIdentifyService$LoginIdentify r1 = new LoginIdentifyService$LoginIdentify("single_Lark", 1);
        single_Lark = r1;
        LoginIdentifyService$LoginIdentify r3 = new LoginIdentifyService$LoginIdentify("Suite_single_LarkDocs", 2);
        Suite_single_LarkDocs = r3;
        LoginIdentifyService$LoginIdentify r5 = new LoginIdentifyService$LoginIdentify("Suite_single_Lark", 3);
        Suite_single_Lark = r5;
        LoginIdentifyService$LoginIdentify r7 = new LoginIdentifyService$LoginIdentify("Suite_enterprise_LarkDocs", 4);
        Suite_enterprise_LarkDocs = r7;
        LoginIdentifyService$LoginIdentify r9 = new LoginIdentifyService$LoginIdentify("Suite_enterprise_Lark", 5);
        Suite_enterprise_Lark = r9;
        a = new LoginIdentifyService$LoginIdentify[]{r0, r1, r3, r5, r7, r9};
    }

    public static LoginIdentifyService$LoginIdentify[] values() {
        return (LoginIdentifyService$LoginIdentify[]) a.clone();
    }

    public static LoginIdentifyService$LoginIdentify valueOf(String r1) {
        return (LoginIdentifyService$LoginIdentify) r27.a.a(LoginIdentifyService$LoginIdentify.class, r1);
    }

    public LoginIdentifyService$LoginIdentify(String r1, int r2) {
        super(r1, r2);
    }
}
