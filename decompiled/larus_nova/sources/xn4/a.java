package xn4;

import com.bytedance.ee.bear.thread.BearExecutors;
import fo5.c;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements qnb.b.a {

    /* JADX INFO: renamed from: xn4.a$a, reason: collision with other inner class name */
    public final class C8260a implements rnb.b {
        public C8260a() {
        }

        @Override // rnb.b
        public final void d(String r100, String r101) {
            tt5.a.b(r100, r101);
        }

        @Override // rnb.b
        public final void e(String r100, Throwable r101) {
            tt5.a.f(r100, r101, true);
        }

        @Override // rnb.b
        public final void i(String r100, String r101) {
            tt5.a.h(r100, r101);
        }

        @Override // rnb.b
        public final void w(String r100, String r101) {
            tt5.a.k(r100, r101);
        }

        @Override // rnb.b
        public final void e(String r100, String r101) {
            tt5.a.d(r100, r101);
        }

        @Override // rnb.b
        public final void e(String r100, String r101, Throwable r102) {
            tt5.a.e(r100, r101, r102, false);
        }
    }

    public final class b implements snb.a {
        @Override // snb.a
        public final Executor b() {
            return new c(TimeUnit.SECONDS, new LinkedBlockingQueue(), new fo5.b("BEAR_SINGLE_RnReceiveDispatch"));
        }

        @Override // snb.a
        public final ExecutorService a() {
            return BearExecutors.a();
        }

        public b() {
        }
    }

    public a() {
    }

    @Override // qnb.b.a
    public final snb.a a() {
        return new b();
    }

    public final rnb.b b() {
        return new C8260a();
    }
}
