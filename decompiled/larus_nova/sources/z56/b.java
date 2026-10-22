package z56;

import com.bytedance.ies.xbridge.IDLXBridgeMethod;
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

/* JADX INFO: loaded from: classes19.dex */
public abstract class b extends v56.c<InterfaceC8419b, c> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f570105d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgeMethodName(name = "x.subscribeEvent", params = {"eventName", "timestamp"})
    public final String f570106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PUBLIC)
    public final IDLXBridgeMethod.Access f570107c;

    public static final class a {
    }

    /* JADX INFO: renamed from: z56.b$b, reason: collision with other inner class name */
    @XBridgeParamModel
    public interface InterfaceC8419b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "eventName", required = true)
        String getEventName();

        @XBridgeParamField(isGetter = true, keyPath = "timestamp", required = true)
        Number getTimestamp();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
        f570105d = MapsKt.mapOf(new Pair[]{TuplesKt.to("IDLVersion", AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF_3M), TuplesKt.to("UID", "610bec30c2d6f700463349f5"), TuplesKt.to("TicketID", "15666")});
    }

    public b() {
        this.f570106b = "x.subscribeEvent";
        this.f570107c = IDLXBridgeMethod.Access.PUBLIC;
    }

    @Override // v56.c, com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f570107c;
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final String getName() {
        return this.f570106b;
    }
}
