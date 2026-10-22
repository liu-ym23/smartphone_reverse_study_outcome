package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.message.RealTimeChorusUIInfo;
import com.bytedance.android.livesdkapi.depend.message.RealTimeChorusUIInfoKt;
import com.bytedance.android.livesdkapi.depend.message.UserChorusInfo;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f0<T> implements Consumer {
    public final /* synthetic */ RealTimeChorusMainViewWidget a;

    public f0(RealTimeChorusMainViewWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r12) {
        dc2.c.b r13 = (dc2.c.b) r12;
        ((ArrayList) this.a.U).clear();
        List<UserChorusInfo> r0 = this.a.U;
        IRoomLinkMicSyncData r1 = (IRoomLinkMicSyncData) r13.b;
        boolean r2 = true;
        if (r1 == null) goto L21;
        ClientUIInfo r3 = r1.getClientUIInfo();
        if (r3 == null) goto L21;
        RealTimeChorusUIInfo r4 = r3.getRealTimeChorusInfo();
        if (r4 == null) goto L21;
        Map r5 = RealTimeChorusUIInfoKt.getUserInfoString(r4);
        if (r5 == null) goto L21;
        Collection r6 = r5.values();
        if (r6 == null) goto L21;
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r6.iterator();
    L14:
        if (r8.hasNext() == false) goto L22;
        T r9 = r8.next();
        if (((UserChorusInfo) r9).getOrder() <= 0) goto L18;
        boolean r10 = true;
    L19:
        if (r10 == false) goto L14;
        r7.add(r9);
        goto L14
    L18:
        r10 = false;
    L22:
        ((ArrayList) r0).addAll(r7);
        List r14 = ((IRoomLinkMicSyncData) r13.b).getMLinkUsers();
        if (r14 == null) goto L44;
        List r15 = r14;
        if ((r15 instanceof Collection) == true) goto L27;
    L29:
        Iterator<T> r16 = r15.iterator();
    L31:
        if (r16.hasNext() == false) goto L44;
        com.bytedance.android.livesdk.link.model.bridge.k1 r11 = ((com.bytedance.android.livesdk.link.model.bridge.k) r16.next()).getContent();
        if (r11 == null) goto L37;
        com.bytedance.android.livesdk.link.model.bridge.l1 r17 = r11.getLinkMicAudienceContent();
        if (r17 == null) goto L37;
        long r18 = r17.getChorusGuestStatus();
    L39:
        if (r18 <= 0) goto L41;
        boolean r19 = true;
    L42:
        if (r19 == false) goto L31;
    L45:
        ALogger.i("RealTimeChorusMainViewWidget", "talkRoomListUserInfoPb, hasChorusGuest: " + r2);
        RealTimeChorusMainViewWidget r110 = this.a;
        if (r2 == r110.v2) goto L62;
        ViewGroup r20 = ((Widget) r110).containerView;
        if (r20 == null) goto L50;
        r20.post(new q0(r110, r2));
    L50:
        this.a.v2 = r2;
        return;
    L62:
        return;
    L41:
        r19 = false;
    L37:
        r18 = 0;
        goto L39
    L27:
        if (r15.isEmpty() == false) goto L29;
    L44:
        r2 = false;
    L21:
        r7 = new ArrayList();
        goto L22
    }
}
