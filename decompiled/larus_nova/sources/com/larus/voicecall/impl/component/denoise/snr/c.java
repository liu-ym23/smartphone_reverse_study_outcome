package com.larus.voicecall.impl.component.denoise.snr;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<a, Unit> f377404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f377405b;

    @Override // com.larus.voicecall.impl.component.denoise.snr.a
    public final void c() {
        Function1<a, Unit> r100 = this.f377404a;
        r100.invoke(new b(r100));
    }

    @Override // com.larus.voicecall.impl.component.denoise.snr.a
    public final String a() {
        return this.f377405b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function1<? super a, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "transTo");
        super(r100);
        this.f377404a = r100;
        this.f377405b = "SNRInitState";
    }

    @Override // com.larus.voicecall.impl.component.denoise.snr.a
    public final void e(boolean r100, boolean r101, boolean r102) {
        FLogger.f375446a.i(this.f377405b, "onUIStateChange isListeningState=" + r100 + " isMute=" + r101 + "  isDenoiseSwitchOpen=" + r102);
        if (r100 == false) goto L8;
        if (r101 == true) goto L9;
        if (r102 == false) goto L10;
        Function1<a, Unit> r103 = this.f377404a;
        r103.invoke(new f(r103));
        return;
    L10:
        return;
    L9:
        return;
    }
}
