package com.bytedance.ee.bear.doc.newresupdate.provider.interceptor;

import android.app.Activity;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f217983a;

    public static final class a implements UDToast.b {
        public a() {
        }

        @Override // com.larksuite.component.universe_design.toast.UDToast.b
        public final void a(com.ss.android.lark.compose.foundation.toast.b r100) {
            Intrinsics.checkNotNullParameter(r100, "toast");
            new ml5.b("debug_config").b("enable_debug_res", Boolean.TRUE);
            tt5.a.h("AbsResourceInterceptor", "click close ");
            r100.cancel();
        }
    }

    public c(String r100) {
        this.f217983a = r100;
    }

    public final void a() {
        Activity r100 = AppLifecycle.a.f408803a.f();
        if (r100 == null) goto L6;
        String r101 = this.f217983a;
        UDToast.a r102 = UDToast.build(r100);
        r102.g(r100.getString(R.string.LarkCCM_Test_UsingSpecifiedPack_Toast) + r101);
        r102.f285429b.f417630d = 3000;
        r102.b(R.string.LarkCCM_Test_UsingSpecifiedPack_SwitchDefault_Button, new a());
        r102.h();
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
