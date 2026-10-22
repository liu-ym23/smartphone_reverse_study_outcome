package com.bytedance.ee.bear.bitable.load.workimpl;

import android.webkit.WebView;
import com.bytedance.ee.bear.bitable.load.AbsLoadWork;
import com.bytedance.ee.bear.document.DocBridgeWebViewV2;
import com.bytedance.ee.bear.document.b5;
import com.bytedance.ee.bear.domain.BearUrl;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public class b extends AbsLoadWork {

    public static final class a {
    }

    static {
    }

    public JSONObject n() {
        throw null;
    }

    @Override // com.bytedance.ee.bear.bitable.load.AbsLoadWork
    public final void d() {
        tt5.a.h("AbsDocumentRenderWork", "renderDocumentWork start ");
        BearUrl r100 = this.f214440a.u();
        String r101 = this.f214440a.l();
        b5 r102 = this.f214444e;
        if (r102 != null) goto L5;
    L25:
        tt5.a.d("AbsDocumentRenderWork", "webView is null");
        return;
    L5:
        if (r102 == null) goto L7;
        WebView r103 = r102.getWebView();
    L8:
        if (r103 == null) goto L25;
        this.f214440a.s().L(r100, r101, null, this.f214440a.getPluginHost().a().getAssociateAppUrl());
        b5 r104 = this.f214444e;
        if (r104 != null) goto L13;
        return;
    L13:
        if (r104.getWebView() == null) goto L30;
        DocBridgeWebViewV2 r105 = this.f214440a.s();
        String r106 = n().toString();     // Catch: Exception -> L21
        if (r106 != null) goto L19;
        r106 = "";
    L19:
        r105.E("extraParams", r106);     // Catch: Exception -> L21
        r105.E(ControlRule.KEY_EXTRA_DATA, "");     // Catch: Exception -> L21
    L23:
        this.f214440a.A("BITABLE_NATIVE_LOAD_URL", System.currentTimeMillis());
        r105.O("", null, false);
        m();
        this.f214441b.m();
        return;
    L21:
        e = move-exception;
        tt5.a.e("AbsDocumentRenderWork", "renderDocumentWork addRenderParams error", e, false);
        goto L23
    L30:
        return;
    L7:
        r103 = null;
        goto L8
    }

    public b(com.bytedance.ee.bear.bitable.load.e r100, com.bytedance.ee.bear.bitable.load.f r101) {
        Intrinsics.checkNotNullParameter(r100, "loadContext");
        Intrinsics.checkNotNullParameter(r101, "loadControl");
        super(r100, r101);
    }
}
