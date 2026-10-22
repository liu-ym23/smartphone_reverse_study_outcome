package ps1;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\r"}, d2 = {"Lps1/b;", "", "", "topInfoBackground", "Ljava/lang/String;", "getTopInfoBackground", "()Ljava/lang/String;", "mainBackground", "getMainBackground", "navigationBackground", "getNavigationBackground", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("main_background")
    private final String mainBackground;

    @SerializedName("navigation_background")
    private final String navigationBackground;

    @SerializedName("top_info_background")
    private final String topInfoBackground;

    public b() {
        this.topInfoBackground = "#F3F8FF";
        this.mainBackground = "#FFFFFFFF";
        this.navigationBackground = "#FFFFFFFF";
    }
}
