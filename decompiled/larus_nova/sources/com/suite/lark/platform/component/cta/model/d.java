package com.suite.lark.platform.component.cta.model;

import com.google.gson.Gson;
import com.larksuite.framework.callback.Entity.ErrorResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f460524a = null;

    static {
        f460524a = new d();
    }

    public d() {
    }

    public static com.larksuite.rucket.job.base.b a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        goc.b r101 = (goc.b) new Gson().fromJson(r100, goc.b.class);     // Catch: Exception -> L8
        if (r101.a() == 0) goto L6;
        com.larksuite.rucket.job.base.b r102 = new com.larksuite.rucket.job.base.b.C3939b(new ErrorResult(r101.c()));     // Catch: Exception -> L8
    L11:
        return r102;
    L6:
        r102 = new com.larksuite.rucket.job.base.b.c(r101);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        return new com.larksuite.rucket.job.base.b.C3939b(new ErrorResult(e));
    }
}
