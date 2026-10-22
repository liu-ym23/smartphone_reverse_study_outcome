package com.ss.android.lark.flow.chat;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.compose.foundation.toast.f;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f422026a;

    public a(Context r100) {
        this.f422026a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context r100 = this.f422026a;     // Catch: Throwable -> L4
        int r101 = FlowToast.f417626a;     // Catch: Throwable -> L4
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L4
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L4
        f r102 = new f(r100);     // Catch: Throwable -> L4
        r102.setText(R.string.LarkIM_Common_NetworkErrorCheck_Toast);     // Catch: Throwable -> L4
        r102.setIcon(R.drawable.flow_ud_ic_warning);     // Catch: Throwable -> L4
        r102.show();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
