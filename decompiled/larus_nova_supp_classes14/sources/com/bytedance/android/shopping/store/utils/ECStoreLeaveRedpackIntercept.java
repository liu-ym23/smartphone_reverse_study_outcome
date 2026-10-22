package com.bytedance.android.shopping.store.utils;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.core.utils.m0;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.ies.utility.SharedPrefHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECStoreLeaveRedpackIntercept implements l {
    public final Lazy a;
    public final long b;
    public final a0 c;
    public final String d;

    public static final class a {
    }

    static {
    }

    public ECStoreLeaveRedpackIntercept(a0 r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "storeIntercept");
        Intrinsics.checkNotNullParameter(r3, "closeStoreMethod");
        this.c = r2;
        this.d = r3;
        this.a = LazyKt.lazy(ECStoreLeaveRedpackIntercept$sharedPrefHelper$2.INSTANCE);
        this.b = 86400000;
    }

    @Override // com.bytedance.android.shopping.store.utils.l
    public final boolean a(ECStoreViewModel r14, Context r15) {
        Intrinsics.checkNotNullParameter(r14, "viewModel");
        Intrinsics.checkNotNullParameter(r15, "context");
        String r0 = this.c.c();
        if (r0 != null) goto L5;
        return true;
    L5:
        Integer r2 = this.c.a();
        if (r2 == null) goto L43;
        r2.intValue();
        String r3 = this.c.d();
        Integer r4 = this.c.e();
        if (r4 != null) goto L11;
    L13:
        if (r4 != null) goto L16;
    L18:
        if (r4 != null) goto L21;
    L23:
        String r5 = "";
    L24:
        String r6 = Intrinsics.stringPlus(r3, r5);
        String r7 = ((SharedPrefHelper) this.a.getValue()).j(r6, "");
        if (r7 != null) goto L27;
    L30:
        boolean r8 = true;
    L31:
        if (r8 == false) goto L33;
        ECStoreCommonIntercept.a r9 = new ECStoreCommonIntercept.a();
    L34:
        long r10 = System.currentTimeMillis();
        if (this.c.f() == null) goto L40;
        if ((r9.b() + (this.b * ((long) this.c.f().intValue()))) >= r10) goto L40;
        r9.c(1);
        r9.d(r10);
        SharedPrefHelper r11 = (SharedPrefHelper) this.a.getValue();
        r11.l(r6, u0.d(r9));
        r11.a();
    L40:
        if (r9.a() < this.c.a().intValue()) goto L42;
        boolean r12 = false;
    L44:
        if (r12 == true) goto L46;
        return true;
    L46:
        m0 r1 = new m0(r0);
        Activity r13 = l0.b(r15);
        String r16 = null;
        if (r13 == null) goto L49;
        String r17 = hm.c.e(r13);
    L50:
        r1.b("entrance_info", r17);
        r1.b("shop_id", r14.getStoreParam().getShopId());
        r1.b("author_id", r14.getStoreParam().getStoreAccountParam().getUserId());
        Integer r18 = r14.getStoreParam().getFollowStatus();
        if (r18 == null) goto L53;
        r16 = String.valueOf(r18.intValue());
    L53:
        r1.b("follow_status", r16);
        r1.b("close_store_method", this.d);
        r1.b("data", r14.getStayPopupData());
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(r15, r1.c());
        return false;
    L49:
        r17 = null;
        goto L50
    L42:
        r9.c(r9.a() + 1);
        SharedPrefHelper r19 = (SharedPrefHelper) this.a.getValue();
        r19.l(r6, u0.d(r9));
        r19.a();
        goto L43
    L33:
        r9 = (ECStoreCommonIntercept.a) u0.b(r7, ECStoreCommonIntercept.a.class);
        goto L34
    L27:
        if (r7.length() == 0) goto L30;
        r8 = false;
        goto L31
    L21:
        if (r4.intValue() != 3) goto L23;
        r5 = Intrinsics.stringPlus(r14.getStoreParam().getStoreAccountParam().getUserId(), r14.getStoreParam().getSecShopId());
        goto L24
    L16:
        if (r4.intValue() != 2) goto L18;
        r5 = r14.getStoreParam().getSecShopId();
        goto L24
    L11:
        if (r4.intValue() != 1) goto L13;
        r5 = r14.getStoreParam().getStoreAccountParam().getUserId();
    L43:
        r12 = true;
        goto L44
    }
}
