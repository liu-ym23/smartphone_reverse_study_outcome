package x66;

import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.ies.xbridge.annotation.XBridgeModelExtension;
import com.bytedance.ies.xbridge.annotation.XBridgeParamField;
import com.bytedance.ies.xbridge.annotation.XBridgeParamModel;
import com.bytedance.ies.xbridge.annotation.XBridgeResultModel;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import com.bytedance.ies.xbridge.model.idl.XBaseResultModel;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a extends v56.c<b, c> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f562636b = null;

    /* JADX INFO: renamed from: x66.a$a, reason: collision with other inner class name */
    public static final class C8198a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "cpu_usage", required = false)
        Boolean getCpu_usage();

        @XBridgeParamField(isGetter = true, keyPath = "memory_all", required = false)
        Boolean getMemory_all();

        @XBridgeParamField(isGetter = true, keyPath = "memory_limit", required = false)
        Boolean getMemory_limit();

        @XBridgeParamField(isGetter = true, keyPath = "memory_rest", required = false)
        Boolean getMemory_rest();

        @XBridgeParamField(isGetter = true, keyPath = "memory_use", required = false)
        Boolean getMemory_use();

        @XBridgeParamField(isGetter = true, keyPath = IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE, required = false)
        Boolean getTemperature();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "cpu_usage", required = true)
        Number getCpu_usage();

        @XBridgeParamField(isGetter = true, keyPath = "memory_all", required = true)
        Number getMemory_all();

        @XBridgeParamField(isGetter = true, keyPath = "memory_limit", required = true)
        Number getMemory_limit();

        @XBridgeParamField(isGetter = true, keyPath = "memory_rest", required = true)
        Number getMemory_rest();

        @XBridgeParamField(isGetter = true, keyPath = "memory_use", required = true)
        Number getMemory_use();

        @XBridgeParamField(isGetter = true, keyPath = IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE, required = true)
        Number getTemperature();

        @XBridgeParamField(isGetter = false, keyPath = "cpu_usage", required = true)
        void setCpu_usage(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "memory_all", required = true)
        void setMemory_all(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "memory_limit", required = true)
        void setMemory_limit(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "memory_rest", required = true)
        void setMemory_rest(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "memory_use", required = true)
        void setMemory_use(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE, required = true)
        void setTemperature(Number r100);
    }

    static {
        f562636b = MapsKt.mapOf(new Pair[]{TuplesKt.to("IDLVersion", "1005"), TuplesKt.to("UID", "6184d92cb4a5670046bedeb2"), TuplesKt.to("TicketID", "15201")});
    }
}
