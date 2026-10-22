package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes5.dex */
public interface SyntheticJavaPartsProvider {
    public static final Companion Companion = null;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final CompositeSyntheticJavaPartsProvider EMPTY = null;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            EMPTY = new CompositeSyntheticJavaPartsProvider(CollectionsKt.emptyList());
        }

        public final CompositeSyntheticJavaPartsProvider getEMPTY() {
            return EMPTY;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void generateConstructors(ClassDescriptor r100, List<ClassConstructorDescriptor> r101, LazyJavaResolverContext r102);

    void generateMethods(ClassDescriptor r100, Name r101, Collection<SimpleFunctionDescriptor> r102, LazyJavaResolverContext r103);

    void generateNestedClass(ClassDescriptor r100, Name r101, List<ClassDescriptor> r102, LazyJavaResolverContext r103);

    void generateStaticFunctions(ClassDescriptor r100, Name r101, Collection<SimpleFunctionDescriptor> r102, LazyJavaResolverContext r103);

    List<Name> getMethodNames(ClassDescriptor r100, LazyJavaResolverContext r101);

    List<Name> getNestedClassNames(ClassDescriptor r100, LazyJavaResolverContext r101);

    List<Name> getStaticFunctionNames(ClassDescriptor r100, LazyJavaResolverContext r101);

    PropertyDescriptorImpl modifyField(ClassDescriptor r100, PropertyDescriptorImpl r101, LazyJavaResolverContext r102);
}
