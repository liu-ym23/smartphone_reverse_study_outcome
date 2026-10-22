package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* JADX INFO: loaded from: classes5.dex */
public abstract class VariableDescriptorImpl extends DeclarationDescriptorNonRootImpl implements VariableDescriptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected KotlinType outType;

    private static /* synthetic */ void $$$reportNull$$$0(int r100) {
        switch(r100) {
            case 4: goto L4;
            case 5: goto L4;
            case 6: goto L4;
            case 7: goto L4;
            case 8: goto L4;
            case 9: goto L4;
            case 10: goto L4;
            default: goto L3;
        };
    L3:
        String r101 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r100) {
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L8;
            case 8: goto L8;
            case 9: goto L8;
            case 10: goto L8;
            default: goto L7;
        };
    L7:
        int r102 = 3;
    L9:
        Object[] r103 = new Object[r102];
        switch(r100) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L12;
            case 6: goto L12;
            case 7: goto L12;
            case 8: goto L12;
            case 9: goto L12;
            case 10: goto L12;
            default: goto L11;
        };
    L11:
        r103[0] = "containingDeclaration";
    L17:
        switch(r100) {
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L22;
            case 8: goto L21;
            case 9: goto L20;
            case 10: goto L19;
            default: goto L18;
        };
    L18:
        r103[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
    L26:
        switch(r100) {
            case 4: goto L28;
            case 5: goto L28;
            case 6: goto L28;
            case 7: goto L28;
            case 8: goto L28;
            case 9: goto L28;
            case 10: goto L28;
            default: goto L27;
        };
    L27:
        r103[2] = "<init>";
    L28:
        String r104 = String.format(r101, r103);
        switch(r100) {
            case 4: goto L32;
            case 5: goto L32;
            case 6: goto L32;
            case 7: goto L32;
            case 8: goto L32;
            case 9: goto L32;
            case 10: goto L32;
            default: goto L33;
        };
    L33:
        throw new IllegalArgumentException(r104);
    L32:
        throw new IllegalStateException(r104);
    L19:
        r103[1] = "getReturnType";
        goto L26
    L20:
        r103[1] = "getContextReceiverParameters";
        goto L26
    L21:
        r103[1] = "getTypeParameters";
        goto L26
    L22:
        r103[1] = "getOverriddenDescriptors";
        goto L26
    L23:
        r103[1] = "getValueParameters";
        goto L26
    L24:
        r103[1] = "getOriginal";
        goto L26
    L25:
        r103[1] = "getType";
        goto L26
    L12:
        r103[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
        goto L17
    L13:
        r103[0] = "source";
        goto L17
    L14:
        r103[0] = "name";
        goto L17
    L15:
        r103[0] = "annotations";
        goto L17
    L8:
        r102 = 2;
        goto L9
    L4:
        r101 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return null;
    }

    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return null;
    }

    public <V> V getUserData(CallableDescriptor.UserDataKey<V> r100) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return false;
    }

    public boolean isConst() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueDescriptor
    public KotlinType getType() {
        KotlinType r100 = this.outType;
        if (r100 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return r100;
    }

    public List<ReceiverParameterDescriptor> getContextReceiverParameters() {
        List<ReceiverParameterDescriptor> r100 = Collections.emptyList();
        if (r100 != null) goto L5;
        $$$reportNull$$$0(9);
    L5:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public VariableDescriptor getOriginal() {
        VariableDescriptor r100 = (VariableDescriptor) super.getOriginal();
        if (r100 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return r100;
    }

    public Collection<? extends CallableDescriptor> getOverriddenDescriptors() {
        Set r100 = Collections.emptySet();
        if (r100 != null) goto L5;
        $$$reportNull$$$0(7);
    L5:
        return r100;
    }

    public KotlinType getReturnType() {
        KotlinType r100 = getType();
        if (r100 != null) goto L5;
        $$$reportNull$$$0(10);
    L5:
        return r100;
    }

    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> r100 = Collections.emptyList();
        if (r100 != null) goto L5;
        $$$reportNull$$$0(8);
    L5:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<ValueParameterDescriptor> getValueParameters() {
        List<ValueParameterDescriptor> r100 = Collections.emptyList();
        if (r100 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        return r100;
    }

    static {
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableDescriptor getOriginal() {
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

    public void setOutType(KotlinType r100) {
        this.outType = r100;
    }

    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor r100) {
        return substitute(r100);
    }

    public VariableDescriptorImpl(DeclarationDescriptor r100, Annotations r101, Name r102, KotlinType r103, SourceElement r104) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r102 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r104 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        super(r100, r101, r102, r104);
        this.outType = r103;
    }
}
