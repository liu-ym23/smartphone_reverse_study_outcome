package com.larus.avlink.plugins;

import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.larus.dora.api.IDoraService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class n1 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o1 f294001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f294002b;

    public /* synthetic */ n1(o1 r100, int r101) {
        this.f294001a = r100;
        this.f294002b = r101;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        o1 r100 = this.f294001a;
        int r101 = this.f294002b;
        FLogger.f375446a.i("DoraIsolatedCallQueryMonitor", "sendTtsResponseEvent, scene=" + r100.f294013e + ", type=" + r101 + ", duration=" + (System.currentTimeMillis() - r100.f294016h) + ", callId=" + r100.f294014f + " roomId=" + r100.f294015g + ", questionId=" + r100.f294010b);
        LinkedHashMap r102 = new LinkedHashMap();
        r100.a(r102);
        r102.put("type", Integer.valueOf(r101));
        r102.put("duration", Long.valueOf(o1.b(r100.f294016h)));
        r102.put(NoticeInfo.KEY_REPLY_ID, r100.f294010b);
        r102.put("is_rtos_player", Integer.valueOf(r100.f294011c ? 1 : 0));
        IDoraService r103 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r103 == null) goto L6;
        r103.A0("flow_dora_vui_tts_response", r102);
    L6:
        return Unit.INSTANCE;
    }
}
