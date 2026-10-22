package dv9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/larus/settings/provider/maintab/HomePageMiddleTabConfig;", "", "<init>", "()V", "style", "", "getStyle", "()I", "iconUrl", "", "getIconUrl", "()Ljava/lang/String;", "iconKey", "getIconKey", "Companion", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("icon_key")
    private final String iconKey;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("style")
    private final int style;

    /* JADX INFO: renamed from: dv9.a$a, reason: collision with other inner class name */
    public static final class C5713a {
    }

    static {
    }

    public a() {
        this.style = 1;
    }

    public final String a() {
        return this.iconKey;
    }

    public final String b() {
        return this.iconUrl;
    }

    public final int c() {
        return this.style;
    }
}
