package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes5.dex */
public abstract class VariableDescriptorWithInitializerImpl extends VariableDescriptorImpl {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected NullableLazyValue<ConstantValue<?>> compileTimeInitializer;
    protected Function0<NullableLazyValue<ConstantValue<?>>> compileTimeInitializerFactory;
    private final boolean isVar;

    private static /* synthetic */ void $$$reportNull$$$0(int r100) {
        Object[] r101 = new Object[3];
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L11;
        if (r100 == 3) goto L10;
        if (r100 == 4) goto L9;
        if (r100 == 5) goto L9;
        r101[0] = "containingDeclaration";
    L13:
        r101[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl";
        if (r100 == 4) goto L18;
        if (r100 == 5) goto L17;
        r101[2] = "<init>";
    L20:
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r101));
    L17:
        r101[2] = "setCompileTimeInitializer";
        goto L20
    L18:
        r101[2] = "setCompileTimeInitializerFactory";
    L9:
        r101[0] = "compileTimeInitializerFactory";
        goto L13
    L10:
        r101[0] = "source";
        goto L13
    L11:
        r101[0] = "name";
        goto L13
    L12:
        r101[0] = "annotations";
        goto L13
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    /* JADX INFO: renamed from: getCompileTimeInitializer */
    public ConstantValue<?> mo10728getCompileTimeInitializer() {
        NullableLazyValue<ConstantValue<?>> r100 = this.compileTimeInitializer;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.invoke();
    }

    static {
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isVar() {
        return this.isVar;
    }

    public void setCompileTimeInitializerFactory(Function0<NullableLazyValue<ConstantValue<?>>> r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(4);
    L4:
        setCompileTimeInitializer(null, r100);
    }

    public void setCompileTimeInitializer(NullableLazyValue<ConstantValue<?>> r100, Function0<NullableLazyValue<ConstantValue<?>>> r101) {
        if (r101 != null) goto L4;
        $$$reportNull$$$0(5);
    L4:
        this.compileTimeInitializerFactory = r101;
        if (r100 != null) goto L8;
        r100 = r101.invoke();
    L8:
        this.compileTimeInitializer = r100;
    }

    public VariableDescriptorWithInitializerImpl(DeclarationDescriptor r100, Annotations r101, Name r102, KotlinType r110, boolean r111, SourceElement r112) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r102 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r112 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        super(r100, r101, r102, r110, r112);
        this.isVar = r111;
    }
}
