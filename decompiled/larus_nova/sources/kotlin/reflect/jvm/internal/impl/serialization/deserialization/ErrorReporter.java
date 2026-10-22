package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;

/* JADX INFO: loaded from: classes5.dex */
public interface ErrorReporter {
    public static final ErrorReporter DO_NOTHING = null;

    void reportCannotInferVisibility(CallableMemberDescriptor r100);

    void reportIncompleteHierarchy(ClassDescriptor r100, List<String> r101);

    static {
        DO_NOTHING = new AnonymousClass1();
    }
}
