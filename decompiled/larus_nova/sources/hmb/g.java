package hmb;

import com.bytedance.ee.bear.doc.resupdate.f0;

/* JADX INFO: loaded from: classes36.dex */
public final class g implements f0 {
    public g() {
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.f0
    public final void onFail() {
        tt5.a.h("DocResourceDownload", "downloadFullResource onFail(): ");
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.f0
    public final void onReady() {
        tt5.a.h("DocResourceDownload", "downloadFullResource onReady(): ");
    }
}
