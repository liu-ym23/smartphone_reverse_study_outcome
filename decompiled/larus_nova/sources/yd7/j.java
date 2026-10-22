package yd7;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeStringEnum;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.ss.android.lark.monitor.traffic.TrafficMetrics;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public abstract class j extends XCoreIDLBridgeMethod<g, h> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f567340c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.uploadImagesToImageX", params = {"authConfig", "uploadConfig", "filePaths"}, results = {"imageInfos", "errorInfo", "traceId"})
    public final String f567341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f567342b;

    public static final class a {
    }

    public interface b extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "accessKeyId", required = true)
        String getAccessKeyId();

        @XBridgeParamField(isGetter = true, keyPath = "hostName", required = true)
        String getHostName();

        @XBridgeParamField(isGetter = true, keyPath = "secretAccessKey", required = true)
        String getSecretAccessKey();

        @XBridgeParamField(isGetter = true, keyPath = "serviceId", required = true)
        String getServiceId();

        @XBridgeParamField(isGetter = true, keyPath = "sessionToken", required = true)
        String getSessionToken();
    }

    public interface c extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "aesKey", required = false)
        String getAesKey();

        @XBridgeParamField(isGetter = true, keyPath = "option", required = true)
        Number getOption();

        @XBridgeParamField(isGetter = true, keyPath = "publicKey", required = false)
        String getPublicKey();
    }

    public interface d extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "errorCode", required = false)
        Number getErrorCode();

        @XBridgeParamField(isGetter = true, keyPath = "errorMessage", required = false)
        String getErrorMessage();

        @XBridgeParamField(isGetter = false, keyPath = "errorCode", required = false)
        void setErrorCode(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "errorMessage", required = false)
        void setErrorMessage(String r100);
    }

    public interface e extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "encryptionInfo", required = false)
        Map<String, Object> getEncryptionInfo();

        @XBridgeParamField(isGetter = true, keyPath = "metaInfo", required = false)
        Map<String, Object> getMetaInfo();

        @XBridgeParamField(isGetter = true, keyPath = "uri", required = false)
        String getUri();

        @XBridgeParamField(isGetter = false, keyPath = "encryptionInfo", required = false)
        void setEncryptionInfo(Map<String, ? extends Object> r100);

        @XBridgeParamField(isGetter = false, keyPath = "metaInfo", required = false)
        void setMetaInfo(Map<String, ? extends Object> r100);

        @XBridgeParamField(isGetter = false, keyPath = "uri", required = false)
        void setUri(String r100);
    }

    public interface f extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "sliceSize", required = false)
        Number getSliceSize();

        @XBridgeParamField(isGetter = true, keyPath = "socketNum", required = false)
        Number getSocketNum();

        @XBridgeParamField(isGetter = true, keyPath = "traceId", required = false)
        String getTraceId();
    }

    @XBridgeParamModel
    public interface g extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "authConfig", nestedClassType = b.class, required = true)
        b getAuthConfig();

        @XBridgeParamField(isGetter = true, keyPath = "encryptionConfig", nestedClassType = c.class, required = false)
        c getEncryptionConfig();

        @XBridgeParamField(isGetter = true, keyPath = "filePaths", primitiveClassType = String.class, required = true)
        List<String> getFilePaths();

        @XBridgeStringEnum(option = {TrafficMetrics.FRPM_TTNET, "builtIn"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "mainNetworkType", required = false)
        String getMainNetworkType();

        @XBridgeParamField(isGetter = true, keyPath = "uploadConfig", nestedClassType = f.class, required = false)
        f getUploadConfig();

        @XBridgeStringEnum(option = {TrafficMetrics.FRPM_TTNET, "builtIn"})
        @XBridgeParamField(isEnum = true, isGetter = false, keyPath = "mainNetworkType", required = false)
        void setMainNetworkType(String r100);
    }

    @XBridgeResultModel
    public interface h extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "errorInfo", nestedClassType = d.class, required = false)
        d getErrorInfo();

        @XBridgeParamField(isGetter = true, keyPath = "imageInfos", nestedClassType = e.class, required = false)
        List<e> getImageInfos();

        @XBridgeParamField(isGetter = true, keyPath = "traceId", required = true)
        String getTraceId();

        @XBridgeParamField(isGetter = false, keyPath = "errorInfo", nestedClassType = d.class, required = false)
        void setErrorInfo(d r100);

        @XBridgeParamField(isGetter = false, keyPath = "imageInfos", nestedClassType = e.class, required = false)
        void setImageInfos(List<? extends e> r100);

        @XBridgeParamField(isGetter = false, keyPath = "traceId", required = true)
        void setTraceId(String r100);
    }

    static {
        f567340c = MapsKt.mapOf(TuplesKt.to("TicketID", "26428"));
    }

    public j() {
        this.f567341a = "x.uploadImagesToImageX";
        this.f567342b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f567342b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f567341a;
    }
}
