package he3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lhe3/h1;", "", "", "cartAddibleStatus", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "Lhe3/f1;", "addCartButton", "Lhe3/f1;", "a", "()Lhe3/f1;", "", "newSourceType", "Ljava/lang/String;", "getNewSourceType", "()Ljava/lang/String;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h1 {

    @SerializedName("add_cart_button")
    private final f1 addCartButton;

    @SerializedName("cart_addible_status")
    private final Boolean cartAddibleStatus;

    @SerializedName("new_source_type")
    private final String newSourceType;

    public h1() {
        this(null, null, 7);
    }

    public final f1 a() {
        return this.addCartButton;
    }

    public final Boolean b() {
        return this.cartAddibleStatus;
    }

    public h1(Boolean r3, f1 r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r4 = null;
    L8:
        this.cartAddibleStatus = r3;
        this.addCartButton = r4;
        this.newSourceType = null;
    }
}
