package com.larus.voicecall.impl.component.denoise.snr;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<a, Unit> f377402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f377403b;

    @Override // com.larus.voicecall.impl.component.denoise.snr.a
    public final String a() {
        return this.f377403b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Function1<? super a, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "transTo");
        super(r100);
        this.f377402a = r100;
        this.f377403b = "SNRAsrState";
    }

    @Override // com.larus.voicecall.impl.component.denoise.snr.a
    public final void e(boolean r100, boolean r101, boolean r102) {
        FLogger.f375446a.i(this.f377403b, "onUIStateChange isListeningState=" + r100 + " isMute=" + r101 + "  isDenoiseSwitchOpen=" + r102);
        if (r100 == true) goto L6;
        Function1<a, Unit> r103 = this.f377402a;
        r103.invoke(new c(r103));
        return;
    }
}
