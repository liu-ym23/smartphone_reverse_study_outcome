package z05;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.editionmanager.executor.k;
import io.reactivex.Flowable;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public final k a;

    public d() {
        this.a = new k((NetService) org.koin.java.a.a(NetService.class));
    }

    public final Flowable<g> a(final String r5, int r6, final String r7) {
        g r0 = f.c(r5, r7);
        if (r0 != null) goto L5;
        k r1 = this.a;
        String r8 = String.valueOf(r6);
        r1.getClass();
        NetService.d r2 = ((NetService) org.koin.java.a.a(NetService.class)).Vc(new k.c());
        NetService.e r3 = new NetService.f("/space/api/platform/version/meta/");
        r3.c = 2;
        r3.b(DocViewModel.EXTRA_PARENT_TOKEN, r5);
        r3.b("obj_type", r8);
        r3.b("edition_id", r7);
        r3.b("need_user_info", String.valueOf(true));
        HashMap r9 = new HashMap();
        r9.put("Content-Type", "application/x-www-form-urlencoded");
        r3.c(r9);
        return r2.a(r3).flatMap(new com.bytedance.ee.bear.document.editionmanager.executor.i()).observeOn(fo5.d.a()).map(new b(r5, r7));
    L5:
        return Flowable.just(r0);
    }
}
