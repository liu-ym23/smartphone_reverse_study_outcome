package com.bytedance.ies.argus.api.params;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/argus/api/params/WebLoadPageType;", "", "", "strValue", "Ljava/lang/String;", "getStrValue", "()Ljava/lang/String;", "WHITE_INNER", "GREY_SEC_LINK", "GREY_INNER", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum WebLoadPageType extends Enum<WebLoadPageType> {
    public static final WebLoadPageType GREY_INNER = null;
    public static final WebLoadPageType GREY_SEC_LINK = null;
    public static final WebLoadPageType WHITE_INNER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WebLoadPageType[] f245697a = null;
    private final String strValue;

    public static WebLoadPageType valueOf(String r100) {
        return (WebLoadPageType) r27.a.a(WebLoadPageType.class, r100);
    }

    public static WebLoadPageType[] values() {
        return (WebLoadPageType[]) f245697a.clone();
    }

    static {
        WebLoadPageType r100 = new WebLoadPageType("WHITE_INNER", 0, "white_inner");
        WHITE_INNER = r100;
        WebLoadPageType r101 = new WebLoadPageType("GREY_SEC_LINK", 1, "grey_secLink");
        GREY_SEC_LINK = r101;
        WebLoadPageType r102 = new WebLoadPageType("GREY_INNER", 2, "grey_inner");
        GREY_INNER = r102;
        f245697a = new WebLoadPageType[]{r100, r101, r102};
    }

    public final String getStrValue() {
        return this.strValue;
    }

    public WebLoadPageType(String r100, int r101, String r102) {
        super(r100, r101);
        this.strValue = r102;
    }
}
