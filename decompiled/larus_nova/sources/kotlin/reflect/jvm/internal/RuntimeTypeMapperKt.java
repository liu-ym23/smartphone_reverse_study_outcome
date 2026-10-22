package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"signature", "", "Ljava/lang/reflect/Method;", "getSignature", "(Ljava/lang/reflect/Method;)Ljava/lang/String;", "kotlin-reflection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RuntimeTypeMapperKt {
    public static /* synthetic */ CharSequence accessor$RuntimeTypeMapperKt$lambda0(Class r100) {
        return _get_signature_$lambda$0(r100);
    }

    private static final CharSequence _get_signature_$lambda$0(Class r100) {
        Intrinsics.checkNotNull(r100);
        return ReflectClassUtilKt.getDesc(r100);
    }

    public static final /* synthetic */ String access$getSignature(Method r100) {
        return getSignature(r100);
    }

    private static final String getSignature(Method r110) {
        return r110.getName() + ArraysKt.joinToString$default(r110.getParameterTypes(), "", "(", ")", 0, null, RuntimeTypeMapperKt$$Lambda$0.INSTANCE, 24, null) + ReflectClassUtilKt.getDesc(r110.getReturnType());
    }
}
