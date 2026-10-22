package com.bytedance.salamander.anniex;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f268365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f268366b;

    public final Context getContext() {
        Context r100 = this.f268365a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }

    public s(Context r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "reloadFunc");
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f268365a = r100;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f268366b = r101;
    }
}
