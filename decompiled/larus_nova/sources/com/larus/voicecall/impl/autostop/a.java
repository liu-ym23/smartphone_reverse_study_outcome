package com.larus.voicecall.impl.autostop;

import com.larus.im.service.audio.cmd.TriggerMode;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class a extends com.larus.audio.call.arch.a<com.larus.audio.call.arch.c> implements t {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f377131f;

    @Override // com.larus.audio.call.arch.a
    public final String T2() {
        return this.f377131f;
    }

    public a(com.larus.audio.call.arch.c r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f377131f = "AutoStopAsrContextPlugin";
    }

    @Override // com.larus.voicecall.impl.autostop.t
    public final void updateScreenshotForAsr(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tosKey");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        JSONObject r102 = new JSONObject();
        r102.put("image_url", r100);
        r102.put("update_nonstream_context_finish", true);
        JSONObject r103 = new JSONObject();
        r103.put("context_data", r102);
        id9.d r104 = getContext().j();
        if (r104 == null) goto L11;
        jd9.c r105 = r104.state();
    L13:
        if ((r105 instanceof jd9.c.a) == false) goto L18;
        id9.d r106 = getContext().j();
        if (r106 == null) goto L19;
        r106.p(TriggerMode.UPDATE_PERSONAL_CONTEXT, r103.toString());
        return;
    L19:
        return;
    L18:
        return;
    L11:
        r105 = null;
        goto L13
    L5:
        r101 = false;
        goto L6
    }
}
