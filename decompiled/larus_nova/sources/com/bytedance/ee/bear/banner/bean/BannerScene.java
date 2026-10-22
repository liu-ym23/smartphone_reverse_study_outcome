package com.bytedance.ee.bear.banner.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/banner/bean/BannerScene;", "", "reachId", "", "scenarioId", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getReachId", "()Ljava/lang/String;", "getScenarioId", "COMMON", "TEMPLATE", "BITABLE_LANDING", "features-banner-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BannerScene extends Enum<BannerScene> {
    public static final BannerScene BITABLE_LANDING = null;
    public static final BannerScene COMMON = null;
    public static final BannerScene TEMPLATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BannerScene[] f206455a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f206456b = null;
    private final String reachId;
    private final String scenarioId;

    public static EnumEntries<BannerScene> getEntries() {
        return f206456b;
    }

    static {
        BannerScene r100 = new BannerScene("COMMON", 0, "RP_CCM-HOME_TOP", "SCENE_COMMON");
        COMMON = r100;
        BannerScene r101 = new BannerScene("TEMPLATE", 1, "RP_CCM_TEMPLATE", "SCENE_CCM_TEMPLATE");
        TEMPLATE = r101;
        BannerScene r102 = new BannerScene("BITABLE_LANDING", 2, "RP_BITABLE_HOME_TOP", "SCENE_BITABLE_COMMON");
        BITABLE_LANDING = r102;
        BannerScene[] r103 = {r100, r101, r102};
        f206455a = r103;
        f206456b = EnumEntriesKt.enumEntries(r103);
    }

    public static BannerScene[] values() {
        return (BannerScene[]) f206455a.clone();
    }

    public final String getReachId() {
        return this.reachId;
    }

    public final String getScenarioId() {
        return this.scenarioId;
    }

    public static BannerScene valueOf(String r100) {
        return (BannerScene) a.a(BannerScene.class, r100);
    }

    public BannerScene(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.reachId = r102;
        this.scenarioId = r103;
    }
}
