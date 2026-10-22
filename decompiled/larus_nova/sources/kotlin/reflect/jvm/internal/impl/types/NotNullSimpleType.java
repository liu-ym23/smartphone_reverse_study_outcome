package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
final class NotNullSimpleType extends DelegatingSimpleTypeImpl {
    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return false;
    }

    public NotNullSimpleType(SimpleType r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        super(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public NotNullSimpleType replaceDelegate(SimpleType r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        return new NotNullSimpleType(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public /* bridge */ /* synthetic */ DelegatingSimpleType replaceDelegate(SimpleType r100) {
        return replaceDelegate(r100);
    }
}
