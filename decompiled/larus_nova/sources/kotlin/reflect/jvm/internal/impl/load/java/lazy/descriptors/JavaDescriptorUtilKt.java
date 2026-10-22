package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;

/* JADX INFO: loaded from: classes42.dex */
public final class JavaDescriptorUtilKt {
    public static final boolean isJavaField(PropertyDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getGetter() != null) goto L5;
        return true;
    L5:
        return false;
    }
}
