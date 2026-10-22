package he3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lhe3/k2;", "", "", "shopId", "Ljava/lang/String;", "getShopId", "()Ljava/lang/String;", "secShopId", "getSecShopId", "bindAuthorId", "getBindAuthorId", "secBindAuthorId", "getSecBindAuthorId", "shopName", "c", "setShopName", "(Ljava/lang/String;)V", "shopLink", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/ec/model/ECUrlModel;", "shopLogo", "Lcom/bytedance/android/ec/model/ECUrlModel;", "b", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setShopLogo", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k2 {

    @SerializedName("bind_author_id")
    private final String bindAuthorId;

    @SerializedName("sec_bind_author_id")
    private final String secBindAuthorId;

    @SerializedName("sec_shop_id")
    private final String secShopId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID)
    private final String shopId;

    @SerializedName("shop_link")
    private final String shopLink;

    @SerializedName("shop_logo")
    private ECUrlModel shopLogo;

    @SerializedName("shop_name")
    private String shopName;

    public k2() {
    }

    public final String a() {
        return this.shopLink;
    }

    public final ECUrlModel b() {
        return this.shopLogo;
    }

    public final String c() {
        return this.shopName;
    }
}
