package com.bytedance.android.livesdk.livecommerce.intro.event;

import com.bytedance.android.livesdk.livecommerce.intro.model.resp.g0;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import sg2.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h implements Runnable {
    public final /* synthetic */ IntroCardEventCenter a;

    public h(IntroCardEventCenter r1) {
        this.a = r1;
    }

    public final void a() {
        com.bytedance.android.ec.common.api.jump.model.g r0 = IntroCardEventCenter.c(this.a);
        if (r0 == null) goto L18;
        ql.a r1 = r0.a;
        String r3 = null;
        if ((r1 instanceof IntroPromotionVO) == true) goto L7;
        r1 = null;
    L7:
        IntroPromotionVO r2 = (IntroPromotionVO) r1;
        if (r2 == null) goto L19;
        v r4 = new v("livesdk_size_card_show", r0);
        g0 r5 = r2.getSecondFrame();
        if (r5 == null) goto L12;
        Map<String, String> r6 = r5.a();
    L13:
        r4.d(r6);
        a r7 = this.a.a;
        if (r7 == null) goto L16;
        r7.a();
        r3 = "a1128.b3295.c59667.d30609";
    L16:
        r4.i(r3);
        return;
    L12:
        r6 = null;
        goto L13
    L19:
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
