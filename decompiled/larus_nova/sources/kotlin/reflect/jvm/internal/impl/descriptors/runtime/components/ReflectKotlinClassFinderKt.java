package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes5.dex */
public final class ReflectKotlinClassFinderKt {
    public static final /* synthetic */ String access$toRuntimeFqName(ClassId r100) {
        return toRuntimeFqName(r100);
    }

    private static final String toRuntimeFqName(ClassId r100) {
        String r101 = StringsKt.replace$default(r100.getRelativeClassName().asString(), '.', Typography.dollar, false, 4, null);
        if (r100.getPackageFqName().isRoot() == false) goto L6;
        return r101;
    L6:
        return r100.getPackageFqName() + '.' + r101;
    }
}
