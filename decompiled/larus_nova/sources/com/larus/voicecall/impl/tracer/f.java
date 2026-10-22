package com.larus.voicecall.impl.tracer;

import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class f implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f379152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f379153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f379154c;

    public /* synthetic */ f(j r100, int r101, boolean r102) {
        this.f379152a = r100;
        this.f379153b = r101;
        this.f379154c = r102;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        j r100 = this.f379152a;
        int r101 = this.f379153b;
        boolean r102 = this.f379154c;
        FLogger.f375446a.i("RealtimeCallQueryMonitor", "sendChatResponseEvent, scene=" + r100.f379179e + ", type=" + r101 + ", duration=" + (System.currentTimeMillis() - r100.f379182h) + ", callId=" + r100.f379180f + " roomId=" + r100.f379181g + ", questionId=" + r100.f379176b + ", isCommand=" + r102);
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("type", Integer.valueOf(r101));
        r103.put("is_command", Boolean.valueOf(r102));
        r103.put("duration", Long.valueOf(j.b(r100.f379182h)));
        r103.put(NoticeInfo.KEY_REPLY_ID, r100.f379176b);
        r100.a(r103);
        r100.f379175a.k().reportEvent("flow_vui_chat_response", r103);
        return Unit.INSTANCE;
    }
}
