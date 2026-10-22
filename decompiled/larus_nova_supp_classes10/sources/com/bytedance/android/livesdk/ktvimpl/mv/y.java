package com.bytedance.android.livesdk.ktvimpl.mv;

import com.bytedance.android.livesdk.message.model.KtvMusic;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class y {
    public ArrayList<Function3<l, Integer, String, Unit>> a;
    public final long b;
    public final String c;
    public final String d;
    public final Long e;
    public Integer f;

    public static final class a {
    }

    static {
    }

    public /* synthetic */ y() {
        throw null;
    }

    public final int hashCode() {
        long r0 = this.b;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.c;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = (r1 + r4) * 31;
        String r6 = this.d;
        if (r6 == null) goto L9;
        int r7 = r6.hashCode();
    L10:
        int r8 = (r5 + r7) * 31;
        Long r9 = this.e;
        if (r9 == null) goto L13;
        int r10 = r9.hashCode();
    L14:
        int r11 = (r8 + r10) * 31;
        Integer r12 = this.f;
        if (r12 == null) goto L18;
        r3 = r12.hashCode();
    L18:
        return r11 + r3;
    L13:
        r10 = 0;
        goto L14
    L9:
        r7 = 0;
        goto L10
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "SongMvParam(songId=" + this.b + ", songName=" + this.c + ", orderUidString=" + this.d + ", songOffset=" + this.e + ", fetchType=" + this.f + ")";
    }

    public final boolean equals(Object r6) {
        if ((r6 instanceof y) == false) goto L12;
        y r7 = (y) r6;
        if (r7.b == this.b) goto L7;
    L9:
        return false;
    L7:
        if (Intrinsics.areEqual(this.d, r7.d) == false) goto L9;
        return true;
    L12:
        return super.equals(r6);
    }

    public y(KtvMusic r10, Integer r11) {
        Intrinsics.checkNotNullParameter(r10, "music");
        this(r10.getMId(), r10.getMTitle(), r10.getOrderUserIdString(), null, r11, 8);
    }

    public y(long r2, String r4, String r5, Long r6, Integer r7) {
        Intrinsics.checkNotNullParameter(r5, "orderUidString");
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }

    public /* synthetic */ y(long r10, String r12, String r13, Long r14, Integer r15, int r16) {
        if ((r16 & 2) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r16 & 8) == 0) goto L9;
        Long r7 = null;
    L11:
        if ((r16 & 16) == 0) goto L13;
        Integer r8 = null;
    L14:
        this(r10, r5, r13, r7, r8);
        return;
    L13:
        r8 = r15;
        goto L14
    L9:
        r7 = r14;
        goto L11
    L5:
        r5 = r12;
        goto L7
    }
}
