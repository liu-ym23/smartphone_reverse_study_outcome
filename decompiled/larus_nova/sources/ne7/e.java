package ne7;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeResultModelArguments;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes22.dex */
public final class e {
    public static final b a(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = c.a.f518888a;
        return new b(r100);
    }

    public static final <T extends XBaseModel> T b(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (T) XBridgeResultModelArguments.INSTANCE.createModel(r100);
    }

    public static final <T extends XBaseModel> T c(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (T) XBridgeResultModelArguments.INSTANCE.createModel(JvmClassMappingKt.getJavaClass(r100));
    }
}
