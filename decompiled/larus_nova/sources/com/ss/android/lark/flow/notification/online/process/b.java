package com.ss.android.lark.flow.notification.online.process;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.AbstractNotification;
import com.ss.android.lark.notification.export.entity.Notice;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final btb.c f423756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final btb.e f423757b;

    public b() {
        btb.c r100 = new btb.c();
        this.f423756a = r100;
        this.f423757b = new btb.e(r100);
    }

    public static void a(b r100, Notice r110) {
        r100.getClass();
        if (r110 != null) goto L5;
        thb.a.a("FlowNotificationDispatcher", "notice is empty!");
        return;
    L5:
        ArrayList r101 = new ArrayList();
        int r102 = r110.type;
        if (r102 != 20001) goto L8;
        r101.add(20001);
    L49:
        Iterator r103 = r101.iterator();
    L51:
        if (r103.hasNext() == false) goto L93;
        Integer r104 = (Integer) r103.next();
        btb.e r105 = r100.f423757b;
        int r106 = r104.intValue();
        if (((ConcurrentHashMap) r105.f20711a).containsKey(Integer.valueOf(r106)) == true) goto L55;
        Log.e("NotificationFactory", "no push type found! for type " + r106);
        AbstractNotification r107 = null;
    L56:
        if (r107 == null) goto L57;
        btb.c r108 = r100.f423756a;
        AbstractNotification.b r109 = r107.a();
        AbstractNotification.AbstractNotificationDisplayer r111 = r107.c();
        AbstractNotification.a r112 = r107.b();
        if (r109 != null) goto L61;
        Notice r113 = r110;
    L62:
        boolean r114 = false;
        if (r113 == null) goto L84;
        if (r109 != null) goto L67;
        int r115 = 0;
    L68:
        if (r115 == 0) goto L70;
        if (r115 != 1) goto L84;
        if (r112 == null) goto L84;
        r112.a(r113);
        goto L84
    L70:
        if (r111.c(r113) == false) goto L84;
        atb.a r116 = r111.b(r113);
        if (r116 == null) goto L84;
        AbstractNotification.AbstractNotificationDisplayer.a r117 = (AbstractNotification.AbstractNotificationDisplayer.a) ((ConcurrentHashMap) r108.f20709a).get(r116.getClass());
        if (r117 != null) goto L77;
        Log.e("no notification display is suit!");
    L77:
        if (r117 == null) goto L79;
        r117.a(r116);
    L79:
        r114 = true;
        goto L84
    L67:
        r115 = r109.b(r113);
    L84:
        if (r114 == false) goto L51;
        return;
    L61:
        r113 = r109.a(r110);
        goto L62
    L57:
        thb.a.a("FlowNotificationDispatcher", "notification for " + r104 + " is not registered!");
        goto L51
    L55:
        r107 = (AbstractNotification) ((ConcurrentHashMap) r105.f20711a).get(Integer.valueOf(r106));
        goto L56
    L93:
        return;
    L8:
        if (r102 != 20002) goto L10;
        r101.add(20002);
        goto L49
    L10:
        switch(r102) {
            case 1: goto L24;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L18;
            case 9: goto L17;
            case 10: goto L16;
            case 11: goto L16;
            case 12: goto L15;
            case 13: goto L14;
            case 14: goto L13;
            default: goto L11;
        };
    L11:
        switch(r102) {
            case 10001: goto L46;
            case 10002: goto L45;
            case 10003: goto L44;
            case 10004: goto L43;
            case 10005: goto L42;
            case 10006: goto L41;
            default: goto L49;
        };
    L41:
        r101.add(10010);
        goto L49
    L42:
        r101.add(10006);
        goto L49
    L43:
        r101.add(10005);
        goto L49
    L44:
        r101.add(10004);
        goto L49
    L45:
        r101.add(10003);
        goto L49
    L46:
        r101.add(10001);
        goto L49
    L13:
        r101.add(14);
        goto L49
    L14:
        r101.add(13);
        goto L49
    L15:
        r101.add(12);
        goto L49
    L16:
        r101.add(10);
        goto L49
    L17:
        r101.add(9);
        goto L49
    L18:
        r101.add(8);
        goto L49
    L19:
        r101.add(7);
        goto L49
    L20:
        r101.add(6);
        goto L49
    L21:
        r101.add(5);
        goto L49
    L22:
        r101.add(4);
        goto L49
    L23:
        r101.add(3);
        goto L49
    L24:
        int r118 = r110.state;
        if (r118 == 3) goto L40;
        if (r118 == 2) goto L40;
        if (r118 != 4) goto L30;
        r101.add(10002);
        goto L49
    L30:
        r101 = new ArrayList();
        Notice.Extra r119 = r110.extra;
        if (r119 == null) goto L49;
        int r120 = r119.f433065i;
        if (r120 == 0) goto L49;
        if (r110.type != 1) goto L39;
        if (r120 != 3) goto L39;
        r101.add(10000);
    L39:
        r101.add(2);
    L40:
        r101.add(2);
        r101.add(4);
        r101.add(5);
        goto L49
    }

    public final <T extends Notice, R extends atb.a> void b(int r100, final AbstractNotification<T, R> r101) {
        btb.e r102 = this.f423757b;
        if (((ConcurrentHashMap) r102.f20711a).containsKey(Integer.valueOf(r100)) == true) goto L19;
        ((ConcurrentHashMap) r102.f20711a).put(Integer.valueOf(r100), r101);
        btb.b r103 = new btb.b(LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new btb.d(r101)));
        Class r104 = (Class) ((ParameterizedType) r101.getClass().getGenericSuperclass()).getActualTypeArguments()[1];     // Catch: Exception -> L8
    L10:
        if (r104 == null) goto L18;
        btb.c r105 = r102.f20712b;
        if (((ConcurrentHashMap) r105.f20709a).containsKey(r104) == true) goto L20;
        ((ConcurrentHashMap) r105.f20709a).put(r104, r103);
        return;
    L20:
        return;
    L18:
        return;
    L8:
        e = move-exception;
        Log.e("NotificationFactory", "notification register failed Reason: " + e.getMessage());
        r104 = null;
        goto L10
    }
}
