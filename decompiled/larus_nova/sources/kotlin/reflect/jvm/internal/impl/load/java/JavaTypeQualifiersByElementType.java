package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.EnumMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class JavaTypeQualifiersByElementType {
    private final EnumMap<AnnotationQualifierApplicabilityType, JavaDefaultQualifiers> defaultQualifiers;

    public final EnumMap<AnnotationQualifierApplicabilityType, JavaDefaultQualifiers> getDefaultQualifiers() {
        return this.defaultQualifiers;
    }

    public JavaTypeQualifiersByElementType(EnumMap<AnnotationQualifierApplicabilityType, JavaDefaultQualifiers> r100) {
        Intrinsics.checkNotNullParameter(r100, "defaultQualifiers");
        this.defaultQualifiers = r100;
    }

    public final JavaDefaultQualifiers get(AnnotationQualifierApplicabilityType r100) {
        return this.defaultQualifiers.get(r100);
    }
}
