package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.card;

import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import com.bytedance.bpea.cert.token.TokenCert;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b extends vb6.a {
    public final /* synthetic */ KtvRoomCardWidget a;

    public b(KtvRoomCardWidget r1) {
        this.a = r1;
    }

    public final void u4(long r1, ec6.a r3) {
        Intrinsics.checkNotNullParameter(r3, "client");
        if (KSongTuningPanelHelperKt.d() != null) goto L10;
        sk0.c r2 = r3.r();
        if (r2 == null) goto L7;
        com.bytedance.android.live.pushstream.d r4 = gc6.b.a(r2);
    L8:
        KtvRoomCardWidget r5 = this.a;
        TokenCert r6 = KtvRoomCardWidget.s;
        r5.yq(r4);
        return;
    L7:
        r4 = null;
        goto L8
    }
}
