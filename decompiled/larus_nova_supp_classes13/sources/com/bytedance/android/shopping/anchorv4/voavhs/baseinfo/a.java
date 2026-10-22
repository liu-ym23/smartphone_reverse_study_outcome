package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final boolean a(ActivityVO r14) {
        if (r14 != null) goto L6;
        return false;
    L6:
        if (r14.getSubsidy() == null) goto L9;
        return true;
    L9:
        if (r14.getActivityBgUrl() != null) goto L11;
    L13:
        boolean r1 = false;
    L14:
        ActivityTime r3 = r14.getActivityTime();
        if (r3 == null) goto L17;
        long r6 = r3.getServerTime();
    L18:
        ActivityTime r4 = r14.getActivityTime();
        if (r4 == null) goto L21;
        long r8 = r4.getPreStartTime();
    L22:
        ActivityTime r5 = r14.getActivityTime();
        if (r5 == null) goto L25;
        long r10 = r5.getStartTime();
    L26:
        ActivityTime r7 = r14.getActivityTime();
        if (r7 == null) goto L29;
        long r12 = r7.getEndTime();
    L30:
        ActivityTime r9 = r14.getActivityTime();
        if (r9 == null) goto L33;
        r9.getRestBeginTime();
    L33:
        ActivityTime r15 = r14.getActivityTime();
        if (r15 == null) goto L37;
        r15.getRestEndTime();
    L37:
        if (r8 <= 0) goto L39;
    L47:
        if (r8 > 0) goto L49;
    L59:
        return r1;
    L49:
        if (r6 <= 0) goto L59;
        if (r10 > 0) goto L59;
        if (r12 > 0) goto L59;
        if (r1 == true) goto L56;
        return false;
    L56:
        if (r8 < r6) goto L63;
        return true;
    L63:
        return false;
    L39:
        if (r10 > 0) goto L47;
        if (r12 <= 0) goto L47;
        if (r1 == true) goto L44;
        return false;
    L44:
        if (r6 > r12) goto L61;
        return true;
    L61:
        return false;
    L29:
        r12 = 0;
        goto L30
    L25:
        r10 = 0;
        goto L26
    L21:
        r8 = 0;
        goto L22
    L17:
        r6 = 0;
        goto L18
    L11:
        if (r14.getPrice() == null) goto L13;
        r1 = true;
        goto L14
    }
}
