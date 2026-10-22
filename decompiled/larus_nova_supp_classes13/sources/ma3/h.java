package ma3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u000b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006¨\u0006\u0014"}, d2 = {"Lma3/h;", "", "", "queryItems", "Ljava/lang/String;", "getQueryItems", "()Ljava/lang/String;", "cjInfo", "getCjInfo", "", "orderIds", "[Ljava/lang/String;", "getOrderIds", "()[Ljava/lang/String;", "phaseOrderId", "getPhaseOrderId", "customPayType", "getCustomPayType", "extraInfo", "getExtraInfo", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h {

    @SerializedName("cj_info")
    private final String cjInfo;

    @SerializedName("customize_pay_type")
    private final String customPayType;

    @SerializedName("extra_info")
    private final String extraInfo;

    @SerializedName("order_ids")
    private final String[] orderIds;

    @SerializedName("phase_order_id")
    private final String phaseOrderId;

    @SerializedName("query_items")
    private final String queryItems;

    public h() {
        this(null, null, null, 63);
    }

    public h(String r3, String r4, String r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 32) == 0) goto L11;
        r5 = null;
    L11:
        this.queryItems = r3;
        this.cjInfo = r4;
        this.orderIds = null;
        this.phaseOrderId = null;
        this.customPayType = null;
        this.extraInfo = r5;
    }
}
