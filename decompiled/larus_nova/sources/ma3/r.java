package ma3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R*\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001f\u0010\rR$\u0010 \u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u000f\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013¨\u0006#"}, d2 = {"Lma3/r;", "Lma3/m;", "Lma3/e;", "exParams", "Lma3/e;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lma3/e;", "", "", "", "skuExParams", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "queryParams", "Ljava/lang/String;", "getQueryParams", "()Ljava/lang/String;", "setQueryParams", "(Ljava/lang/String;)V", "", "ultimateBuyAB", "Ljava/lang/Integer;", "getUltimateBuyAB", "()Ljava/lang/Integer;", "ultimateBuyVersion", "c", "isSingleSku", "yataVersion", "getYataVersion", "yataProtocolInfo", "getYataProtocolInfo", "ecomClientAiInfo", "getEcomClientAiInfo", "setEcomClientAiInfo", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r implements m {

    @SerializedName("ecom_client_ai_info")
    private String ecomClientAiInfo;

    @SerializedName("ex_params")
    private final e exParams;

    @SerializedName("is_single_sku")
    private final Integer isSingleSku;

    @SerializedName("query_params")
    private String queryParams;

    @SerializedName("sku_ex_params")
    private final Map<String, Object> skuExParams;

    @SerializedName("ultimate_buy_ab")
    private final Integer ultimateBuyAB;

    @SerializedName("ultimate_buy_version")
    private final Integer ultimateBuyVersion;

    @SerializedName("yata_protocol_info")
    private final Map<String, Object> yataProtocolInfo;

    @SerializedName("yata_version")
    private final String yataVersion;

    public r() {
        this(null, null, null, null, null, null, null, 511);
    }

    public final e a() {
        return this.exParams;
    }

    public final Map<String, Object> b() {
        return this.skuExParams;
    }

    public final Integer c() {
        return this.ultimateBuyVersion;
    }

    public r(e r100, Map r101, Integer r102, Integer r103, Integer r104, String r105, Map r110, int r111) {
        if ((r111 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r111 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r111 & 8) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r111 & 16) == 0) goto L15;
        r103 = 0;
    L15:
        if ((r111 & 32) == 0) goto L18;
        r104 = 0;
    L18:
        if ((r111 & 64) == 0) goto L21;
        r105 = "";
    L21:
        if ((r111 & 128) == 0) goto L23;
        r110 = null;
    L23:
        this.exParams = r100;
        this.skuExParams = r101;
        this.queryParams = null;
        this.ultimateBuyAB = r102;
        this.ultimateBuyVersion = r103;
        this.isSingleSku = r104;
        this.yataVersion = r105;
        this.yataProtocolInfo = r110;
        this.ecomClientAiInfo = null;
    }
}
