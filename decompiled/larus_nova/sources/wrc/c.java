package wrc;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final /* synthetic */ class c implements Function2 {
    public /* synthetic */ c() {
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object r100, Object r101) {
        Object r102 = (Comparable) r100;
        Object r103 = (Comparable) r101;
        Intrinsics.checkNotNullParameter(r102, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r103, "b");
        if ((r102 instanceof Number) == false) goto L10;
        if ((r103 instanceof Number) == false) goto L10;
        if (((Number) r102).doubleValue() > ((Number) r103).doubleValue()) goto L11;
    L12:
        boolean r104 = false;
    L14:
        return Boolean.valueOf(r104);
    L11:
        r104 = true;
    L10:
        if (r102.toString().compareTo(r103.toString()) <= 0) goto L12;
        goto L11
    }
}
