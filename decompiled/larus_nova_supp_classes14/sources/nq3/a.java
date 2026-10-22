package nq3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lnq3/a;", "", "", "viewType", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "layout", "a", "version", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("layout")
    private final String layout;

    @SerializedName("version")
    private final String version;

    @SerializedName("layout_type")
    private final String viewType;

    public a() {
        this(null, null, null);
    }

    public final String a() {
        return this.layout;
    }

    public final String b() {
        return this.version;
    }

    public final String c() {
        return this.viewType;
    }

    public a(String r1, String r2, String r3) {
        this.viewType = r1;
        this.layout = r2;
        this.version = r3;
    }
}
