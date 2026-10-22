package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import com.google.gson.JsonObject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends VOIdentifier {
    public static final /* synthetic */ int f = 0;
    public AnchorV4BaseInfoDisplay b;
    public AnchorV4BaseInfoMeta c;
    public ComponentDTO d;
    public boolean e;

    public static final class a {
        public static c a(ComponentDTO r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r4, "componentDTO");
            Object r0 = null;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
            c r2 = new c(0);     // Catch: Throwable -> L13
            VO r3 = r4.getVo();     // Catch: Throwable -> L13
            if (r3 == null) goto L6;
            JsonObject r6 = r3.getDisplay();     // Catch: Throwable -> L13
        L7:
            r2.b = (AnchorV4BaseInfoDisplay) u0.a(r6, AnchorV4BaseInfoDisplay.class);     // Catch: Throwable -> L13
            r2.e = r5;     // Catch: Throwable -> L13
            VO r7 = r4.getVo();     // Catch: Throwable -> L13
            if (r7 == null) goto L10;
            JsonObject r8 = r7.getMeta();     // Catch: Throwable -> L13
        L11:
            r2.c = (AnchorV4BaseInfoMeta) u0.a(r8, AnchorV4BaseInfoMeta.class);     // Catch: Throwable -> L13
            r2.d = r4;     // Catch: Throwable -> L13
            Object r9 = Result.constructor-impl(r2);     // Catch: Throwable -> L13
        L16:
            if (Result.isFailure-impl(r9) == true) goto L20;
            r0 = r9;
        L20:
            return (c) r0;
        L10:
            r8 = null;
            goto L11
        L6:
            r6 = null;
        L13:
            th = move-exception;
            Result.Companion r10 = Result.Companion;
            r9 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L16
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
        if (this.e == r4.e) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        AnchorV4BaseInfoDisplay r0 = this.b;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        AnchorV4BaseInfoMeta r4 = this.c;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ComponentDTO r7 = this.d;
        if (r7 == null) goto L13;
        r1 = r7.hashCode();
    L13:
        int r8 = (r6 + r1) * 31;
        boolean r9 = this.e;
        ?? r10 = r9;
        if (r9 == false) goto L17;
        r10 = 1;
    L17:
        return r8 + r10;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "AnchorV4BaseInfoVO(display=" + this.b + ", meta=" + this.c + ", component=" + this.d + ", collapseDetail=" + this.e + ")";
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

    public c(int r1) {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = false;
    }
}
