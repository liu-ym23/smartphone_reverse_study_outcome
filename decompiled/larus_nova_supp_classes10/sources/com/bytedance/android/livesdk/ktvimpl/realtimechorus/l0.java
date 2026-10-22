package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l0<T> implements Consumer {
    public final /* synthetic */ RealTimeChorusMainViewWidget.e a;

    public l0(RealTimeChorusMainViewWidget.e r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        jd0.r r5 = (jd0.r) r4;
        if (this.a.a.k0.isAnchor() == true) goto L15;
        com.bytedance.android.live.pushstream.d r6 = this.a.a.V.h(false);
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = KSongTuningPanelHelperKt.d();
        com.bytedance.android.live.pushstream.d r2 = null;
        if ((r0 instanceof com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.b) == true) goto L7;
        r0 = null;
    L7:
        com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.b r1 = (com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.b) r0;
        if (r1 == null) goto L11;
        r2 = r1.s;
    L11:
        if ((!Intrinsics.areEqual(r6, r2)) == false) goto L13;
        this.a.a.Aq();
    L13:
        this.a.a.Pq();
        return;
    }
}
