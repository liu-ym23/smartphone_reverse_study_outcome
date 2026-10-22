package com.larus.home.impl.route;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.router.SmartRouter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class k0 implements q97.a {
    public k0() {
    }

    @Override // q97.a
    public final boolean b(com.bytedance.router.c r100) {
        int r101 = u0.f346102a;
        if (r100 == null) goto L7;
        Uri r102 = r100.f267530d;
        if (r102 == null) goto L7;
        String r103 = r102.toString();
    L9:
        return Intrinsics.areEqual(u0.a(r103), "//flow/multi_account_switch");
    L7:
        r103 = null;
        goto L9
    }

    @Override // q97.a
    public final boolean a(Context r100, com.bytedance.router.c r101) {
        String r102 = null;
        if (r101 == null) goto L7;
        Intent r103 = r101.f267528b;
        if (r103 == null) goto L7;
        Bundle r104 = r103.getExtras();
    L8:
        if (r104 == null) goto L11;
        r102 = r104.getString("style");
    L11:
        if (Intrinsics.areEqual(r102, "full") == false) goto L13;
        String r105 = "//flow/multi_account_activity";
    L14:
        com.bytedance.router.i r106 = SmartRouter.buildRoute(r100, r105);
        if (r104 == null) goto L17;
        r106.g(r104);
    L17:
        r106.d();
        return true;
    L13:
        r105 = "//flow/multi_account_panel";
    L7:
        r104 = null;
        goto L8
    }
}
