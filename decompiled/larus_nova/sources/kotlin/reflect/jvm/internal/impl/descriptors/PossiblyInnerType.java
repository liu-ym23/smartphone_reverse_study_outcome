package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* JADX INFO: loaded from: classes42.dex */
public final class PossiblyInnerType {
    private final List<TypeProjection> arguments;
    private final ClassifierDescriptorWithTypeParameters classifierDescriptor;
    private final PossiblyInnerType outerType;

    public final List<TypeProjection> getArguments() {
        return this.arguments;
    }

    public final ClassifierDescriptorWithTypeParameters getClassifierDescriptor() {
        return this.classifierDescriptor;
    }

    public final PossiblyInnerType getOuterType() {
        return this.outerType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PossiblyInnerType(ClassifierDescriptorWithTypeParameters r100, List<? extends TypeProjection> r101, PossiblyInnerType r102) {
        Intrinsics.checkNotNullParameter(r100, "classifierDescriptor");
        Intrinsics.checkNotNullParameter(r101, "arguments");
        this.classifierDescriptor = r100;
        this.arguments = r101;
        this.outerType = r102;
    }
}
