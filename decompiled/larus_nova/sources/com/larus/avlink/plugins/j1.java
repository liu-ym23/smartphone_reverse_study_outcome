package com.larus.avlink.plugins;

import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.larus.dora.api.IDoraService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class j1 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o1 f293959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f293960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f293961c;

    public /* synthetic */ j1(o1 r100, int r101, boolean r102) {
        this.f293959a = r100;
        this.f293960b = r101;
        this.f293961c = r102;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        o1 r100 = this.f293959a;
        int r101 = this.f293960b;
        boolean r102 = this.f293961c;
        FLogger.f375446a.i("DoraIsolatedCallQueryMonitor", "sendChatResponseEvent, scene=" + r100.f294013e + ", type=" + r101 + ", duration=" + (System.currentTimeMillis() - r100.f294016h) + ", callId=" + r100.f294014f + " roomId=" + r100.f294015g + ", questionId=" + r100.f294010b + ", isCommand=" + r102);
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("type", Integer.valueOf(r101));
        r103.put("is_command", Boolean.valueOf(r102));
        r103.put("duration", Long.valueOf(o1.b(r100.f294016h)));
        r103.put(NoticeInfo.KEY_REPLY_ID, r100.f294010b);
        r100.a(r103);
        IDoraService r104 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r104 == null) goto L6;
        r104.A0("flow_dora_vui_chat_response", r103);
    L6:
        return Unit.INSTANCE;
    }
}
