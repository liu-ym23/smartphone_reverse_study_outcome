package ljb;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.watermark.userscope.WatermarkModuleV3;
import com.ss.android.lark.watermark.userscope.c;
import e0c.k;
import java.util.HashMap;
import p4c.d;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile c f509536a;

    public a() {
    }

    public static c a() {
        if (f509536a != null) goto L19;
        monitor-enter(a.class);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (f509536a != null) goto L13;
        Log.i("watermarkV3", "scs.watermark.user_state_and_optimize is: true");     // Catch: Throwable -> L15
        d r100 = (d) ApiUtils.getApi(d.class);     // Catch: Throwable -> L15
        if (r100 == null) goto L12;
        HashMap r101 = new HashMap();     // Catch: Throwable -> L15
        r101.put("event", "use_refactored");     // Catch: Throwable -> L15
        r100.monitorEventV2("scs_watermark_refactor", r101, null, null, 0);     // Catch: Throwable -> L15
    L12:
        int r102 = WatermarkModuleV3.f445382g;     // Catch: Throwable -> L15
        ((c) k.a(LarkContext.getApplication(), c.class)).v7();     // Catch: Throwable -> L15
        f509536a = (c) k.a(LarkContext.getApplication(), c.class);     // Catch: Throwable -> L15
    L13:
        monitor-exit(a.class);     // Catch: Throwable -> L15
    L19:
        return f509536a;
    }
}
