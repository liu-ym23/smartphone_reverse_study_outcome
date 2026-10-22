package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected;

import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final HashMap<String, k> d;
    public final boolean e;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L16;
        a r4 = (a) r3;
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
        if (this.e == r4.e) goto L25;
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
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
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
        HashMap<String, k> r10 = this.d;
        if (r10 == null) goto L14;
        int r11 = r10.hashCode();
    L15:
        int r12 = (r9 + r11) * 31;
        boolean r13 = this.e;
        if (r13 == true) goto L20;
        r1 = r13;
    L20:
        return r12 + r1;
    L14:
        r11 = 0;
        goto L15
    }

    public final String toString() {
        return "ExtraMusicData(isAdmin=" + this.a + ", isInChorus=" + this.b + ", multiChorusJoined=" + this.c + ", multiChorusInfo=" + this.d + ", firstSongHasNoCopyright=" + this.e + ")";
    }

    public final boolean a(a r5) {
        Intrinsics.checkNotNullParameter(r5, "newData");
        if (this.e == r5.e) goto L6;
        return false;
    L6:
        if (((Boolean) h.k1.getValue(null, h.a[113(0x71, float:1.58E-43)])).booleanValue() == false) goto L18;
        if (this.a == r5.a) goto L10;
        return false;
    L10:
        if (this.b == r5.b) goto L12;
        return false;
    L12:
        if (this.c == r5.c) goto L14;
        return false;
    L14:
        if (KtvUtilsKt.r(this.d, r5.d) == false) goto L26;
        return true;
    L26:
        return false;
    L18:
        if (this.a == r5.a) goto L20;
        return false;
    L20:
        if (this.b != r5.b) goto L28;
        return true;
    L28:
        return false;
    }

    public a(boolean r1, boolean r2, boolean r3, HashMap<String, k> r4, boolean r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
