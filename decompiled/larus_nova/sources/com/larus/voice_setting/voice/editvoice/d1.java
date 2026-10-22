package com.larus.voice_setting.voice.editvoice;

import com.google.gson.Gson;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes32.dex */
public final class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d1 f376764a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Gson f376765b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f376766c = null;

    public d1() {
    }

    static {
        f376764a = new d1();
        f376765b = new Gson();
        f376766c = LazyKt.lazy(new c1());
    }

    public final b1 query(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        Object r102 = null;
        if (r101 == false) goto L11;
        return null;
    L11:
        com.larus.cache.f r103 = (com.larus.cache.f) f376766c.getValue();
        if (r103 != null) goto L33;
        return null;
    L33:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L22
        com.larus.cache.f.e r105 = r103.e(r100);     // Catch: Throwable -> L22
        if (r105 != null) goto L17;
        return null;
    L17:
        String r106 = r105.a();     // Catch: Throwable -> L22
        if (r106 != null) goto L20;
        return null;
    L20:
        Object r107 = Result.m9449constructorimpl((b1) f376765b.fromJson(r106, b1.class));     // Catch: Throwable -> L22
    L24:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L28;
        FLogger.f375446a.e("VoicePitchAndRateRepo", "[query] key(" + r100 + ") failed", r108);
    L28:
        if (Result.m9455isFailureimpl(r107) == true) goto L32;
        r102 = r107;
    L32:
        return (b1) r102;
    L22:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }
}
