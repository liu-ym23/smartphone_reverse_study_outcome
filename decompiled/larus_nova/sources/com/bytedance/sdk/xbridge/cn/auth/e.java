package com.bytedance.sdk.xbridge.cn.auth;

import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthErrorCode;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class e implements ke7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m16.b f269837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.bytedance.ies.bullet.kit.web.jsbridge.d> f269838b;

    /* JADX WARN: Multi-variable type inference failed */
    public e(m16.b r100, List<? extends com.bytedance.ies.bullet.kit.web.jsbridge.d> r101) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f269837a = r100;
        this.f269838b = r101;
    }

    @Override // ke7.a
    public final ld7.c a(le7.a<?> r210, IDLXBridgeMethod r211) {
        Intrinsics.checkNotNullParameter(r210, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r211, com.alipay.sdk.m.p.e.f25671s);
        if (r210.c() != PlatformType.WEB) goto L12;
        Iterator<T> r100 = this.f269838b.iterator();
    L6:
        if (r100.hasNext() == false) goto L12;
        com.bytedance.ies.bullet.kit.web.jsbridge.d r101 = (com.bytedance.ies.bullet.kit.web.jsbridge.d) r100.next();
        com.bytedance.ies.bullet.kit.web.jsbridge.a r102 = r101.a(r210, r211, this.f269837a);
        if (r102.f247041a == false) goto L6;
        r210.f508953k = -1;
        StringBuilder r103 = new StringBuilder("blocked by biz service cjpay, msg: ");
        r101.name();
        r103.append(r102.f247042b);
        String r104 = r103.toString();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r210.f508954l = r104;
        StringBuilder r105 = new StringBuilder("blocked by biz service cjpay, msg: ");
        r101.name();
        r105.append(r102.f247042b);
        return new ld7.c(false, false, r105.toString(), AuthErrorCode.BLOCK_BY_BIZ_SERVICE, null, 50);
    L12:
        return new ld7.c(true, false, null, null, null, 62);
    }
}
