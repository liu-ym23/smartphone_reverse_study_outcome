package l5;

import kotlin.jvm.internal.Intrinsics;
import m5.h1;

/* JADX INFO: loaded from: classes43.dex */
public final class c0 {
    public c0() {
    }

    public static void a(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "traceEvent");
        h1 r101 = r100.f507365a;
        Long r102 = b0.a(r101, "fe_send_call", "native_receive_call");
        if (r102 == null) goto L5;
        long r103 = r102.longValue();
        r100.f507366b.d("call_fe_to_native_duration", Long.valueOf(r103));
    L5:
        Long r104 = b0.a(r101, "fe_send_call", "fe_receive_callback");
        if (r104 == null) goto L9;
        long r105 = r104.longValue();
        r100.f507366b.d("total_duration", Long.valueOf(r105));
        return;
    }
}
