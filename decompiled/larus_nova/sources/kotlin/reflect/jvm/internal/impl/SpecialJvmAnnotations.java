package kotlin.reflect.jvm.internal.impl;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes42.dex */
public final class SpecialJvmAnnotations {
    public static final SpecialJvmAnnotations INSTANCE = null;
    private static final ClassId JAVA_LANG_ANNOTATION_REPEATABLE = null;
    private static final Set<ClassId> SPECIAL_ANNOTATIONS = null;

    private SpecialJvmAnnotations() {
    }

    static {
        INSTANCE = new SpecialJvmAnnotations();
        List r100 = CollectionsKt.listOf(new FqName[]{JvmAnnotationNames.METADATA_FQ_NAME, JvmAnnotationNames.JETBRAINS_NOT_NULL_ANNOTATION, JvmAnnotationNames.JETBRAINS_NULLABLE_ANNOTATION, JvmAnnotationNames.TARGET_ANNOTATION, JvmAnnotationNames.RETENTION_ANNOTATION, JvmAnnotationNames.DOCUMENTED_ANNOTATION});
        LinkedHashSet r101 = new LinkedHashSet();
        ClassId.Companion r102 = ClassId.Companion;
        Iterator r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r101.add(r102.topLevel((FqName) r103.next()));
        goto L4
    L6:
        SPECIAL_ANNOTATIONS = r101;
        JAVA_LANG_ANNOTATION_REPEATABLE = ClassId.Companion.topLevel(JvmAnnotationNames.REPEATABLE_ANNOTATION);
    }

    public final ClassId getJAVA_LANG_ANNOTATION_REPEATABLE() {
        return JAVA_LANG_ANNOTATION_REPEATABLE;
    }

    public final Set<ClassId> getSPECIAL_ANNOTATIONS() {
        return SPECIAL_ANNOTATIONS;
    }

    public final boolean isAnnotatedWithContainerMetaAnnotation(KotlinJvmBinaryClass r100) {
        Intrinsics.checkNotNullParameter(r100, "klass");
        final Ref.BooleanRef r101 = new Ref.BooleanRef();
        r100.loadClassAnnotations(new AnonymousClass1(r101), null);
        return r101.element;
    }
}
