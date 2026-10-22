package com.bytedance.ies.bullet.core.kit.bridge;

import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f246547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f246548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f246549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f246550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f246551e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f246552f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f246553g;

    public e() {
    }

    public final boolean a() {
        if (this.f246547a > 0) goto L5;
    L17:
        return false;
    L5:
        if (this.f246548b <= 0) goto L17;
        if (this.f246549c <= 0) goto L17;
        if (this.f246550d <= 0) goto L17;
        if (this.f246551e <= 0) goto L17;
        if (this.f246552f <= 0) goto L17;
        if (this.f246553g <= 0) goto L17;
        return true;
    }

    public final JSONObject d() {
        JSONObject r100 = new JSONObject();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        r100.put("on_call_from_js", this.f246548b - this.f246547a);     // Catch: Throwable -> L5
        r100.put("on_decode_end", this.f246549c - this.f246547a);     // Catch: Throwable -> L5
        r100.put("on_method_call", this.f246550d - this.f246547a);     // Catch: Throwable -> L5
        r100.put("on_callback_start", this.f246551e - this.f246547a);     // Catch: Throwable -> L5
        r100.put("on_encode_end", this.f246552f - this.f246547a);     // Catch: Throwable -> L5
        Result.m9449constructorimpl(r100.put("on_callback_end", this.f246553g - this.f246547a));     // Catch: Throwable -> L5
    L7:
        return r100;
    L5:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static void b(e r100) {
        r100.getClass();
        r100.f246551e = System.currentTimeMillis();
    }

    public static void c(e r100) {
        r100.getClass();
        r100.f246552f = System.currentTimeMillis();
    }
}
