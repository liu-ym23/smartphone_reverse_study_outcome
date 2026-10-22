package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: classes42.dex */
public final class NonEmptyDeserializedAnnotations extends DeserializedAnnotations {
    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        return false;
    }

    public NonEmptyDeserializedAnnotations(StorageManager r100, Function0<? extends List<? extends AnnotationDescriptor>> r101) {
        Intrinsics.checkNotNullParameter(r100, "storageManager");
        Intrinsics.checkNotNullParameter(r101, "compute");
        super(r100, r101);
    }
}
