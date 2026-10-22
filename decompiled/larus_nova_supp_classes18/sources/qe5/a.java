package qe5;

import android.content.Context;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends XCoreBridgeMethod {
    public final String a;

    /* JADX INFO: renamed from: qe5.a$a, reason: collision with other inner class name */
    public static final class C0294a {
    }

    static {
    }

    public a() {
        this.a = "ccm.permission.adjustSettingsCallback";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(XReadableMap r8, XBridgeMethod.Callback r9, XBridgePlatformType r10) {
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r9, "callback");
        Intrinsics.checkNotNullParameter(r10, ResourceData.KEY_TYPE);
        if (((Context) provideContext(Context.class)) != null) goto L6;
        tt5.a.d("ccm-lynx: CCMAdjustSettingsCallbackMethod", "handle()...context is null");
        return;
    L6:
        int r11 = r8.getInt("result");
        tt5.a.h("ccm-lynx: CCMAdjustSettingsCallbackMethod", "handle()...result = " + r11);
        jg5.j r12 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        WeakReference<th5.a> r1 = jg5.j.j;
        if (r1 == null) goto L12;
        r12.getClass();
        if (r1.get() == null) goto L12;
        jg5.j.j.get().rU(r11);
    L12:
        if (r12.a == null) goto L14;
        r12.a = null;
    L14:
        XCoreBridgeMethod.onSuccess$default(this, r9, new LinkedHashMap(), null, 4, null);
    }
}
