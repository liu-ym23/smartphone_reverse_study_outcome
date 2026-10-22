package io.ktor.client;

import io.ktor.client.engine.e;
import io.ktor.util.KtorDsl;
import io.ktor.util.o;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes41.dex */
@KtorDsl
public final class HttpClientConfig<T extends e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<io.ktor.util.a<?>, Function1<Object, Unit>> f491618a;

    public HttpClientConfig() {
        new LinkedHashMap();
        this.f491618a = new LinkedHashMap();
        new LinkedHashMap();
        HttpClientConfig$engineConfig$1 r100 = HttpClientConfig$engineConfig$1.INSTANCE;
        boolean r101 = o.f491970a;
    }
}
