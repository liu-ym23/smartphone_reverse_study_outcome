package tl5;

import android.text.TextUtils;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerRunOnNotUIThread$CC;
import com.bytedance.ee.bear.jsbridge.Message;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.rn.RnSyncManager;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tb5.m;

/* JADX INFO: loaded from: classes18.dex */
public final class k implements tb5.h<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f546635a;

    public static final class a {
    }

    static {
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerRunOnNotUIThread$CC.$default$authType(this);
    }

    public k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "webViewId");
        this.f546635a = r100;
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final void handle(Object r100, m r101) {
        String r102 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (TextUtils.isEmpty(r102) == false) goto L5;
    L9:
        if (r102 == null) goto L14;
        JSONObject r103 = new JSONObject(r102);
        r103.put("webviewId", this.f546635a);
        String r104 = r103.toString();
        RnSyncManager r105 = RnSyncManager.f236496a;
        Intrinsics.checkNotNullParameter(r104, "message");
        Message r106 = new Message();
        r106.f227152c = r104;
        wl5.f r107 = RnSyncManager.f236505j;
        if (r107 == null) goto L15;
        r107.d(r106.b());
        return;
    L15:
        return;
    L14:
        return;
    L5:
        if (r102.contains("heartbeats") == false) goto L9;
        if (r102.contains("currentHeartbeatContent") == false) goto L9;
        tt5.a.h("SendMessageHandler", r102);
        goto L9
    }
}
