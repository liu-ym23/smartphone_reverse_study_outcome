package com.larus.home.impl.route;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class o0 implements q97.a {

    public static final class a {
    }

    static {
    }

    public o0() {
    }

    @Override // q97.a
    public final boolean b(com.bytedance.router.c r100) {
        int r101 = u0.f346102a;
        if (r100 == null) goto L7;
        Uri r102 = r100.f267530d;
        if (r102 == null) goto L7;
        String r103 = r102.toString();
    L9:
        return Intrinsics.areEqual(u0.a(r103), "//flow/open_browser");
    L7:
        r103 = null;
        goto L9
    }

    @Override // q97.a
    public final boolean a(Context r100, com.bytedance.router.c r101) {
        String r102 = null;
        if (r101 == null) goto L7;
        Uri r103 = r101.f267530d;
        if (r103 == null) goto L7;
        String r104 = UriProtector.getQueryParameter(r103, "url");
    L9:
        if (r104 != null) goto L11;
    L14:
        boolean r105 = true;
    L16:
        if (r105 == false) goto L19;
        FLogger.f375446a.e("OpenBrowserInterceptor", "Cannot open browser because url is empty");
        return true;
    L19:
        Intent r106 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r104));
        if ((r100 instanceof Activity) == true) goto L22;
        r106.addFlags(268435456);
    L22:
        if (r100 != null) goto L30;
    L29:
        return true;
    L30:
        r100.startActivity(r106);     // Catch: ActivityNotFoundException -> L25
    L25:
        FLogger r107 = FLogger.f375446a;
        StringBuilder r108 = new StringBuilder("No activity found for external url scheme=");
        Uri r109 = r106.getData();
        if (r109 == null) goto L28;
        r102 = r109.getScheme();
    L28:
        r108.append(r102);
        r107.e("OpenBrowserInterceptor", r108.toString());
        goto L29
    L11:
        if (StringsKt.isBlank(r104) == true) goto L14;
        r105 = false;
    L7:
        r104 = null;
        goto L9
    }
}
