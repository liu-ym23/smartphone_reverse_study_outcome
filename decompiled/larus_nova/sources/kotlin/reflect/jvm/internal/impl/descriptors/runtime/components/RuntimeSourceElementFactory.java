package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaElement;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;

/* JADX INFO: loaded from: classes5.dex */
public final class RuntimeSourceElementFactory implements JavaSourceElementFactory {
    public static final RuntimeSourceElementFactory INSTANCE = null;

    /* JADX INFO: loaded from: classes42.dex */
    public static final class RuntimeSourceElement implements JavaSourceElement {
        private final ReflectJavaElement javaElement;

        public String toString() {
            return RuntimeSourceElement.class.getName() + ": " + getJavaElement();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement
        public /* bridge */ /* synthetic */ JavaElement getJavaElement() {
            return getJavaElement();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
        public SourceFile getContainingFile() {
            return SourceFile.NO_SOURCE_FILE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement
        public ReflectJavaElement getJavaElement() {
            return this.javaElement;
        }

        public RuntimeSourceElement(ReflectJavaElement r100) {
            Intrinsics.checkNotNullParameter(r100, "javaElement");
            this.javaElement = r100;
        }
    }

    static {
        INSTANCE = new RuntimeSourceElementFactory();
    }

    private RuntimeSourceElementFactory() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory
    public JavaSourceElement source(JavaElement r100) {
        Intrinsics.checkNotNullParameter(r100, "javaElement");
        return new RuntimeSourceElement((ReflectJavaElement) r100);
    }
}
