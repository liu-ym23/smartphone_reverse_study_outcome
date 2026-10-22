package pe5;

import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.setting.CCMLynxSettingsConfig;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public class a extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f528715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final XBridgeMethod.Access f528716b;

    /* JADX INFO: renamed from: pe5.a$a, reason: collision with other inner class name */
    public static final class C7186a {
    }

    static {
    }

    public a() {
        this.f528715a = "ccm.getSettings";
        this.f528716b = XBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final XBridgeMethod.Access getAccess() {
        return this.f528716b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public String getName() {
        return this.f528715a;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r100, XBridgeMethod.Callback r101, XBridgePlatformType r110) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r110, "type");
        String r102 = (String) c.a.f206237a.d(CCMLynxSettingsConfig.CONFIG_NAME, SliceInitService.DEFAULT_SWITCH);
        tt5.a.h("CCMGetSettingMethod", "getLynxSettings, config size: " + r102.length());
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("settings", r102);
        XCoreBridgeMethod.onSuccess$default(this, r101, r103, null, 4, null);
    }
}
