package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: loaded from: classes42.dex */
public abstract class AbstractLazyTypeParameterDescriptor extends AbstractTypeParameterDescriptor {
    private static /* synthetic */ void $$$reportNull$$$0(int r100) {
        Object[] r101 = new Object[3];
        switch(r100) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        r101[0] = "storageManager";
    L11:
        r101[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractLazyTypeParameterDescriptor";
        r101[2] = "<init>";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r101));
    L5:
        r101[0] = "supertypeLoopChecker";
        goto L11
    L6:
        r101[0] = "source";
        goto L11
    L7:
        r101[0] = "variance";
        goto L11
    L8:
        r101[0] = "name";
        goto L11
    L9:
        r101[0] = "annotations";
        goto L11
    L10:
        r101[0] = "containingDeclaration";
        goto L11
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl
    public String toString() {
        Object[] r100 = new Object[3];
        String r101 = "";
        if (isReified() == false) goto L5;
        String r102 = "reified ";
    L6:
        r100[0] = r102;
        if (getVariance() == Variance.INVARIANT) goto L10;
        r101 = getVariance() + " ";
    L10:
        r100[1] = r101;
        r100[2] = getName();
        return String.format("%s%s%s", r100);
    L5:
        r102 = "";
        goto L6
    }

    public AbstractLazyTypeParameterDescriptor(StorageManager r100, DeclarationDescriptor r101, Annotations r102, Name r103, Variance r104, boolean r105, int r106, SourceElement r107, SupertypeLoopChecker r110) {
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
        super(r100, r101, r102, r103, r104, r105, r106, r107, r110);
    }
}
