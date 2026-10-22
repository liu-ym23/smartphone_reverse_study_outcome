package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: loaded from: classes5.dex */
public interface DeclarationDescriptorVisitor<R, D> {
    R visitClassDescriptor(ClassDescriptor r100, D r101);

    R visitConstructorDescriptor(ConstructorDescriptor r100, D r101);

    R visitFunctionDescriptor(FunctionDescriptor r100, D r101);

    R visitModuleDeclaration(ModuleDescriptor r100, D r101);

    R visitPackageFragmentDescriptor(PackageFragmentDescriptor r100, D r101);

    R visitPackageViewDescriptor(PackageViewDescriptor r100, D r101);

    R visitPropertyDescriptor(PropertyDescriptor r100, D r101);

    R visitPropertyGetterDescriptor(PropertyGetterDescriptor r100, D r101);

    R visitPropertySetterDescriptor(PropertySetterDescriptor r100, D r101);

    R visitReceiverParameterDescriptor(ReceiverParameterDescriptor r100, D r101);

    R visitTypeAliasDescriptor(TypeAliasDescriptor r100, D r101);

    R visitTypeParameterDescriptor(TypeParameterDescriptor r100, D r101);

    R visitValueParameterDescriptor(ValueParameterDescriptor r100, D r101);
}
