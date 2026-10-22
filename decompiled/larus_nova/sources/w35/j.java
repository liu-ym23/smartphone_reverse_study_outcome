package w35;

import android.webkit.ValueCallback;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w35.a f558171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f558172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f558173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f558174d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f558175e;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f558176a;

        public static final class a<T> implements ValueCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ j f558177a;

            public a(j r100) {
                this.f558177a = r100;
            }

            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object r100) {
                String r101 = (String) r100;
                j r102 = this.f558177a;
                Intrinsics.checkNotNull(r101);
                r102.getClass();
                Intrinsics.checkNotNullParameter(r101, "<set-?>");
                r102.f558172b = r101;
            }
        }

        public b(j r100) {
            this.f558176a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j r100 = this.f558176a;     // Catch: Throwable -> L4
            r100.f558173c++;     // Catch: Throwable -> L4
            ap5.a.a(r100.f558171a, "javascript:getSSRScrollPos", new JSONObject(), new a(this.f558176a));     // Catch: Throwable -> L4
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f558178a;

        @Override // w35.a.d
        public final void a() {
            com.bytedance.ee.util.ui.j.e(this.f558178a.f558174d);
            com.bytedance.ee.util.ui.j.d(this.f558178a.f558174d, DocOpenConfig.f().ssr_webview_get_pos_gap_time);
        }

        public c(j r100) {
            this.f558178a = r100;
        }
    }

    static {
    }

    public j(w35.a r100) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        this.f558171a = r100;
        this.f558172b = SliceInitService.DEFAULT_SWITCH;
        this.f558174d = new b(this);
        this.f558175e = new c(this);
    }
}
