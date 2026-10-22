package kotlin.reflect.jvm.internal.impl.load.java.structure;

/* JADX INFO: loaded from: classes42.dex */
public final class JavaTypesKt {
    public static final boolean isSuperWildcard(JavaType r100) {
        if ((r100 instanceof JavaWildcardType) == false) goto L5;
        JavaWildcardType r101 = (JavaWildcardType) r100;
    L7:
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.getBound() != null) goto L11;
        return false;
    L11:
        if (r101.isExtends() == false) goto L13;
        return false;
    L13:
        return true;
    L5:
        r101 = null;
        goto L7
    }
}
