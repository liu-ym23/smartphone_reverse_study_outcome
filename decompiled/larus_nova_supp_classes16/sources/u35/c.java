package u35;

import android.view.View;
import android.webkit.ValueCallback;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import kotlin.jvm.internal.Intrinsics;
import zv4.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public final ChameleonWebView a;
    public String b;
    public final b c;
    public final C0305c d;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ c a;

        public static final class a<T> implements ValueCallback {
            public final /* synthetic */ c a;

            public a(c r1) {
                this.a = r1;
            }

            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object r2) {
                String r3 = (String) r2;
                c r0 = this.a;
                Intrinsics.checkNotNull(r3);
                r0.b = r3;
            }
        }

        public b(c r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ap5.a.a(this.a.a, "javascript:getSSRScrollPos", new JSONObject(), new a(this.a));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: renamed from: u35.c$c, reason: collision with other inner class name */
    public static final class C0305c implements f {
        public final /* synthetic */ c a;

        public C0305c(c r1) {
            this.a = r1;
        }

        @Override // zv4.f
        public final void onScrollChange(View r1, int r2, int r3, int r4, int r5) {
            j.e(this.a.c);
            j.d(this.a.c, DocOpenConfig.f().ssr_webview_get_pos_gap_time);
        }
    }

    static {
    }

    public c(ChameleonWebView r2) {
        Intrinsics.checkNotNullParameter(r2, "webView");
        this.a = r2;
        this.b = "{}";
        this.c = new b(this);
        this.d = new C0305c(this);
    }
}
