package retrofit2;

import com.larus.apm.impl.protector.RunnableProtector;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.Request;

/* JADX INFO: loaded from: classes41.dex */
public final class i extends CallAdapter.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f537488a;

    public class a implements CallAdapter<Object, Call<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Type f537489a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f537490b;

        @Override // retrofit2.CallAdapter
        public final Type responseType() {
            return this.f537489a;
        }

        @Override // retrofit2.CallAdapter
        public final Call<?> adapt(Call<Object> r100) {
            return new b(this.f537490b.f537488a, r100);
        }

        public a(i r100, Type r101) {
            this.f537490b = r100;
            this.f537489a = r101;
        }
    }

    public static final class b<T> implements Call<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Executor f537491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Call<T> f537492b;

        public class a implements Callback<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Callback f537493a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f537494b;

            /* JADX INFO: renamed from: retrofit2.i$b$a$a, reason: collision with other inner class name */
            public class RunnableC7473a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Response f537495a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ a f537496b;

                public final void a() {
                    if (this.f537496b.f537494b.f537492b.isCanceled() == false) goto L5;
                    a r100 = this.f537496b;
                    r100.f537493a.onFailure(r100.f537494b, new IOException("Canceled"));
                    return;
                L5:
                    a r101 = this.f537496b;
                    r101.f537493a.onResponse(r101.f537494b, this.f537495a);
                }

                @Override // java.lang.Runnable
                public final void run() {
                    a();     // Catch: Throwable -> L4
                    return;
                L4:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == false) goto L8;
                    return;
                L8:
                    throw th;
                }

                public RunnableC7473a(a r100, Response r101) {
                    this.f537496b = r100;
                    this.f537495a = r101;
                }
            }

            /* JADX INFO: renamed from: retrofit2.i$b$a$b, reason: collision with other inner class name */
            public class RunnableC7474b implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Throwable f537497a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ a f537498b;

                @Override // java.lang.Runnable
                public final void run() {
                    a r100 = this.f537498b;     // Catch: Throwable -> L4
                    r100.f537493a.onFailure(r100.f537494b, this.f537497a);     // Catch: Throwable -> L4
                    return;
                L4:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == false) goto L8;
                    return;
                L8:
                    throw th;
                }

                public RunnableC7474b(a r100, Throwable r101) {
                    this.f537498b = r100;
                    this.f537497a = r101;
                }
            }

            public a(b r100, Callback r101) {
                this.f537494b = r100;
                this.f537493a = r101;
            }

            @Override // retrofit2.Callback
            public final void onFailure(Call<T> r100, Throwable r101) {
                this.f537494b.f537491a.execute(new RunnableC7474b(this, r101));
            }

            @Override // retrofit2.Callback
            public final void onResponse(Call<T> r100, Response<T> r101) {
                this.f537494b.f537491a.execute(new RunnableC7473a(this, r101));
            }
        }

        @Override // retrofit2.Call
        public final void cancel() {
            this.f537492b.cancel();
        }

        @Override // retrofit2.Call
        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public final Call<T> mo11002clone() {
            return new b(this.f537491a, this.f537492b.mo11002clone());
        }

        @Override // retrofit2.Call
        public final Response<T> execute() throws IOException {
            return this.f537492b.execute();
        }

        @Override // retrofit2.Call
        public final boolean isCanceled() {
            return this.f537492b.isCanceled();
        }

        @Override // retrofit2.Call
        public final boolean isExecuted() {
            return this.f537492b.isExecuted();
        }

        @Override // retrofit2.Call
        public final Request request() {
            return this.f537492b.request();
        }

        public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
            return mo11002clone();
        }

        @Override // retrofit2.Call
        public final void enqueue(Callback<T> r100) {
            u.a(r100, "callback == null");
            this.f537492b.enqueue(new a(this, r100));
        }

        public b(Executor r100, Call<T> r101) {
            this.f537491a = r100;
            this.f537492b = r101;
        }
    }

    public i(Executor r100) {
        this.f537488a = r100;
    }

    @Override // retrofit2.CallAdapter.Factory
    @Nullable
    public final CallAdapter<?, ?> get(Type r100, Annotation[] r101, Retrofit r102) {
        if (CallAdapter.Factory.getRawType(r100) == Call.class) goto L7;
        return null;
    L7:
        if ((r100 instanceof ParameterizedType) == false) goto L11;
        return new a(this, u.e(0, (ParameterizedType) r100));
    L11:
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
