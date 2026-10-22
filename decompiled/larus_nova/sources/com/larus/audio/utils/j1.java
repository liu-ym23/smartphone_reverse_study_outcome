package com.larus.audio.utils;

import com.google.gson.Gson;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j1 f290058a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f290059b = null;

    public j1() {
    }

    static {
        f290058a = new j1();
        f290059b = LazyKt.lazy(new i1());
    }

    public static String a(SAMICoreBlock r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(new JSONObject(new JSONObject(((Gson) f290059b.getValue()).toJson(r100.audioData[0])).optString("textMsg")).optString("speech_alignment_result"));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r102) == false) goto L11;
        r102 = null;
    L11:
        return (String) r102;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
