package kotlin.reflect.jvm.internal;

import android.util.EventsUtils;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u00052\u00020\u0006:\u0001eB\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020.0&2\u0006\u0010/\u001a\u000200H\u0016J\u0016\u00101\u001a\b\u0012\u0004\u0012\u0002020&2\u0006\u0010/\u001a\u000200H\u0016J\u0012\u00103\u001a\u0004\u0018\u00010.2\u0006\u00104\u001a\u000205H\u0016J\u0012\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010\u0002H\u0016J\u0013\u0010]\u001a\u00020E2\b\u0010^\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010_\u001a\u000205H\u0016J\b\u0010`\u001a\u000207H\u0016J\u0018\u0010a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010b\u001a\u00020cH\u0002J\u0018\u0010d\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010b\u001a\u00020cH\u0002R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR!\u0010\r\u001a\u0012\u0012\u000e\u0012\f0\u000fR\b\u0012\u0004\u0012\u00028\u00000\u00000\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020 8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u001e\u0010%\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030'0&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020+0&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010)R\u0016\u00106\u001a\u0004\u0018\u0001078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u0016\u0010:\u001a\u0004\u0018\u0001078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u00109R \u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000=0&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010)R\u001e\u0010?\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010)R\u0016\u0010A\u001a\u0004\u0018\u00018\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020H0\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bI\u0010\u001aR\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bL\u0010\u001aR\"\u0010M\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00040\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u0010\u001aR\u0016\u0010O\u001a\u0004\u0018\u00010P8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0014\u0010S\u001a\u00020E8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0014\u0010U\u001a\u00020E8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bU\u0010TR\u0014\u0010V\u001a\u00020E8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bV\u0010TR\u0014\u0010W\u001a\u00020E8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bW\u0010TR\u0014\u0010X\u001a\u00020E8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bX\u0010TR\u0014\u0010Y\u001a\u00020E8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bY\u0010TR\u0014\u0010Z\u001a\u00020E8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010TR\u0014\u0010[\u001a\u00020E8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b[\u0010TR\u0014\u0010\\\u001a\u00020E8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010T¨\u0006f"}, d2 = {"Lkotlin/reflect/jvm/internal/KClassImpl;", "T", XmlPullParser.NO_NAMESPACE, "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "jClass", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "getJClass", "()Ljava/lang/Class;", "data", "Lkotlin/Lazy;", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "getData", "()Lkotlin/Lazy;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "annotations", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "getAnnotations", "()Ljava/util/List;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "memberScope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getMemberScope$kotlin_reflection", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "staticScope", "getStaticScope$kotlin_reflection", "members", XmlPullParser.NO_NAMESPACE, "Lkotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "constructorDescriptors", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "getProperties", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "getLocalProperty", "index", XmlPullParser.NO_NAMESPACE, "simpleName", XmlPullParser.NO_NAMESPACE, "getSimpleName", "()Ljava/lang/String;", "qualifiedName", "getQualifiedName", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "isInstance", XmlPullParser.NO_NAMESPACE, "value", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "sealedSubclasses", "getSealedSubclasses", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "isFinal", "()Z", "isOpen", "isAbstract", "isSealed", "isData", "isInner", "isCompanion", "isFun", "isValue", "equals", "other", "hashCode", "toString", "createSyntheticClassOrFail", "moduleData", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "createSyntheticClass", "Data", "kotlin-reflection"}, k = 1, mv = {2, 0, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class KClassImpl<T> extends KDeclarationContainerImpl implements KClass<T>, KClassifierImpl, KTypeParameterOwnerImpl {
    private final Lazy<KClassImpl<T>.Data> data;
    private final Class<T> jClass;

    public static /* synthetic */ Data accessor$KClassImpl$lambda0(KClassImpl r0) {
        return data$lambda$0(r0);
    }

    private final ClassId getClassId() {
        return RuntimeTypeMapper.INSTANCE.mapJvmClassToKotlinClassId(getJClass());
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        return this.data.getValue().getAnnotations();
    }

    @Override // kotlin.reflect.KClass
    public Collection<KFunction<T>> getConstructors() {
        return this.data.getValue().getConstructors();
    }

    public ClassDescriptor getDescriptor() {
        return this.data.getValue().getDescriptor();
    }

    @Override // kotlin.reflect.KDeclarationContainer
    public Collection<KCallable<?>> getMembers() {
        return this.data.getValue().getAllMembers();
    }

    @Override // kotlin.reflect.KClass
    public Collection<KClass<?>> getNestedClasses() {
        return this.data.getValue().getNestedClasses();
    }

    @Override // kotlin.reflect.KClass
    public T getObjectInstance() {
        return (T) this.data.getValue().getObjectInstance();
    }

    @Override // kotlin.reflect.KClass
    public String getQualifiedName() {
        return this.data.getValue().getQualifiedName();
    }

    @Override // kotlin.reflect.KClass
    public List<KClass<? extends T>> getSealedSubclasses() {
        return this.data.getValue().getSealedSubclasses();
    }

    @Override // kotlin.reflect.KClass
    public String getSimpleName() {
        return this.data.getValue().getSimpleName();
    }

    @Override // kotlin.reflect.KClass
    public List<KType> getSupertypes() {
        return this.data.getValue().getSupertypes();
    }

    @Override // kotlin.reflect.KClass
    public List<KTypeParameter> getTypeParameters() {
        return this.data.getValue().getTypeParameters();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("class ");
        ClassId r1 = getClassId();
        FqName r2 = r1.getPackageFqName();
        if (r2.isRoot() == false) goto L5;
        String r3 = XmlPullParser.NO_NAMESPACE;
    L6:
        r0.append(r3 + StringsKt.replace$default(r1.getRelativeClassName().asString(), '.', '$', false, 4, null));
        return r0.toString();
    L5:
        r3 = r2.asString() + '.';
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<ConstructorDescriptor> getConstructorDescriptors() {
        ClassDescriptor r0 = getDescriptor();
        if (r0.getKind() == ClassKind.INTERFACE) goto L10;
        if (r0.getKind() == ClassKind.OBJECT) goto L10;
        return r0.getConstructors();
    L10:
        return CollectionsKt.emptyList();
    }

    public final MemberScope getMemberScope$kotlin_reflection() {
        return getDescriptor().getDefaultType().getMemberScope();
    }

    public final MemberScope getStaticScope$kotlin_reflection() {
        return getDescriptor().getStaticScope();
    }

    @Override // kotlin.reflect.KClass
    public KVisibility getVisibility() {
        return UtilKt.toKVisibility(getDescriptor().getVisibility());
    }

    @Override // kotlin.reflect.KClass
    public int hashCode() {
        return JvmClassMappingKt.getJavaObjectType(this).hashCode();
    }

    @Override // kotlin.reflect.KClass
    public boolean isAbstract() {
        if (getDescriptor().getModality() != Modality.ABSTRACT) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.reflect.KClass
    public boolean isCompanion() {
        return getDescriptor().isCompanionObject();
    }

    @Override // kotlin.reflect.KClass
    public boolean isData() {
        return getDescriptor().isData();
    }

    @Override // kotlin.reflect.KClass
    public boolean isFinal() {
        if (getDescriptor().getModality() != Modality.FINAL) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.reflect.KClass
    public boolean isFun() {
        return getDescriptor().isFun();
    }

    @Override // kotlin.reflect.KClass
    public boolean isInner() {
        return getDescriptor().isInner();
    }

    @Override // kotlin.reflect.KClass
    public boolean isOpen() {
        if (getDescriptor().getModality() != Modality.OPEN) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.reflect.KClass
    public boolean isSealed() {
        if (getDescriptor().getModality() != Modality.SEALED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.reflect.KClass
    public boolean isValue() {
        return getDescriptor().isValue();
    }

    public final Lazy<KClassImpl<T>.Data> getData() {
        return this.data;
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public Class<T> getJClass() {
        return this.jClass;
    }

    @Override // kotlin.reflect.jvm.internal.KClassifierImpl
    /* JADX INFO: renamed from: getDescriptor, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ ClassifierDescriptor mo167getDescriptor() {
        return getDescriptor();
    }

    public KClassImpl(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "jClass");
        this.jClass = r2;
        this.data = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KClassImpl$$Lambda$0(this));
    }

    public static final /* synthetic */ ClassId access$getClassId(KClassImpl r0) {
        return r0.getClassId();
    }

    private static final Data data$lambda$0(KClassImpl r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return new Data(r1);
    }

    @Override // kotlin.reflect.KClass
    public boolean equals(Object r2) {
        if ((r2 instanceof KClassImpl) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(JvmClassMappingKt.getJavaObjectType(this), JvmClassMappingKt.getJavaObjectType((KClass) r2)) == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<FunctionDescriptor> getFunctions(Name r4) {
        Intrinsics.checkNotNullParameter(r4, "name");
        MemberScope r0 = getMemberScope$kotlin_reflection();
        NoLookupLocation r1 = NoLookupLocation.FROM_REFLECTION;
        return CollectionsKt.plus(r0.getContributedFunctions(r4, r1), getStaticScope$kotlin_reflection().getContributedFunctions(r4, r1));
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public PropertyDescriptor getLocalProperty(int r10) {
        if (Intrinsics.areEqual(getJClass().getSimpleName(), "DefaultImpls") == false) goto L10;
        Class<?> r0 = getJClass().getDeclaringClass();
        if (r0 == null) goto L10;
        if (r0.isInterface() == false) goto L10;
        KClass r1 = JvmClassMappingKt.getKotlinClass(r0);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
        return ((KClassImpl) r1).getLocalProperty(r10);
    L10:
        DeserializedClassDescriptor r2 = getDescriptor();
        if ((r2 instanceof DeserializedClassDescriptor) == false) goto L13;
        DeserializedClassDescriptor r3 = r2;
    L14:
        if (r3 == null) goto L19;
        ProtoBuf.Property r4 = (ProtoBuf.Property) ProtoBufUtilKt.getExtensionOrNull(r3.getClassProto(), JvmProtoBuf.classLocalVariable, r10);
        if (r4 != null) goto L18;
        return null;
    L18:
        return UtilKt.deserializeToDescriptor(getJClass(), r4, r3.getC().getNameResolver(), r3.getC().getTypeTable(), r3.getMetadataVersion(), getLocalProperty.2.1.1.INSTANCE);
    L19:
        return null;
    L13:
        r3 = null;
        goto L14
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<PropertyDescriptor> getProperties(Name r4) {
        Intrinsics.checkNotNullParameter(r4, "name");
        MemberScope r0 = getMemberScope$kotlin_reflection();
        NoLookupLocation r1 = NoLookupLocation.FROM_REFLECTION;
        return CollectionsKt.plus(r0.getContributedVariables(r4, r1), getStaticScope$kotlin_reflection().getContributedVariables(r4, r1));
    }

    @Override // kotlin.reflect.KClass
    public boolean isInstance(Object r2) {
        Integer r0 = ReflectClassUtilKt.getFunctionClassArity(getJClass());
        if (r0 != null) goto L5;
        Class<T> r1 = ReflectClassUtilKt.getWrapperByPrimitive(getJClass());
        if (r1 != null) goto L10;
        r1 = getJClass();
    L10:
        return r1.isInstance(r2);
    L5:
        return TypeIntrinsics.isFunctionOfArity(r2, r0.intValue());
    }

    private final ClassDescriptor createSyntheticClass(ClassId r11, RuntimeModuleData r12) {
        ClassDescriptorImpl r9 = new ClassDescriptorImpl(new EmptyPackageFragmentDescriptor(r12.getModule(), r11.getPackageFqName()), r11.getShortClassName(), Modality.FINAL, ClassKind.CLASS, CollectionsKt.listOf(r12.getModule().getBuiltIns().getAny().getDefaultType()), SourceElement.NO_SOURCE, false, r12.getDeserialization().getStorageManager());
        r9.initialize(new createSyntheticClass.1.1(r9, r12.getDeserialization().getStorageManager()), SetsKt.emptySet(), null);
        return r9;
    }

    private final ClassDescriptor createSyntheticClassOrFail(ClassId r5, RuntimeModuleData r6) {
        if (getJClass().isSynthetic() == true) goto L5;
        ReflectKotlinClass r0 = ReflectKotlinClass.Factory.create(getJClass());
        if (r0 == null) goto L11;
        KotlinClassHeader r1 = r0.getClassHeader();
        if (r1 == null) goto L11;
        KotlinClassHeader.Kind r2 = r1.getKind();
    L12:
        if (r2 != null) goto L14;
        int r3 = -1;
    L16:
        switch(r3) {
            case -1: goto L24;
            case 0: goto L18;
            case 1: goto L22;
            case 2: goto L22;
            case 3: goto L22;
            case 4: goto L22;
            case 5: goto L20;
            case 6: goto L24;
            default: goto L18;
        };
    L18:
        throw new NoWhenBranchMatchedException();
    L20:
        throw new KotlinReflectionInternalError("Unknown class: " + getJClass() + " (kind = " + r2 + ')');
    L22:
        return createSyntheticClass(r5, r6);
    L24:
        throw new KotlinReflectionInternalError("Unresolved class: " + getJClass() + " (kind = " + r2 + ')');
    L14:
        r3 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
    L11:
        r2 = null;
        goto L12
    L5:
        return createSyntheticClass(r5, r6);
    }

    public static final /* synthetic */ ClassDescriptor access$createSyntheticClassOrFail(KClassImpl r0, ClassId r1, RuntimeModuleData r2) {
        return r0.createSyntheticClassOrFail(r1, r2);
    }
}
