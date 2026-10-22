package com.larus.voicecall.impl.component.denoise.snr;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class d extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<a, Unit> f377406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f377407b;

    @Override // com.larus.voicecall.impl.component.denoise.snr.a
    public final void b() {
        Function1<a, Unit> r100 = this.f377406a;
        r100.invoke(new e(r100));
    }

    @Override // com.larus.voicecall.impl.component.denoise.snr.a
    public final void c() {
        Function1<a, Unit> r100 = this.f377406a;
        r100.invoke(new b(r100));
    }

    @Override // com.larus.voicecall.impl.component.denoise.snr.a
    public final String a() {
        return this.f377407b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Function1<? super a, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "transTo");
        super(r100);
        this.f377406a = r100;
        this.f377407b = "SNRReportState";
    }

    @Override // com.larus.voicecall.impl.component.denoise.snr.a
    public final void e(boolean r100, boolean r101, boolean r102) {
        FLogger.f375446a.i(this.f377407b, "onUIStateChange isListeningState=" + r100 + " isMute=" + r101 + "  isDenoiseSwitchOpen=" + r102);
        if (r100 == false) goto L6;
        if (r101 == true) goto L6;
        if (r102 == false) goto L6;
        return;
    L6:
        Function1<a, Unit> r103 = this.f377406a;
        r103.invoke(new c(r103));
    }
}
