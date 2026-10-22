package vd7;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
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
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public abstract class a extends XCoreIDLBridgeMethod<c, d> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f554202c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.getAppInfo", results = {com.heytap.mcssdk.constant.b.f276371u, "installID", "appName", "appVersion", "updateVersionCode", "channel", "language", "isTeenMode", "isBaseMode", "appTheme", "deviceID", "osVersion", "statusBarHeight", "devicePlatform", "deviceModel", OnekeyLoginConstants.NET_TYPE, "networkType", "networkQuality", Constants.OperatorKey.KEY_CARRIER, "is32Bit", "idfa", "screenWidth", "screenHeight", "screenOrientation", "safeArea"})
    public final String f554203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f554204b;

    /* JADX INFO: renamed from: vd7.a$a, reason: collision with other inner class name */
    public static final class C7983a {
    }

    public interface b extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "marginBottom", required = true)
        Number getMarginBottom();

        @XBridgeParamField(isGetter = true, keyPath = "marginLeft", required = true)
        Number getMarginLeft();

        @XBridgeParamField(isGetter = true, keyPath = "marginRight", required = true)
        Number getMarginRight();

        @XBridgeParamField(isGetter = true, keyPath = "marginTop", required = true)
        Number getMarginTop();

        @XBridgeParamField(isGetter = false, keyPath = "marginBottom", required = true)
        void setMarginBottom(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "marginLeft", required = true)
        void setMarginLeft(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "marginRight", required = true)
        void setMarginRight(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "marginTop", required = true)
        void setMarginTop(Number r100);
    }

    @XBridgeParamModel
    public interface c extends XBaseParamModel {
    }

    @XBridgeResultModel
    public interface d extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = com.heytap.mcssdk.constant.b.f276371u, required = true)
        String getAppID();

        @XBridgeParamField(isGetter = true, keyPath = "appName", required = true)
        String getAppName();

        @XBridgeParamField(isGetter = true, keyPath = "appTheme", required = true)
        String getAppTheme();

        @XBridgeParamField(isGetter = true, keyPath = "appVersion", required = true)
        String getAppVersion();

        @XBridgeParamField(isGetter = true, keyPath = Constants.OperatorKey.KEY_CARRIER, required = true)
        String getCarrier();

        @XBridgeParamField(isGetter = true, keyPath = "channel", required = true)
        String getChannel();

        @XBridgeParamField(isGetter = true, keyPath = "deviceID", required = true)
        String getDeviceID();

        @XBridgeParamField(isGetter = true, keyPath = "deviceModel", required = true)
        String getDeviceModel();

        @XBridgeParamField(isGetter = true, keyPath = "devicePlatform", required = true)
        String getDevicePlatform();

        @XBridgeParamField(isGetter = true, keyPath = "idfa", required = false)
        String getIdfa();

        @XBridgeParamField(isGetter = true, keyPath = "installID", required = true)
        String getInstallID();

        @XBridgeParamField(isGetter = true, keyPath = "language", required = true)
        String getLanguage();

        @XBridgeParamField(isGetter = true, keyPath = OnekeyLoginConstants.NET_TYPE, required = true)
        String getNetType();

        @XBridgeParamField(isGetter = true, keyPath = "networkQuality", required = true)
        Number getNetworkQuality();

        @XBridgeParamField(isGetter = true, keyPath = "networkType", required = true)
        String getNetworkType();

        @XBridgeParamField(isGetter = true, keyPath = "osVersion", required = true)
        String getOsVersion();

        @XBridgeParamField(isGetter = true, keyPath = "safeArea", nestedClassType = b.class, required = false)
        b getSafeArea();

        @XBridgeParamField(isGetter = true, keyPath = "screenHeight", required = true)
        Number getScreenHeight();

        @XBridgeStringEnum(option = {"landscape", "portrait"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "screenOrientation", required = true)
        String getScreenOrientation();

        @XBridgeParamField(isGetter = true, keyPath = "screenWidth", required = true)
        Number getScreenWidth();

        @XBridgeParamField(isGetter = true, keyPath = "statusBarHeight", required = true)
        Number getStatusBarHeight();

        @XBridgeParamField(isGetter = true, keyPath = "updateVersionCode", required = true)
        String getUpdateVersionCode();

        @XBridgeParamField(isGetter = true, keyPath = "is32Bit", required = true)
        Boolean is32Bit();

        @XBridgeParamField(isGetter = true, keyPath = "isBaseMode", required = true)
        Boolean isBaseMode();

        @XBridgeParamField(isGetter = true, keyPath = "isTeenMode", required = true)
        Boolean isTeenMode();

        @XBridgeParamField(isGetter = false, keyPath = "is32Bit", required = true)
        void set32Bit(Boolean r100);

        @XBridgeParamField(isGetter = false, keyPath = com.heytap.mcssdk.constant.b.f276371u, required = true)
        void setAppID(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "appName", required = true)
        void setAppName(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "appTheme", required = true)
        void setAppTheme(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "appVersion", required = true)
        void setAppVersion(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "isBaseMode", required = true)
        void setBaseMode(Boolean r100);

        @XBridgeParamField(isGetter = false, keyPath = Constants.OperatorKey.KEY_CARRIER, required = true)
        void setCarrier(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "channel", required = true)
        void setChannel(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "deviceID", required = true)
        void setDeviceID(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "deviceModel", required = true)
        void setDeviceModel(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "devicePlatform", required = true)
        void setDevicePlatform(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "idfa", required = false)
        void setIdfa(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "installID", required = true)
        void setInstallID(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "language", required = true)
        void setLanguage(String r100);

        @XBridgeParamField(isGetter = false, keyPath = OnekeyLoginConstants.NET_TYPE, required = true)
        void setNetType(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "networkQuality", required = true)
        void setNetworkQuality(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "networkType", required = true)
        void setNetworkType(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "osVersion", required = true)
        void setOsVersion(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "safeArea", nestedClassType = b.class, required = false)
        void setSafeArea(b r100);

        @XBridgeParamField(isGetter = false, keyPath = "screenHeight", required = true)
        void setScreenHeight(Number r100);

        @XBridgeStringEnum(option = {"landscape", "portrait"})
        @XBridgeParamField(isEnum = true, isGetter = false, keyPath = "screenOrientation", required = true)
        void setScreenOrientation(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "screenWidth", required = true)
        void setScreenWidth(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "statusBarHeight", required = true)
        void setStatusBarHeight(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "isTeenMode", required = true)
        void setTeenMode(Boolean r100);

        @XBridgeParamField(isGetter = false, keyPath = "updateVersionCode", required = true)
        void setUpdateVersionCode(String r100);
    }

    static {
        f554202c = MapsKt.mapOf(TuplesKt.to("TicketID", "38885"));
    }

    public a() {
        this.f554203a = "x.getAppInfo";
        this.f554204b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f554204b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f554203a;
    }
}
