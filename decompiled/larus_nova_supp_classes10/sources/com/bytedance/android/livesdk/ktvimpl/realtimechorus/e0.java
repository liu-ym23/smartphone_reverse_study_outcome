package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.live.base.model.user.IBaseUser;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e0<T> implements Consumer {
    public final /* synthetic */ RealTimeChorusMainViewWidget a;

    public e0(RealTimeChorusMainViewWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r10) {
        Map<String, Boolean> r11 = (Map) r10;
        RealTimeChorusMainViewWidget r0 = this.a;
        int r1 = RealTimeChorusMainViewWidget.Q2;
        r0.getClass();
        ArrayList r2 = new ArrayList();
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r3 = r0.N2;
        if (r3 == null) goto L14;
        BehaviorSubject r4 = r3.f();
        if (r4 == null) goto L14;
        List r5 = (List) r4.getValue();
        if (r5 == null) goto L14;
        Iterator<T> r6 = r5.iterator();
    L10:
        if (r6.hasNext() == false) goto L14;
        ch0.e r7 = (ch0.e) r6.next();
        if (r7.a.getChorusGuestStatus() <= 0) goto L10;
        r2.add(r7);
    L14:
        LinkedHashMap r8 = new LinkedHashMap();
        Iterator r9 = r2.iterator();
    L16:
        if (r9.hasNext() == false) goto L32;
        ch0.e r12 = (ch0.e) r9.next();
        Map<String, Boolean> r13 = r0.b2;
        IBaseUser r14 = r12.a.getUser();
        String r15 = "";
        if (r14 == null) goto L21;
        String r16 = r14.getIdString();
        if (r16 == null) goto L21;
    L22:
        Boolean r17 = r13.get(r16);
        boolean r18 = Intrinsics.areEqual(r11.get(r12.a.getInteractId()), Boolean.TRUE);
        if ((!Intrinsics.areEqual(r17, Boolean.valueOf(r18))) == false) goto L16;
        IBaseUser r19 = r12.a.getUser();
        if (r19 == null) goto L30;
        String r20 = r19.getIdString();
        if (r20 == null) goto L30;
        r15 = r20;
    L30:
        r8.put(r15, Boolean.valueOf(r18));
    L21:
        r16 = "";
        goto L22
    L32:
        if ((!r8.isEmpty()) == false) goto L42;
        JSONArray r21 = new JSONArray();
        Iterator r22 = r8.entrySet().iterator();
    L35:
        if (r22.hasNext() == false) goto L38;
        Map.Entry r23 = (Map.Entry) r22.next();
        String r24 = (String) r23.getKey();
        boolean r25 = ((Boolean) r23.getValue()).booleanValue();
        JSONObject r26 = new JSONObject();
        r26.put("isTalking", r25);
        r26.put("userId", r24);
        r21.put(r26);
        goto L35
    L38:
        if (r21.length() <= 0) goto L42;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r27 = r0.Q;
        if (r27 == null) goto L42;
        r27.f(r21.toString());
    L42:
        r0.b2 = r11;
    }
}
