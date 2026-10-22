package e84;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.bdinstall.honor.HonorOAIDCallback;
import com.bytedance.bdinstall.honor.HonorOAIDLimitCallback;
import com.bytedance.bdinstall.oaid.impl.IOAIDService;
import com.huawei.hms.android.SystemUtils;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends b<IOAIDService> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HonorOAIDCallback f471306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HonorOAIDLimitCallback f471307d;

    /* JADX INFO: loaded from: classes8.dex */
    public class a implements u.b<IOAIDService, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f471308a;

        public a(g r100) {
            this.f471308a = r100;
        }

        @Override // e84.u.b
        public final String a(IOAIDService r100) throws Exception {
            IOAIDService r101 = r100;
            if (r101 != null) goto L5;
            com.bytedance.bdinstall.t.b("honor# service is null");
            return null;
        L5:
            r101.getOAID(this.f471308a.f471306c);
            r101.isOAIDTrackingLimited(this.f471308a.f471307d);
            return "";
        }

        @Override // e84.u.b
        public final IOAIDService b(IBinder r100) {
            return IOAIDService.Stub.asInterface(r100);
        }
    }

    @Override // e84.m
    public final String getName() {
        return SystemUtils.PRODUCT_HONOR;
    }

    public g() {
        super("com.hihonor.id");
        this.f471306c = new HonorOAIDCallback();
        this.f471307d = new HonorOAIDLimitCallback();
    }

    @Override // e84.b
    public final u.b<IOAIDService, String> c() {
        return new a(this);
    }

    @Override // e84.b
    public final Intent b(Context r100) {
        Intent r101 = new Intent();
        r101.setAction("com.hihonor.id.HnOaIdService");
        r101.setPackage("com.hihonor.id");
        return r101;
    }

    @Override // e84.b, e84.m
    public final m.a getOaid(Context r100) {
        m.a r101 = new m.a();
        Intent r102 = b(r100);     // Catch: Exception -> L32
        a r103 = new a(this);     // Catch: Exception -> L32
        CountDownLatch r104 = new CountDownLatch(1);     // Catch: Exception -> L32
        u.a r105 = new u.a(r104, r103);     // Catch: Throwable -> L15
        if (r100.bindService(r102, r105, 1) == false) goto L23;
        r104.await();     // Catch: Throwable -> L15
        r103.a(r105.f471351c);     // Catch: Throwable -> L13
        r100.unbindService(r105);     // Catch: Throwable -> L10
    L10:
        th = th;
    L11:
        th.printStackTrace();     // Catch: Exception -> L32
    L13:
        th = th;
    L38:
        th.printStackTrace();     // Catch: Throwable -> L25
        if (r105 == null) goto L23;
        r100.unbindService(r105);     // Catch: Throwable -> L21
    L21:
        th = th;
        goto L11
    L25:
        th = move-exception;
        if (r105 != null) goto L42;
    L31:
        throw th;     // Catch: Exception -> L32
    L42:
        r100.unbindService(r105);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        th.printStackTrace();     // Catch: Exception -> L32
    L23:
        r101.f471323a = this.f471306c.getOaid();     // Catch: Exception -> L32
        r101.f471324b = this.f471307d.isLimit();     // Catch: Exception -> L32
        com.bytedance.bdinstall.t.a("honor# getOaid " + r101.f471323a);     // Catch: Exception -> L32
        return r101;
    L15:
        th = th;
        r105 = null;
    L32:
        e = move-exception;
        e.printStackTrace();
        return r101;
    }
}
