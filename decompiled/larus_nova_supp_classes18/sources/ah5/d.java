package ah5;

import android.content.Context;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d extends XCoreBridgeMethod {
    public final String a;

    public static final class a {
    }

    static {
    }

    public d() {
        this.a = "ccm.notifyMemberChange";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(XReadableMap r2, XBridgeMethod.Callback r3, XBridgePlatformType r4) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TYPE);
        if (((Context) provideContext(Context.class)) != null) goto L6;
        tt5.a.d("CCMNotifyMemberChangeMethod", "handle()...context is null");
        return;
    L6:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().j(1);
    }
}
