package ma3;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R*\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001f\u0010\rR$\u0010 \u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u000f\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013¨\u0006#"}, d2 = {"Lma3/r;", "Lma3/m;", "Lma3/e;", "exParams", "Lma3/e;", "a", "()Lma3/e;", "", "", "", "skuExParams", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "queryParams", "Ljava/lang/String;", "getQueryParams", "()Ljava/lang/String;", "setQueryParams", "(Ljava/lang/String;)V", "", "ultimateBuyAB", "Ljava/lang/Integer;", "getUltimateBuyAB", "()Ljava/lang/Integer;", "ultimateBuyVersion", "c", "isSingleSku", "yataVersion", "getYataVersion", "yataProtocolInfo", "getYataProtocolInfo", "ecomClientAiInfo", "getEcomClientAiInfo", "setEcomClientAiInfo", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public r(e r4, Map r5, Integer r6, Integer r7, Integer r8, String r9, Map r10, int r11) {
        if ((r11 & 1) == 0) goto L6;
        r4 = null;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r5 = null;
    L9:
        if ((r11 & 8) == 0) goto L12;
        r6 = 0;
    L12:
        if ((r11 & 16) == 0) goto L15;
        r7 = 0;
    L15:
        if ((r11 & 32) == 0) goto L18;
        r8 = 0;
    L18:
        if ((r11 & 64) == 0) goto L21;
        r9 = "";
    L21:
        if ((r11 & 128) == 0) goto L23;
        r10 = null;
    L23:
        this.exParams = r4;
        this.skuExParams = r5;
        this.queryParams = null;
        this.ultimateBuyAB = r6;
        this.ultimateBuyVersion = r7;
        this.isSingleSku = r8;
        this.yataVersion = r9;
        this.yataProtocolInfo = r10;
        this.ecomClientAiInfo = null;
    }
}
