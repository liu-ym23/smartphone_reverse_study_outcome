package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;

/* JADX INFO: loaded from: classes5.dex */
public final class RuntimeErrorReporter implements ErrorReporter {
    public static final RuntimeErrorReporter INSTANCE = null;

    static {
        INSTANCE = new RuntimeErrorReporter();
    }

    private RuntimeErrorReporter() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter
    public void reportCannotInferVisibility(CallableMemberDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        throw new IllegalStateException("Cannot infer visibility for " + r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter
    public void reportIncompleteHierarchy(ClassDescriptor r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        Intrinsics.checkNotNullParameter(r101, "unresolvedSuperClasses");
        throw new IllegalStateException("Incomplete hierarchy for class " + r100.getName() + ", unresolved classes " + r101);
    }
}
