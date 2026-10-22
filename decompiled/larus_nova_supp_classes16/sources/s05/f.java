package s05;

import com.bytedance.ee.bear.doccomponent.api.entity.ComponentInvokeResult;
import com.bytedance.ee.bear.document.doccomponent.impl.WebDocComponentImpl;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import kotlin.jvm.internal.TypeIntrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements i<ComponentInvokeResult> {
    public final /* synthetic */ WebDocComponentImpl a;

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public f(WebDocComponentImpl r1) {
        this.a = r1;
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r3, m r4) {
        ComponentInvokeResult r5 = (ComponentInvokeResult) r3;
        StringBuilder r0 = new StringBuilder("JSB_CALLBACK_NATIVE result=");
        if (r5 == null) goto L5;
        String r1 = r5.toString();
    L6:
        r0.append(du5.b.k(r1));
        r0.append(" callback=");
        r0.append(r4);
        tt5.a.h("DComponent_DocComponentWebImpl", r0.toString());
        if (r5 == null) goto L19;
        d r6 = this.a.c;     // Catch: Throwable -> L13
        String r7 = r5.getCallbackId();     // Catch: Throwable -> L13
        qz4.a r8 = (qz4.a) TypeIntrinsics.asMutableMap(r6.a).remove(r7);     // Catch: Throwable -> L13
        if (r8 == null) goto L18;
        r8.a();     // Catch: Throwable -> L13
        return;
    L18:
        return;
    L13:
        th = move-exception;
        tt5.a.f("DComponent_DocComponentWebImpl", th, false);
        return;
    L19:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
