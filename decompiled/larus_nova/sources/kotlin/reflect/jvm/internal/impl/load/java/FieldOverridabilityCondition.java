package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JavaDescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;

/* JADX INFO: loaded from: classes5.dex */
public final class FieldOverridabilityCondition implements ExternalOverridabilityCondition {
    public FieldOverridabilityCondition() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Contract getContract() {
        return ExternalOverridabilityCondition.Contract.BOTH;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Result isOverridable(CallableDescriptor r100, CallableDescriptor r101, ClassDescriptor r102) {
        Intrinsics.checkNotNullParameter(r100, "superDescriptor");
        Intrinsics.checkNotNullParameter(r101, "subDescriptor");
        if ((r101 instanceof PropertyDescriptor) == false) goto L27;
        if ((r100 instanceof PropertyDescriptor) == false) goto L27;
        PropertyDescriptor r103 = (PropertyDescriptor) r101;
        PropertyDescriptor r104 = (PropertyDescriptor) r100;
        if (Intrinsics.areEqual(r103.getName(), r104.getName()) == true) goto L12;
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    L12:
        if (JavaDescriptorUtilKt.isJavaField(r103) == false) goto L18;
        if (JavaDescriptorUtilKt.isJavaField(r104) == false) goto L18;
        return ExternalOverridabilityCondition.Result.OVERRIDABLE;
    L18:
        if (JavaDescriptorUtilKt.isJavaField(r103) == true) goto L25;
        if (JavaDescriptorUtilKt.isJavaField(r104) == true) goto L25;
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    L25:
        return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
    L27:
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }
}
