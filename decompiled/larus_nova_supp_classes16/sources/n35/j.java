package n35;

import android.text.TextUtils;
import com.bytedance.ee.bear.document.offline.base.OfflineTransferModel;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Executor;
import k25.e0;
import k25.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j implements tb5.h<OfflineTransferModel> {
    public final String a;
    public final Executor b;

    public j() {
        this.a = "Office_GetDataHandler";
        this.b = e0.r();
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final BridgeAuthType authType() {
        return BridgeAuthType.Private;
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final void handle(Object r9, final tb5.m r10) {
        final OfflineTransferModel r3 = (OfflineTransferModel) r9;
        final long r4 = System.currentTimeMillis();
        if (r3 == null) goto L11;
        final m0 r2 = r3.parseResourceData();
        if (r2 == null) goto L11;
        if (TextUtils.isEmpty(r2.b) == true) goto L11;
        if (TextUtils.isEmpty(r2.k) == true) goto L11;
        Flowable.just("").observeOn(Schedulers.from(this.b)).subscribe(new h(this, r2, r3, r4, r10), new i(this, r10));
        return;
    L11:
        d25.d.h("", r10);
        tt5.a.k(this.a, "GetDataHandler.handle: model is null ");
    }
}
