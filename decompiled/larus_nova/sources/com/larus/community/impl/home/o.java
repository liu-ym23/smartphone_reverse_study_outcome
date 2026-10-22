package com.larus.community.impl.home;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.larus.platform.service.z1;
import com.larus.utils.k0;
import kotlin.Pair;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class o implements q97.a {
    public o() {
    }

    @Override // q97.a
    public final boolean b(com.bytedance.router.c r100) {
        int r101 = k0.f375428a;
        if (r100 == null) goto L5;
        Uri r102 = r100.f267530d;
    L6:
        String r103 = k0.a(String.valueOf(r102));
        if (r103 != null) goto L9;
        return false;
    L9:
        if (StringsKt.contains$default(r103, "//flow/community_create", false, 2, null) != true) goto L13;
        return true;
    L13:
        return false;
    L5:
        r102 = null;
        goto L6
    }

    @Override // q97.a
    public final boolean a(Context r100, com.bytedance.router.c r101) {
        if (r100 == null) goto L13;
        if (r101 == null) goto L13;
        Intent r102 = r101.f267528b;
        if (r102 == null) goto L10;
        Bundle r103 = r102.getExtras();
        if (r103 == null) goto L10;
    L12:
        return z1.f365863a.f(r100, r103);
    L10:
        r103 = com.larus.utils.f.c(new Pair[0]);
    L13:
        return false;
    }
}
