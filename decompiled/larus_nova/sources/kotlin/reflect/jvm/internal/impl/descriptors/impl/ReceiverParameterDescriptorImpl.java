package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;

/* JADX INFO: loaded from: classes42.dex */
public class ReceiverParameterDescriptorImpl extends AbstractReceiverParameterDescriptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final DeclarationDescriptor containingDeclaration;
    private ReceiverValue value;

    private static /* synthetic */ void $$$reportNull$$$0(int r100) {
        if (r100 == 7) goto L6;
        if (r100 == 8) goto L6;
        String r101 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r100 == 7) goto L11;
        if (r100 == 8) goto L11;
        int r102 = 3;
    L12:
        Object[] r103 = new Object[r102];
        switch(r100) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L14;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            case 8: goto L17;
            case 9: goto L16;
            case 10: goto L15;
            default: goto L14;
        };
    L14:
        r103[0] = "containingDeclaration";
    L22:
        if (r100 == 7) goto L26;
        if (r100 == 8) goto L25;
        r103[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
    L27:
        switch(r100) {
            case 7: goto L31;
            case 8: goto L31;
            case 9: goto L30;
            case 10: goto L29;
            default: goto L28;
        };
    L28:
        r103[2] = "<init>";
        goto L31
    L29:
        r103[2] = "setOutType";
        goto L31
    L30:
        r103[2] = "copy";
    L31:
        String r104 = String.format(r101, r103);
        if (r100 == 7) goto L36;
        if (r100 == 8) goto L36;
        throw new IllegalArgumentException(r104);
    L36:
        throw new IllegalStateException(r104);
    L25:
        r103[1] = "getContainingDeclaration";
        goto L27
    L26:
        r103[1] = "getValue";
        goto L27
    L15:
        r103[0] = "outType";
        goto L22
    L16:
        r103[0] = "newOwner";
        goto L22
    L17:
        r103[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        goto L22
    L18:
        r103[0] = "name";
        goto L22
    L19:
        r103[0] = "annotations";
        goto L22
    L20:
        r103[0] = "value";
    L11:
        r102 = 2;
    L6:
        r101 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor r100 = this.containingDeclaration;
        if (r100 != null) goto L5;
        $$$reportNull$$$0(8);
    L5:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor
    public ReceiverValue getValue() {
        ReceiverValue r100 = this.value;
        if (r100 != null) goto L5;
        $$$reportNull$$$0(7);
    L5:
        return r100;
    }

    static {
    }

    public ReceiverParameterDescriptorImpl(DeclarationDescriptor r100, ReceiverValue r101, Annotations r102) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r102 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        this(r100, r101, r102, SpecialNames.THIS);
    }

    public ReceiverParameterDescriptorImpl(DeclarationDescriptor r100, ReceiverValue r101, Annotations r102, Name r103) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(3);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(4);
    L6:
        if (r102 != null) goto L8;
        $$$reportNull$$$0(5);
    L8:
        if (r103 != null) goto L10;
        $$$reportNull$$$0(6);
    L10:
        super(r102, r103);
        this.containingDeclaration = r100;
        this.value = r101;
    }
}
