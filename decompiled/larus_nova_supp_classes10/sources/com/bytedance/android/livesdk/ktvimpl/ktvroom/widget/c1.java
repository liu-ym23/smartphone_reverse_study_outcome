package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c1<T> implements Consumer {
    public final /* synthetic */ KtvRoomAnchorWidget a;

    public c1(KtvRoomAnchorWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        zg1.g r4 = (zg1.g) r3;
        ALogger.i("KtvRoomAnchorWidget", "received ApmOpenMulitLinkMicControlEvent");
        if (jc1.k.n(IInteractService.class).isEnableTalkRoomEmoji() == false) goto L13;
        KtvRoomAnchorWidget r5 = this.a;
        int r0 = KtvRoomAnchorWidget.x1;
        ILinkPlayerInfoBridge r6 = r5.yq().p(je0.d.b0(), tc0.c.h().f);
        if (r6 == null) goto L11;
        DataCenter r1 = ((Widget) this.a).dataCenter;
        if (r6.getSilenceStatus() == 0) goto L9;
        boolean r7 = true;
    L10:
        r1.put("data_self_is_silenced", Boolean.valueOf(r7));
        goto L11
    L9:
        r7 = false;
    L11:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.emoji.a r8 = new com.bytedance.android.livesdk.ktvimpl.ktvroom.emoji.a();
        r8.b(((Widget) this.a).context);
        r8.c(((Widget) this.a).dataCenter);
        r8.c = Boolean.TRUE;
        Intrinsics.checkNotNullParameter("seat", "requestPage");
        r8.d = "seat";
        r8.a().a();
        return;
    }
}
