package kotlinx.serialization.modules;

import java.util.List;
import juc.n;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KClass;
import kotlinx.serialization.ExperimentalSerializationApi;

/* JADX INFO: loaded from: classes5.dex */
@ExperimentalSerializationApi
public interface g {
    <T> void a(KClass<T> r100, Function1<? super List<? extends juc.d<?>>, ? extends juc.d<?>> r101);

    <T> void b(KClass<T> r100, juc.d<T> r101);

    <Base> void c(KClass<Base> r100, Function1<? super String, ? extends juc.c<? extends Base>> r101);

    <Base> void d(KClass<Base> r100, Function1<? super Base, ? extends n<? super Base>> r101);

    <Base, Sub extends Base> void e(KClass<Base> r100, KClass<Sub> r101, juc.d<Sub> r102);
}
