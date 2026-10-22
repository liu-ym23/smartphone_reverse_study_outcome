package r55;

import android.app.Application;
import android.content.Context;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.util.ui.m;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.compose.foundation.toast.b;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: r55.a$a, reason: collision with other inner class name */
    public static final class C0282a {

        /* JADX INFO: renamed from: r55.a$a$a, reason: collision with other inner class name */
        public static final class RunnableC0283a implements Runnable {
            public final /* synthetic */ int a;
            public final /* synthetic */ Long b;
            public final /* synthetic */ Context c;

            /* JADX INFO: renamed from: r55.a$a$a$a, reason: collision with other inner class name */
            public static final class C0284a implements UDToast.b {
                public C0284a() {
                }

                public final void a(b r3) {
                    Intrinsics.checkNotNullParameter(r3, "toast");
                    tt5.a.h("MobileNetworkToast", "click close ");
                    r3.cancel();
                    t.c = true;
                }
            }

            public RunnableC0283a(int r1, Long r2, Context r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            public final void a() {
                Application r0 = eu5.b.a;
                int r1 = this.a;
                Long r2 = this.b;
                if (r2 == null) goto L5;
                long r3 = r2.longValue();
            L6:
                String r4 = xo5.a.c(r0, r1, "size", com.bytedance.ee.util.io.a.a(r3));
                Context r5 = this.c;
                Intrinsics.checkNotNull(r5);
                UDToast.a r6 = UDToast.build(r5);
                Intrinsics.checkNotNull(r4);
                r6.g(r4);
                r6.b.d = 2000;
                r6.c(this.c.getResources().getString(2131887457), new C0284a());
                r6.h();
                return;
            L5:
                r3 = 0;
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
        }

        @JvmStatic
        public static void a(Long r2, Context r3, int r4) {
            tt5.a.h("MobileNetworkToast", "show, size=" + r2 + ", context=" + r3 + ", active=" + com.bytedance.ee.util.ui.b.b(r3));
            if (com.bytedance.ee.util.ui.b.b(r3) == true) goto L5;
            return;
        L5:
            m.a(new RunnableC0283a(r4, r2, r3));
        }
    }

    static {
    }
}
