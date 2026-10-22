package yc9;

import com.larus.im.bean.message.UplinkFileEntity;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final /* synthetic */ class q0 implements Function1 {
    public /* synthetic */ q0() {
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        UplinkFileEntity r101 = (UplinkFileEntity) r100;
        Intrinsics.checkNotNullParameter(r101, "$this$calcCountIf");
        return Boolean.valueOf(n1.b(r101));
    }
}
