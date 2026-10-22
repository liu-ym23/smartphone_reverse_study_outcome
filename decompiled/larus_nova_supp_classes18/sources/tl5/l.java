package tl5;

import android.text.TextUtils;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l implements tb5.i<String> {
    public m a;
    public final List<m> b;

    public static final class a {
    }

    static {
    }

    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2.-CC.$default$authType(this);
    }

    public l() {
        this.b = new ArrayList();
    }

    public final void a(m r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        if (((ArrayList) this.b).contains(r3) == true) goto L6;
        ((ArrayList) this.b).add(r3);
        tt5.a.h("SendMessageToWebviewHandler", "addFollowWebViewCallback callback: " + r3.hashCode() + " size: " + ((ArrayList) this.b).size());
        return;
    }

    public final void c(m r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        ((ArrayList) this.b).remove(r3);
        tt5.a.h("SendMessageToWebviewHandler", "removeFollowWebViewCallback callback: " + r3.hashCode() + " size: " + ((ArrayList) this.b).size());
    }

    public final void handle(Object r2, m r3) {
        String r4 = (String) r2;
        Intrinsics.checkNotNullParameter(r3, "callback");
        if (TextUtils.isEmpty(r4) == false) goto L5;
    L9:
        if (r4 == null) goto L17;
        m r5 = this.a;
        if (r5 == null) goto L13;
        r5.onCallBack(r4);
    L13:
        Iterator r6 = ((ArrayList) this.b).iterator();
    L15:
        if (r6.hasNext() == false) goto L19;
        ((m) r6.next()).onCallBack(r4);
        goto L15
    L19:
        return;
    L17:
        return;
    L5:
        if (r4.contains("heartbeats") == false) goto L9;
        if (r4.contains("currentHeartbeatContent") == false) goto L9;
        tt5.a.h("SendMessageToWebviewHandler", r4);
        goto L9
    }
}
