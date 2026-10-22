package m25;

import com.bytedance.ee.bear.contract.offline.OfflineRenameData;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements i<OfflineRenameData> {
    public d() {
    }

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r2, m r3) {
        final OfflineRenameData r4 = (OfflineRenameData) r2;
        tt5.a.h("OfflineRenameHandler", "OfflineRenameHandler.handler: 32 data=" + r4);
        Flowable.just(Boolean.TRUE).map(new a(r4)).subscribeOn(fo5.d.b()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r4), new c());
    }
}
