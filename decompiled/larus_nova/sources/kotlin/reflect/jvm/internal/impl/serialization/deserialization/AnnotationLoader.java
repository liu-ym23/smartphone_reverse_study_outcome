package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: loaded from: classes5.dex */
public interface AnnotationLoader<A> {
    A loadAnnotation(ProtoBuf.Annotation r100, NameResolver r101);

    List<A> loadCallableAnnotations(ProtoContainer r100, MessageLite r101, AnnotatedCallableKind r102);

    List<A> loadClassAnnotations(ProtoContainer.Class r100);

    List<A> loadEnumEntryAnnotations(ProtoContainer r100, ProtoBuf.EnumEntry r101);

    List<A> loadExtensionReceiverParameterAnnotations(ProtoContainer r100, MessageLite r101, AnnotatedCallableKind r102);

    List<A> loadPropertyBackingFieldAnnotations(ProtoContainer r100, ProtoBuf.Property r101);

    List<A> loadPropertyDelegateFieldAnnotations(ProtoContainer r100, ProtoBuf.Property r101);

    List<A> loadTypeAnnotations(ProtoBuf.Type r100, NameResolver r101);

    List<A> loadTypeParameterAnnotations(ProtoBuf.TypeParameter r100, NameResolver r101);

    List<A> loadValueParameterAnnotations(ProtoContainer r100, MessageLite r101, AnnotatedCallableKind r102, int r103, ProtoBuf.ValueParameter r104);
}
