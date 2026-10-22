package com.larus.avlink.plugins;

import com.larus.dora.api.IDoraService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class g1 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o1 f293920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f293921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f293922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f293923d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f293924e;

    public /* synthetic */ g1(o1 r100, int r101, boolean r102, boolean r103, long r104) {
        this.f293920a = r100;
        this.f293921b = r101;
        this.f293922c = r102;
        this.f293923d = r103;
        this.f293924e = r104;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        o1 r100 = this.f293920a;
        int r101 = this.f293921b;
        boolean r102 = this.f293922c;
        boolean r103 = this.f293923d;
        long r104 = this.f293924e;
        FLogger.f375446a.i("DoraIsolatedCallQueryMonitor", "sendAsrEndEvent, scene=" + r100.f294013e + " , callId=" + r100.f294014f + ",roomId=" + r100.f294015g + ", asrResponseNums=" + r101 + " has Reported asr end = " + r100.B);
        LinkedHashMap r105 = new LinkedHashMap();
        r100.a(r105);
        r105.put("valid", Boolean.valueOf(r102));
        r105.put(com.bytedance.android.ec.core.event.a.KEY_QUESTION_ID, r100.f294010b);
        r105.put("asr_resp_num", Integer.valueOf(r101));
        r105.put("is_interrupt", Boolean.valueOf(r103));
        r105.put("duration", Long.valueOf(o1.b(r104)));
        IDoraService r106 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r106 == null) goto L5;
        r106.A0("flow_dora_vui_asr_end", r105);
    L5:
        r100.B = true;
        return Unit.INSTANCE;
    }
}
