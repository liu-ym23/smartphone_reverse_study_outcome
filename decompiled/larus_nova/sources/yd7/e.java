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
public abstract class e extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f567325c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.downloadFile", params = {"url", "extension", "header", "params", "needCommonParams", "saveToAlbum", "enableProgress"}, results = {"clientCode", "httpCode", "header", "response", "filePath"})
    public final String f567326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f567327b;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "enableProgress", required = false)
        Boolean getEnableProgress();

        @XBridgeParamField(isGetter = true, keyPath = "extension", required = false)
        String getExtension();

        @XBridgeParamField(isGetter = true, keyPath = "header", required = false)
        Map<String, Object> getHeader();

        @XBridgeParamField(isGetter = true, keyPath = "needCommonParams", required = false)
        Boolean getNeedCommonParams();

        @XBridgeParamField(isGetter = true, keyPath = "params", required = false)
        Map<String, Object> getParams();

        @XBridgeParamField(isGetter = true, keyPath = "saveToAlbum", required = false)
        String getSaveToAlbum();

        @XBridgeParamField(isGetter = true, keyPath = "url", required = true)
        String getUrl();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "clientCode", required = true)
        Number getClientCode();

        @XBridgeParamField(isGetter = true, keyPath = "filePath", required = true)
        String getFilePath();

        @XBridgeParamField(isGetter = true, keyPath = "header", required = false)
        Map<String, Object> getHeader();

        @XBridgeParamField(isGetter = true, keyPath = "httpCode", required = false)
        Number getHttpCode();

        @XBridgeParamField(isGetter = true, keyPath = "response", required = false)
        Map<String, Object> getResponse();

        @XBridgeParamField(isGetter = false, keyPath = "clientCode", required = true)
        void setClientCode(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "filePath", required = true)
        void setFilePath(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "header", required = false)
        void setHeader(Map<String, ? extends Object> r100);

        @XBridgeParamField(isGetter = false, keyPath = "httpCode", required = false)
        void setHttpCode(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "response", required = false)
        void setResponse(Map<String, ? extends Object> r100);
    }

    static {
        f567325c = MapsKt.mapOf(TuplesKt.to("TicketID", "36794"));
    }

    public e() {
        this.f567326a = "x.downloadFile";
        this.f567327b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f567327b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f567326a;
    }
}
