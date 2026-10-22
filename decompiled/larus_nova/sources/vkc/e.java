package vkc;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<b> f555578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f555579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f555580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final vkc.a f555581d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public wkc.a f555582e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f555583f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f555584g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f555585h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f555586i;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f555587a;

        /* JADX INFO: renamed from: vkc.e$a$a, reason: collision with other inner class name */
        public class RunnableC8015a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ wkc.a f555588a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f555589b;

            public final void a() {
                e r100 = this.f555589b.f555587a;
                r100.f555583f = false;
                wkc.a r101 = this.f555588a;
                if (r101 != null) goto L9;
                int r102 = r100.f555584g + 1;
                r100.f555584g = r102;
                if (r102 <= r100.f555586i) goto L7;
                return;
            L7:
                long r103 = r100.f555585h;
                r100.f555579b.removeCallbacksAndMessages(null);
                r100.f555579b.postDelayed(new f(r100), r103);
                return;
            L9:
                r100.f555584g = 0;
                r100.f555582e = r101;
                Iterator r104 = ((HashSet) r100.f555578a).iterator();
            L11:
                if (r104.hasNext() == false) goto L13;
                ((b) r104.next()).a(this.f555589b.f555587a.f555582e);
                goto L11
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC8015a(a r100, wkc.a r101) {
                this.f555589b = r100;
                this.f555588a = r101;
            }
        }

        public final void a() {
            vkc.a r100 = this.f555587a.f555581d;     // Catch: Exception -> L4
            r100.getClass();     // Catch: Exception -> L4
            wkc.a r101 = new wkc.a(new JSONObject(r100.f555560b.executeGet(vkc.a.a(r100.f555559a + "/video/live/qos/v2/ipSettings", r100.f555561c))));     // Catch: Exception -> L4
        L6:
            this.f555587a.f555579b.post(new RunnableC8015a(this, r101));
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
            r101 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(e r100) {
            this.f555587a = r100;
        }
    }

    public interface b {
        void a(wkc.a r100);
    }

    public final void a() {
        if (this.f555583f == false) goto L5;
        return;
    L5:
        this.f555583f = true;
        g r100 = this.f555580c;
        a r101 = new a(this);
        r100.f555591a.execute(r101);
    }

    public e(g r100, vkc.a r101, long r102, int r103) {
        this.f555578a = new HashSet();
        this.f555579b = new Handler(Looper.getMainLooper());
        this.f555582e = null;
        this.f555583f = false;
        this.f555584g = 0;
        this.f555585h = 10000;
        this.f555586i = 5;
        this.f555580c = r100;
        this.f555581d = r101;
        this.f555585h = r102;
        this.f555586i = r103;
    }
}
