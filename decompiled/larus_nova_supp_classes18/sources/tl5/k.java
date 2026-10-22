package tl5;

import android.text.TextUtils;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerRunOnNotUIThread;
import com.bytedance.ee.bear.jsbridge.Message;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.rn.RnSyncManager;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k implements tb5.h<String> {
    public final String a;

    public static final class a {
    }

    static {
    }

    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerRunOnNotUIThread.-CC.$default$authType(this);
    }

    public k(String r2) {
        Intrinsics.checkNotNullParameter(r2, "webViewId");
        this.a = r2;
    }

    public final void handle(Object r2, m r3) {
        String r4 = (String) r2;
        Intrinsics.checkNotNullParameter(r3, "callback");
        if (TextUtils.isEmpty(r4) == false) goto L5;
    L9:
        if (r4 == null) goto L14;
        JSONObject r5 = new JSONObject(r4);
        r5.put("webviewId", this.a);
        String r6 = r5.toString();
        RnSyncManager r7 = RnSyncManager.a;
        Intrinsics.checkNotNullParameter(r6, "message");
        Message r8 = new Message();
        r8.c = r6;
        wl5.f r9 = RnSyncManager.j;
        if (r9 == null) goto L15;
        r9.d(r8.b());
        return;
    L15:
        return;
    L14:
        return;
    L5:
        if (r4.contains("heartbeats") == false) goto L9;
        if (r4.contains("currentHeartbeatContent") == false) goto L9;
        tt5.a.h("SendMessageHandler", r4);
        goto L9
    }
}
