package com.obric.update.impl.v2.gateway;

import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    public static void a(PolarisFileWrapper r100) {
        Intrinsics.checkNotNullParameter(r100, "apkFile");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L15
        StringBuilder r102 = new StringBuilder();     // Catch: Throwable -> L15
        AppHost.Companion r103 = AppHost.f326268a;     // Catch: Throwable -> L15
        r102.append(r103.getApplication().getPackageName());     // Catch: Throwable -> L15
        r102.append(".obric.update");     // Catch: Throwable -> L15
        String r104 = r102.toString();     // Catch: Throwable -> L15
        ContextWrapper r105 = r103.a().getCurrentActivity();     // Catch: Throwable -> L15
        if (r105 != null) goto L6;
        r105 = r103.getApplication();     // Catch: Throwable -> L15
    L6:
        FLogger.f375446a.i("ApkInstallGateway", "startInstaller:" + r105 + ", file:" + r100 + ", authority:" + r104);     // Catch: Throwable -> L15
        int r106 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L15
        if (r106 < 24) goto L9;
        Uri r107 = FileProvider.getUriForFile(r105, r104, r100);     // Catch: Throwable -> L15
    L10:
        Intent r108 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);     // Catch: Throwable -> L15
        r108.setDataAndType(r107, "application/vnd.android.package-archive");     // Catch: Throwable -> L15
        r108.addFlags(268435456);     // Catch: Throwable -> L15
        if (r106 < 24) goto L13;
        r108.addFlags(1);     // Catch: Throwable -> L15
    L13:
        r105.startActivity(r108);     // Catch: Throwable -> L15
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L23;
        FLogger.f375446a.e("ApkInstallGateway", "startInstaller fail : " + r110.getMessage());
        return;
    L23:
        return;
    L9:
        r107 = Uri.fromFile(r100);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }
}
