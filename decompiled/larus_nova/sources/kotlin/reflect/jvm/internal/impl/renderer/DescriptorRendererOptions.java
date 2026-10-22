package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Set;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes5.dex */
public interface DescriptorRendererOptions {

    /* JADX INFO: loaded from: classes42.dex */
    public static final class DefaultImpls {
        public static boolean getIncludeAnnotationArguments(DescriptorRendererOptions r100) {
            return r100.getAnnotationArgumentsRenderingPolicy().getIncludeAnnotationArguments();
        }

        public static boolean getIncludeEmptyAnnotationArguments(DescriptorRendererOptions r100) {
            return r100.getAnnotationArgumentsRenderingPolicy().getIncludeEmptyAnnotationArguments();
        }
    }

    AnnotationArgumentsRenderingPolicy getAnnotationArgumentsRenderingPolicy();

    boolean getDebugMode();

    boolean getEnhancedTypes();

    Set<FqName> getExcludedTypeAnnotationClasses();

    boolean getIncludeAnnotationArguments();

    boolean getIncludeEmptyAnnotationArguments();

    void setAnnotationArgumentsRenderingPolicy(AnnotationArgumentsRenderingPolicy r100);

    void setClassifierNamePolicy(ClassifierNamePolicy r100);

    void setDebugMode(boolean r100);

    void setExcludedTypeAnnotationClasses(Set<FqName> r100);

    void setModifiers(Set<? extends DescriptorRendererModifier> r100);

    void setParameterNameRenderingPolicy(ParameterNameRenderingPolicy r100);

    void setReceiverAfterName(boolean r100);

    void setRenderCompanionObjectName(boolean r100);

    void setStartFromName(boolean r100);

    void setTextFormat(RenderingFormat r100);

    void setVerbose(boolean r100);

    void setWithDefinedIn(boolean r100);

    void setWithoutSuperTypes(boolean r100);

    void setWithoutTypeParameters(boolean r100);
}
