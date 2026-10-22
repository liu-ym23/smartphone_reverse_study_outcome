package y77;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public class b {

    @SerializedName(GearStrategy.GEAR_STRATEGY_KEY_EXTRA_CONFIG)
    public Map<String, String> extraConfig;

    @SerializedName("signal_name")
    public String signalName;

    @SerializedName("report_interval")
    public long signalReportInterval;

    @SerializedName("signal_scene")
    public List<String> signalScene;

    @SerializedName("signal_type")
    public int signalType;

    public final String toString() {
        return com.bytedance.push.utils.c.f267060a.toJson(this);
    L4:
        return null;
    }

    public b() {
        this.signalScene = new ArrayList();
        this.extraConfig = new HashMap();
    }
}
