package com.bytedance.ies.bullet.core;

import com.bytedance.ies.bullet.service.base.c1;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class a0 implements b26.a {
    public a0() {
    }

    @Override // b26.a
    public final void a(v26.l r110, b26.d r111) {
        Intrinsics.checkNotNullParameter(r110, "config");
        Intrinsics.checkNotNullParameter(r111, "info");
        s26.d r100 = s26.d.f540305c;
        com.bytedance.ies.bullet.service.base.r r101 = (com.bytedance.ies.bullet.service.base.r) s26.d.f540305c.d(r110.I, com.bytedance.ies.bullet.service.base.r.class);
        if (r101 == null) goto L18;
        c1 r102 = new c1(r111.f17019a, null, null, null, null, 254);
        w16.a r112 = r110.f552723z;
        if (r112 == null) goto L7;
        a36.c r113 = (a36.c) r112.a(a36.c.class);
    L8:
        if (r113 == null) goto L10;
        r102.f247801k = r113;
        r102.f247792b = r111.f17020b;
    L16:
        r102.f247793c = r111.f17021c;
        r102.f247794d = r111.f17022d;
        r102.f247795e = r111.f17023e;
        r102.f247796f = r111.f17024f;
        r102.f247797g = r111.f17025g;
        r102.f247798h = r111.f17026h;
        r102.f247799i = null;
        r102.f247800j = null;
        r101.S(r102);
        return;
    L10:
        JSONObject r114 = r111.f17022d;
        if (r114 == null) goto L14;
        String r115 = JSONObjectProtectorUtils.getString(r114, "res_url");
        if (r115 == null) goto L14;
    L15:
        r102.f247792b = r115;
    L14:
        r115 = r111.f17020b;
        goto L15
    L7:
        r113 = null;
        goto L8
    }
}
