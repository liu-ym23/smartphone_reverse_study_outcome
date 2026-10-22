package com.bytedance.applog.priority;

import android.util.Pair;
import com.bytedance.applog.IBDAccountCallback;
import com.bytedance.applog.b;
import com.bytedance.common.utility.NetworkUtils;
import ex3.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i implements PriorityEventMetaFactory {
    public final b a;

    public final long eventId() {
        return ex3.g.a.incrementAndGet();
    }

    public final long eventIndex() {
        return this.a.Q1();
    }

    public final int nt() {
        return NetworkUtils.getNetworkTypeFast(this.a.getContext()).getValue();
    }

    public final j user() {
        b r1 = this.a;
        if (r1.n == null) goto L5;
        long r2 = r1.n.k.a;
    L6:
        IBDAccountCallback r5 = this.a.a0;
        b r6 = this.a;
        if (r6.n == null) goto L9;
        rw3.n r7 = r6.n.k;
    L11:
        if (r5 == null) goto L22;
        Pair r8 = r5.getOdinUserInfo();
        boolean r10 = true;
        if (((Long) r8.second).longValue() <= 0) goto L15;
        long r11 = ((Long) r8.second).longValue();
        long r15 = r11;
        int r14 = ((Integer) r8.first).intValue();
        int r12 = 1;
        int r13 = 1;
    L24:
        return new j(this.a.getUserUniqueID(), r11, r12, r13, r14, r15);
    L15:
        if (r7 == null) goto L22;
        if (r7.d == 0) goto L20;
        r10 = false;
    L20:
        if (r10 == false) goto L22;
        long r3 = r7.b;
        int r9 = r7.c;
        r11 = r2;
        r15 = r3;
        r12 = r7.d;
        r13 = r7.e;
        r14 = r9;
    L22:
        r11 = r2;
        r15 = 0;
        r12 = 0;
        r13 = 0;
        r14 = 0;
        goto L24
    L9:
        r7 = null;
        goto L11
    L5:
        r2 = 0;
        goto L6
    }

    public final String abSdkVersion() {
        long r0 = user().b;
        if (r0 > 0) goto L6;
        return null;
    L6:
        b r2 = this.a;
        String.valueOf(r0);
        return r2.N1();
    }

    public i(b r1) {
        this.a = r1;
    }

    public final int sentryStainedValue(String r4) {
        e r0 = this.a.W;
        if (r0.g() == true) goto L5;
        boolean r5 = false;
    L6:
        if (r5 == true) goto L8;
        return 0;
    L8:
        if (r0.a.o == false) goto L10;
        return 3;
    L10:
        return 1;
    L5:
        r5 = r0.e(r4);
        goto L6
    }
}
