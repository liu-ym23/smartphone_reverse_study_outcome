package j35;

import com.bytedance.ee.bear.document.DocBridgeWebViewV2;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f extends c {
    public f(DocBridgeWebViewV2 r1) {
        super(r1);
    }

    @Override // j35.c
    public final Flowable<Boolean> b(final boolean r3, String r4) {
        tt5.a.h("DefaultDocPreLoader", "loadTemplateFlow()... isReloadRN = " + r3);
        final DocBridgeWebViewV2 r5 = this.a;
        return Flowable.just("").observeOn(fo5.d.b()).map(new d(this, r5, r3)).observeOn(fo5.d.d()).map(new e(this));
    }
}
