package i44;

import com.amap.api.col.s.ce;
import com.bytedance.awemeopen.bizmodels.feed.shopping.card.DetailPromotion;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Li44/b;", "Ln14/a;", "", "promotion", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setPromotion", "(Ljava/lang/String;)V", "", "Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/DetailPromotion;", "promotions", "Ljava/util/List;", "f", "()Ljava/util/List;", ce.f26391f, "(Ljava/util/List;)V", "<init>", "()V", "ao_domain_release"}, k = 1, mv = {1, 7, 1})
public final class b extends n14.a {

    @SerializedName("promotion")
    private String promotion;

    @SerializedName("promotions")
    private List<DetailPromotion> promotions;

    public b() {
    }

    public final String e() {
        return this.promotion;
    }

    public final List<DetailPromotion> f() {
        return this.promotions;
    }

    public final void g(List<DetailPromotion> r100) {
        this.promotions = r100;
    }
}
