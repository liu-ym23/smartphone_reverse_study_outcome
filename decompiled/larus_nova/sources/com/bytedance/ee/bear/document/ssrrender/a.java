package com.bytedance.ee.bear.document.ssrrender;

import android.webkit.JsPromptResult;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f221906a;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ssrrender.a$a, reason: collision with other inner class name */
    public static final class C3166a {
    }

    public interface b {
        void a(c r100);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public JsPromptResult f221907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f221908b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final RunnableC3167a f221909c;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ssrrender.a$c$a, reason: collision with other inner class name */
        public static final class RunnableC3167a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f221910a;

            @Override // java.lang.Runnable
            public final void run() {
                c r100 = this.f221910a;     // Catch: Throwable -> L9
                if (r100.f221908b != null) goto L12;
                JsPromptResult r101 = r100.f221907a;     // Catch: Throwable -> L9
                if (r101 == null) goto L7;
                r101.confirm(SliceInitService.DEFAULT_SWITCH);     // Catch: Throwable -> L9
            L7:
                this.f221910a.f221907a = null;     // Catch: Throwable -> L9
                return;
            L12:
                return;
            L9:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L16;
                throw th;
            }

            public RunnableC3167a(c r100) {
                this.f221910a = r100;
            }
        }

        public c(JsPromptResult r100) {
            this.f221907a = r100;
            RunnableC3167a r101 = new RunnableC3167a(this);
            this.f221909c = r101;
            j.d(r101, DocOpenConfig.f().promt_timeout);
        }

        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION);
            this.f221908b = r100;
            JsPromptResult r101 = this.f221907a;
            if (r101 == null) goto L5;
            r101.confirm(r100);
        L5:
            this.f221907a = null;
            j.e(this.f221909c);
        }
    }

    static {
    }

    public a() {
    }
}
