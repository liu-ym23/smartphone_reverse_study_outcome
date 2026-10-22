package com.bytedance.android.shopping.mall.feed.help;

import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.shopping.api.mall.model.BffBizInfo;
import com.bytedance.android.shopping.api.mall.model.HomePageBffDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.google.gson.Gson;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p {
    public static final /* synthetic */ int e = 0;
    public final String a;
    public final HomePageDTO b;
    public final ECHybridListDTO c;
    public final com.bytedance.android.ec.hybrid.list.entity.k d;

    public static final class a {
        public static p a(String r9, String r10) {
            Intrinsics.checkNotNullParameter(r9, "result");
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L28
            Gson r2 = com.bytedance.android.shopping.api.mall.common.tools.p.a;     // Catch: Throwable -> L28
            HomePageDTO r3 = (HomePageDTO) com.bytedance.android.shopping.api.mall.common.tools.p.a(r9, HomePageDTO.class);     // Catch: Throwable -> L28
            if (r3 != null) goto L6;
        L26:
            Result.constructor-impl(null);     // Catch: Throwable -> L28
        L31:
            return new p(r9, null, null, null);
        L6:
            if (r10 != null) goto L8;
        L11:
            boolean r4 = true;
        L12:
            if (r4 == true) goto L14;
            h.a(r3, r10);     // Catch: Throwable -> L28
        L14:
            HomePageBffDTO r11 = r3.getBff();     // Catch: Throwable -> L28
            if (r11 == null) goto L26;
            ECHybridListDTO r12 = r11.getFeed();     // Catch: Throwable -> L28
            if (r12 == null) goto L26;
            ECHybridListDTO.a r5 = ECHybridListDTO.Companion;     // Catch: Throwable -> L28
            HomePageBffDTO r7 = r3.getBff();     // Catch: Throwable -> L28
            if (r7 == null) goto L23;
            BffBizInfo r8 = r7.getBizInfo();     // Catch: Throwable -> L28
            if (r8 == null) goto L23;
            String r13 = r8.getEcSceneId();     // Catch: Throwable -> L28
        L24:
            com.bytedance.android.ec.hybrid.list.entity.dto.a r6 = new com.bytedance.android.ec.hybrid.list.entity.dto.a(1, r13, 190);     // Catch: Throwable -> L28
            r5.getClass();     // Catch: Throwable -> L28
            return new p(r9, r3, r12, ECHybridListDTO.a.d(r12, false, r6));
        L23:
            r13 = null;
            goto L24
        L8:
            if (r10.length() == 0) goto L11;
            r4 = false;
        L28:
            th = move-exception;
            Result.Companion r14 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L31
        }
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof p) == false) goto L14;
        p r4 = (p) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        HomePageDTO r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ECHybridListDTO r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        com.bytedance.android.ec.hybrid.list.entity.k r10 = this.d;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "MallSaasApiResult(originResult=" + this.a + ", homepageDto=" + this.b + ", listDto=" + this.c + ", listVo=" + this.d + ")";
    }

    public p(String r2, HomePageDTO r3, ECHybridListDTO r4, com.bytedance.android.ec.hybrid.list.entity.k r5) {
        Intrinsics.checkNotNullParameter(r2, "originResult");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
