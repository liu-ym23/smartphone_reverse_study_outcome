package com.bytedance.android.shopping.anchorv4.voavhs.kolevaluation;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import com.google.gson.JsonObject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends VOIdentifier {
    public static final /* synthetic */ int e = 0;
    public final AnchorV4KolEvaluationDisplay b;
    public final AnchorV4KolEvaluationMeta c;
    public final ComponentDTO d;

    public static final class a {
        public static b a(ComponentDTO r4) {
            Intrinsics.checkNotNullParameter(r4, "componentDTO");
            Object r0 = null;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
            new b(null, null, null);     // Catch: Throwable -> L13
            VO r2 = r4.getVo();     // Catch: Throwable -> L13
            if (r2 == null) goto L6;
            JsonObject r3 = r2.getDisplay();     // Catch: Throwable -> L13
        L7:
            AnchorV4KolEvaluationDisplay r5 = (AnchorV4KolEvaluationDisplay) u0.a(r3, AnchorV4KolEvaluationDisplay.class);     // Catch: Throwable -> L13
            VO r6 = r4.getVo();     // Catch: Throwable -> L13
            if (r6 == null) goto L10;
            JsonObject r7 = r6.getMeta();     // Catch: Throwable -> L13
        L11:
            Object r8 = Result.constructor-impl(new b(r5, (AnchorV4KolEvaluationMeta) u0.a(r7, AnchorV4KolEvaluationMeta.class), r4));     // Catch: Throwable -> L13
        L16:
            if (Result.isFailure-impl(r8) == true) goto L20;
            r0 = r8;
        L20:
            return (b) r0;
        L10:
            r7 = null;
            goto L11
        L6:
            r3 = null;
        L13:
            th = move-exception;
            Result.Companion r9 = Result.Companion;
            r8 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L16
        }
    }

    static {
    }

    public b() {
        this(null, null, null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L12;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        AnchorV4KolEvaluationDisplay r0 = this.b;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        AnchorV4KolEvaluationMeta r4 = this.c;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ComponentDTO r7 = this.d;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "AnchorV4KolEvaluationVO(display=" + this.b + ", meta=" + this.c + ", component=" + this.d + ")";
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

    public b(AnchorV4KolEvaluationDisplay r1, AnchorV4KolEvaluationMeta r2, ComponentDTO r3) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
    }
}
