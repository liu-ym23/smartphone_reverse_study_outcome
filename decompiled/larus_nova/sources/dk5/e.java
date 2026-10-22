package dk5;

import android.app.Application;
import com.alibaba.fastjson.TypeReference;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.notification.bean.NotificationResult;
import com.bytedance.ee.bear.rn.RnPushProtocol;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetService f469003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ck5.i f469004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RnPushProtocol f469005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public dk5.c f469006d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f469007e;

    public class a implements Consumer<Result> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f469008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f469009b;

        @Override // io.reactivex.functions.Consumer
        public final void accept(Result r100) throws Exception {
            Iterator r101 = this.f469008a.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            String r102 = (String) r101.next();
            e r103 = this.f469009b;
            r103.getClass();
            fo5.d.b().scheduleDirect(new i(r103, r102));
            goto L4
        }

        public a(e r100, List r101) {
            this.f469009b = r100;
            this.f469008a = r101;
        }
    }

    public class b implements Consumer<Throwable> {
        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Throwable r100) throws Exception {
            tt5.a.e("NotificationRepository", "syncCloseNotification failed", r100, false);
        }
    }

    public class c extends TypeReference<Result<NotificationResult>> {
        public c() {
        }
    }

    public e() {
        Application r100 = eu5.b.f474075a;
        if (ck5.i.f24043a == null) goto L5;
    L14:
        this.f469004b = ck5.i.f24043a;
        this.f469003a = (NetService) org.koin.java.a.a(NetService.class);
        this.f469007e = ((s45.c) org.koin.java.a.a(s45.c.class)).getString("unitID", "cn");
        this.f469005c = (RnPushProtocol) org.koin.java.a.b(RnPushProtocol.class, RnPushProtocol.VersionQualifier.Default, new d(this));
        return;
    L5:
        monitor-enter(ck5.i.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (ck5.i.f24043a != null) goto L9;
        ck5.i.f24043a = new ck5.i(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(ck5.i.class);     // Catch: Throwable -> L11
        goto L14
    }

    static {
    }

    public final void a(List<String> r100) {
        NetService.d r101 = this.f469003a.Rb(Result.class);
        NetService.f r102 = new NetService.f("/api/bulletin/close/");
        r102.f216906c = 1;
        HashMap r103 = new HashMap();
        r103.put("id", r100);
        ((HashMap) r102.f216910g).putAll(r103);
        r101.a(r102).subscribe(new a(this, r100), new b());
    }
}
