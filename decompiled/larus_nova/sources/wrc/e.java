package wrc;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final /* synthetic */ class e implements Function2 {
    public /* synthetic */ e() {
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object r100, Object r101) {
        Comparable r102 = (Comparable) r100;
        Comparable r103 = (Comparable) r101;
        Intrinsics.checkNotNullParameter(r102, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r103, "b");
        return Boolean.valueOf(urc.g.b(r102, r103, false));
    }
}
