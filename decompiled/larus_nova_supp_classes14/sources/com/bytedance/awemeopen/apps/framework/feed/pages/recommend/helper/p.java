package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper;

import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.export.api.pageconfig.recfeed.FeedPageConfig;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import kotlin.jvm.internal.Intrinsics;
import r14.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p {
    public final String a;
    public boolean b;
    public int c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;

    public final long a() {
        boolean r1 = true;
        AoLogger.b(this.a, new Object[]{"getTotalPlayTimeInRealtime"});
        if (this.h != 0) goto L6;
        r1 = false;
    L6:
        if (r1 == false) goto L9;
        b();
    L9:
        return this.g;
    }

    public final void b() {
        AoLogger.b(this.a, new Object[]{"onPlayPause"});
        if (this.h != 0) goto L6;
        AoLogger.b(this.a, new Object[]{"not a start point"});
        return;
    L6:
        this.g += System.currentTimeMillis() - this.h;
        this.h = 0;
    }

    public p() {
        this.a = p.class.getSimpleName();
    }

    public final void c(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r18, jz3.a r19) {
        Intrinsics.checkNotNullParameter(r18, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r19, "data");
        this.d = System.currentTimeMillis();
        AoLogger.b("RecommendPageTimeEventRecoder", new Object[]{"stay_page_count_begin"});
        AosEventReporter.a.getClass();
        Intrinsics.checkNotNullParameter(r18, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r19, "data");
        Intrinsics.checkNotNullParameter(this, "eventRecorder");
        String r5 = r18.c.sceneId();
        FeedPageConfig r1 = r18.c.getPageConfig();
        String r6 = r1.getHostEnterFrom();
        d14.a r3 = b14.a.a;
        t24.a r4 = b14.a.a(t24.a.class);
        User r7 = r19.a.f();
        if (r7 == null) goto L6;
        String r8 = r7.u();
        if (r8 == null) goto L6;
    L7:
        String r9 = r19.a.c();
        String r2 = AosEventReporter.b(r19.a, r1);
        if (r2 != null) goto L10;
        String r10 = "";
    L11:
        a0 r11 = r19.a.d;
        if (r11 == null) goto L17;
        String r12 = r11.a();
        if (r12 == null) goto L17;
        String r13 = r12;
    L18:
        String r14 = r8;
        r4.c0(r5, r6, r14, r9, r10, r13, AosEventReporter.c(r19.a), AosEventReporter.e(r19.a), this.b, r19.a.e(), Integer.valueOf(r19.a.i()), null);
        return;
    L17:
        r13 = "";
        goto L18
    L10:
        r10 = r2;
    L6:
        r8 = "";
        goto L7
    }
}
