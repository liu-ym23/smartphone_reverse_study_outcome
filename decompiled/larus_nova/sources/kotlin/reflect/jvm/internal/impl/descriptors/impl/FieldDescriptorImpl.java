package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: loaded from: classes5.dex */
public final class FieldDescriptorImpl extends AnnotatedImpl implements FieldDescriptor {
    private final PropertyDescriptor correspondingProperty;

    public FieldDescriptorImpl(Annotations r100, PropertyDescriptor r101) {
        Intrinsics.checkNotNullParameter(r100, "annotations");
        Intrinsics.checkNotNullParameter(r101, "correspondingProperty");
        super(r100);
        this.correspondingProperty = r101;
    }
}
