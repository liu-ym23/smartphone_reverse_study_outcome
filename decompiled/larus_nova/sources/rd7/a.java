package rd7;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeStringEnum;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public abstract class a extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f537290c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.createCalendarEvent", params = {LocationMonitorConst.IDENTIFIER, "repeatFrequency", "repeatInterval", "repeatCount", com.heytap.mcssdk.constant.b.f276369s, com.heytap.mcssdk.constant.b.f276370t, "alarmOffset", "allDay", "title", "notes", "location", "url", "calendarName"}, results = {""})
    public final String f537291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f537292b;

    /* JADX INFO: renamed from: rd7.a$a, reason: collision with other inner class name */
    public static final class C7465a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "alarmOffset", required = false)
        Number getAlarmOffset();

        @XBridgeParamField(isGetter = true, keyPath = "allDay", required = false)
        Boolean getAllDay();

        @XBridgeParamField(isGetter = true, keyPath = "calendarName", required = false)
        String getCalendarName();

        @XBridgeParamField(isGetter = true, keyPath = com.heytap.mcssdk.constant.b.f276370t, required = true)
        Number getEndDate();

        @XBridgeParamField(isGetter = true, keyPath = LocationMonitorConst.IDENTIFIER, required = true)
        String getIdentifier();

        @XBridgeParamField(isGetter = true, keyPath = "location", required = false)
        String getLocation();

        @XBridgeParamField(isGetter = true, keyPath = "notes", required = false)
        String getNotes();

        @XBridgeParamField(isGetter = true, keyPath = "repeatCount", required = true)
        Number getRepeatCount();

        @XBridgeStringEnum(option = {"DAILY", "MONTHLY", "WEEKLY", "YEARLY", "daily", "monthly", "weekly", "yearly"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "repeatFrequency", required = true)
        String getRepeatFrequency();

        @XBridgeParamField(isGetter = true, keyPath = "repeatInterval", required = true)
        Number getRepeatInterval();

        @XBridgeParamField(isGetter = true, keyPath = com.heytap.mcssdk.constant.b.f276369s, required = true)
        Number getStartDate();

        @XBridgeParamField(isGetter = true, keyPath = "title", required = false)
        String getTitle();

        @XBridgeParamField(isGetter = true, keyPath = "url", required = false)
        String getUrl();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
        f537290c = MapsKt.mapOf(TuplesKt.to("TicketID", "16589"));
    }

    public a() {
        this.f537291a = "x.createCalendarEvent";
        this.f537292b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f537292b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f537291a;
    }
}
