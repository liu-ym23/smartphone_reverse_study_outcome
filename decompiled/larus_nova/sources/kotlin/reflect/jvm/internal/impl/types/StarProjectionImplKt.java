package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* JADX INFO: loaded from: classes42.dex */
public final class StarProjectionImplKt {
    public static final KotlinType starProjectionType(TypeParameterDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        DeclarationDescriptor r101 = r100.getContainingDeclaration();
        if ((r101 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L10;
        List<TypeParameterDescriptor> r102 = ((ClassifierDescriptorWithTypeParameters) r101).getTypeConstructor().getParameters();
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L21;
        r103.add(((TypeParameterDescriptor) r104.next()).getTypeConstructor());
        goto L6
    L21:
        return buildStarProjectionTypeByTypeParameters(r103, r100.getUpperBounds(), DescriptorUtilsKt.getBuiltIns(r100));
    L10:
        if ((r101 instanceof FunctionDescriptor) == false) goto L18;
        List<TypeParameterDescriptor> r105 = ((FunctionDescriptor) r101).getTypeParameters();
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator<T> r107 = r105.iterator();
    L13:
        if (r107.hasNext() == false) goto L16;
        r106.add(((TypeParameterDescriptor) r107.next()).getTypeConstructor());
        goto L13
    L16:
        return buildStarProjectionTypeByTypeParameters(r106, r100.getUpperBounds(), DescriptorUtilsKt.getBuiltIns(r100));
    L18:
        throw new IllegalArgumentException("Unsupported descriptor type to build star projection type based on type parameters of it");
    }

    private static final KotlinType buildStarProjectionTypeByTypeParameters(final List<? extends TypeConstructor> r100, List<? extends KotlinType> r101, KotlinBuiltIns r102) {
        KotlinType r103 = TypeSubstitutor.create(new AnonymousClass1(r100)).substitute((KotlinType) CollectionsKt.first(r101), Variance.OUT_VARIANCE);
        if (r103 == null) goto L5;
        return r103;
    L5:
        return r102.getDefaultBound();
    }
}
