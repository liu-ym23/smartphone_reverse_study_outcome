package com.bytedance.android.shopping.deepfeed.slice.view.list;

import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final Pair<String, Map<String, Object>> d;
    public final Pair<String, Map<String, Object>> e;
    public final Integer f;
    public final boolean g;
    public final boolean h;

    public c() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L22;
        c r4 = (c) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (this.g == r4.g) goto L20;
        return false;
    L20:
        if (this.h == r4.h) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.b;
        ?? r5 = r4;
        if (r4 == false) goto L8;
        r5 = 1;
    L8:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.c;
        ?? r8 = r7;
        if (r7 == false) goto L11;
        r8 = 1;
    L11:
        int r9 = (r6 + r8) * 31;
        Pair<String, Map<String, Object>> r10 = this.d;
        int r11 = 0;
        if (r10 == null) goto L14;
        int r12 = r10.hashCode();
    L15:
        int r13 = (r9 + r12) * 31;
        Pair<String, Map<String, Object>> r14 = this.e;
        if (r14 == null) goto L18;
        int r15 = r14.hashCode();
    L19:
        int r16 = (r13 + r15) * 31;
        Integer r17 = this.f;
        if (r17 == null) goto L22;
        r11 = r17.hashCode();
    L22:
        int r18 = (r16 + r11) * 31;
        boolean r19 = this.g;
        ?? r20 = r19;
        if (r19 == false) goto L25;
        r20 = 1;
    L25:
        int r21 = (r18 + r20) * 31;
        boolean r22 = this.h;
        if (r22 == true) goto L30;
        r1 = r22;
    L30:
        return r21 + r1;
    L18:
        r15 = 0;
        goto L19
    L14:
        r12 = 0;
        goto L15
    }

    public final String toString() {
        return "DeepFeedSlcListData(visible=" + this.a + ", loopScroll=" + this.b + ", footer=" + this.c + ", action=" + this.d + ", slideAction=" + this.e + ", scrollToIndex=" + this.f + ", syncSelectedToState=" + this.g + ", keepPositionOnStop=" + this.h + ")";
    }

    public /* synthetic */ c(int r10) {
        this(false, false, false, null, null, null, false, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(boolean r1, boolean r2, boolean r3, Pair<String, ? extends Map<String, ? extends Object>> r4, Pair<String, ? extends Map<String, ? extends Object>> r5, Integer r6, boolean r7, boolean r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}
