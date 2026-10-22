package wc;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e¨\u0006\u0015"}, d2 = {"Lwc/h;", "Lcom/bytedance/android/bst/api/a;", "", "productId", "Ljava/lang/String;", "getProductId", "()Ljava/lang/String;", "setProductId", "(Ljava/lang/String;)V", "", "isAd", "I", "()I", "setAd", "(I)V", "bstGroupType", "getBstGroupType", "setBstGroupType", "originReport", "getOriginReport", "setOriginReport", "models_cnRelease"}, k = 1, mv = {1, 4, 0})
public final class h extends com.bytedance.android.bst.api.a {

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_BST_GROUP_TYPE)
    private String bstGroupType;

    @SerializedName("bst_is_ad")
    private int isAd;

    @SerializedName("origin_report")
    private int originReport;

    @SerializedName("product_id")
    private String productId;

    @Override // com.bytedance.android.bst.api.a
    public final com.bytedance.android.bst.api.a copy() {
        return new h(this.productId, this.isAd, this.bstGroupType, this.originReport);
    }

    @Override // com.bytedance.android.bst.api.a
    public final String getTag() {
        return this.productId;
    }

    @Override // com.bytedance.android.bst.api.a
    public final boolean checkValid(vc.a r100) {
        boolean r101 = false;
        if (this.productId.length() != 0) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L9;
        throw null;
    L9:
        if (this.bstGroupType.length() != 0) goto L11;
        r101 = true;
    L11:
        if (r101 == true) goto L13;
        return true;
    L13:
        throw null;
    L5:
        r102 = false;
        goto L7
    }

    public h(String r100, int r101, String r102, int r103) {
        super("ecommerce", "shopping_media");
        this.productId = r100;
        this.isAd = r101;
        this.bstGroupType = r102;
        this.originReport = r103;
    }
}
