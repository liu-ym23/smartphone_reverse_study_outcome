package com.bytedance.android.livesdk.liveinit.other;

import com.bytedance.android.live.base.service.IVSReportService;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractSourceManager;
import com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService;
import com.bytedance.android.live.livepullstream.api.ICastScreenStreamService;
import com.bytedance.android.live.search.api.ILiveSearchService;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.init.AbsLiveInitUnit;
import com.bytedance.android.livesdk.init.LiveInitPoint;
import com.bytedance.android.livesdk.init.LiveInitUnitKey;
import com.bytedance.android.livesdkapi.init.LiveInitAssistant;
import com.bytedance.android.livesdkapi.service.vs.IVSVideoService;
import jc1.k;
import kotlin.Metadata;
import lu2.f;
import pm1.g;
import tb1.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/liveinit/other/LiveOtherInitUnit;", "Lcom/bytedance/android/livesdk/init/AbsLiveInitUnit;", "()V", "CLASS_FormatSDKService", "", "getUnitKey", "Lcom/bytedance/android/livesdk/init/LiveInitUnitKey;", "initPoint", "Lcom/bytedance/android/livesdk/init/LiveInitPoint;", "initialize", "", "livesdk-init_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveOtherInitUnit extends AbsLiveInitUnit {
    private static final String CLASS_FormatSDKService = "com.bytedance.android.format.service.FormatSDKService";
    public static final LiveOtherInitUnit INSTANCE = null;

    static {
        INSTANCE = new LiveOtherInitUnit();
    }

    public void initialize() {
        k.m(IVSReportService.class, AnonymousClass1.INSTANCE);
        k.m(IVSPlayerService.class, AnonymousClass2.INSTANCE);
        if (LiveInitAssistant.INSTANCE.getInitConfigInner().getLazyInitTopService() == false) goto L5;
        k.m(IMiddlewareInteractGameService.class, AnonymousClass3.INSTANCE);
        k.m(IInteractGameService.class, AnonymousClass4.INSTANCE);
    L6:
        k.m(IInteractGameMonitorService.class, AnonymousClass6.INSTANCE);
        k.m(IInteractSourceManager.class, AnonymousClass7.INSTANCE);
        k.m(ILiveSearchService.class, AnonymousClass8.INSTANCE);
        int r0 = com.bytedance.android.livesdk.liveinit.a.a;
        com.bytedance.android.livesdk.liveinit.a.b(IVSVideoService.class, AnonymousClass9.INSTANCE);
        k.m(ICastScreenStreamService.class, AnonymousClass10.INSTANCE);
        k.m(f.class, AnonymousClass11.INSTANCE);
        boolean r1 = c.a;
        ht2.k.a(true);
        jc1.a.b().registerActivityLifecycleCallbacks(com.bytedance.android.live.core.utils.a.d);
        int r2 = g.a;
        return;
    L5:
        int r3 = com.bytedance.android.livesdk.liveinit.a.a;
        com.bytedance.android.livesdk.liveinit.a.b(IInteractGameService.class, AnonymousClass5.INSTANCE);
        goto L6
    }

    private LiveOtherInitUnit() {
    }

    public LiveInitUnitKey getUnitKey() {
        return LiveInitUnitKey.LiveOtherInitUnit;
    }

    public LiveInitPoint initPoint() {
        return LiveInitPoint.COMPLETE_INIT;
    }
}
