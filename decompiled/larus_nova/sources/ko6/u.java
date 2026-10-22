package ko6;

import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.annotation.XBridgeIntEnum;
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
public abstract class u extends v56.c<b, c> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f504508d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgeMethodName(name = "open_poi_feed", params = {SimilarProductParam.AWEME_ID, "initial_time", TextureRenderKeys.KEY_IS_VIDEO_STYLE, "poi_info", "extra_params", "poi_id", "initial_cursor", "scene_type", "initial_count", "page_count", "tracker_data", "aweme_list", "video_count", "disable_like_item", "disable_slider_poi_detail", "react_id", "index", "session_id", "poi_feed_track_params_config"})
    public final String f504509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f504510c;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = SimilarProductParam.AWEME_ID, required = false)
        String getAwemeId();

        @XBridgeParamField(isGetter = true, keyPath = "aweme_list", required = false)
        String getAwemeList();

        @XBridgeIntEnum(option = {0, 1})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "disable_like_item", required = false)
        Number getDisableLikeItem();

        @XBridgeIntEnum(option = {0, 1})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "disable_slider_poi_detail", required = false)
        Number getDisableSliderPoiDetail();

        @XBridgeParamField(isGetter = true, keyPath = "extra_params", required = false)
        Object getExtraParams();

        @XBridgeParamField(isGetter = true, keyPath = "index", required = false)
        Number getIndex();

        @XBridgeParamField(isGetter = true, keyPath = "initial_count", required = false)
        Number getInitialCount();

        @XBridgeParamField(isGetter = true, keyPath = "initial_cursor", required = false)
        Number getInitialCursor();

        @XBridgeParamField(isGetter = true, keyPath = "initial_time", required = false)
        Number getInitialTime();

        @XBridgeParamField(isGetter = true, keyPath = "page_count", required = false)
        Number getPageCount();

        @XBridgeParamField(isGetter = true, keyPath = "poi_feed_track_params_config", required = false)
        String getPoiFeedTrackParams();

        @XBridgeParamField(isGetter = true, keyPath = "poi_id", required = false)
        String getPoiId();

        @XBridgeParamField(isGetter = true, keyPath = "poi_info", required = false)
        String getPoiInfo();

        @XBridgeParamField(isGetter = true, keyPath = "react_id", required = false)
        String getReactId();

        @XBridgeParamField(isGetter = true, keyPath = "scene_type", required = false)
        Number getSceneType();

        @XBridgeParamField(isGetter = true, keyPath = "session_id", required = false)
        String getSessionId();

        @XBridgeParamField(isGetter = true, keyPath = "tracker_data", required = false)
        Object getTrackerData();

        @XBridgeParamField(isGetter = true, keyPath = "video_count", required = false)
        Number getVideoCount();

        @XBridgeParamField(isGetter = true, keyPath = TextureRenderKeys.KEY_IS_VIDEO_STYLE, required = false)
        Number getVideoStyle();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
        f504508d = MapsKt.mapOf(TuplesKt.to("TicketID", "27398"));
    }

    public u() {
        this.f504509b = "open_poi_feed";
        this.f504510c = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // v56.c, com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f504510c;
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final String getName() {
        return this.f504509b;
    }
}
