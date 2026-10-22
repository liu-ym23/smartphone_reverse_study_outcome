package com.larus.init.task.imsdk;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.larus.abtest.api.IAbTest;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements gd9.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f351370a = null;

    static {
        f351370a = new h();
    }

    public h() {
    }

    @Override // gd9.g
    public final double a(String r100, double r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return ((Number) IAbTest.f286085a.getExperimentValue(r100, Double.TYPE, Double.valueOf(r101), r102)).doubleValue();
    }

    @Override // gd9.g
    public final long b(String r100, long r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return ((Number) IAbTest.f286085a.getExperimentValue(r100, Long.TYPE, Long.valueOf(r101), r102)).longValue();
    }

    @Override // gd9.g
    public final String c(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defValue");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl(JsonParser.parseString(r101).getAsJsonObject());     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r104) == false) goto L10;
        r104 = null;
    L10:
        JsonObject r105 = (JsonObject) r104;
        if (r105 != null) goto L14;
        return r101;
    L14:
        return ((JsonObject) IAbTest.f286085a.getExperimentValue(r100, JsonObject.class, r105, r102)).toString();
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    @Override // gd9.g
    public final int d(String r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return ((Number) IAbTest.f286085a.getExperimentValue(r100, Integer.TYPE, Integer.valueOf(r101), r102)).intValue();
    }

    @Override // gd9.g
    public final boolean e(String r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return ((Boolean) IAbTest.f286085a.getExperimentValue(r100, Boolean.TYPE, Boolean.valueOf(r101), r102)).booleanValue();
    }

    @Override // gd9.g
    public final String f(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defValue");
        return (String) IAbTest.f286085a.getExperimentValue(r100, String.class, r101, r102);
    }
}
