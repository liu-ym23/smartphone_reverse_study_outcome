package com.larus.im.bean;

import com.larus.platform.model.NotificationBusiness;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/larus/im/bean/InAppBannerScene;", "", "scene", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getScene", "()Ljava/lang/String;", "GENERAL_BANNER", "CREDIT_POINT", "AI_PPT", "O_LIVE_ISLAND", "FEEDBACK_POPUP", "ADVANCE_LIMIT_REMINDER", "USER_EQUITY_CHANGED", "PC_GUIDE_RESOURCE", "OFFICE_TASK_ASK_HUMAN", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InAppBannerScene extends Enum<InAppBannerScene> {
    public static final InAppBannerScene ADVANCE_LIMIT_REMINDER = null;
    public static final InAppBannerScene AI_PPT = null;
    public static final InAppBannerScene CREDIT_POINT = null;
    public static final InAppBannerScene FEEDBACK_POPUP = null;
    public static final InAppBannerScene GENERAL_BANNER = null;
    public static final InAppBannerScene OFFICE_TASK_ASK_HUMAN = null;
    public static final InAppBannerScene O_LIVE_ISLAND = null;
    public static final InAppBannerScene PC_GUIDE_RESOURCE = null;
    public static final InAppBannerScene USER_EQUITY_CHANGED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InAppBannerScene[] f346413a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f346414b = null;
    private final String scene;

    public static EnumEntries<InAppBannerScene> getEntries() {
        return f346414b;
    }

    static {
        InAppBannerScene r100 = new InAppBannerScene("GENERAL_BANNER", 0, "general_banner");
        GENERAL_BANNER = r100;
        InAppBannerScene r101 = new InAppBannerScene("CREDIT_POINT", 1, "credit_point");
        CREDIT_POINT = r101;
        InAppBannerScene r102 = new InAppBannerScene("AI_PPT", 2, "ai_ppt");
        AI_PPT = r102;
        InAppBannerScene r103 = new InAppBannerScene("O_LIVE_ISLAND", 3, "o_live_island");
        O_LIVE_ISLAND = r103;
        InAppBannerScene r104 = new InAppBannerScene("FEEDBACK_POPUP", 4, "feedback_popup");
        FEEDBACK_POPUP = r104;
        InAppBannerScene r105 = new InAppBannerScene("ADVANCE_LIMIT_REMINDER", 5, "advance_limit_reminder");
        ADVANCE_LIMIT_REMINDER = r105;
        InAppBannerScene r110 = new InAppBannerScene("USER_EQUITY_CHANGED", 6, "user_equity_changed");
        USER_EQUITY_CHANGED = r110;
        InAppBannerScene r111 = new InAppBannerScene("PC_GUIDE_RESOURCE", 7, "pc_guide_resource");
        PC_GUIDE_RESOURCE = r111;
        InAppBannerScene r112 = new InAppBannerScene("OFFICE_TASK_ASK_HUMAN", 8, NotificationBusiness.OFFICE_TASK_ASK_HUMAN);
        OFFICE_TASK_ASK_HUMAN = r112;
        InAppBannerScene[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f346413a = r113;
        f346414b = EnumEntriesKt.enumEntries(r113);
    }

    public static InAppBannerScene[] values() {
        return (InAppBannerScene[]) f346413a.clone();
    }

    public final String getScene() {
        return this.scene;
    }

    public static InAppBannerScene valueOf(String r100) {
        return (InAppBannerScene) a.a(InAppBannerScene.class, r100);
    }

    public InAppBannerScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.scene = r102;
    }
}
