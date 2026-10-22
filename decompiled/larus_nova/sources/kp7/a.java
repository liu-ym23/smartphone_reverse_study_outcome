package kp7;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public abstract class a extends XCoreIDLBridgeMethod<b, Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f505519c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "thirdPartyAuth", params = {"platform", "enableCancel", "checkBinding"})
    public final String f505520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PUBLIC)
    public final IDLXBridgeMethod.Access f505521b;

    /* JADX INFO: renamed from: kp7.a$a, reason: collision with other inner class name */
    public static final class C6596a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "checkBinding", required = false)
        Boolean getCheckBinding();

        @XBridgeParamField(isGetter = true, keyPath = "enableCancel", required = false)
        Boolean getEnableCancel();

        @XBridgeParamField(isGetter = true, keyPath = "platform", required = true)
        String getPlatform();
    }

    static {
        f505519c = MapsKt.mapOf(TuplesKt.to("TicketID", "19223"));
    }

    public a() {
        this.f505520a = "thirdPartyAuth";
        this.f505521b = IDLXBridgeMethod.Access.PUBLIC;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f505521b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f505520a;
    }
}
