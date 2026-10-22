package kotlinx.serialization.modules;

import java.util.List;
import juc.n;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.KClass;
import kotlinx.serialization.ExperimentalSerializationApi;

/* JADX INFO: loaded from: classes5.dex */
public abstract class d {
    public d() {
    }

    @ExperimentalSerializationApi
    public abstract void a(g r100);

    @ExperimentalSerializationApi
    public abstract <T> juc.d<T> b(KClass<T> r100, List<? extends juc.d<?>> r101);

    public abstract boolean d();

    @ExperimentalSerializationApi
    public abstract <T> juc.c<T> e(KClass<? super T> r100, String r101);

    @ExperimentalSerializationApi
    public abstract <T> n<T> f(KClass<? super T> r100, T r101);

    public static /* synthetic */ juc.d c(d r100, KClass r101) {
        return r100.b(r101, CollectionsKt.emptyList());
    }
}
