package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
final class SimpleTypeWithAttributes extends DelegatingSimpleTypeImpl {
    private final TypeAttributes attributes;

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public TypeAttributes getAttributes() {
        return this.attributes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public SimpleTypeWithAttributes replaceDelegate(SimpleType r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        return new SimpleTypeWithAttributes(r100, getAttributes());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public /* bridge */ /* synthetic */ DelegatingSimpleType replaceDelegate(SimpleType r100) {
        return replaceDelegate(r100);
    }

    public SimpleTypeWithAttributes(SimpleType r100, TypeAttributes r101) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        Intrinsics.checkNotNullParameter(r101, "attributes");
        super(r100);
        this.attributes = r101;
    }
}
