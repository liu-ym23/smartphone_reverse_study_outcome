package com.larus.call_plugins_doubao_common;

import com.larus.call_plugins_doubao_common.manager.n0;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes26.dex */
public abstract class h extends com.larus.audio.call.arch.a<com.larus.audio.call.arch.c> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Job f321374f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public n0 f321375g;

    @Override // com.larus.audio.call.arch.a
    public String T2() {
        return "CommonMediaFocusPlugin";
    }

    public void j3() {
    }

    public void k3() {
    }

    @Override // com.larus.audio.call.arch.a
    public void b3() {
        Job r100 = this.f321374f;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f321374f = null;
    }

    @Override // com.larus.audio.call.arch.a
    public void e3() {
        super.e3();
        j3();
        k3();
    }

    @Override // com.larus.audio.call.arch.a
    public void g3() {
        super.g3();
        n0 r100 = this.f321375g;
        if (r100 == null) goto L6;
        r100.k();
        return;
    }

    public h(com.larus.audio.call.arch.c r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }
}
