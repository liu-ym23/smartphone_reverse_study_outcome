package kta;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.hihonor.cloudservice.oaid.IOAIDService;
import com.ss.android.deviceregister.base.honor.HonorOAIDCallback;
import com.ss.android.deviceregister.base.honor.HonorOAIDLimitCallback;

/* JADX INFO: loaded from: classes6.dex */
public final class i extends c<IOAIDService> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HonorOAIDCallback f506106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HonorOAIDLimitCallback f506107d;

    /* JADX INFO: loaded from: classes34.dex */
    public class a implements w.b<IOAIDService, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f506108a;

        public a(i r100) {
            this.f506108a = r100;
        }

        @Override // kta.w.b
        public final String a(IOAIDService r100) throws Exception {
            IOAIDService r101 = r100;
            if (r101 != null) goto L5;
            return null;
        L5:
            r101.getOAID(this.f506108a.f506106c);
            r101.isOAIDTrackingLimited(this.f506108a.f506107d);
            return "";
        }

        @Override // kta.w.b
        public final IOAIDService b(IBinder r100) {
            return IOAIDService.Stub.asInterface(r100);
        }
    }

    public i() {
        super("com.hihonor.id");
        this.f506106c = new HonorOAIDCallback();
        this.f506107d = new HonorOAIDLimitCallback();
    }

    @Override // kta.c
    public final w.b<IOAIDService, String> c() {
        return new a(this);
    }

    @Override // kta.c
    public final Intent b(Context r100) {
        Intent r101 = new Intent();
        r101.setAction("com.hihonor.id.HnOaIdService");
        r101.setPackage("com.hihonor.id");
        return r101;
    }

    @Override // kta.c, kta.o
    public final o.a getOaid(Context r100) {
        o.a r101 = new o.a();
        new w(r100, b(r100), new a(this)).a();     // Catch: Exception -> L5
        r101.f506112a = this.f506106c.getOaid();     // Catch: Exception -> L5
        r101.f506113b = this.f506107d.isLimit();     // Catch: Exception -> L5
        return r101;
    L5:
        e = move-exception;
        e.printStackTrace();
        return r101;
    }
}
