package com.bytedance.android.shopping.api.mall.common.tools;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k implements yj.p {
    public static final k b = null;
    public final /* synthetic */ MallRouteManageProxy a;

    public final void a(Context r2, String r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        this.a.a(r2, r3, r4);
    }

    public final boolean b(Context r2, Uri r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        return this.a.b(r2, r3, r4);
    }

    public final boolean c(Uri r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        return this.a.c(r2);
    }

    public final void d(Context r2, String r3, Map<String, Object> r4) {
        this.a.d(r2, r3, r4);
    }

    static {
        b = new k();
    }

    public k() {
        this.a = new MallRouteManageProxy();
    }
}
