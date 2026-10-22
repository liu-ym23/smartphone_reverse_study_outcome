package ie3;

import com.bytedance.android.shopping.infeed.data.idl.ad.AdBaseInfo;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lie3/a;", "", "Lcom/bytedance/android/shopping/infeed/data/idl/ad/AdBaseInfo;", "adBaseInfo", "Lcom/bytedance/android/shopping/infeed/data/idl/ad/AdBaseInfo;", "a", "()Lcom/bytedance/android/shopping/infeed/data/idl/ad/AdBaseInfo;", "b", "(Lcom/bytedance/android/shopping/infeed/data/idl/ad/AdBaseInfo;)V", "", "commerceConfigData", "Ljava/lang/String;", "getCommerceConfigData", "()Ljava/lang/String;", "setCommerceConfigData", "(Ljava/lang/String;)V", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("base_info")
    private AdBaseInfo adBaseInfo;

    @SerializedName("commerce_config_data")
    private String commerceConfigData;

    public a() {
    }

    public final AdBaseInfo a() {
        return this.adBaseInfo;
    }

    public final void b(AdBaseInfo r1) {
        this.adBaseInfo = r1;
    }
}
