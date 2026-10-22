package a35;

import com.bytedance.ee.bear.document.offline.sync.sync.SyncStatusModel;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e0 implements tb5.i<SyncStatusModel> {
    public final WeakReference<d0> a;

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public e0(d0 r2) {
        this.a = new WeakReference(r2);
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r1, tb5.m r2) {
        SyncStatusModel r3 = (SyncStatusModel) r1;
        WeakReference<d0> r4 = this.a;
        if (r4 == null) goto L8;
        d0 r5 = r4.get();
        if (r5 == null) goto L9;
        r5.a(r3);
        return;
    L9:
        return;
    }
}
