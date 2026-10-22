package qe5;

import android.content.Context;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i extends XCoreBridgeMethod {
    public final String a;

    public static final class a {
    }

    static {
    }

    public i() {
        this.a = "ccm.permission.showRealNameAuthDialog";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(XReadableMap r5, XBridgeMethod.Callback r6, XBridgePlatformType r7) {
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "callback");
        Intrinsics.checkNotNullParameter(r7, ResourceData.KEY_TYPE);
        Context r8 = (Context) provideContext(Context.class);
        if (r8 != null) goto L6;
        tt5.a.d("ccm-lynx: CCMShowRealNameAuthDialogMethod", "handle()...context is null");
        return;
    L6:
        int r0 = r5.getInt("code");
        String r1 = s.f(r5, ResourceData.KEY_TOKEN, "");
        int r9 = r5.getInt(ResourceData.KEY_TYPE);
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).G8(r8, r1, r9, r0);
    }
}
