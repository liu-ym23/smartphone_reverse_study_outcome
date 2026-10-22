package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;

/* JADX INFO: loaded from: classes5.dex */
public final class ReflectAnnotationSource implements SourceElement {

    /* JADX INFO: renamed from: annotation, reason: collision with root package name */
    private final Annotation f504567annotation;

    public final Annotation getAnnotation() {
        return this.f504567annotation;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
    public SourceFile getContainingFile() {
        return SourceFile.NO_SOURCE_FILE;
    }

    public ReflectAnnotationSource(Annotation r100) {
        Intrinsics.checkNotNullParameter(r100, "annotation");
        this.f504567annotation = r100;
    }
}
