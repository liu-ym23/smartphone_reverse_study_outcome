package wf3;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR*\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R\u001a\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lwf3/c;", "", "", "", "exParams", "Ljava/util/Map;", "getExParams", "()Ljava/util/Map;", "queryParams", "Ljava/lang/String;", "getQueryParams", "()Ljava/lang/String;", "yataParam", "getYataParam", "yataProtocolInfo", "getYataProtocolInfo", "yataVersion", "getYataVersion", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("ex_params")
    private final Map<String, Object> exParams;

    @SerializedName("query_params")
    private final String queryParams;

    @SerializedName("yata_param")
    private final String yataParam;

    @SerializedName("yata_protocol_info")
    private final Map<String, Object> yataProtocolInfo;

    @SerializedName("yata_version")
    private final String yataVersion;

    /* JADX WARN: Multi-variable type inference failed */
    public c() {
        Object[] r100 = 0 == true ? 1 : 0;
        Object[] r101 = 0 == true ? 1 : 0;
        this(null, r100, r101, 31);
    }

    public /* synthetic */ c(Map r100, Map r101, String r102, int r110) {
        if ((r110 & 1) == 0) goto L5;
        r100 = MapsKt.emptyMap();
    L5:
        Map r103 = r100;
        if ((r110 & 2) == 0) goto L8;
        String r104 = "";
    L10:
        if ((r110 & 4) == 0) goto L12;
        String r105 = "";
    L14:
        if ((r110 & 8) == 0) goto L16;
        Map r106 = null;
    L18:
        if ((r110 & 16) == 0) goto L20;
        String r107 = "";
    L21:
        this(r103, r104, r105, r106, r107);
        return;
    L20:
        r107 = r102;
        goto L21
    L16:
        r106 = r101;
        goto L18
    L12:
        r105 = null;
        goto L14
    L8:
        r104 = null;
        goto L10
    }

    public c(Map<String, ? extends Object> r100, String r101, String r102, Map<String, ? extends Object> r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "exParams");
        Intrinsics.checkNotNullParameter(r101, "queryParams");
        Intrinsics.checkNotNullParameter(r102, "yataParam");
        Intrinsics.checkNotNullParameter(r104, "yataVersion");
        this.exParams = r100;
        this.queryParams = r101;
        this.yataParam = r102;
        this.yataProtocolInfo = r103;
        this.yataVersion = r104;
    }
}
