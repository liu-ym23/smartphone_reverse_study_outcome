package f36;

import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.sdk.xbridge.cn.runtime.thread.ThreadUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f475393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final et3.c f475394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f475395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f475396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f475397e;

    public static final class a {
    }

    /* JADX INFO: renamed from: f36.b$b, reason: collision with other inner class name */
    public static final class RunnableC5855b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f475398a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f475399b;

        public RunnableC5855b(b r100, JSONObject r101) {
            this.f475398a = r100;
            this.f475399b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f475398a.c(this.f475399b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public b() {
        this.f475393a = new e();
        et3.c r100 = new et3.c("bullet_fluency_tracer");
        this.f475394b = r100;
        r100.c(new c(this));
        r100.b(new d(this));
    }

    public final void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "extraCategory");
        if (this.f475395c == false) goto L5;
        return;
    L5:
        e r101 = this.f475393a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "extraCategory");
        r101.f475408g = r100;
        this.f475396d = SystemClock.uptimeMillis();
        this.f475394b.d();
        this.f475395c = true;
    }

    public final void b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "extraCategory");
        if (this.f475395c == true) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L9;
        ThreadUtils.a().post(new RunnableC5855b(this, r100));
        return;
    L9:
        c(r100);
    }

    public final void c(JSONObject r100) {
        e r101 = this.f475393a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "extraCategory");
        r101.f475409h = r100;
        this.f475393a.f475402a = SystemClock.uptimeMillis() - this.f475396d;
        this.f475394b.f();
        this.f475395c = false;
        this.f475396d = 0;
    }
}
