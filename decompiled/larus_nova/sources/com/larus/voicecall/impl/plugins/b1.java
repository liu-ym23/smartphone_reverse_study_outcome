package com.larus.voicecall.impl.plugins;

import com.larus.call_plugins_doubao_common.CommonFeedbackVoicePluginV2;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class b1 extends CommonFeedbackVoicePluginV2<r> {
    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.audio.call.arch.c] */
    @Override // com.larus.call_plugins_doubao_common.CommonFeedbackVoicePluginV2
    public final void k3() {
        com.larus.voicecall.impl.tracer.o r100 = d3a.a.b(getContext());
        if (r100 == null) goto L6;
        r100.v();
        return;
    }

    public b1(r r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }
}
