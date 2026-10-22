package ab3;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR*\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R\u001a\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lab3/b;", "", "", "", "exParams", "Ljava/util/Map;", "getExParams", "()Ljava/util/Map;", "queryParams", "Ljava/lang/String;", "getQueryParams", "()Ljava/lang/String;", "yataParam", "getYataParam", "yataProtocolInfo", "getYataProtocolInfo", "yataVersion", "getYataVersion", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

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
    public b() {
        Object[] r0 = 0 == true ? 1 : 0;
        Object[] r1 = 0 == true ? 1 : 0;
        this(null, r0, r1, 31);
    }

    public /* synthetic */ b(Map r7, Map r8, String r9, int r10) {
        if ((r10 & 1) == 0) goto L5;
        r7 = MapsKt.emptyMap();
    L5:
        Map r1 = r7;
        if ((r10 & 2) == 0) goto L8;
        String r11 = "";
    L10:
        if ((r10 & 4) == 0) goto L12;
        String r3 = "";
    L14:
        if ((r10 & 8) == 0) goto L16;
        Map r4 = null;
    L18:
        if ((r10 & 16) == 0) goto L20;
        String r5 = "";
    L21:
        this(r1, r11, r3, r4, r5);
        return;
    L20:
        r5 = r9;
        goto L21
    L16:
        r4 = r8;
        goto L18
    L12:
        r3 = null;
        goto L14
    L8:
        r11 = null;
        goto L10
    }

    public b(Map<String, ? extends Object> r2, String r3, String r4, Map<String, ? extends Object> r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "exParams");
        Intrinsics.checkNotNullParameter(r3, "queryParams");
        Intrinsics.checkNotNullParameter(r4, "yataParam");
        Intrinsics.checkNotNullParameter(r6, "yataVersion");
        this.exParams = r2;
        this.queryParams = r3;
        this.yataParam = r4;
        this.yataProtocolInfo = r5;
        this.yataVersion = r6;
    }
}
