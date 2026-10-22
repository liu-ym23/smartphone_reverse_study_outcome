package com.bytedance.ee.bear.facade.common.empty;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class DefaultConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f226410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Config> f226411b;

    public final Context getContext() {
        return this.f226410a;
    }

    public DefaultConfig(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f226410a = r100;
        this.f226411b = new DefaultConfig$default$1(this);
    }
}
