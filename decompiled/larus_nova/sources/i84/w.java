package i84;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.bdinstall.e0;
import com.bytedance.bdinstall.n0;
import com.bytedance.bdinstall.o0;
import com.bytedance.bdinstall.t0;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class w implements e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f488644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t0 f488645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f488646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o0 f488647d;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n0 f488648a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ w f488649b;

        @Override // java.lang.Runnable
        public final void run() {
            t0 r100 = this.f488649b.f488645b;     // Catch: Throwable -> L7
            if (r100 == null) goto L5;
            r100.a(this.f488648a);     // Catch: Throwable -> L7
            w.b(this.f488649b);     // Catch: Throwable -> L7
        L5:
            this.f488649b.f488645b = null;     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        public a(w r100, n0 r101) {
            this.f488649b = r100;
            this.f488648a = r101;
        }
    }

    public static void b(w r100) {
        o0 r101 = r100.f488647d;
        if (r101 != null) goto L5;
    L8:
        com.bytedance.bdinstall.i.f199652b.f199684k.c(r100);
        return;
    L5:
        if (r101.O == true) goto L8;
        String r102 = String.valueOf(r101.f199728a);
        j74.a r103 = com.bytedance.bdinstall.i.f199651a;
        com.bytedance.bdinstall.k.k(r102).f199684k.c(r100);
    }

    @Override // com.bytedance.bdinstall.e0
    public final void a(n0 r100) {
        this.f488646c.post(new a(this, r100));
    }

    public w(long r100, t0 r101, o0 r102) {
        this.f488646c = new Handler(Looper.getMainLooper());
        this.f488644a = r100;
        this.f488645b = r101;
        this.f488647d = r102;
    }
}
