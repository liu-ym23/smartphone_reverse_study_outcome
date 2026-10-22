package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DeclarationDescriptorNonRootImpl extends DeclarationDescriptorImpl implements DeclarationDescriptorNonRoot {
    private final DeclarationDescriptor containingDeclaration;
    private final SourceElement source;

    private static /* synthetic */ void $$$reportNull$$$0(int r100) {
        if (r100 == 4) goto L7;
        if (r100 == 5) goto L7;
        if (r100 == 6) goto L7;
        String r101 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r100 == 4) goto L13;
        if (r100 == 5) goto L13;
        if (r100 == 6) goto L13;
        int r102 = 3;
    L14:
        Object[] r103 = new Object[r102];
        switch(r100) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L17;
            case 6: goto L17;
            default: goto L16;
        };
    L16:
        r103[0] = "containingDeclaration";
    L22:
        if (r100 == 4) goto L28;
        if (r100 == 5) goto L27;
        if (r100 == 6) goto L26;
        r103[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
    L29:
        if (r100 == 4) goto L33;
        if (r100 == 5) goto L33;
        if (r100 == 6) goto L33;
        r103[2] = "<init>";
    L33:
        String r104 = String.format(r101, r103);
        if (r100 == 4) goto L39;
        if (r100 == 5) goto L39;
        if (r100 == 6) goto L39;
        throw new IllegalArgumentException(r104);
    L39:
        throw new IllegalStateException(r104);
    L26:
        r103[1] = "getSource";
        goto L29
    L27:
        r103[1] = "getContainingDeclaration";
        goto L29
    L28:
        r103[1] = "getOriginal";
        goto L29
    L17:
        r103[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
        goto L22
    L18:
        r103[0] = "source";
        goto L22
    L19:
        r103[0] = "name";
        goto L22
    L20:
        r103[0] = "annotations";
    L13:
        r102 = 2;
    L7:
        r101 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor r100 = this.containingDeclaration;
        if (r100 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        SourceElement r100 = this.source;
        if (r100 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public DeclarationDescriptorWithSource getOriginal() {
        DeclarationDescriptorWithSource r100 = (DeclarationDescriptorWithSource) super.getOriginal();
        if (r100 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    public DeclarationDescriptorNonRootImpl(DeclarationDescriptor r100, Annotations r101, Name r102, SourceElement r103) {
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
        super(r101, r102);
        this.containingDeclaration = r100;
        this.source = r103;
    }
}
