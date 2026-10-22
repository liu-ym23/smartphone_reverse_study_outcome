package z45;

import com.bytedance.ee.bear.drive.biz.cache.manual.model.ManualOfflineSyncDeletedTokenData;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class s0 extends n75.b<String> {
    public final /* synthetic */ ManualOfflineSyncDeletedTokenData a;

    public s0(ManualOfflineSyncDeletedTokenData r1) {
        this.a = r1;
    }

    @Override // n75.b
    public final void a(n75.a<String> r5) throws Exception {
        Iterator<ManualOfflineSyncDeletedTokenData.Token> r0 = this.a.getTokens().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        ManualOfflineSyncDeletedTokenData.Token r1 = r0.next();
        if (r1.getType() != sbb.e.l.b) goto L4;
        r5.onNext(r1.getToken());
        goto L4
    L9:
        r5.onComplete();
    }
}
