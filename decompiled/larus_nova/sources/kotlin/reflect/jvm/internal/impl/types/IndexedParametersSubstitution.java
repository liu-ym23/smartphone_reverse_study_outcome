package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* JADX INFO: loaded from: classes42.dex */
public final class IndexedParametersSubstitution extends TypeSubstitution {
    private final boolean approximateContravariantCapturedTypes;
    private final TypeProjection[] arguments;
    private final TypeParameterDescriptor[] parameters;

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean isEmpty() {
        if (this.arguments.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean approximateContravariantCapturedTypes() {
        return this.approximateContravariantCapturedTypes;
    }

    public final TypeProjection[] getArguments() {
        return this.arguments;
    }

    public final TypeParameterDescriptor[] getParameters() {
        return this.parameters;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    /* JADX INFO: renamed from: get */
    public TypeProjection mo10737get(KotlinType r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        ClassifierDescriptor r101 = r100.getConstructor().mo10732getDeclarationDescriptor();
        if ((r101 instanceof TypeParameterDescriptor) == false) goto L5;
        TypeParameterDescriptor r102 = (TypeParameterDescriptor) r101;
    L6:
        if (r102 != null) goto L8;
        return null;
    L8:
        int r103 = r102.getIndex();
        TypeParameterDescriptor[] r104 = this.parameters;
        if (r103 < r104.length) goto L11;
    L14:
        return null;
    L11:
        if (Intrinsics.areEqual(r104[r103].getTypeConstructor(), r102.getTypeConstructor()) == false) goto L14;
        return this.arguments[r103];
    L5:
        r102 = null;
        goto L6
    }

    public IndexedParametersSubstitution(List<? extends TypeParameterDescriptor> r100, List<? extends TypeProjection> r101) {
        Intrinsics.checkNotNullParameter(r100, "parameters");
        Intrinsics.checkNotNullParameter(r101, "argumentsList");
        this((TypeParameterDescriptor[]) r100.toArray(new TypeParameterDescriptor[0]), (TypeProjection[]) r101.toArray(new TypeProjection[0]), false, 4, null);
    }

    public IndexedParametersSubstitution(TypeParameterDescriptor[] r100, TypeProjection[] r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "parameters");
        Intrinsics.checkNotNullParameter(r101, "arguments");
        this.parameters = r100;
        this.arguments = r101;
        this.approximateContravariantCapturedTypes = r102;
        int r103 = r100.length;
        int r104 = r101.length;
    }

    public /* synthetic */ IndexedParametersSubstitution(TypeParameterDescriptor[] r100, TypeProjection[] r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = false;
    L5:
        this(r100, r101, r102);
    }
}
