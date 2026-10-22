package ej6;

import com.bytedance.android.scope.m;
import cy0.j;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.n;

/* JADX INFO: loaded from: classes19.dex */
public final class d {
    static {
    }

    public static void a(Map r100) {
        Intrinsics.checkNotNullParameter("livesdk_livelink_link_performance", "eventName");
        n r101 = new n();
        Map<String, String> r102 = r101.f516447a;
        Intrinsics.checkNotNullParameter(r102, "map");
        if (r100.size() <= 0) goto L5;
        Intrinsics.checkNotNullParameter(r100, "map");
        r102.putAll(r100);
    L5:
        cy0.e.f465759a.getClass();
        j r103 = cy0.e.a.f465760a;
        m.f163449e.getClass();
        Object r104 = m.b(r103).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r104);
        ((i) ((f80.a) r104)).w3("livesdk_livelink_link_performance", r101.f516447a, r101.f516448b);
    }
}
