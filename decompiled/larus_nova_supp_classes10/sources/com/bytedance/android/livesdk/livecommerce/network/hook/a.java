package com.bytedance.android.livesdk.livecommerce.network.hook;

import com.bytedance.android.ec.core.utils.i;
import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.utils.LiveRoomRedirectInfo;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import si2.g;
import si2.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r10, FilterNullArrayList r11) {
        Intrinsics.checkNotNullParameter(r10, "url");
        if (EComABUtils.enableLiveUrlRedirect().booleanValue() == true) goto L5;
        return r10;
    L5:
        String r0 = g.a;
        boolean r1 = true;
        if (r0 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == true) goto L105;
        String r4 = null;
        if (StringsKt.startsWith$default(r10, r0, false, 2, null) == false) goto L106;
        String r5 = r10.substring(r0.length());
        List<String> r6 = EComABUtils.getNetworkAPIEnableRedirectList();
        List<String> r7 = r6;
        if (r7 != null) goto L18;
    L21:
        boolean r8 = true;
    L22:
        if (r8 == false) goto L24;
    L30:
        if (r11 == null) goto L41;
        Iterator<E> r9 = r11.iterator();
    L33:
        if (r9.hasNext() == false) goto L37;
        Object r12 = r9.next();
        if (Intrinsics.areEqual(((i) ((k) r12)).a, "room_id") == false) goto L33;
    L38:
        k r13 = (k) r12;
        if (r13 == null) goto L41;
        String r14 = ((i) r13).b;
    L42:
        if (r11 == null) goto L53;
        Iterator<E> r15 = r11.iterator();
    L45:
        if (r15.hasNext() == false) goto L49;
        Object r16 = r15.next();
        if (Intrinsics.areEqual(((i) ((k) r16)).a, "room_unique_key") == false) goto L45;
    L50:
        k r17 = (k) r16;
        if (r17 == null) goto L53;
        String r18 = ((i) r17).b;
    L54:
        if (r11 == null) goto L65;
        Iterator<E> r19 = r11.iterator();
    L57:
        if (r19.hasNext() == false) goto L61;
        Object r20 = r19.next();
        if (Intrinsics.areEqual(((i) ((k) r20)).a, "container_room_id") == false) goto L57;
    L62:
        k r21 = (k) r20;
        if (r21 == null) goto L65;
        r4 = ((i) r21).b;
        goto L65
    L61:
        r20 = null;
    L65:
        if (r14 != null) goto L67;
    L70:
        boolean r110 = true;
    L71:
        if (r110 == true) goto L82;
        if (r4 != null) goto L74;
    L77:
        boolean r111 = true;
    L78:
        if (r111 == true) goto L82;
        if ((!Intrinsics.areEqual(r14, r4)) == false) goto L82;
        return r10;
    L74:
        if (r4.length() == 0) goto L77;
        r111 = false;
    L82:
        int r112 = RoomContextController.h;
        LiveRoomRedirectInfo r113 = RoomContextController.a.b(r14, r18).g;
        if (r113 == null) goto L107;
        Map<String, String> r114 = r113.b;
        if (r114 == null) goto L109;
        String r115 = r114.get(r5);
        if (r115 != null) goto L90;
    L93:
        if (r1 == false) goto L95;
        return r10;
    L95:
        return r0 + r115;
    L90:
        if (r115.length() == 0) goto L93;
        r1 = false;
        goto L93
    L109:
        return r10;
    L107:
        return r10;
    L67:
        if (r14.length() == 0) goto L70;
        r110 = false;
        goto L71
    L49:
        r16 = null;
    L53:
        r18 = null;
        goto L54
    L37:
        r12 = null;
    L41:
        r14 = null;
        goto L42
    L24:
        if (StringsKt.endsWith$default(r5, "/", false, 2, null) == false) goto L26;
        String r22 = r5;
    L28:
        if (r6.contains(r22) == true) goto L30;
        return r10;
    L26:
        r22 = r5 + '/';
        goto L28
    L18:
        if (r7.isEmpty() == true) goto L21;
        r8 = false;
        goto L22
    L106:
        return r10;
    L105:
        return r10;
    L8:
        if (r0.length() == 0) goto L11;
        r3 = false;
        goto L12
    }
}
