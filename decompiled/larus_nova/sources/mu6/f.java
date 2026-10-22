package mu6;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public abstract class f extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f515770c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "openLiveLifeGrouponPage", params = {"page_source", "page_type", "params"})
    public final String f515771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f515772b;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "page_source", required = true)
        String getPageSource();

        @XBridgeParamField(isGetter = true, keyPath = "page_type", required = true)
        Number getPageType();

        @XBridgeParamField(isGetter = true, keyPath = "params", nestedClassType = d.class, required = false)
        d getParams();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    public interface d extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "coupon_ids", required = false)
        String getCouponIds();

        @XBridgeParamField(isGetter = true, keyPath = "extra_request_params", required = false)
        String getExtraRequestParams();

        @XBridgeParamField(isGetter = true, keyPath = "from_position", required = false)
        String getFromPosition();
    }

    static {
        f515770c = MapsKt.mapOf(TuplesKt.to("TicketID", "20863"));
    }

    public f() {
        this.f515771a = "openLiveLifeGrouponPage";
        this.f515772b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f515772b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f515771a;
    }
}
