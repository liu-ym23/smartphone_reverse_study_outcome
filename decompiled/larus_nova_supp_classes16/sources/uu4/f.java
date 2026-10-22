package uu4;

import android.util.Pair;
import com.bytedance.ee.bear.bitable.card.model.enums.ETableType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final ETableType e;
    public final Pair<Long, Long> f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.c == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.d == true) goto L18;
        r1 = 1237;
    L18:
        int r7 = (r6 + r1) * 31;
        ETableType r8 = this.e;
        int r9 = 0;
        if (r8 != null) goto L21;
        int r10 = 0;
    L22:
        int r11 = (r7 + r10) * 31;
        Pair<Long, Long> r12 = this.f;
        if (r12 == null) goto L27;
        r9 = r12.hashCode();
    L27:
        return r11 + r9;
    L21:
        r10 = r8.hashCode();
        goto L22
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "OpenRecordStartParam(isShowNormalCard=" + this.a + ", isShowInRecord=" + this.b + ", isBaseAdd=" + this.c + ", isReady=" + this.d + ", tableType=" + this.e + ", mergeDataTimes=" + this.f + ')';
    }

    public f(boolean r1, boolean r2, boolean r3, boolean r4, ETableType r5, Pair<Long, Long> r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
