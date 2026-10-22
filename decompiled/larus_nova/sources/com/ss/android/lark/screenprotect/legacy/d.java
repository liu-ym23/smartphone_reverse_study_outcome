package com.ss.android.lark.screenprotect.legacy;

import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import io.reactivex.functions.Consumer;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d<T> f439793a = null;

    static {
        f439793a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ScsLogger.d("ScreenshotProtection", "sendBotNotification: sendBotNotification error");
        String r101 = u4c.a.f548750a;
        u4c.a.a("scs_screenshot_send_bot_notification_result", MapsKt.mapOf(TuplesKt.to("is_success", "false")), null, MapsKt.mapOf(TuplesKt.to("message", ((Throwable) r100).getMessage())), 1, 4);
    }
}
