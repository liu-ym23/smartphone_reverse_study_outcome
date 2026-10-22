package tl5;

import com.bytedance.ee.bear.jsbridge.BridgeHandlerRunOnNotUIThread$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.rn.RnSyncManager;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: classes18.dex */
public class a implements tb5.h<String> {

    /* JADX INFO: renamed from: tl5.a$a, reason: collision with other inner class name */
    public static final class C7739a {
    }

    static {
    }

    public a() {
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerRunOnNotUIThread$CC.$default$authType(this);
    }

    public void a(String r100, m r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        StringBuilder r102 = new StringBuilder("handle()... data nul is ");
        if (r100 != null) goto L5;
        boolean r103 = true;
    L6:
        r102.append(r103);
        r102.append("  callback: ");
        r102.append(r101.hashCode());
        tt5.a.h("HandleMessageHandler", r102.toString());
        RnSyncManager r104 = RnSyncManager.f236496a;
        Intrinsics.checkNotNullParameter(r101, "callback");
        l r105 = RnSyncManager.f236508m;
        if (r105 == null) goto L10;
        tt5.a.h("SendMessageToWebviewHandler", "setWebViewCallback callback: " + Integer.valueOf(r101.hashCode()));
        r105.f546636a = r101;
        return;
    L10:
        return;
    L5:
        r103 = false;
        goto L6
    }
}
