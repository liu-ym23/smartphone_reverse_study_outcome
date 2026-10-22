package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes42.dex */
public final class ReflectJavaAnnotationOwnerKt {
    public static final List<ReflectJavaAnnotation> getAnnotations(Annotation[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ArrayList r101 = new ArrayList(r100.length);
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.add(new ReflectJavaAnnotation(r100[r103]));
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    public static final ReflectJavaAnnotation findAnnotation(Annotation[] r100, FqName r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "fqName");
        int r102 = r100.length;
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L9;
        Annotation r104 = r100[r103];
        if (Intrinsics.areEqual(ReflectClassUtilKt.getClassId(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(r104))).asSingleFqName(), r101) == true) goto L10;
        r103 = r103 + 1;
    L10:
        if (r104 != null) goto L12;
        return null;
    L12:
        return new ReflectJavaAnnotation(r104);
    L9:
        r104 = null;
        goto L10
    }
}
