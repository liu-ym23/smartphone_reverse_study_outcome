package qo6;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeIntEnum;
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
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public abstract class d extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f534191c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "getSession", params = {"rootId", "sessionId", "type", "key"}, results = {"code", "result"})
    public final String f534192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f534193b;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "key", required = false)
        String getKey();

        @XBridgeParamField(isGetter = true, keyPath = "rootId", required = true)
        String getRootId();

        @XBridgeParamField(isGetter = true, keyPath = "sessionId", required = true)
        String getSessionId();

        @XBridgeParamField(isGetter = true, keyPath = "type", required = false)
        String getType();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "code", required = true)
        @XBridgeIntEnum(option = {1, 0, -1, -2})
        Number getCode();

        @XBridgeParamField(isGetter = true, keyPath = "result", required = false)
        Map<String, Object> getResult();

        @XBridgeParamField(isEnum = true, isGetter = false, keyPath = "code", required = true)
        @XBridgeIntEnum(option = {1, 0, -1, -2})
        void setCode(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "result", required = false)
        void setResult(Map<String, ? extends Object> r100);
    }

    static {
        f534191c = MapsKt.mapOf(TuplesKt.to("TicketID", "31995"));
    }

    public d() {
        this.f534192a = "getSession";
        this.f534193b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f534193b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f534192a;
    }
}
