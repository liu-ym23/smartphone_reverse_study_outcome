package np0;

import com.bytedance.android.live.core.utils.z0;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f519996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PublishSubject f519997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Observable<T> f519998c;

    public static final class a<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f519999a = null;

        static {
            f519999a = new a();
        }

        public a() {
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            h80.c r101 = (h80.c) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return r101.b();
        }
    }

    /* JADX INFO: renamed from: np0.b$b, reason: collision with other inner class name */
    public static final class C6955b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C6955b f520000a = null;

        static {
            f520000a = new C6955b();
        }

        public C6955b() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            h80.c r101 = (h80.c) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return z0.b(r101);
        }
    }

    public b() {
        PublishSubject r100 = PublishSubject.create();
        this.f519997b = r100;
        this.f519998c = (Observable<T>) r100.filter(a.f519999a).map(C6955b.f520000a);
    }

    public final void a(T r100) {
        this.f519996a = r100;
        this.f519997b.onNext(h80.c.c(r100));
    }
}
