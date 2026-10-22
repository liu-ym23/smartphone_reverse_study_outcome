package ko6;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
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
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public abstract class c extends v56.c<b, InterfaceC6584c> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f504441d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgeMethodName(name = "fetch_session_info", params = {LocationMonitorConst.IDENTIFIER}, results = {"id_existed", "info"})
    public final String f504442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f504443c;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = LocationMonitorConst.IDENTIFIER, required = true)
        String getIdentifier();
    }

    /* JADX INFO: renamed from: ko6.c$c, reason: collision with other inner class name */
    @XBridgeResultModel
    public interface InterfaceC6584c extends XBaseResultModel {
        @XBridgeIntEnum(option = {0, 1})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "id_existed", required = true)
        Number getId_existed();

        @XBridgeParamField(isGetter = true, keyPath = "info", required = true)
        Object getInfo();

        @XBridgeIntEnum(option = {0, 1})
        @XBridgeParamField(isEnum = true, isGetter = false, keyPath = "id_existed", required = true)
        void setId_existed(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "info", required = true)
        void setInfo(Object r100);
    }

    static {
        f504441d = MapsKt.mapOf(new Pair[]{TuplesKt.to("IDLVersion", AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF), TuplesKt.to("UID", "61238e458f1df8005c6526ee")});
    }

    public c() {
        this.f504442b = "fetch_session_info";
        this.f504443c = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // v56.c, com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f504443c;
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final String getName() {
        return this.f504442b;
    }
}
