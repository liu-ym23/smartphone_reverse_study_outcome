package com.larus.call_plugins_doubao_common;

import android.media.AudioManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f321367a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f321368b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f321369c = null;

    static {
        Intrinsics.checkNotNullParameter("dora_appease.mp3", "fileName");
        Intrinsics.checkNotNullParameter("8e5221a2c7e863216f3151d00d59f26e", "md5");
        f321367a = new a("switch_micro_voice.mp3", "8baf3cfcf4c9a1de73b74cfc13e92b4b", false, 3, null, 200);
        f321368b = new a("dora_nature_comfort.mp3", "2b0b0b9c8d9da82cb5a1c0a5deb7742f", true, 3, "dora_appease_engine", 800);
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        Object r101 = Result.m9449constructorimpl(Integer.valueOf(AudioManager.class.getField("STREAM_ASSISTANT").getInt(null)));     // Catch: Throwable -> L5
    L8:
        if (Result.m9452exceptionOrNullimpl(r101) == null) goto L11;
        r101 = 3;
    L11:
        f321369c = new a("obric_dora_appease.mp3", "a572f45b2adb93d9b5452e6c09dc152a", true, ((Number) r101).intValue(), "o_appease_engine", 1000);
        return;
    L5:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
