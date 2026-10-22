package tl5;

import com.bytedance.ee.bear.jsbridge.BridgeHandlerRunOnNotUIThread;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.rn.RnSyncManager;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class a implements tb5.h<String> {

    /* JADX INFO: renamed from: tl5.a$a, reason: collision with other inner class name */
    public static final class C0312a {
    }

    static {
    }

    public a() {
    }

    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerRunOnNotUIThread.-CC.$default$authType(this);
    }

    public void a(String r4, m r5) {
        Intrinsics.checkNotNullParameter(r5, "callback");
        StringBuilder r1 = new StringBuilder("handle()... data nul is ");
        if (r4 != null) goto L5;
        boolean r6 = true;
    L6:
        r1.append(r6);
        r1.append("  callback: ");
        r1.append(r5.hashCode());
        tt5.a.h("HandleMessageHandler", r1.toString());
        RnSyncManager r7 = RnSyncManager.a;
        Intrinsics.checkNotNullParameter(r5, "callback");
        l r8 = RnSyncManager.m;
        if (r8 == null) goto L10;
        tt5.a.h("SendMessageToWebviewHandler", "setWebViewCallback callback: " + Integer.valueOf(r5.hashCode()));
        r8.a = r5;
        return;
    L10:
        return;
    L5:
        r6 = false;
        goto L6
    }
}
