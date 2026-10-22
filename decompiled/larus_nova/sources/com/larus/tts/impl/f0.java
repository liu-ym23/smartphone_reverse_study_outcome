package com.larus.tts.impl;

import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.m0;

/* JADX INFO: loaded from: classes31.dex */
public final class f0 implements Function0<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m0 f370229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f370230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<Boolean> f370231c;

    public f0(m0 r100, Ref.BooleanRef r101, kotlinx.coroutines.j r102) {
        this.f370229a = r100;
        this.f370230b = r101;
        this.f370231c = r102;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        FLogger.f375446a.i("TtsReader", "[TTS] next in queue playing tts code");
        this.f370229a.dispose();
        Ref.BooleanRef r100 = this.f370230b;
        if (r100.element == true) goto L6;
        r100.element = true;
        kotlinx.coroutines.i<Boolean> r101 = this.f370231c;
        Result.Companion r102 = Result.Companion;
        r101.resumeWith(Result.m9449constructorimpl(Boolean.TRUE));
    L6:
        return Unit.INSTANCE;
    }
}
