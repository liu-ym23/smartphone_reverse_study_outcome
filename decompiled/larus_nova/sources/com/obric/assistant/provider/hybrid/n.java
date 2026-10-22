package com.obric.assistant.provider.hybrid;

import android.os.Bundle;
import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.larus.account.base.api.IAccountService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.account.IObricAccountService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes5.dex */
public final class n implements com.obric.assistant.provider.hybrid.a {

    /* JADX INFO: loaded from: classes4.dex */
    public static final class a {
    }

    static {
    }

    public n() {
    }

    @Override // com.obric.assistant.provider.hybrid.a
    public Bundle call(String r100, Bundle r101) {
        IObricAccountService r102 = (IObricAccountService) ServiceManager.get().getService(IObricAccountService.class);
        boolean r103 = false;
        if (r102 == null) goto L17;
        CountDownLatch r104 = new CountDownLatch(1);
        AtomicBoolean r105 = new AtomicBoolean(false);
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L11
        r102.i(new m(r105, r104));     // Catch: Throwable -> L11
        if (r104.await(5000, TimeUnit.MILLISECONDS) == true) goto L9;
        FLogger.f375446a.w("SwitchToPersonalAccount", "switchToPersonalAccount timeout");     // Catch: Throwable -> L11
    L9:
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L16;
        FLogger.f375446a.w("SwitchToPersonalAccount", "switchToPersonalAccount failed: " + r108.getMessage(), r108);
    L16:
        r103 = r105.get();
    L11:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L17:
        Bundle r110 = new Bundle();
        r110.putBoolean("switch_success", r103);
        if (r103 == false) goto L25;
        r38.b r111 = IAccountService.f286094a.getUserInfo();
        if (r111 == null) goto L23;
        String r112 = r111.g();
        if (r112 == null) goto L23;
    L24:
        r110.putString(ITwitterService.ResponseConstants.USER_NAME, r112);
    L23:
        r112 = "";
    L25:
        return r110;
    }
}
