package com.ss.android.lark.chameleonv2.lkapi.resource.target;

import android.content.Context;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f411448a;

    public b(Context r100) {
        this.f411448a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UDToast.a r100 = UDToast.build(this.f411448a);     // Catch: Throwable -> L4
        r100.d(R.drawable.ud_icon_warning_outlined);     // Catch: Throwable -> L4
        r100.g(this.f411448a.getString(R.string.LarkCCM_Docs_Doubao_OperateInFeishu_Toast));     // Catch: Throwable -> L4
        r100.f285429b.f417630d = -1;     // Catch: Throwable -> L4
        r100.h();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
