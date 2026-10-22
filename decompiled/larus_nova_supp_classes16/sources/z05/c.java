package z05;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.editionmanager.executor.k;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ d a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ c15.a d;

    public /* synthetic */ c(d r1, String r2, int r3, c15.a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d r0 = this.a;
        String r1 = this.b;
        int r2 = this.c;
        final c15.a r3 = this.d;
        NetService.d r4 = r0.a.a.Vc(new k.a());
        String r5 = String.valueOf(r2);
        NetService.e r6 = new NetService.f("/space/api/meta/");
        r6.c = 2;
        r6.b("token", r1);
        r6.b("type", r5);
        HashMap r7 = new HashMap();
        r7.put("Content-Type", "application/json");
        r6.c(r7);
        r4.a(r6).subscribe(new com.bytedance.ee.bear.document.editionmanager.executor.g(r3), new com.bytedance.ee.bear.document.editionmanager.executor.h(r3));
    }
}
