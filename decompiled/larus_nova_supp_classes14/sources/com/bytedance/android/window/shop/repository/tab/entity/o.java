package com.bytedance.android.window.shop.repository.tab.entity;

import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.shopping.api.window.AwemeInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o extends p {
    public static final /* synthetic */ int q = 0;
    public boolean n;
    public final Lazy o;
    public final String p;

    public static final class a {
    }

    static {
    }

    public final AwemeInfo e() {
        return (AwemeInfo) this.o.getValue();
    }

    public final int hashCode() {
        e r0 = this.j;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        WindowV2ProductItemVO r4 = this.k;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        int r7 = 1231;
        if (this.l == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r6 + r8) * 31;
        if (this.m == true) goto L18;
        r7 = 1237;
    L18:
        int r10 = (r9 + r7) * 31;
        AwemeInfo r11 = e();
        if (r11 == null) goto L21;
        String r12 = r11.a();
    L22:
        if (r12 == null) goto L25;
        r1 = r12.hashCode();
    L25:
        return r10 + r1;
    L21:
        r12 = null;
        goto L22
    L13:
        r8 = 1237;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    @Override // com.bytedance.android.window.shop.repository.tab.entity.f
    public final WindowV2ProductItemVO c() {
        return this.k;
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L5;
        return true;
    L5:
        String r2 = null;
        if (r6 == null) goto L8;
        Class<?> r3 = r6.getClass();
    L10:
        if ((!Intrinsics.areEqual(o.class, r3)) == false) goto L12;
        return false;
    L12:
        if (r6 == null) goto L37;
        o r7 = (o) r6;
        if ((!Intrinsics.areEqual(this.j, r7.j)) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.k, r7.k)) == false) goto L20;
        return false;
    L20:
        if (this.l == r7.l) goto L23;
        return false;
    L23:
        if (this.m == r7.m) goto L25;
        return false;
    L25:
        AwemeInfo r1 = e();
        if (r1 == null) goto L28;
        String r4 = r1.a();
    L29:
        AwemeInfo r8 = r7.e();
        if (r8 == null) goto L33;
        r2 = r8.a();
    L33:
        if ((!Intrinsics.areEqual(r4, r2)) == false) goto L35;
        return false;
    L35:
        return true;
    L28:
        r4 = null;
        goto L29
    L37:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.repository.tab.entity.WindowHangingProductVideoVO");
    L8:
        r3 = null;
        goto L10
    }

    public o(e r7, tq3.c r8, boolean r9, boolean r10, String r11) {
        super(r7, r8, r9, r10, 207);
        this.p = r11;
        this.o = LazyKt.lazy(new WindowHangingProductVideoVO$awemeInfo$2(this));
    }
}
