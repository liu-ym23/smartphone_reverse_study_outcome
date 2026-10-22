package yd7;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public abstract class k extends XCoreIDLBridgeMethod<f, g> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f567343c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.uploadVideoToVOD", params = {"authConfig", "uploadConfig", "filePath"}, results = {"traceId", "errorInfo", "videoInfo"})
    public final String f567344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f567345b;

    public static final class a {
    }

    public interface b extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "accessKeyId", required = true)
        String getAccessKeyId();

        @XBridgeParamField(isGetter = true, keyPath = "hostName", required = true)
        String getHostName();

        @XBridgeParamField(isGetter = true, keyPath = "secretAccessKey", required = true)
        String getSecretAccessKey();

        @XBridgeParamField(isGetter = true, keyPath = "sessionToken", required = true)
        String getSessionToken();

        @XBridgeParamField(isGetter = true, keyPath = "spaceName", required = true)
        String getSpaceName();
    }

    public interface c extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "errorCode", required = false)
        Number getErrorCode();

        @XBridgeParamField(isGetter = true, keyPath = "errorMessage", required = false)
        String getErrorMessage();

        @XBridgeParamField(isGetter = false, keyPath = "errorCode", required = false)
        void setErrorCode(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "errorMessage", required = false)
        void setErrorMessage(String r100);
    }

    public interface d extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "sliceSize", required = false)
        Number getSliceSize();

        @XBridgeParamField(isGetter = true, keyPath = "socketNum", required = false)
        Number getSocketNum();

        @XBridgeParamField(isGetter = true, keyPath = "traceId", required = false)
        String getTraceId();
    }

    public interface e extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "coverUri", required = false)
        String getCoverUri();

        @XBridgeParamField(isGetter = true, keyPath = "metaInfo", required = false)
        Map<String, Object> getMetaInfo();

        @XBridgeParamField(isGetter = true, keyPath = "vid", required = false)
        String getVid();

        @XBridgeParamField(isGetter = false, keyPath = "coverUri", required = false)
        void setCoverUri(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "metaInfo", required = false)
        void setMetaInfo(Map<String, ? extends Object> r100);

        @XBridgeParamField(isGetter = false, keyPath = "vid", required = false)
        void setVid(String r100);
    }

    @XBridgeParamModel
    public interface f extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "authConfig", nestedClassType = b.class, required = true)
        b getAuthConfig();

        @XBridgeParamField(isGetter = true, keyPath = "filePath", required = true)
        String getFilePath();

        @XBridgeParamField(isGetter = true, keyPath = "uploadConfig", nestedClassType = d.class, required = false)
        d getUploadConfig();
    }

    @XBridgeResultModel
    public interface g extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "errorInfo", nestedClassType = c.class, required = false)
        c getErrorInfo();

        @XBridgeParamField(isGetter = true, keyPath = "traceId", required = true)
        String getTraceId();

        @XBridgeParamField(isGetter = true, keyPath = "videoInfo", nestedClassType = e.class, required = false)
        e getVideoInfo();

        @XBridgeParamField(isGetter = false, keyPath = "errorInfo", nestedClassType = c.class, required = false)
        void setErrorInfo(c r100);

        @XBridgeParamField(isGetter = false, keyPath = "traceId", required = true)
        void setTraceId(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "videoInfo", nestedClassType = e.class, required = false)
        void setVideoInfo(e r100);
    }

    static {
        f567343c = MapsKt.mapOf(TuplesKt.to("TicketID", "26429"));
    }

    public k() {
        this.f567344a = "x.uploadVideoToVOD";
        this.f567345b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f567345b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f567344a;
    }
}
