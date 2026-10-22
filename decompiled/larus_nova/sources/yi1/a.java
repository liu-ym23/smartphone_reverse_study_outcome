package yi1;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdk.config.oi;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import zg1.h1;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f567852a = 0;

    static {
    }

    public static void a(String r100, Context r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        ALogger.i("ttlive_anchor_swallow_back", "closeLiveAndHandleScheme jumpScheme:" + r100 + " source:" + r102);
        h1 r103 = new h1(6);
        Bundle r104 = new Bundle();
        boolean r105 = true;
        r104.putBoolean("DATA_BOOLEAN_SKIP_INTERCEPTOR", true);
        r103.f571839d = r104;
        xs2.b.a().post(r103);
        if (r100 != null) goto L5;
    L8:
        if (r105 == false) goto L11;
        ALogger.i("ttlive_anchor_swallow_back", "empty scheme");
        return;
    L11:
        NewBroadcastMonitor.a r106 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.NEW_LINK_AUDIENCE_JSB_JUMP, null, null, 14);
        r106.l(0);
        r106.i("jumpScheme", r100);
        r106.i("source", r102);
        r106.a().report();
        int r107 = ms1.h.f515462a;
        oi r108 = oi.f120906a;
        if (r108.getValue().a() > 0) goto L14;
    L18:
        ALogger.i("ttlive_anchor_swallow_back", "real start closeLiveAndHandleScheme");
        ILiveActionHandler r109 = (ILiveActionHandler) jc1.k.f(ILiveActionHandler.class);
        if (r109 == null) goto L24;
        r109.handle(r101, r100);
        return;
    L24:
        return;
    L14:
        if (jc1.k.f(IBroadcastService.class) == null) goto L18;
        ALogger.i("ttlive_anchor_swallow_back", "real start middle");
        IBroadcastService r110 = (IBroadcastService) jc1.k.f(IBroadcastService.class);
        if (r110 == null) goto L22;
        r110.openLiveDelaySchemeActivity(r101, r100, r108.getValue().a());
        return;
    L22:
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r105 = false;
        goto L8
    }
}
