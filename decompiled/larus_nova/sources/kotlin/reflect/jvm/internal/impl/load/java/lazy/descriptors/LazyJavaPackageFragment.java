package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryPackageSourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.utils.DeserializationHelpersKt;

/* JADX INFO: loaded from: classes5.dex */
public final class LazyJavaPackageFragment extends PackageFragmentDescriptorImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final Annotations annotations;
    private final NotNullLazyValue binaryClasses$delegate;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LazyJavaResolverContext f504576c;
    private final JavaPackage jPackage;
    private final JvmMetadataVersion jvmMetadataVersion;
    private final NotNullLazyValue partToFacade$delegate;
    private final JvmPackageScope scope;
    private final NotNullLazyValue<List<FqName>> subPackages;

    /* JADX INFO: loaded from: classes42.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[KotlinClassHeader.Kind.values().length];
            r100[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r100;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaPackageFragment.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaPackageFragment.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};
    }

    public static /* synthetic */ Map accessor$LazyJavaPackageFragment$lambda0(LazyJavaPackageFragment r100) {
        return binaryClasses_delegate$lambda$2(r100);
    }

    public static /* synthetic */ List accessor$LazyJavaPackageFragment$lambda1(LazyJavaPackageFragment r100) {
        return subPackages$lambda$3(r100);
    }

    public static /* synthetic */ HashMap accessor$LazyJavaPackageFragment$lambda2(LazyJavaPackageFragment r100) {
        return partToFacade_delegate$lambda$4(r100);
    }

    public final Map<String, KotlinJvmBinaryClass> getBinaryClasses$descriptors_jvm() {
        return (Map) StorageKt.getValue(this.binaryClasses$delegate, this, $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        return new KotlinJvmBinaryPackageSourceElement(this);
    }

    public final List<FqName> getSubPackageFqNames$descriptors_jvm() {
        return this.subPackages.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl
    public String toString() {
        return "Lazy Java package fragment: " + getFqName() + " of module " + this.f504576c.getComponents().getModule();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    public /* bridge */ /* synthetic */ MemberScope getMemberScope() {
        return getMemberScope();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        return this.annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    public JvmPackageScope getMemberScope() {
        return this.scope;
    }

    private static final Map binaryClasses_delegate$lambda$2(LazyJavaPackageFragment r100) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        List<String> r101 = r100.f504576c.getComponents().getPackagePartProvider().findPackageParts(r100.getFqName().asString());
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L12;
        String r104 = (String) r103.next();
        ClassId r105 = ClassId.Companion.topLevel(JvmClassName.byInternalName(r104).getFqNameForTopLevelClassMaybeWithDollars());
        KotlinJvmBinaryClass r106 = KotlinClassFinderKt.findKotlinClass(r100.f504576c.getComponents().getKotlinClassFinder(), r105, r100.jvmMetadataVersion);
        if (r106 == null) goto L8;
        Pair r107 = TuplesKt.to(r104, r106);
    L9:
        if (r107 == null) goto L4;
        r102.add(r107);
        goto L4
    L8:
        r107 = null;
        goto L9
    L12:
        return MapsKt.toMap(r102);
    }

    private static final HashMap partToFacade_delegate$lambda$4(LazyJavaPackageFragment r100) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        HashMap r101 = new HashMap();
        Iterator<Map.Entry<String, KotlinJvmBinaryClass>> r102 = r100.getBinaryClasses$descriptors_jvm().entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L15;
        Map.Entry<String, KotlinJvmBinaryClass> r103 = r102.next();
        String r104 = r103.getKey();
        KotlinJvmBinaryClass r105 = r103.getValue();
        JvmClassName r106 = JvmClassName.byInternalName(r104);
        KotlinClassHeader r107 = r105.getClassHeader();
        KotlinClassHeader.Kind r108 = r107.getKind();
        int r109 = WhenMappings.$EnumSwitchMapping$0[r108.ordinal()];
        if (r109 != 1) goto L8;
        String r110 = r107.getMultifileClassName();
        if (r110 == null) goto L4;
        r101.put(r106, JvmClassName.byInternalName(r110));
        goto L4
    L8:
        if (r109 != 2) goto L4;
        r101.put(r106, r106);
        goto L4
    L15:
        return r101;
    }

    private static final List subPackages$lambda$3(LazyJavaPackageFragment r100) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        Collection<JavaPackage> r101 = r100.jPackage.getSubPackages();
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(((JavaPackage) r103.next()).getFqName());
        goto L4
    L6:
        return r102;
    }

    public final ClassDescriptor findClassifierByJavaClass$descriptors_jvm(JavaClass r100) {
        Intrinsics.checkNotNullParameter(r100, "jClass");
        return this.scope.getJavaScope$descriptors_jvm().findClassifierByJavaClass$descriptors_jvm(r100);
    }

    public LazyJavaPackageFragment(LazyJavaResolverContext r100, JavaPackage r110) {
        Intrinsics.checkNotNullParameter(r100, "outerContext");
        Intrinsics.checkNotNullParameter(r110, "jPackage");
        super(r100.getModule(), r110.getFqName());
        this.jPackage = r110;
        LazyJavaResolverContext r101 = ContextKt.childForClassOrPackage$default(r100, this, null, 0, 6, null);
        this.f504576c = r101;
        this.jvmMetadataVersion = DeserializationHelpersKt.jvmMetadataVersionOrDefault(r100.getComponents().getDeserializedDescriptorResolver().getComponents().getConfiguration());
        this.binaryClasses$delegate = r101.getStorageManager().createLazyValue(new LazyJavaPackageFragment$$Lambda$0(this));
        this.scope = new JvmPackageScope(r101, r110, this);
        this.subPackages = r101.getStorageManager().createRecursionTolerantLazyValue(new LazyJavaPackageFragment$$Lambda$1(this), CollectionsKt.emptyList());
        if (r101.getComponents().getJavaTypeEnhancementState().getDisabledDefaultAnnotations() == false) goto L5;
        Annotations r102 = Annotations.Companion.getEMPTY();
    L6:
        this.annotations = r102;
        this.partToFacade$delegate = r101.getStorageManager().createLazyValue(new LazyJavaPackageFragment$$Lambda$2(this));
        return;
    L5:
        r102 = LazyJavaAnnotationsKt.resolveAnnotations(r101, r110);
        goto L6
    }
}
