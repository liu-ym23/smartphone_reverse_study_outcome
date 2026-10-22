package he3;

import com.bytedance.android.shopping.infeed.data.idl.InFeedProduct;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lhe3/y0;", "", "", "Lcom/bytedance/android/shopping/infeed/data/idl/InFeedProduct;", "cards", "Ljava/util/List;", "getCards", "()Ljava/util/List;", "Lcom/bytedance/android/shopping/infeed/data/idl/InFeedProductV2;", "cardsV2", "b", "Lhe3/u;", "bffData", "Lhe3/u;", "a", "()Lhe3/u;", "Lhe3/v0;", "paConfig", "Lhe3/v0;", "getPaConfig", "()Lhe3/v0;", "Lhe3/z0;", "extra", "Lhe3/z0;", "c", "()Lhe3/z0;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class y0 {

    @SerializedName("bff_data")
    private final u bffData;

    @SerializedName("infos")
    private final List<InFeedProduct> cards;

    @SerializedName("cards")
    private final List<InFeedProductV2> cardsV2;

    @SerializedName("extra")
    private final z0 extra;

    @SerializedName("pa_conf")
    private final v0 paConfig;

    public y0() {
    }

    public final u a() {
        return this.bffData;
    }

    public final List<InFeedProductV2> b() {
        return this.cardsV2;
    }

    public final z0 c() {
        return this.extra;
    }
}
