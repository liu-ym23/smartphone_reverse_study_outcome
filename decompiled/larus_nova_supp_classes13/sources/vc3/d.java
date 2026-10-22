package vc3;

import android.view.View;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public final String a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final View e;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L16;
        d r4 = (d) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
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
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.c;
        ?? r8 = 1;
        ?? r9 = r7;
        if (r7 == false) goto L13;
        r9 = 1;
    L13:
        int r10 = (r6 + r9) * 31;
        boolean r11 = this.d;
        if (r11 == true) goto L17;
        r8 = r11;
    L17:
        int r12 = (r10 + r8) * 31;
        View r13 = this.e;
        if (r13 == null) goto L21;
        r1 = r13.hashCode();
    L21:
        return r12 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "SlcOpenActionParams(area=" + this.a + ", btm=" + this.b + ", btmAppendIndex=" + this.c + ", btmTokenAppendBcm=" + this.d + ", view=" + this.e + ")";
    }

    public d(String r2, String r3, boolean r4, boolean r5, View r6) {
        Intrinsics.checkNotNullParameter(r2, "area");
        Intrinsics.checkNotNullParameter(r3, "btm");
        Intrinsics.checkNotNullParameter(r6, FreqActions.ACTION_VIEW);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
