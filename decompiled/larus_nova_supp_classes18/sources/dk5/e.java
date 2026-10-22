package dk5;

import android.app.Application;
import com.alibaba.fastjson.TypeReference;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.notification.bean.NotificationResult;
import com.bytedance.ee.bear.rn.RnPushProtocol;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public final NetService a;
    public final ck5.i b;
    public RnPushProtocol c;
    public dk5.c d;
    public String e;

    public class a implements Consumer<Result> {
        public final /* synthetic */ List a;
        public final /* synthetic */ e b;

        public final void accept(Object r5) throws Exception {
            Result r6 = (Result) r5;
            Iterator r7 = this.a.iterator();
        L4:
            if (r7.hasNext() == false) goto L6;
            String r0 = (String) r7.next();
            e r1 = this.b;
            r1.getClass();
            fo5.d.b().scheduleDirect(new i(r1, r0));
            goto L4
        }

        public a(e r1, List r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class b implements Consumer<Throwable> {
        public b() {
        }

        public final void accept(Object r4) throws Exception {
            tt5.a.e("NotificationRepository", "syncCloseNotification failed", (Throwable) r4, false);
        }
    }

    public class c extends TypeReference<Result<NotificationResult>> {
        public c() {
        }
    }

    public e() {
        Application r0 = eu5.b.a;
        if (ck5.i.a == null) goto L5;
    L14:
        this.b = ck5.i.a;
        this.a = (NetService) org.koin.java.a.a(NetService.class);
        this.e = ((s45.c) org.koin.java.a.a(s45.c.class)).getString("unitID", "cn");
        this.c = (RnPushProtocol) org.koin.java.a.b(RnPushProtocol.class, RnPushProtocol.VersionQualifier.Default, new d(this));
        return;
    L5:
        monitor-enter(ck5.i.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (ck5.i.a != null) goto L9;
        ck5.i.a = new ck5.i(r0);     // Catch: Throwable -> L11
    L9:
        monitor-exit(ck5.i.class);     // Catch: Throwable -> L11
        goto L14
    }

    static {
    }

    public final void a(List<String> r5) {
        NetService.d r0 = this.a.Rb(Result.class);
        NetService.f r1 = new NetService.f("/api/bulletin/close/");
        ((NetService.e) r1).c = 1;
        HashMap r2 = new HashMap();
        r2.put(ResourceData.KEY_ID, r5);
        ((HashMap) ((NetService.e) r1).g).putAll(r2);
        r0.a(r1).subscribe(new a(this, r5), new b());
    }
}
