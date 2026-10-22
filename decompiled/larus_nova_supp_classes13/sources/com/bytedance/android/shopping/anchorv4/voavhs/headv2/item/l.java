package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item;

import com.bytedance.android.shopping.anchorv4.video.base.BasePdpVideoView;
import com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.HeadVideoController;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l implements com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.m {
    public final /* synthetic */ k a;

    public l(k r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.m
    public final void a(com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.l r4) {
        Intrinsics.checkNotNullParameter(r4, "wrapper");
        r4.e.g(this.a);
        k r0 = this.a;
        HeadVideoController r1 = r0.c;
        if (r1 == null) goto L10;
        Function1<Boolean, Unit> r2 = r0.g;
        Intrinsics.checkNotNullParameter(r2, "listener");
        BasePdpVideoView r3 = r1.d;
        if (r3 == null) goto L10;
        Intrinsics.checkNotNullParameter(r2, "listener");
        y73.a r5 = r3.c;
        if (r5 == null) goto L10;
        r5.j(r2);
    L10:
        if (Intrinsics.areEqual(r4.e.getParentView(), this.a) == false) goto L13;
        k r6 = this.a;
        r6.getClass();
        r6.removeView(k.g(r4));
    L13:
        if (Intrinsics.areEqual(r4, this.a.a) == false) goto L16;
        this.a.a = null;
        return;
    }
}
