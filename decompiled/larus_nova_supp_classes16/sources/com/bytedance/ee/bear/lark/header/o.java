package com.bytedance.ee.bear.lark.header;

import com.bytedance.ee.bear.list.homepage.banner.BitableBannerConfig;
import com.bytedance.ee.bear.list.homepage.banner.MoreButton;
import com.bytedance.ee.bear.list.homepage.banner.RecommendView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class o implements Runnable {
    public final /* synthetic */ n a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public o(n r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        n r0 = this.a;
        BitableBannerConfig r1 = r0.c;
        if (r1 == null) goto L21;
        String r2 = this.b;
        String r3 = this.c;
        RecommendView r4 = r0.a;
        if (r4 == null) goto L17;
        String r5 = r1.getBannerTitle();
        if (r5 == null) goto L10;
        r2 = r5;
    L10:
        MoreButton r6 = r1.getMoreBtn();
        if (r6 == null) goto L16;
        String r7 = r6.getText();
        if (r7 == null) goto L16;
        r3 = r7;
    L16:
        Intrinsics.checkNotNullParameter(r2, "leftTitle");
        Intrinsics.checkNotNullParameter(r3, "rightTitle");
        r4.a.setLeftTitle(r2);
        r4.a.setRightTitle(r3);
    L17:
        RecommendView r8 = r0.a;
        if (r8 == null) goto L22;
        r8.setCardsData(r1.getCards());
        return;
    L22:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
