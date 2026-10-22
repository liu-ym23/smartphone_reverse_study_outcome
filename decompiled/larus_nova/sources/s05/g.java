package s05;

import com.bytedance.ee.bear.doccomponent.api.entity.DocComponentBizEvent;
import com.bytedance.ee.bear.document.doccomponent.impl.WebDocComponentImpl;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
public final class g implements i<DocComponentBizEvent> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebDocComponentImpl f540022a;

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public g(WebDocComponentImpl r100) {
        this.f540022a = r100;
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r100, m r101) {
        DocComponentBizEvent r102 = (DocComponentBizEvent) r100;
        StringBuilder r103 = new StringBuilder("JSB_INVOKE_NATIVE result=");
        if (r102 == null) goto L5;
        String r104 = r102.toString();
    L6:
        r103.append(du5.b.k(r104));
        r103.append(" cb=");
        r103.append(r101);
        tt5.a.h("DComponent_DocComponentWebImpl", r103.toString());
        if (r102 == null) goto L29;
        r102.setCallBack(r101);     // Catch: Throwable -> L22
        d r105 = this.f540022a.f219529c;     // Catch: Throwable -> L22
        String r106 = r102.getCommand();     // Catch: Throwable -> L22
        String r107 = "";
        if (r106 != null) goto L13;
        r106 = "";
    L13:
        String r108 = r102.getModule();     // Catch: Throwable -> L22
        if (r108 == null) goto L17;
        r107 = r108;
    L17:
        qz4.b r109 = r105.a(r106, r107);     // Catch: Throwable -> L22
        if (r109 != null) goto L20;
        tt5.a.k("DComponent_DocComponentWebImpl", "JSB_INVOKE_NATIVE handler is null");     // Catch: Throwable -> L22
    L25:
        return;
    L20:
        r109.onEvent(r102);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        tt5.a.f("DComponent_DocComponentWebImpl", th, false);
        return;
    L29:
        return;
    L5:
        r104 = null;
        goto L6
    }
}
