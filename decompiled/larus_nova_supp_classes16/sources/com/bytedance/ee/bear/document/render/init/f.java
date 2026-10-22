package com.bytedance.ee.bear.document.render.init;

import android.view.View;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.g7;
import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.bear.document.y3;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements g7 {
    public final /* synthetic */ ChameleonPluginHost a;
    public final /* synthetic */ DocViewModel b;
    public final /* synthetic */ DocumentLoaderV3 c;

    @Override // vv4.b
    public final tb5.n getBridge() {
        return this.a.getWeb().getBridge();
    }

    @Override // com.bytedance.ee.bear.document.e4
    public final View getContentView() {
        return this.a.getWeb().getWebView();
    }

    @Override // com.bytedance.ee.bear.document.g7
    public final vv4.k getWeb() {
        return this.a.getWeb();
    }

    @Override // com.bytedance.ee.bear.document.e4
    public final x2 getDocumentLoader() {
        return this.c;
    }

    @Override // com.bytedance.ee.bear.document.e4
    public final y3 getDocumentMetadata() {
        return this.b;
    }

    public f(ChameleonPluginHost r1, DocViewModel r2, DocumentLoaderV3 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
