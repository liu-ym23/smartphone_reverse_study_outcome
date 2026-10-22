package com.larus.home.impl.route;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class g0 implements q97.a {
    public g0() {
    }

    @Override // q97.a
    public final boolean b(com.bytedance.router.c r100) {
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("Router matchInterceptRules -> ");
        String r103 = null;
        if (r100 == null) goto L7;
        Uri r104 = r100.f267530d;
        if (r104 == null) goto L7;
        String r105 = r104.getAuthority();
    L8:
        r102.append(r105);
        r101.d("MainRouterInterceptor", r102.toString());
        int r106 = u0.f346102a;
        if (r100 == null) goto L13;
        Uri r107 = r100.f267530d;
        if (r107 == null) goto L13;
        r103 = r107.toString();
    L13:
        String r108 = u0.a(r103);
        if (Intrinsics.areEqual(r108, "//main_page") == false) goto L16;
    L21:
        return true;
    L16:
        if (Intrinsics.areEqual(r108, "//conversation_list") == true) goto L21;
        if (Intrinsics.areEqual(r108, "//flow/home") == true) goto L21;
        return false;
    L7:
        r105 = null;
        goto L8
    }

    @Override // q97.a
    public final boolean a(Context r100, com.bytedance.router.c r101) {
        int r102 = db9.a.C5650a.f467835a;
        String r103 = null;
        if (r101 == null) goto L5;
        Uri r104 = r101.f267530d;
    L6:
        if (r104 == null) goto L9;
        r103 = UriProtector.getQueryParameter(r104, "android_no_clear_top");
    L9:
        if (Intrinsics.areEqual(r103, "1") == true) goto L16;
        if (r101 == null) goto L17;
        Intent r105 = r101.f267528b;
        if (r105 == null) goto L18;
        r105.addFlags(67108864);
        return false;
    L18:
        return false;
    L17:
        return false;
    L16:
        return false;
    L5:
        r104 = null;
        goto L6
    }
}
