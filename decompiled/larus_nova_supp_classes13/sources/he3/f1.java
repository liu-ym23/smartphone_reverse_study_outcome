package he3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lhe3/f1;", "", "", "link", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "buttonType", "getButtonType", "text", "getText", "color", "getColor", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f1 {

    @SerializedName("button_type")
    private final String buttonType;

    @SerializedName("color")
    private final String color;

    @SerializedName("link")
    private final String link;

    @SerializedName("text")
    private final String text;

    public f1() {
        this(null, 15);
    }

    public final String a() {
        return this.link;
    }

    public f1(String r2, int r3) {
        if ((r3 & 1) == 0) goto L5;
        r2 = null;
    L5:
        this.link = r2;
        this.buttonType = null;
        this.text = null;
        this.color = null;
    }
}
