package com.bytedance.ee.bear.list.homepage.banner;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@AppConfig(key = "ccm_base_homepage")
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR\u001c\u0010.\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\t¨\u00061"}, d2 = {"Lcom/bytedance/ee/bear/list/homepage/banner/BitableBannerConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "bannerTitle", "", "getBannerTitle", "()Ljava/lang/String;", "setBannerTitle", "(Ljava/lang/String;)V", "cards", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/list/homepage/banner/BannerCardInfo;", "Lkotlin/collections/ArrayList;", "getCards", "()Ljava/util/ArrayList;", "setCards", "(Ljava/util/ArrayList;)V", "moreBtn", "Lcom/bytedance/ee/bear/list/homepage/banner/MoreButton;", "getMoreBtn", "()Lcom/bytedance/ee/bear/list/homepage/banner/MoreButton;", "setMoreBtn", "(Lcom/bytedance/ee/bear/list/homepage/banner/MoreButton;)V", "newFormTemplate", "Lcom/bytedance/ee/bear/list/homepage/banner/TemplatesItem;", "getNewFormTemplate", "()Lcom/bytedance/ee/bear/list/homepage/banner/TemplatesItem;", "setNewFormTemplate", "(Lcom/bytedance/ee/bear/list/homepage/banner/TemplatesItem;)V", "activityFetchInterval", "", "getActivityFetchInterval", "()Ljava/lang/Long;", "setActivityFetchInterval", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "activityEmptyConfig", "Lcom/bytedance/ee/bear/list/homepage/banner/ActivityEmptyConfig;", "getActivityEmptyConfig", "()Lcom/bytedance/ee/bear/list/homepage/banner/ActivityEmptyConfig;", "setActivityEmptyConfig", "(Lcom/bytedance/ee/bear/list/homepage/banner/ActivityEmptyConfig;)V", "homePageLeftTabTitle", "getHomePageLeftTabTitle", "setHomePageLeftTabTitle", "homePageRightTabTitle", "getHomePageRightTabTitle", "setHomePageRightTabTitle", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableBannerConfig implements NonProguard {
    private ActivityEmptyConfig activityEmptyConfig;
    private Long activityFetchInterval;
    private String bannerTitle;
    private ArrayList<BannerCardInfo> cards;
    private String homePageLeftTabTitle;
    private String homePageRightTabTitle;
    private MoreButton moreBtn;
    private TemplatesItem newFormTemplate;

    public BitableBannerConfig() {
    }

    public final ActivityEmptyConfig getActivityEmptyConfig() {
        return this.activityEmptyConfig;
    }

    public final Long getActivityFetchInterval() {
        return this.activityFetchInterval;
    }

    public final String getBannerTitle() {
        return this.bannerTitle;
    }

    public final ArrayList<BannerCardInfo> getCards() {
        return this.cards;
    }

    public final String getHomePageLeftTabTitle() {
        return this.homePageLeftTabTitle;
    }

    public final String getHomePageRightTabTitle() {
        return this.homePageRightTabTitle;
    }

    public final MoreButton getMoreBtn() {
        return this.moreBtn;
    }

    public final TemplatesItem getNewFormTemplate() {
        return this.newFormTemplate;
    }

    public final void setActivityEmptyConfig(ActivityEmptyConfig r1) {
        this.activityEmptyConfig = r1;
    }

    public final void setActivityFetchInterval(Long r1) {
        this.activityFetchInterval = r1;
    }

    public final void setBannerTitle(String r1) {
        this.bannerTitle = r1;
    }

    public final void setCards(ArrayList<BannerCardInfo> r1) {
        this.cards = r1;
    }

    public final void setHomePageLeftTabTitle(String r1) {
        this.homePageLeftTabTitle = r1;
    }

    public final void setHomePageRightTabTitle(String r1) {
        this.homePageRightTabTitle = r1;
    }

    public final void setMoreBtn(MoreButton r1) {
        this.moreBtn = r1;
    }

    public final void setNewFormTemplate(TemplatesItem r1) {
        this.newFormTemplate = r1;
    }
}
