package com.bytedance.ies.bullet.lynx.init;

import android.app.Application;
import com.lynx.tasm.LynxEnv;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f247352a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Application f247353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f247354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Float f247355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Float f247356e;

    public h() {
    }

    static {
        f247352a = new h();
        LynxEnv.inst().getLynxVersion();
    }

    public final Application getContext() {
        Application r100 = f247353b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }
}
