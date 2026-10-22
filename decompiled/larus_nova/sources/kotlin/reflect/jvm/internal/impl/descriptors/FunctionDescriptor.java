package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* JADX INFO: loaded from: classes5.dex */
public interface FunctionDescriptor extends CallableMemberDescriptor {

    public interface CopyBuilder<D extends FunctionDescriptor> {
        D build();

        <V> CopyBuilder<D> putUserData(CallableDescriptor.UserDataKey<V> r100, V r101);

        CopyBuilder<D> setAdditionalAnnotations(Annotations r100);

        CopyBuilder<D> setCopyOverrides(boolean r100);

        CopyBuilder<D> setDispatchReceiverParameter(ReceiverParameterDescriptor r100);

        CopyBuilder<D> setDropOriginalInContainingParts();

        CopyBuilder<D> setExtensionReceiverParameter(ReceiverParameterDescriptor r100);

        CopyBuilder<D> setHiddenForResolutionEverywhereBesideSupercalls();

        CopyBuilder<D> setHiddenToOvercomeSignatureClash();

        CopyBuilder<D> setKind(CallableMemberDescriptor.Kind r100);

        CopyBuilder<D> setModality(Modality r100);

        CopyBuilder<D> setName(Name r100);

        CopyBuilder<D> setOriginal(CallableMemberDescriptor r100);

        CopyBuilder<D> setOwner(DeclarationDescriptor r100);

        CopyBuilder<D> setPreserveSourceElement();

        CopyBuilder<D> setReturnType(KotlinType r100);

        CopyBuilder<D> setSignatureChange();

        CopyBuilder<D> setSubstitution(TypeSubstitution r100);

        CopyBuilder<D> setTypeParameters(List<TypeParameterDescriptor> r100);

        CopyBuilder<D> setValueParameters(List<ValueParameterDescriptor> r100);

        CopyBuilder<D> setVisibility(DescriptorVisibility r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    DeclarationDescriptor getContainingDeclaration();

    FunctionDescriptor getInitialSignatureDescriptor();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    FunctionDescriptor getOriginal();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    Collection<? extends FunctionDescriptor> getOverriddenDescriptors();

    boolean isHiddenForResolutionEverywhereBesideSupercalls();

    boolean isHiddenToOvercomeSignatureClash();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    boolean isSuspend();

    boolean isTailrec();

    CopyBuilder<? extends FunctionDescriptor> newCopyBuilder();

    FunctionDescriptor substitute(TypeSubstitutor r100);
}
