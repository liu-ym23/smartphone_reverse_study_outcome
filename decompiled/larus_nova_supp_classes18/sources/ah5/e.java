package ah5;

import android.content.Context;
import com.bytedance.ee.bear.middleground_permission_export.model.i;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import java.util.ArrayList;
import jg5.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e extends XCoreBridgeMethod implements i {
    public final String a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.i
    public final void sB() {
        XBridgeMethod.b r0 = (XBridgeMethod.b) provideContext(XBridgeMethod.b.class);
        if (r0 == null) goto L6;
        r0.sendJsEvent("ccm.notifyMemberChangeNative", null);
        return;
    }

    public e() {
        this.a = "ccm.registerMemberChange";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(XReadableMap r2, XBridgeMethod.Callback r3, XBridgePlatformType r4) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TYPE);
        if (((Context) provideContext(Context.class)) != null) goto L7;
        tt5.a.d("CCMRegisterMemberChangeMethod", "handle()...context is null");
        return;
    L7:
        if (s.b(r2, "isRegister", true) == false) goto L9;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().m(this);
        return;
    L9:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().getClass();
        ((ArrayList) j.b).remove(this);
    }
}
