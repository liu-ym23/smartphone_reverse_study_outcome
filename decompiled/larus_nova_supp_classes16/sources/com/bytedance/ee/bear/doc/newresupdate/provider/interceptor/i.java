package com.bytedance.ee.bear.doc.newresupdate.provider.interceptor;

import android.app.Activity;
import com.bytedance.ee.bear.bitable.toast.ToastModel;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i implements Runnable {
    public final /* synthetic */ String a;

    public static final class a implements UDToast.b {
        public a() {
        }

        public final void a(com.ss.android.lark.compose.foundation.toast.b r4) {
            Intrinsics.checkNotNullParameter(r4, "toast");
            new ml5.b("debug_config").b("offline_disable_specific_res", Boolean.TRUE);
            tt5.a.h("AbsResourceInterceptor", "click close ");
            r4.cancel();
        }
    }

    public i(String r1) {
        this.a = r1;
    }

    public final void a() {
        Activity r0 = AppLifecycle.a.a.f();
        if (r0 == null) goto L6;
        String r1 = this.a;
        UDToast.a r2 = UDToast.build(r0);
        r2.g(r0.getString(2131889779) + r1);
        r2.b.d = ToastModel.DEFAULT_DURATION;
        r2.b(2131889778, new a());
        r2.h();
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
