package lu9;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\n\u0018\u00002\u00020\u0001B5\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000f\u001a\u00020\u0004H\u0016R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR.\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/larus/settings/provider/disk/PathConfig;", "", "cleanPaths", "", "", "patternPaths", "", "<init>", "(Ljava/util/List;Ljava/util/Map;)V", "getCleanPaths", "()Ljava/util/List;", "getPatternPaths", "()Ljava/util/Map;", "setPatternPaths", "(Ljava/util/Map;)V", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class h {

    @SerializedName("clean_paths")
    private final List<String> cleanPaths;

    @SerializedName("pattern_paths")
    private Map<String, String> patternPaths;

    public final String toString() {
        return "PathConfig(cleanPaths=" + this.cleanPaths + ", patternPaths=" + this.patternPaths + ')';
    }

    public h() {
        List<String> r100 = CollectionsKt.emptyList();
        Map<String, String> r101 = MapsKt.emptyMap();
        this.cleanPaths = r100;
        this.patternPaths = r101;
    }

    public final List<String> a() {
        return this.cleanPaths;
    }

    public final Map<String, String> b() {
        return this.patternPaths;
    }
}
