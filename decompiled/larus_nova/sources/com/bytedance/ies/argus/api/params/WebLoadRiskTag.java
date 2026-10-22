package com.bytedance.ies.argus.api.params;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/argus/api/params/WebLoadRiskTag;", "", "", "strValue", "Ljava/lang/String;", "getStrValue", "()Ljava/lang/String;", "Default", "PassInnerDomain", "GreyInnerDomain", "PassPluginVerify", "ShowRiskUnknown", "ShowRiskGrey", "ShowRiskBlack", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum WebLoadRiskTag extends Enum<WebLoadRiskTag> {
    public static final WebLoadRiskTag Default = null;
    public static final WebLoadRiskTag GreyInnerDomain = null;
    public static final WebLoadRiskTag PassInnerDomain = null;
    public static final WebLoadRiskTag PassPluginVerify = null;
    public static final WebLoadRiskTag ShowRiskBlack = null;
    public static final WebLoadRiskTag ShowRiskGrey = null;
    public static final WebLoadRiskTag ShowRiskUnknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WebLoadRiskTag[] f245698a = null;
    private final String strValue;

    public static WebLoadRiskTag valueOf(String r100) {
        return (WebLoadRiskTag) r27.a.a(WebLoadRiskTag.class, r100);
    }

    public static WebLoadRiskTag[] values() {
        return (WebLoadRiskTag[]) f245698a.clone();
    }

    static {
        WebLoadRiskTag r100 = new WebLoadRiskTag("Default", 0, "default");
        Default = r100;
        WebLoadRiskTag r101 = new WebLoadRiskTag("PassInnerDomain", 1, "white_inner_list");
        PassInnerDomain = r101;
        WebLoadRiskTag r102 = new WebLoadRiskTag("GreyInnerDomain", 2, "grey_inner_list");
        GreyInnerDomain = r102;
        WebLoadRiskTag r103 = new WebLoadRiskTag("PassPluginVerify", 3, "risk_white_plugin");
        PassPluginVerify = r103;
        WebLoadRiskTag r104 = new WebLoadRiskTag("ShowRiskUnknown", 4, "risk_unknown");
        ShowRiskUnknown = r104;
        WebLoadRiskTag r105 = new WebLoadRiskTag("ShowRiskGrey", 5, "risk_grey");
        ShowRiskGrey = r105;
        WebLoadRiskTag r110 = new WebLoadRiskTag("ShowRiskBlack", 6, "risk_black");
        ShowRiskBlack = r110;
        f245698a = new WebLoadRiskTag[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public final String getStrValue() {
        return this.strValue;
    }

    public WebLoadRiskTag(String r100, int r101, String r102) {
        super(r100, r101);
        this.strValue = r102;
    }
}
