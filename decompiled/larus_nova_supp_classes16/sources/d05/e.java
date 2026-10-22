package d05;

import com.bytedance.ee.bear.document.appsetting.FeatureGatingKey;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import io.reactivex.Flowable;
import java.util.List;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements tb5.i<FeatureGatingKey> {
    public e() {
    }

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r4, final m r5) {
        FeatureGatingKey r6 = (FeatureGatingKey) r4;
        if (r5 != null) goto L5;
        tt5.a.d("FeatureGatingConfigHand", "handle, callback is null, data = " + r6);
        return;
    L5:
        if (r6 != null) goto L7;
        tt5.a.d("FeatureGatingConfigHand", "handle, data is null");
        return;
    L7:
        final List<String> r1 = r6.getFeatureGatingKeys();
        if (r1 != null) goto L10;
        tt5.a.d("FeatureGatingConfigHand", "handle, featureGatingKeys is null, data = " + r6);
        return;
    L10:
        tt5.a.b("FeatureGatingConfigHand", "handle, featureGatingKeys size = " + r1.size());
        Flowable.just("").observeOn(fo5.d.b()).map(new b(r1)).subscribe(new c(r5), new d());
    }
}
