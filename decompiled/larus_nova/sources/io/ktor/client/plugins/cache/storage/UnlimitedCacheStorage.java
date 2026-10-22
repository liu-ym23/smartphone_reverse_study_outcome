package io.ktor.client.plugins.cache.storage;

import io.ktor.http.Url;
import io.ktor.util.collections.ConcurrentMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class UnlimitedCacheStorage extends HttpCacheStorage {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentMap<Url, Set<io.ktor.client.plugins.cache.b>> f491696b;

    public UnlimitedCacheStorage() {
        this.f491696b = new ConcurrentMap();
    }

    @Override // io.ktor.client.plugins.cache.storage.HttpCacheStorage
    public final Set<io.ktor.client.plugins.cache.b> b(Url r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Set<io.ktor.client.plugins.cache.b> r101 = this.f491696b.get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return SetsKt.emptySet();
    }

    @Override // io.ktor.client.plugins.cache.storage.HttpCacheStorage
    public final io.ktor.client.plugins.cache.b a(Url r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "varyKeys");
        Iterator<T> r102 = this.f491696b.a(r100, UnlimitedCacheStorage$find$data$1.INSTANCE).iterator();
    L4:
        if (r102.hasNext() == false) goto L17;
        Object r103 = r102.next();
        io.ktor.client.plugins.cache.b r104 = (io.ktor.client.plugins.cache.b) r103;
        if (r101.isEmpty() == true) goto L14;
        Iterator<Map.Entry<String, String>> r105 = r101.entrySet().iterator();
    L10:
        if (r105.hasNext() == false) goto L14;
        Map.Entry<String, String> r106 = r105.next();
        String r107 = r106.getKey();
        String r108 = r106.getValue();
        if (Intrinsics.areEqual(r104.f491680b.get(r107), r108) == true) goto L10;
        boolean r109 = false;
    L15:
        if (r109 == false) goto L4;
    L19:
        return (io.ktor.client.plugins.cache.b) r103;
    L14:
        r109 = true;
        goto L15
    L17:
        r103 = null;
        goto L19
    }

    @Override // io.ktor.client.plugins.cache.storage.HttpCacheStorage
    public final void c(Url r100, io.ktor.client.plugins.cache.b r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "value");
        Set<io.ktor.client.plugins.cache.b> r102 = this.f491696b.a(r100, UnlimitedCacheStorage$store$data$1.INSTANCE);
        if (r102.add(r101) == true) goto L6;
        r102.remove(r101);
        r102.add(r101);
        return;
    }
}
