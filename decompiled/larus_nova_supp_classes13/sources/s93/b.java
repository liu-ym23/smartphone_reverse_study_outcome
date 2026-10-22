package s93;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Ls93/b;", "", "", "enableStraightOut", "Ljava/lang/Boolean;", "a", "()Ljava/lang/Boolean;", "", "expirationTime", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "", "", "tabBlacklist", "Ljava/util/List;", "c", "()Ljava/util/List;", "<init>", "()V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("enable_straight_out")
    private final Boolean enableStraightOut;

    @SerializedName("expiration_time")
    private final Long expirationTime;

    @SerializedName("tab_blacklist")
    private final List<Integer> tabBlacklist;

    public b() {
        this.enableStraightOut = Boolean.FALSE;
    }

    public final Boolean a() {
        return this.enableStraightOut;
    }

    public final Long b() {
        return this.expirationTime;
    }

    public final List<Integer> c() {
        return this.tabBlacklist;
    }
}
