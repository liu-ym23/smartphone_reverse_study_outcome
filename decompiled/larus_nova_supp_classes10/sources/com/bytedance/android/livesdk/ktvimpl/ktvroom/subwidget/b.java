package com.bytedance.android.livesdk.ktvimpl.ktvroom.subwidget;

import ch0.m;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import hh1.w0;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ KtvRoomContainerBaseWidget a;

    public b(KtvRoomContainerWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        m r7 = (m) r6;
        ALogger.i("KtvRoomContainerBaseWidget", "waitingUserMergeDataListObservable, size: " + r7.a);
        KtvRoomContainerBaseWidget r0 = this.a;
        List r8 = r7.a;
        if (r8 == null) goto L5;
        List r9 = CollectionsKt.toMutableList(r8);
    L6:
        List r10 = TypeIntrinsics.asMutableList(r9);
        if (r0.q.isAnchor() == true) goto L10;
        IMiddlewareUserService r1 = k.f(IMiddlewareUserService.class);
        Intrinsics.checkNotNull(r1);
        if (r1.user().c() == true) goto L10;
        return;
    L10:
        w0 r2 = r0.D;
        if (r2 == null) goto L16;
        if (r10 == null) goto L15;
        r2.O6(r10);
        goto L16
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge>");
    L16:
        String r3 = "";
        if (Lists.isEmpty(r10) == false) goto L21;
        DataCenter r11 = r0.q.getDataCenter();
        if (r11 == null) goto L32;
        r11.put("data_audio_talk_dot_with_number_show", "");
        return;
    L32:
        return;
    L21:
        y r12 = r0.E;
        Intrinsics.checkNotNull(r12);
        int r13 = ((ArrayList) r12.V4()).size();
        String r4 = Integer.toString(r13);
        if (r13 <= 99) goto L24;
        r4 = "99+";
    L24:
        if (r13 <= 0) goto L27;
        r3 = r4;
    L27:
        DataCenter r14 = r0.q.getDataCenter();
        if (r14 == null) goto L34;
        r14.put("data_audio_talk_dot_with_number_show", r3);
        return;
    L34:
        return;
    L5:
        r9 = null;
        goto L6
    }
}
