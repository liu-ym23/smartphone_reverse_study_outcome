package z45;

import io.reactivex.Flowable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l0 extends com.bytedance.ee.bear.contract.q0 {
    public final /* synthetic */ j0 a;

    public l0(j0 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.contract.q0, com.bytedance.ee.bear.contract.c0.d
    public final void a(String r3) {
        tt5.a.k("DRIVE_MANUAL_CACHE", "ListDataChangeCallback delete file");
        ArrayList r0 = new ArrayList();
        r0.add(r3);
        this.a.a.getClass();
        Flowable.just(r0).observeOn(fo5.d.b()).map(new com.bytedance.ee.bear.drive.cache.i()).doOnError(new com.bytedance.ee.bear.drive.cache.j()).subscribe(new com.bytedance.ee.bear.bitable.homepage.list.a0(), new k0());
    }
}
