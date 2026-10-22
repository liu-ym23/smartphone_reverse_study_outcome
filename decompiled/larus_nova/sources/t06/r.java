package t06;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"Lt06/r;", "Lt06/a;", "", "", "whiteDomainList", "Ljava/util/List;", "b", "()Ljava/util/List;", "whiteRegList", "c", "sensitiveRequestHeaders", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class r extends a {

    @SerializedName("sensitive_request_headers")
    private final List<String> sensitiveRequestHeaders;

    @SerializedName("white_domain_list")
    private final List<String> whiteDomainList;

    @SerializedName("white_reg_list")
    private final List<String> whiteRegList;

    public r() {
        List<String> r100 = CollectionsKt.emptyList();
        List<String> r101 = CollectionsKt.emptyList();
        this.whiteDomainList = r100;
        this.whiteRegList = r101;
        this.sensitiveRequestHeaders = null;
    }

    public final List<String> a() {
        return this.sensitiveRequestHeaders;
    }

    public final List<String> b() {
        return this.whiteDomainList;
    }

    public final List<String> c() {
        return this.whiteRegList;
    }
}
