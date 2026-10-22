package com.bytedance.android.livesdk.livecommerce.message;

import com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.UpdatePopPromotionInterceptor;
import com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.b0;
import com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.c0;
import com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.d;
import com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.d0;
import com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.e;
import com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.e0;
import com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.f;
import com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.f0;
import com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.g;
import com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.h;
import com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.i;
import com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.k;
import com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.l;
import com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.m;
import com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.n;
import com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.o;
import com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.p;
import com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.q;
import com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.r;
import com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.s;
import com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.t;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static List a(boolean r1, RealRoomController r2) {
        Intrinsics.checkNotNullParameter(r2, "controller");
        ArrayList r0 = new ArrayList();
        if (r1 == false) goto L5;
        r0.add(new o());
        r0.add(new r(r2));
        r0.add(new q());
        r0.add(new g());
        r0.add(new l());
        r0.add(new f());
        r0.add(new h());
        r0.add(new com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.c(r2));
        r0.add(new com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.b(r2));
        r0.add(new n(r2));
        r0.add(new s(r2));
        r0.add(new b0());
        r0.add(new f0());
        r0.add(new UpdatePopPromotionInterceptor());
        r0.add(new d0(r2));
        r0.add(new e0(r2));
        r0.add(new t(r2));
        r0.add(new k());
        r0.add(new p());
        r0.add(new c0());
        r0.add(new e());
        r0.add(new m());
        r0.add(new i());
        r0.add(new d());
    L9:
        return r0;
    L5:
        r0.add(new qi2.b(r2));
        if (EComABUtils.isEnableLiveOptSlot() == true) goto L8;
        r0.add(new qi2.d(r2));
    L8:
        r0.add(new qi2.c());
        r0.add(new f0());
        goto L9
    }
}
