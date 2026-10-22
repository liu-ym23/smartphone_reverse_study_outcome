package he3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lhe3/q0;", "", "Lhe3/l1;", "productDetailLink", "Lhe3/l1;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lhe3/l1;", "productDetailLinkForWindow", "getProductDetailLinkForWindow", "", "findSimilarLink", "Ljava/lang/String;", "getFindSimilarLink", "()Ljava/lang/String;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q0 {

    @SerializedName("find_similar_link")
    private final String findSimilarLink;

    @SerializedName("product_detail_link")
    private final l1 productDetailLink;

    @SerializedName("product_detail_link_for_window")
    private final l1 productDetailLinkForWindow;

    public q0() {
    }

    public final l1 a() {
        return this.productDetailLink;
    }
}
