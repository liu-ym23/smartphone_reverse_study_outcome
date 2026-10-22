package yw6;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lyw6/q;", "", "", "productId", "Ljava/lang/String;", "getProductId", "()Ljava/lang/String;", "", "clickType", "Ljava/lang/Integer;", "getClickType", "()Ljava/lang/Integer;", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class q {

    @SerializedName("click_type")
    private final Integer clickType;

    @SerializedName("product_id")
    private final String productId;

    public q() {
        this(null, null);
    }

    public q(String r100, Integer r101) {
        this.productId = r100;
        this.clickType = r101;
    }
}
