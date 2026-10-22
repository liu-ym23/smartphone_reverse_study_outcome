package com.larus.audio.call.plugins;

import com.larus.im.service.audio.cmd.TriggerMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes24.dex */
public final /* synthetic */ class x implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.larus.audio.call.arch.c f289550a;

    public /* synthetic */ x(com.larus.audio.call.arch.c r100) {
        this.f289550a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        id9.d r100 = this.f289550a.j();
        if (r100 == null) goto L6;
        r100.p(TriggerMode.WAIT, null);
        return Unit.INSTANCE;
    L6:
        return null;
    }
}
