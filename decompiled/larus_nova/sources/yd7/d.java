package yd7;

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
import com.ss.ttvideoengine.model.SubInfo;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public abstract class d extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f567322c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.compressImage", params = {"uri", SubInfo.KEY_FORMAT, GearStrategyConsts.EV_QUALITY, "scalingRatio"}, results = {"tempFilePath", "size"})
    public final String f567323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f567324b;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = SubInfo.KEY_FORMAT, required = false)
        String getFormat();

        @XBridgeParamField(isGetter = true, keyPath = GearStrategyConsts.EV_QUALITY, required = false)
        Number getQuality();

        @XBridgeParamField(isGetter = true, keyPath = "scalingRatio", required = true)
        Number getScalingRatio();

        @XBridgeParamField(isGetter = true, keyPath = "uri", required = true)
        String getUri();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "size", required = true)
        Number getSize();

        @XBridgeParamField(isGetter = true, keyPath = "tempFilePath", required = true)
        String getTempFilePath();

        @XBridgeParamField(isGetter = false, keyPath = "size", required = true)
        void setSize(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "tempFilePath", required = true)
        void setTempFilePath(String r100);
    }

    static {
        f567322c = MapsKt.mapOf(TuplesKt.to("TicketID", "33942"));
    }

    public d() {
        this.f567323a = "x.compressImage";
        this.f567324b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f567324b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f567323a;
    }
}
