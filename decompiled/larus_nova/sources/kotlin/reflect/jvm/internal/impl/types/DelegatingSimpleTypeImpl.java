package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public abstract class DelegatingSimpleTypeImpl extends DelegatingSimpleType {
    private final SimpleType delegate;

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public SimpleType getDelegate() {
        return this.delegate;
    }

    public DelegatingSimpleTypeImpl(SimpleType r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.delegate = r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType makeNullableAsSpecified(boolean r100) {
        if (r100 != isMarkedNullable()) goto L6;
        return this;
    L6:
        return getDelegate().makeNullableAsSpecified(r100).replaceAttributes(getAttributes());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType replaceAttributes(TypeAttributes r100) {
        Intrinsics.checkNotNullParameter(r100, "newAttributes");
        if (r100 == getAttributes()) goto L6;
        return new SimpleTypeWithAttributes(this, r100);
    L6:
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType makeNullableAsSpecified(boolean r100) {
        return makeNullableAsSpecified(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType replaceAttributes(TypeAttributes r100) {
        return replaceAttributes(r100);
    }
}
