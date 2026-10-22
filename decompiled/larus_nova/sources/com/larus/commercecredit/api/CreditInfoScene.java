package com.larus.commercecredit.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/commercecredit/api/CreditInfoScene;", "", "scene", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getScene", "()Ljava/lang/String;", "COMMERCE_CREDIT_INFO_PANEL", "COMMERCE_CREDIT_INFO_PANEL_RETRY", "COMMERCE_CREDIT_INFO_PANEL_CLICK_MOBILE_ACTIVITY", "COMMERCE_CREDIT_SIDEBAR_PROFILE", "COMMERCE_CREDIT_DEFAULT_PROFILE", "COMMERCE_CREDIT_SETTING", "COMMERCE_CREDIT_MESSAGE_RECEIVED", "COMMERCE_CREDIT_MESSAGE_STREAM_END", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CreditInfoScene extends Enum<CreditInfoScene> {
    public static final CreditInfoScene COMMERCE_CREDIT_DEFAULT_PROFILE = null;
    public static final CreditInfoScene COMMERCE_CREDIT_INFO_PANEL = null;
    public static final CreditInfoScene COMMERCE_CREDIT_INFO_PANEL_CLICK_MOBILE_ACTIVITY = null;
    public static final CreditInfoScene COMMERCE_CREDIT_INFO_PANEL_RETRY = null;
    public static final CreditInfoScene COMMERCE_CREDIT_MESSAGE_RECEIVED = null;
    public static final CreditInfoScene COMMERCE_CREDIT_MESSAGE_STREAM_END = null;
    public static final CreditInfoScene COMMERCE_CREDIT_SETTING = null;
    public static final CreditInfoScene COMMERCE_CREDIT_SIDEBAR_PROFILE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CreditInfoScene[] f325665a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f325666b = null;
    private final String scene;

    public static EnumEntries<CreditInfoScene> getEntries() {
        return f325666b;
    }

    static {
        CreditInfoScene r100 = new CreditInfoScene("COMMERCE_CREDIT_INFO_PANEL", 0, "commerce_credit_info_panel");
        COMMERCE_CREDIT_INFO_PANEL = r100;
        CreditInfoScene r101 = new CreditInfoScene("COMMERCE_CREDIT_INFO_PANEL_RETRY", 1, "commerce_credit_info_panel_retry");
        COMMERCE_CREDIT_INFO_PANEL_RETRY = r101;
        CreditInfoScene r102 = new CreditInfoScene("COMMERCE_CREDIT_INFO_PANEL_CLICK_MOBILE_ACTIVITY", 2, "commerce_credit_info_panel_click_mobile_activity");
        COMMERCE_CREDIT_INFO_PANEL_CLICK_MOBILE_ACTIVITY = r102;
        CreditInfoScene r103 = new CreditInfoScene("COMMERCE_CREDIT_SIDEBAR_PROFILE", 3, "commerce_credit_sidebar_profile");
        COMMERCE_CREDIT_SIDEBAR_PROFILE = r103;
        CreditInfoScene r104 = new CreditInfoScene("COMMERCE_CREDIT_DEFAULT_PROFILE", 4, "commerce_credit_default_profile");
        COMMERCE_CREDIT_DEFAULT_PROFILE = r104;
        CreditInfoScene r105 = new CreditInfoScene("COMMERCE_CREDIT_SETTING", 5, "commerce_credit_setting");
        COMMERCE_CREDIT_SETTING = r105;
        CreditInfoScene r110 = new CreditInfoScene("COMMERCE_CREDIT_MESSAGE_RECEIVED", 6, "commerce_credit_message_received");
        COMMERCE_CREDIT_MESSAGE_RECEIVED = r110;
        CreditInfoScene r111 = new CreditInfoScene("COMMERCE_CREDIT_MESSAGE_STREAM_END", 7, "commerce_credit_message_stream_end");
        COMMERCE_CREDIT_MESSAGE_STREAM_END = r111;
        CreditInfoScene[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f325665a = r112;
        f325666b = EnumEntriesKt.enumEntries(r112);
    }

    public static CreditInfoScene[] values() {
        return (CreditInfoScene[]) f325665a.clone();
    }

    public final String getScene() {
        return this.scene;
    }

    public static CreditInfoScene valueOf(String r100) {
        return (CreditInfoScene) a.a(CreditInfoScene.class, r100);
    }

    public CreditInfoScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.scene = r102;
    }
}
