package he3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lhe3/x1;", "", "", "link", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "keyword", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "queryId", "getQueryId", "Lhe3/y1;", "pointInfo", "Lhe3/y1;", "c", "()Lhe3/y1;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class x1 {

    @SerializedName("keyword")
    private final String keyword;

    @SerializedName("link")
    private final String link;

    @SerializedName("point_info")
    private final y1 pointInfo;

    @SerializedName("query_id")
    private final String queryId;

    public x1() {
        this.link = null;
        this.keyword = null;
        this.queryId = null;
        this.pointInfo = null;
    }

    public final String a() {
        return this.keyword;
    }

    public final String b() {
        return this.link;
    }

    public final y1 c() {
        return this.pointInfo;
    }
}
