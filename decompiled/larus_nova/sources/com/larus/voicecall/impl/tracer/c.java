package com.larus.voicecall.impl.tracer;

import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class c implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f379126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f379127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f379128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f379129d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f379130e;

    public /* synthetic */ c(j r100, int r101, boolean r102, boolean r103, long r104) {
        this.f379126a = r100;
        this.f379127b = r101;
        this.f379128c = r102;
        this.f379129d = r103;
        this.f379130e = r104;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        j r100 = this.f379126a;
        int r101 = this.f379127b;
        boolean r102 = this.f379128c;
        boolean r103 = this.f379129d;
        long r104 = this.f379130e;
        FLogger.f375446a.i("RealtimeCallQueryMonitor", "sendAsrEndEvent, scene=" + r100.f379179e + " , callId=" + r100.f379180f + ",roomId=" + r100.f379181g + ", asrResponseNums=" + r101 + " has Reported asr end = " + r100.E);
        LinkedHashMap r105 = new LinkedHashMap();
        r100.a(r105);
        r105.put("valid", Boolean.valueOf(r102));
        r105.put(com.bytedance.android.ec.core.event.a.KEY_QUESTION_ID, r100.f379176b);
        r105.put("asr_resp_num", Integer.valueOf(r101));
        r105.put("is_interrupt", Boolean.valueOf(r103));
        r105.put("duration", Long.valueOf(j.b(r104)));
        r100.f379175a.k().reportEvent("flow_vui_asr_end", r105);
        r100.E = true;
        return Unit.INSTANCE;
    }
}
