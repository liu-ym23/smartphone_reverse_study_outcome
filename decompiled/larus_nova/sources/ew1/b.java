package ew1;

import com.alipay.sdk.m.p.e;
import com.bytedance.android.live.core.utils.f0;
import com.bytedance.crash.d;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b {
    static {
    }

    @JvmStatic
    public static final void a(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, e.f25671s);
        Intrinsics.checkNotNullParameter(r101, "error");
        int r102 = f0.f66132a;
        String r103 = "DrawerHistoryExpCollect->".concat(r100);
        Intrinsics.checkNotNullParameter(r103, "message");
        Intrinsics.checkNotNullParameter(r101, "error");
        d.d(r101, r103);
    }
}
