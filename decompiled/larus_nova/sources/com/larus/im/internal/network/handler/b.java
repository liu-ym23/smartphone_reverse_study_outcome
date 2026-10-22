package com.larus.im.internal.network.handler;

import com.larus.im.internal.delegate.c;
import com.larus.im.internal.network.stragery.uplink.BaseUplinkStrategy;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b implements BaseUplinkStrategy.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f349195b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f349196a;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.im.internal.network.handler.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes30.dex */
    public static final class C4367b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f349197a;

        public C4367b(CoroutineExceptionHandler.Key r100, b r101) {
            this.f349197a = r101;
            super(r100);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r101) {
            if (c.f348197a.isDebug() == true) goto L6;
            this.f349197a.c("processor invoke error , " + r101.getMessage(), r101);
            return;
        L6:
            throw r101;
        }
    }

    static {
    }

    public abstract String b();

    public b() {
        this.f349196a = LazyKt.lazy(new com.larus.im.internal.network.handler.a(this));
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        com.larus.im.internal.delegate.a.f348188b.i("AbsHttpRequestHandler", "[" + b() + "] " + r100);
    }

    public final void c(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        com.larus.im.internal.delegate.a r102 = com.larus.im.internal.delegate.a.f348188b;
        r102.e("AbsHttpRequestHandler", "[" + b() + "] " + r100);
        if (r101 == null) goto L6;
        r102.e("AbsHttpRequestHandler", "[" + b() + "] " + r101.getMessage());
        StringBuilder r103 = new StringBuilder("[");
        r103.append(b());
        r103.append("] ");
        Intrinsics.checkNotNullParameter(r101, "<this>");
        r103.append(ExceptionsKt.stackTraceToString(r101));
        r102.e("AbsHttpRequestHandler", r103.toString());
        return;
    }
}
