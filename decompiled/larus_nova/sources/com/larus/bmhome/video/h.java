package com.larus.bmhome.video;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f315327a = false;

    static {
        f315327a = AppHost.f326268a.isDebug();
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter("VideoSRSaverHelper", "tag");
        Intrinsics.checkNotNullParameter(r100, "msg");
        FLogger.f375446a.i("video_common_log_VideoSRSaverHelper", r100);
    }

    public static void a(String r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (f315327a == true) goto L13;
        return;
    L13:
        FLogger r102 = FLogger.f375446a;     // Catch: Exception -> L10
        String r103 = "video_common_log_".concat(r100);     // Catch: Exception -> L10
        String r104 = (String) r101.invoke();     // Catch: Exception -> L10
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        r102.d(r103, r104);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e);
    }
}
