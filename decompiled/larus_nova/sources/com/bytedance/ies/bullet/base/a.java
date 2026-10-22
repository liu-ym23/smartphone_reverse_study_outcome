package com.bytedance.ies.bullet.base;

import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f246271a = 0;

    static {
    }

    public static void a(boolean r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r101, "errMsg");
        if (r100 == false) goto L7;
        if (r102 == null) goto L6;
        throw r102;
    L6:
        throw new RuntimeException(r101);
    L7:
        ExecutorService r103 = BulletLogger.f247763a;
        BulletLogger.j(r101, LogLevel.E, "XInit");
    }
}
