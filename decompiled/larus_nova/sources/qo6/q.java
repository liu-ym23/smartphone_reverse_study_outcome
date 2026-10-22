package qo6;

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
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public abstract class q extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f534230c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "refreshNearbyCommonDialog", params = {"refreshPageType", "refreshResourceType", "refreshAction", "extraRequestParam", "refreshScene", "feedPartlyRefresh"})
    public final String f534231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f534232b;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "extraRequestParam", required = false)
        String getExtraRequestParam();

        @XBridgeParamField(isGetter = true, keyPath = "feedPartlyRefresh", required = false)
        Boolean getFeedPartlyRefresh();

        @XBridgeParamField(isGetter = true, keyPath = "refreshAction", required = true)
        Number getRefreshAction();

        @XBridgeParamField(isGetter = true, keyPath = "refreshPageType", required = false)
        Number getRefreshPageType();

        @XBridgeParamField(isGetter = true, keyPath = "refreshResourceType", primitiveClassType = Number.class, required = false)
        List<Number> getRefreshResourceType();

        @XBridgeParamField(isGetter = true, keyPath = "refreshScene", required = false)
        String getRefreshScene();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
        f534230c = MapsKt.mapOf(TuplesKt.to("TicketID", "35631"));
    }

    public q() {
        this.f534231a = "refreshNearbyCommonDialog";
        this.f534232b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f534232b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f534231a;
    }
}
