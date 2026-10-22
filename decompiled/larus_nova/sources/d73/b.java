package d73;

import com.bytedance.jedi.model.guava.cache.Cache;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Cache<K, V> f467229a;

    public b(Cache<K, V> r100) {
        Intrinsics.checkNotNullParameter(r100, "mRealCache");
        this.f467229a = r100;
    }
}
