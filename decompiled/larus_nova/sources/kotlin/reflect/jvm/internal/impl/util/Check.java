package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* JADX INFO: loaded from: classes42.dex */
public interface Check {

    public static final class DefaultImpls {
        public static String invoke(Check r100, FunctionDescriptor r101) {
            Intrinsics.checkNotNullParameter(r101, "functionDescriptor");
            if (r100.check(r101) == false) goto L7;
            return null;
        L7:
            return r100.getDescription();
        }
    }

    boolean check(FunctionDescriptor r100);

    String getDescription();

    String invoke(FunctionDescriptor r100);
}
