package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractAnnotationLoader<A> implements AnnotationLoader<A> {
    private final SerializerExtensionProtocol protocol;

    /* JADX INFO: loaded from: classes42.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[AnnotatedCallableKind.values().length];
            r100[AnnotatedCallableKind.PROPERTY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r100;
        }
    }

    public final SerializerExtensionProtocol getProtocol() {
        return this.protocol;
    }

    public AbstractAnnotationLoader(SerializerExtensionProtocol r100) {
        Intrinsics.checkNotNullParameter(r100, "protocol");
        this.protocol = r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadClassAnnotations(ProtoContainer.Class r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        List r101 = (List) r100.getClassProto().getExtension(this.protocol.getClassAnnotation());
        if (r101 != null) goto L5;
        r101 = CollectionsKt.emptyList();
    L5:
        List r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r104 = r102.iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        r103.add(loadAnnotation((ProtoBuf.Annotation) r104.next(), r100.getNameResolver()));
        goto L7
    L9:
        return r103;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadEnumEntryAnnotations(ProtoContainer r100, ProtoBuf.EnumEntry r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "proto");
        List r102 = (List) r101.getExtension(this.protocol.getEnumEntryAnnotation());
        if (r102 != null) goto L5;
        r102 = CollectionsKt.emptyList();
    L5:
        List r103 = r102;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
    L7:
        if (r105.hasNext() == false) goto L9;
        r104.add(loadAnnotation((ProtoBuf.Annotation) r105.next(), r100.getNameResolver()));
        goto L7
    L9:
        return r104;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadPropertyBackingFieldAnnotations(ProtoContainer r100, ProtoBuf.Property r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "proto");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> r102 = this.protocol.getPropertyBackingFieldAnnotation();
        if (r102 == null) goto L5;
        List r103 = (List) r101.getExtension(r102);
    L6:
        if (r103 != null) goto L8;
        r103 = CollectionsKt.emptyList();
    L8:
        List r104 = r103;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator r106 = r104.iterator();
    L10:
        if (r106.hasNext() == false) goto L12;
        r105.add(loadAnnotation((ProtoBuf.Annotation) r106.next(), r100.getNameResolver()));
        goto L10
    L12:
        return r105;
    L5:
        r103 = null;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadPropertyDelegateFieldAnnotations(ProtoContainer r100, ProtoBuf.Property r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "proto");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> r102 = this.protocol.getPropertyDelegatedFieldAnnotation();
        if (r102 == null) goto L5;
        List r103 = (List) r101.getExtension(r102);
    L6:
        if (r103 != null) goto L8;
        r103 = CollectionsKt.emptyList();
    L8:
        List r104 = r103;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator r106 = r104.iterator();
    L10:
        if (r106.hasNext() == false) goto L12;
        r105.add(loadAnnotation((ProtoBuf.Annotation) r106.next(), r100.getNameResolver()));
        goto L10
    L12:
        return r105;
    L5:
        r103 = null;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadTypeAnnotations(ProtoBuf.Type r100, NameResolver r101) {
        Intrinsics.checkNotNullParameter(r100, "proto");
        Intrinsics.checkNotNullParameter(r101, "nameResolver");
        List r102 = (List) r100.getExtension(this.protocol.getTypeAnnotation());
        if (r102 != null) goto L5;
        r102 = CollectionsKt.emptyList();
    L5:
        List r103 = r102;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
    L7:
        if (r105.hasNext() == false) goto L9;
        r104.add(loadAnnotation((ProtoBuf.Annotation) r105.next(), r101));
        goto L7
    L9:
        return r104;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadTypeParameterAnnotations(ProtoBuf.TypeParameter r100, NameResolver r101) {
        Intrinsics.checkNotNullParameter(r100, "proto");
        Intrinsics.checkNotNullParameter(r101, "nameResolver");
        List r102 = (List) r100.getExtension(this.protocol.getTypeParameterAnnotation());
        if (r102 != null) goto L5;
        r102 = CollectionsKt.emptyList();
    L5:
        List r103 = r102;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
    L7:
        if (r105.hasNext() == false) goto L9;
        r104.add(loadAnnotation((ProtoBuf.Annotation) r105.next(), r101));
        goto L7
    L9:
        return r104;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadCallableAnnotations(ProtoContainer r100, MessageLite r101, AnnotatedCallableKind r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "proto");
        Intrinsics.checkNotNullParameter(r102, "kind");
        if ((r101 instanceof ProtoBuf.Constructor) == false) goto L6;
        List r103 = (List) ((ProtoBuf.Constructor) r101).getExtension(this.protocol.getConstructorAnnotation());
    L21:
        if (r103 != null) goto L23;
        r103 = CollectionsKt.emptyList();
    L23:
        List r104 = r103;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator r106 = r104.iterator();
    L25:
        if (r106.hasNext() == false) goto L27;
        r105.add(loadAnnotation((ProtoBuf.Annotation) r106.next(), r100.getNameResolver()));
        goto L25
    L27:
        return r105;
    L6:
        if ((r101 instanceof ProtoBuf.Function) == false) goto L9;
        r103 = (List) ((ProtoBuf.Function) r101).getExtension(this.protocol.getFunctionAnnotation());
        goto L21
    L9:
        if ((r101 instanceof ProtoBuf.Property) == false) goto L29;
        int r107 = WhenMappings.$EnumSwitchMapping$0[r102.ordinal()];
        if (r107 != 1) goto L13;
        r103 = (List) ((ProtoBuf.Property) r101).getExtension(this.protocol.getPropertyAnnotation());
        goto L21
    L13:
        if (r107 != 2) goto L15;
        r103 = (List) ((ProtoBuf.Property) r101).getExtension(this.protocol.getPropertyGetterAnnotation());
        goto L21
    L15:
        if (r107 != 3) goto L18;
        r103 = (List) ((ProtoBuf.Property) r101).getExtension(this.protocol.getPropertySetterAnnotation());
        goto L21
    L18:
        throw new IllegalStateException("Unsupported callable kind with property proto".toString());
    L29:
        throw new IllegalStateException(("Unknown message: " + r101).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadExtensionReceiverParameterAnnotations(ProtoContainer r100, MessageLite r101, AnnotatedCallableKind r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "proto");
        Intrinsics.checkNotNullParameter(r102, "kind");
        List r103 = null;
        if ((r101 instanceof ProtoBuf.Function) == false) goto L8;
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, List<ProtoBuf.Annotation>> r104 = this.protocol.getFunctionExtensionReceiverAnnotation();
        if (r104 == null) goto L21;
        r103 = (List) ((ProtoBuf.Function) r101).getExtension(r104);
    L21:
        if (r103 != null) goto L23;
        r103 = CollectionsKt.emptyList();
    L23:
        List r105 = r103;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r107 = r105.iterator();
    L25:
        if (r107.hasNext() == false) goto L27;
        r106.add(loadAnnotation((ProtoBuf.Annotation) r107.next(), r100.getNameResolver()));
        goto L25
    L27:
        return r106;
    L8:
        if ((r101 instanceof ProtoBuf.Property) == false) goto L29;
        int r108 = WhenMappings.$EnumSwitchMapping$0[r102.ordinal()];
        if (r108 != 1) goto L12;
    L18:
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> r109 = this.protocol.getPropertyExtensionReceiverAnnotation();
        if (r109 == null) goto L21;
        r103 = (List) ((ProtoBuf.Property) r101).getExtension(r109);
        goto L21
    L12:
        if (r108 == 2) goto L18;
        if (r108 == 3) goto L18;
        throw new IllegalStateException(("Unsupported callable kind with property proto for receiver annotations: " + r102).toString());
    L29:
        throw new IllegalStateException(("Unknown message: " + r101).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadValueParameterAnnotations(ProtoContainer r100, MessageLite r101, AnnotatedCallableKind r102, int r103, ProtoBuf.ValueParameter r104) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "callableProto");
        Intrinsics.checkNotNullParameter(r102, "kind");
        Intrinsics.checkNotNullParameter(r104, "proto");
        List r105 = (List) r104.getExtension(this.protocol.getParameterAnnotation());
        if (r105 != null) goto L5;
        r105 = CollectionsKt.emptyList();
    L5:
        List r106 = r105;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator r108 = r106.iterator();
    L7:
        if (r108.hasNext() == false) goto L9;
        r107.add(loadAnnotation((ProtoBuf.Annotation) r108.next(), r100.getNameResolver()));
        goto L7
    L9:
        return r107;
    }
}
