package zd7;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.DefaultType;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeDefaultValue;
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
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public abstract class a extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f571318c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.uploadFile", params = {"url", "filePath", "params", "header", "fileType", "addCommonParams"}, results = {"url", "response", "clientCode", "httpCode", "header"})
    public final String f571319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f571320b;

    /* JADX INFO: renamed from: zd7.a$a, reason: collision with other inner class name */
    public static final class C8442a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(defaultValue = @XBridgeDefaultValue(boolValue = true, type = DefaultType.BOOL), isGetter = true, keyPath = "addCommonParams", required = false)
        boolean getAddCommonParams();

        @XBridgeParamField(isGetter = true, keyPath = "filePath", required = true)
        String getFilePath();

        @XBridgeStringEnum(option = {"image", "video"})
        @XBridgeParamField(defaultValue = @XBridgeDefaultValue(stringValue = "image", type = DefaultType.STRING), isEnum = true, isGetter = true, keyPath = "fileType", required = false)
        String getFileType();

        @XBridgeParamField(isGetter = true, keyPath = "header", required = false)
        Map<String, Object> getHeader();

        @XBridgeParamField(isGetter = true, keyPath = "params", required = false)
        Map<String, Object> getParams();

        @XBridgeParamField(isGetter = true, keyPath = "url", required = true)
        String getUrl();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "clientCode", required = true)
        Number getClientCode();

        @XBridgeParamField(isGetter = true, keyPath = "header", required = false)
        Map<String, Object> getHeader();

        @XBridgeParamField(isGetter = true, keyPath = "httpCode", required = false)
        Number getHttpCode();

        @XBridgeParamField(isGetter = true, keyPath = "response", required = false)
        Object getResponse();

        @XBridgeParamField(isGetter = true, keyPath = "url", required = true)
        String getUrl();

        @XBridgeParamField(isGetter = false, keyPath = "clientCode", required = true)
        void setClientCode(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "header", required = false)
        void setHeader(Map<String, ? extends Object> r100);

        @XBridgeParamField(isGetter = false, keyPath = "httpCode", required = false)
        void setHttpCode(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "response", required = false)
        void setResponse(Object r100);

        @XBridgeParamField(isGetter = false, keyPath = "url", required = true)
        void setUrl(String r100);
    }

    static {
        f571318c = MapsKt.mapOf(new Pair[]{TuplesKt.to("IDLVersion", "1008"), TuplesKt.to("UID", "618a60b3e27b17003f66dc99"), TuplesKt.to("TicketID", "15807")});
    }

    public a() {
        this.f571319a = "x.uploadFile";
        this.f571320b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f571320b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f571319a;
    }
}
