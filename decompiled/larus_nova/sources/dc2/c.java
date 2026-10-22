package dc2;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes9.dex */
public final class c<T> implements ylc.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PropertyOwner<a<T>> f467849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f467850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ylc.c f467851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Observable<T> f467852d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Observable<b<T>> f467853e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f467854f;

    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f467855a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f467856b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final T f467857c;

        /* JADX INFO: renamed from: dc2.c$a$a, reason: collision with other inner class name */
        public static final class C5653a {
        }

        static {
        }

        public a(long r100, String r101, T r102) {
            Intrinsics.checkNotNullParameter(r101, "bizLogId");
            this.f467855a = r100;
            this.f467856b = r101;
            this.f467857c = r102;
        }
    }

    public static final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f467858a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f467859b;

        public b(long r100, T r101) {
            Intrinsics.checkNotNullParameter(r101, "value");
            this.f467858a = r100;
            this.f467859b = r101;
        }
    }

    /* JADX INFO: renamed from: dc2.c$c, reason: collision with other inner class name */
    public static final class C5654c<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C5654c f467860a = null;

        static {
            f467860a = new C5654c();
        }

        public C5654c() {
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            a r101 = (a) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            if (r101.f467857c == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class d<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f467861a = null;

        static {
            f467861a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            a r101 = (a) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return r101.f467857c;
        }
    }

    public static final class e<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f467862a = null;

        static {
            f467862a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            a r101 = (a) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            if (r101.f467857c == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class f<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f467863a = null;

        static {
            f467863a = new f();
        }

        public f() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            a r101 = (a) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            long r102 = r101.f467855a;
            T r103 = r101.f467857c;
            Intrinsics.checkNotNull(r103);
            return new b(r102, r103);
        }
    }

    public static final class g<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f467864a = null;

        static {
            f467864a = new g();
        }

        public g() {
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            a r101 = (a) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            if (r101.f467857c == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class h<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f467865a = null;

        static {
            f467865a = new h();
        }

        public h() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            a r101 = (a) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            long r102 = r101.f467855a;
            T r103 = r101.f467857c;
            Intrinsics.checkNotNull(r103);
            return new b(r102, r103);
        }
    }

    public static final class i<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ dc2.f f467866a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f467867b;

        public i(dc2.f r100, long r101) {
            this.f467866a = r100;
            this.f467867b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Disposable r101 = (Disposable) r100;
            dc2.f r102 = this.f467866a;
            long r103 = this.f467867b;
            r102.f467878c = false;
            r102.f467876a = System.currentTimeMillis();
            r102.f467877b = r103;
        }
    }

    public static final class j<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ dc2.f f467868a;

        public j(dc2.f r100) {
            this.f467868a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            a r101 = (a) r100;
            dc2.f r102 = this.f467868a;
            long r103 = r101.f467855a;
            String r104 = r101.f467856b;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r104, "bizLogId");
            if (r102.f467878c == true) goto L7;
            r102.a(true, false, Long.valueOf(r103), r104, null);
            return;
        }
    }

    public static final class k<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ dc2.f f467869a;

        public k(dc2.f r100) {
            this.f467869a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Throwable r100 = (Throwable) r110;
            if ((r100 instanceof TimeoutException) == false) goto L8;
            dc2.f r101 = this.f467869a;
            if (r101.f467878c == true) goto L18;
            r101.a(false, true, null, null, null);
            return;
        L18:
            return;
        L8:
            dc2.f r102 = this.f467869a;
            if (r100 != null) goto L12;
            r102.getClass();
            return;
        L12:
            if (r102.f467878c == true) goto L19;
            r102.a(false, false, null, null, r100);
            return;
        }
    }

    public static final class l<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f467870a = null;

        static {
            f467870a = new l();
        }

        public l() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            a r101 = (a) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            T r102 = r101.f467857c;
            Intrinsics.checkNotNull(r102);
            return r102;
        }
    }

    public static final class m<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f467871a;

        public m(long r100) {
            this.f467871a = r100;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            a r101 = (a) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            if (r101.f467857c != null) goto L5;
        L7:
            return false;
        L5:
            if (r101.f467855a < this.f467871a) goto L7;
            return true;
        }
    }

    public static final class n<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n f467872a = null;

        static {
            f467872a = new n();
        }

        public n() {
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            a r101 = (a) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            if (r101.f467857c == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class o<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f467873a;

        public o(long r100) {
            this.f467873a = r100;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            a r101 = (a) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            if (r101.f467857c != null) goto L5;
        L7:
            return false;
        L5:
            if (r101.f467855a < this.f467873a) goto L7;
            return true;
        }
    }

    public final Observable<b<T>> b() {
        return (Observable<b<T>>) this.f467849a.filter(e.f467862a).observeOn(AndroidSchedulers.mainThread()).map(f.f467863a);
    }

    public final T c() {
        PropertyOwner<a<T>> r100 = this.f467849a;
        r100.getClass();
        return r100.f64752a.f467857c;
    }

    @Override // ylc.c
    public final void onClear() {
        this.f467849a.onComplete();
    }

    public c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f467854f = r100;
        PropertyOwner<a<T>> r101 = new PropertyOwner(new a(0, "", null));
        this.f467849a = r101;
        this.f467852d = (Observable<T>) com.bytedance.android.live.core.arch.mvvm.f.b(r101).filter(C5654c.f467860a).observeOn(AndroidSchedulers.mainThread()).map(d.f467861a);
        this.f467853e = (Observable<b<T>>) com.bytedance.android.live.core.arch.mvvm.f.b(r101).filter(g.f467864a).observeOn(AndroidSchedulers.mainThread()).map(h.f467865a);
    }

    @Override // ylc.c
    public final void a(com.ss.ugc.live.sdk.message.wrsc.data.a r100) {
        Intrinsics.checkNotNullParameter(r100, "roomDataSync");
        Object r101 = r100.f458184e;
        if (r101 != null) goto L18;
        String r102 = r100.f458186g;
        Map<String, Class<?>> r103 = dc2.a.f467848a;
        Intrinsics.checkNotNullParameter(r102, "key");
        Class<T> r104 = (Class) ((HashMap) dc2.a.f467848a).get(r102);
        if (r104 == null) goto L18;
        am3.c<T> r105 = ((IMiddlewareNetworkService) jc1.k.n(IMiddlewareNetworkService.class)).getProtoDecoder(r104);     // Catch: Throwable -> L20
        if (r105 == null) goto L18;
        am3.g r106 = new am3.g();     // Catch: Throwable -> L20
        ByteString r107 = r100.f458183d;     // Catch: Throwable -> L20
        if (r107 == null) goto L13;
        byte[] r108 = r107.toByteArray();     // Catch: Throwable -> L20
        if (r108 == null) goto L13;
    L14:
        r106.k(new am3.b(r108));     // Catch: Throwable -> L20
        T r109 = r105.decode(r106);     // Catch: Throwable -> L20
        if ((r109 instanceof Object) == true) goto L17;
        r101 = null;
        goto L18
    L17:
        r101 = r109;
    L13:
        r108 = new byte[0];     // Catch: Throwable -> L20
    L18:
        this.f467849a.a(new a(r100.f458180a, r100.f458182c, r101));
    }

    public final Observable<T> d(long r100, long r101) {
        if (r101 > 0) goto L5;
        Observable<a<T>> r102 = this.f467849a.filter(new m(r100));
    L10:
        dc2.f r103 = new dc2.f(this.f467854f, this.f467850b);
        return r102.doOnSubscribe(new i(r103, r100)).doOnNext(new j(r103)).doOnError(new k(r103)).map(l.f467870a).observeOn(AndroidSchedulers.mainThread());
    L5:
        T r104 = c();
        PropertyOwner<a<T>> r105 = this.f467849a;
        r105.getClass();
        if (r105.f64752a.f467855a < r100) goto L9;
        if (r104 == null) goto L9;
        r102 = com.bytedance.android.live.core.arch.mvvm.f.b(this.f467849a).filter(n.f467872a);
    L9:
        r102 = this.f467849a.filter(new o(r100)).timeout(r101, TimeUnit.MILLISECONDS);
        goto L10
    }
}
