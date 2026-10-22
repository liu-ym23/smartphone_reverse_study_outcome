package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;

/* JADX INFO: loaded from: classes5.dex */
public interface ClassifierNamePolicy {

    public static final class FULLY_QUALIFIED implements ClassifierNamePolicy {
        public static final FULLY_QUALIFIED INSTANCE = null;

        static {
            INSTANCE = new FULLY_QUALIFIED();
        }

        private FULLY_QUALIFIED() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy
        public String renderClassifier(ClassifierDescriptor r100, DescriptorRenderer r101) {
            Intrinsics.checkNotNullParameter(r100, "classifier");
            Intrinsics.checkNotNullParameter(r101, "renderer");
            if ((r100 instanceof TypeParameterDescriptor) == false) goto L7;
            return r101.renderName(((TypeParameterDescriptor) r100).getName(), false);
        L7:
            return r101.renderFqName(DescriptorUtils.getFqName(r100));
        }
    }

    public static final class SHORT implements ClassifierNamePolicy {
        public static final SHORT INSTANCE = null;

        static {
            INSTANCE = new SHORT();
        }

        private SHORT() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor] */
        /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Named] */
        /* JADX WARN: Type inference failed for: r2v2, types: [kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor] */
        @Override // kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy
        public String renderClassifier(ClassifierDescriptor r100, DescriptorRenderer r101) {
            Intrinsics.checkNotNullParameter(r100, "classifier");
            Intrinsics.checkNotNullParameter(r101, "renderer");
            if ((r100 instanceof TypeParameterDescriptor) == true) goto L5;
            ArrayList r102 = new ArrayList();
        L7:
            r102.add(r100.getName());
            r100 = r100.getContainingDeclaration();
            if ((r100 instanceof ClassDescriptor) == true) goto L7;
            return RenderingUtilsKt.renderFqName(CollectionsKt.asReversedMutable(r102));
        L5:
            return r101.renderName(((TypeParameterDescriptor) r100).getName(), false);
        }
    }

    public static final class SOURCE_CODE_QUALIFIED implements ClassifierNamePolicy {
        public static final SOURCE_CODE_QUALIFIED INSTANCE = null;

        static {
            INSTANCE = new SOURCE_CODE_QUALIFIED();
        }

        private SOURCE_CODE_QUALIFIED() {
        }

        private final String qualifiedNameForSourceCode(ClassifierDescriptor r100) {
            String r101 = RenderingUtilsKt.render(r100.getName());
            if ((r100 instanceof TypeParameterDescriptor) == false) goto L5;
            return r101;
        L5:
            String r102 = qualifierName(r100.getContainingDeclaration());
            if (r102 != null) goto L8;
            return r101;
        L8:
            if (Intrinsics.areEqual(r102, "") == false) goto L10;
            return r101;
        L10:
            return r102 + '.' + r101;
        }

        private final String qualifierName(DeclarationDescriptor r100) {
            if ((r100 instanceof ClassDescriptor) == false) goto L6;
            return qualifiedNameForSourceCode((ClassifierDescriptor) r100);
        L6:
            if ((r100 instanceof PackageFragmentDescriptor) == true) goto L11;
            return null;
        L11:
            return RenderingUtilsKt.render(((PackageFragmentDescriptor) r100).getFqName().toUnsafe());
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy
        public String renderClassifier(ClassifierDescriptor r100, DescriptorRenderer r101) {
            Intrinsics.checkNotNullParameter(r100, "classifier");
            Intrinsics.checkNotNullParameter(r101, "renderer");
            return qualifiedNameForSourceCode(r100);
        }
    }

    String renderClassifier(ClassifierDescriptor r100, DescriptorRenderer r101);
}
