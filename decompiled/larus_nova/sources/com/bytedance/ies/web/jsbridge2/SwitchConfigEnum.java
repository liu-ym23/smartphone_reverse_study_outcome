package com.bytedance.ies.web.jsbridge2;

/* JADX INFO: loaded from: classes19.dex */
public final enum SwitchConfigEnum extends Enum<SwitchConfigEnum> {
    public static final SwitchConfigEnum PERMISSION_CONFIG_DEFAULT_FETCHED = null;
    public static final SwitchConfigEnum PERMISSION_CONFIG_INTERNAL_INIT = null;
    public static final SwitchConfigEnum PERMISSION_CONFIG_SYNC_PARSE_SWITCH = null;
    public static final SwitchConfigEnum XSS_CALLBACK_ID_SWITCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SwitchConfigEnum[] f249286a = null;

    static {
        SwitchConfigEnum r100 = new SwitchConfigEnum("XSS_CALLBACK_ID_SWITCH", 0);
        XSS_CALLBACK_ID_SWITCH = r100;
        SwitchConfigEnum r101 = new SwitchConfigEnum("PERMISSION_CONFIG_SYNC_PARSE_SWITCH", 1);
        PERMISSION_CONFIG_SYNC_PARSE_SWITCH = r101;
        SwitchConfigEnum r102 = new SwitchConfigEnum("PERMISSION_CONFIG_DEFAULT_FETCHED", 2);
        PERMISSION_CONFIG_DEFAULT_FETCHED = r102;
        SwitchConfigEnum r103 = new SwitchConfigEnum("PERMISSION_CONFIG_INTERNAL_INIT", 3);
        PERMISSION_CONFIG_INTERNAL_INIT = r103;
        f249286a = new SwitchConfigEnum[]{r100, r101, r102, r103};
    }

    public static SwitchConfigEnum[] values() {
        return (SwitchConfigEnum[]) f249286a.clone();
    }

    public static SwitchConfigEnum valueOf(String r100) {
        return (SwitchConfigEnum) r27.a.a(SwitchConfigEnum.class, r100);
    }

    public SwitchConfigEnum(String r100, int r101) {
        super(r100, r101);
    }
}
