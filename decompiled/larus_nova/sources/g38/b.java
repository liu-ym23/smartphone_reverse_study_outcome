package g38;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b extends AbstractCoroutineContextElement implements ContinuationInterceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f479865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ContinuationInterceptor f479866b;

    public final class a<T> implements Continuation<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Continuation<T> f479867a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CoroutineContext f479868b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f479869c;

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.f479868b;
        }

        @Override // kotlin.coroutines.Continuation
        public final void resumeWith(Object r100) {
            String r101 = this.f479869c.f479865a;
            String r102 = qqb.a.d();     // Catch: Throwable -> L9
            qqb.a.f(r101);     // Catch: Throwable -> L7
            this.f479867a.resumeWith(r100);     // Catch: Throwable -> L7
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r102, "traceId");
            qqb.a.g(r102);
            return;
        L7:
            th = th;
        L11:
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r102, "traceId");
            qqb.a.g(r102);
            throw th;
        L9:
            th = th;
            r102 = "";
            goto L11
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(b r100, Continuation<? super T> r101) {
            Intrinsics.checkNotNullParameter(r101, "continuation");
            this.f479869c = r100;
            this.f479867a = r101;
            this.f479868b = r101.getContext();
        }
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> r100) {
        return (E) ContinuationInterceptor.DefaultImpls.get(this, r100);
    }

    @Override // kotlin.coroutines.ContinuationInterceptor
    public final <T> Continuation<T> interceptContinuation(Continuation<? super T> r100) {
        Intrinsics.checkNotNullParameter(r100, "continuation");
        ContinuationInterceptor r101 = this.f479866b;
        if (r101 == null) goto L7;
        Continuation<T> r102 = r101.interceptContinuation(new a(this, r100));
        if (r102 == null) goto L7;
        return r102;
    L7:
        return new a(this, r100);
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key<?> r100) {
        return ContinuationInterceptor.DefaultImpls.minusKey(this, r100);
    }

    @Override // kotlin.coroutines.ContinuationInterceptor
    public final void releaseInterceptedContinuation(Continuation<?> r100) {
        ContinuationInterceptor.DefaultImpls.releaseInterceptedContinuation(this, r100);
    }

    public b(String r100, ContinuationInterceptor r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        super(ContinuationInterceptor.Key);
        this.f479865a = r100;
        this.f479866b = r101;
    }
}
