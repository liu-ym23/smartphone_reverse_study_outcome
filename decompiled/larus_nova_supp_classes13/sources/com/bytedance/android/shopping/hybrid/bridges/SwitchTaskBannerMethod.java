package com.bytedance.android.shopping.hybrid.bridges;

import com.bytedance.android.ec.core.hybrid.widgets.LynxTaskBanner;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/hybrid/bridges/SwitchTaskBannerMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SwitchTaskBannerMethod extends ECBaseBridgeMethod {

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return "ecomSwtichTaskBannerVisible";
    }

    public SwitchTaskBannerMethod() {
    }

    public final void c(JSONObject r3, ECBaseBridgeMethod.a r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "iReturn");
        String r5 = r3.optString("containerID");
        int r1 = 0;
        if (r3.optInt("visible", 0) != 0) goto L5;
        boolean r6 = true;
    L6:
        Map r0 = LynxTaskBanner.i;
        if (r5 == null) goto L15;
        LynxTaskBanner r2 = (LynxTaskBanner) ((LinkedHashMap) LynxTaskBanner.i).get(r5);
        if (r2 == null) goto L15;
        if (r6 == true) goto L14;
        r1 = 8;
    L14:
        r2.setVisibility(r1);
    L15:
        Function1<String, Unit> r7 = null;
        if (r6 == false) goto L23;
        WeakReference<Function3<JSONObject, String, Boolean, Unit>> r8 = com.bytedance.android.shopping.hybrid.bridges.a.a;
        if (r8 == null) goto L20;
        Function3<JSONObject, String, Boolean, Unit> r9 = r8.get();
    L21:
        if (r9 == null) goto L29;
        Unit r10 = (Unit) r9.invoke(null, r5, Boolean.TRUE);
        return;
    L29:
        return;
    L20:
        r9 = null;
        goto L21
    L23:
        WeakReference<Function1<String, Unit>> r11 = com.bytedance.android.shopping.hybrid.bridges.a.b;
        if (r11 == null) goto L26;
        r7 = r11.get();
    L26:
        if (r7 == null) goto L31;
        Unit r12 = (Unit) r7.invoke(r5);
        return;
    L31:
        return;
    L5:
        r6 = false;
        goto L6
    }
}
