package wd7;

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
public abstract class c extends XCoreIDLBridgeMethod<b, InterfaceC8096c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f559300c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.reportAppLog", params = {"eventName", "params"}, results = {""})
    public final String f559301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PROTECT)
    public final IDLXBridgeMethod.Access f559302b;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "eventName", required = true)
        String getEventName();

        @XBridgeParamField(isGetter = true, keyPath = "params", required = false)
        Map<String, Object> getParams();
    }

    /* JADX INFO: renamed from: wd7.c$c, reason: collision with other inner class name */
    @XBridgeResultModel
    public interface InterfaceC8096c extends XBaseResultModel {
    }

    static {
        f559300c = MapsKt.mapOf(new Pair[]{TuplesKt.to("IDLVersion", "1004"), TuplesKt.to("UID", "6109074037e39f003e7cc36a"), TuplesKt.to("TicketID", "16359")});
    }

    public c() {
        this.f559301a = "x.reportAppLog";
        this.f559302b = IDLXBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f559302b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f559301a;
    }
}
