package ok7;

import android.content.Context;
import android.content.Intent;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.LinkedHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "luckydogJumpDebug", owner = "maochangtong")
public final class g extends a {
    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return "luckydogJumpDebug";
    }

    public g() {
    }

    @Override // ok7.a
    public final void e(XReadableMap r110, i r111) {
        rk7.m r100 = rk7.m.f538361o;
        if (rk7.m.f538357k == false) goto L37;
        String r101 = r110.getString("debug_page");
        xl7.b r102 = rk7.o.f538364a;
        boolean r103 = true;
        if (r101 != null) goto L7;
    L10:
        boolean r104 = true;
    L11:
        if (r104 == true) goto L32;
        JSONObject r105 = rk7.o.f538366c;
        if (r105 == null) goto L16;
        String r106 = r105.optString(r101);
    L17:
        if (r106 != null) goto L19;
    L22:
        boolean r107 = true;
    L24:
        if (r107 == false) goto L39;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckydogDebugHelper", "未找到测试页类名");
        goto L32
    L39:
        Context r108 = r100.e();     // Catch: Throwable -> L30
        Intent r109 = new Intent(r108, rk7.o.a(r106));     // Catch: Throwable -> L30
        r109.setFlags(268435456);     // Catch: Throwable -> L30
        if (r108 == null) goto L33;
        r108.startActivity(r109);     // Catch: Throwable -> L30
    L33:
        LinkedHashMap r112 = new LinkedHashMap();
        if (r103 == false) goto L36;
        onSuccess(r111, r112, "success");
        return;
    L36:
        XCoreBridgeMethod.onFailure$default(this, r111, -5, "fail", null, 8, null);
        return;
    L30:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.c("LuckydogDebugHelper", th.getLocalizedMessage(), th);
        goto L32
    L19:
        if (r106.length() == 0) goto L22;
        r107 = false;
        goto L24
    L16:
        r106 = null;
    L32:
        r103 = false;
        goto L33
    L7:
        if (r101.length() == 0) goto L10;
        r104 = false;
        goto L11
    L37:
        XCoreBridgeMethod.onFailure$default(this, r111, -5, "fail", null, 8, null);
    }
}
