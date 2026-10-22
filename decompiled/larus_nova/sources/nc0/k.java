package nc0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class k {
    public static final <T extends vh7.c<T>> vh7.c<T> a(vh7.c<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$flexInstance");
        if ((r100 instanceof vh7.e) == false) goto L9;
        Object r101 = ((vh7.e) r100).getFlexInstance();
        if (r101 == null) goto L8;
        return (vh7.c) r101;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.tools.kcp.modelx.runtime.FlexModel<T>");
    L9:
        return r100;
    }
}
