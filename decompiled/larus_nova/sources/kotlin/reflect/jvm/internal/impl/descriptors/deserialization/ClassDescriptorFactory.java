package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes5.dex */
public interface ClassDescriptorFactory {
    ClassDescriptor createClass(ClassId r100);

    Collection<ClassDescriptor> getAllContributedClassesIfPossible(FqName r100);

    boolean shouldCreateClass(FqName r100, Name r101);
}
