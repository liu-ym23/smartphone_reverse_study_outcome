package t06;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR6\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lt06/u;", "", "", "", "whiteDomainList", "Ljava/util/List;", "b", "()Ljava/util/List;", "setWhiteDomainList", "(Ljava/util/List;)V", "whiteRegList", "c", "setWhiteRegList", "", "methods", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "setMethods", "(Ljava/util/Map;)V", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class u {

    @SerializedName("methods")
    private Map<String, ? extends List<String>> methods;

    @SerializedName("white_domain_list")
    private List<String> whiteDomainList;

    @SerializedName("white_reg_list")
    private List<String> whiteRegList;

    public u() {
        this.whiteDomainList = CollectionsKt.emptyList();
        this.whiteRegList = CollectionsKt.emptyList();
        this.methods = MapsKt.emptyMap();
    }

    public final Map<String, List<String>> a() {
        return this.methods;
    }

    public final List<String> b() {
        return this.whiteDomainList;
    }

    public final List<String> c() {
        return this.whiteRegList;
    }
}
