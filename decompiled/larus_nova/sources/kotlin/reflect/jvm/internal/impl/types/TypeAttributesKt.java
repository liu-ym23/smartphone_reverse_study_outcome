package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: loaded from: classes42.dex */
public final class TypeAttributesKt {
    public static final TypeAttributes toDefaultAttributes(Annotations r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return TypeAttributeTranslator.DefaultImpls.toAttributes$default(DefaultTypeAttributeTranslator.INSTANCE, r100, null, null, 6, null);
    }

    public static final TypeAttributes replaceAnnotations(TypeAttributes r100, Annotations r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "newAnnotations");
        if (AnnotationsTypeAttributeKt.getAnnotations(r100) != r101) goto L5;
        return r100;
    L5:
        AnnotationsTypeAttribute r102 = AnnotationsTypeAttributeKt.getAnnotationsAttribute(r100);
        if (r102 == null) goto L12;
        TypeAttributes r103 = r100.remove(r102);
        if (r103 == null) goto L12;
        r100 = r103;
    L12:
        if (r101.iterator().hasNext() == true) goto L17;
        if (r101.isEmpty() == false) goto L17;
        return r100;
    L17:
        return r100.plus(new AnnotationsTypeAttribute(r101));
    }
}
