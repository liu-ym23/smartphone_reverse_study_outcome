package com.bytedance.awemeopen.apps.framework.utils;

import android.content.Context;
import android.content.Intent;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "schema");
    L10:
        e = move-exception;
        zx3.a.c(r2, 2131894201).d();
        AoLogger.c("ToDouyinAbilityUtil", new Object[]{e});
        return;
    L4:
        if (com.bytedance.awemeopen.infra.util.l.a("com.ss.android.ugc.aweme", r2) == false) goto L7;
        r2.startActivity(new Intent("android.intent.action.VIEW", UriProtector.parse(r3)));     // Catch: Exception -> L10
    L13:
        return;
    L7:
        if (AosExtConfig.b.H(r2) == true) goto L13;
        com.bytedance.awemeopen.infra.util.l.b(r2);     // Catch: Exception -> L10
        goto L13
    }
}
