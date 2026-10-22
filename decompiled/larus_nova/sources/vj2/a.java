package vj2;

import com.bytedance.android.ec.model.g;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.ec.model.response.w;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\bR(\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\bR(\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\bR\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0087D¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lvj2/a;", "Lcom/bytedance/android/ec/model/g;", "", "", "Lcom/bytedance/android/ec/model/response/ECPromotion;", "promotions", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "Lcom/bytedance/android/ec/model/response/w;", "promotionsV2", "d", "products", "getProducts", "productsV2", "b", "topPromotions", "e", "", "serverTime", "J", "getServerTime", "()J", "apiLogId", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a extends g {

    @SerializedName("log_id")
    private final String apiLogId;

    @SerializedName("products")
    private final Map<String, ECPromotion> products;

    @SerializedName("products_v2")
    private final Map<String, w> productsV2;

    @SerializedName("promotions")
    private final Map<String, ECPromotion> promotions;

    @SerializedName("promotions_v2")
    private final Map<String, w> promotionsV2;

    @SerializedName("server_time")
    private final long serverTime;

    @SerializedName("top_promotions")
    private final Map<String, w> topPromotions;

    public a() {
    }

    public final String a() {
        return this.apiLogId;
    }

    public final Map<String, w> b() {
        return this.productsV2;
    }

    public final Map<String, ECPromotion> c() {
        return this.promotions;
    }

    public final Map<String, w> d() {
        return this.promotionsV2;
    }

    public final Map<String, w> e() {
        return this.topPromotions;
    }
}
