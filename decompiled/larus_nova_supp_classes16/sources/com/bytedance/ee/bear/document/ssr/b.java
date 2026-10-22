package com.bytedance.ee.bear.document.ssr;

import android.webkit.JsPromptResult;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public InterfaceC0107b a;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ssr.b$b, reason: collision with other inner class name */
    public interface InterfaceC0107b {
        void a(c r1);
    }

    public static final class c {
        public JsPromptResult a;
        public String b;
        public final a c;

        public static final class a implements Runnable {
            public final /* synthetic */ c a;

            @Override // java.lang.Runnable
            public final void run() {
                c r0 = this.a;     // Catch: Throwable -> L9
                if (r0.b != null) goto L12;
                JsPromptResult r1 = r0.a;     // Catch: Throwable -> L9
                if (r1 == null) goto L7;
                r1.confirm("{}");     // Catch: Throwable -> L9
            L7:
                this.a.a = null;     // Catch: Throwable -> L9
                return;
            L12:
                return;
            L9:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L16;
                throw th;
            }

            public a(c r1) {
                this.a = r1;
            }
        }

        public c(JsPromptResult r3) {
            this.a = r3;
            a r4 = new a(this);
            this.c = r4;
            com.bytedance.ee.util.ui.j.d(r4, DocOpenConfig.f().promt_timeout);
        }

        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "pos");
            this.b = r2;
            JsPromptResult r0 = this.a;
            if (r0 == null) goto L5;
            r0.confirm(r2);
        L5:
            this.a = null;
            com.bytedance.ee.util.ui.j.e(this.c);
        }
    }

    static {
    }

    public b() {
    }
}
