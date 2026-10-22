package io.ktor.client.call;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/client/call/UnsupportedContentTypeException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "Lio/ktor/http/content/c;", "content", "<init>", "(Lio/ktor/http/content/c;)V", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final class UnsupportedContentTypeException extends IllegalStateException {
    public UnsupportedContentTypeException(io.ktor.http.content.c r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        super("Failed to write body: " + Reflection.getOrCreateKotlinClass(r100.getClass()));
    }
}
