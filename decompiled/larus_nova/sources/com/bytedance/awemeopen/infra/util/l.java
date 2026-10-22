package com.bytedance.awemeopen.infra.util;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class l {
    static {
    }

    public static void b(Context r100) {
        Intrinsics.checkNotNullParameter("com.ss.android.ugc.aweme", "appPkg");
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    L11:
        e = move-exception;
        AoLogger.c("PackageUtils", new Object[]{e.getMessage()});
        return;
    L4:
        if (TextUtils.isEmpty("com.ss.android.ugc.aweme") == false) goto L6;
        return;
    L6:
        Intent r101 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse("market://details?id=com.ss.android.ugc.aweme"));     // Catch: Exception -> L11
        if (TextUtils.isEmpty("") == true) goto L9;
        r101.setPackage("");     // Catch: Exception -> L11
    L9:
        r101.addFlags(268435456);     // Catch: Exception -> L11
        r100.startActivity(r101);     // Catch: Exception -> L11
    }

    public static boolean a(String r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "pkgname");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101.getPackageManager().getPackageInfo(r100, 0) != null) goto L13;
        return false;
    L13:
        return true;
    L8:
        e = move-exception;
        AoLogger.c("PackageUtils", new Object[]{e.getMessage()});
        return false;
    }
}
