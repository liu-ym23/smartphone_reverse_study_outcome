package com.bytedance.android.shopping.anchorv4.voavhs.receivingnotice;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.UI;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import com.google.gson.JsonObject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends VOIdentifier {
    public static final /* synthetic */ int f = 0;
    public AnchorV4ReceivingNoticeDisplay b;
    public AnchorV4ReceivingNoticeMeta c;
    public ComponentDTO d;
    public com.bytedance.android.shopping.anchorv4.dto.business.a e;

    public static final class a {
        public static c a(ComponentDTO r4) {
            Intrinsics.checkNotNullParameter(r4, "componentDTO");
            Object r0 = null;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L17
            c r2 = new c(0);     // Catch: Throwable -> L17
            VO r3 = r4.getVo();     // Catch: Throwable -> L17
            if (r3 == null) goto L6;
            JsonObject r5 = r3.getDisplay();     // Catch: Throwable -> L17
        L7:
            r2.b = (AnchorV4ReceivingNoticeDisplay) u0.a(r5, AnchorV4ReceivingNoticeDisplay.class);     // Catch: Throwable -> L17
            VO r6 = r4.getVo();     // Catch: Throwable -> L17
            if (r6 == null) goto L10;
            JsonObject r7 = r6.getMeta();     // Catch: Throwable -> L17
        L11:
            r2.c = (AnchorV4ReceivingNoticeMeta) u0.a(r7, AnchorV4ReceivingNoticeMeta.class);     // Catch: Throwable -> L17
            r2.d = r4;     // Catch: Throwable -> L17
            UI r8 = r4.getUi();     // Catch: Throwable -> L17
            if (r8 == null) goto L14;
            com.bytedance.android.shopping.anchorv4.dto.business.a r9 = r8.getStyle();     // Catch: Throwable -> L17
        L15:
            r2.e = r9;     // Catch: Throwable -> L17
            Object r10 = Result.constructor-impl(r2);     // Catch: Throwable -> L17
        L20:
            if (Result.isFailure-impl(r10) == true) goto L24;
            r0 = r10;
        L24:
            return (c) r0;
        L14:
            r9 = null;
            goto L15
        L10:
            r7 = null;
            goto L11
        L6:
            r5 = null;
        L17:
            th = move-exception;
            Result.Companion r11 = Result.Companion;
            r10 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L20
        }
    }

    static {
    }

    public c() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L14;
        c r4 = (c) r3;
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
        AnchorV4ReceivingNoticeDisplay r0 = this.b;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        AnchorV4ReceivingNoticeMeta r4 = this.c;
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
        return "AnchorV4ReceivingNoticeVO(display=" + this.b + ", meta=" + this.c + ", component=" + this.d + ", style=" + this.e + ")";
    }

    public c(int r1) {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
    }
}
