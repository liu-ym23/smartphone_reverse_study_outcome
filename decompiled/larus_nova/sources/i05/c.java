package i05;

import android.text.TextUtils;
import com.bytedance.ee.bear.document.bridgestatus.BridgeReadyModel;
import com.bytedance.ee.bear.document.f1;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements i<BridgeReadyModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f487878a;

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public c(f1 r100) {
        this.f487878a = r100;
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r100, m r101) {
        BridgeReadyModel r102 = (BridgeReadyModel) r100;
        tt5.a.b("BridgeReadyHandler", "handle()... ");
        if (this.f487878a == null) goto L9;
        if (r102 == null) goto L9;
        if (TextUtils.isEmpty(r102.getType()) == true) goto L9;
        this.f487878a.a(r102);
        return;
    L9:
        StringBuilder r103 = new StringBuilder("readyHandler data: ");
        if (r102 != null) goto L12;
        String r104 = "";
    L13:
        r103.append(r104);
        tt5.a.h("BridgeReadyHandler", r103.toString());
        return;
    L12:
        r104 = r102.toString();
        goto L13
    }
}
