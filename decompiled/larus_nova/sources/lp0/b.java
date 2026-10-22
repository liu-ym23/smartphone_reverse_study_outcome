package lp0;

import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.scope.j;
import com.bytedance.android.scope.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {
    public static final mp0.a a(j r100) {
        m r101 = m.f163449e;
        if (r100 != null) goto L5;
        r101.getClass();
        r100 = m.f163448d;
    L5:
        a r102 = (a) r101.a(r100, a.class);
        if (r102 != null) goto L10;
        return null;
    L10:
        return (mp0.a) r101.d(r102, mp0.a.class);
    }

    public static final com.bytedance.android.live.openplatform.impl.miniappanchor.choose.c c(a r100) {
        if (r100 == null) goto L6;
        com.bytedance.android.live.openplatform.impl.miniappanchor.choose.a r101 = r100.getRoot();
        if (r101 == null) goto L6;
        return r101.dE();
    L6:
        return null;
    }

    public static final boolean d(a r100) {
        if (r100 == null) goto L8;
        so0.a r101 = r100.w();
        if (r101 == null) goto L8;
        OpenPlatformContext r102 = r101.a();
        if (r102 == null) goto L8;
        return r102.isInLive();
    L8:
        return false;
    }

    public static final <T extends OpenPlatformContextService> T b(a r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r101, "cls");
        if (r100 == null) goto L9;
        so0.a r102 = r100.w();
        if (r102 == null) goto L9;
        OpenPlatformContext r103 = r102.a();
        if (r103 == null) goto L9;
        return (T) r103.getService(r101);
    L9:
        return null;
    }
}
