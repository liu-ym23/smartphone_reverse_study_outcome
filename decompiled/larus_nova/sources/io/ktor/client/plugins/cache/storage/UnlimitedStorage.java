package io.ktor.client.plugins.cache.storage;

import io.ktor.http.Url;
import io.ktor.util.collections.ConcurrentMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class UnlimitedStorage implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentMap<Url, Set<b>> f491697a;

    public UnlimitedStorage() {
        this.f491697a = new ConcurrentMap();
    }

    @Override // io.ktor.client.plugins.cache.storage.a
    public final Object c(Url r100, Continuation<? super Set<b>> r101) {
        Set<b> r102 = this.f491697a.get(r100);
        if (r102 == null) goto L5;
        return r102;
    L5:
        return SetsKt.emptySet();
    }

    @Override // io.ktor.client.plugins.cache.storage.a
    public final Object a(Url r100, Map<String, String> r101, Continuation<? super b> r102) {
        Iterator<T> r103 = this.f491697a.a(r100, UnlimitedStorage$find$data$1.INSTANCE).iterator();
    L4:
        if (r103.hasNext() == false) goto L16;
        Object r104 = r103.next();
        b r105 = (b) r104;
        boolean r106 = true;
        if (r101.isEmpty() == true) goto L14;
        Iterator<Map.Entry<String, String>> r107 = r101.entrySet().iterator();
    L10:
        if (r107.hasNext() == false) goto L14;
        Map.Entry<String, String> r108 = r107.next();
        String r109 = r108.getKey();
        String r110 = r108.getValue();
        if (Intrinsics.areEqual(r105.f491705h.get(r109), r110) == true) goto L10;
        r106 = false;
    L14:
        if (r106 == false) goto L4;
        return r104;
    L16:
        return null;
    }

    @Override // io.ktor.client.plugins.cache.storage.a
    public final Object b(Url r100, b r101, ContinuationImpl r102) {
        Set<b> r103 = this.f491697a.a(r100, UnlimitedStorage$store$cache$1.INSTANCE);
        if (r103.add(r101) == true) goto L6;
        r103.remove(r101);
        r103.add(r101);
    L6:
        return Unit.INSTANCE;
    }
}
