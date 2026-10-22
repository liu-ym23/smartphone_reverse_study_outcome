package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes5.dex */
public /* synthetic */ class JavaClassFinder$$Util {
    public static /* synthetic */ JavaPackage findPackage$default(JavaClassFinder r100, FqName r101, boolean r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L7;
        r102 = true;
    L7:
        return r100.findPackage(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findPackage");
    }
}
