package z93;

import com.google.gson.annotations.SerializedName;
import com.obric.sva.sdk.data.ISmModel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R.\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lz93/b;", "Lz93/e;", "", "", "commonComponents", "Ljava/util/List;", "getCommonComponents", "()Ljava/util/List;", "", "cardsComponents", "Ljava/util/Map;", "getCardsComponents", "()Ljava/util/Map;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b extends e {

    @SerializedName("cards_components_templates")
    private final Map<String, List<String>> cardsComponents;

    @SerializedName("common_components_templates")
    private final List<String> commonComponents;

    public b() {
        super(null, 0, null, null, null, null, null, null, ISmModel.VERSION_0300);
        this.commonComponents = null;
        this.cardsComponents = null;
    }
}
