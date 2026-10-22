package qh8;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class j implements Function1 {
    public /* synthetic */ j() {
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        String r101 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "imageUrl");
        if (k.a(r101) == true) goto L5;
        return r101;
    L5:
        return "res:///2131240745";
    }
}
