package com.bytedance.sdk.xbridge.cn.system;

import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public abstract class d extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f270180c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.getDeviceStats", params = {"memory_all", "memory_use", "memory_rest", "memory_limit", "cpu_usage", IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE}, results = {"memory_all", "memory_use", "memory_rest", "memory_limit", "cpu_usage", IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE})
    public final String f270181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PROTECT)
    public final IDLXBridgeMethod.Access f270182b;

    public static final class a {
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
        f270180c = MapsKt.mapOf(new Pair[]{TuplesKt.to("IDLVersion", "1005"), TuplesKt.to("UID", "6184d92cb4a5670046bedeb2"), TuplesKt.to("TicketID", "15201")});
    }

    public d() {
        this.f270181a = "x.getDeviceStats";
        this.f270182b = IDLXBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f270182b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f270181a;
    }
}
