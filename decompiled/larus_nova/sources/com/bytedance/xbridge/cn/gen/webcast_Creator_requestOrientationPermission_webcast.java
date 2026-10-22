package com.bytedance.xbridge.cn.gen;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.browser.jsbridge.newmethods.bb;
import com.bytedance.ies.bullet.core.kit.bridge.j;
import kotlin.jvm.internal.Intrinsics;
import m16.b;

/* JADX INFO: loaded from: classes22.dex */
public class webcast_Creator_requestOrientationPermission_webcast {
    public webcast_Creator_requestOrientationPermission_webcast() {
    }

    public static j create(b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        bb r101 = new bb(null);
        r101.f63325b = (IHybridComponent) r100.c(IHybridComponent.class);
        return com.bytedance.android.annie.xbridge.mix.j.a(r101, "requestOrientationPermission", r100);
    }
}
