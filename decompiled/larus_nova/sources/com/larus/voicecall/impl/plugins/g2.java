package com.larus.voicecall.impl.plugins;

import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class g2 extends com.larus.audio.call.arch.a<r> implements u {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f378522f;

    @Override // com.larus.audio.call.arch.a
    public final String T2() {
        return this.f378522f;
    }

    public g2(r r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f378522f = "RealtimeNotWorkInfoPlugin";
    }

    @Override // com.larus.voicecall.impl.plugins.u
    public final void L(int r100) {
        FLogger.f375446a.i(this.f378522f, "triggerNetInfoChange newQuality: " + r100);
        JSONObject r101 = new JSONObject();
        r101.put("ui_event", "network_quality");
        r101.put("network_level", String.valueOf(r100));
        id9.d r102 = getContext().j();
        if (r102 == null) goto L6;
        TriggerMode r103 = TriggerMode.UPDATE_UI_CONTEXT;
        JSONObject r104 = new JSONObject();
        r104.put("applet_payload", r101);
        Unit r105 = Unit.INSTANCE;
        r102.p(r103, r104.toString());
        return;
    }
}
