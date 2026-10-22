package rd7;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public abstract class c extends XCoreIDLBridgeMethod<b, InterfaceC7467c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f537296c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.readCalendarEvent", params = {LocationMonitorConst.IDENTIFIER}, results = {com.heytap.mcssdk.constant.b.f276369s, com.heytap.mcssdk.constant.b.f276370t, "alarmOffset", "allDay", "title", "notes", "location", "url"})
    public final String f537297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f537298b;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = LocationMonitorConst.IDENTIFIER, required = true)
        String getIdentifier();
    }

    /* JADX INFO: renamed from: rd7.c$c, reason: collision with other inner class name */
    @XBridgeResultModel
    public interface InterfaceC7467c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "alarmOffset", required = false)
        Number getAlarmOffset();

        @XBridgeParamField(isGetter = true, keyPath = "allDay", required = false)
        Boolean getAllDay();

        @XBridgeParamField(isGetter = true, keyPath = com.heytap.mcssdk.constant.b.f276370t, required = true)
        Number getEndDate();

        @XBridgeParamField(isGetter = true, keyPath = "location", required = false)
        String getLocation();

        @XBridgeParamField(isGetter = true, keyPath = "notes", required = false)
        String getNotes();

        @XBridgeParamField(isGetter = true, keyPath = com.heytap.mcssdk.constant.b.f276369s, required = true)
        Number getStartDate();

        @XBridgeParamField(isGetter = true, keyPath = "title", required = false)
        String getTitle();

        @XBridgeParamField(isGetter = true, keyPath = "url", required = false)
        String getUrl();

        @XBridgeParamField(isGetter = false, keyPath = "alarmOffset", required = false)
        void setAlarmOffset(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "allDay", required = false)
        void setAllDay(Boolean r100);

        @XBridgeParamField(isGetter = false, keyPath = com.heytap.mcssdk.constant.b.f276370t, required = true)
        void setEndDate(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "location", required = false)
        void setLocation(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "notes", required = false)
        void setNotes(String r100);

        @XBridgeParamField(isGetter = false, keyPath = com.heytap.mcssdk.constant.b.f276369s, required = true)
        void setStartDate(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "title", required = false)
        void setTitle(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "url", required = false)
        void setUrl(String r100);
    }

    static {
        f537296c = MapsKt.mapOf(new Pair[]{TuplesKt.to("IDLVersion", "1003"), TuplesKt.to("UID", "610914d137e39f003e7cc37f"), TuplesKt.to("TicketID", "12883")});
    }

    public c() {
        this.f537297a = "x.readCalendarEvent";
        this.f537298b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f537298b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f537297a;
    }
}
