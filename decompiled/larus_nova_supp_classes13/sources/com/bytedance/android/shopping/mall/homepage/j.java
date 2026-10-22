package com.bytedance.android.shopping.mall.homepage;

import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.bytedance.android.shopping.mall.homepage.tools.DataEngineWrapper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j implements ECMallFeed.b {
    public final /* synthetic */ ECMallFragment a;

    public j(ECMallFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.b
    public final void b(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "schema");
        DataEngineWrapper r5 = this.a.L0;
        if (r5 == null) goto L7;
        y93.a r6 = r5.b;
        if (r6 == null) goto L7;
        Long r7 = r6.j();
    L8:
        if (r7 == null) goto L10;
        return;
    L10:
        Integer r8 = this.a.G1.b();
        int r0 = 0;
        if (r8 == null) goto L13;
        int r9 = r8.intValue();
    L14:
        int r10 = (r4 ? 1 : 0) + r9;
        Integer r11 = this.a.G1.c();
        if (r11 == null) goto L17;
        r0 = r11.intValue();
    L17:
        ECMallFragment r12 = this.a;
        y93.g r1 = r12.G1;
        Integer r13 = Integer.valueOf(r10);
        r12.G1 = y93.g.a(r1, Integer.valueOf(r0 + 1), r13);
        return;
    L13:
        r9 = 0;
    L7:
        r7 = null;
        goto L8
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.b
    public final void a(String r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "viewType");
        DataEngineWrapper r6 = this.a.L0;
        if (r6 == null) goto L7;
        y93.a r7 = r6.b;
        if (r7 == null) goto L7;
        Long r8 = r7.j();
    L8:
        if (r8 == null) goto L10;
        return;
    L10:
        Integer r9 = this.a.H1.a();
        int r0 = 0;
        if (r9 == null) goto L13;
        int r10 = r9.intValue();
    L14:
        int r11 = (r4 ? 1 : 0) + r10;
        Integer r12 = this.a.H1.b();
        if (r12 == null) goto L17;
        int r13 = r12.intValue();
    L18:
        int r14 = r13 + 1;
        Integer r1 = this.a.H1.c();
        if (r1 == null) goto L21;
        r0 = r1.intValue();
    L21:
        int r15 = (r5 ? 1 : 0) + r0;
        ECMallFragment r2 = this.a;
        y93.f r16 = r2.H1;
        Integer r17 = Integer.valueOf(r14);
        Integer r18 = Integer.valueOf(r11);
        Integer r19 = Integer.valueOf(r15);
        r16.getClass();
        r2.H1 = new y93.f(r17, r18, r19);
        return;
    L17:
        r13 = 0;
        goto L18
    L13:
        r10 = 0;
    L7:
        r8 = null;
        goto L8
    }
}
