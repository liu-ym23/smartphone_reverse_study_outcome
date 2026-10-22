package com.bytedance.ee.bear.document.render.preload;

import com.bytedance.ee.bear.document.render.node.f;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import com.ss.android.lark.chameleon.pluginapi.IChameleonLoader;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements i<String> {
    public final /* synthetic */ WebViewLoadStateWebService a;

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public d(WebViewLoadStateWebService r1) {
        this.a = r1;
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r5, m r6) {
        String r7 = (String) r5;
        Intrinsics.checkNotNullParameter(r7, "data");
        WebViewLoadStateWebService r0 = this.a;
        r0.d = true;
        tt5.a.h(r0.a, "==openDocs==preload== preloadJsModule...");
        long r8 = new JSONObject(new JSONObject(r7).optString("data")).optLong("templateBeginTime");     // Catch: Throwable -> L5
    L7:
        ((f) this.a.h.getValue()).l(this.a.g, r8);
        WebViewLoadStateWebService r9 = this.a;
        r9.e((String[]) r9.c.toArray(new String[0]));
        IChameleonHandlerContext r10 = this.a.getChameleonContext();
        if (r10 == null) goto L15;
        IChameleonLoader r11 = r10.getWebviewLoader();
        if (r11 == null) goto L16;
        r11.onLoadSuccess();
        return;
    L16:
        return;
    L15:
        return;
    L5:
        th = move-exception;
        tt5.a.f(this.a.a, th, false);
        r8 = 0;
        goto L7
    }
}
