package com.larus.home.impl.route;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class f1 implements q97.a {

    public static final class a {
    }

    static {
    }

    public f1() {
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
        r101.d("ToastRouteInterceptor", r102.toString());
        int r106 = u0.f346102a;
        if (r100 == null) goto L14;
        Uri r107 = r100.f267530d;
        if (r107 == null) goto L14;
        r103 = r107.toString();
    L14:
        return Intrinsics.areEqual(u0.a(r103), "//flow/notice/toast");
    L7:
        r105 = null;
        goto L8
    }

    @Override // q97.a
    public final boolean a(Context r100, com.bytedance.router.c r101) {
        if (r101 == null) goto L13;
        Intent r102 = r101.f267528b;
        if (r102 == null) goto L14;
        Bundle r103 = r102.getExtras();
        if (r103 == null) goto L15;
        String r104 = r103.getString("toast");
        if (r104 == null) goto L16;
        t19.s.j(t19.s.f544207a, r100, r104, null, false, 28);
        return true;
    L16:
        return true;
    L15:
        return true;
    L14:
        return true;
    L13:
        return true;
    }
}
