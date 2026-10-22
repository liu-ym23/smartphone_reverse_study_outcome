package com.bytedance.locallife.biz.perf;

import com.bytedance.ai.api.navi.AppletNaviType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/biz/perf/PageEnum;", "", "", "page", "Ljava/lang/String;", "MALL", "POI", "GOODS_DETAIL", "CONFIRM_ORDER_PAGE", "TRADE_ORDER_DETAIL", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3})
public final enum PageEnum extends Enum<PageEnum> {
    public static final PageEnum CONFIRM_ORDER_PAGE = null;
    public static final PageEnum GOODS_DETAIL = null;
    public static final PageEnum MALL = null;
    public static final PageEnum POI = null;
    public static final PageEnum TRADE_ORDER_DETAIL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PageEnum[] f256828a = null;
    public final String page;

    public static PageEnum valueOf(String r100) {
        return (PageEnum) r27.a.a(PageEnum.class, r100);
    }

    public static PageEnum[] values() {
        return (PageEnum[]) f256828a.clone();
    }

    static {
        PageEnum r100 = new PageEnum("MALL", 0, "mall");
        MALL = r100;
        PageEnum r101 = new PageEnum("POI", 1, AppletNaviType.POI);
        POI = r101;
        PageEnum r102 = new PageEnum("GOODS_DETAIL", 2, "goodsDetail");
        GOODS_DETAIL = r102;
        PageEnum r103 = new PageEnum("CONFIRM_ORDER_PAGE", 3, "confirmOrderPage");
        CONFIRM_ORDER_PAGE = r103;
        PageEnum r104 = new PageEnum("TRADE_ORDER_DETAIL", 4, "tradeOrderDetail");
        TRADE_ORDER_DETAIL = r104;
        f256828a = new PageEnum[]{r100, r101, r102, r103, r104};
    }

    public PageEnum(String r100, int r101, String r102) {
        super(r100, r101);
        this.page = r102;
    }
}
