package wd7;

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
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public abstract class b extends XCoreIDLBridgeMethod<c, d> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f559297c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.reportALog", params = {"level", "message", "tag", "codePosition"}, results = {"code", "msg"})
    public final String f559298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PROTECT)
    public final IDLXBridgeMethod.Access f559299b;

    public static final class a {
    }

    /* JADX INFO: renamed from: wd7.b$b, reason: collision with other inner class name */
    public interface InterfaceC8095b extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "file", required = true)
        String getFile();

        @XBridgeParamField(isGetter = true, keyPath = "function", required = true)
        String getFunction();

        @XBridgeParamField(isGetter = true, keyPath = "line", required = true)
        Number getLine();
    }

    @XBridgeParamModel
    public interface c extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "codePosition", nestedClassType = InterfaceC8095b.class, required = true)
        InterfaceC8095b getCodePosition();

        @XBridgeStringEnum(option = {"debug", "error", "info", "verbose", "warn"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "level", required = true)
        String getLevel();

        @XBridgeParamField(isGetter = true, keyPath = "message", required = true)
        String getMessage();

        @XBridgeParamField(isGetter = true, keyPath = "tag", required = true)
        String getTag();
    }

    @XBridgeResultModel
    public interface d extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "code", required = true)
        Number getCode();

        @XBridgeParamField(isGetter = true, keyPath = "msg", required = true)
        String getMsg();

        @XBridgeParamField(isGetter = false, keyPath = "code", required = true)
        void setCode(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "msg", required = true)
        void setMsg(String r100);
    }

    static {
        f559297c = MapsKt.mapOf(new Pair[]{TuplesKt.to("IDLVersion", AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF), TuplesKt.to("UID", "61090b9b37e39f003e7cc375"), TuplesKt.to("TicketID", "16566")});
    }

    public b() {
        this.f559298a = "x.reportALog";
        this.f559299b = IDLXBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f559299b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f559298a;
    }
}
