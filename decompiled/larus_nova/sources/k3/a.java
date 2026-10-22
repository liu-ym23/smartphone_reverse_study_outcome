package k3;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes43.dex */
public final class a {
    public static final <T extends BaseModel> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (T) c.a(r100);
    }

    public static final <T extends BaseModel> T b(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = c.f501630a;
        return (T) c.a(JvmClassMappingKt.getJavaClass(r100));
    }
}
