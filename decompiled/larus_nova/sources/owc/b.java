package owc;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class b {
    public static kwc.a a(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "moduleDeclaration");
        kwc.a r101 = new kwc.a(false, false);
        r100.invoke(r101);
        return r101;
    }
}
