package ma3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lma3/e;", "", "", "extraInfo", "Ljava/lang/String;", "getExtraInfo", "()Ljava/lang/String;", "queryParams", "getQueryParams", "a", "(Ljava/lang/String;)V", "megaObject", "getMegaObject", "cjInfo", "getCjInfo", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("cj_info")
    private final String cjInfo;

    @SerializedName("extra_info")
    private final String extraInfo;

    @SerializedName("mega_object")
    private final String megaObject;

    @SerializedName("query_items")
    private String queryParams;

    public e() {
        this(null, null, null, null);
    }

    public final void a(String r1) {
        this.queryParams = r1;
    }

    public e(String r1, String r2, String r3, String r4) {
        this.extraInfo = r1;
        this.queryParams = r2;
        this.megaObject = r3;
        this.cjInfo = r4;
    }
}
