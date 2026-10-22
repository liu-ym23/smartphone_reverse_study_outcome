package t06;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001R.\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lt06/q;", "Lt06/a;", "", "", "", "", "sceneMatchMap", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class q extends a {

    @SerializedName("scene_match_map")
    private final Map<String, List<Long>> sceneMatchMap;

    public q() {
        this.sceneMatchMap = null;
    }

    public final Map<String, List<Long>> a() {
        return this.sceneMatchMap;
    }
}
