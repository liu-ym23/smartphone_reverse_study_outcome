package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusWebLoadVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/o;", "", "code", "I", "getCode", "()I", "", "strValue", "Ljava/lang/String;", "getStrValue", "()Ljava/lang/String;", "BLACK_PROTOCOL", "BLACK_URL_REG", "HIT_SEC_LINK_SCENE", "FORCE_TO_HTTPS", "WHITE_URL", "ALREADY_SEC_LINK_PAGE", "REWRITE_BY_SEC_LINK", "PASS_BY_SEC_LINK_SERVER", "HAS_TRIGGER_CHECK", "REDIRECT_LAST_URL_IS_SEC_LINK_PAGE", "RELOAD_SEC_URL", "REDIRECT_REWRITE_URL", "NO_SEC_LINK_SCENE", "URL_ALREADY_CHECKED", "SKIP_VERIFY_PROTOCOL", "SEC_LINK_HANDLER_IS_NULL", "SEC_LINK_VERIFY_MODE_NOT_ENABLE", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusWebLoadVerifyReason extends Enum<ArgusWebLoadVerifyReason> implements o {
    public static final ArgusWebLoadVerifyReason ALREADY_SEC_LINK_PAGE = null;
    public static final ArgusWebLoadVerifyReason BLACK_PROTOCOL = null;
    public static final ArgusWebLoadVerifyReason BLACK_URL_REG = null;
    public static final ArgusWebLoadVerifyReason FORCE_TO_HTTPS = null;
    public static final ArgusWebLoadVerifyReason HAS_TRIGGER_CHECK = null;
    public static final ArgusWebLoadVerifyReason HIT_SEC_LINK_SCENE = null;
    public static final ArgusWebLoadVerifyReason NO_SEC_LINK_SCENE = null;
    public static final ArgusWebLoadVerifyReason PASS_BY_SEC_LINK_SERVER = null;
    public static final ArgusWebLoadVerifyReason REDIRECT_LAST_URL_IS_SEC_LINK_PAGE = null;
    public static final ArgusWebLoadVerifyReason REDIRECT_REWRITE_URL = null;
    public static final ArgusWebLoadVerifyReason RELOAD_SEC_URL = null;
    public static final ArgusWebLoadVerifyReason REWRITE_BY_SEC_LINK = null;
    public static final ArgusWebLoadVerifyReason SEC_LINK_HANDLER_IS_NULL = null;
    public static final ArgusWebLoadVerifyReason SEC_LINK_VERIFY_MODE_NOT_ENABLE = null;
    public static final ArgusWebLoadVerifyReason SKIP_VERIFY_PROTOCOL = null;
    public static final ArgusWebLoadVerifyReason URL_ALREADY_CHECKED = null;
    public static final ArgusWebLoadVerifyReason WHITE_URL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusWebLoadVerifyReason[] f245979a = null;
    private final int code;
    private final String strValue;

    public static ArgusWebLoadVerifyReason valueOf(String r100) {
        return (ArgusWebLoadVerifyReason) r27.a.a(ArgusWebLoadVerifyReason.class, r100);
    }

    public static ArgusWebLoadVerifyReason[] values() {
        return (ArgusWebLoadVerifyReason[]) f245979a.clone();
    }

    static {
        ArgusWebLoadVerifyReason r100 = new ArgusWebLoadVerifyReason("BLACK_PROTOCOL", 0, -1, "hit black protocol");
        BLACK_PROTOCOL = r100;
        ArgusWebLoadVerifyReason r101 = new ArgusWebLoadVerifyReason("BLACK_URL_REG", 1, -2, "hit black url reg");
        BLACK_URL_REG = r101;
        ArgusWebLoadVerifyReason r102 = new ArgusWebLoadVerifyReason("HIT_SEC_LINK_SCENE", 2, -5, "container context's secLinkScene is");
        HIT_SEC_LINK_SCENE = r102;
        ArgusWebLoadVerifyReason r103 = new ArgusWebLoadVerifyReason("FORCE_TO_HTTPS", 3, -6, "domain in share cookie list and use http is forbidden");
        FORCE_TO_HTTPS = r103;
        ArgusWebLoadVerifyReason r104 = new ArgusWebLoadVerifyReason("WHITE_URL", 4, 1, "hit white url");
        WHITE_URL = r104;
        ArgusWebLoadVerifyReason r105 = new ArgusWebLoadVerifyReason("ALREADY_SEC_LINK_PAGE", 5, 2, "already secLink page");
        ALREADY_SEC_LINK_PAGE = r105;
        ArgusWebLoadVerifyReason r106 = new ArgusWebLoadVerifyReason("REWRITE_BY_SEC_LINK", 6, 3, "rewrite by secLink");
        REWRITE_BY_SEC_LINK = r106;
        ArgusWebLoadVerifyReason r110 = new ArgusWebLoadVerifyReason("PASS_BY_SEC_LINK_SERVER", 7, 4, "pass by secLink server");
        PASS_BY_SEC_LINK_SERVER = r110;
        ArgusWebLoadVerifyReason r111 = new ArgusWebLoadVerifyReason("HAS_TRIGGER_CHECK", 8, 5, "has triggered checked");
        HAS_TRIGGER_CHECK = r111;
        ArgusWebLoadVerifyReason r112 = new ArgusWebLoadVerifyReason("REDIRECT_LAST_URL_IS_SEC_LINK_PAGE", 9, 6, "last url is secLink page, has verified by server");
        REDIRECT_LAST_URL_IS_SEC_LINK_PAGE = r112;
        ArgusWebLoadVerifyReason r113 = new ArgusWebLoadVerifyReason("RELOAD_SEC_URL", 10, 7, "reload sec url");
        RELOAD_SEC_URL = r113;
        ArgusWebLoadVerifyReason r114 = new ArgusWebLoadVerifyReason("REDIRECT_REWRITE_URL", 11, 8, "redirect rewrite url, will trigger reload");
        REDIRECT_REWRITE_URL = r114;
        ArgusWebLoadVerifyReason r107 = new ArgusWebLoadVerifyReason("NO_SEC_LINK_SCENE", 12, 9, "no secLink scene");
        NO_SEC_LINK_SCENE = r107;
        ArgusWebLoadVerifyReason r108 = new ArgusWebLoadVerifyReason("URL_ALREADY_CHECKED", 13, 10, "url already checked");
        URL_ALREADY_CHECKED = r108;
        ArgusWebLoadVerifyReason r109 = new ArgusWebLoadVerifyReason("SKIP_VERIFY_PROTOCOL", 14, 11, "skip verify protocol");
        SKIP_VERIFY_PROTOCOL = r109;
        ArgusWebLoadVerifyReason r115 = new ArgusWebLoadVerifyReason("SEC_LINK_HANDLER_IS_NULL", 15, 1001, "secLinkHandler is null");
        SEC_LINK_HANDLER_IS_NULL = r115;
        ArgusWebLoadVerifyReason r116 = new ArgusWebLoadVerifyReason("SEC_LINK_VERIFY_MODE_NOT_ENABLE", 16, 1002, "secLinkVerifyMode not enable");
        SEC_LINK_VERIFY_MODE_NOT_ENABLE = r116;
        f245979a = new ArgusWebLoadVerifyReason[]{r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r107, r108, r109, r115, r116};
    }

    @Override // com.bytedance.ies.argus.bean.o
    public int getCode() {
        return this.code;
    }

    @Override // com.bytedance.ies.argus.bean.o
    public String getStrValue() {
        return this.strValue;
    }

    public ArgusWebLoadVerifyReason(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.strValue = r103;
    }
}
