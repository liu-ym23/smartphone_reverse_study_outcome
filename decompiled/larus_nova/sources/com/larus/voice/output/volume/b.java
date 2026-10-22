package com.larus.voice.output.volume;

import com.larus.audio.AudioServiceDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.z2;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import m58.y;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements a {
    public b() {
    }

    @Override // com.larus.voice.output.volume.a
    public final void a(c r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = c68.b.f22600a;
        c68.b.d("ZeroVolumeAutoPlayHelper", "[ZeroVolumeCommonHandler][handle]: scene=" + r100.f376038c);
    }

    @Override // com.larus.voice.output.volume.a
    public final boolean b(c r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r101 = false;
        if (z2.f365865a.T2() != 0) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L10;
        c68.b.d("ZeroVolumeAutoPlayHelper", "[ZeroVolumeCommonHandler][checkCondition]: disable audio zero volume adjust");
    L15:
        r101 = true;
    L16:
        int r103 = c68.b.f22600a;
        c68.b.d("ZeroVolumeAutoPlayHelper", "[ZeroVolumeCommonHandler][canHandle]: result=" + r101);
        return r101;
    L10:
        if (y.f512149a.a(AppHost.f326268a.getApplication()) == true) goto L13;
        c68.b.d("ZeroVolumeAutoPlayHelper", "[ZeroVolumeCommonHandler][checkCondition]: current volume is not zero");
        goto L15
    L13:
        if (AudioServiceDelegate.f288288a.isDoraConnected() == false) goto L16;
        c68.b.d("ZeroVolumeAutoPlayHelper", "[ZeroVolumeCommonHandler][checkCondition]: dora connected");
        goto L15
    L5:
        r102 = false;
        goto L7
    }
}
