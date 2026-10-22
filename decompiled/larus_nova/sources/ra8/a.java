package ra8;

import android.content.Context;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kc8.f;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f536852a = 0;

    static {
    }

    public a() {
    }

    public static c b() {
        pd6.b r100 = pd6.c.f528682a;
        c r101 = (c) pd6.c.a(Reflection.getOrCreateKotlinClass(c.class));
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new IllegalStateException("BlockKit implementation is not installed".toString());
    }

    public static hk9.a a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return b().u2(r100);
    }

    public static void c(hk9.a r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        b().w(r100);
    }

    public static void e(hk9.a r100, List r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "models");
        b().y0(r100, r101, r102);
    }

    public static void d(hk9.a r100, List r101, f r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "blocks");
        Intrinsics.checkNotNullParameter(r102, "config");
        b().l0(r100, r101, r102, r103);
    }
}
