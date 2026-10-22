package lc1;

import com.bytedance.android.live.base.IService;
import jc1.k;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static final <T extends IService> T a(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$inst");
        Class r101 = JvmClassMappingKt.getJavaClass(r100);
        Intrinsics.checkNotNullParameter(r101, "$this$inst");
        return (T) k.f(r101);
    }
}
