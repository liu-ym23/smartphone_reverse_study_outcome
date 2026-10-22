package yz0;

import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.v;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class p {
    public static final void a(com.bytedance.android.live.revenue.core.b r100, Function1<? super o, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "block");
        if (r100 != null) goto L8;
        IllegalStateException r102 = new IllegalStateException("RevenueInstance is null");
        SafetyGuard.a(null, r102, "RoomStateService error handler");
        if (v.b() == true) goto L7;
        return;
    L7:
        throw r102;
    L8:
        boolean r103 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        o r104 = (o) com.bytedance.android.live.revenue.core.util.h.b(r100, o.class);
        if (r104 != null) goto L14;
        IllegalStateException r105 = new IllegalStateException("Attached service is not found, isScopeEntered = " + com.bytedance.android.scope.l.b(r100.e()));
        SafetyGuard.a(null, r105, "RoomStateService error handler");
        if (v.b() == true) goto L13;
        return;
    L13:
        throw r105;
    L14:
        r101.invoke(r104);
    }
}
