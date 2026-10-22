package com.larus.camera.impl.ui.viewmodel;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.platform.spi.IAIChatService;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class b0 implements Function2 {
    public /* synthetic */ b0() {
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object r100, Object r101) {
        String r102 = (String) r101;
        if (((Boolean) r100).booleanValue() == false) goto L11;
        if (r102.length() <= 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L11;
        t19.s r104 = t19.s.f544207a;
        Application r105 = AppHost.f326268a.getApplication();
        r104.getClass();
        t19.s.o(r105, R.string.larus_save_success, false);
        IAIChatService.f365899a.n7(r102);
        goto L11
    L7:
        r103 = false;
    L11:
        return Unit.INSTANCE;
    }
}
