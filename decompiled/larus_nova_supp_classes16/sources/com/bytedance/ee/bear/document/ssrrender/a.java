package com.bytedance.ee.bear.document.ssrrender;

import android.webkit.JsPromptResult;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public b a;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ssrrender.a$a, reason: collision with other inner class name */
    public static final class C0110a {
    }

    public interface b {
        void a(c r1);
    }

    public static final class c {
        public JsPromptResult a;
        public String b;
        public final RunnableC0111a c;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ssrrender.a$c$a, reason: collision with other inner class name */
        public static final class RunnableC0111a implements Runnable {
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

            public RunnableC0111a(c r1) {
                this.a = r1;
            }
        }

        public c(JsPromptResult r3) {
            this.a = r3;
            RunnableC0111a r4 = new RunnableC0111a(this);
            this.c = r4;
            j.d(r4, DocOpenConfig.f().promt_timeout);
        }

        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "pos");
            this.b = r2;
            JsPromptResult r0 = this.a;
            if (r0 == null) goto L5;
            r0.confirm(r2);
        L5:
            this.a = null;
            j.e(this.c);
        }
    }

    static {
    }

    public a() {
    }
}
