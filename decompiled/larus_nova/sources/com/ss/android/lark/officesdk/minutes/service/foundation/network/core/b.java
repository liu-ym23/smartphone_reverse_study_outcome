package com.ss.android.lark.officesdk.minutes.service.foundation.network.core;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.google.gson.Gson;
import com.ss.android.lark.utils.e0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f433898a = null;

    static {
        f433898a = new b();
    }

    public b() {
    }

    public static gvb.b a(int r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, ContainerPosition.BODY);
        if (r100 != 200) goto L24;
        if (r102 == true) goto L24;
        return null;
    L24:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        Gson r104 = e0.f444707a;     // Catch: Throwable -> L8
        Object r105 = Result.m9449constructorimpl((gvb.b) e0.a(r101, gvb.b.class));     // Catch: Throwable -> L8
    L11:
        if (Result.m9455isFailureimpl(r105) == false) goto L13;
        r105 = null;
    L13:
        gvb.b r106 = (gvb.b) r105;
        if (r100 == 200) goto L16;
        return r106;
    L16:
        if (r106 != null) goto L18;
        return null;
    L18:
        if (r106.a() == 0) goto L20;
        boolean r107 = true;
    L21:
        if (r107 == true) goto L23;
        return null;
    L23:
        return r106;
    L20:
        r107 = false;
    L8:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}
