package com.bytedance.dux.toast;

import android.content.Context;
import android.widget.Toast;
import com.ss.android.lark.utils.statistics.PerfLog;
import em4.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends Toast implements e {
    @Override // com.bytedance.dux.toast.e
    public final void dismiss() {
        cancel();     // Catch: Exception -> L4
        Unit r100 = Unit.INSTANCE;     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        k.a("Try exception occur " + e.getMessage());
        Unit r101 = Unit.INSTANCE;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // com.bytedance.dux.toast.e
    public final void a(int r100, int r101) {
        show();     // Catch: Exception -> L4
        Unit r102 = Unit.INSTANCE;     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        k.a("Try exception occur " + e.getMessage());
        Unit r103 = Unit.INSTANCE;
    }
}
