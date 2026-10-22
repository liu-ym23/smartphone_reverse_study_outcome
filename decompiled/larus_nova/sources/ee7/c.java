package ee7;

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
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public abstract class c extends XCoreIDLBridgeMethod<b, InterfaceC5774c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f472299c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.updateGecko", params = {"accessKey", "channel", "enableDownloadAutoRetry"}, results = {"statusCode"})
    public final String f472300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PROTECT)
    public final IDLXBridgeMethod.Access f472301b;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "accessKey", required = true)
        String getAccessKey();

        @XBridgeParamField(isGetter = true, keyPath = "channel", required = true)
        String getChannel();

        @XBridgeParamField(defaultValue = @XBridgeDefaultValue(boolValue = true, type = DefaultType.BOOL), isGetter = true, keyPath = "enableDownloadAutoRetry", required = false)
        boolean getEnableDownloadAutoRetry();
    }

    /* JADX INFO: renamed from: ee7.c$c, reason: collision with other inner class name */
    @XBridgeResultModel
    public interface InterfaceC5774c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "statusCode", required = true)
        Number getStatusCode();

        @XBridgeParamField(isGetter = false, keyPath = "statusCode", required = true)
        void setStatusCode(Number r100);
    }

    static {
        f472299c = MapsKt.mapOf(new Pair[]{TuplesKt.to("IDLVersion", "1003"), TuplesKt.to("UID", "60ec27f95dbd2a0046d1fe7c"), TuplesKt.to("TicketID", "16169")});
    }

    public c() {
        this.f472300a = "x.updateGecko";
        this.f472301b = IDLXBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f472301b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f472300a;
    }
}
