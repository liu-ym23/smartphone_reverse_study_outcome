package jh0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.g;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static c f499067a;

    public static void a() {
        ALogger.i("DynamicBizExtController", "onDynamicWidgetDestroy");
        c r100 = f499067a;
        if (r100 != null) goto L5;
    L13:
        f499067a = null;
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r101 = g.f77934a;
        g.d("onDynamicWidgetDestroy");
        return;
    L5:
        if (gh0.a.d() == true) goto L13;
        ALogger.i("DynamicBizLogHelper", "onDynamicWidgetDestroy");
        hd0.c.f().e(r100.f499070c);
        if ((!r100.f499068a.isEmpty()) == false) goto L12;
        r100.a(null);
        if (hd0.c.f().h() == false) goto L12;
        r100.c(null);
    L12:
        ((LinkedHashMap) r100.f499068a).clear();
        goto L13
    }

    static {
    }
}
