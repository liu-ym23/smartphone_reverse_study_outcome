package z11;

import com.bytedance.android.live.revenue.core.b;
import com.bytedance.android.live.revenue.core.util.e;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.live.kmp.core.d;
import d51.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {
    public static final d a(Class r100) {
        if (c.A0.a() == false) goto L8;
        b r101 = j.C0.a();
        if (r101 != null) goto L7;
        return null;
    L7:
        e.b(r101, r100);
    L8:
        b r102 = j.C0.a();
        Intrinsics.checkNotNull(r102);
        return e.b(r102, r100);
    }
}
