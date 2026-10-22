package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: loaded from: classes42.dex */
public final class AbbreviatedType extends DelegatingSimpleType {
    private final SimpleType abbreviation;
    private final SimpleType delegate;

    public final SimpleType getExpandedType() {
        return getDelegate();
    }

    public final SimpleType getAbbreviation() {
        return this.abbreviation;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public SimpleType getDelegate() {
        return this.delegate;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public AbbreviatedType makeNullableAsSpecified(boolean r100) {
        return new AbbreviatedType(getDelegate().makeNullableAsSpecified(r100), this.abbreviation.makeNullableAsSpecified(r100));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public AbbreviatedType refine(KotlinTypeRefiner r100) {
        Intrinsics.checkNotNullParameter(r100, "kotlinTypeRefiner");
        KotlinType r101 = r100.refineType(getDelegate());
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        KotlinType r102 = r100.refineType(this.abbreviation);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new AbbreviatedType((SimpleType) r101, (SimpleType) r102);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType replaceAttributes(TypeAttributes r100) {
        Intrinsics.checkNotNullParameter(r100, "newAttributes");
        return new AbbreviatedType(getDelegate().replaceAttributes(r100), this.abbreviation);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public AbbreviatedType replaceDelegate(SimpleType r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        return new AbbreviatedType(r100, this.abbreviation);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ SimpleType makeNullableAsSpecified(boolean r100) {
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

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType makeNullableAsSpecified(boolean r100) {
        return makeNullableAsSpecified(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ SimpleType refine(KotlinTypeRefiner r100) {
        return refine(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ UnwrappedType refine(KotlinTypeRefiner r100) {
        return refine(r100);
    }

    public AbbreviatedType(SimpleType r100, SimpleType r101) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        Intrinsics.checkNotNullParameter(r101, "abbreviation");
        this.delegate = r100;
        this.abbreviation = r101;
    }
}
