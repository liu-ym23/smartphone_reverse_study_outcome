package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* JADX INFO: loaded from: classes5.dex */
public final class JavaDescriptorResolver {
    private final JavaResolverCache javaResolverCache;
    private final LazyJavaPackageFragmentProvider packageFragmentProvider;

    public final LazyJavaPackageFragmentProvider getPackageFragmentProvider() {
        return this.packageFragmentProvider;
    }

    public final ClassDescriptor resolveClass(JavaClass r100) {
        Intrinsics.checkNotNullParameter(r100, "javaClass");
        FqName r101 = r100.getFqName();
        if (r101 != null) goto L5;
    L8:
        JavaClass r102 = r100.getOuterClass();
        if (r102 == null) goto L21;
        ClassDescriptor r103 = resolveClass(r102);
        if (r103 == null) goto L13;
        MemberScope r104 = r103.getUnsubstitutedInnerClassesScope();
    L14:
        if (r104 == null) goto L16;
        ClassifierDescriptor r105 = r104.mo10734getContributedClassifier(r100.getName(), NoLookupLocation.FROM_JAVA_LOADER);
    L18:
        if ((r105 instanceof ClassDescriptor) == true) goto L20;
        return null;
    L20:
        return (ClassDescriptor) r105;
    L16:
        r105 = null;
        goto L18
    L13:
        r104 = null;
        goto L14
    L21:
        if (r101 != null) goto L23;
        return null;
    L23:
        LazyJavaPackageFragment r106 = (LazyJavaPackageFragment) CollectionsKt.firstOrNull(this.packageFragmentProvider.getPackageFragments(r101.parent()));
        if (r106 != null) goto L26;
        return null;
    L26:
        return r106.findClassifierByJavaClass$descriptors_jvm(r100);
    L5:
        if (r100.getLightClassOriginKind() != LightClassOriginKind.SOURCE) goto L8;
        return this.javaResolverCache.getClassResolvedFromSource(r101);
    }

    public JavaDescriptorResolver(LazyJavaPackageFragmentProvider r100, JavaResolverCache r101) {
        Intrinsics.checkNotNullParameter(r100, "packageFragmentProvider");
        Intrinsics.checkNotNullParameter(r101, "javaResolverCache");
        this.packageFragmentProvider = r100;
        this.javaResolverCache = r101;
    }
}
