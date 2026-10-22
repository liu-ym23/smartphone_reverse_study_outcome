package jy0;

import com.bytedance.android.scope.m;
import cy0.j;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes47.dex */
public final class d {
    public static final void a(int r100, String r101, StackTraceElement[] r102) {
        Intrinsics.checkNotNullParameter(r101, "tag");
        cy0.e.f465759a.getClass();
        j r103 = cy0.e.a.f465760a;
        m.f163449e.getClass();
        Object r104 = m.b(r103).a(Reflection.getOrCreateKotlinClass(c.class));
        Intrinsics.checkNotNull(r104);
        ((c) ((f80.a) r104)).stacktrace(r100, r101, r102);
    }
}
