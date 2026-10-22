package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes42.dex */
public final class MethodSignatureMappingKt {
    public static final String computeJvmSignature(CallableDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        SignatureBuildingComponents r101 = SignatureBuildingComponents.INSTANCE;
        if (DescriptorUtils.isLocal(r100) == false) goto L5;
        return null;
    L5:
        DeclarationDescriptor r102 = r100.getContainingDeclaration();
        if ((r102 instanceof ClassDescriptor) == false) goto L8;
        ClassDescriptor r103 = (ClassDescriptor) r102;
    L9:
        if (r103 != null) goto L12;
        return null;
    L12:
        if (r103.getName().isSpecial() == false) goto L14;
        return null;
    L14:
        CallableDescriptor r104 = r100.getOriginal();
        if ((r104 instanceof SimpleFunctionDescriptor) == false) goto L17;
        SimpleFunctionDescriptor r105 = (SimpleFunctionDescriptor) r104;
    L18:
        if (r105 != null) goto L21;
        return null;
    L21:
        return MethodSignatureBuildingUtilsKt.signature(r101, r103, computeJvmDescriptor$default(r105, false, false, 3, null));
    L17:
        r105 = null;
        goto L18
    L8:
        r103 = null;
        goto L9
    }

    public static final boolean forceSingleValueParameterBoxing(CallableDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "f");
        if ((r100 instanceof FunctionDescriptor) == true) goto L5;
        return false;
    L5:
        FunctionDescriptor r101 = (FunctionDescriptor) r100;
        if (Intrinsics.areEqual(r101.getName().asString(), "remove") == true) goto L8;
        return false;
    L8:
        if (r101.getValueParameters().size() == 1) goto L10;
        return false;
    L10:
        if (SpecialBuiltinMembers.isFromJavaOrBuiltins((CallableMemberDescriptor) r100) == true) goto L37;
        JvmType r102 = mapToJvmType(((ValueParameterDescriptor) CollectionsKt.single(r101.getOriginal().getValueParameters())).getType());
        JvmPrimitiveType r103 = null;
        if ((r102 instanceof JvmType.Primitive) == false) goto L15;
        JvmType.Primitive r104 = (JvmType.Primitive) r102;
    L16:
        if (r104 == null) goto L19;
        r103 = r104.getJvmPrimitiveType();
    L19:
        if (r103 == JvmPrimitiveType.INT) goto L21;
        return false;
    L21:
        FunctionDescriptor r105 = BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(r101);
        if (r105 != null) goto L24;
        return false;
    L24:
        JvmType r106 = mapToJvmType(((ValueParameterDescriptor) CollectionsKt.single(r105.getOriginal().getValueParameters())).getType());
        if (Intrinsics.areEqual(DescriptorUtilsKt.getFqNameUnsafe(r105.getContainingDeclaration()), StandardNames.FqNames.mutableCollection.toUnsafe()) == true) goto L27;
        return false;
    L27:
        if ((r106 instanceof JvmType.Object) == true) goto L29;
        return false;
    L29:
        if (Intrinsics.areEqual(((JvmType.Object) r106).getInternalName(), "java/lang/Object") == false) goto L36;
        return true;
    L36:
        return false;
    L15:
        r104 = null;
        goto L16
    L37:
        return false;
    }

    public static final String getInternalName(ClassDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ClassId r101 = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(DescriptorUtilsKt.getFqNameSafe(r100).toUnsafe());
        if (r101 == null) goto L7;
        return JvmClassName.internalNameByClassId(r101);
    L7:
        return DescriptorBasedTypeSignatureMappingKt.computeInternalName$default(r100, null, 2, null);
    }

    public static final JvmType mapToJvmType(KotlinType r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (JvmType) DescriptorBasedTypeSignatureMappingKt.mapType$default(r100, JvmTypeFactoryImpl.INSTANCE, TypeMappingMode.DEFAULT, TypeMappingConfigurationImpl.INSTANCE, null, null, 32, null);
    }

    private static final void appendErasedType(StringBuilder r100, KotlinType r101) {
        r100.append(mapToJvmType(r101));
    }

    public static final String computeJvmDescriptor(FunctionDescriptor r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        StringBuilder r103 = new StringBuilder();
        if (r102 == true) goto L5;
    L9:
        r103.append("(");
        ReceiverParameterDescriptor r104 = r100.getExtensionReceiverParameter();
        if (r104 == null) goto L12;
        appendErasedType(r103, r104.getType());
    L12:
        Iterator<ValueParameterDescriptor> r105 = r100.getValueParameters().iterator();
    L14:
        if (r105.hasNext() == false) goto L16;
        appendErasedType(r103, r105.next().getType());
        goto L14
    L16:
        r103.append(")");
        if (r101 == false) goto L23;
        if (DescriptorBasedTypeSignatureMappingKt.hasVoidReturnType(r100) == false) goto L21;
        r103.append("V");
        goto L23
    L21:
        KotlinType r106 = r100.getReturnType();
        Intrinsics.checkNotNull(r106);
        appendErasedType(r103, r106);
    L23:
        return r103.toString();
    L5:
        if ((r100 instanceof ConstructorDescriptor) == false) goto L7;
        String r107 = "<init>";
    L8:
        r103.append(r107);
        goto L9
    L7:
        r107 = r100.getName().asString();
        goto L8
    }

    public static /* synthetic */ String computeJvmDescriptor$default(FunctionDescriptor r100, boolean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = true;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = true;
    L9:
        return computeJvmDescriptor(r100, r101, r102);
    }
}
