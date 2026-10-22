package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.animation.universalwidget.utils.ListDiffUtils;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d0<T> implements Consumer {
    public final /* synthetic */ RealTimeChorusMainViewWidget a;

    public d0(RealTimeChorusMainViewWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r13) {
        RealTimeChorusMainViewWidget r0 = this.a;
        int r1 = RealTimeChorusMainViewWidget.Q2;
        r0.getClass();
        ArrayList r2 = new ArrayList();
        List r14 = (List) r13;
        Iterator<T> r3 = r14.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        ch0.e r4 = (ch0.e) r3.next();
        if (r4.a.getChorusGuestStatus() <= 0) goto L4;
        r2.add(r4);
        goto L4
    L8:
        ArrayList r5 = new ArrayList();
        Iterator r6 = r2.iterator();
    L9:
        Object r7 = null;
        boolean r8 = true;
        if (r6.hasNext() == false) goto L48;
        ch0.e r9 = (ch0.e) r6.next();
        Iterator r10 = ((ArrayList) r0.V1).iterator();
    L13:
        if (r10.hasNext() == false) goto L39;
        Object r11 = r10.next();
        ch0.e r12 = (ch0.e) r11;
        IBaseUser r15 = r12.a.getUser();
        if (r15 == null) goto L17;
        String r16 = r15.getIdString();
    L18:
        if (r16 != null) goto L20;
    L23:
        boolean r17 = true;
    L24:
        if (r17 == true) goto L36;
        IBaseUser r18 = r12.a.getUser();
        if (r18 == null) goto L28;
        String r19 = r18.getIdString();
    L29:
        IBaseUser r110 = r9.a.getUser();
        if (r110 == null) goto L32;
        String r111 = r110.getIdString();
    L34:
        if (Intrinsics.areEqual(r19, r111) == false) goto L36;
        boolean r112 = true;
    L37:
        if (r112 == false) goto L13;
        r7 = r11;
        goto L39
    L32:
        r111 = null;
        goto L34
    L28:
        r19 = null;
    L36:
        r112 = false;
        goto L37
    L20:
        if (r16.length() == 0) goto L23;
        r17 = false;
        goto L24
    L17:
        r16 = null;
    L39:
        ch0.e r20 = (ch0.e) r7;
        if (r20 == null) goto L9;
        if (ch0.f.a(r9) == ch0.f.a(r20)) goto L45;
        r8 = false;
    L45:
        if (r8 == true) goto L9;
        r5.add(r9);
        goto L9
    L48:
        if ((!r5.isEmpty()) == false) goto L63;
        int r21 = com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a;
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(r0.M2) == true) goto L63;
        JSONArray r22 = new JSONArray();
        Iterator r23 = r5.iterator();
    L54:
        if (r23.hasNext() == false) goto L59;
        ch0.e r24 = (ch0.e) r23.next();
        boolean r25 = ch0.f.a(r24);
        IBaseUser r26 = r24.a.getUser();
        if (r26 == null) goto L54;
        JSONObject r27 = new JSONObject();
        r27.put("isTalking", r25);
        r27.put("userId", r26.getIdString());
        r22.put(r27);
        goto L54
    L59:
        if (r22.length() <= 0) goto L63;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r28 = r0.Q;
        if (r28 == null) goto L63;
        r28.f(r22.toString());
    L63:
        r0.V1 = r2;
        RealTimeChorusMainViewWidget r29 = this.a;
        r29.getClass();
        if (hg6.i.a() == false) goto L102;
        ArrayList r30 = new ArrayList();
        Iterator<T> r113 = r14.iterator();
    L67:
        if (r113.hasNext() == false) goto L72;
        ch0.e r31 = (ch0.e) r113.next();
        if (r31.a.getUser() == null) goto L67;
        r30.add(new MultiLinkGuestViewBinder.a(r31, null, 62));
        goto L67
    L72:
        if (ListDiffUtils.c(r29.g2, r30) == true) goto L103;
        r29.g2 = r30;
        ArrayList r32 = new ArrayList();
        r32.addAll(r30);
        ((Widget) r29).dataCenter.put("data_multi_link_dynamic_guest_list_change", new nh0.f("guest_list", null, r32, null, null, null, false, 246));
        return;
    L103:
        return;
    }
}
