package owc;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.koin.core.definition.BeanDefinition;

/* JADX INFO: loaded from: classes42.dex */
public final class a {
    public static final void a(BeanDefinition r100, KClass r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        List<? extends KClass<?>> r102 = CollectionsKt.plus(r100.f526133f, r101);
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r100.f526133f = r102;
    }
}
