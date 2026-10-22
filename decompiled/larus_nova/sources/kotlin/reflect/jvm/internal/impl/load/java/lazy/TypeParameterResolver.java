package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;

/* JADX INFO: loaded from: classes5.dex */
public interface TypeParameterResolver {

    public static final class EMPTY implements TypeParameterResolver {
        public static final EMPTY INSTANCE = null;

        static {
            INSTANCE = new EMPTY();
        }

        private EMPTY() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver
        public TypeParameterDescriptor resolveTypeParameter(JavaTypeParameter r100) {
            Intrinsics.checkNotNullParameter(r100, "javaTypeParameter");
            return null;
        }
    }

    TypeParameterDescriptor resolveTypeParameter(JavaTypeParameter r100);
}
