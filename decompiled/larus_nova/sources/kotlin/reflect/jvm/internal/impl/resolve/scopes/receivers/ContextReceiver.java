package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes42.dex */
public final class ContextReceiver extends AbstractReceiverValue implements ImplicitContextReceiver {
    private final Name customLabelName;
    private final CallableDescriptor declarationDescriptor;

    public String toString() {
        return "Cxt { " + getDeclarationDescriptor() + " }";
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitContextReceiver
    public Name getCustomLabelName() {
        return this.customLabelName;
    }

    public CallableDescriptor getDeclarationDescriptor() {
        return this.declarationDescriptor;
    }

    public ContextReceiver(CallableDescriptor r100, KotlinType r101, Name r102, ReceiverValue r103) {
        Intrinsics.checkNotNullParameter(r100, "declarationDescriptor");
        Intrinsics.checkNotNullParameter(r101, "receiverType");
        super(r101, r103);
        this.declarationDescriptor = r100;
        this.customLabelName = r102;
    }
}
