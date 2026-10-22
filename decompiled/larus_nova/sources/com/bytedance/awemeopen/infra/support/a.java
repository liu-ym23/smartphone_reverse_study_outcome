package com.bytedance.awemeopen.infra.support;

import android.util.Log;
import com.bytedance.awemeopen.infra.base.npth.AoExceptionReporter;
import com.bytedance.awemeopen.infra.base.npth.ErrorPriority;
import com.bytedance.awemeopen.servicesapi.npth.AoNpthService;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f198940a = 0;

    static {
    }

    public static void a(String r100, String r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, "bizType");
        Intrinsics.checkNotNullParameter(r101, "sign");
        Intrinsics.checkNotNullParameter(r102, "block");
        r102.invoke();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        String r103 = Log.getStackTraceString(th);
        AoNpthService r104 = AoExceptionReporter.f198706a;
        AoExceptionReporter.a(ErrorPriority.f198710p0, r100, r101, r103, th);
    }
}
