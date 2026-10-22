package zz0;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.scope.m;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes47.dex */
public final class h {
    public static final void a(Context r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        cy0.e.f465759a.getClass();
        cy0.j r102 = cy0.e.a.f465760a;
        m.f163449e.getClass();
        Object r103 = m.b(r102).a(Reflection.getOrCreateKotlinClass(g.class));
        Intrinsics.checkNotNull(r103);
        ((g) ((f80.a) r103)).Y(r100, r101);
    }

    public static final void b(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uriString");
        cy0.e.f465759a.getClass();
        cy0.j r102 = cy0.e.a.f465760a;
        m.f163449e.getClass();
        Object r103 = m.b(r102).a(Reflection.getOrCreateKotlinClass(g.class));
        Intrinsics.checkNotNull(r103);
        ((g) ((f80.a) r103)).S2(r100, r101);
    }
}
