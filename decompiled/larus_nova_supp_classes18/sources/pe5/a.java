package pe5;

import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.setting.CCMLynxSettingsConfig;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class a extends XCoreBridgeMethod {
    public final String a;
    public final XBridgeMethod.Access b;

    /* JADX INFO: renamed from: pe5.a$a, reason: collision with other inner class name */
    public static final class C0288a {
    }

    static {
    }

    public a() {
        this.a = "ccm.getSettings";
        this.b = XBridgeMethod.Access.PROTECT;
    }

    public final XBridgeMethod.Access getAccess() {
        return this.b;
    }

    public String getName() {
        return this.a;
    }

    public final void handle(XReadableMap r8, XBridgeMethod.Callback r9, XBridgePlatformType r10) {
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r9, "callback");
        Intrinsics.checkNotNullParameter(r10, ResourceData.KEY_TYPE);
        String r11 = (String) c.a.a.d(CCMLynxSettingsConfig.CONFIG_NAME, "{}");
        tt5.a.h("CCMGetSettingMethod", "getLynxSettings, config size: " + r11.length());
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put(BenefitStore.FROM_SETTINGS, r11);
        XCoreBridgeMethod.onSuccess$default(this, r9, r3, null, 4, null);
    }
}
