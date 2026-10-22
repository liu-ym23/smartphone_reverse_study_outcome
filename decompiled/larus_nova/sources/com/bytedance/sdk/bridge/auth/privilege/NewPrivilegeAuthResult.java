package com.bytedance.sdk.bridge.auth.privilege;

/* JADX INFO: loaded from: classes22.dex */
public final enum NewPrivilegeAuthResult extends Enum<NewPrivilegeAuthResult> {
    public static final NewPrivilegeAuthResult EXCEPTION_AUTH_RULE_EMPTY = null;
    public static final NewPrivilegeAuthResult EXCEPTION_BRIDGE_NAME_EMPTY = null;
    public static final NewPrivilegeAuthResult EXCEPTION_BRIDGE_PRIVILEGE_EMPTY = null;
    public static final NewPrivilegeAuthResult EXCEPTION_EMPTY_URL = null;
    public static final NewPrivilegeAuthResult EXCEPTION_NOT_HTTP = null;
    public static final NewPrivilegeAuthResult EXCEPTION_PARSE_HOST_ERROR = null;
    public static final NewPrivilegeAuthResult EXCEPTION_RUNTIME = null;
    public static final NewPrivilegeAuthResult FALSE = null;
    public static final NewPrivilegeAuthResult TRUE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NewPrivilegeAuthResult[] f269566a = null;

    static {
        NewPrivilegeAuthResult r100 = new NewPrivilegeAuthResult("TRUE", 0);
        TRUE = r100;
        NewPrivilegeAuthResult r101 = new NewPrivilegeAuthResult("FALSE", 1);
        FALSE = r101;
        NewPrivilegeAuthResult r102 = new NewPrivilegeAuthResult("EXCEPTION_EMPTY_URL", 2);
        EXCEPTION_EMPTY_URL = r102;
        NewPrivilegeAuthResult r103 = new NewPrivilegeAuthResult("EXCEPTION_NOT_HTTP", 3);
        EXCEPTION_NOT_HTTP = r103;
        NewPrivilegeAuthResult r104 = new NewPrivilegeAuthResult("EXCEPTION_PARSE_HOST_ERROR", 4);
        EXCEPTION_PARSE_HOST_ERROR = r104;
        NewPrivilegeAuthResult r105 = new NewPrivilegeAuthResult("EXCEPTION_BRIDGE_NAME_EMPTY", 5);
        EXCEPTION_BRIDGE_NAME_EMPTY = r105;
        NewPrivilegeAuthResult r110 = new NewPrivilegeAuthResult("EXCEPTION_BRIDGE_PRIVILEGE_EMPTY", 6);
        EXCEPTION_BRIDGE_PRIVILEGE_EMPTY = r110;
        NewPrivilegeAuthResult r111 = new NewPrivilegeAuthResult("EXCEPTION_RUNTIME", 7);
        EXCEPTION_RUNTIME = r111;
        NewPrivilegeAuthResult r112 = new NewPrivilegeAuthResult("EXCEPTION_AUTH_RULE_EMPTY", 8);
        EXCEPTION_AUTH_RULE_EMPTY = r112;
        f269566a = new NewPrivilegeAuthResult[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public static NewPrivilegeAuthResult[] values() {
        return (NewPrivilegeAuthResult[]) f269566a.clone();
    }

    public static NewPrivilegeAuthResult valueOf(String r100) {
        return (NewPrivilegeAuthResult) r27.a.a(NewPrivilegeAuthResult.class, r100);
    }

    public NewPrivilegeAuthResult(String r100, int r101) {
        super(r100, r101);
    }
}
