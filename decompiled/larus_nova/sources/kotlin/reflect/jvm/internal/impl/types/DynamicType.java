package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes42.dex */
public final class DynamicType extends FlexibleType implements DynamicTypeMarker {
    private final TypeAttributes attributes;

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public DynamicType makeNullableAsSpecified(boolean r100) {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public DynamicType refine(KotlinTypeRefiner r100) {
        Intrinsics.checkNotNullParameter(r100, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public String render(DescriptorRenderer r100, DescriptorRendererOptions r101) {
        Intrinsics.checkNotNullParameter(r100, "renderer");
        Intrinsics.checkNotNullParameter(r101, "options");
        return "dynamic";
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public SimpleType getDelegate() {
        return getUpperBound();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public TypeAttributes getAttributes() {
        return this.attributes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType makeNullableAsSpecified(boolean r100) {
        return makeNullableAsSpecified(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ KotlinType refine(KotlinTypeRefiner r100) {
        return refine(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public DynamicType replaceAttributes(TypeAttributes r100) {
        Intrinsics.checkNotNullParameter(r100, "newAttributes");
        return new DynamicType(TypeUtilsKt.getBuiltIns(getDelegate()), r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ UnwrappedType refine(KotlinTypeRefiner r100) {
        return refine(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType replaceAttributes(TypeAttributes r100) {
        return replaceAttributes(r100);
    }

    public DynamicType(KotlinBuiltIns r100, TypeAttributes r101) {
        Intrinsics.checkNotNullParameter(r100, "builtIns");
        Intrinsics.checkNotNullParameter(r101, "attributes");
        super(r100.getNothingType(), r100.getNullableAnyType());
        this.attributes = r101;
    }
}
