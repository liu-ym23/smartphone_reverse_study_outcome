package ko6;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.annotation.DefaultType;
import com.bytedance.ies.xbridge.annotation.XBridgeDefaultValue;
import com.bytedance.ies.xbridge.annotation.XBridgeMethodName;
import com.bytedance.ies.xbridge.annotation.XBridgeModelExtension;
import com.bytedance.ies.xbridge.annotation.XBridgeParamField;
import com.bytedance.ies.xbridge.annotation.XBridgeParamModel;
import com.bytedance.ies.xbridge.annotation.XBridgePermission;
import com.bytedance.ies.xbridge.annotation.XBridgeResultModel;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import com.bytedance.ies.xbridge.model.idl.XBaseResultModel;
import com.ss.texturerender.TextureRenderKeys;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public abstract class v extends v56.c<b, c> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f504511d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgeMethodName(name = "open_poi_media", params = {"scene_type", TextureRenderKeys.KEY_IS_VIDEO_STYLE, "track_data", "extra_params", AppConstants.BUNDLE_MEDIA_ID, "index", "page_data", "should_show_page_indicator", "should_show_scroll_guide"})
    public final String f504512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f504513c;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "extra_params", required = false)
        Map<String, Object> getExtraParams();

        @XBridgeParamField(isGetter = true, keyPath = "index", required = false)
        Number getIndex();

        @XBridgeParamField(isGetter = true, keyPath = AppConstants.BUNDLE_MEDIA_ID, required = false)
        String getMediaId();

        @XBridgeParamField(isGetter = true, keyPath = "page_data", required = false)
        Map<String, Object> getPageData();

        @XBridgeParamField(isGetter = true, keyPath = "scene_type", required = true)
        Number getSceneType();

        @XBridgeParamField(isGetter = true, keyPath = "should_show_page_indicator", required = false)
        Boolean getShouldShowPageIndicator();

        @XBridgeParamField(isGetter = true, keyPath = "should_show_scroll_guide", required = false)
        Boolean getShouldShowScrollGuide();

        @XBridgeParamField(isGetter = true, keyPath = "track_data", required = false)
        Map<String, Object> getTrackData();

        @XBridgeParamField(defaultValue = @XBridgeDefaultValue(stringValue = "0", type = DefaultType.STRING), isGetter = true, keyPath = TextureRenderKeys.KEY_IS_VIDEO_STYLE, required = false)
        Number getVideoStyle();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
        f504511d = MapsKt.mapOf(TuplesKt.to("TicketID", "27481"));
    }

    public v() {
        this.f504512b = "open_poi_media";
        this.f504513c = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // v56.c, com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f504513c;
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final String getName() {
        return this.f504512b;
    }
}
