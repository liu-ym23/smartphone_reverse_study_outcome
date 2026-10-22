package vd7;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeStringEnum;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public abstract class b extends XCoreIDLBridgeMethod<c, d> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f554205c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.getSettings", params = {"keys"}, results = {"settings"})
    public final String f554206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PROTECT)
    public final IDLXBridgeMethod.Access f554207b;

    public static final class a {
    }

    /* JADX INFO: renamed from: vd7.b$b, reason: collision with other inner class name */
    public interface InterfaceC7984b extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "biz", required = false)
        String getBiz();

        @XBridgeParamField(isGetter = true, keyPath = "key", required = true)
        String getKey();

        @XBridgeStringEnum(option = {"array", "bool", ItemStyle.ITEM_STYLE_DOUBLE, "float", "int32", "long", "number", "object", "string"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "type", required = true)
        String getType();
    }

    @XBridgeParamModel
    public interface c extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "keys", nestedClassType = InterfaceC7984b.class, required = true)
        List<InterfaceC7984b> getKeys();
    }

    @XBridgeResultModel
    public interface d extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "settings", required = true)
        Map<String, Object> getSettings();

        @XBridgeParamField(isGetter = false, keyPath = "settings", required = true)
        void setSettings(Map<String, ? extends Object> r100);
    }

    static {
        f554205c = MapsKt.mapOf(new Pair[]{TuplesKt.to("IDLVersion", AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF_3M), TuplesKt.to("UID", "6109038337e39f003e7cc366"), TuplesKt.to("TicketID", "16577")});
    }

    public b() {
        this.f554206a = "x.getSettings";
        this.f554207b = IDLXBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f554207b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f554206a;
    }
}
