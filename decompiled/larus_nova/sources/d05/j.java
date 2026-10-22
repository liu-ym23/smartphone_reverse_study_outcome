package d05;

import com.bytedance.ee.bear.document.appsetting.FeatureGatingKey;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import io.reactivex.Flowable;
import java.util.List;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
public final class j implements tb5.i<FeatureGatingKey> {
    public j() {
    }

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r100, final m r101) {
        FeatureGatingKey r102 = (FeatureGatingKey) r100;
        if (r101 != null) goto L5;
        tt5.a.d("FeatureGatingConfigHand", "handle, callback is null, data = " + r102);
        return;
    L5:
        if (r102 != null) goto L7;
        tt5.a.d("FeatureGatingConfigHand", "handle, data is null");
        return;
    L7:
        final List<String> r103 = r102.getFeatureGatingKeys();
        if (r103 != null) goto L10;
        tt5.a.d("FeatureGatingConfigHand", "handle, featureGatingKeys is null, data = " + r102);
        return;
    L10:
        tt5.a.b("FeatureGatingConfigHand", "handle, featureGatingKeys size = " + r103.size());
        Flowable.just("").observeOn(fo5.d.b()).map(new g(r103)).subscribe(new h(r101), new i());
    }
}
