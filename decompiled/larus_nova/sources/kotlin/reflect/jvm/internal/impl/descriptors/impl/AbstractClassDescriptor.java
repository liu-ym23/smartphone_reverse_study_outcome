package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractClassDescriptor extends ModuleAwareClassDescriptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected final NotNullLazyValue<SimpleType> defaultType;
    private final Name name;
    private final NotNullLazyValue<ReceiverParameterDescriptor> thisAsReceiverParameter;
    private final NotNullLazyValue<MemberScope> unsubstitutedInnerClassesScope;

    private static /* synthetic */ void $$$reportNull$$$0(int r110) {
        if (r110 == 2) goto L16;
        if (r110 == 3) goto L16;
        if (r110 == 4) goto L16;
        if (r110 == 5) goto L16;
        if (r110 == 6) goto L16;
        if (r110 == 9) goto L16;
        if (r110 == 12) goto L16;
        if (r110 == 14) goto L16;
        if (r110 == 16) goto L16;
        if (r110 == 17) goto L16;
        if (r110 == 19) goto L16;
        if (r110 == 20) goto L16;
        String r111 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L17:
        if (r110 == 2) goto L30;
        if (r110 == 3) goto L30;
        if (r110 == 4) goto L30;
        if (r110 == 5) goto L30;
        if (r110 == 6) goto L30;
        if (r110 == 9) goto L30;
        if (r110 == 12) goto L30;
        if (r110 == 14) goto L30;
        if (r110 == 16) goto L30;
        if (r110 == 17) goto L30;
        if (r110 == 19) goto L30;
        if (r110 == 20) goto L30;
        int r112 = 3;
    L31:
        Object[] r113 = new Object[r112];
        switch(r110) {
            case 1: goto L39;
            case 2: goto L38;
            case 3: goto L38;
            case 4: goto L38;
            case 5: goto L38;
            case 6: goto L38;
            case 7: goto L37;
            case 8: goto L36;
            case 9: goto L38;
            case 10: goto L35;
            case 11: goto L36;
            case 12: goto L38;
            case 13: goto L37;
            case 14: goto L38;
            case 15: goto L35;
            case 16: goto L38;
            case 17: goto L38;
            case 18: goto L34;
            case 19: goto L38;
            case 20: goto L38;
            default: goto L33;
        };
    L33:
        r113[0] = "storageManager";
    L41:
        if (r110 == 2) goto L62;
        if (r110 == 3) goto L61;
        if (r110 == 4) goto L60;
        if (r110 == 5) goto L59;
        if (r110 == 6) goto L58;
        if (r110 == 9) goto L57;
        if (r110 == 12) goto L57;
        if (r110 == 14) goto L57;
        if (r110 == 16) goto L57;
        if (r110 == 17) goto L56;
        if (r110 == 19) goto L55;
        if (r110 == 20) goto L54;
        r113[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
    L63:
        switch(r110) {
            case 2: goto L67;
            case 3: goto L67;
            case 4: goto L67;
            case 5: goto L67;
            case 6: goto L67;
            case 7: goto L66;
            case 8: goto L66;
            case 9: goto L67;
            case 10: goto L66;
            case 11: goto L66;
            case 12: goto L67;
            case 13: goto L66;
            case 14: goto L67;
            case 15: goto L66;
            case 16: goto L67;
            case 17: goto L67;
            case 18: goto L65;
            case 19: goto L67;
            case 20: goto L67;
            default: goto L64;
        };
    L64:
        r113[2] = "<init>";
        goto L67
    L65:
        r113[2] = "substitute";
        goto L67
    L66:
        r113[2] = "getMemberScope";
    L67:
        String r114 = String.format(r111, r113);
        if (r110 == 2) goto L82;
        if (r110 == 3) goto L82;
        if (r110 == 4) goto L82;
        if (r110 == 5) goto L82;
        if (r110 == 6) goto L82;
        if (r110 == 9) goto L82;
        if (r110 == 12) goto L82;
        if (r110 == 14) goto L82;
        if (r110 == 16) goto L82;
        if (r110 == 17) goto L82;
        if (r110 == 19) goto L82;
        if (r110 == 20) goto L82;
        throw new IllegalArgumentException(r114);
    L82:
        throw new IllegalStateException(r114);
    L54:
        r113[1] = "getDefaultType";
        goto L63
    L55:
        r113[1] = "substitute";
        goto L63
    L56:
        r113[1] = "getUnsubstitutedMemberScope";
    L57:
        r113[1] = "getMemberScope";
        goto L63
    L58:
        r113[1] = "getContextReceivers";
        goto L63
    L59:
        r113[1] = "getThisAsReceiverParameter";
        goto L63
    L60:
        r113[1] = "getUnsubstitutedInnerClassesScope";
        goto L63
    L61:
        r113[1] = "getOriginal";
        goto L63
    L62:
        r113[1] = "getName";
        goto L63
    L34:
        r113[0] = "substitutor";
        goto L41
    L35:
        r113[0] = "typeSubstitution";
        goto L41
    L36:
        r113[0] = "kotlinTypeRefiner";
        goto L41
    L37:
        r113[0] = "typeArguments";
        goto L41
    L38:
        r113[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
        goto L41
    L39:
        r113[0] = "name";
    L30:
        r112 = 2;
    L16:
        r111 = "@NotNull method %s.%s must not return null";
        goto L17
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public ClassDescriptor getOriginal() {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public SimpleType getDefaultType() {
        SimpleType r100 = this.defaultType.invoke();
        if (r100 != null) goto L5;
        $$$reportNull$$$0(20);
    L5:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Named
    public Name getName() {
        Name r100 = this.name;
        if (r100 != null) goto L5;
        $$$reportNull$$$0(2);
    L5:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ReceiverParameterDescriptor getThisAsReceiverParameter() {
        ReceiverParameterDescriptor r100 = this.thisAsReceiverParameter.invoke();
        if (r100 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScope getUnsubstitutedInnerClassesScope() {
        MemberScope r100 = this.unsubstitutedInnerClassesScope.invoke();
        if (r100 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public List<ReceiverParameterDescriptor> getContextReceivers() {
        List<ReceiverParameterDescriptor> r100 = Collections.emptyList();
        if (r100 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ ClassifierDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScope getUnsubstitutedMemberScope() {
        MemberScope r100 = getUnsubstitutedMemberScope(DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this)));
        if (r100 != null) goto L5;
        $$$reportNull$$$0(17);
    L5:
        return r100;
    }

    static {
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScope getMemberScope(TypeSubstitution r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(15);
    L4:
        MemberScope r101 = getMemberScope(r100, DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this)));
        if (r101 != null) goto L7;
        $$$reportNull$$$0(16);
    L7:
        return r101;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public ClassDescriptor substitute(TypeSubstitutor r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(18);
    L5:
        if (r100.isEmpty() == false) goto L8;
        return this;
    L8:
        return new LazySubstitutingClassDescriptor(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor r100) {
        return substitute(r100);
    }

    public AbstractClassDescriptor(StorageManager r100, Name r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        this.name = r101;
        this.defaultType = r100.createLazyValue(new AnonymousClass1(this));
        this.unsubstitutedInnerClassesScope = r100.createLazyValue(new AnonymousClass2(this));
        this.thisAsReceiverParameter = r100.createLazyValue(new AnonymousClass3(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> r100, D r101) {
        return r100.visitClassDescriptor(this, r101);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    public MemberScope getMemberScope(TypeSubstitution r100, KotlinTypeRefiner r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(10);
    L4:
        if (r101 != null) goto L7;
        $$$reportNull$$$0(11);
    L7:
        if (r100.isEmpty() == false) goto L12;
        MemberScope r102 = getUnsubstitutedMemberScope(r101);
        if (r102 != null) goto L11;
        $$$reportNull$$$0(12);
    L11:
        return r102;
    L12:
        TypeSubstitutor r103 = TypeSubstitutor.create(r100);
        return new SubstitutingScope(getUnsubstitutedMemberScope(r101), r103);
    }
}
