package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes5.dex */
public interface AnnotationAndConstantLoader<A, C> extends AnnotationLoader<A> {
    C loadAnnotationDefaultValue(ProtoContainer r100, ProtoBuf.Property r101, KotlinType r102);

    C loadPropertyConstant(ProtoContainer r100, ProtoBuf.Property r101, KotlinType r102);
}
