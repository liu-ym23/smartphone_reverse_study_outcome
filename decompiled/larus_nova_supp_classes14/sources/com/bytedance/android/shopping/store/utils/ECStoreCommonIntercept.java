package com.bytedance.android.shopping.store.utils;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.core.utils.m0;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.store.arch.ECStoreFoldPhoneHelper;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECStoreCommonIntercept implements l {
    public final Lazy a;
    public final long b;
    public final a0 c;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/store/utils/ECStoreCommonIntercept$a;", "", "", "frequencyTime", "I", "a", "()I", "c", "(I)V", "", "timeMills", "J", "b", "()J", "d", "(J)V", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("frequency_time")
        private int frequencyTime;

        @SerializedName("time_mills")
        private long timeMills;

        public a() {
        }

        public final int a() {
            return this.frequencyTime;
        }

        public final long b() {
            return this.timeMills;
        }

        public final void c(int r1) {
            this.frequencyTime = r1;
        }

        public final void d(long r1) {
            this.timeMills = r1;
        }
    }

    public ECStoreCommonIntercept(a0 r3) {
        Intrinsics.checkNotNullParameter(r3, "storeIntercept");
        this.c = r3;
        this.a = LazyKt.lazy(ECStoreCommonIntercept$sharedPrefHelper$2.INSTANCE);
        this.b = 86400000;
    }

    @Override // com.bytedance.android.shopping.store.utils.l
    public final boolean a(ECStoreViewModel r13, Context r14) {
        Intrinsics.checkNotNullParameter(r13, "viewModel");
        Intrinsics.checkNotNullParameter(r14, "context");
        String r0 = this.c.c();
        if (r0 != null) goto L6;
        return true;
    L6:
        if (this.c.g() != null) goto L8;
    L9:
        Integer r2 = this.c.a();
        if (r2 == null) goto L30;
        r2.intValue();
        String r3 = ((SharedPrefHelper) this.a.getValue()).j(r13.getStoreParam().getInterceptBackProcessType(), "");
        if (r3 != null) goto L14;
    L17:
        boolean r4 = true;
    L18:
        if (r4 == false) goto L20;
        a r5 = new a();
    L21:
        long r6 = System.currentTimeMillis();
        if (this.c.f() == null) goto L27;
        if ((r5.b() + (this.b * ((long) this.c.f().intValue()))) >= r6) goto L27;
        r5.c(1);
        r5.d(r6);
        SharedPrefHelper r7 = (SharedPrefHelper) this.a.getValue();
        r7.l(r13.getStoreParam().getInterceptBackProcessType(), u0.d(r5));
        r7.a();
    L27:
        if (r5.a() < this.c.a().intValue()) goto L29;
        boolean r8 = false;
    L31:
        if (r8 == true) goto L33;
    L32:
        return true;
    L33:
        m0 r1 = new m0(r0);
        Activity r9 = l0.b(r14);
        if (r9 == null) goto L36;
        String r10 = hm.c.e(r9);
    L37:
        r1.b("entrance_info", r10);
        r1.b("shop_id", r13.getStoreParam().getShopId());
        r1.b("sec_shop_id", r13.getStoreParam().getSecShopId());
        r1.b("author_id", r13.getStoreParam().getStoreAccountParam().getUserId());
        String r15 = r1.c();
        com.bytedance.android.ec.sdk.helper.p r11 = com.bytedance.android.ec.sdk.helper.p.a;
        ECStoreFoldPhoneHelper.b(r15);
        r11.openSchema(r14, r15);
        return false;
    L36:
        r10 = null;
        goto L37
    L29:
        r5.c(r5.a() + 1);
        SharedPrefHelper r12 = (SharedPrefHelper) this.a.getValue();
        r12.l(r13.getStoreParam().getInterceptBackProcessType(), u0.d(r5));
        r12.a();
        goto L30
    L20:
        r5 = (a) u0.b(r3, a.class);
        goto L21
    L14:
        if (r3.length() == 0) goto L17;
        r4 = false;
    L30:
        r8 = true;
        goto L31
    L8:
        if ((!Intrinsics.areEqual((Boolean) r13.isFollowed().getValue(), this.c.g())) == true) goto L32;
        goto L9
    }
}
