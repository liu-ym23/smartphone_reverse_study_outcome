package he3;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u0018R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0018R\"\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lhe3/p1;", "", "", "originalPrice", "Ljava/lang/Integer;", "getOriginalPrice", "()Ljava/lang/Integer;", "minPrice", "c", "maxPrice", "getMaxPrice", "marketPrice", "getMarketPrice", "Lhe3/o1;", "minPriceDesc", "Lhe3/o1;", "d", "()Lhe3/o1;", "hotSalePrice", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "hotSaleSkuId", "Ljava/lang/String;", "getHotSaleSkuId", "()Ljava/lang/String;", "hotSalePriceDesc", "b", "showPrice", "getShowPrice", "showSkuId", "getShowSkuId", "showPriceType", "getShowPriceType", "", "Lhe3/c1;", "priceSuffixList", "Ljava/util/List;", "e", "()Ljava/util/List;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p1 {

    @SerializedName("hot_sale_price")
    private final Integer hotSalePrice;

    @SerializedName("hot_sale_price_desc")
    private final o1 hotSalePriceDesc;

    @SerializedName("hot_sale_sku_id")
    private final String hotSaleSkuId;

    @SerializedName("market_price")
    private final Integer marketPrice;

    @SerializedName("max_price")
    private final Integer maxPrice;

    @SerializedName("min_price")
    private final Integer minPrice;

    @SerializedName("min_price_desc")
    private final o1 minPriceDesc;

    @SerializedName(BdpAppEventConstant.PARAMS_ORIGINAL_PRICE)
    private final Integer originalPrice;

    @SerializedName("price_suffix_list")
    private final List<c1> priceSuffixList;

    @SerializedName("show_price")
    private final Integer showPrice;

    @SerializedName("show_price_type")
    private final String showPriceType;

    @SerializedName("show_sku_id")
    private final String showSkuId;

    public p1() {
    }

    public final Integer a() {
        return this.hotSalePrice;
    }

    public final o1 b() {
        return this.hotSalePriceDesc;
    }

    public final Integer c() {
        return this.minPrice;
    }

    public final o1 d() {
        return this.minPriceDesc;
    }

    public final List<c1> e() {
        return this.priceSuffixList;
    }
}
