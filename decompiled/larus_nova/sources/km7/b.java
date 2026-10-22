package km7;

import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.utils.j;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import ok7.i;
import org.json.JSONObject;
import rk7.m;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "luckydogShowWidgetInstallGuide")
public final class b extends ok7.a {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return "luckydogShowWidgetInstallGuide";
    }

    public b() {
    }

    @Override // ok7.a
    public final void e(XReadableMap r100, i r101) {
        JSONObject r102 = j.d(r100);
        if (m.f538357k == false) goto L6;
        com.bytedance.ug.sdk.luckydog.api.log.a.c("luckydogShowWidgetInstallGuide", "installGuideJson=" + r102);
        return;
    }
}
