package com.bytedance.ee.bear.document;

import android.text.TextUtils;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class w2 extends com.bytedance.ee.bear.contract.n0 implements LifecycleObserver {
    public final a a;

    public class a extends yv4.e {
        public final /* synthetic */ DocBridgeWebViewV2 g;
        public final /* synthetic */ w2 h;

        @Override // yv4.c, yv4.f
        public final void release() {
            super.release();
            this.g.S(this.h);
        }

        public a(w2 r1, PluginHost r2, DocBridgeWebViewV2 r3) {
            this.h = r1;
            this.g = r3;
            super(r2);
        }
    }

    public class b extends x2.c {
        public final /* synthetic */ DocumentPluginHost a;
        public final /* synthetic */ w2 b;

        @Override // com.bytedance.ee.bear.document.x2.c, com.bytedance.ee.bear.document.x2.b
        public final void onLoadSuccess() {
            DocViewModel r0 = this.a.a();
            if (r0 != null) goto L5;
            return;
        L5:
            if (TextUtils.equals(r0.getDocumentType(), sbb.e.o.getType()) == false) goto L8;
            return;
        L8:
            if (TextUtils.equals(r0.getDocumentType(), sbb.e.g.getType()) == false) goto L10;
            return;
        L10:
            if (TextUtils.equals(r0.getDocumentType(), sbb.e.h.getType()) == false) goto L12;
            return;
        L12:
            if (TextUtils.equals(r0.getDocumentType(), sbb.e.i.getType()) == true) goto L18;
            this.b.a.i();
            return;
        }

        public b(w2 r1, DocumentPluginHost r2) {
            this.b = r1;
            this.a = r2;
        }

        @Override // com.bytedance.ee.bear.document.x2.c, com.bytedance.ee.bear.document.x2.b
        public final void onLoadFail(int r1, Throwable r2) {
            this.b.a.i();
        }
    }

    public w2(DocumentPluginHost r4) {
        vv4.k r0 = r4.getWeb();
        DocBridgeWebViewV2 r1 = (DocBridgeWebViewV2) r0.getWebView();
        r1.C(this);
        a r2 = new a(this, r4, r1);
        this.a = r2;
        ((z4) r0).C(new v2(r2));
        r4.getDocumentLoader().S3(new b(this, r4));
    }

    @Override // com.bytedance.ee.bear.contract.n0, com.bytedance.ee.bear.contract.m0
    public final void m(Map<String, String> r1) {
        this.a.i();
    }
}
