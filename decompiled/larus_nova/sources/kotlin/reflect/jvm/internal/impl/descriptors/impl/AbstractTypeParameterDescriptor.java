package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* JADX INFO: loaded from: classes42.dex */
public abstract class AbstractTypeParameterDescriptor extends DeclarationDescriptorNonRootImpl implements TypeParameterDescriptor {
    private final NotNullLazyValue<SimpleType> defaultType;
    private final int index;
    private final boolean reified;
    private final StorageManager storageManager;
    private final NotNullLazyValue<TypeConstructor> typeConstructor;
    private final Variance variance;

    public class TypeParameterTypeConstructor extends AbstractTypeConstructor {
        private final SupertypeLoopChecker supertypeLoopChecker;
        final /* synthetic */ AbstractTypeParameterDescriptor this$0;

        private static /* synthetic */ void $$$reportNull$$$0(int r110) {
            if (r110 == 1) goto L10;
            if (r110 == 2) goto L10;
            if (r110 == 3) goto L10;
            if (r110 == 4) goto L10;
            if (r110 == 5) goto L10;
            if (r110 == 8) goto L10;
            String r100 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L11:
            if (r110 == 1) goto L18;
            if (r110 == 2) goto L18;
            if (r110 == 3) goto L18;
            if (r110 == 4) goto L18;
            if (r110 == 5) goto L18;
            if (r110 == 8) goto L18;
            int r101 = 3;
        L19:
            Object[] r102 = new Object[r101];
            switch(r110) {
                case 1: goto L25;
                case 2: goto L25;
                case 3: goto L25;
                case 4: goto L25;
                case 5: goto L25;
                case 6: goto L24;
                case 7: goto L23;
                case 8: goto L25;
                case 9: goto L22;
                default: goto L21;
            };
        L21:
            r102[0] = "storageManager";
        L27:
            if (r110 == 1) goto L39;
            if (r110 == 2) goto L38;
            if (r110 == 3) goto L37;
            if (r110 == 4) goto L36;
            if (r110 == 5) goto L35;
            if (r110 == 8) goto L34;
            r102[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
        L40:
            switch(r110) {
                case 1: goto L45;
                case 2: goto L45;
                case 3: goto L45;
                case 4: goto L45;
                case 5: goto L45;
                case 6: goto L44;
                case 7: goto L43;
                case 8: goto L45;
                case 9: goto L42;
                default: goto L41;
            };
        L41:
            r102[2] = "<init>";
            goto L45
        L42:
            r102[2] = "isSameClassifier";
            goto L45
        L43:
            r102[2] = "processSupertypesWithoutCycles";
            goto L45
        L44:
            r102[2] = "reportSupertypeLoopError";
        L45:
            String r103 = String.format(r100, r102);
            if (r110 == 1) goto L54;
            if (r110 == 2) goto L54;
            if (r110 == 3) goto L54;
            if (r110 == 4) goto L54;
            if (r110 == 5) goto L54;
            if (r110 == 8) goto L54;
            throw new IllegalArgumentException(r103);
        L54:
            throw new IllegalStateException(r103);
        L34:
            r102[1] = "processSupertypesWithoutCycles";
            goto L40
        L35:
            r102[1] = "getSupertypeLoopChecker";
            goto L40
        L36:
            r102[1] = "getBuiltIns";
            goto L40
        L37:
            r102[1] = "getDeclarationDescriptor";
            goto L40
        L38:
            r102[1] = "getParameters";
            goto L40
        L39:
            r102[1] = "computeSupertypes";
            goto L40
        L22:
            r102[0] = "classifier";
            goto L27
        L23:
            r102[0] = "supertypes";
            goto L27
        L24:
            r102[0] = "type";
            goto L27
        L25:
            r102[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
        L18:
            r101 = 2;
        L10:
            r100 = "@NotNull method %s.%s must not return null";
            goto L11
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        public Collection<KotlinType> computeSupertypes() {
            List<KotlinType> r100 = this.this$0.resolveUpperBounds();
            if (r100 != null) goto L5;
            $$$reportNull$$$0(1);
        L5:
            return r100;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        public KotlinType defaultSupertypeIfEmpty() {
            return ErrorUtils.createErrorType(ErrorTypeKind.CYCLIC_UPPER_BOUNDS, new String[0]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public KotlinBuiltIns getBuiltIns() {
            KotlinBuiltIns r100 = DescriptorUtilsKt.getBuiltIns(this.this$0);
            if (r100 != null) goto L5;
            $$$reportNull$$$0(4);
        L5:
            return r100;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getDeclarationDescriptor */
        public ClassifierDescriptor mo10732getDeclarationDescriptor() {
            AbstractTypeParameterDescriptor r100 = this.this$0;
            if (r100 != null) goto L5;
            $$$reportNull$$$0(3);
        L5:
            return r100;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        public SupertypeLoopChecker getSupertypeLoopChecker() {
            SupertypeLoopChecker r100 = this.supertypeLoopChecker;
            if (r100 != null) goto L5;
            $$$reportNull$$$0(5);
        L5:
            return r100;
        }

        public String toString() {
            return this.this$0.getName().toString();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            List<TypeParameterDescriptor> r100 = Collections.emptyList();
            if (r100 != null) goto L5;
            $$$reportNull$$$0(2);
        L5:
            return r100;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor
        public boolean isSameClassifier(ClassifierDescriptor r100) {
            if (r100 != null) goto L5;
            $$$reportNull$$$0(9);
        L5:
            if ((r100 instanceof TypeParameterDescriptor) == true) goto L7;
        L9:
            return false;
        L7:
            if (DescriptorEquivalenceForOverrides.INSTANCE.areTypeParametersEquivalent(this.this$0, (TypeParameterDescriptor) r100, true) == false) goto L9;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        public List<KotlinType> processSupertypesWithoutCycles(List<KotlinType> r100) {
            if (r100 != null) goto L4;
            $$$reportNull$$$0(7);
        L4:
            List<KotlinType> r101 = this.this$0.processBoundsWithoutCycles(r100);
            if (r101 != null) goto L7;
            $$$reportNull$$$0(8);
        L7:
            return r101;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        public void reportSupertypeLoopError(KotlinType r100) {
            if (r100 != null) goto L4;
            $$$reportNull$$$0(6);
        L4:
            this.this$0.mo10735reportSupertypeLoopError(r100);
        }

        public TypeParameterTypeConstructor(AbstractTypeParameterDescriptor r100, StorageManager r101, SupertypeLoopChecker r102) {
            if (r101 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            this.this$0 = r100;
            super(r101);
            this.supertypeLoopChecker = r102;
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r100) {
        switch(r100) {
            case 7: goto L4;
            case 8: goto L4;
            case 9: goto L4;
            case 10: goto L4;
            case 11: goto L4;
            case 12: goto L3;
            case 13: goto L4;
            case 14: goto L4;
            default: goto L3;
        };
    L3:
        String r101 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r100) {
            case 7: goto L8;
            case 8: goto L8;
            case 9: goto L8;
            case 10: goto L8;
            case 11: goto L8;
            case 12: goto L7;
            case 13: goto L8;
            case 14: goto L8;
            default: goto L7;
        };
    L7:
        int r102 = 3;
    L9:
        Object[] r103 = new Object[r102];
        switch(r100) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L13;
            case 9: goto L13;
            case 10: goto L13;
            case 11: goto L13;
            case 12: goto L12;
            case 13: goto L13;
            case 14: goto L13;
            default: goto L11;
        };
    L11:
        r103[0] = "storageManager";
    L21:
        switch(r100) {
            case 7: goto L29;
            case 8: goto L28;
            case 9: goto L27;
            case 10: goto L26;
            case 11: goto L25;
            case 12: goto L22;
            case 13: goto L24;
            case 14: goto L23;
            default: goto L22;
        };
    L22:
        r103[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
    L30:
        switch(r100) {
            case 7: goto L33;
            case 8: goto L33;
            case 9: goto L33;
            case 10: goto L33;
            case 11: goto L33;
            case 12: goto L32;
            case 13: goto L33;
            case 14: goto L33;
            default: goto L31;
        };
    L31:
        r103[2] = "<init>";
        goto L33
    L32:
        r103[2] = "processBoundsWithoutCycles";
    L33:
        String r104 = String.format(r101, r103);
        switch(r100) {
            case 7: goto L37;
            case 8: goto L37;
            case 9: goto L37;
            case 10: goto L37;
            case 11: goto L37;
            case 12: goto L38;
            case 13: goto L37;
            case 14: goto L37;
            default: goto L38;
        };
    L38:
        throw new IllegalArgumentException(r104);
    L37:
        throw new IllegalStateException(r104);
    L23:
        r103[1] = "getStorageManager";
        goto L30
    L24:
        r103[1] = "processBoundsWithoutCycles";
        goto L30
    L25:
        r103[1] = "getOriginal";
        goto L30
    L26:
        r103[1] = "getDefaultType";
        goto L30
    L27:
        r103[1] = "getTypeConstructor";
        goto L30
    L28:
        r103[1] = "getUpperBounds";
        goto L30
    L29:
        r103[1] = "getVariance";
        goto L30
    L12:
        r103[0] = "bounds";
        goto L21
    L13:
        r103[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
        goto L21
    L14:
        r103[0] = "supertypeLoopChecker";
        goto L21
    L15:
        r103[0] = "source";
        goto L21
    L16:
        r103[0] = "variance";
        goto L21
    L17:
        r103[0] = "name";
        goto L21
    L18:
        r103[0] = "annotations";
        goto L21
    L19:
        r103[0] = "containingDeclaration";
        goto L21
    L8:
        r102 = 2;
        goto L9
    L4:
        r101 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public boolean isCapturedFromOuterDeclaration() {
        return false;
    }

    /* JADX INFO: renamed from: reportSupertypeLoopError */
    public abstract void mo10735reportSupertypeLoopError(KotlinType r100);

    public abstract List<KotlinType> resolveUpperBounds();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public SimpleType getDefaultType() {
        SimpleType r100 = this.defaultType.invoke();
        if (r100 != null) goto L5;
        $$$reportNull$$$0(10);
    L5:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public StorageManager getStorageManager() {
        StorageManager r100 = this.storageManager;
        if (r100 != null) goto L5;
        $$$reportNull$$$0(14);
    L5:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public final TypeConstructor getTypeConstructor() {
        TypeConstructor r100 = this.typeConstructor.invoke();
        if (r100 != null) goto L5;
        $$$reportNull$$$0(9);
    L5:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public Variance getVariance() {
        Variance r100 = this.variance;
        if (r100 != null) goto L5;
        $$$reportNull$$$0(7);
    L5:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public TypeParameterDescriptor getOriginal() {
        TypeParameterDescriptor r100 = (TypeParameterDescriptor) super.getOriginal();
        if (r100 != null) goto L5;
        $$$reportNull$$$0(11);
    L5:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public List<KotlinType> getUpperBounds() {
        List<KotlinType> r100 = ((TypeParameterTypeConstructor) getTypeConstructor()).mo10733getSupertypes();
        if (r100 != null) goto L5;
        $$$reportNull$$$0(8);
    L5:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public int getIndex() {
        return this.index;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public boolean isReified() {
        return this.reified;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ ClassifierDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptorWithSource getOriginal() {
        return getOriginal();
    }

    public List<KotlinType> processBoundsWithoutCycles(List<KotlinType> r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(12);
    L4:
        if (r100 != null) goto L6;
        $$$reportNull$$$0(13);
    L6:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> r100, D r101) {
        return r100.visitTypeParameterDescriptor(this, r101);
    }

    public AbstractTypeParameterDescriptor(final StorageManager r100, DeclarationDescriptor r101, Annotations r102, final Name r103, Variance r104, boolean r105, int r106, SourceElement r107, final SupertypeLoopChecker r110) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r102 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r103 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        if (r104 != null) goto L12;
        $$$reportNull$$$0(4);
    L12:
        if (r107 != null) goto L14;
        $$$reportNull$$$0(5);
    L14:
        if (r110 != null) goto L16;
        $$$reportNull$$$0(6);
    L16:
        super(r101, r102, r103, r107);
        this.variance = r104;
        this.reified = r105;
        this.index = r106;
        this.typeConstructor = r100.createLazyValue(new AnonymousClass1(this, r100, r110));
        this.defaultType = r100.createLazyValue(new AnonymousClass2(this, r103));
        this.storageManager = r100;
    }
}
