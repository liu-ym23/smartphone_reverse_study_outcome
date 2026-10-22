package th3;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R*\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lth3/a;", "", "", "productId", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "comboId", "d", "comboNum", "e", "extra", "f", "channelId", "b", "", "channelType", "I", "c", "()I", "bcmChain", "a", "foodTakeoutCustomPropertyList", "g", "foodTakeoutSalePackageList", "h", "", "extraParamsMap", "Ljava/util/Map;", "getExtraParamsMap", "()Ljava/util/Map;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("bcm_chain")
    private final String bcmChain;

    @SerializedName("product_channel_id")
    private final String channelId;

    @SerializedName("product_channel_type")
    private final int channelType;

    @SerializedName("combo_id")
    private final String comboId;

    @SerializedName("combo_num")
    private final String comboNum;

    @SerializedName("extra")
    private final String extra;

    @SerializedName("extra_params_map")
    private final Map<String, Object> extraParamsMap;

    @SerializedName("custom_property_list")
    private final String foodTakeoutCustomPropertyList;

    @SerializedName("sale_package_list")
    private final String foodTakeoutSalePackageList;

    @SerializedName(PdpOpenThirdParam.KEY_PRODUCT_ID)
    private final String productId;

    public a() {
        throw null;
    }

    public final String a() {
        return this.bcmChain;
    }

    public final String b() {
        return this.channelId;
    }

    public final int c() {
        return this.channelType;
    }

    public final String d() {
        return this.comboId;
    }

    public final String e() {
        return this.comboNum;
    }

    public final String f() {
        return this.extra;
    }

    public final String g() {
        return this.foodTakeoutCustomPropertyList;
    }

    public final String h() {
        return this.foodTakeoutSalePackageList;
    }

    public final String i() {
        return this.productId;
    }

    public a(String r2, String r3, String r4, String r5, String r6, int r7, String r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r2, "productId");
        Intrinsics.checkNotNullParameter(r3, "comboId");
        Intrinsics.checkNotNullParameter(r4, "comboNum");
        Intrinsics.checkNotNullParameter(r5, "extra");
        Intrinsics.checkNotNullParameter(r6, "channelId");
        this.productId = r2;
        this.comboId = r3;
        this.comboNum = r4;
        this.extra = r5;
        this.channelId = r6;
        this.channelType = r7;
        this.bcmChain = r8;
        this.foodTakeoutCustomPropertyList = r9;
        this.foodTakeoutSalePackageList = r10;
        this.extraParamsMap = null;
    }
}
