package ph3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lph3/b;", "", "", "", "exParams", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "queryParams", "Ljava/lang/String;", "getQueryParams", "()Ljava/lang/String;", "yataVersion", "getYataVersion", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("ex_params")
    private final Map<String, Object> exParams;

    @SerializedName("query_params")
    private final String queryParams;

    @SerializedName("yata_version")
    private final String yataVersion;

    public b() {
        this(null, null, 7);
    }

    public final Map<String, Object> a() {
        return this.exParams;
    }

    public b(Map r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        r101 = "";
    L8:
        Intrinsics.checkNotNullParameter(r101, "yataVersion");
        this.exParams = r100;
        this.queryParams = null;
        this.yataVersion = r101;
    }
}
