package io.ktor.client.request;

import io.ktor.http.Url;
import io.ktor.http.g0;
import io.ktor.http.l0;
import io.ktor.http.o;
import io.ktor.http.p;
import io.ktor.http.t;
import io.ktor.http.v;
import io.ktor.util.InternalAPI;
import io.ktor.util.s;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes41.dex */
public final class HttpRequestBuilder implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g0 f491758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v f491759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f491760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f491761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Job f491762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final io.ktor.util.c f491763f;

    public static final class a {
    }

    static {
    }

    public final c a() {
        Url r100 = this.f491758a.b();
        v r101 = this.f491759b;
        p r102 = this.f491760c.l();
        Object r103 = this.f491761d;
        if ((r103 instanceof io.ktor.http.content.c) == false) goto L5;
        io.ktor.http.content.c r104 = (io.ktor.http.content.c) r103;
    L6:
        io.ktor.http.content.c r105 = r104;
        if (r105 == null) goto L11;
        return new c(r100, r101, r102, r105, this.f491762e, this.f491763f);
    L11:
        throw new IllegalStateException(("No request transformation found: " + this.f491761d).toString());
    L5:
        r104 = null;
        goto L6
    }

    public HttpRequestBuilder() {
        this.f491758a = new g0(null);
        this.f491759b = v.f491905b;
        this.f491760c = new o(0);
        this.f491761d = io.ktor.client.utils.c.f491798a;
        this.f491762e = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.f491763f = new io.ktor.util.h();
    }

    @Override // io.ktor.http.t
    public final o getHeaders() {
        return this.f491760c;
    }

    @InternalAPI
    public final void b(isc.a r100) {
        if (r100 == null) goto L4;
        this.f491763f.a(g.f491786a, r100);
        return;
    L4:
        io.ktor.util.c r101 = this.f491763f;
        io.ktor.util.a<isc.a> r102 = g.f491786a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "key");
        r101.f().remove(r102);
    }

    public final void d(HttpRequestBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f491759b = r100.f491759b;
        this.f491761d = r100.f491761d;
        b((isc.a) r100.f491763f.b(g.f491786a));
        l0.c(this.f491758a, r100.f491758a);
        g0 r101 = this.f491758a;
        r101.d(r101.f491869h);
        s.a(this.f491760c, r100.f491760c);
        io.ktor.util.c r102 = this.f491763f;
        io.ktor.util.c r103 = r100.f491763f;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        Intrinsics.checkNotNullParameter(r103, "other");
        Iterator r104 = CollectionsKt.toList(r103.f().keySet()).iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        io.ktor.util.a r105 = (io.ktor.util.a) r104.next();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type io.ktor.util.AttributeKey<kotlin.Any>");
        r102.a(r105, r103.c(r105));
        goto L4
    }

    public final <T> void c(io.ktor.client.engine.c<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "capability");
        ((Map) this.f491763f.e(io.ktor.client.engine.d.f491644a, HttpRequestBuilder$setCapability$capabilities$1.INSTANCE)).put(r100, r101);
    }
}
