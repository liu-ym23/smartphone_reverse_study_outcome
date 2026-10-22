package qt9;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR&\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/larus/settings/provider/UGReturnConfig;", "", "enable", "", "titles", "", "", "<init>", "(ZLjava/util/Map;)V", "getEnable", "()Z", "getTitles", "()Ljava/util/Map;", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class q4 {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("titles")
    private final Map<String, String> titles;

    public q4() {
        this(0);
    }

    public final boolean a() {
        return this.enable;
    }

    public final Map<String, String> b() {
        return this.titles;
    }

    public /* synthetic */ q4(int r100) {
        this(false, MapsKt.emptyMap());
    }

    public q4(boolean r100, Map<String, String> r101) {
        this.enable = r100;
        this.titles = r101;
    }
}
