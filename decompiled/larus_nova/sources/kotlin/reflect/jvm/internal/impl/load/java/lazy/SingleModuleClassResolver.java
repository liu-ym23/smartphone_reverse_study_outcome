package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JavaDescriptorResolver;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleModuleClassResolver implements ModuleClassResolver {
    public JavaDescriptorResolver resolver;

    public SingleModuleClassResolver() {
    }

    public final JavaDescriptorResolver getResolver() {
        JavaDescriptorResolver r100 = this.resolver;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("resolver");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver
    public ClassDescriptor resolveClass(JavaClass r100) {
        Intrinsics.checkNotNullParameter(r100, "javaClass");
        return getResolver().resolveClass(r100);
    }

    public final void setResolver(JavaDescriptorResolver r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.resolver = r100;
    }
}
