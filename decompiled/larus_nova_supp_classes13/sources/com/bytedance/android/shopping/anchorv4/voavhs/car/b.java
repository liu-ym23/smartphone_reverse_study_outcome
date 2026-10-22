package com.bytedance.android.shopping.anchorv4.voavhs.car;

import com.bytedance.android.ec.core.utils.d1;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.model.response.ProductSelectPoiInfo;
import com.bytedance.android.ec.model.sku.SkuPoiInfo;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.UI;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import com.google.gson.JsonObject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends VOIdentifier {
    public static final /* synthetic */ int f = 0;
    public AnchorV4CarAddressDisplay b;
    public AnchorV4CarAddressMeta c;
    public ComponentDTO d;
    public com.bytedance.android.shopping.anchorv4.dto.business.a e;

    public static final class a {
        public static b a(ComponentDTO r4) {
            Intrinsics.checkNotNullParameter(r4, "componentDTO");
            Object r0 = null;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L23
            b r2 = new b(0);     // Catch: Throwable -> L23
            VO r3 = r4.getVo();     // Catch: Throwable -> L23
            if (r3 == null) goto L6;
            JsonObject r5 = r3.getDisplay();     // Catch: Throwable -> L23
        L7:
            r2.b = (AnchorV4CarAddressDisplay) u0.a(r5, AnchorV4CarAddressDisplay.class);     // Catch: Throwable -> L23
            VO r6 = r4.getVo();     // Catch: Throwable -> L23
            if (r6 == null) goto L10;
            JsonObject r7 = r6.getMeta();     // Catch: Throwable -> L23
        L11:
            r2.c = (AnchorV4CarAddressMeta) u0.a(r7, AnchorV4CarAddressMeta.class);     // Catch: Throwable -> L23
            r2.d = r4;     // Catch: Throwable -> L23
            UI r8 = r4.getUi();     // Catch: Throwable -> L23
            if (r8 == null) goto L14;
            com.bytedance.android.shopping.anchorv4.dto.business.a r9 = r8.getStyle();     // Catch: Throwable -> L23
        L15:
            r2.e = r9;     // Catch: Throwable -> L23
            ProductSelectPoiInfo r10 = d1.a;     // Catch: Throwable -> L23
            AnchorV4CarAddressMeta r11 = r2.c;     // Catch: Throwable -> L23
            if (r11 == null) goto L20;
            AnchorV4CarAddressBusinessMeta r12 = r11.getBusinessMeta();     // Catch: Throwable -> L23
            if (r12 == null) goto L20;
            SkuPoiInfo r13 = r12.getPoiInfo();     // Catch: Throwable -> L23
        L21:
            d1.b = r13;     // Catch: Throwable -> L23
            Object r14 = Result.constructor-impl(r2);     // Catch: Throwable -> L23
        L26:
            if (Result.isFailure-impl(r14) == true) goto L30;
            r0 = r14;
        L30:
            return (b) r0;
        L20:
            r13 = null;
            goto L21
        L14:
            r9 = null;
            goto L15
        L10:
            r7 = null;
            goto L11
        L6:
            r5 = null;
        L23:
            th = move-exception;
            Result.Companion r15 = Result.Companion;
            r14 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L26
        }
    }

    static {
    }

    public b() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L14;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        AnchorV4CarAddressDisplay r0 = this.b;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        AnchorV4CarAddressMeta r4 = this.c;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ComponentDTO r7 = this.d;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        com.bytedance.android.shopping.anchorv4.dto.business.a r10 = this.e;
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
        return "AnchorV4CarAddressVO(display=" + this.b + ", meta=" + this.c + ", component=" + this.d + ", style=" + this.e + ")";
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier
    public final String identifier() {
        ComponentDTO r0 = this.d;
        if (r0 == null) goto L5;
        String r1 = r0.getComponentId();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public b(int r1) {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
    }
}
