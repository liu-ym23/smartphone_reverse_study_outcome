package lx4;

import android.app.Activity;
import com.bytedance.ee.bear.contract.l;
import com.bytedance.ee.bear.document.DocBridgeWebViewV2;
import com.bytedance.ee.bear.document.l7;
import com.bytedance.ee.bear.document.y7;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class a implements g {
    public final com.bytedance.ee.bear.route.h a;

    /* JADX INFO: renamed from: lx4.a$a, reason: collision with other inner class name */
    public static final class C0251a {
    }

    public static final class b extends WeakReference<a> {
        public b(a r1) {
            super(r1);
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ a a;
        public final /* synthetic */ boolean b;

        public c(a r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r4) {
            b r5 = (b) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            tt5.a.h("WikiAutoTestImpl", "onBackPressed");
            Activity r0 = this.a.a.getCurrentActivity();
            if (r0 == null) goto L6;
            r0.onBackPressed();
        L6:
            if (this.b == false) goto L13;
            l7 r1 = y7.j;
            DocBridgeWebViewV2 r2 = y7.a.a.k();
            if (r2 == null) goto L13;
            if (r2.u3 == null) goto L13;
            tt5.a.h(r2.g1, "notifyV8ToGC ====");
            r2.u3.notifyV8ToGC();
        L13:
            return r5;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d<T> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r3) {
            b r4 = (b) r3;
            tt5.a.h("WikiAutoTestImpl", "after 2 seconds openNext");
            if (r4 == null) goto L8;
            a r5 = r4.get();
            if (r5 == null) goto L9;
            r5.l();
            return;
        L9:
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public static final e<T> a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r4) {
            tt5.a.e("WikiAutoTestImpl", "error throwable ", (Throwable) r4, false);
        }
    }

    static {
    }

    public boolean n() {
        return false;
    }

    public a(com.bytedance.ee.bear.route.h r2) {
        Intrinsics.checkNotNullParameter(r2, "mRouterService");
        this.a = r2;
    }

    public final Disposable o(boolean r3, long r4, long r6) {
        if (l.a.booleanValue() == true) goto L6;
        return null;
    L6:
        if (n() == true) goto L9;
        Flowable r0 = Flowable.just(new b(this));
        TimeUnit r1 = TimeUnit.SECONDS;
        return r0.delay(r4, r1).observeOn(fo5.d.d()).map(new c(this, r3)).delay(r6, r1).observeOn(fo5.d.d()).subscribe(d.a, e.a);
    L9:
        return null;
    }
}
