package ko6;

import androidx.core.app.NotificationCompat;
import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.annotation.XBridgeIntEnum;
import com.bytedance.ies.xbridge.annotation.XBridgeMethodName;
import com.bytedance.ies.xbridge.annotation.XBridgeModelExtension;
import com.bytedance.ies.xbridge.annotation.XBridgeParamField;
import com.bytedance.ies.xbridge.annotation.XBridgeParamModel;
import com.bytedance.ies.xbridge.annotation.XBridgePermission;
import com.bytedance.ies.xbridge.annotation.XBridgeResultModel;
import com.bytedance.ies.xbridge.model.idl.XBaseModel;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import com.bytedance.ies.xbridge.model.idl.XBaseResultModel;
import com.tencent.open.SocialConstants;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public abstract class g extends v56.c<b, c> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f504464d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgeMethodName(name = "getCurrentGCJLocation", params = {NotificationCompat.GROUP_KEY_SILENT, "forceLocate", "isLegitimate", "forceLocateAuth"}, results = {"code", SocialConstants.PARAM_APP_DESC, "latitude", "longitude", "city_code", "city_name", "is_pop_select", "real_city_name", "data"})
    public final String f504465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.SECURE)
    public final IDLXBridgeMethod.Access f504466c;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeIntEnum(option = {0, 1})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "forceLocate", required = false)
        Number getForceLocate();

        @XBridgeParamField(isGetter = true, keyPath = "forceLocateAuth", required = false)
        String getForceLocateAuth();

        @XBridgeParamField(isGetter = true, keyPath = NotificationCompat.GROUP_KEY_SILENT, required = true)
        Number getSilent();

        @XBridgeIntEnum(option = {0, 1})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "isLegitimate", required = false)
        Number isLegitimate();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "city_code", required = false)
        String getCityCode();

        @XBridgeParamField(isGetter = true, keyPath = "city_name", required = false)
        String getCityName();

        @XBridgeParamField(isGetter = true, keyPath = "code", required = true)
        Number getCode();

        @XBridgeParamField(isGetter = true, keyPath = "data", nestedClassType = d.class, required = false)
        d getData();

        @XBridgeParamField(isGetter = true, keyPath = SocialConstants.PARAM_APP_DESC, required = false)
        String getDesc();

        @XBridgeParamField(isGetter = true, keyPath = "latitude", required = false)
        String getLatitude();

        @XBridgeParamField(isGetter = true, keyPath = "longitude", required = false)
        String getLongitude();

        @XBridgeParamField(isGetter = true, keyPath = "real_city_name", required = false)
        String getRealCityName();

        @XBridgeParamField(isGetter = true, keyPath = "is_pop_select", required = false)
        Number isPopSelect();

        @XBridgeParamField(isGetter = false, keyPath = "city_code", required = false)
        void setCityCode(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "city_name", required = false)
        void setCityName(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "code", required = true)
        void setCode(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "data", nestedClassType = d.class, required = false)
        void setData(d r100);

        @XBridgeParamField(isGetter = false, keyPath = SocialConstants.PARAM_APP_DESC, required = false)
        void setDesc(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "latitude", required = false)
        void setLatitude(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "longitude", required = false)
        void setLongitude(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "is_pop_select", required = false)
        void setPopSelect(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "real_city_name", required = false)
        void setRealCityName(String r100);
    }

    public interface d extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "city_code", required = false)
        String getCityCode();

        @XBridgeParamField(isGetter = true, keyPath = "city_name", required = false)
        String getCityName();

        @XBridgeParamField(isGetter = true, keyPath = "latitude", required = false)
        String getLatitude();

        @XBridgeParamField(isGetter = true, keyPath = "longitude", required = false)
        String getLongitude();

        @XBridgeParamField(isGetter = true, keyPath = "real_city_name", required = false)
        String getRealCityName();

        @XBridgeParamField(isGetter = true, keyPath = "is_pop_select", required = false)
        Number isPopSelect();

        @XBridgeParamField(isGetter = false, keyPath = "city_code", required = false)
        void setCityCode(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "city_name", required = false)
        void setCityName(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "latitude", required = false)
        void setLatitude(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "longitude", required = false)
        void setLongitude(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "is_pop_select", required = false)
        void setPopSelect(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "real_city_name", required = false)
        void setRealCityName(String r100);
    }

    static {
        f504464d = MapsKt.mapOf(TuplesKt.to("TicketID", "30299"));
    }

    public g() {
        this.f504465b = "getCurrentGCJLocation";
        this.f504466c = IDLXBridgeMethod.Access.SECURE;
    }

    @Override // v56.c, com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f504466c;
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final String getName() {
        return this.f504465b;
    }
}
