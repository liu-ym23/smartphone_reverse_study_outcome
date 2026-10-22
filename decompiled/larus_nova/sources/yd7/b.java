package yd7;

import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
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
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public abstract class b extends XCoreIDLBridgeMethod<e, f> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f567316c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.chooseAndUpload", params = {"mediaType", "maxCount", "sourceType", "cameraType", "needBase64Data", "saveToPhotoAlbum", "imageParams", "videoParams", "url", "params", "header", "needCommonParams"}, results = {"clientCode", "httpCode", "header", "response", "tempFiles"})
    public final String f567317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f567318b;

    public static final class a {
    }

    /* JADX INFO: renamed from: yd7.b$b, reason: collision with other inner class name */
    public interface InterfaceC8329b extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "compressMaxSize", required = false)
        Number getCompressMaxSize();

        @XBridgeParamField(isGetter = true, keyPath = "cropHeight", required = false)
        String getCropHeight();

        @XBridgeParamField(isGetter = true, keyPath = "cropWidth", required = false)
        String getCropWidth();
    }

    public interface c extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "base64Data", required = false)
        String getBase64Data();

        @XBridgeStringEnum(option = {"image", "video"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "mediaType", required = true)
        String getMediaType();

        @XBridgeParamField(isGetter = true, keyPath = DBDefinition.MIME_TYPE, required = true)
        String getMimeType();

        @XBridgeParamField(isGetter = true, keyPath = "path", required = true)
        String getPath();

        @XBridgeParamField(isGetter = true, keyPath = "size", required = true)
        Number getSize();

        @XBridgeParamField(isGetter = true, keyPath = "url", required = false)
        String getUrl();

        @XBridgeParamField(isGetter = false, keyPath = "base64Data", required = false)
        void setBase64Data(String r100);

        @XBridgeStringEnum(option = {"image", "video"})
        @XBridgeParamField(isEnum = true, isGetter = false, keyPath = "mediaType", required = true)
        void setMediaType(String r100);

        @XBridgeParamField(isGetter = false, keyPath = DBDefinition.MIME_TYPE, required = true)
        void setMimeType(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "path", required = true)
        void setPath(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "size", required = true)
        void setSize(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "url", required = false)
        void setUrl(String r100);
    }

    public interface d extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "durationLimit", required = false)
        Number getDurationLimit();
    }

    @XBridgeParamModel
    public interface e extends XBaseParamModel {
        @XBridgeStringEnum(option = {"back", NewBroadcastMonitor.CAPTURE.FRONT})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "cameraType", required = false)
        String getCameraType();

        @XBridgeParamField(isGetter = true, keyPath = "header", required = false)
        Map<String, Object> getHeader();

        @XBridgeParamField(isGetter = true, keyPath = "imageParams", nestedClassType = InterfaceC8329b.class, required = false)
        InterfaceC8329b getImageParams();

        @XBridgeParamField(isGetter = true, keyPath = "maxCount", required = true)
        Number getMaxCount();

        @XBridgeStringEnum(option = {"image", "video"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "mediaType", primitiveClassType = String.class, required = true)
        List<String> getMediaType();

        @XBridgeParamField(defaultValue = @XBridgeDefaultValue(boolValue = false, type = DefaultType.BOOL), isGetter = true, keyPath = "needBase64Data", required = false)
        boolean getNeedBase64Data();

        @XBridgeParamField(defaultValue = @XBridgeDefaultValue(boolValue = true, type = DefaultType.BOOL), isGetter = true, keyPath = "needCommonParams", required = false)
        boolean getNeedCommonParams();

        @XBridgeParamField(isGetter = true, keyPath = "params", required = false)
        Map<String, Object> getParams();

        @XBridgeParamField(defaultValue = @XBridgeDefaultValue(boolValue = false, type = DefaultType.BOOL), isGetter = true, keyPath = "saveToPhotoAlbum", required = false)
        boolean getSaveToPhotoAlbum();

        @XBridgeStringEnum(option = {"album", "camera"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "sourceType", required = true)
        String getSourceType();

        @XBridgeParamField(isGetter = true, keyPath = "url", required = true)
        String getUrl();

        @XBridgeParamField(isGetter = true, keyPath = "videoParams", nestedClassType = d.class, required = false)
        d getVideoParams();
    }

    @XBridgeResultModel
    public interface f extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "clientCode", required = true)
        Number getClientCode();

        @XBridgeParamField(isGetter = true, keyPath = "header", required = false)
        Map<String, Object> getHeader();

        @XBridgeParamField(isGetter = true, keyPath = "httpCode", required = false)
        Number getHttpCode();

        @XBridgeParamField(isGetter = true, keyPath = "response", required = false)
        Map<String, Object> getResponse();

        @XBridgeParamField(isGetter = true, keyPath = "tempFiles", nestedClassType = c.class, required = true)
        List<c> getTempFiles();

        @XBridgeParamField(isGetter = false, keyPath = "clientCode", required = true)
        void setClientCode(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "header", required = false)
        void setHeader(Map<String, ? extends Object> r100);

        @XBridgeParamField(isGetter = false, keyPath = "httpCode", required = false)
        void setHttpCode(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "response", required = false)
        void setResponse(Map<String, ? extends Object> r100);

        @XBridgeParamField(isGetter = false, keyPath = "tempFiles", nestedClassType = c.class, required = true)
        void setTempFiles(List<? extends c> r100);
    }

    static {
        f567316c = MapsKt.mapOf(TuplesKt.to("TicketID", "15580"));
    }

    public b() {
        this.f567317a = "x.chooseAndUpload";
        this.f567318b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f567318b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f567317a;
    }
}
