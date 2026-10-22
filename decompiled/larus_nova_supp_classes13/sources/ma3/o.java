package ma3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006¨\u0006\u0014"}, d2 = {"Lma3/o;", "", "", "returnUrl", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "urlType", "e", "", "payStatus", "I", "a", "()I", "urlBtm", "d", "urlBcm", "c", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o {

    @SerializedName("pay_status")
    private final int payStatus;

    @SerializedName("return_url")
    private String returnUrl;

    @SerializedName("url_bcm")
    private final String urlBcm;

    @SerializedName("url_btm")
    private final String urlBtm;

    @SerializedName("url_type")
    private final String urlType;

    public final int a() {
        return this.payStatus;
    }

    public final String b() {
        return this.returnUrl;
    }

    public final String c() {
        return this.urlBcm;
    }

    public final String d() {
        return this.urlBtm;
    }

    public final String e() {
        return this.urlType;
    }

    public final void f(String r1) {
        this.returnUrl = r1;
    }
}
