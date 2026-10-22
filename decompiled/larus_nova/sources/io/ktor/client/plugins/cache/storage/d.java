package io.ktor.client.plugins.cache.storage;

import io.ktor.http.Url;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class d extends HttpCacheStorage {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f491707b = 0;

    static {
        new d();
    }

    @Override // io.ktor.client.plugins.cache.storage.HttpCacheStorage
    public final io.ktor.client.plugins.cache.b a(Url r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "varyKeys");
        return null;
    }

    @Override // io.ktor.client.plugins.cache.storage.HttpCacheStorage
    public final void c(Url r100, io.ktor.client.plugins.cache.b r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "value");
    }

    public d() {
    }

    @Override // io.ktor.client.plugins.cache.storage.HttpCacheStorage
    public final Set<io.ktor.client.plugins.cache.b> b(Url r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return SetsKt.emptySet();
    }
}
