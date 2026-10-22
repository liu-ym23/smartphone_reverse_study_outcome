package ko6;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.annotation.XBridgeMethodName;
import com.bytedance.ies.xbridge.annotation.XBridgeModelExtension;
import com.bytedance.ies.xbridge.annotation.XBridgeParamField;
import com.bytedance.ies.xbridge.annotation.XBridgeParamModel;
import com.bytedance.ies.xbridge.annotation.XBridgePermission;
import com.bytedance.ies.xbridge.annotation.XBridgeResultModel;
import com.bytedance.ies.xbridge.model.idl.XBaseModel;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import com.bytedance.ies.xbridge.model.idl.XBaseResultModel;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public abstract class t extends v56.c<b, c> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f504505d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgeMethodName(name = "openCityPanel", params = {"custom_style"}, results = {"code", "select_name", "select_code", "data"})
    public final String f504506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f504507c;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "custom_style", nestedClassType = d.class, required = false)
        d getCustomStyle();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "code", required = true)
        Number getCode();

        @XBridgeParamField(isGetter = true, keyPath = "data", nestedClassType = e.class, required = false)
        e getData();

        @XBridgeParamField(isGetter = true, keyPath = "select_code", required = false)
        String getSelectCode();

        @XBridgeParamField(isGetter = true, keyPath = "select_name", required = false)
        String getSelectName();

        @XBridgeParamField(isGetter = false, keyPath = "code", required = true)
        void setCode(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "data", nestedClassType = e.class, required = false)
        void setData(e r100);

        @XBridgeParamField(isGetter = false, keyPath = "select_code", required = false)
        void setSelectCode(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "select_name", required = false)
        void setSelectName(String r100);
    }

    public interface d extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = WsConstants.KEY_CHANNEL_TYPE, required = false)
        Number getChannelType();

        @XBridgeParamField(isGetter = true, keyPath = "custom_hint", required = false)
        String getCustomHint();

        @XBridgeParamField(isGetter = true, keyPath = "hide_history", required = true)
        boolean getHideHistory();

        @XBridgeParamField(isGetter = true, keyPath = "hide_hot_city", required = true)
        boolean getHideHotCity();

        @XBridgeParamField(isGetter = true, keyPath = "location_address_config", nestedClassType = f.class, required = false)
        f getLocationAddressConfig();

        @XBridgeParamField(isGetter = true, keyPath = "only_show_l2", required = true)
        boolean getOnlyShowL2();

        @XBridgeParamField(isGetter = true, keyPath = "quick_access_list", nestedClassType = g.class, required = false)
        List<g> getQuickAccessList();
    }

    public interface e extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "location_address", required = false)
        String getLocationAddress();

        @XBridgeParamField(isGetter = true, keyPath = "select_code", required = false)
        String getSelectCode();

        @XBridgeParamField(isGetter = true, keyPath = "select_l3_code", required = false)
        String getSelectL3Code();

        @XBridgeParamField(isGetter = true, keyPath = "select_l3_name", required = false)
        String getSelectL3Name();

        @XBridgeParamField(isGetter = true, keyPath = "select_l3_type", required = false)
        Number getSelectL3Type();

        @XBridgeParamField(isGetter = true, keyPath = "select_name", required = false)
        String getSelectName();

        @XBridgeParamField(isGetter = false, keyPath = "location_address", required = false)
        void setLocationAddress(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "select_code", required = false)
        void setSelectCode(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "select_l3_code", required = false)
        void setSelectL3Code(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "select_l3_name", required = false)
        void setSelectL3Name(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "select_l3_type", required = false)
        void setSelectL3Type(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "select_name", required = false)
        void setSelectName(String r100);
    }

    public interface f extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "city_code", required = true)
        String getCityCode();

        @XBridgeParamField(isGetter = true, keyPath = "city_name", required = true)
        String getCityName();

        @XBridgeParamField(isGetter = true, keyPath = "enable", required = true)
        boolean getEnable();

        @XBridgeParamField(isGetter = true, keyPath = "enter_from", required = true)
        String getEnterFrom();

        @XBridgeParamField(isGetter = true, keyPath = "latd", required = false)
        String getLatd();

        @XBridgeParamField(isGetter = true, keyPath = "location_id", required = false)
        String getLocationId();

        @XBridgeParamField(isGetter = true, keyPath = "lotd", required = false)
        String getLotd();
    }

    public interface g extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "code", required = true)
        String getCode();

        @XBridgeParamField(isGetter = true, keyPath = "name", required = true)
        String getName();
    }

    static {
        f504505d = MapsKt.mapOf(TuplesKt.to("TicketID", "39397"));
    }

    public t() {
        this.f504506b = "openCityPanel";
        this.f504507c = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // v56.c, com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f504507c;
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final String getName() {
        return this.f504506b;
    }
}
