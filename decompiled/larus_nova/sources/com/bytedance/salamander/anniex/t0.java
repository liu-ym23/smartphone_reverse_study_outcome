package com.bytedance.salamander.anniex;

import android.content.Context;
import com.bytedance.ies.bullet.core.common.Arch;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Context> f268379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ia.c f268380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.anniex.base.lifecycle.a f268381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Arch f268382d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Scenes f268383e;

    public Context getContext() {
        WeakReference<Context> r100 = this.f268379a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_context");
        r100 = null;
    L5:
        Context r101 = r100.get();
        Intrinsics.checkNotNull(r101);
        return r101;
    }

    public t0(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f268382d = Arch.SL;
        this.f268383e = Scenes.AnnieXPage;
        this.f268379a = new WeakReference(r100);
    }
}
