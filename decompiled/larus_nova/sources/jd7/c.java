package jd7;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeStringEnum;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public abstract class c extends XCoreIDLBridgeMethod<b, InterfaceC6420c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f498651c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.logout", params = {PerfLog.PARAM_KEY_CONTEXT_ID}, results = {"status"})
    public final String f498652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f498653b;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = PerfLog.PARAM_KEY_CONTEXT_ID, required = false)
        Map<String, Object> getContext();
    }

    /* JADX INFO: renamed from: jd7.c$c, reason: collision with other inner class name */
    @XBridgeResultModel
    public interface InterfaceC6420c extends XBaseResultModel {
        @XBridgeStringEnum(option = {"cancelled", "loggedOut"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "status", required = true)
        String getStatus();

        @XBridgeStringEnum(option = {"cancelled", "loggedOut"})
        @XBridgeParamField(isEnum = true, isGetter = false, keyPath = "status", required = true)
        void setStatus(String r100);
    }

    static {
        f498651c = MapsKt.mapOf(new Pair[]{TuplesKt.to("IDLVersion", "1003"), TuplesKt.to("UID", "61093dc137e39f003e7cc38f"), TuplesKt.to("TicketID", "16603")});
    }

    public c() {
        this.f498652a = "x.logout";
        this.f498653b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f498653b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f498652a;
    }
}
