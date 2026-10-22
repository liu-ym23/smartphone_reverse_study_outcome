package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.shopping.anchorv3.AnchorV3Starter;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class PdpRootComponent$checkLawAndTrackEnterProductDetail$1 extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
    public final /* synthetic */ PdpRootComponent c;

    @Override // java.lang.Runnable
    public final void run() {
        CommonMeta r0 = this.c.O1().d().getData().a().a();
        FragmentActivity r1 = this.c.O1().getContainerAbility().mo2525getContext();
        String r2 = this.c.g2().getSessionId();
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        Function1<Boolean, Unit> r3 = new PdpRootComponent$checkLawAndTrackEnterProductDetail$1$run$1(this);
        Intrinsics.checkNotNullParameter(r3, "callback");
        if (com.bytedance.android.shopping.utils.i.a() == true) goto L5;
        com.bytedance.android.shopping.base.event.c.a(true, r2);
        int r4 = AnchorV3Starter.S;
        AnchorV3Starter.Companion.a(r1, r0, r3);
        return;
    L5:
        com.bytedance.android.shopping.base.event.c.a(false, r2);
        r3.invoke(Boolean.TRUE);
    }

    public PdpRootComponent$checkLawAndTrackEnterProductDetail$1(PdpRootComponent r1) {
        this.c = r1;
        super("check_lawer");
    }
}
