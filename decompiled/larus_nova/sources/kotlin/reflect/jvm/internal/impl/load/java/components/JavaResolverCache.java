package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes5.dex */
public interface JavaResolverCache {
    public static final JavaResolverCache EMPTY = null;

    ClassDescriptor getClassResolvedFromSource(FqName r100);

    void recordClass(JavaClass r100, ClassDescriptor r101);

    void recordConstructor(JavaElement r100, ConstructorDescriptor r101);

    void recordField(JavaField r100, PropertyDescriptor r101);

    void recordMethod(JavaMember r100, SimpleFunctionDescriptor r101);

    static {
        EMPTY = new AnonymousClass1();
    }
}
