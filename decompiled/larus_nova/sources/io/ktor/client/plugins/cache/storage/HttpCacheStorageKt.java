package io.ktor.client.plugins.cache.storage;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.cache.HttpCacheEntryKt;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.http.Url;
import io.ktor.http.n;
import io.ktor.http.w;
import io.ktor.http.x;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.core.k;
import io.ktor.utils.io.core.v;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class HttpCacheStorageKt {

    public static final class a extends io.ktor.client.statement.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final x f491690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final w f491691b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final hsc.a f491692c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final hsc.a f491693d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final n f491694e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final CoroutineContext f491695f;

        @Override // io.ktor.client.statement.b
        public final ByteReadChannel a() {
            throw new IllegalStateException("This is a fake response");
        }

        @Override // io.ktor.client.statement.b
        public final HttpClientCall a80() {
            throw new IllegalStateException("This is a fake response");
        }

        @Override // io.ktor.client.statement.b
        public final hsc.a b() {
            return this.f491692c;
        }

        @Override // io.ktor.client.statement.b
        public final hsc.a c() {
            return this.f491693d;
        }

        @Override // io.ktor.client.statement.b
        public final x d() {
            return this.f491690a;
        }

        @Override // io.ktor.client.statement.b
        public final w e() {
            return this.f491691b;
        }

        @Override // kotlinx.coroutines.CoroutineScope
        public final CoroutineContext getCoroutineContext() {
            return this.f491695f;
        }

        @Override // io.ktor.http.s
        public final n getHeaders() {
            return this.f491694e;
        }

        public a(b r100, CoroutineContext r101) {
            this.f491690a = r100.f491699b;
            this.f491691b = r100.f491702e;
            this.f491692c = r100.f491700c;
            this.f491693d = r100.f491701d;
            this.f491694e = r100.f491704g;
            this.f491695f = r101;
        }
    }

    public static final io.ktor.client.statement.b a(b r100, io.ktor.client.a r101, io.ktor.client.request.b r102, CoroutineContext r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "client");
        Intrinsics.checkNotNullParameter(r102, "request");
        Intrinsics.checkNotNullParameter(r103, "responseContext");
        return new io.ktor.client.call.a(r101, r102, new a(r100, r103), r100.f491706i).d();
    }

    public static final Object b(io.ktor.client.plugins.cache.storage.a r110, io.ktor.client.statement.b r111, Map<String, String> r210, boolean r211, Continuation<? super b> r212) {
        if ((r212 instanceof HttpCacheStorageKt$store$4) == false) goto L7;
        HttpCacheStorageKt$store$4 r100 = (HttpCacheStorageKt$store$4) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        b r105 = (b) r100.L$0;
        ResultKt.throwOnFailure(r102);
        return r105;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        boolean r106 = r100.Z$0;
        Url r107 = (Url) r100.L$3;
        Map<String, String> r108 = (Map) r100.L$2;
        io.ktor.client.statement.b r109 = (io.ktor.client.statement.b) r100.L$1;
        io.ktor.client.plugins.cache.storage.a r112 = (io.ktor.client.plugins.cache.storage.a) r100.L$0;
        ResultKt.throwOnFailure(r102);
        Map<String, String> r113 = r108;
        io.ktor.client.plugins.cache.storage.a r114 = r112;
    L20:
        byte[] r115 = v.b((k) r102);
        HttpResponseKt.b(r109);
        Url r116 = r109.a80().c().getUrl();
        x r117 = r109.d();
        hsc.a r118 = r109.b();
        n r119 = r109.getHeaders();
        w r120 = r109.e();
        b r121 = new b(r116, r117, r118, r109.c(), r120, HttpCacheEntryKt.b(r109, r106), r119, r113, r115);
        r100.L$0 = r121;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.L$3 = null;
        r100.label = 2;
        if (r114.b(r107, r121, r100) != r103) goto L24;
        return r103;
    L24:
        return r121;
    L16:
        ResultKt.throwOnFailure(r102);
        Url r122 = r111.a80().c().getUrl();
        ByteReadChannel r123 = r111.a();
        r114 = r110;
        r100.L$0 = r114;
        r109 = r111;
        r100.L$1 = r109;
        r100.L$2 = r210;
        r100.L$3 = r122;
        r100.Z$0 = r211;
        r100.label = 1;
        Object r124 = ByteReadChannel.a.a(r123, r100);
        if (r124 != r103) goto L19;
        return r103;
    L19:
        r107 = r122;
        r102 = r124;
        r113 = r210;
        r106 = r211;
    L7:
        r100 = new HttpCacheStorageKt$store$4(r212);
        goto L8
    }

    public static final Object c(HttpCacheStorage r100, Url r101, io.ktor.client.statement.b r102, boolean r103, Continuation<? super io.ktor.client.plugins.cache.b> r104) {
        if ((r104 instanceof HttpCacheStorageKt$store$1) == false) goto L7;
        HttpCacheStorageKt$store$1 r105 = (HttpCacheStorageKt$store$1) r104;
        int r106 = r105.label;
        if ((r106 & Integer.MIN_VALUE) == 0) goto L7;
        r105.label = r106 - Integer.MIN_VALUE;
    L8:
        Object r107 = r105.result;
        Object r108 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r109 = r105.label;
        if (r109 == 0) goto L14;
        if (r109 != 1) goto L13;
        r101 = (Url) r105.L$1;
        r100 = (HttpCacheStorage) r105.L$0;
        ResultKt.throwOnFailure(r107);
    L17:
        io.ktor.client.plugins.cache.b r110 = (io.ktor.client.plugins.cache.b) r107;
        r100.c(r101, r110);
        return r110;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r107);
        r105.L$0 = r100;
        r105.L$1 = r101;
        r105.label = 1;
        r107 = HttpCacheEntryKt.a(r103, r102, r105);
        if (r107 != r108) goto L17;
        return r108;
    L7:
        r105 = new HttpCacheStorageKt$store$1(r104);
        goto L8
    }
}
