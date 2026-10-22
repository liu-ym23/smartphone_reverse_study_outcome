package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.StockEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class q implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f563996a = null;

    static {
        f563996a = new q();
    }

    public q() {
    }

    @Override // xia.c
    public final int a(AppEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        if ((r100 instanceof StockEntity) == false) goto L111;
        StockEntity r101 = (StockEntity) r100;
        int r102 = r101.getName().hashCode() + 0;
        String r103 = r101.getCurrentPrice();
        if (r103 == null) goto L7;
        r102 = (r102 * 31) + r103.hashCode();
    L7:
        String r104 = r101.getHighestPrice();
        if (r104 == null) goto L10;
        r102 = (r102 * 31) + r104.hashCode();
    L10:
        String r105 = r101.getLowestPrice();
        if (r105 == null) goto L13;
        r102 = (r102 * 31) + r105.hashCode();
    L13:
        String r106 = r101.getTradingVolume();
        if (r106 == null) goto L16;
        r102 = (r102 * 31) + r106.hashCode();
    L16:
        String r107 = r101.getTradingValue();
        if (r107 == null) goto L19;
        r102 = (r102 * 31) + r107.hashCode();
    L19:
        String r108 = r101.getPriceChangeToday();
        if (r108 == null) goto L22;
        r102 = (r102 * 31) + r108.hashCode();
    L22:
        String r109 = r101.getPriceChangePercentageToday();
        if (r109 == null) goto L25;
        r102 = (r102 * 31) + r109.hashCode();
    L25:
        String r110 = r101.getOpeningPriceToday();
        if (r110 == null) goto L28;
        r102 = (r102 * 31) + r110.hashCode();
    L28:
        String r111 = r101.getClosingPriceToday();
        if (r111 == null) goto L31;
        r102 = (r102 * 31) + r111.hashCode();
    L31:
        String r112 = r101.getNetProfitToShareholders();
        if (r112 == null) goto L34;
        r102 = (r102 * 31) + r112.hashCode();
    L34:
        String r113 = r101.getOperatingIncome();
        if (r113 == null) goto L37;
        r102 = (r102 * 31) + r113.hashCode();
    L37:
        String r114 = r101.getBasicEarningsPerShare();
        if (r114 == null) goto L40;
        r102 = (r102 * 31) + r114.hashCode();
    L40:
        String r115 = r101.getNetAssetsPerShare();
        if (r115 == null) goto L43;
        r102 = (r102 * 31) + r115.hashCode();
    L43:
        String r116 = r101.getGrossProfitMargin();
        if (r116 == null) goto L46;
        r102 = (r102 * 31) + r116.hashCode();
    L46:
        String r117 = r101.getNetProfitMargin();
        if (r117 == null) goto L49;
        r102 = (r102 * 31) + r117.hashCode();
    L49:
        String r118 = r101.getReturnOnEquity();
        if (r118 == null) goto L52;
        r102 = (r102 * 31) + r118.hashCode();
    L52:
        String r119 = r101.getDebtToAssetsRatio();
        if (r119 == null) goto L55;
        r102 = (r102 * 31) + r119.hashCode();
    L55:
        String r120 = r101.getGrossProfit();
        if (r120 == null) goto L58;
        r102 = (r102 * 31) + r120.hashCode();
    L58:
        String r121 = r101.getOperatingProfit();
        if (r121 == null) goto L61;
        r102 = (r102 * 31) + r121.hashCode();
    L61:
        String r122 = r101.getProfitAfterTax();
        if (r122 == null) goto L64;
        r102 = (r102 * 31) + r122.hashCode();
    L64:
        String r123 = r101.getTotalCurrentAssets();
        if (r123 == null) goto L67;
        r102 = (r102 * 31) + r123.hashCode();
    L67:
        String r124 = r101.getTotalNonCurrentAssets();
        if (r124 == null) goto L70;
        r102 = (r102 * 31) + r124.hashCode();
    L70:
        String r125 = r101.getTotalAssets();
        if (r125 == null) goto L73;
        r102 = (r102 * 31) + r125.hashCode();
    L73:
        String r126 = r101.getTotalCurrentLiabilities();
        if (r126 == null) goto L76;
        r102 = (r102 * 31) + r126.hashCode();
    L76:
        String r127 = r101.getTotalNonCurrentLiabilities();
        if (r127 == null) goto L79;
        r102 = (r102 * 31) + r127.hashCode();
    L79:
        String r128 = r101.getTotalLiabilities();
        if (r128 == null) goto L82;
        r102 = (r102 * 31) + r128.hashCode();
    L82:
        String r129 = r101.getShareholdersEquity();
        if (r129 == null) goto L85;
        r102 = (r102 * 31) + r129.hashCode();
    L85:
        String r130 = r101.getTotalEquity();
        if (r130 == null) goto L88;
        r102 = (r102 * 31) + r130.hashCode();
    L88:
        String r131 = r101.getNetCashFlowFromOperatingActivities();
        if (r131 == null) goto L91;
        r102 = (r102 * 31) + r131.hashCode();
    L91:
        String r132 = r101.getNetCashFlowFromInvestingActivities();
        if (r132 == null) goto L94;
        r102 = (r102 * 31) + r132.hashCode();
    L94:
        String r133 = r101.getNetCashFlowFromFinancingActivities();
        if (r133 == null) goto L97;
        r102 = (r102 * 31) + r133.hashCode();
    L97:
        String r134 = r101.getNetCash();
        if (r134 == null) goto L100;
        r102 = (r102 * 31) + r134.hashCode();
    L100:
        String r135 = r101.getCashAtEndOfPeriod();
        if (r135 == null) goto L103;
        r102 = (r102 * 31) + r135.hashCode();
    L103:
        String r136 = r101.getMarket();
        if (r136 == null) goto L106;
        r102 = (r102 * 31) + r136.hashCode();
    L106:
        String r137 = r101.getMarketStatus();
        if (r137 != null) goto L109;
        return r102;
    L109:
        return (r102 * 31) + r137.hashCode();
    L111:
        throw new IllegalStateException("Check failed.".toString());
    }
}
