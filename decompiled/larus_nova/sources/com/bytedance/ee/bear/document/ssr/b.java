package com.bytedance.ee.bear.document.ssr;

import android.webkit.JsPromptResult;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterfaceC3163b f221861a;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ssr.b$b, reason: collision with other inner class name */
    public interface InterfaceC3163b {
        void a(c r100);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public JsPromptResult f221862a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f221863b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f221864c;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f221865a;

            @Override // java.lang.Runnable
            public final void run() {
                c r100 = this.f221865a;     // Catch: Throwable -> L9
                if (r100.f221863b != null) goto L12;
                JsPromptResult r101 = r100.f221862a;     // Catch: Throwable -> L9
                if (r101 == null) goto L7;
                r101.confirm(SliceInitService.DEFAULT_SWITCH);     // Catch: Throwable -> L9
            L7:
                this.f221865a.f221862a = null;     // Catch: Throwable -> L9
                return;
            L12:
                return;
            L9:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L16;
                throw th;
            }

            public a(c r100) {
                this.f221865a = r100;
            }
        }

        public c(JsPromptResult r100) {
            this.f221862a = r100;
            a r101 = new a(this);
            this.f221864c = r101;
            com.bytedance.ee.util.ui.j.d(r101, DocOpenConfig.f().promt_timeout);
        }

        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION);
            this.f221863b = r100;
            JsPromptResult r101 = this.f221862a;
            if (r101 == null) goto L5;
            r101.confirm(r100);
        L5:
            this.f221862a = null;
            com.bytedance.ee.util.ui.j.e(this.f221864c);
        }
    }

    static {
    }

    public b() {
    }
}
