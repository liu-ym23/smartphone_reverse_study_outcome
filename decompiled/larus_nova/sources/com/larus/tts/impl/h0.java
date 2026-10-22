package com.larus.tts.impl;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes31.dex */
public final class h0 implements Function1<Throwable, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h0 f370238a = null;

    static {
        f370238a = new h0();
    }

    public h0() {
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable r100) {
        Throwable r101 = r100;
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("[TTS] cancel by scope will callback, ");
        if (r101 == null) goto L5;
        Throwable r104 = r101.getCause();
    L6:
        r103.append(r104);
        r102.i("TtsReader", r103.toString());
        return Unit.INSTANCE;
    L5:
        r104 = null;
        goto L6
    }
}
