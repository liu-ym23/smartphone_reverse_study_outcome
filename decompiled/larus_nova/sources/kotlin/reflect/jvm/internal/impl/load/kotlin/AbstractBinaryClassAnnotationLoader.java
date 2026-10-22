package kotlin.reflect.jvm.internal.impl.load.kotlin;

import androidx.compose.material3.internal.TextFieldImplKt;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.SpecialJvmAnnotations;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader.AnnotationsContainer;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.ClassMapperLite;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.text.StringsKt;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractBinaryClassAnnotationLoader<A, S extends AnnotationsContainer<? extends A>> implements AnnotationLoader<A> {
    public static final Companion Companion = null;
    private final KotlinClassFinder kotlinClassFinder;

    /* JADX INFO: loaded from: classes42.dex */
    public static abstract class AnnotationsContainer<A> {
        public AnnotationsContainer() {
        }

        public abstract Map<MemberSignature, List<A>> getMemberAnnotations();
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final KotlinJvmBinaryClass getSpecialCaseContainerClass(ProtoContainer r100, boolean r101, boolean r102, Boolean r110, boolean r111, KotlinClassFinder r112, JvmMetadataVersion r113) {
            Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
            Intrinsics.checkNotNullParameter(r112, "kotlinClassFinder");
            Intrinsics.checkNotNullParameter(r113, "jvmMetadataVersion");
            if (r101 == false) goto L27;
            if (r110 == null) goto L26;
            if ((r100 instanceof ProtoContainer.Class) == false) goto L12;
            ProtoContainer.Class r103 = (ProtoContainer.Class) r100;
            if (r103.getKind() != ProtoBuf.Class.Kind.INTERFACE) goto L12;
            return KotlinClassFinderKt.findKotlinClass(r112, r103.getClassId().createNestedClassId(Name.identifier("DefaultImpls")), r113);
        L12:
            if (r110.booleanValue() == false) goto L27;
            if ((r100 instanceof ProtoContainer.Package) == false) goto L27;
            SourceElement r104 = r100.getSource();
            if ((r104 instanceof JvmPackagePartSource) == false) goto L18;
            JvmPackagePartSource r105 = (JvmPackagePartSource) r104;
        L19:
            if (r105 == null) goto L21;
            JvmClassName r106 = r105.getFacadeClassName();
        L22:
            if (r106 == null) goto L27;
            return KotlinClassFinderKt.findKotlinClass(r112, ClassId.Companion.topLevel(new FqName(StringsKt.replace$default(r106.getInternalName(), '/', '.', false, 4, null))), r113);
        L21:
            r106 = null;
            goto L22
        L18:
            r105 = null;
            goto L19
        L26:
            throw new IllegalStateException(("isConst should not be null for property (container=" + r100 + ')').toString());
        L27:
            if (r102 == false) goto L51;
            if ((r100 instanceof ProtoContainer.Class) == false) goto L51;
            ProtoContainer.Class r107 = (ProtoContainer.Class) r100;
            if (r107.getKind() != ProtoBuf.Class.Kind.COMPANION_OBJECT) goto L51;
            ProtoContainer.Class r108 = r107.getOuterClass();
            if (r108 == null) goto L51;
            if (r108.getKind() != ProtoBuf.Class.Kind.CLASS) goto L37;
        L43:
            SourceElement r109 = r108.getSource();
            if ((r109 instanceof KotlinJvmBinarySourceElement) == false) goto L46;
            KotlinJvmBinarySourceElement r114 = (KotlinJvmBinarySourceElement) r109;
        L47:
            if (r114 != null) goto L49;
            return null;
        L49:
            return r114.getBinaryClass();
        L46:
            r114 = null;
            goto L47
        L37:
            if (r108.getKind() == ProtoBuf.Class.Kind.ENUM_CLASS) goto L43;
            if (r111 == false) goto L51;
            if (r108.getKind() == ProtoBuf.Class.Kind.INTERFACE) goto L43;
            if (r108.getKind() == ProtoBuf.Class.Kind.ANNOTATION_CLASS) goto L43;
        L51:
            if ((r100 instanceof ProtoContainer.Package) == true) goto L53;
        L58:
            return null;
        L53:
            if ((r100.getSource() instanceof JvmPackagePartSource) == false) goto L58;
            SourceElement r115 = r100.getSource();
            Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
            JvmPackagePartSource r116 = (JvmPackagePartSource) r115;
            KotlinJvmBinaryClass r117 = r116.getKnownJvmBinaryClass();
            if (r117 == null) goto L57;
            return r117;
        L57:
            return KotlinClassFinderKt.findKotlinClass(r112, r116.getClassId(), r113);
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public static final enum PropertyRelatedElement extends Enum<PropertyRelatedElement> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ PropertyRelatedElement[] $VALUES = null;
        public static final PropertyRelatedElement BACKING_FIELD = null;
        public static final PropertyRelatedElement DELEGATE_FIELD = null;
        public static final PropertyRelatedElement PROPERTY = null;

        private static final /* synthetic */ PropertyRelatedElement[] $values() {
            return new PropertyRelatedElement[]{PROPERTY, BACKING_FIELD, DELEGATE_FIELD};
        }

        static {
            PROPERTY = new PropertyRelatedElement("PROPERTY", 0);
            BACKING_FIELD = new PropertyRelatedElement("BACKING_FIELD", 1);
            DELEGATE_FIELD = new PropertyRelatedElement("DELEGATE_FIELD", 2);
            PropertyRelatedElement[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static PropertyRelatedElement[] values() {
            return (PropertyRelatedElement[]) $VALUES.clone();
        }

        public static PropertyRelatedElement valueOf(String r100) {
            return (PropertyRelatedElement) a.a(PropertyRelatedElement.class, r100);
        }

        private PropertyRelatedElement(String r100, int r101) {
            super(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[AnnotatedCallableKind.values().length];
            r100[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[AnnotatedCallableKind.PROPERTY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r100;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public abstract S getAnnotationsContainer(KotlinJvmBinaryClass r100);

    public byte[] getCachedFileContent(KotlinJvmBinaryClass r100) {
        Intrinsics.checkNotNullParameter(r100, "kotlinClass");
        return null;
    }

    public abstract JvmMetadataVersion getJvmMetadataVersion();

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public abstract A loadAnnotation(ProtoBuf.Annotation r100, NameResolver r101);

    public abstract KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotation(ClassId r100, SourceElement r101, List<A> r102);

    public final KotlinClassFinder getKotlinClassFinder() {
        return this.kotlinClassFinder;
    }

    public AbstractBinaryClassAnnotationLoader(KotlinClassFinder r100) {
        Intrinsics.checkNotNullParameter(r100, "kotlinClassFinder");
        this.kotlinClassFinder = r100;
    }

    private final KotlinJvmBinaryClass toBinaryClass(ProtoContainer.Class r100) {
        SourceElement r101 = r100.getSource();
        if ((r101 instanceof KotlinJvmBinarySourceElement) == false) goto L5;
        KotlinJvmBinarySourceElement r102 = (KotlinJvmBinarySourceElement) r101;
    L6:
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.getBinaryClass();
    L5:
        r102 = null;
        goto L6
    }

    public final boolean isImplicitRepeatableContainer(ClassId r100) {
        Intrinsics.checkNotNullParameter(r100, "classId");
        if (r100.getOuterClassId() != null) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r100.getShortClassName().asString(), TextFieldImplKt.ContainerId) == false) goto L16;
        KotlinJvmBinaryClass r101 = KotlinClassFinderKt.findKotlinClass(this.kotlinClassFinder, r100, getJvmMetadataVersion());
        if (r101 != null) goto L10;
        return false;
    L10:
        if (SpecialJvmAnnotations.INSTANCE.isAnnotatedWithContainerMetaAnnotation(r101) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadClassAnnotations(ProtoContainer.Class r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        KotlinJvmBinaryClass r101 = toBinaryClass(r100);
        if (r101 == null) goto L7;
        final ArrayList r102 = new ArrayList(1);
        r101.loadClassAnnotations(new AnonymousClass1(this, r102), getCachedFileContent(r101));
        return r102;
    L7:
        throw new IllegalStateException(("Class for loading annotations is not found: " + r100.debugFqName()).toString());
    }

    private final int computeJvmParameterIndexShift(ProtoContainer r100, MessageLite r101) {
        if ((r101 instanceof ProtoBuf.Function) == false) goto L9;
        if (ProtoTypeTableUtilKt.hasReceiver((ProtoBuf.Function) r101) == true) goto L25;
    L7:
        return 0;
    L25:
        return 1;
    L9:
        if ((r101 instanceof ProtoBuf.Property) == false) goto L14;
        if (ProtoTypeTableUtilKt.hasReceiver((ProtoBuf.Property) r101) == false) goto L7;
        return 1;
    L14:
        if ((r101 instanceof ProtoBuf.Constructor) == false) goto L22;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.ProtoContainer.Class");
        ProtoContainer.Class r102 = (ProtoContainer.Class) r100;
        if (r102.getKind() != ProtoBuf.Class.Kind.ENUM_CLASS) goto L19;
        return 2;
    L19:
        if (r102.isInner() == false) goto L7;
        return 1;
    L22:
        throw new UnsupportedOperationException("Unsupported message: " + r101.getClass());
    }

    public final KotlinJvmBinaryClass findClassWithAnnotationsAndInitializers(ProtoContainer r100, KotlinJvmBinaryClass r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        if (r101 == null) goto L5;
        return r101;
    L5:
        if ((r100 instanceof ProtoContainer.Class) == true) goto L10;
        return null;
    L10:
        return toBinaryClass((ProtoContainer.Class) r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadEnumEntryAnnotations(ProtoContainer r110, ProtoBuf.EnumEntry r111) {
        Intrinsics.checkNotNullParameter(r110, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r111, "proto");
        return findClassAndLoadMemberAnnotations$default(this, r110, MemberSignature.Companion.fromFieldNameAndDesc(r110.getNameResolver().getString(r111.getName()), ClassMapperLite.mapClass(((ProtoContainer.Class) r110).getClassId().asString())), false, false, null, false, 60, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadPropertyBackingFieldAnnotations(ProtoContainer r100, ProtoBuf.Property r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "proto");
        return loadPropertyAnnotations(r100, r101, PropertyRelatedElement.BACKING_FIELD);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadPropertyDelegateFieldAnnotations(ProtoContainer r100, ProtoBuf.Property r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "proto");
        return loadPropertyAnnotations(r100, r101, PropertyRelatedElement.DELEGATE_FIELD);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadTypeAnnotations(ProtoBuf.Type r100, NameResolver r101) {
        Intrinsics.checkNotNullParameter(r100, "proto");
        Intrinsics.checkNotNullParameter(r101, "nameResolver");
        Iterable r102 = (Iterable) r100.getExtension(JvmProtoBuf.typeAnnotation);
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ProtoBuf.Annotation r105 = (ProtoBuf.Annotation) r104.next();
        Intrinsics.checkNotNull(r105);
        r103.add(loadAnnotation(r105, r101));
        goto L4
    L6:
        return r103;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadTypeParameterAnnotations(ProtoBuf.TypeParameter r100, NameResolver r101) {
        Intrinsics.checkNotNullParameter(r100, "proto");
        Intrinsics.checkNotNullParameter(r101, "nameResolver");
        Iterable r102 = (Iterable) r100.getExtension(JvmProtoBuf.typeParameterAnnotation);
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ProtoBuf.Annotation r105 = (ProtoBuf.Annotation) r104.next();
        Intrinsics.checkNotNull(r105);
        r103.add(loadAnnotation(r105, r101));
        goto L4
    L6:
        return r103;
    }

    private final List<A> loadPropertyAnnotations(ProtoContainer r110, ProtoBuf.Property r111, PropertyRelatedElement r210) {
        boolean r100 = Flags.IS_CONST.get(r111.getFlags()).booleanValue();
        boolean r101 = JvmProtoBufUtil.isMovedFromInterfaceCompanion(r111);
        if (r210 != PropertyRelatedElement.PROPERTY) goto L10;
        MemberSignature r102 = AbstractBinaryClassAnnotationLoaderKt.getPropertySignature$default(r111, r110.getNameResolver(), r110.getTypeTable(), false, true, false, 40, null);
        if (r102 != null) goto L9;
        return CollectionsKt.emptyList();
    L9:
        return findClassAndLoadMemberAnnotations$default(this, r110, r102, true, false, Boolean.valueOf(r100), r101, 8, null);
    L10:
        MemberSignature r103 = AbstractBinaryClassAnnotationLoaderKt.getPropertySignature$default(r111, r110.getNameResolver(), r110.getTypeTable(), true, false, false, 48, null);
        if (r103 == null) goto L13;
        boolean r104 = false;
        boolean r105 = StringsKt.contains$default(r103.getSignature(), "$delegate", false, 2, null);
        if (r210 != PropertyRelatedElement.DELEGATE_FIELD) goto L17;
        r104 = true;
    L17:
        if (r105 == r104) goto L21;
        return CollectionsKt.emptyList();
    L21:
        return findClassAndLoadMemberAnnotations(r110, r103, true, true, Boolean.valueOf(r100), r101);
    L13:
        return CollectionsKt.emptyList();
    }

    public final KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotationIfNotSpecial(ClassId r100, SourceElement r101, List<A> r102) {
        Intrinsics.checkNotNullParameter(r100, "annotationClassId");
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r102, "result");
        if (SpecialJvmAnnotations.INSTANCE.getSPECIAL_ANNOTATIONS().contains(r100) == false) goto L7;
        return null;
    L7:
        return loadAnnotation(r100, r101, r102);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadCallableAnnotations(ProtoContainer r110, MessageLite r111, AnnotatedCallableKind r112) {
        Intrinsics.checkNotNullParameter(r110, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r111, "proto");
        Intrinsics.checkNotNullParameter(r112, "kind");
        if (r112 == AnnotatedCallableKind.PROPERTY) goto L5;
        MemberSignature r100 = getCallableSignature$default(this, r111, r110.getNameResolver(), r110.getTypeTable(), r112, false, 16, null);
        if (r100 != null) goto L11;
        return CollectionsKt.emptyList();
    L11:
        return findClassAndLoadMemberAnnotations$default(this, r110, r100, false, false, null, false, 60, null);
    L5:
        return loadPropertyAnnotations(r110, (ProtoBuf.Property) r111, PropertyRelatedElement.PROPERTY);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadExtensionReceiverParameterAnnotations(ProtoContainer r110, MessageLite r111, AnnotatedCallableKind r112) {
        Intrinsics.checkNotNullParameter(r110, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r111, "proto");
        Intrinsics.checkNotNullParameter(r112, "kind");
        MemberSignature r113 = getCallableSignature$default(this, r111, r110.getNameResolver(), r110.getTypeTable(), r112, false, 16, null);
        if (r113 == null) goto L7;
        return findClassAndLoadMemberAnnotations$default(this, r110, MemberSignature.Companion.fromMethodSignatureAndParameterIndex(r113, 0), false, false, null, false, 60, null);
    L7:
        return CollectionsKt.emptyList();
    }

    public final MemberSignature getCallableSignature(MessageLite r100, NameResolver r110, TypeTable r111, AnnotatedCallableKind r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r100, "proto");
        Intrinsics.checkNotNullParameter(r110, "nameResolver");
        Intrinsics.checkNotNullParameter(r111, "typeTable");
        Intrinsics.checkNotNullParameter(r112, "kind");
        if ((r100 instanceof ProtoBuf.Constructor) == false) goto L9;
        MemberSignature.Companion r114 = MemberSignature.Companion;
        JvmMemberSignature.Method r101 = JvmProtoBufUtil.INSTANCE.getJvmConstructorSignature((ProtoBuf.Constructor) r100, r110, r111);
        if (r101 != null) goto L34;
        return null;
    L34:
        return r114.fromJvmMemberSignature(r101);
    L9:
        if ((r100 instanceof ProtoBuf.Function) == false) goto L15;
        MemberSignature.Companion r115 = MemberSignature.Companion;
        JvmMemberSignature.Method r102 = JvmProtoBufUtil.INSTANCE.getJvmMethodSignature((ProtoBuf.Function) r100, r110, r111);
        if (r102 != null) goto L35;
        return null;
    L35:
        return r115.fromJvmMemberSignature(r102);
    L15:
        if ((r100 instanceof ProtoBuf.Property) == false) goto L36;
        JvmProtoBuf.JvmPropertySignature r103 = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull((GeneratedMessageLite.ExtendableMessage) r100, JvmProtoBuf.propertySignature);
        if (r103 != null) goto L19;
        return null;
    L19:
        int r116 = WhenMappings.$EnumSwitchMapping$0[r112.ordinal()];
        if (r116 == 1) goto L31;
        if (r116 == 2) goto L28;
        if (r116 == 3) goto L37;
        return null;
    L37:
        return AbstractBinaryClassAnnotationLoaderKt.getPropertySignature((ProtoBuf.Property) r100, r110, r111, true, true, r113);
    L28:
        if (r103.hasSetter() == true) goto L39;
        return null;
    L39:
        return MemberSignature.Companion.fromMethod(r110, r103.getSetter());
    L31:
        if (r103.hasGetter() == true) goto L33;
        return null;
    L33:
        return MemberSignature.Companion.fromMethod(r110, r103.getGetter());
    L36:
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadValueParameterAnnotations(ProtoContainer r110, MessageLite r111, AnnotatedCallableKind r112, int r113, ProtoBuf.ValueParameter r114) {
        Intrinsics.checkNotNullParameter(r110, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r111, "callableProto");
        Intrinsics.checkNotNullParameter(r112, "kind");
        Intrinsics.checkNotNullParameter(r114, "proto");
        MemberSignature r115 = getCallableSignature$default(this, r111, r110.getNameResolver(), r110.getTypeTable(), r112, false, 16, null);
        if (r115 == null) goto L7;
        int r116 = r113 + computeJvmParameterIndexShift(r110, r111);
        return findClassAndLoadMemberAnnotations$default(this, r110, MemberSignature.Companion.fromMethodSignatureAndParameterIndex(r115, r116), false, false, null, false, 60, null);
    L7:
        return CollectionsKt.emptyList();
    }

    private final List<A> findClassAndLoadMemberAnnotations(ProtoContainer r100, MemberSignature r110, boolean r111, boolean r112, Boolean r113, boolean r114) {
        KotlinJvmBinaryClass r101 = findClassWithAnnotationsAndInitializers(r100, Companion.getSpecialCaseContainerClass(r100, r111, r112, r113, r114, this.kotlinClassFinder, getJvmMetadataVersion()));
        if (r101 == null) goto L5;
        List<A> r102 = getAnnotationsContainer(r101).getMemberAnnotations().get(r110);
        if (r102 == null) goto L9;
        return r102;
    L9:
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.emptyList();
    }

    public static /* synthetic */ MemberSignature getCallableSignature$default(AbstractBinaryClassAnnotationLoader r100, MessageLite r101, NameResolver r102, TypeTable r103, AnnotatedCallableKind r110, boolean r111, int r112, Object r113) {
        if (r113 != null) goto L10;
        if ((r112 & 16) == 0) goto L6;
        boolean r104 = false;
    L8:
        return r100.getCallableSignature(r101, r102, r103, r110, r104);
    L6:
        r104 = r111;
        goto L8
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCallableSignature");
    }

    public static /* synthetic */ List findClassAndLoadMemberAnnotations$default(AbstractBinaryClassAnnotationLoader r100, ProtoContainer r110, MemberSignature r111, boolean r112, boolean r113, Boolean r114, boolean r115, int r116, Object r117) {
        if (r117 != null) goto L22;
        if ((r116 & 4) == 0) goto L6;
        boolean r101 = false;
    L8:
        if ((r116 & 8) == 0) goto L10;
        boolean r102 = false;
    L12:
        if ((r116 & 16) == 0) goto L14;
        Boolean r103 = null;
    L16:
        if ((r116 & 32) == 0) goto L18;
        boolean r104 = false;
    L20:
        return r100.findClassAndLoadMemberAnnotations(r110, r111, r101, r102, r103, r104);
    L18:
        r104 = r115;
        goto L20
    L14:
        r103 = r114;
        goto L16
    L10:
        r102 = r113;
        goto L12
    L6:
        r101 = r112;
        goto L8
    L22:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findClassAndLoadMemberAnnotations");
    }
}
