package com.larus.kmp.voice_setting.voice.base.multitab;

import com.larus.im.FlowRuntime;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f351801a = 0;

    static {
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        FlowRuntime.b().e().i("VoiceListDiag", r100);     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
