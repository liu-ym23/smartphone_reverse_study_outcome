package defpackage;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
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

/* JADX INFO: loaded from: classes6.dex */
public abstract class c extends XCoreIDLBridgeMethod<b, InterfaceC0384c> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f21893b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f21894a;

    /* JADX INFO: loaded from: classes42.dex */
    public static final class a {
    }

    /* JADX INFO: loaded from: classes42.dex */
    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "stateLog", required = true)
        Map<String, Object> getStateLog();
    }

    /* JADX INFO: renamed from: c$c, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes42.dex */
    @XBridgeResultModel
    public interface InterfaceC0384c extends XBaseResultModel {
    }

    static {
        f21893b = MapsKt.mapOf(TuplesKt.to("TicketID", "41425"));
    }

    public c() {
        this.f21894a = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f21894a;
    }
}
