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

/* JADX INFO: loaded from: classes16.dex */
public final class d implements i<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebViewLoadStateWebService f221409a;

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public d(WebViewLoadStateWebService r100) {
        this.f221409a = r100;
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r100, m r101) {
        String r102 = (String) r100;
        Intrinsics.checkNotNullParameter(r102, "data");
        WebViewLoadStateWebService r103 = this.f221409a;
        r103.f221395d = true;
        tt5.a.h(r103.f221392a, "==openDocs==preload== preloadJsModule...");
        long r104 = new JSONObject(new JSONObject(r102).optString("data")).optLong("templateBeginTime");     // Catch: Throwable -> L5
    L7:
        ((f) this.f221409a.f221399h.getValue()).l(this.f221409a.f221398g, r104);
        WebViewLoadStateWebService r105 = this.f221409a;
        r105.e((String[]) r105.f221394c.toArray(new String[0]));
        IChameleonHandlerContext r106 = this.f221409a.getChameleonContext();
        if (r106 == null) goto L15;
        IChameleonLoader r107 = r106.getWebviewLoader();
        if (r107 == null) goto L16;
        r107.onLoadSuccess();
        return;
    L16:
        return;
    L15:
        return;
    L5:
        th = move-exception;
        tt5.a.f(this.f221409a.f221392a, th, false);
        r104 = 0;
        goto L7
    }
}
