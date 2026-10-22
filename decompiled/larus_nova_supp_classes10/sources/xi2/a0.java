package xi2;

import com.bytedance.android.livesdk.livecommerce.network.response.ECPublicBottomScreenDataType;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPublicBottomScreenProduct;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lxi2/a0;", "Lcom/bytedance/android/ec/model/g;", "", "dataType", "I", "getDataType", "()I", "setDataType", "(I)V", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPublicBottomScreenProduct;", "product", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPublicBottomScreenProduct;", "a", "()Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPublicBottomScreenProduct;", "setProduct", "(Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPublicBottomScreenProduct;)V", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a0 extends com.bytedance.android.ec.model.g {

    @SerializedName("data_type")
    private int dataType;

    @SerializedName("product")
    private ECPublicBottomScreenProduct product;

    public a0() {
        this.dataType = ECPublicBottomScreenDataType.PRODUCT.getType();
    }

    public final ECPublicBottomScreenProduct a() {
        return this.product;
    }
}
