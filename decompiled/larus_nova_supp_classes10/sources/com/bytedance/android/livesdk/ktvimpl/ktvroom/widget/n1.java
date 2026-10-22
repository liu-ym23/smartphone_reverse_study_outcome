package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.bytedance.android.livesdk.ktvimpl.ktvroom.subwidget.KtvRoomContainerWidget;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n1<T> implements Consumer {
    public final /* synthetic */ KtvRoomGuestWidget a;

    public n1(KtvRoomGuestWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Intrinsics.checkNotNullParameter((fd2.z) r3, "event");
        KtvRoomGuestWidget r4 = this.a;
        int r0 = KtvRoomGuestWidget.G2;
        if (com.bytedance.android.live.liveinteract.spatial.a.e(r4.C0()) == false) goto L10;
        jy0.b.a("SpatialAudio_KtvRoomGuestWidget", "singerChanged updateSpatialAudioPosition------");
        KtvRoomContainerWidget r5 = r4.Y;
        if (r5 == null) goto L11;
        qe2.a r6 = r5.e;
        if (r6 == null) goto L12;
        r6.b();
        return;
    L12:
        return;
    L11:
        return;
    }
}
