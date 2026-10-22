package com.ss.android.lark.screenprotect.common;

import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.security.compliance.infra.network.h;
import io.reactivex.functions.Consumer;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<T> f439782a = null;

    static {
        f439782a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        h r101 = (h) r100;
        ScsLogger.d("ScreenshotProtection_US", "sendBotNotification: sendBotNotification success");
        String r102 = u4c.a.f548750a;
        u4c.a.a("scs_screenshot_send_bot_notification_result", MapsKt.mapOf(TuplesKt.to("is_success", "true")), null, null, 0, 12);
    }
}
