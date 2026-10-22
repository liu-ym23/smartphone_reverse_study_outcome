package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: loaded from: classes5.dex */
public class ImplicitClassReceiver implements ImplicitReceiver, ThisClassReceiver {
    private final ClassDescriptor classDescriptor;
    private final ClassDescriptor declarationDescriptor;
    private final ImplicitClassReceiver original;

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
    public SimpleType getType() {
        return this.classDescriptor.getDefaultType();
    }

    public int hashCode() {
        return this.classDescriptor.hashCode();
    }

    public String toString() {
        return "Class{" + getType() + '}';
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ThisClassReceiver
    public final ClassDescriptor getClassDescriptor() {
        return this.classDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
    public /* bridge */ /* synthetic */ KotlinType getType() {
        return getType();
    }

    public boolean equals(Object r100) {
        ClassDescriptor r101 = this.classDescriptor;
        ClassDescriptor r102 = null;
        if ((r100 instanceof ImplicitClassReceiver) == false) goto L5;
        ImplicitClassReceiver r103 = (ImplicitClassReceiver) r100;
    L6:
        if (r103 == null) goto L9;
        r102 = r103.classDescriptor;
    L9:
        return Intrinsics.areEqual(r101, r102);
    L5:
        r103 = null;
        goto L6
    }

    public ImplicitClassReceiver(ClassDescriptor r100, ImplicitClassReceiver r101) {
        Intrinsics.checkNotNullParameter(r100, "classDescriptor");
        this.classDescriptor = r100;
        if (r101 != null) goto L5;
        r101 = this;
    L5:
        this.original = r101;
        this.declarationDescriptor = r100;
    }
}
