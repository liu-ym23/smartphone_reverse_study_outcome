package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionProductDetailStruct;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import com.google.gson.JsonObject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends VOIdentifier {
    public static final /* synthetic */ int d = 0;
    public final PromotionProductDetailStruct b;
    public final ComponentDTO c;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv4.voavhs.detailhead.a$a, reason: collision with other inner class name */
    public static final class C0007a {
        public static d a(ComponentDTO r2) {
            Intrinsics.checkNotNullParameter(r2, "componentDTO");
            Object r0 = null;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
            VO r3 = r2.getVo();     // Catch: Throwable -> L13
            if (r3 == null) goto L6;
            JsonObject r4 = r3.getDisplay();     // Catch: Throwable -> L13
        L7:
            PromotionProductDetailStruct r5 = (PromotionProductDetailStruct) u0.a(r4, PromotionProductDetailStruct.class);     // Catch: Throwable -> L13
            if (r5 == null) goto L10;
            d r6 = v63.d.a(r5);     // Catch: Throwable -> L13
        L11:
            Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L13
        L15:
            Throwable r8 = Result.exceptionOrNull-impl(r7);
            if (r8 == null) goto L19;
            ECExceptionMonitor.e(r8);
        L19:
            if (Result.isFailure-impl(r7) == true) goto L23;
            r0 = r7;
        L23:
            return (d) r0;
        L10:
            r6 = null;
            goto L11
        L6:
            r4 = null;
        L13:
            th = move-exception;
            Result.Companion r9 = Result.Companion;
            r7 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L15
        }
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L10;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        PromotionProductDetailStruct r0 = this.b;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ComponentDTO r4 = this.c;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "AnchorV4CombineVO(display=" + this.b + ", component=" + this.c + ")";
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier
    public final String identifier() {
        ComponentDTO r0 = this.c;
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

    public a() {
        this.b = null;
        this.c = null;
    }
}
