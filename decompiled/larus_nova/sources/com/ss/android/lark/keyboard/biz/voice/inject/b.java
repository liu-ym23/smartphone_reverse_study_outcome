package com.ss.android.lark.keyboard.biz.voice.inject;

import android.content.Context;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f428626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f428627b;

    public b(a r100, Context r101) {
        this.f428626a = r100;
        this.f428627b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a r100 = this.f428626a;     // Catch: Throwable -> L4
        Context r101 = this.f428627b;     // Catch: Throwable -> L4
        r100.getClass();     // Catch: Throwable -> L4
        FlowToast.a r102 = new FlowToast.a(r101);     // Catch: Throwable -> L4
        r102.e(R.string.Lark_Legacy_RecordShortTimeWarning);     // Catch: Throwable -> L4
        r102.f417629c = UDIconUtils.getIconDrawable(r102.f417627a, R.drawable.flow_ud_ic_warning);     // Catch: Throwable -> L4
        r102.c(49, 0, UIHelper.dp2px(44.0f));     // Catch: Throwable -> L4
        r102.a().show();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
