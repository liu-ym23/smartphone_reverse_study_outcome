package he3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lhe3/z0;", "", "", "requestId", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "cartUrl", "a", "postBack", "getPostBack", "needTitleDetail", "getNeedTitleDetail", "", "inflowPageNumber", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "d", "(Ljava/lang/Integer;)V", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z0 {
    public boolean a;

    @SerializedName("cart_url")
    private final String cartUrl;

    @SerializedName("inflow_page_number")
    private Integer inflowPageNumber;

    @SerializedName("need_title_detail")
    private final String needTitleDetail;

    @SerializedName("post_back")
    private final String postBack;

    @SerializedName("request_id")
    private String requestId;

    public z0() {
    }

    public final String a() {
        return this.cartUrl;
    }

    public final Integer b() {
        return this.inflowPageNumber;
    }

    public final String c() {
        return this.requestId;
    }

    public final void d(Integer r1) {
        this.inflowPageNumber = r1;
    }

    public final void e(String r1) {
        this.requestId = r1;
    }
}
