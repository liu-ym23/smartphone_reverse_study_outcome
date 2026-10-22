package mz0;

import com.bytedance.android.livesdk.log.filter.v;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes47.dex */
public final class d {
    public static final e<?> b(LogCommon r100) {
        Intrinsics.checkNotNullParameter(r100, "logCommon");
        cy0.e.f465759a.getClass();
        cy0.j r101 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r102 = com.bytedance.android.scope.m.b(r101).a(Reflection.getOrCreateKotlinClass(c.class));
        Intrinsics.checkNotNull(r102);
        return ((c) ((f80.a) r102)).W2(r100);
    }

    public static final void c(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueId");
        cy0.e.f465759a.getClass();
        cy0.j r101 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r102 = com.bytedance.android.scope.m.b(r101).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r102);
        ((i) ((f80.a) r102)).removeSendLogFilter(r100);
    }

    public static final void a(Object r100, v r101) {
        Intrinsics.checkNotNullParameter(r100, "uniqueId");
        Intrinsics.checkNotNullParameter(r101, "filter");
        cy0.e.f465759a.getClass();
        cy0.j r102 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r103 = com.bytedance.android.scope.m.b(r102).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r103);
        ((i) ((f80.a) r103)).addSendLogFilter(r100, r101);
    }
}
