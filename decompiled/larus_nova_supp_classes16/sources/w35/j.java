package w35;

import android.webkit.ValueCallback;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j {
    public final w35.a a;
    public String b;
    public int c;
    public final b d;
    public final c e;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ j a;

        public static final class a<T> implements ValueCallback {
            public final /* synthetic */ j a;

            public a(j r1) {
                this.a = r1;
            }

            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object r3) {
                String r4 = (String) r3;
                j r0 = this.a;
                Intrinsics.checkNotNull(r4);
                r0.getClass();
                Intrinsics.checkNotNullParameter(r4, "<set-?>");
                r0.b = r4;
            }
        }

        public b(j r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j r0 = this.a;     // Catch: Throwable -> L4
            r0.c++;     // Catch: Throwable -> L4
            ap5.a.a(r0.a, "javascript:getSSRScrollPos", new JSONObject(), new a(this.a));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements w35.a.d {
        public final /* synthetic */ j a;

        @Override // w35.a.d
        public final void a() {
            com.bytedance.ee.util.ui.j.e(this.a.d);
            com.bytedance.ee.util.ui.j.d(this.a.d, DocOpenConfig.f().ssr_webview_get_pos_gap_time);
        }

        public c(j r1) {
            this.a = r1;
        }
    }

    static {
    }

    public j(w35.a r2) {
        Intrinsics.checkNotNullParameter(r2, "webView");
        this.a = r2;
        this.b = "{}";
        this.d = new b(this);
        this.e = new c(this);
    }
}
