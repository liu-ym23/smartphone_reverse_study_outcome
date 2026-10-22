package qb3;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lqb3/b;", "", "", "", "exParams", "Ljava/util/Map;", "getExParams", "()Ljava/util/Map;", "queryParams", "Ljava/lang/String;", "getQueryParams", "()Ljava/lang/String;", "yataVersion", "getYataVersion", "yataParam", "getYataParam", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("ex_params")
    private final Map<String, Object> exParams;

    @SerializedName("query_params")
    private final String queryParams;

    @SerializedName("yata_param")
    private final String yataParam;

    @SerializedName("yata_version")
    private final String yataVersion;

    public b() {
        this(null, null, "", "");
    }

    public b(Map<String, ? extends Object> r100, String r101, String r102, String r103) {
        this.exParams = r100;
        this.queryParams = r101;
        this.yataVersion = r102;
        this.yataParam = r103;
    }
}
