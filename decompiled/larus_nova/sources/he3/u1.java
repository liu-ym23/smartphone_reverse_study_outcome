package he3;

import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lhe3/u1;", "", "", SalesInfoStruct.SALES, "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "", "sealDesc", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "totalSales", "getTotalSales", "campaignSales", "getCampaignSales", "", "saleDescList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u1 {

    @SerializedName("campaign_sales")
    private final Integer campaignSales;

    @SerializedName("sale_desc_list")
    private final List<String> saleDescList;

    @SerializedName(SalesInfoStruct.SALES)
    private final Integer sales;

    @SerializedName("sale_desc")
    private final String sealDesc;

    @SerializedName("total_sales")
    private final Integer totalSales;

    public u1() {
        this.sales = null;
        this.sealDesc = null;
        this.totalSales = null;
        this.campaignSales = null;
        this.saleDescList = null;
    }

    public final List<String> a() {
        return this.saleDescList;
    }

    public final Integer b() {
        return this.sales;
    }

    public final String c() {
        return this.sealDesc;
    }
}
