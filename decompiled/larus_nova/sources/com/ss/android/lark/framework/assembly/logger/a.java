package com.ss.android.lark.framework.assembly.logger;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public final class a implements com.ss.android.lark.log.b {
    @Inject
    public a() {
    }

    @Override // com.ss.android.lark.log.b
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }
}
