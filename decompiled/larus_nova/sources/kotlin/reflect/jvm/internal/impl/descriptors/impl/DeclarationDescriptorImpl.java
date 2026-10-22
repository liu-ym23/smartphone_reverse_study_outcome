package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DeclarationDescriptorImpl extends AnnotatedImpl implements DeclarationDescriptor {
    private final Name name;

    private static /* synthetic */ void $$$reportNull$$$0(int r100) {
        if (r100 == 2) goto L8;
        if (r100 == 3) goto L8;
        if (r100 == 5) goto L8;
        if (r100 == 6) goto L8;
        String r101 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L14;
        if (r100 == 5) goto L14;
        if (r100 == 6) goto L14;
        int r102 = 3;
    L15:
        Object[] r103 = new Object[r102];
        switch(r100) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L19;
            case 6: goto L19;
            default: goto L17;
        };
    L17:
        r103[0] = "annotations";
    L22:
        if (r100 == 2) goto L29;
        if (r100 == 3) goto L28;
        if (r100 == 5) goto L27;
        if (r100 == 6) goto L27;
        r103[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
    L30:
        if (r100 == 2) goto L38;
        if (r100 == 3) goto L38;
        if (r100 == 4) goto L37;
        if (r100 == 5) goto L38;
        if (r100 == 6) goto L38;
        r103[2] = "<init>";
        goto L38
    L37:
        r103[2] = "toString";
    L38:
        String r104 = String.format(r101, r103);
        if (r100 == 2) goto L45;
        if (r100 == 3) goto L45;
        if (r100 == 5) goto L45;
        if (r100 == 6) goto L45;
        throw new IllegalArgumentException(r104);
    L45:
        throw new IllegalStateException(r104);
    L27:
        r103[1] = "toString";
        goto L30
    L28:
        r103[1] = "getOriginal";
        goto L30
    L29:
        r103[1] = "getName";
        goto L30
    L18:
        r103[0] = "descriptor";
        goto L22
    L19:
        r103[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
        goto L22
    L20:
        r103[0] = "name";
    L14:
        r102 = 2;
    L8:
        r101 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    public DeclarationDescriptor getOriginal() {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Named
    public Name getName() {
        Name r100 = this.name;
        if (r100 != null) goto L5;
        $$$reportNull$$$0(2);
    L5:
        return r100;
    }

    public String toString() {
        return toString(this);
    }

    public static String toString(DeclarationDescriptor r100) {
        if (r100 != null) goto L12;
        $$$reportNull$$$0(4);
    L12:
        String r101 = DescriptorRenderer.DEBUG_TEXT.render(r100) + "[" + r100.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(r100)) + "]";     // Catch: Throwable -> L8
        if (r101 != null) goto L7;
        $$$reportNull$$$0(5);
    L7:
        return r101;
    L8:
        String r102 = r100.getClass().getSimpleName() + " " + r100.getName();
        if (r102 != null) goto L11;
        $$$reportNull$$$0(6);
    L11:
        return r102;
    }

    public DeclarationDescriptorImpl(Annotations r100, Name r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        super(r100);
        this.name = r101;
    }
}
