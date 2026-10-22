package io.ktor.client.request;

import io.ktor.client.call.HttpClientCall;
import io.ktor.http.Url;
import io.ktor.http.s;
import io.ktor.http.v;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes41.dex */
public interface b extends s, CoroutineScope {
    HttpClientCall a80();

    io.ktor.util.b getAttributes();

    io.ktor.http.content.c getContent();

    CoroutineContext getCoroutineContext();

    v getMethod();

    Url getUrl();
}
