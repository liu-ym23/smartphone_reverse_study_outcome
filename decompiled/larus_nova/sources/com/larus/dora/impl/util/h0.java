package com.larus.dora.impl.util;

import android.content.Intent;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes27.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f338139a = 0;

    static {
    }

    public static boolean a() {
        if (AppHost.f326268a.getApplication().getPackageManager().getPackageInfo("com.huawei.smartaudio", 0) == null) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    public static boolean b(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return false;
    L11:
        g49.d.d("ExternalRoute", "open schema, schema: " + r100);
        Intent r102 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        r102.setData(UriProtector.parse(r100));
        r102.addFlags(335544320);
        AppHost.Companion r103 = AppHost.f326268a;
        if (r102.resolveActivity(r103.getApplication().getPackageManager()) != null) goto L19;
        return false;
    L19:
        r103.getApplication().startActivity(r102);     // Catch: Exception -> L16
        return true;
    L16:
        e = move-exception;
        FLogger.f375446a.e("ExternalRoute", "open schema failed, schema: " + r100 + ", e: " + e);
        return false;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }
}
