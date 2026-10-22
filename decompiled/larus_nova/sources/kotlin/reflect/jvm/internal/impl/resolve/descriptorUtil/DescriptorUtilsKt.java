package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt;
import kotlin.reflect.jvm.internal.impl.types.checker.Ref;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeRefinementSupport;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes5.dex */
public final class DescriptorUtilsKt {
    private static final Name RETENTION_PARAMETER_NAME = null;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$declaresOrInheritsDefaultValue$2, reason: invalid class name */
    /* JADX INFO: loaded from: classes42.dex */
    public /* synthetic */ class AnonymousClass2 extends FunctionReference implements Function1<ValueParameterDescriptor, Boolean> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "declaresDefaultValue";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(ValueParameterDescriptor.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getSignature() {
            return "declaresDefaultValue()Z";
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Boolean invoke2(ValueParameterDescriptor r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
            return Boolean.valueOf(r100.declaresDefaultValue());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(ValueParameterDescriptor r100) {
            return invoke2(r100);
        }
    }

    public static /* synthetic */ Iterable accessor$DescriptorUtilsKt$lambda0(ValueParameterDescriptor r100) {
        return declaresOrInheritsDefaultValue$lambda$5(r100);
    }

    public static /* synthetic */ DeclarationDescriptor accessor$DescriptorUtilsKt$lambda1(DeclarationDescriptor r100) {
        return _get_parentsWithSelf_$lambda$8(r100);
    }

    public static /* synthetic */ Iterable accessor$DescriptorUtilsKt$lambda2(boolean r100, CallableMemberDescriptor r101) {
        return firstOverridden$lambda$10(r100, r101);
    }

    public static /* synthetic */ Sequence accessor$DescriptorUtilsKt$lambda3(boolean r100, CallableMemberDescriptor r101) {
        return overriddenTreeAsSequence$lambda$12$lambda$11(r100, r101);
    }

    static {
        RETENTION_PARAMETER_NAME = Name.identifier("value");
    }

    private static final DeclarationDescriptor _get_parentsWithSelf_$lambda$8(DeclarationDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return r100.getContainingDeclaration();
    }

    public static final boolean declaresOrInheritsDefaultValue(ValueParameterDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return DFS.ifAny(CollectionsKt.listOf(r100), DescriptorUtilsKt$$Lambda$0.INSTANCE, AnonymousClass2.INSTANCE).booleanValue();
    }

    private static final Iterable declaresOrInheritsDefaultValue$lambda$5(ValueParameterDescriptor r100) {
        Collection<ValueParameterDescriptor> r101 = r100.getOverriddenDescriptors();
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(((ValueParameterDescriptor) r103.next()).getOriginal());
        goto L4
    L6:
        return r102;
    }

    public static final FqName fqNameOrNull(DeclarationDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        FqNameUnsafe r101 = getFqNameUnsafe(r100);
        if (r101.isSafe() == true) goto L6;
        r101 = null;
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.toSafe();
    }

    public static final ClassDescriptor getAnnotationClass(AnnotationDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ClassifierDescriptor r101 = r100.getType().getConstructor().mo10732getDeclarationDescriptor();
        if ((r101 instanceof ClassDescriptor) == true) goto L7;
        return null;
    L7:
        return (ClassDescriptor) r101;
    }

    public static final KotlinBuiltIns getBuiltIns(DeclarationDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return getModule(r100).getBuiltIns();
    }

    public static final ClassId getClassId(ClassifierDescriptor r100) {
        if (r100 == null) goto L15;
        DeclarationDescriptor r101 = r100.getContainingDeclaration();
        if (r101 != null) goto L7;
        return null;
    L7:
        if ((r101 instanceof PackageFragmentDescriptor) == false) goto L10;
        return new ClassId(((PackageFragmentDescriptor) r101).getFqName(), r100.getName());
    L10:
        if ((r101 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L18;
        ClassId r102 = getClassId((ClassifierDescriptor) r101);
        if (r102 != null) goto L14;
        return null;
    L14:
        return r102.createNestedClassId(r100.getName());
    L18:
        return null;
    L15:
        return null;
    }

    public static final FqName getFqNameSafe(DeclarationDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return DescriptorUtils.getFqNameSafe(r100);
    }

    public static final FqNameUnsafe getFqNameUnsafe(DeclarationDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return DescriptorUtils.getFqName(r100);
    }

    public static final InlineClassRepresentation<SimpleType> getInlineClassRepresentation(ClassDescriptor r100) {
        if (r100 == null) goto L5;
        ValueClassRepresentation<SimpleType> r101 = r100.getValueClassRepresentation();
    L7:
        if ((r101 instanceof InlineClassRepresentation) == true) goto L9;
        return null;
    L9:
        return (InlineClassRepresentation) r101;
    L5:
        r101 = null;
        goto L7
    }

    public static final KotlinTypeRefiner getKotlinTypeRefiner(ModuleDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Ref r101 = (Ref) r100.getCapability(KotlinTypeRefinerKt.getREFINER_CAPABILITY());
        if (r101 == null) goto L5;
        TypeRefinementSupport r102 = (TypeRefinementSupport) r101.getValue();
    L7:
        if ((r102 instanceof TypeRefinementSupport.Enabled) == false) goto L10;
        return ((TypeRefinementSupport.Enabled) r102).getTypeRefiner();
    L10:
        return KotlinTypeRefiner.Default.INSTANCE;
    L5:
        r102 = null;
        goto L7
    }

    public static final ModuleDescriptor getModule(DeclarationDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return DescriptorUtils.getContainingModule(r100);
    }

    public static final MultiFieldValueClassRepresentation<SimpleType> getMultiFieldValueClassRepresentation(ClassDescriptor r100) {
        if (r100 == null) goto L5;
        ValueClassRepresentation<SimpleType> r101 = r100.getValueClassRepresentation();
    L7:
        if ((r101 instanceof MultiFieldValueClassRepresentation) == true) goto L9;
        return null;
    L9:
        return (MultiFieldValueClassRepresentation) r101;
    L5:
        r101 = null;
        goto L7
    }

    public static final Sequence<DeclarationDescriptor> getParents(DeclarationDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return SequencesKt.drop(getParentsWithSelf(r100), 1);
    }

    public static final Sequence<DeclarationDescriptor> getParentsWithSelf(DeclarationDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return SequencesKt.generateSequence(r100, DescriptorUtilsKt$$Lambda$1.INSTANCE);
    }

    public static final CallableMemberDescriptor getPropertyIfAccessor(CallableMemberDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof PropertyAccessorDescriptor) == true) goto L5;
        return r100;
    L5:
        return ((PropertyAccessorDescriptor) r100).getCorrespondingProperty();
    }

    public static final ClassDescriptor getSuperClassNotAny(ClassDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Iterator<KotlinType> r101 = r100.getDefaultType().getConstructor().mo10733getSupertypes().iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        KotlinType r102 = r101.next();
        if (KotlinBuiltIns.isAnyOrNullableAny(r102) == true) goto L4;
        ClassifierDescriptor r103 = r102.getConstructor().mo10732getDeclarationDescriptor();
        if (DescriptorUtils.isClassOrEnumClass(r103) == false) goto L4;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        return (ClassDescriptor) r103;
    L11:
        return null;
    }

    public static final boolean isTypeRefinementEnabled(ModuleDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Ref r101 = (Ref) r100.getCapability(KotlinTypeRefinerKt.getREFINER_CAPABILITY());
        if (r101 == null) goto L10;
        TypeRefinementSupport r102 = (TypeRefinementSupport) r101.getValue();
        if (r102 != null) goto L7;
        return false;
    L7:
        if (r102.isEnabled() != true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    private static final Iterable firstOverridden$lambda$10(boolean r100, CallableMemberDescriptor r101) {
        if (r100 == false) goto L6;
        if (r101 == null) goto L5;
        r101 = r101.getOriginal();
        goto L6
    L5:
        r101 = null;
    L6:
        if (r101 == null) goto L10;
        Collection<? extends CallableMemberDescriptor> r102 = r101.getOverriddenDescriptors();
        if (r102 == null) goto L10;
    L12:
        return r102;
    L10:
        r102 = CollectionsKt.emptyList();
        goto L12
    }

    public static final Sequence<CallableMemberDescriptor> overriddenTreeAsSequence(CallableMemberDescriptor r100, final boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == false) goto L6;
        r100 = r100.getOriginal();
    L6:
        return SequencesKt.plus(SequencesKt.sequenceOf(new CallableMemberDescriptor[]{r100}), SequencesKt.flatMap(CollectionsKt.asSequence(r100.getOverriddenDescriptors()), new DescriptorUtilsKt$$Lambda$3(r101)));
    }

    private static final Sequence overriddenTreeAsSequence$lambda$12$lambda$11(boolean r100, CallableMemberDescriptor r101) {
        Intrinsics.checkNotNull(r101);
        return overriddenTreeAsSequence(r101, r100);
    }

    public static final CallableMemberDescriptor firstOverridden(CallableMemberDescriptor r100, final boolean r101, final Function1<? super CallableMemberDescriptor, Boolean> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "predicate");
        final kotlin.jvm.internal.Ref.ObjectRef r103 = new kotlin.jvm.internal.Ref.ObjectRef();
        return (CallableMemberDescriptor) DFS.dfs(CollectionsKt.listOf(r100), new DescriptorUtilsKt$$Lambda$2(r101), new C123392(r103, r102));
    }

    public static final ClassDescriptor resolveTopLevelClass(ModuleDescriptor r100, FqName r101, LookupLocation r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "topLevelClassFqName");
        Intrinsics.checkNotNullParameter(r102, "location");
        r101.isRoot();
        ClassifierDescriptor r103 = r100.getPackage(r101.parent()).getMemberScope().mo10734getContributedClassifier(r101.shortName(), r102);
        if ((r103 instanceof ClassDescriptor) == true) goto L7;
        return null;
    L7:
        return (ClassDescriptor) r103;
    }

    public static /* synthetic */ CallableMemberDescriptor firstOverridden$default(CallableMemberDescriptor r100, boolean r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = false;
    L6:
        return firstOverridden(r100, r101, r102);
    }
}
