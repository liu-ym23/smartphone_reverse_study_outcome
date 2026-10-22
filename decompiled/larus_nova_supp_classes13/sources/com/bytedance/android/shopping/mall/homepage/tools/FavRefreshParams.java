package com.bytedance.android.shopping.mall.homepage.tools;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class FavRefreshParams {
    public static final /* synthetic */ int f = 0;
    public final boolean a;
    public final Map<String, Object> b;
    public final boolean c;
    public final com.bytedance.android.shopping.mall.opt.g d;
    public final Function1<com.bytedance.android.shopping.api.mall.c, Unit> e;

    public static final class Companion {
        public static FavRefreshParams a(boolean r8, JSONObject r9, String r10, boolean r11, com.bytedance.android.shopping.mall.opt.g r12) {
            if (r9 != null) goto L7;
            if (r10 != null) goto L7;
            if (r8 == true) goto L7;
            LinkedHashMap r0 = null;
        L8:
            LinkedHashMap r3 = r0;
            if (r9 == null) goto L12;
            if (r3 == null) goto L12;
            r3.put("pitaya_actions", r9);
        L12:
            if (r10 == null) goto L15;
            if (r3 == null) goto L15;
            r3.put("revert_filters", r10);
        L15:
            if (r3 == null) goto L18;
            r3.put("skip_reset_params", Boolean.valueOf(r8));
        L18:
            return new FavRefreshParams(false, r3, r11, r12, FavRefreshParams$Companion$valueOf$3.INSTANCE, 1);
        L7:
            r0 = new LinkedHashMap();
            goto L8
        }
    }

    static {
    }

    public FavRefreshParams() {
        throw null;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof FavRefreshParams) == false) goto L16;
        FavRefreshParams r4 = (FavRefreshParams) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        Map<String, Object> r4 = this.b;
        int r5 = 0;
        if (r4 == null) goto L8;
        int r6 = r4.hashCode();
    L9:
        int r7 = (r3 + r6) * 31;
        boolean r8 = this.c;
        if (r8 == true) goto L13;
        r1 = r8;
    L13:
        int r9 = (r7 + r1) * 31;
        com.bytedance.android.shopping.mall.opt.g r10 = this.d;
        if (r10 == null) goto L16;
        int r11 = r10.hashCode();
    L17:
        int r12 = (r9 + r11) * 31;
        Function1<com.bytedance.android.shopping.api.mall.c, Unit> r13 = this.e;
        if (r13 == null) goto L21;
        r5 = r13.hashCode();
    L21:
        return r12 + r5;
    L16:
        r11 = 0;
        goto L17
    L8:
        r6 = 0;
        goto L9
    }

    public final String toString() {
        return "FavRefreshParams(requestButRefresh=" + this.a + ", insertParams=" + this.b + ", allowTabNot0=" + this.c + ", event=" + this.d + ", requestResult=" + this.e + ")";
    }

    public FavRefreshParams(boolean r4, Map r5, boolean r6, com.bytedance.android.shopping.mall.opt.g r7, Function1 r8, int r9) {
        if ((r9 & 1) == 0) goto L6;
        r4 = false;
    L6:
        if ((r9 & 2) == 0) goto L9;
        r5 = null;
    L9:
        if ((r9 & 4) == 0) goto L12;
        r6 = false;
    L12:
        if ((r9 & 8) == 0) goto L14;
        r7 = null;
    L14:
        Intrinsics.checkNotNullParameter(r8, "requestResult");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
    }
}
