package io.ktor.client.plugins;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes41.dex */
public final class HttpSend {

    public static final class DefaultSender implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f491658a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final io.ktor.client.a f491659b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f491660c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public HttpClientCall f491661d;

        public DefaultSender(int r100, io.ktor.client.a r101) {
            Intrinsics.checkNotNullParameter(r101, "client");
            this.f491658a = r100;
            this.f491659b = r101;
        }

        @Override // io.ktor.client.plugins.v
        public final Object a(HttpRequestBuilder r100, Continuation<? super HttpClientCall> r101) {
            if ((r101 instanceof HttpSend$DefaultSender$execute$1) == false) goto L7;
            HttpSend$DefaultSender$execute$1 r102 = (HttpSend$DefaultSender$execute$1) r101;
            int r103 = r102.label;
            if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
            r102.label = r103 - Integer.MIN_VALUE;
        L8:
            Object r104 = r102.result;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r105 = r102.label;
            HttpClientCall r106 = null;
            if (r105 == 0) goto L21;
            if (r105 != 1) goto L20;
            DefaultSender r107 = (DefaultSender) r102.L$0;
            ResultKt.throwOnFailure(r104);
            if ((r104 instanceof HttpClientCall) == false) goto L14;
            r106 = (HttpClientCall) r104;
        L14:
            if (r106 == null) goto L18;
            r107.f491661d = r106;
            return r106;
        L18:
            throw new IllegalStateException(("Failed to execute send pipeline. Expected [HttpClientCall], but received " + r104).toString());
        L20:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L21:
            ResultKt.throwOnFailure(r104);
            HttpClientCall r108 = this.f491661d;
            if (r108 == null) goto L24;
            CoroutineScopeKt.cancel$default(r108, null, 1, null);
        L24:
            int r109 = this.f491660c;
            if (r109 >= this.f491658a) goto L27;
            this.f491660c = r109 + 1;
            this.f491659b.getClass();
            Object r110 = r100.f491761d;
            r102.L$0 = this;
            r102.label = 1;
            throw null;
        L27:
            throw new SendCountExceedException("Max send count " + this.f491658a + " exceeded. Consider increasing the property maxSendCount if more is required.");
        L7:
            r102 = new HttpSend$DefaultSender$execute$1(this, r101);
            goto L8
        }
    }

    public static final class a implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function3<v, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> f491662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final v f491663b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function3<? super v, ? super HttpRequestBuilder, ? super Continuation<? super HttpClientCall>, ? extends Object> r100, v r101) {
            Intrinsics.checkNotNullParameter(r100, "interceptor");
            Intrinsics.checkNotNullParameter(r101, "nextSender");
            this.f491662a = r100;
            this.f491663b = r101;
        }

        @Override // io.ktor.client.plugins.v
        public final Object a(HttpRequestBuilder r100, Continuation<? super HttpClientCall> r101) {
            return this.f491662a.invoke(this.f491663b, r100, r101);
        }
    }
}
