package tl5;

import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.rn.RnSyncManager;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements tb5.i<String> {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2.-CC.$default$authType(this);
    }

    public final void handle(Object r3, m r4) {
        String r5 = (String) r3;
        Intrinsics.checkNotNullParameter(r4, "callback");
        StringBuilder r0 = new StringBuilder("handle()... data nul is ");
        if (r5 != null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        r0.append("  callback: ");
        r0.append(r4);
        tt5.a.h("ReloadHandler", r0.toString());
        if (r5 == null) goto L10;
        RnSyncManager r6 = RnSyncManager.a;
        RnSyncManager.i();
        d r7 = new d(r4);
        Intrinsics.checkNotNullParameter(r7, "iRnConnectStatus");
        RnSyncManager.u.add(r7);
        return;
    L10:
        return;
    L5:
        r1 = false;
        goto L6
    }
}
