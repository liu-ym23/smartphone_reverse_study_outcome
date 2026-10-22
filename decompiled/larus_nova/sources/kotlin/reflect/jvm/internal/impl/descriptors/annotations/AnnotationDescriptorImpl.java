package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes42.dex */
public class AnnotationDescriptorImpl implements AnnotationDescriptor {
    private final KotlinType annotationType;
    private final SourceElement source;
    private final Map<Name, ConstantValue<?>> valueArguments;

    private static /* synthetic */ void $$$reportNull$$$0(int r110) {
        if (r110 == 3) goto L7;
        if (r110 == 4) goto L7;
        if (r110 == 5) goto L7;
        String r100 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r110 == 3) goto L13;
        if (r110 == 4) goto L13;
        if (r110 == 5) goto L13;
        int r101 = 3;
    L14:
        Object[] r102 = new Object[r101];
        if (r110 == 1) goto L23;
        if (r110 == 2) goto L22;
        if (r110 == 3) goto L21;
        if (r110 == 4) goto L21;
        if (r110 == 5) goto L21;
        r102[0] = "annotationType";
    L24:
        if (r110 == 3) goto L30;
        if (r110 == 4) goto L29;
        if (r110 == 5) goto L28;
        r102[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
    L31:
        if (r110 == 3) goto L35;
        if (r110 == 4) goto L35;
        if (r110 == 5) goto L35;
        r102[2] = "<init>";
    L35:
        String r103 = String.format(r100, r102);
        if (r110 == 3) goto L41;
        if (r110 == 4) goto L41;
        if (r110 == 5) goto L41;
        throw new IllegalArgumentException(r103);
    L41:
        throw new IllegalStateException(r103);
    L28:
        r102[1] = "getSource";
        goto L31
    L29:
        r102[1] = "getAllValueArguments";
        goto L31
    L30:
        r102[1] = "getType";
    L21:
        r102[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        goto L24
    L22:
        r102[0] = "source";
        goto L24
    L23:
        r102[0] = "valueArguments";
    L13:
        r101 = 2;
    L7:
        r100 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public Map<Name, ConstantValue<?>> getAllValueArguments() {
        Map<Name, ConstantValue<?>> r100 = this.valueArguments;
        if (r100 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public SourceElement getSource() {
        SourceElement r100 = this.source;
        if (r100 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public KotlinType getType() {
        KotlinType r100 = this.annotationType;
        if (r100 != null) goto L5;
        $$$reportNull$$$0(3);
    L5:
        return r100;
    }

    public String toString() {
        return DescriptorRenderer.FQ_NAMES_IN_TYPES.renderAnnotation(this, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public FqName getFqName() {
        return AnnotationDescriptor.DefaultImpls.getFqName(this);
    }

    public AnnotationDescriptorImpl(KotlinType r100, Map<Name, ConstantValue<?>> r101, SourceElement r102) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r102 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        this.annotationType = r100;
        this.valueArguments = r101;
        this.source = r102;
    }
}
