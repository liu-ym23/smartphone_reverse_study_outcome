package com.bytedance.timon.ruler.adapter;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.TextStreamsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f270701a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static JsonObject f270702b;

    static {
        f270701a = new AtomicBoolean(false);
    }

    public static JsonObject a(Context r100, String r101) {
        AtomicBoolean r102 = f270701a;
        if (r102.get() == true) goto L11;
        r102.set(true);
        System.nanoTime();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L7
        String r104 = TextStreamsKt.readText(new BufferedReader(new InputStreamReader(r100.getAssets().open(r101))));     // Catch: Throwable -> L7
        f270702b = (JsonObject) new Gson().fromJson(r104, JsonObject.class);     // Catch: Throwable -> L7
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        System.nanoTime();
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L11:
        return f270702b;
    }
}
