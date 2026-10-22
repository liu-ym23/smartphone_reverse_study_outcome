package ve7;

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
public abstract class b extends XCoreIDLBridgeMethod<InterfaceC7993b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f554406c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.getStorageItem", params = {"key", "biz"}, results = {"data"})
    public final String f554407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f554408b;

    public static final class a {
    }

    /* JADX INFO: renamed from: ve7.b$b, reason: collision with other inner class name */
    @XBridgeParamModel
    public interface InterfaceC7993b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "biz", required = false)
        String getBiz();

        @XBridgeParamField(isGetter = true, keyPath = "key", required = true)
        String getKey();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "data", required = true)
        Object getData();

        @XBridgeParamField(isGetter = false, keyPath = "data", required = true)
        void setData(Object r100);
    }

    static {
        f554406c = MapsKt.mapOf(new Pair[]{TuplesKt.to("IDLVersion", "1009"), TuplesKt.to("UID", "60f9059d79e5d2003e565712"), TuplesKt.to("TicketID", "16625")});
    }

    public b() {
        this.f554407a = "x.getStorageItem";
        this.f554408b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f554408b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f554407a;
    }
}
