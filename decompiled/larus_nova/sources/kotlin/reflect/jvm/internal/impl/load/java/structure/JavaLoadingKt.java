package kotlin.reflect.jvm.internal.impl.load.java.structure;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes42.dex */
public final class JavaLoadingKt {
    private static final boolean isMethodWithOneObjectParameter(JavaMethod r100) {
        JavaValueParameter r101 = (JavaValueParameter) CollectionsKt.singleOrNull(r100.getValueParameters());
        JavaClassifierType r102 = null;
        if (r101 == null) goto L5;
        JavaType r103 = r101.getType();
    L7:
        if ((r103 instanceof JavaClassifierType) == false) goto L10;
        r102 = (JavaClassifierType) r103;
    L10:
        if (r102 != null) goto L12;
        return false;
    L12:
        JavaClassifier r104 = r102.getClassifier();
        if ((r104 instanceof JavaClass) == false) goto L20;
        FqName r105 = ((JavaClass) r104).getFqName();
        if (r105 != null) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(r105.asString(), "java.lang.Object") == false) goto L22;
        return true;
    L22:
        return false;
    L20:
        return false;
    L5:
        r103 = null;
        goto L7
    }

    private static final boolean isObjectMethod(JavaMethod r100) {
        String r101 = r100.getName().asString();
        int r102 = r101.hashCode();
        if (r102 == (-1776922004)) goto L17;
        if (r102 == (-1295482945)) goto L13;
        if (r102 == 147696667) goto L10;
    L19:
        return false;
    L10:
        if (r101.equals("hashCode") == false) goto L19;
    L22:
        return r100.getValueParameters().isEmpty();
    L13:
        if (r101.equals("equals") == false) goto L19;
        return isMethodWithOneObjectParameter(r100);
    L17:
        if (r101.equals("toString") == false) goto L19;
        goto L19
    }

    public static final boolean isObjectMethodInInterface(JavaMember r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getContainingClass().isInterface() == true) goto L5;
    L9:
        return false;
    L5:
        if ((r100 instanceof JavaMethod) == false) goto L9;
        if (isObjectMethod((JavaMethod) r100) == false) goto L9;
        return true;
    }
}
