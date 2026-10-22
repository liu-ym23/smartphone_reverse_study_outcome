package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;

/* JADX INFO: loaded from: classes5.dex */
public interface JavaClassesTracker {

    public static final class Default implements JavaClassesTracker {
        public static final Default INSTANCE = null;

        static {
            INSTANCE = new Default();
        }

        private Default() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker
        public void reportClass(JavaClassDescriptor r100) {
            Intrinsics.checkNotNullParameter(r100, "classDescriptor");
        }
    }

    void reportClass(JavaClassDescriptor r100);
}
