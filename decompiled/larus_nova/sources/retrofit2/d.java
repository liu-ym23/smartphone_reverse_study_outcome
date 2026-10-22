package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes41.dex */
public final class d extends CallAdapter.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f537481a = null;

    public static final class a<R> implements CallAdapter<R, CompletableFuture<R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f537482a;

        @Override // retrofit2.CallAdapter
        public final Type responseType() {
            return this.f537482a;
        }

        public a(Type r100) {
            this.f537482a = r100;
        }

        @Override // retrofit2.CallAdapter
        public final Object adapt(Call r100) {
            retrofit2.b r101 = new retrofit2.b(r100);
            r100.enqueue(new c(r101));
            return r101;
        }
    }

    public static final class b<R> implements CallAdapter<R, CompletableFuture<Response<R>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f537483a;

        @Override // retrofit2.CallAdapter
        public final Type responseType() {
            return this.f537483a;
        }

        public b(Type r100) {
            this.f537483a = r100;
        }

        @Override // retrofit2.CallAdapter
        public final Object adapt(Call r100) {
            e r101 = new e(r100);
            r100.enqueue(new f(r101));
            return r101;
        }
    }

    static {
        f537481a = new d();
    }

    public d() {
    }

    @Override // retrofit2.CallAdapter.Factory
    @Nullable
    public final CallAdapter<?, ?> get(Type r100, Annotation[] r101, Retrofit r102) {
        if (CallAdapter.Factory.getRawType(r100) == CompletableFuture.class) goto L7;
        return null;
    L7:
        if ((r100 instanceof ParameterizedType) == false) goto L19;
        Type r103 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) r100);
        if (CallAdapter.Factory.getRawType(r103) == Response.class) goto L13;
        return new a(r103);
    L13:
        if ((r103 instanceof ParameterizedType) == false) goto L17;
        return new b(CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) r103));
    L17:
        throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
    L19:
        throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
    }
}
