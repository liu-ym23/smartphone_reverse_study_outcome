package ko6;

import com.bytedance.locallife.live.model.LiveLocalLifeRoomInfo;
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
import com.tencent.open.SocialConstants;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public abstract class z extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f504520c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "poiGoodsShare", params = {LiveLocalLifeRoomInfo.TRACE_SESSION_ID, "title", "image", SocialConstants.PARAM_APP_DESC, "url", "innerUrl", "report_url", "im_extra", "awe_type", "qrcode_share_info", "command_share_params", "extra_data", "carryParams"}, results = {"code", "button", "data"})
    public final String f504521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f504522b;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "awe_type", required = false)
        String getAweType();

        @XBridgeParamField(isGetter = true, keyPath = "carryParams", required = false)
        Map<String, Object> getCarryParams();

        @XBridgeParamField(isGetter = true, keyPath = "command_share_params", required = true)
        Map<String, Object> getCommandShareParams();

        @XBridgeParamField(isGetter = true, keyPath = SocialConstants.PARAM_APP_DESC, required = true)
        String getDesc();

        @XBridgeParamField(isGetter = true, keyPath = "extra_data", required = false)
        Map<String, Object> getExtraData();

        @XBridgeParamField(isGetter = true, keyPath = "im_extra", required = true)
        Map<String, Object> getImExtra();

        @XBridgeParamField(isGetter = true, keyPath = "image", required = true)
        String getImage();

        @XBridgeParamField(isGetter = true, keyPath = "innerUrl", required = true)
        String getInnerUrl();

        @XBridgeParamField(isGetter = true, keyPath = "qrcode_share_info", required = true)
        Map<String, Object> getQrcodeShareInfo();

        @XBridgeParamField(isGetter = true, keyPath = "report_url", required = false)
        String getReportUrl();

        @XBridgeParamField(isGetter = true, keyPath = "title", required = true)
        String getTitle();

        @XBridgeParamField(isGetter = true, keyPath = LiveLocalLifeRoomInfo.TRACE_SESSION_ID, required = true)
        String getTraceSessionId();

        @XBridgeParamField(isGetter = true, keyPath = "url", required = true)
        String getUrl();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "button", required = true)
        String getButton();

        @XBridgeParamField(isGetter = true, keyPath = "code", required = true)
        Number getCode();

        @XBridgeParamField(isGetter = true, keyPath = "data", nestedClassType = d.class, required = false)
        d getData();

        @XBridgeParamField(isGetter = false, keyPath = "button", required = true)
        void setButton(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "code", required = true)
        void setCode(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "data", nestedClassType = d.class, required = false)
        void setData(d r100);
    }

    public interface d extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "msg", required = true)
        String getMsg();

        @XBridgeParamField(isGetter = false, keyPath = "msg", required = true)
        void setMsg(String r100);
    }

    static {
        f504520c = MapsKt.mapOf(TuplesKt.to("TicketID", "39291"));
    }

    public z() {
        this.f504521a = "poiGoodsShare";
        this.f504522b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f504522b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f504521a;
    }
}
