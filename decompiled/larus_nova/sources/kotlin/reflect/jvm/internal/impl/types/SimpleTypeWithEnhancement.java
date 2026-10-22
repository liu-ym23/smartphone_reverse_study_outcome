package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: loaded from: classes42.dex */
public final class SimpleTypeWithEnhancement extends DelegatingSimpleType implements TypeWithEnhancement {
    private final SimpleType delegate;
    private final KotlinType enhancement;

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType
    public String toString() {
        return "[@EnhancedForWarnings(" + getEnhancement() + ")] " + getOrigin();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement
    public SimpleType getOrigin() {
        return getDelegate();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public SimpleType getDelegate() {
        return this.delegate;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement
    public KotlinType getEnhancement() {
        return this.enhancement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement
    public /* bridge */ /* synthetic */ UnwrappedType getOrigin() {
        return getOrigin();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType makeNullableAsSpecified(boolean r100) {
        UnwrappedType r101 = TypeWithEnhancementKt.wrapEnhancement(getOrigin().makeNullableAsSpecified(r100), getEnhancement().unwrap().makeNullableAsSpecified(r100));
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return (SimpleType) r101;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public SimpleTypeWithEnhancement refine(KotlinTypeRefiner r100) {
        Intrinsics.checkNotNullParameter(r100, "kotlinTypeRefiner");
        KotlinType r101 = r100.refineType(getDelegate());
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new SimpleTypeWithEnhancement((SimpleType) r101, r100.refineType(getEnhancement()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType replaceAttributes(TypeAttributes r100) {
        Intrinsics.checkNotNullParameter(r100, "newAttributes");
        UnwrappedType r101 = TypeWithEnhancementKt.wrapEnhancement(getOrigin().replaceAttributes(r100), getEnhancement());
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return (SimpleType) r101;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public SimpleTypeWithEnhancement replaceDelegate(SimpleType r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        return new SimpleTypeWithEnhancement(r100, getEnhancement());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType makeNullableAsSpecified(boolean r100) {
        return makeNullableAsSpecified(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ KotlinType refine(KotlinTypeRefiner r100) {
        return refine(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType replaceAttributes(TypeAttributes r100) {
        return replaceAttributes(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public /* bridge */ /* synthetic */ DelegatingSimpleType replaceDelegate(SimpleType r100) {
        return replaceDelegate(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ SimpleType refine(KotlinTypeRefiner r100) {
        return refine(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ UnwrappedType refine(KotlinTypeRefiner r100) {
        return refine(r100);
    }

    public SimpleTypeWithEnhancement(SimpleType r100, KotlinType r101) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        Intrinsics.checkNotNullParameter(r101, "enhancement");
        this.delegate = r100;
        this.enhancement = r101;
    }
}
