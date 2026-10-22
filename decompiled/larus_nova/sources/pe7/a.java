package pe7;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.DefaultType;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeDefaultValue;
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
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public abstract class a extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f528717c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.close", params = {"containerID", "containerIDs", GXTemplateKey.GAIAX_LAYER_PROGRESS_ANIMATED}, results = {""})
    public final String f528718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PROTECT)
    public final IDLXBridgeMethod.Access f528719b;

    /* JADX INFO: renamed from: pe7.a$a, reason: collision with other inner class name */
    public static final class C7187a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(defaultValue = @XBridgeDefaultValue(boolValue = false, type = DefaultType.BOOL), isGetter = true, keyPath = GXTemplateKey.GAIAX_LAYER_PROGRESS_ANIMATED, required = false)
        boolean getAnimated();

        @XBridgeParamField(isGetter = true, keyPath = "containerID", required = false)
        String getContainerID();

        @XBridgeParamField(isGetter = true, keyPath = "containerIDs", primitiveClassType = String.class, required = false)
        List<String> getContainerIDs();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
        f528717c = MapsKt.mapOf(new Pair[]{TuplesKt.to("IDLVersion", "1006"), TuplesKt.to("UID", "6109029437e39f003e7cc362"), TuplesKt.to("TicketID", "16502")});
    }

    public a() {
        this.f528718a = "x.close";
        this.f528719b = IDLXBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f528719b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f528718a;
    }
}
