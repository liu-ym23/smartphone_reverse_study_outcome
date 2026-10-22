package com.ss.android.ugc.aweme.poi.bean;

import com.bytedance.ai.api.navi.AppletNaviType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/bean/DetailEnterPage;", "", "", "detailEnterPage", "Ljava/lang/String;", "POI", "LIVE", "GOODSDETAIL", "SEARCH", "LIFE_CARD_FEED", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final enum DetailEnterPage extends Enum<DetailEnterPage> {
    public static final DetailEnterPage GOODSDETAIL = null;
    public static final DetailEnterPage LIFE_CARD_FEED = null;
    public static final DetailEnterPage LIVE = null;
    public static final DetailEnterPage POI = null;
    public static final DetailEnterPage SEARCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DetailEnterPage[] f451305a = null;
    public final String detailEnterPage;

    public static DetailEnterPage valueOf(String r100) {
        return (DetailEnterPage) a.a(DetailEnterPage.class, r100);
    }

    public static DetailEnterPage[] values() {
        return (DetailEnterPage[]) f451305a.clone();
    }

    static {
        DetailEnterPage r100 = new DetailEnterPage("POI", 0, AppletNaviType.POI);
        POI = r100;
        DetailEnterPage r101 = new DetailEnterPage("LIVE", 1, "livebroadcasting");
        LIVE = r101;
        DetailEnterPage r102 = new DetailEnterPage("GOODSDETAIL", 2, "project_detail_page");
        GOODSDETAIL = r102;
        DetailEnterPage r103 = new DetailEnterPage("SEARCH", 3, "search");
        SEARCH = r103;
        DetailEnterPage r104 = new DetailEnterPage("LIFE_CARD_FEED", 4, "life_card_feed");
        LIFE_CARD_FEED = r104;
        f451305a = new DetailEnterPage[]{r100, r101, r102, r103, r104};
    }

    public DetailEnterPage(String r100, int r101, String r102) {
        super(r100, r101);
        this.detailEnterPage = r102;
    }
}
