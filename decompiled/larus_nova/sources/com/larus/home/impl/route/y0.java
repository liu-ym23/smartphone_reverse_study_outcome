package com.larus.home.impl.route;

import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class y0 implements q97.a {
    public y0() {
    }

    @Override // q97.a
    public final boolean b(com.bytedance.router.c r100) {
        int r101 = u0.f346102a;
        if (r100 == null) goto L7;
        Uri r102 = r100.f267530d;
        if (r102 == null) goto L7;
        String r103 = r102.toString();
    L9:
        if (Intrinsics.areEqual(u0.a(r103), "//flow/subscription_detail") == false) goto L11;
        ap9.a r104 = ap9.a.f15860a;
        return true;
    L11:
        return false;
    L7:
        r103 = null;
        goto L9
    }

    @Override // q97.a
    public final boolean a(Context r100, com.bytedance.router.c r101) {
        if ((r100 instanceof FragmentActivity) == false) goto L7;
        ap9.a.f15860a.b((FragmentActivity) r100, "");
        return true;
    L7:
        return true;
    }
}
