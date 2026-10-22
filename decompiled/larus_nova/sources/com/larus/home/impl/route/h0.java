package com.larus.home.impl.route;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class h0 implements q97.a {
    public h0() {
    }

    @Override // q97.a
    public final boolean b(com.bytedance.router.c r100) {
        if (r100 == null) goto L8;
        Uri r101 = r100.f267530d;
        if (r101 != null) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual("//" + r101.getHost() + r101.getPath(), "//flow/chat_page");
    L8:
        return false;
    }

    @Override // q97.a
    public final boolean a(Context r100, com.bytedance.router.c r101) {
        if (r101 == null) goto L8;
        Intent r102 = r101.f267528b;
        if (r102 == null) goto L9;
        r102.putExtra("page_open_time", System.currentTimeMillis());
        return false;
    L9:
        return false;
    L8:
        return false;
    }
}
