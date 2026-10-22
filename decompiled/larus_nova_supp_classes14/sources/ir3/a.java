package ir3;

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
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class a extends XCoreIDLBridgeMethod<InterfaceC0138a, b> {

    @XBridgeModelExtension
    public static final Map<String, Object> c = null;

    @XBridgeMethodName(name = "annie.redirectTo", params = {""}, results = {"url"})
    public final String a;

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access b;

    /* JADX INFO: renamed from: ir3.a$a, reason: collision with other inner class name */
    @XBridgeParamModel
    public interface InterfaceC0138a extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "url", required = true)
        String getUrl();

        @XBridgeParamField(isGetter = false, keyPath = "url", required = true)
        void setUrl(String r1);
    }

    @XBridgeResultModel
    public interface b extends XBaseResultModel {
    }

    public static final class c {
    }

    static {
        c = MapsKt.mapOf(TuplesKt.to("TicketID", "29548"));
    }

    public a() {
        this.a = "annie.redirectTo";
        this.b = IDLXBridgeMethod.Access.PRIVATE;
    }

    public final IDLXBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }
}
