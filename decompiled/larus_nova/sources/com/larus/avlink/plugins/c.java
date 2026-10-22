package com.larus.avlink.plugins;

import com.larus.avlink.plugins.n4;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public abstract class c<C extends n4> extends com.larus.audio.call.arch.a<C> implements o4 {
    public void Q0(int r100) {
    }

    @Override // com.larus.audio.call.arch.a
    public void V2() {
    }

    public void i0(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "caller");
    }

    public void j3(int r100, int r101, String r102, String r103) {
    }

    public c(C r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }
}
