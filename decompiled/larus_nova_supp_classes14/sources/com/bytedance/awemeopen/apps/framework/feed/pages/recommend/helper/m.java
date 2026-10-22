package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper;

import android.content.Context;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import r14.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m {
    public final String a;
    public int b;
    public String c;
    public long d;
    public long e;

    public m() {
        this.a = Reflection.getOrCreateKotlinClass(m.class).getSimpleName();
        this.c = "";
    }

    public final void b(r14.c r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        boolean r1 = true;
        this.b++;
        String r0 = this.c;
        if (r0 != null) goto L7;
    L10:
        if (r1 == false) goto L13;
        this.c = r3.c();
        return;
    L13:
        return;
    L7:
        if (r0.length() == 0) goto L10;
        r1 = false;
        goto L10
    }

    public final void a(Context r18, String r19, String r20, r14.c r21, int r22) {
        Intrinsics.checkNotNullParameter(r19, "sceneId");
        AoLogger.b(this.a, new Object[]{"onPageDisappear"});
        boolean r4 = com.bytedance.awemeopen.infra.util.m.b(r18);
        if (this.d == 0) goto L5;
        this.e += System.currentTimeMillis() - this.d;
        this.d = 0;
    L6:
        if (r4 == true) goto L8;
        return;
    L8:
        if (r21 != null) goto L10;
        return;
    L10:
        AosEventReporter r5 = AosEventReporter.a;
        long r9 = this.e;
        int r11 = this.b;
        String r12 = this.c;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r19, "sceneId");
        Intrinsics.checkNotNullParameter(r21, "aweme");
        Intrinsics.checkNotNullParameter(r12, "groupIdFIrst");
        d14.a r3 = b14.a.a;
        t24.a r6 = b14.a.a(t24.a.class);
        User r7 = r21.f();
        if (r7 == null) goto L14;
        String r8 = r7.u();
        if (r8 == null) goto L14;
    L15:
        String r10 = r21.c();
        String r13 = AosEventReporter.b(r21, null);
        if (r13 != null) goto L20;
        if (r20 != null) goto L19;
        r13 = "";
        goto L20
    L19:
        r13 = r20;
    L20:
        a0 r14 = r21.d;
        if (r14 == null) goto L24;
        String r15 = r14.a();
        if (r15 == null) goto L24;
    L25:
        String r16 = AosEventReporter.c(r21);
        User r1 = r21.f();
        if (r1 == null) goto L28;
        boolean r17 = r1.O();
    L29:
        r6.I2(r19, r8, r10, r13, r15, r16, r17, r9, r11, r12, r22, null);
        return;
    L28:
        r17 = false;
    L24:
        r15 = "";
    L14:
        r8 = "";
        goto L15
    L5:
        AoLogger.c(this.a, new Object[]{"not paired timer"});
        goto L6
    }
}
