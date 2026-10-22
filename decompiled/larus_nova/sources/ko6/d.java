package ko6;

import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.annotation.XBridgeModelExtension;
import com.bytedance.ies.xbridge.annotation.XBridgeParamField;
import com.bytedance.ies.xbridge.annotation.XBridgeParamModel;
import com.bytedance.ies.xbridge.annotation.XBridgePermission;
import com.bytedance.ies.xbridge.annotation.XBridgeResultModel;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import com.bytedance.ies.xbridge.model.idl.XBaseResultModel;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public abstract class d extends v56.c<b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f504447c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PUBLIC)
    public final IDLXBridgeMethod.Access f504448b;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "android_use_high_quality", required = false)
        Boolean getAndroidUseHighQuality();

        @XBridgeParamField(isGetter = true, keyPath = "auto_rotate", required = false)
        Boolean getAutoRotate();

        @XBridgeParamField(isGetter = true, keyPath = "description_list", primitiveClassType = String.class, required = false)
        List<String> getDescription_list();

        @XBridgeParamField(isGetter = true, keyPath = "drag_dismiss", required = false)
        Boolean getDrag_dismiss();

        @XBridgeParamField(isGetter = true, keyPath = "enable_shield", required = false)
        Boolean getEnableShield();

        @XBridgeParamField(isGetter = true, keyPath = "images", primitiveClassType = String.class, required = true)
        List<String> getImages();

        @XBridgeParamField(isGetter = true, keyPath = "index", required = false)
        Number getIndex();

        @XBridgeParamField(isGetter = true, keyPath = "loop", required = false)
        Boolean getLoop();

        @XBridgeParamField(isGetter = true, keyPath = "needDownload", required = false)
        Number getNeedDownload();

        @XBridgeParamField(isGetter = true, keyPath = "openType", required = false)
        String getOpenType();

        @XBridgeParamField(isGetter = true, keyPath = "show_close_button", required = false)
        Boolean getShow_close_button();

        @XBridgeParamField(isGetter = true, keyPath = "thumb_images", primitiveClassType = String.class, required = false)
        List<String> getThumb_images();

        @XBridgeParamField(isGetter = true, keyPath = "tracker_data", required = false)
        String getTracker_data();

        @XBridgeParamField(isGetter = true, keyPath = "uniqueId", required = false)
        String getUniqueId();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "code", required = true)
        Number getCode();

        @XBridgeParamField(isGetter = false, keyPath = "code", required = true)
        void setCode(Number r100);
    }

    static {
        f504447c = MapsKt.mapOf(new Pair[]{TuplesKt.to("TicketID", "31986"), TuplesKt.to("IDLVersion", "1008"), TuplesKt.to("UID", "61236a3c8f1df8005c6526ce")});
    }

    public d() {
        this.f504448b = IDLXBridgeMethod.Access.PUBLIC;
    }

    @Override // v56.c, com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f504448b;
    }
}
