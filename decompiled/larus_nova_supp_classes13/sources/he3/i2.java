package he3;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087D¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006¨\u0006\u001f"}, d2 = {"Lhe3/i2;", "", "", "reqId", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "token", "getToken", "creativeId", "a", "adId", "getAdId", "roomId", "getRoomId", "bizTag", "getBizTag", "", "fromSaas", "Ljava/lang/Boolean;", "getFromSaas", "()Ljava/lang/Boolean;", "", "productId", "Ljava/lang/Long;", "getProductId", "()Ljava/lang/Long;", "productIdStr", "getProductIdStr", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i2 {

    @SerializedName("ad_id")
    private final String adId;

    @SerializedName("biz_tag")
    private final String bizTag;

    @SerializedName("cid")
    private final String creativeId;

    @SerializedName("from_saas")
    private final Boolean fromSaas;

    @SerializedName(PdpOpenThirdParam.KEY_PRODUCT_ID)
    private final Long productId;

    @SerializedName("product_id_str")
    private final String productIdStr;

    @SerializedName("req_id")
    private final String reqId;

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName("token")
    private final String token;

    public i2() {
        this.productId = 0L;
    }

    public final String a() {
        return this.creativeId;
    }

    public final String b() {
        return this.reqId;
    }
}
