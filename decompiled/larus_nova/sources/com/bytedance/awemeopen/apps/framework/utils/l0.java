package com.bytedance.awemeopen.apps.framework.utils;

import android.content.Context;
import android.content.Intent;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f197725a = 0;

    static {
    }

    public static void a(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "schema");
    L10:
        e = move-exception;
        zx3.a.c(r100, R.string.aos_find_package_err).d();
        AoLogger.c("ToDouyinAbilityUtil", new Object[]{e});
        return;
    L4:
        if (com.bytedance.awemeopen.infra.util.l.a("com.ss.android.ugc.aweme", r100) == false) goto L7;
        r100.startActivity(new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r101)));     // Catch: Exception -> L10
    L13:
        return;
    L7:
        if (AosExtConfig.f193138b.H(r100) == true) goto L13;
        com.bytedance.awemeopen.infra.util.l.b(r100);     // Catch: Exception -> L10
        goto L13
    }
}
