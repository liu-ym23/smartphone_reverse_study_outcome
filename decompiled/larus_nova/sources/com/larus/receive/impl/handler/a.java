package com.larus.receive.impl.handler;

import android.content.Context;
import android.content.Intent;
import com.larus.receive.contract.ReceiveCustomDiffContract;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a implements b {
    public a() {
    }

    @Override // com.larus.receive.impl.handler.b
    public final String getName() {
        return ReceiveCustomDiffContract.f367364b.getName();
    }

    @Override // com.larus.receive.impl.handler.b
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("landing", "currentPage");
        ReceiveCustomDiffContract.f367364b.a(r100);
    }

    @Override // com.larus.receive.impl.handler.b
    public final boolean b(Intent r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        return ReceiveCustomDiffContract.f367364b.b(r100);
    }
}
