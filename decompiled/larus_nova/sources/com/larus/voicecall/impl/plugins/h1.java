package com.larus.voicecall.impl.plugins;

import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class h1 extends com.larus.audio.call.arch.a<r> implements i1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f378524f;

    @Override // com.larus.voicecall.impl.plugins.i1
    public final void h1() {
        LinkedHashMap r100 = new LinkedHashMap();
        o1 r101 = s.e(getContext());
        boolean r102 = true;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L9:
        if (r103 == false) goto L11;
        r100.put("current_modal_type", 2);
        r100.put(com.bytedance.android.ec.core.event.a.KEY_VIDEO_SOURCE_TYPE, 1);
    L20:
        FLogger.f375446a.i(this.f378524f, "syncClientInfo was called, info=" + r100);
        id9.d r104 = getContext().j();
        if (r104 == null) goto L24;
        r104.r(r100);
        return;
    L24:
        return;
    L11:
        u2 r105 = s.d(getContext());
        if (r105 != null) goto L14;
    L16:
        r102 = false;
    L17:
        if (r102 == false) goto L19;
        r100.put("current_modal_type", 2);
        r100.put(com.bytedance.android.ec.core.event.a.KEY_VIDEO_SOURCE_TYPE, 2);
        goto L20
    L19:
        r100.put("current_modal_type", 1);
        r100.put(com.bytedance.android.ec.core.event.a.KEY_VIDEO_SOURCE_TYPE, 0);
        goto L20
    L14:
        if (r105.J() != true) goto L16;
    L5:
        if (r101.D5() != true) goto L7;
        r103 = true;
        goto L9
    }

    @Override // com.larus.audio.call.arch.a
    public final String T2() {
        return this.f378524f;
    }

    public h1(r r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f378524f = "RealtimeCallTracePlugin";
    }
}
