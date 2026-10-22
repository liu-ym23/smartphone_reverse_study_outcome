package yd7;

import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
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
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public abstract class c extends XCoreIDLBridgeMethod<e, f> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f567319c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.chooseMedia", params = {"maxCount", "mediaTypes", "mediaType", "sourceType", "cameraType", "compressImage", "compressWidth", "compressHeight", "saveToPhotoAlbum", "isNeedCut", "cropRatioWidth", "cropRatioHeight", "needBase64Data", "needBinaryData", "imageParams", "videoParams", "ignoreUserCancel", "copyToPrivateDirection", "inAppStyle"}, results = {"tempFiles"})
    public final String f567320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f567321b;

    public static final class a {
    }

    public interface b extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "compressMaxSize", required = false)
        Number getCompressMaxSize();

        @XBridgeParamField(isGetter = true, keyPath = "cropHeight", required = false)
        String getCropHeight();

        @XBridgeParamField(isGetter = true, keyPath = "cropWidth", required = false)
        String getCropWidth();
    }

    /* JADX INFO: renamed from: yd7.c$c, reason: collision with other inner class name */
    public interface InterfaceC8330c extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "base64Data", required = false)
        String getBase64Data();

        @XBridgeStringEnum(option = {"image", "video"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "mediaType", required = true)
        String getMediaType();

        @XBridgeParamField(isGetter = true, keyPath = DBDefinition.MIME_TYPE, required = false)
        String getMimeType();

        @XBridgeParamField(isGetter = true, keyPath = "path", required = true)
        String getPath();

        @XBridgeParamField(isGetter = true, keyPath = "size", required = true)
        Number getSize();

        @XBridgeParamField(isGetter = true, keyPath = "tempFilePath", required = true)
        String getTempFilePath();

        @XBridgeParamField(isGetter = false, keyPath = "base64Data", required = false)
        void setBase64Data(String r100);

        @XBridgeStringEnum(option = {"image", "video"})
        @XBridgeParamField(isEnum = true, isGetter = false, keyPath = "mediaType", required = true)
        void setMediaType(String r100);

        @XBridgeParamField(isGetter = false, keyPath = DBDefinition.MIME_TYPE, required = false)
        void setMimeType(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "path", required = true)
        void setPath(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "size", required = true)
        void setSize(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "tempFilePath", required = true)
        void setTempFilePath(String r100);
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

        @XBridgeParamField(isGetter = true, keyPath = "compressHeight", required = false)
        Number getCompressHeight();

        @XBridgeParamField(isGetter = true, keyPath = "compressImage", required = false)
        Boolean getCompressImage();

        @XBridgeParamField(isGetter = true, keyPath = "compressWidth", required = false)
        Number getCompressWidth();

        @XBridgeParamField(isGetter = true, keyPath = "copyToPrivateDirection", required = false)
        Boolean getCopyToPrivateDirection();

        @XBridgeParamField(isGetter = true, keyPath = "cropRatioHeight", required = false)
        Number getCropRatioHeight();

        @XBridgeParamField(isGetter = true, keyPath = "cropRatioWidth", required = false)
        Number getCropRatioWidth();

        @XBridgeParamField(isGetter = true, keyPath = "ignoreUserCancel", required = false)
        Boolean getIgnoreUserCancel();

        @XBridgeParamField(isGetter = true, keyPath = "imageParams", nestedClassType = b.class, required = false)
        b getImageParams();

        @XBridgeParamField(isGetter = true, keyPath = "inAppStyle", required = false)
        Boolean getInAppStyle();

        @XBridgeParamField(isGetter = true, keyPath = "maxCount", required = false)
        Number getMaxCount();

        @XBridgeStringEnum(option = {"image", "video"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "mediaType", primitiveClassType = String.class, required = false)
        List<String> getMediaType();

        @XBridgeStringEnum(option = {"image", "video"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "mediaTypes", primitiveClassType = String.class, required = false)
        List<String> getMediaTypes();

        @XBridgeParamField(isGetter = true, keyPath = "needBase64Data", required = false)
        Boolean getNeedBase64Data();

        @XBridgeParamField(isGetter = true, keyPath = "needBinaryData", required = false)
        Boolean getNeedBinaryData();

        @XBridgeParamField(isGetter = true, keyPath = "saveToPhotoAlbum", required = false)
        Boolean getSaveToPhotoAlbum();

        @XBridgeStringEnum(option = {"album", "camera"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "sourceType", required = true)
        String getSourceType();

        @XBridgeParamField(isGetter = true, keyPath = "videoParams", nestedClassType = d.class, required = false)
        d getVideoParams();

        @XBridgeParamField(isGetter = true, keyPath = "isNeedCut", required = false)
        Boolean isNeedCut();
    }

    @XBridgeResultModel
    public interface f extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "tempFiles", nestedClassType = InterfaceC8330c.class, required = true)
        List<InterfaceC8330c> getTempFiles();

        @XBridgeParamField(isGetter = false, keyPath = "tempFiles", nestedClassType = InterfaceC8330c.class, required = true)
        void setTempFiles(List<? extends InterfaceC8330c> r100);
    }

    static {
        f567319c = MapsKt.mapOf(TuplesKt.to("TicketID", "38222"));
    }

    public c() {
        this.f567320a = "x.chooseMedia";
        this.f567321b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f567321b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f567320a;
    }
}
