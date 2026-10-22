package la3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lla3/d;", "", "", "icon", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "title", "f", "description", "d", "buttonText", "b", "buttonAction", "a", "", "debounceTime", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class d {

    @SerializedName("button_action")
    private final String buttonAction;

    @SerializedName("button_text")
    private final String buttonText;

    @SerializedName("debounce_time")
    private final Integer debounceTime;

    @SerializedName("description")
    private final String description;

    @SerializedName("icon")
    private final String icon;

    @SerializedName("title")
    private final String title;

    public d() {
        this(null, null, null, null, null, null);
    }

    public final String a() {
        return this.buttonAction;
    }

    public final String b() {
        return this.buttonText;
    }

    public final Integer c() {
        return this.debounceTime;
    }

    public final String d() {
        return this.description;
    }

    public final String e() {
        return this.icon;
    }

    public final String f() {
        return this.title;
    }

    public d(String r1, String r2, String r3, String r4, String r5, Integer r6) {
        this.icon = r1;
        this.title = r2;
        this.description = r3;
        this.buttonText = r4;
        this.buttonAction = r5;
        this.debounceTime = r6;
    }
}
