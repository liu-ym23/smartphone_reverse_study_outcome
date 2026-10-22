package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsKt;

/* JADX INFO: loaded from: classes42.dex */
public final class AnnotationsTypeAttribute extends TypeAttribute<AnnotationsTypeAttribute> {
    private final Annotations annotations;

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeAttribute
    public KClass<? extends AnnotationsTypeAttribute> getKey() {
        return Reflection.getOrCreateKotlinClass(AnnotationsTypeAttribute.class);
    }

    public int hashCode() {
        return this.annotations.hashCode();
    }

    public final Annotations getAnnotations() {
        return this.annotations;
    }

    public AnnotationsTypeAttribute(Annotations r100) {
        Intrinsics.checkNotNullParameter(r100, "annotations");
        this.annotations = r100;
    }

    public AnnotationsTypeAttribute add(AnnotationsTypeAttribute r100) {
        if (r100 != null) goto L5;
        return this;
    L5:
        return new AnnotationsTypeAttribute(AnnotationsKt.composeAnnotations(this.annotations, r100.annotations));
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof AnnotationsTypeAttribute) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(((AnnotationsTypeAttribute) r100).annotations, this.annotations);
    }

    public AnnotationsTypeAttribute intersect(AnnotationsTypeAttribute r100) {
        if (Intrinsics.areEqual(r100, this) == true) goto L7;
        return null;
    L7:
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeAttribute
    public /* bridge */ /* synthetic */ TypeAttribute add(TypeAttribute r100) {
        return add((AnnotationsTypeAttribute) r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeAttribute
    public /* bridge */ /* synthetic */ TypeAttribute intersect(TypeAttribute r100) {
        return intersect((AnnotationsTypeAttribute) r100);
    }
}
