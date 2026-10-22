package com.larus.login.api;

import com.bytedance.keva.Keva;
import com.larus.platform.service.AccountService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes30.dex */
public final class CommonDouYinLoginKV {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f356938a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f356939b = null;

    public CommonDouYinLoginKV() {
    }

    static {
        f356938a = LazyKt.lazy(new j());
        f356939b = LazyKt.lazy(new k());
    }

    public static Keva a() {
        return (Keva) f356939b.getValue();
    }

    public static boolean b() {
        if (((uq9.f) f356938a.getValue()).d() == true) goto L10;
        String r100 = AccountService.f365697a.getUserId();
        if (a().getBoolean("ecom_notify_shown_uid_set_".concat(r100), false) == false) goto L7;
    L8:
        d();
        return true;
    L7:
        if (a().getBoolean("wallet_and_payment_notification_pop_up", false) == true) goto L8;
        return false;
    L10:
        return a().getBoolean("wallet_and_payment_notification_pop_up", false);
    }

    public static void c() {
        if (((uq9.f) f356938a.getValue()).d() == false) goto L5;
        return;
    L5:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new CommonDouYinLoginKV$registerCheckEcomNotifyListener$1(null), 2, null);
    }

    public static void d() {
        if (((uq9.f) f356938a.getValue()).d() == true) goto L8;
        String r100 = AccountService.f365697a.getUserId();
        a().storeBoolean("ecom_notify_shown_uid_set_".concat(r100), true);
        if (a().getBoolean("ecom_notify_reported_uid_set_".concat(r100), false) == false) goto L7;
        return;
    L7:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new CommonDouYinLoginKV$setWalletAndPaymentNotificationPopUp$1(r100, null), 2, null);
        return;
    L8:
        a().storeBoolean("wallet_and_payment_notification_pop_up", true);
    }
}
