package com.bytedance.xbridge.cn.gen;

import android.view.View;
import android.view.ViewParent;
import com.bytedance.android.live.browser.jsbridge.newmethods.a2;
import com.bytedance.ies.bullet.core.kit.bridge.j;
import kotlin.jvm.internal.Intrinsics;
import m16.b;
import ue7.c;

/* JADX INFO: loaded from: classes22.dex */
public class webcast_Creator_clipScreen_webcast {
    public webcast_Creator_clipScreen_webcast() {
    }

    public static j create(b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        c r101 = (c) r100.c(c.class);
        Object r102 = null;
        if (r101 == null) goto L7;
        View r103 = r101.i();
        if (r103 == null) goto L7;
        ViewParent r104 = r103.getParent();
    L9:
        if ((r104 instanceof View) == false) goto L13;
        r102 = r104;
    L13:
        return com.bytedance.android.annie.xbridge.mix.j.a(new a2((View) r102), "clipScreen", r100);
    L7:
        r104 = null;
        goto L9
    }
}
