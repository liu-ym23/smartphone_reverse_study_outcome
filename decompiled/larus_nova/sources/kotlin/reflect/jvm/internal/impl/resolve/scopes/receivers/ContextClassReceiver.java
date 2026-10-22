package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes42.dex */
public final class ContextClassReceiver extends AbstractReceiverValue implements ImplicitContextReceiver {
    private final ClassDescriptor classDescriptor;
    private final Name customLabelName;

    public String toString() {
        return getType() + ": Ctx { " + this.classDescriptor + " }";
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitContextReceiver
    public Name getCustomLabelName() {
        return this.customLabelName;
    }

    public ContextClassReceiver(ClassDescriptor r100, KotlinType r101, Name r102, ReceiverValue r103) {
        Intrinsics.checkNotNullParameter(r100, "classDescriptor");
        Intrinsics.checkNotNullParameter(r101, "receiverType");
        super(r101, r103);
        this.classDescriptor = r100;
        this.customLabelName = r102;
    }
}
