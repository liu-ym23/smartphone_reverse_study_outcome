package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes42.dex */
public final class ConstUtil {
    public static final ConstUtil INSTANCE = null;

    static {
        INSTANCE = new ConstUtil();
    }

    private ConstUtil() {
    }

    @JvmStatic
    public static final boolean canBeUsedForConstVal(KotlinType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return ConstUtilKt.canBeUsedForConstVal(r100);
    }
}
