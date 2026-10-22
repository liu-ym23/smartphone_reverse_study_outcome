package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ClassDescriptorBase extends AbstractClassDescriptor {
    private final DeclarationDescriptor containingDeclaration;
    private final boolean isExternal;
    private final SourceElement source;

    private static /* synthetic */ void $$$reportNull$$$0(int r100) {
        if (r100 == 4) goto L6;
        if (r100 == 5) goto L6;
        String r101 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r100 == 4) goto L11;
        if (r100 == 5) goto L11;
        int r102 = 3;
    L12:
        Object[] r103 = new Object[r102];
        if (r100 == 1) goto L22;
        if (r100 == 2) goto L21;
        if (r100 == 3) goto L20;
        if (r100 == 4) goto L19;
        if (r100 == 5) goto L19;
        r103[0] = "storageManager";
    L23:
        if (r100 == 4) goto L27;
        if (r100 == 5) goto L26;
        r103[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
    L28:
        if (r100 == 4) goto L31;
        if (r100 == 5) goto L31;
        r103[2] = "<init>";
    L31:
        String r104 = String.format(r101, r103);
        if (r100 == 4) goto L36;
        if (r100 == 5) goto L36;
        throw new IllegalArgumentException(r104);
    L36:
        throw new IllegalStateException(r104);
    L26:
        r103[1] = "getSource";
        goto L28
    L27:
        r103[1] = "getContainingDeclaration";
    L19:
        r103[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        goto L23
    L20:
        r103[0] = "source";
        goto L23
    L21:
        r103[0] = "name";
        goto L23
    L22:
        r103[0] = "containingDeclaration";
    L11:
        r102 = 2;
    L6:
        r101 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor r100 = this.containingDeclaration;
        if (r100 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        SourceElement r100 = this.source;
        if (r100 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return r100;
    }

    public boolean isExternal() {
        return this.isExternal;
    }

    public ClassDescriptorBase(StorageManager r100, DeclarationDescriptor r101, Name r102, SourceElement r103, boolean r104) {
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
        super(r100, r102);
        this.containingDeclaration = r101;
        this.source = r103;
        this.isExternal = r104;
    }
}
