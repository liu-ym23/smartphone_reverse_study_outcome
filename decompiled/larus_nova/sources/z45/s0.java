package z45;

import com.bytedance.ee.bear.drive.biz.cache.manual.model.ManualOfflineSyncDeletedTokenData;
import java.util.Iterator;

/* JADX INFO: loaded from: classes16.dex */
public final class s0 extends n75.b<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ManualOfflineSyncDeletedTokenData f570003a;

    public s0(ManualOfflineSyncDeletedTokenData r100) {
        this.f570003a = r100;
    }

    @Override // n75.b
    public final void a(n75.a<String> r100) throws Exception {
        Iterator<ManualOfflineSyncDeletedTokenData.Token> r101 = this.f570003a.getTokens().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        ManualOfflineSyncDeletedTokenData.Token r102 = r101.next();
        if (r102.getType() != sbb.e.f541301l.f541317b) goto L4;
        r100.onNext(r102.getToken());
        goto L4
    L9:
        r100.onComplete();
    }
}
