package ihc;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public abstract class j {

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f489943a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ControlRule f489944b;

        public a(Context r100, ControlRule r101) {
            this.f489943a = r100;
            this.f489944b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Toast.makeText(this.f489943a, "流量海关：跳出行为被拦截，鉴权 id = " + this.f489944b.getCertId(), 0).show();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public j() {
    }

    public static void a(Context r100, ControlRule r101) {
        com.ss.android.ugc.route_monitor.c.a().g();
        Handler r102 = com.ss.android.ugc.route_monitor.utils.r.f454781a;
        a r103 = new a(r100, r101);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r103.run();
        return;
    L5:
        com.ss.android.ugc.route_monitor.utils.r.f454781a.post(r103);
    }
}
