package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitClassReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;

/* JADX INFO: loaded from: classes5.dex */
public class LazyClassReceiverParameterDescriptor extends AbstractReceiverParameterDescriptor {
    private final ClassDescriptor descriptor;
    private final ImplicitClassReceiver receiverValue;

    private static /* synthetic */ void $$$reportNull$$$0(int r100) {
        if (r100 == 1) goto L6;
        if (r100 == 2) goto L6;
        String r101 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L11;
        int r102 = 3;
    L12:
        Object[] r103 = new Object[r102];
        if (r100 == 1) goto L18;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L17;
        r103[0] = "descriptor";
    L19:
        if (r100 == 1) goto L23;
        if (r100 == 2) goto L22;
        r103[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
    L24:
        if (r100 == 1) goto L29;
        if (r100 == 2) goto L29;
        if (r100 == 3) goto L28;
        r103[2] = "<init>";
        goto L29
    L28:
        r103[2] = "copy";
    L29:
        String r104 = String.format(r101, r103);
        if (r100 == 1) goto L34;
        if (r100 == 2) goto L34;
        throw new IllegalArgumentException(r104);
    L34:
        throw new IllegalStateException(r104);
    L22:
        r103[1] = "getContainingDeclaration";
        goto L24
    L23:
        r103[1] = "getValue";
        goto L24
    L17:
        r103[0] = "newOwner";
    L18:
        r103[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
    L11:
        r102 = 2;
    L6:
        r101 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        ClassDescriptor r100 = this.descriptor;
        if (r100 != null) goto L5;
        $$$reportNull$$$0(2);
    L5:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor
    public ReceiverValue getValue() {
        ImplicitClassReceiver r100 = this.receiverValue;
        if (r100 != null) goto L5;
        $$$reportNull$$$0(1);
    L5:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl
    public String toString() {
        return "class " + this.descriptor.getName() + "::this";
    }

    public LazyClassReceiverParameterDescriptor(ClassDescriptor r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        super(Annotations.Companion.getEMPTY());
        this.descriptor = r100;
        this.receiverValue = new ImplicitClassReceiver(r100, null);
    }
}
