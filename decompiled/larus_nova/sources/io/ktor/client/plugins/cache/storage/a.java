package io.ktor.client.plugins.cache.storage;

import io.ktor.http.Url;
import java.util.Map;
import java.util.Set;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes41.dex */
public interface a {
    Object a(Url r100, Map<String, String> r101, Continuation<? super b> r102);

    Object b(Url r100, b r101, ContinuationImpl r102);

    Object c(Url r100, Continuation<? super Set<b>> r101);
}
