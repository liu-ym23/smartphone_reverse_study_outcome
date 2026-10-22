package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes42.dex */
public interface TypeMappingConfiguration<T> {
    KotlinType commonSupertype(Collection<KotlinType> r100);

    String getPredefinedFullInternalNameForClass(ClassDescriptor r100);

    String getPredefinedInternalNameForClass(ClassDescriptor r100);

    T getPredefinedTypeForClass(ClassDescriptor r100);

    KotlinType preprocessType(KotlinType r100);

    void processErrorType(KotlinType r100, ClassDescriptor r101);
}
