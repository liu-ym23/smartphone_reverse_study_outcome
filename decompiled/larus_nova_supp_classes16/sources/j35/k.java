package j35;

import com.bytedance.ee.bear.document.DocBridgeWebViewV2;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k extends c {
    public k(DocBridgeWebViewV2 r1) {
        super(r1);
    }

    @Override // j35.c
    public final Flowable<Boolean> b(final boolean r4, final String r5) {
        tt5.a.h("OfflineDocPreLoader", "loadTemplateFlow()... isReloadRN = " + r4);
        final DocBridgeWebViewV2 r0 = this.a;
        return Flowable.just("").observeOn(fo5.d.b()).map(new i(this, r0, r4)).observeOn(fo5.d.d()).concatMap(new j(r0, r5));
    }
}
