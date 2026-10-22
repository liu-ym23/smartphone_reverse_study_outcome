package dz5;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f470581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PthreadHandlerThreadV2 f470582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f470583c;

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f470584a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            dz5.a r101 = (dz5.a) r100.obj;
            r101.a();
            if (r101.f470580a <= 0) goto L6;
            int r102 = r100.what;
            Message r103 = this.f470584a.f470581a.obtainMessage(r102);
            r103.obj = r101;
            this.f470584a.f470581a.sendMessageDelayed(r103, r101.f470580a);
            return;
        }

        public a(b r100, Looper r101) {
            this.f470584a = r100;
            super(r101);
        }
    }

    public final void a() {
        if (this.f470581a != null) goto L5;
    L6:
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2(this.f470583c, 3);
        this.f470582b = r100;
        ThreadMethodProxy.start(r100);
        this.f470581a = new a(this, this.f470582b.getLooper());
        return;
    L5:
        if (this.f470582b.getLooper() == null) goto L6;
    }

    public b(String r100) {
        this.f470583c = r100;
        a();
    }

    public final void b(dz5.a r100, long r101, long r102) {
        a();
        int r103 = r100.b();
        r100.f470580a = r102;
        Message r104 = this.f470581a.obtainMessage(r103);
        r104.obj = r100;
        r104.what = r103;
        this.f470581a.sendMessageDelayed(r104, r101);
    }
}
