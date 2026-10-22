package yd7;

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

/* JADX INFO: loaded from: classes22.dex */
public abstract class f extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f567328c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.getAbsolutePath", params = {"relativePath"}, results = {"fileExist", "absolutePath"})
    public final String f567329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f567330b;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "relativePath", required = true)
        String getRelativePath();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "absolutePath", required = true)
        String getAbsolutePath();

        @XBridgeParamField(isGetter = true, keyPath = "fileExist", required = true)
        Boolean getFileExist();

        @XBridgeParamField(isGetter = false, keyPath = "absolutePath", required = true)
        void setAbsolutePath(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "fileExist", required = true)
        void setFileExist(Boolean r100);
    }

    static {
        f567328c = MapsKt.mapOf(TuplesKt.to("TicketID", "35251"));
    }

    public f() {
        this.f567329a = "x.getAbsolutePath";
        this.f567330b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f567330b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f567329a;
    }
}
