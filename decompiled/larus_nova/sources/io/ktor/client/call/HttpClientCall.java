package io.ktor.client.call;

import com.bytedance.ai.event.MessageIndication;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import io.ktor.client.request.f;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.util.InternalAPI;
import io.ktor.utils.io.ByteReadChannel;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes41.dex */
public class HttpClientCall implements CoroutineScope {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f491620d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final io.ktor.util.a<Object> f491621e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.ktor.client.a f491622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public io.ktor.client.request.b f491623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public io.ktor.client.statement.b f491624c;
    private volatile /* synthetic */ int received;

    public static final class a {
    }

    public boolean b() {
        return false;
    }

    static {
        f491621e = new io.ktor.util.a("CustomResponse");
        f491620d = AtomicIntegerFieldUpdater.newUpdater(HttpClientCall.class, MessageIndication.STATUS_RECEIVED);
    }

    public final io.ktor.client.request.b c() {
        io.ktor.client.request.b r100 = this.f491623b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("request");
        return null;
    }

    public final io.ktor.client.statement.b d() {
        io.ktor.client.statement.b r100 = this.f491624c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    public final String toString() {
        return "HttpClientCall[" + c().getUrl() + ", " + d().d() + ']';
    }

    public Object e() {
        return d().a();
    }

    public final io.ktor.util.b getAttributes() {
        return c().getAttributes();
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return d().getCoroutineContext();
    }

    public HttpClientCall(io.ktor.client.a r100) {
        Intrinsics.checkNotNullParameter(r100, "client");
        this.f491622a = r100;
        this.received = 0;
    }

    public final Object a(isc.a r100, Continuation<Object> r110) {
        if ((r110 instanceof HttpClientCall$bodyNullable$1) == false) goto L7;
        HttpClientCall$bodyNullable$1 r101 = (HttpClientCall$bodyNullable$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        Object r105 = null;
        if (r104 == 0) goto L33;
        if (r104 == 1) goto L28;
        if (r104 != 2) goto L27;
        isc.a r106 = (isc.a) r101.L$1;
        HttpClientCall r107 = (HttpClientCall) r101.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L22
        Object r112 = ((io.ktor.client.statement.c) r111).f491796b;     // Catch: Throwable -> L22
        if ((!Intrinsics.areEqual(r112, io.ktor.http.content.b.f491838a)) == false) goto L16;
        r105 = r112;
    L16:
        if (r105 == null) goto L24;
        KClass<?> r113 = r106.getType();     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter(r105, "<this>");     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter(r113, "type");     // Catch: Throwable -> L22
        if (JvmClassMappingKt.getJavaClass(r113).isInstance(r105) == true) goto L24;
        throw new NoTransformationFoundException(r107.d(), Reflection.getOrCreateKotlinClass(r105.getClass()), r106.getType());     // Catch: Throwable -> L22
    L24:
        HttpResponseKt.b(r107.d());
        return r105;
    L22:
        th = th;
    L66:
        CoroutineScopeKt.cancel(r107.d(), "Receive failed", th);     // Catch: Throwable -> L58
        throw th;     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        HttpResponseKt.b(r107.d());
        throw th;
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L28:
        r100 = (isc.a) r101.L$1;
        HttpClientCall r108 = (HttpClientCall) r101.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L31
    L52:
        Intrinsics.checkNotNullParameter(r100, "expectedType");     // Catch: Throwable -> L31
        Intrinsics.checkNotNullParameter(r111, "response");     // Catch: Throwable -> L31
        r108.f491622a.getClass();     // Catch: Throwable -> L31
        r101.L$0 = r108;     // Catch: Throwable -> L31
        r101.L$1 = r100;     // Catch: Throwable -> L31
        r101.label = 2;     // Catch: Throwable -> L31
        throw null;     // Catch: Throwable -> L31
    L31:
        th = th;
        r107 = r108;
        goto L66
    L33:
        ResultKt.throwOnFailure(r111);
        io.ktor.client.statement.b r114 = d();     // Catch: Throwable -> L54
        KClass<?> r109 = r100.getType();     // Catch: Throwable -> L54
        Intrinsics.checkNotNullParameter(r114, "<this>");     // Catch: Throwable -> L54
        Intrinsics.checkNotNullParameter(r109, "type");     // Catch: Throwable -> L54
        if (JvmClassMappingKt.getJavaClass(r109).isInstance(r114) == false) goto L40;
        io.ktor.client.statement.b r115 = d();     // Catch: Throwable -> L54
        HttpResponseKt.b(d());
        return r115;
    L40:
        if (b() == false) goto L42;
    L46:
        r111 = getAttributes().b(f491621e);     // Catch: Throwable -> L54
        if (r111 != null) goto L51;
        r101.L$0 = this;     // Catch: Throwable -> L54
        r101.L$1 = r100;     // Catch: Throwable -> L54
        r101.label = 1;     // Catch: Throwable -> L54
        r111 = e();     // Catch: Throwable -> L54
        if (r111 != r103) goto L51;
        return r103;
    L51:
        r108 = this;
        goto L52
    L42:
        if (f491620d.compareAndSet(this, 0, 1) == true) goto L46;
        throw new DoubleReceiveException(this);     // Catch: Throwable -> L54
    L54:
        th = th;
        r107 = this;
    L7:
        r101 = new HttpClientCall$bodyNullable$1(this, r110);
        goto L8
    }

    @InternalAPI
    public HttpClientCall(io.ktor.client.a r100, io.ktor.client.request.c r101, f r102) {
        Intrinsics.checkNotNullParameter(r100, "client");
        Intrinsics.checkNotNullParameter(r101, "requestData");
        Intrinsics.checkNotNullParameter(r102, OnekeyLoginConstants.CT_KEY_RSP_DATA);
        this(r100);
        io.ktor.client.request.a r103 = new io.ktor.client.request.a(this, r101);
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        this.f491623b = r103;
        io.ktor.client.statement.a r104 = new io.ktor.client.statement.a(this, r102);
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        this.f491624c = r104;
        if ((r102.f491782e instanceof ByteReadChannel) == true) goto L6;
        getAttributes().a(f491621e, r102.f491782e);
        return;
    }
}
