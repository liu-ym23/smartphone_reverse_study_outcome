package com.larus.avlink.plugins;

import com.larus.audio.call.plugins.CommonHelloPlugin;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c1 extends CommonHelloPlugin<n4> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f293844n;

    @Override // com.larus.audio.call.plugins.CommonHelloPlugin, com.larus.audio.call.plugins.y0
    public final boolean b1() {
        return j3();
    }

    @Override // com.larus.audio.call.plugins.CommonHelloPlugin, com.larus.audio.call.arch.a
    public final String T2() {
        return this.f293844n;
    }

    public c1(n4 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f293844n = "DoraHelloPlugin";
    }
}
