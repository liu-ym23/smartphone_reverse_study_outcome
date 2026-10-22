package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class AnnotationsContainerWithConstants<A, C> extends AbstractBinaryClassAnnotationLoader.AnnotationsContainer<A> {
    private final Map<MemberSignature, C> annotationParametersDefaultValues;
    private final Map<MemberSignature, List<A>> memberAnnotations;
    private final Map<MemberSignature, C> propertyConstants;

    public final Map<MemberSignature, C> getAnnotationParametersDefaultValues() {
        return this.annotationParametersDefaultValues;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader.AnnotationsContainer
    public Map<MemberSignature, List<A>> getMemberAnnotations() {
        return this.memberAnnotations;
    }

    public final Map<MemberSignature, C> getPropertyConstants() {
        return this.propertyConstants;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnnotationsContainerWithConstants(Map<MemberSignature, ? extends List<? extends A>> r100, Map<MemberSignature, ? extends C> r101, Map<MemberSignature, ? extends C> r102) {
        Intrinsics.checkNotNullParameter(r100, "memberAnnotations");
        Intrinsics.checkNotNullParameter(r101, "propertyConstants");
        Intrinsics.checkNotNullParameter(r102, "annotationParametersDefaultValues");
        this.memberAnnotations = r100;
        this.propertyConstants = r101;
        this.annotationParametersDefaultValues = r102;
    }
}
