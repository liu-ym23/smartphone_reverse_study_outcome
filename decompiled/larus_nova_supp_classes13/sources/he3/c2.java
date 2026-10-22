package he3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lhe3/c2;", "", "", "title", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "shortTitle", "getShortTitle", "midTitle", "getMidTitle", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c2 {

    @SerializedName("mid_title")
    private final String midTitle;

    @SerializedName("short_title")
    private final String shortTitle;

    @SerializedName("title")
    private final String title;

    public c2() {
        this(null, 7);
    }

    public final String a() {
        return this.title;
    }

    public c2(String r2, int r3) {
        if ((r3 & 1) == 0) goto L5;
        r2 = null;
    L5:
        this.title = r2;
        this.shortTitle = null;
        this.midTitle = null;
    }
}
