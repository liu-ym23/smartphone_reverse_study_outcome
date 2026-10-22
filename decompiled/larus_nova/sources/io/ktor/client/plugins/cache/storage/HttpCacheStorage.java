package io.ktor.client.plugins.cache.storage;

import io.ktor.http.Url;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes41.dex */
@Deprecated(message = "Use new [CacheStorage] instead.")
public abstract class HttpCacheStorage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Function0<HttpCacheStorage> f491689a = null;

    public static final class a {
    }

    public abstract io.ktor.client.plugins.cache.b a(Url r100, Map<String, String> r101);

    public abstract Set<io.ktor.client.plugins.cache.b> b(Url r100);

    public abstract void c(Url r100, io.ktor.client.plugins.cache.b r101);

    static {
        f491689a = HttpCacheStorage$Companion$Unlimited$1.INSTANCE;
        int r100 = d.f491707b;
    }

    public HttpCacheStorage() {
    }
}
