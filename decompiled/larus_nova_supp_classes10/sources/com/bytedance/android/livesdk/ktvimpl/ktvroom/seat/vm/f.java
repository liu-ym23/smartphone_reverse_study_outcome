package com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.vm;

import androidx.recyclerview.widget.DiffUtil;
import ch0.j;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.adapter.KtvRoomSeatListAdapter;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.diff.KtvRoomDiffCallback;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ KtvRoomViewManager a;

    public f(a r1) {
        this.a = r1;
    }

    public final void accept(Object r28) {
        Map r1 = (Map) r28;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r2 = this.a.k1.f;
        if (r2 == null) goto L7;
        BehaviorSubject r3 = r2.S0();
        if (r3 == null) goto L7;
        Map r4 = (Map) r3.getValue();
    L8:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r5 = this.a.k1.f;
        if (r5 == null) goto L13;
        BehaviorSubject r6 = r5.Q0();
        if (r6 == null) goto L13;
        Map r7 = (Map) r6.getValue();
    L14:
        KtvRoomViewManager r8 = this.a;
        qe2.c r9 = r8.k1;
        List<tf0.e> r10 = r8.M;
        r9.getClass();
        List r11 = qe2.c.d(r10);
        KtvRoomViewManager r12 = this.a;
        qe2.c r13 = r12.k1;
        List<tf0.e> r14 = r12.M;
        r13.getClass();
        List r15 = qe2.c.b(r14);
        ArrayList r16 = new ArrayList();
        ArrayList r17 = new ArrayList();
        Iterator<T> r18 = r11.iterator();
    L16:
        if (r18.hasNext() == false) goto L41;
        MultiLinkGuestViewBinder.a r19 = (tf0.e) r18.next();
        if ((r19 instanceof MultiLinkGuestViewBinder.a) == true) goto L20;
        MultiLinkGuestViewBinder.a r110 = null;
    L21:
        MultiLinkGuestViewBinder.a r111 = r110;
        if (r111 == null) goto L39;
        if (r4 == null) goto L25;
        Boolean r112 = (Boolean) r4.get(r111.k.a.getInteractId());
    L26:
        Boolean r113 = Boolean.TRUE;
        boolean r114 = Intrinsics.areEqual(r112, r113);
        if (r7 == null) goto L29;
        Boolean r115 = (Boolean) r7.get(r111.k.a.getInteractId());
    L30:
        boolean r20 = Intrinsics.areEqual(r115, r113);
        ch0.e r116 = r111.k;
        j r117 = r116.c;
        if (r117 == null) goto L33;
        j r24 = j.a(r117, r114, 0, 0, false, 29);
    L34:
        ch0.h r118 = r111.k.b;
        if (r118 == null) goto L37;
        ch0.h r23 = ch0.h.a(r118, null, false, false, r20, 0, z0.TYPE_APPLY_CLEAN);
    L38:
        ch0.e r119 = ch0.e.a(r116, null, r23, r24, null, 9);
        MultiLinkGuestViewBinder.a r120 = r111.a();
        Intrinsics.checkNotNullParameter(r119, "<set-?>");
        r120.k = r119;
        r119.d.put("EXT_KEY_KTV_UPDATE_TALK_STATUS", Boolean.valueOf(ch0.f.a(r119)));
        r16.add(r120);
        goto L39
    L37:
        r23 = null;
        goto L38
    L33:
        r24 = null;
        goto L34
    L29:
        r115 = null;
        goto L30
    L25:
        r112 = null;
    L39:
        if (r111 != null) goto L16;
        r16.add(r19);
        goto L16
    L20:
        r110 = r19;
        goto L21
    L41:
        Iterator<T> r21 = r15.iterator();
    L43:
        if (r21.hasNext() == false) goto L65;
        tf0.e r22 = (tf0.e) r21.next();
        if ((r22 instanceof MultiLinkGuestViewBinder.a) == true) goto L47;
        r22 = null;
    L47:
        MultiLinkGuestViewBinder.a r25 = (MultiLinkGuestViewBinder.a) r22;
        if (r25 == null) goto L43;
        if (r4 == null) goto L51;
        Boolean r26 = (Boolean) r4.get(r25.k.a.getInteractId());
    L52:
        Boolean r121 = Boolean.TRUE;
        boolean r122 = Intrinsics.areEqual(r26, r121);
        if (r7 == null) goto L55;
        Boolean r27 = (Boolean) r7.get(r25.k.a.getInteractId());
    L56:
        boolean r123 = Intrinsics.areEqual(r27, r121);
        ch0.e r29 = r25.k;
        j r124 = r29.c;
        if (r124 == null) goto L59;
        j r210 = j.a(r124, r122, 0, 0, false, 29);
    L60:
        ch0.h r125 = r25.k.b;
        if (r125 == null) goto L63;
        ch0.h r211 = ch0.h.a(r125, null, false, false, r123, 0, z0.TYPE_APPLY_CLEAN);
    L64:
        ch0.e r30 = ch0.e.a(r29, null, r211, r210, null, 9);
        MultiLinkGuestViewBinder.a r31 = r25.a();
        Intrinsics.checkNotNullParameter(r30, "<set-?>");
        r31.k = r30;
        r30.d.put("EXT_KEY_KTV_UPDATE_TALK_STATUS", Boolean.valueOf(ch0.f.a(r30)));
        r17.add(r31);
        goto L43
    L63:
        r211 = null;
        goto L64
    L59:
        r210 = null;
        goto L60
    L55:
        r27 = null;
        goto L56
    L51:
        r26 = null;
        goto L52
    L65:
        KtvRoomSeatManager r32 = this.a.F;
        if (r32 == null) goto L70;
        Intrinsics.checkNotNullParameter(r17, "hostList");
        KtvRoomSeatListAdapter r33 = r32.f;
        if (r33 == null) goto L70;
        Intrinsics.checkNotNullParameter(r17, "newList");
        DiffUtil.DiffResult r34 = DiffUtil.calculateDiff(new KtvRoomDiffCallback(r33.c, r17), true);
        r33.c = r17;
        r34.dispatchUpdatesTo(r33);
    L70:
        KtvRoomSeatManager r35 = this.a.F;
        if (r35 == null) goto L75;
        Intrinsics.checkNotNullParameter(r16, "normalGuestList");
        r35.l = r16;
        KtvRoomSeatListAdapter r36 = r35.e;
        if (r36 == null) goto L75;
        Intrinsics.checkNotNullParameter(r16, "newList");
        DiffUtil.DiffResult r37 = DiffUtil.calculateDiff(new KtvRoomDiffCallback(r36.c, r16), true);
        r36.c = r16;
        r37.dispatchUpdatesTo(r36);
    L75:
        Objects.toString(r4);
        Objects.toString(r7);
        Iterator r38 = r16.iterator();
    L77:
        if (r38.hasNext() == false) goto L84;
        tf0.e r39 = (tf0.e) r38.next();
        if ((r39 instanceof MultiLinkGuestViewBinder.a) == true) goto L81;
        r39 = null;
    L81:
        MultiLinkGuestViewBinder.a r40 = (MultiLinkGuestViewBinder.a) r39;
        if (r40 == null) goto L77;
        r40.k.a.getInteractId();
        ch0.e r41 = r40.k;
        j r42 = r41.c;
        ch0.f.a(r41);
        goto L77
    L84:
        return;
    L13:
        r7 = null;
    L7:
        r4 = null;
        goto L8
    }
}
