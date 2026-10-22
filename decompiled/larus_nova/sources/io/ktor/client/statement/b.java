package io.ktor.client.statement;

import io.ktor.client.call.HttpClientCall;
import io.ktor.http.s;
import io.ktor.http.w;
import io.ktor.http.x;
import io.ktor.utils.io.ByteReadChannel;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes41.dex */
public abstract class b implements s, CoroutineScope {
    public b() {
    }

    public abstract ByteReadChannel a();

    public abstract HttpClientCall a80();

    public abstract hsc.a b();

    public abstract hsc.a c();

    public abstract x d();

    public abstract w e();

    public final String toString() {
        return "HttpResponse[" + HttpResponseKt.c(this).getUrl() + ", " + d() + ']';
    }
}
