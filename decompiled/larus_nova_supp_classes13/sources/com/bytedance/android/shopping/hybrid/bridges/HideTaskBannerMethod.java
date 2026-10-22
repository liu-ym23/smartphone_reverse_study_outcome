package com.bytedance.android.shopping.hybrid.bridges;

import com.bytedance.android.ec.core.hybrid.widgets.LynxTaskBanner;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/hybrid/bridges/HideTaskBannerMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HideTaskBannerMethod extends ECBaseBridgeMethod {

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return "ecomHideTaskBanner";
    }

    public HideTaskBannerMethod() {
    }

    public final void c(JSONObject r4, ECBaseBridgeMethod.a r5) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "iReturn");
        String r6 = r4.optString("containerID");
        Map r0 = LynxTaskBanner.i;
        if (r6 != null) goto L5;
        boolean r2 = false;
    L10:
        if (r2 == false) goto L17;
        r5.onSuccess(new JSONObject());
        WeakReference<Function1<String, Unit>> r7 = com.bytedance.android.shopping.hybrid.bridges.a.b;
        if (r7 == null) goto L14;
        Function1<String, Unit> r8 = r7.get();
    L15:
        if (r8 == null) goto L19;
        Unit r9 = (Unit) r8.invoke(r6);
        return;
    L19:
        return;
    L14:
        r8 = null;
        goto L15
    L17:
        r5.onFailed(0, "invalid containerID");
        return;
    L5:
        Map r1 = LynxTaskBanner.i;
        LynxTaskBanner r3 = (LynxTaskBanner) ((LinkedHashMap) r1).get(r6);
        if (r3 == null) goto L8;
        r3.b();
        r2 = true;
    L9:
        r1.remove(r6);
        goto L10
    L8:
        r2 = false;
        goto L9
    }
}
