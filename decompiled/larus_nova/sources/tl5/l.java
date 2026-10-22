package tl5;

import android.text.TextUtils;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: classes18.dex */
public final class l implements tb5.i<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f546636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<m> f546637b;

    public static final class a {
    }

    static {
    }

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public l() {
        this.f546637b = new ArrayList();
    }

    public final void a(m r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        if (((ArrayList) this.f546637b).contains(r100) == true) goto L6;
        ((ArrayList) this.f546637b).add(r100);
        tt5.a.h("SendMessageToWebviewHandler", "addFollowWebViewCallback callback: " + r100.hashCode() + " size: " + ((ArrayList) this.f546637b).size());
        return;
    }

    public final void c(m r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        ((ArrayList) this.f546637b).remove(r100);
        tt5.a.h("SendMessageToWebviewHandler", "removeFollowWebViewCallback callback: " + r100.hashCode() + " size: " + ((ArrayList) this.f546637b).size());
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r100, m r101) {
        String r102 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (TextUtils.isEmpty(r102) == false) goto L5;
    L9:
        if (r102 == null) goto L17;
        m r103 = this.f546636a;
        if (r103 == null) goto L13;
        r103.onCallBack(r102);
    L13:
        Iterator r104 = ((ArrayList) this.f546637b).iterator();
    L15:
        if (r104.hasNext() == false) goto L19;
        ((m) r104.next()).onCallBack(r102);
        goto L15
    L19:
        return;
    L17:
        return;
    L5:
        if (r102.contains("heartbeats") == false) goto L9;
        if (r102.contains("currentHeartbeatContent") == false) goto L9;
        tt5.a.h("SendMessageToWebviewHandler", r102);
        goto L9
    }
}
