package com.larus.voicecall.impl.tracer;

import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class h implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f379162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f379163b;

    public /* synthetic */ h(j r100, int r101) {
        this.f379162a = r100;
        this.f379163b = r101;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        j r100 = this.f379162a;
        int r101 = this.f379163b;
        FLogger.f375446a.i("RealtimeCallQueryMonitor", "sendTtsResponseEvent, scene=" + r100.f379179e + ", type=" + r101 + ", duration=" + (System.currentTimeMillis() - r100.f379182h) + ", callId=" + r100.f379180f + " roomId=" + r100.f379181g + ", questionId=" + r100.f379176b);
        LinkedHashMap r102 = new LinkedHashMap();
        r100.a(r102);
        r102.put("type", Integer.valueOf(r101));
        r102.put("duration", Long.valueOf(j.b(r100.f379182h)));
        r102.put(NoticeInfo.KEY_REPLY_ID, r100.f379176b);
        r102.put("is_rtos_player", Integer.valueOf(r100.f379177c ? 1 : 0));
        r100.f379175a.k().reportEvent("flow_vui_tts_response", r102);
        return Unit.INSTANCE;
    }
}
