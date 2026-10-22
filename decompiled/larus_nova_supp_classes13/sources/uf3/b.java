package uf3;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u000b¨\u0006\u0018"}, d2 = {"Luf3/b;", "", "", "showSeconds", "Ljava/lang/Long;", "getShowSeconds", "()Ljava/lang/Long;", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "Luf3/d;", "icon", "Luf3/d;", "getIcon", "()Luf3/d;", "", "bizParams", "Ljava/util/Map;", "getBizParams", "()Ljava/util/Map;", "extra", "getExtra", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("biz_params")
    private final Map<String, String> bizParams;

    @SerializedName("exp_param")
    private final String extra;

    @SerializedName("icon")
    private final d icon;

    @SerializedName("show_seconds")
    private final Long showSeconds;

    @SerializedName("text")
    private final String text;

    public b() {
        this.showSeconds = null;
        this.text = null;
        this.icon = null;
        this.bizParams = null;
        this.extra = null;
    }
}
